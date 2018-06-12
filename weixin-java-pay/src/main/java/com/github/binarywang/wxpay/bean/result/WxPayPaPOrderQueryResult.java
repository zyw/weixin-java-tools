package com.github.binarywang.wxpay.bean.result;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@XStreamAlias("xml")
public class WxPayPaPOrderQueryResult extends BaseWxPayResult {
  /**
   * 设备号
   */
  @XStreamAlias("device_info")
  private String deviceInfo;

  /**
   * 用户标识
   */
  @XStreamAlias("openid")
  private String openId;

  /**
   * 用户子标识
   */
  @XStreamAlias("sub_openid")
  private String subOpenId;

  /**
   * 是否关注公众账号
   * 用户是否关注公众账号，Y-关注，N-未关注，仅在公众账号类型支付有效
   */
  @XStreamAlias("is_subscribe")
  private String isSubscribe;

  /**
   * 是否关注子公众账号
   * Y-关注，N-未关注，仅在公众账号类型支付有效
   */
  @XStreamAlias("sub_is_subscribe")
  private String subIsSubscribe;

  /**
   * 交易类型
   */
  @XStreamAlias("trade_type")
  private String tradeType;

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
   * 付款银行
   * 银行类型，采用字符串类型的银行标识
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
   * 现金支付货币类型
   * 货币类型，符合ISO 4217标准的三位字母代码，默认人民币：CNY，其他值列表详见货币类型
   */
  @XStreamAlias("cash_fee_type")
  private String cashFeeType;
  /**
   * 代金券或立减优惠金额
   */
  @XStreamAlias("coupon_fee")
  private String couponFee;
  /**
   * 代金券或立减优惠使用数量
   */
  @XStreamAlias("coupon_count")
  private String couponCount;
  /**
   * 微信支付订单号
   */
  @XStreamAlias("transaction_id")
  private String transactionId;
  /**
   * 商户订单号
   */
  @XStreamAlias("out_trade_no")
  private  String outTradeNo;

  /**
   * 附加数据
   */
  @XStreamAlias("attach")
  private String attach;
  /**
   * 支付完成时间
   */
  @XStreamAlias("time_end")
  private String timeEnd;
  /**
   * 交易状态描述
   */
  @XStreamAlias("trade_state_desc")
  private String tradeStateDesc;

  /**
   * 委托代扣协议id
   */
  @XStreamAlias("contract_id")
  private String contractId;
}

