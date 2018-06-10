package com.github.binarywang.wxpay.bean.result;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import me.chanjar.weixin.common.util.ToStringUtils;

/**
 * @Author: ZYW
 * @Description: 微信免密支付回调结果
 * @Date: 2018/5/18 0018 17:10
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@XStreamAlias("xml")
public class PayCallBackResult extends BaseWxPayResult {


    /**
     * 微信支付分配的终端设备号，
     */
    @XStreamAlias("device_info")
    private String deviceInfo;
    /**
     * 用户在商户appid下的唯一标识
     */
    @XStreamAlias("openid")
    private String openid;

    /**
     * sub_appid下，用户的唯一标识
     */
    @XStreamAlias("sub_openid")
    private String subOpenid;

    /**
     * 付款银行
     */
    @XStreamAlias("bank_type")
    private String bankType;

    /**
     * 总金额
     */
    @XStreamAlias("total_fee")
    private String totalFee;

    /**
     * 货币种类
     */
    @XStreamAlias("fee_type")
    private String feeType;

    /**
     * 现金支付金额
     */
    @XStreamAlias("cash_fee")
    private String cashFee;
    /**
     * 货币类型 CNY人民币
     */
    @XStreamAlias("cash_fee_type")
    private String cashFeeType;

    /**
     * 交易状态
     * SUCCESS—支付成功
     * REFUND—转入退款
     * NOTPAY—未支付
     * CLOSED—已关闭
     * ACCEPT—已接收，等待扣款
     * PAY_FAIL--支付失败(其他原因，如银行返回失败)
     */
    @XStreamAlias("trade_state")
    private String tradeState;

    /**
     * 微信支付订单号
     */
    @XStreamAlias("transaction_id")
    private String transactionId;

    /**
     * 支付完成时间
     */
    @XStreamAlias("time_end")
    private String timeEnd;

    /**
     * 商户订单号
     */
    @XStreamAlias("out_trade_no")
    private String outTradeNo;

    /**
     * 商家数据包，原样返回
     */
    @XStreamAlias("attach")
    private String attach;

    /**
     * 委托代扣协议id
     */
    @XStreamAlias("contract_id")
    private String contractId;

    /*public static PayCallBackResult fromXML(String xmlString) {
        XStream xstream = XStreamInitializer.getInstance();
        xstream.processAnnotations(PayCallBackResult.class);
        xstream.registerConverter(new WxPayOrderNotifyResultConverter(xstream.getMapper(), xstream.getReflectionProvider()));
        PayCallBackResult result = (PayCallBackResult) xstream.fromXML(xmlString);
        result.setXmlString(xmlString);
        return result;
    }*/

    @Override
    public String toString() {
        return ToStringUtils.toSimpleString(this);
    }
}
