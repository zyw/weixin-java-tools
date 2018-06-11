package com.github.binarywang.wxpay.bean.request;

import com.github.binarywang.wxpay.config.WxPayConfig;
import com.github.binarywang.wxpay.exception.WxPayException;
import com.github.binarywang.wxpay.util.SignUtils;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.*;
import org.apache.commons.lang3.StringUtils;

/**
 * @author ZYW
 * @date 2018/6/11
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
@AllArgsConstructor
@XStreamAlias("xml")
public class ContractRequest extends BaseWxPayRequest {

    @XStreamAlias("plan_id")
    private String planId;

    @XStreamAlias("contract_code")
    private String contractCode;

    @XStreamAlias("request_serial")
    private String requestSerial;

    @XStreamAlias("contract_display_account")
    private String contractDisplayAccount;

    @XStreamAlias("notify_url")
    private String notifyUrl;

    @XStreamAlias("timestamp")
    private String timestamp;

    @XStreamAlias("version")
    private String version;

    @Override
    protected void checkConstraints() throws WxPayException {
        if(StringUtils.isEmpty(this.timestamp)) {
            this.setTimestamp(String.valueOf(System.currentTimeMillis()));
        }
    }
    @Override
    public void checkAndSign(WxPayConfig config) throws WxPayException {
        super.checkAndSign(config);
        //调用免密支付签名不需要随机数
        this.setNonceStr(null);
        //设置签名字段的值
        this.setSign(SignUtils.createSign(this, this.getSignType(), config.getMchKey(),
                this.ignoreSignType()));
    }
}
