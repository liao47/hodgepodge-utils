import com.github.liao47.common.constants.PatternConstants;
import com.github.liao47.union.UnionPayService;
import com.github.liao47.union.config.AppConfig;
import com.github.liao47.union.config.UnionConfig;
import com.github.liao47.union.config.UnionProp;
import com.github.liao47.union.model.req.PayReq;
import com.github.liao47.union.model.req.QueryReq;
import com.github.liao47.union.model.req.RefundReq;
import com.github.liao47.union.model.resp.BaseResp;
import com.github.liao47.union.model.resp.QueryResp;
import com.github.liao47.union.model.resp.RefundResp;
import com.github.liao47.utils.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * @author liao47
 * @date 2021/2/24 9:21
 */
@ContextConfiguration(classes = AppConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
@Slf4j
public class UnionPayServiceTest {
    @Resource
    private UnionPayService unionPayService;

    @Resource
    private UnionConfig unionConfig;

    @Test
    public void payTest() {
        PayReq payReq = new PayReq();
        UnionProp unionProp = getProp();
        payReq.setMerId(unionProp.getMerId());
        payReq.setOrderId("TEST" + System.currentTimeMillis());
        payReq.setOrderDesc("测试订单");
        payReq.setTxnAmt("1");
        //交易时间取订单创建时间
        payReq.setTxnTime(DateUtils.format(LocalDateTime.now(), PatternConstants.SIMPLE_DATE_TIME));
        payReq.setPayTimeout(DateUtils.format(LocalDateTime.now().plusMinutes(unionConfig.getExpireMinutes()),
                PatternConstants.SIMPLE_DATE_TIME));
        //页面通知地址
        payReq.setFrontUrl(unionConfig.getFrontUrl());
        payReq.setBackUrl(unionConfig.getNotifyUrl());
        if (!StringUtils.startsWith(payReq.getFrontUrl(), "http")) {
            //地址不是http开头默认加上https
            payReq.setFrontUrl("https://" + payReq.getFrontUrl());
        }
        BaseResp resp = unionPayService.execute(payReq, unionProp);
        Assert.assertNotNull(resp);
        log.info("Response:{}", resp);
    }

    @Test
    public void queryTest() {
        UnionProp unionProp = getProp();
        QueryReq queryReq = new QueryReq();
        queryReq.setMerId(unionProp.getMerId());
        queryReq.setOrderId("TEST1614307659551");
        queryReq.setTxnTime(DateUtils.format(LocalDateTime.now(), PatternConstants.SIMPLE_DATE_TIME));
        QueryResp queryResp = (QueryResp) unionPayService.execute(queryReq, unionProp);
        log.info("Response:{}", queryResp);
        Assert.assertTrue(StringUtils.isNotEmpty(queryResp.getQueryId()));
    }

    @Test
    public void refundTest() {
        UnionProp unionProp = getProp();
        RefundReq refundReq = new RefundReq();
        refundReq.setMerId(unionProp.getMerId());
        refundReq.setOrderId("REFUND" + System.currentTimeMillis());
        refundReq.setOrigQryId("632102261047392294008");
        refundReq.setTxnAmt("1");
        refundReq.setTxnTime(DateUtils.format(LocalDateTime.now(), PatternConstants.SIMPLE_DATE_TIME));
        refundReq.setBackUrl(unionConfig.getRefundNotifyUrl());

        RefundResp refundResp = (RefundResp) unionPayService.execute(refundReq, unionProp);
        log.info("Response:{}", refundResp);
        Assert.assertEquals("00", refundResp.getRespCode());
    }

    private UnionProp getProp() {
        UnionProp unionProp = new UnionProp();
        unionProp.setMerId("777290058183840");
        unionProp.setSignCertPwd("000000");
        unionProp.setSignCertPath("acp_test_sign.pfx");
        return unionProp;
    }
}
