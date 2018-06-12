package com.github.binarywang.wxpay.bean.request;

import com.github.binarywang.wxpay.exception.WxPayException;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.*;

/**
 * @author ZYW
 * @date 2018/5/18
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
@AllArgsConstructor
@XStreamAlias("xml")
public class WxApplyPayRequest extends BaseWxPayRequest {

  /**
   * 商品或支付单简要描述
   */
  @XStreamAlias("body")
  private String body;
  /**
   * 商品名称明细列表
   */
  @XStreamAlias("detail")
  private String detail;
  /**
   * 附加数据，在查询API和支付通知中原样返回，该字段主要用于商户携带订单的自定义数据
   */
  @XStreamAlias("attach")
  private String attach;
  /**
   * 商户系统内部的订单号,32个字符内、可包含字母, 其他说明见商户订单号
   */
  @XStreamAlias("out_trade_no")
  private String outTradeNo;
  /**
   * 订单总金额，单位为分，只能为整数
   */
  @XStreamAlias("total_fee")
  private Integer totalFee;
  /**
   * 货币类型 CNY人民币
   */
  @XStreamAlias("fee_type")
  private String feeType;

  /**
   * 8.8.8.8  调用微信支付API的机器IP
   */
  @XStreamAlias("spbill_create_ip")
  private String spbillCreateIp;
  /**
   * WXG  商品标记，代金券或立减优惠功能的参数，说明详见代金券或立减优惠
   */
  @XStreamAlias("goods_tag")
  private String goodsTag;
  /**
   * http://yoursite.com/wxpay.html  接受扣款结果异步回调通知的url
   */
  @XStreamAlias("notify_url")
  private String notifyUrl;
  /**
   * PAP  交易类型PAP-微信委托代扣支付
   */
  @XStreamAlias("trade_type")
  private String tradeType;
  /**
   * 签约成功后，微信返回的委托代扣协议id
   */
  @XStreamAlias("contract_id")
  private String contractId;
  /**
   * 119.145.83.6  点分IP格式(客户端IP)
   *//*
    @XStreamAlias("clientip")
    private String clientip;

    *//**
   * android填imei的一次md5; ios填idfa的一次md5
   *//*
    @XStreamAlias("deviceid")
    private String deviceid;
    *//**
   * 用户手机号
   *//*
    @XStreamAlias("mobile")
    private String mobile;
    *//**
   * 用户邮箱地址
   *//*
    @XStreamAlias("email")
    private String email;
    *//**
   * 用户微信open ID
   *//*
    @XStreamAlias("openid")
    private String openid;
    *//**
   * 用户身份证号
   *//*
    @XStreamAlias("creid")
    private String creid;

    *//**
   * 用户在商户侧的标识
   *//*
    @XStreamAlias("outerid")
    private String outerid;
    *//**
   * 1239878956  10位时间戳
   *//*
    @XStreamAlias("timestamp")
    private Integer timestamp;*/

  @Override
  protected void checkConstraints() throws WxPayException {

  }

}
