package com.github.lly835.config;

import com.lly835.bestpay.config.AlipayConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @version 1.0 2017/3/2
 * @auther <a href="mailto:lly835@163.com">廖师兄</a>
 * @since 1.0
 */
@Configuration
public class PayConfig {

    @Bean
    public AlipayConfig alipayConfig() {
        AlipayConfig alipayConfig = new AlipayConfig();

        /**
         * 合作伙伴id, 支付宝支付必须配置项.
         * https://openhome.alipay.com/platform/keyManage.htm?keyType=partner
         * */
        AlipayConfig.setPartnerId("2088XXXXXXXXXXX");

        /**
         * 开放平台密钥, 支付宝app和wap支付才需要下面的配置.
         * https://openhome.alipay.com/platform/keyManage.htm
         * */
        alipayConfig.setAppId("2017XXXXXXXXXXX");
        alipayConfig.setAppPrivateKey("");
        alipayConfig.setAppPublicKey("");

        /**
         * 合作伙伴密钥, 支付宝PC(即时到账)支付才需要下面的配置.
         * https://openhome.alipay.com/platform/keyManage.htm?keyType=partner
         * */
        alipayConfig.setPartnerPrivateKey("");
        alipayConfig.setPartnerPublicKey("");

        return alipayConfig;
    }
}
