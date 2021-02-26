package com.github.liao47.union;

import com.alibaba.fastjson.JSON;
import com.github.liao47.common.constants.PatternConstants;
import com.github.liao47.common.exception.CustomException;
import com.github.liao47.union.config.UnionConfig;
import com.github.liao47.union.config.UnionProp;
import com.github.liao47.union.model.PayNotifyDTO;
import com.github.liao47.union.model.RefundNotifyDTO;
import com.github.liao47.union.model.req.PayReq;
import com.github.liao47.union.model.req.QueryReq;
import com.github.liao47.union.model.req.RefundReq;
import com.github.liao47.union.model.resp.PayResp;
import com.github.liao47.union.model.resp.QueryResp;
import com.github.liao47.union.model.resp.RefundResp;
import com.github.liao47.union.utils.AcpUtils;
import com.github.liao47.utils.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * 银联支付服务
 * @author liao47
 * @date 2021/2/26 15:29
 */
@Slf4j
@Component
public class UnionPayService {

    @Resource
    private UnionPayRemoteService unionPayRemoteService;

    @Resource
    private UnionConfig unionConfig;

    /**
     * 支付
     * @param payReq
     * @param unionProp
     * @return
     */
    public PayResp pay(PayReq payReq, UnionProp unionProp) {
        payReq.setMerId(unionProp.getMerId());
        //交易时间取订单创建时间
        if (StringUtils.isEmpty(payReq.getTxnTime())) {
            payReq.setTxnTime(DateUtils.format(LocalDateTime.now(), PatternConstants.SIMPLE_DATE_TIME));
        }
        if (StringUtils.isEmpty(payReq.getPayTimeout())) {
            payReq.setPayTimeout(DateUtils.format(LocalDateTime.now().plusMinutes(unionConfig.getExpireMinutes()),
                    PatternConstants.SIMPLE_DATE_TIME));
        }
        //页面通知地址
        payReq.setFrontUrl(StringUtils.defaultIfEmpty(payReq.getFrontUrl(), unionConfig.getFrontUrl()));
        payReq.setBackUrl(StringUtils.defaultIfEmpty(payReq.getBackUrl(), unionConfig.getNotifyUrl()));
        if (!StringUtils.startsWith(payReq.getFrontUrl(), "http")) {
            //地址不是http开头默认加上https
            payReq.setFrontUrl("https://" + payReq.getFrontUrl());
        }
        return (PayResp) unionPayRemoteService.execute(payReq, unionProp);
    }

    /**
     * 查询
     * @param queryReq
     * @param unionProp
     * @return
     */
    public QueryResp query(QueryReq queryReq, UnionProp unionProp) {
        queryReq.setMerId(unionProp.getMerId());
        if (StringUtils.isEmpty(queryReq.getTxnTime())) {
            queryReq.setTxnTime(DateUtils.format(LocalDateTime.now(), PatternConstants.SIMPLE_DATE_TIME));
        }
        return (QueryResp) unionPayRemoteService.execute(queryReq, unionProp);
    }

    /**
     * 退款
     * @param refundReq
     * @param unionProp
     * @return
     */
    public RefundResp refund(RefundReq refundReq, UnionProp unionProp) {
        refundReq.setMerId(unionProp.getMerId());
        if (StringUtils.isEmpty(refundReq.getTxnTime())) {
            refundReq.setTxnTime(DateUtils.format(LocalDateTime.now(), PatternConstants.SIMPLE_DATE_TIME));
        }
        refundReq.setBackUrl(StringUtils.defaultIfEmpty(refundReq.getBackUrl(), unionConfig.getRefundNotifyUrl()));

        return (RefundResp) unionPayRemoteService.execute(refundReq, unionProp);
    }

    /**
     * 获取消费回调通知参数
     * @return
     */
    public PayNotifyDTO payNotify() {
        Map<String, String> paramMap = this.getParamMap();
        if (!AcpUtils.validate(paramMap)) {
            throw new CustomException("银联消费回调参数验签失败");
        }
        return JSON.parseObject(JSON.toJSONString(paramMap), PayNotifyDTO.class);
    }

    /**
     * 获取退款回调通知参数
     * @return
     */
    public RefundNotifyDTO refundNotify() {
        Map<String, String> paramMap = this.getParamMap();
        if (!AcpUtils.validate(paramMap)) {
            throw new CustomException("银联退款回调参数验签失败");
        }
        return JSON.parseObject(JSON.toJSONString(paramMap), RefundNotifyDTO.class);
    }

    /**
     * 获取回调参数
     * @return
     */
    private Map<String, String> getParamMap() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attributes == null) {
            throw new CustomException("获取HttpServletRequest失败");
        }

        Map<String, String[]> paramMap = attributes.getRequest().getParameterMap();
        Map<String, String> map = new HashMap<>(paramMap.size());
        for (Map.Entry<String, String[]> entry : paramMap.entrySet()) {
            if (entry.getValue().length == 1) {
                map.put(entry.getKey(), entry.getValue()[0]);
            }
        }
        return map;
    }
}
