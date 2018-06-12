package com.github.binarywang.wxpay.bean.notify;

import com.github.binarywang.wxpay.bean.result.BaseWxPayResult;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import me.chanjar.weixin.common.util.ToStringUtils;

/**
 * 签约、解约成功后（不成功不通知），微信会把相关签约、解约信息异步通知给商户。商户在收到结果通知后，需马上应答。
 * @author ZYW
 * @date 2018/5/18
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@XStreamAlias("xml")
public class WxContractNotifyResult extends BaseWxPayResult {
  /**
   * <pre>
   * 字段名：签约协议号
   * 变量名：contract_code
   * 是否必填：是
   * 类型：String(32)
   * 示例值：100000
   * 描述：商户侧的签约协议号，由商户生成
   * </pre>
   */
  @XStreamAlias("contract_code")
  private String contractCode;
  /**
   * <pre>
   * 字段名：模板id
   * 变量名：plan_id
   * 是否必填：是
   * 类型：String(28)
   * 示例值：12535
   * 描述：协议模板id，设置路径见开发步骤。
   * </pre>
   */
  @XStreamAlias("plan_id")
  private String planId;
  /**
   * <pre>
   * 字段名：微信open ID
   * 变量名：openid
   * 是否必填：是
   * 类型：String
   * 示例值：onqOjjmM1tad-3ROpncN-yUfa6ua
   * 描述：Appid下，用户的唯一标识
   * </pre>
   */
  @XStreamAlias("openid")
  private String openid;
  /**
   * <pre>
   * 字段名：用户子标识
   * 变量名：sub_openid
   * 是否必填：否
   * 类型：String(32)
   * 示例值：oUpF8uMuAJO_M2pxb1Q9zNjWeS6o
   * 描述：sub_appid下，用户的唯一标识
   * </pre>
   */
  @XStreamAlias("sub_openid")
  private String subOpenid;
  /**
   * <pre>
   * 字段名：变更类型
   * 变量名：change_type
   * 是否必填：是
   * 类型：String(32)
   * 示例值：ADD
   * 描述：ADD--签约 DELETE--解约 商户可通过该字段判断是签约回调还是解约回调
   * </pre>
   */
  @XStreamAlias("change_type")
  private String changeType;
  /**
   * <pre>
   * 字段名：操作时间
   * 变量名：operate_time
   * 是否必填：是
   * 类型：String
   * 示例值：2015-07-01 10:00:00
   * 描述：操作时间
   * </pre>
   */
  @XStreamAlias("operate_time")
  private String operateTime;
  /**
   * <pre>
   * 字段名：委托代扣协议id
   * 变量名：contract_id
   * 是否必填：是
   * 类型：String（32）
   * 示例值：Wx15463511252015071056489715
   * 描述：签约成功后，微信返回的委托代扣协议id
   * </pre>
   */
  @XStreamAlias("contract_id")
  private String contractId;
  /**
   * <pre>
   * 字段名：协议到期时间
   * 变量名：contract_expired_time
   * 是否必填：是
   * 类型：String（32）
   * 示例值：2016-07-01 10:00:00
   * 描述：协议到期时间
   * </pre>
   */
  @XStreamAlias("contract_expired_time")
  private String contractExpiredTime;
  /**
   * <pre>
   * 字段名：请求序列号
   * 变量名：request_serial
   * 是否必填：是
   * 类型：String（32）
   * 示例值：1695
   * 描述：商户请求签约时的序列号，商户侧须唯一 ,纯数字。长度不超过12位
   * </pre>
   */
  @XStreamAlias("request_serial")
  private String requestSerial;

  @Override
  public String toString() {
    return ToStringUtils.toSimpleString(this);
  }
}
