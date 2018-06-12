package com.github.binarywang.wxpay.bean.notify;

import com.github.binarywang.wxpay.bean.result.BaseWxPayResult;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import me.chanjar.weixin.common.util.ToStringUtils;

/**
 * @author ZYW
 * @date 2018/5/18
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@XStreamAlias("xml")
public class WxContractNotifyResult extends BaseWxPayResult {
  /**
   * 签约协议号
   */
  @XStreamAlias("contract_code")
  private String contractCode;

  /**
   * 模板id
   */
  @XStreamAlias("plan_id")
  private String planId;

  /**
   * 用户标识
   */
  @XStreamAlias("openid")
  private String openid;

  /**
   * 用户子标识
   */
  @XStreamAlias("sub_openid")
  private String subOpenid;

  /**
   * ADD--签约
   * DELETE--解约
   * 商户可通过该字段判断是签约回调还是解约回调
   */
  @XStreamAlias("change_type")
  private String changeType;

  /**
   * 操作时间
   */
  @XStreamAlias("operate_time")
  private String operateTime;

  /**
   * 签约成功后，微信返回的委托代扣协议id
   */
  @XStreamAlias("contract_id")
  private String contractId;

  /**
   * 协议到期时间
   */
  @XStreamAlias("contract_expired_time")
  private String contractExpiredTime;

  /**
   * 商户请求签约时的序列号，商户侧须唯一 ,纯数字。长度不超过12位
   */
  @XStreamAlias("request_serial")
  private String requestSerial;

  @Override
  public String toString() {
    return ToStringUtils.toSimpleString(this);
  }
}
