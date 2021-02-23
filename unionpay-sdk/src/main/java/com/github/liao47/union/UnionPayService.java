package com.github.liao47.union;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.github.liao47.common.constants.UnionUriConstants;
import com.github.liao47.common.exception.CustomException;
import com.github.liao47.union.config.UnionConfig;
import com.github.liao47.union.config.UnionProp;
import com.github.liao47.union.model.req.BaseReq;
import com.github.liao47.union.model.resp.BaseResp;
import com.github.liao47.union.model.resp.PayResp;
import com.github.liao47.union.utils.AcpUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 银联支付服务
 * @author liao47
 * @date 2021/2/23 14:05
 */
@Slf4j
@Component
public class UnionPayService {
    @Resource
    private UnionConfig unionConfig;

    @Resource
    private RestTemplate restTemplateSsl;

    /**
     * 执行调用
     * @param baseReq
     * @param unionProp
     * @return
     */
    public BaseResp execute(BaseReq baseReq, UnionProp unionProp) {
        // 组装请求参数
        Map<String, String> map = JSON.parseObject(JSON.toJSONString(baseReq),
                new TypeReference<Map<String, String>>() {});

        //报文中certId,signature的值是在signData方法中获取并自动赋值的，只要证书配置正确即可。
        Map<String, String> paramData = AcpUtils.sign(map, unionProp);

        String url = unionConfig.getUrl() + baseReq.getReqUrl();
        if (UnionUriConstants.DOWNLOAD.equals(baseReq.getReqUrl())) {
            url = unionConfig.getDownloadUrl();
        }
        log.info("银联在线网关请求，请求地址:{},请求参数:{}", url, paramData);

        // 下单接口跟其他的不一样
        if (UnionUriConstants.PAY.equals(baseReq.getReqUrl())) {
            // 请求参数设置完毕，以下对请求参数进行签名并生成html表单，将表单写入浏览器跳转打开银联页面
            // 返回from表单给前端渲染页面即可，不用html
            String html = AcpUtils.createAutoForm(url, paramData);
            return new PayResp(html);
        }

        MultiValueMap<String, Object> postParameters = new LinkedMultiValueMap<>();
        for (Map.Entry<String, String> entry : paramData.entrySet()) {
            postParameters.add(entry.getKey(), entry.getValue());
        }
        HttpHeaders headers = new HttpHeaders();
        headers.add("ContentReq-Type", "application/x-www-form-urlencoded");
        HttpEntity<MultiValueMap<String, Object>> req = new HttpEntity<>(postParameters, headers);
        String rspStr = restTemplateSsl.postForObject(url, req, String.class);
        log.info("银联请求:{}，响应:{}", url, rspStr);
        Map<String, String> respData = AcpUtils.convertResultStringToMap(rspStr);
        if (!AcpUtils.validate(respData)) {
            throw new CustomException("银联支付响应结果验签失败");
        }
        // 响应报文转换
        return JSON.parseObject(JSON.toJSONString(respData), baseReq.getRespType());
    }
}
