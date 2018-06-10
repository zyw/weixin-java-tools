package com.github.binarywang.wxpay.bean.request;

import com.github.binarywang.wxpay.exception.WxPayException;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.*;


@EqualsAndHashCode(callSuper = true)
@Data
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
@AllArgsConstructor
@XStreamAlias("xml")
public class PapOrderQueryRequest extends BaseWxPayRequest {
    /**
     * <pre>
     * 字段名：公众账号ID
     * 变量名：appid
     * 是否必填：是
     * 类型：String(32)
     * 示例值：wxd678efh567hg6787
     * 描述：微信分配的公众账号ID（企业号corpid即为此appId）
     * </pre>
     */
    @XStreamAlias("appid")
    private String appid;
    /**
     * <pre>
     * 字段名：商户号
     * 变量名：mch_id
     * 是否必填：是
     * 类型：String(32)
     * 示例值：1230000109
     * 描述：微信支付分配的商户号
     * </pre>
     */
    @XStreamAlias("mch_id")
    private String mchId;
    /**
     * <pre>
     * 字段名：服务商模式下的子商户公众账号ID
     * 变量名：sub_appid
     * 是否必填：否
     * 类型：String(32)
     * 示例值：wxd678efh567hg6787
     * 描述：微信分配的子商户公众账号ID
     * </pre>
     */
    @XStreamAlias("sub_appid")
    protected String subAppId;
    /**
     * <pre>
     * 字段名：服务商模式下的子商户号
     * 变量名：sub_mch_id
     * 是否必填：是
     * 类型：String(32)
     * 示例值：1230000109
     * 描述：微信支付分配的子商户号，开发者模式下必填
     * </pre>
     */
    @XStreamAlias("sub_mch_id")
    protected String subMchId;


    /**
     * <pre>
     * 字段名：微信订单号
     * 变量名：transaction_id
     * 是否必填：否
     * 类型：String(32)
     * 示例值：1009660380201506130728806387
     * 描述：微信的订单号，优先使用
     * </pre>
     */
    @XStreamAlias("transaction_id")
    private String transactionId;
    /**
     * <pre>
     * 字段名：商户订单号
     * 变量名：out_trade_no
     * 是否必填：否
     * 类型：String(32)
     * 示例值：20150806125346
     * 描述：商户系统内部的订单号，当没提供transaction_id时需要传这个。
     * </pre>
     */
    @XStreamAlias("out_trade_no")
    private String outTradeNo;
    /**
     * <pre>
     * 字段名：随机字符串
     * 变量名：nonce_str
     * 是否必填：是
     * 类型：String(32)
     * 示例值：C380BEC2BFD727A4B6845133519F3AD6
     * 描述：随机字符串，不长于32位。推荐随机数生成算法
     * </pre>
     */
    @XStreamAlias("nonce_str")
    private String nonceStr;

    /**
     * <pre>
     * 字段名：签名
     * 变量名：sign
     * 是否必填：是
     * 类型：String(32)
     * 示例值：C380BEC2BFD727A4B6845133519F3AD6
     * 描述：签名，详见签名生成算法
     * </pre>
     */
    @XStreamAlias("sign")
    private String sign;
    @Override
    protected void checkConstraints() throws WxPayException {

    }
}
