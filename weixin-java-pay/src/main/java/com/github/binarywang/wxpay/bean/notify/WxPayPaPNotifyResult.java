package com.github.binarywang.wxpay.bean.notify;

import com.github.binarywang.wxpay.bean.result.BaseWxPayResult;
import com.github.binarywang.wxpay.converter.WxPayOrderNotifyResultConverter;
import com.github.binarywang.wxpay.util.SignUtils;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import me.chanjar.weixin.common.util.ToStringUtils;
import me.chanjar.weixin.common.util.xml.XStreamInitializer;

import java.util.List;
import java.util.Map;

/**
 * @Author: ZYW
 * @Description: 微信免密支付回调结果
 * @Date: 2018/5/18 0018 17:10
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@XStreamAlias("xml")
public class WxPayPaPNotifyResult extends BaseWxPayResult {
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
   * <pre>
   * 字段名：总代金券金额.
   * 变量名：coupon_fee
   * 是否必填：否
   * 类型：Int
   * 示例值：10
   * 描述：代金券金额<=订单金额，订单金额-代金券金额=现金支付金额，详见支付金额
   * </pre>
   */
  @XStreamAlias("coupon_fee")
  private Integer couponFee;

  /**
   * <pre>
   * 字段名：代金券使用数量.
   * 变量名：coupon_count
   * 是否必填：否
   * 类型：Int
   * 示例值：1
   * 描述：代金券使用数量
   * </pre>
   */
  @XStreamAlias("coupon_count")
  private Integer couponCount;

  private List<WxPayOrderNotifyCoupon> couponList;

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

  public static WxPayPaPNotifyResult fromXML(String xmlString) {
    XStream xstream = XStreamInitializer.getInstance();
    xstream.processAnnotations(WxPayPaPNotifyResult.class);
    xstream.registerConverter(new WxPayOrderNotifyResultConverter(xstream.getMapper(), xstream.getReflectionProvider()));
    WxPayPaPNotifyResult result = (WxPayPaPNotifyResult) xstream.fromXML(xmlString);
    result.setXmlString(xmlString);
    return result;
  }

  @Override
  public Map<String, String> toMap() {
    Map<String, String> resultMap = SignUtils.xmlBean2Map(this);
    if (this.getCouponCount() != null && this.getCouponCount() > 0) {
      for (int i = 0; i < this.getCouponCount(); i++) {
        WxPayOrderNotifyCoupon coupon = couponList.get(i);
        resultMap.putAll(coupon.toMap(i));
      }
    }
    return resultMap;
  }

  @Override
  public String toString() {
    return ToStringUtils.toSimpleString(this);
  }
}
