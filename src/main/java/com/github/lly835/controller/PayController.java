package com.github.lly835.controller;

import com.lly835.bestpay.enums.BestPayTypeEnum;
import com.lly835.bestpay.model.PayRequest;
import com.lly835.bestpay.model.PayResponse;
import com.lly835.bestpay.service.BestPayService;
import com.lly835.bestpay.service.impl.BestPayServiceImpl;
import com.lly835.bestpay.utils.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Random;

/**
 * 支付相关
 * @version 1.0 2017/3/2
 * @auther <a href="mailto:lly835@163.com">廖师兄</a>
 * @since 1.0
 */
@RestController
@Slf4j
@Lazy
public class PayController {

    private BestPayService bestPayService = new BestPayServiceImpl();

    /**
     * 发起支付
     */
    @GetMapping(value = "/pay")
    public void pay() throws Exception{
        PayRequest request = new PayRequest();
        Random random = new Random();

        //支付方式
        request.setPayTypeEnum(BestPayTypeEnum.ALIPAY_WAP);
        request.setOrderId(String.valueOf(random.nextInt(1000000000)));
        request.setOrderAmount(0.01);
        request.setOrderName("最好的支付sdk");
        request.setReturnUrl("http://127.0.0.1:8080/syncNotify");
        //这里要填外网ip或者域名, 如果是需要映射到自己的电脑, 推荐natapp.cn
        request.setNotifyUrl("http://xxx.natapp.cc/asyncNotify");
        log.info("【发起支付】request={}", JsonUtil.toJson(request));

        //发起支付请求
        PayResponse response = bestPayService.pay(request);
        log.info("【发起支付】response={}", JsonUtil.toJson(response));
        log.info("【发起支付】response={}", response);
    }

    /**
     * 同步回调
     */
    @GetMapping(value = "/syncNotify")
    public void syncNotify(HttpServletRequest request) throws Exception {
        PayResponse response = bestPayService.syncNotify(request);
        log.info("【同步回调】response={}", JsonUtil.toJson(response));
    }

    /**
     * 异步回调
     */
    @PostMapping(value = "/asyncNotify")
    public void asyncNotify(HttpServletRequest request) throws Exception {
        PayResponse response = bestPayService.asyncNotify(request);
        log.info("【异步回调】response={}", JsonUtil.toJson(response));
    }


}
