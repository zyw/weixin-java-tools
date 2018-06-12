package com.github.binarywang.wxpay.bean.request;

import com.github.binarywang.wxpay.exception.WxPayException;
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
public class WxPayContractRequest extends BaseWxPayRequest {
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
   * 字段名：请求序列号
   * 变量名：request_serial
   * 是否必填：是
   * 类型：Int64
   * 示例值：1000
   * 描述：商户请求签约时的序列号，商户侧须唯一。序列号主要用于排序，不作为查询条件，纯数字。长度不超过12位
   * </pre>
   */
  @XStreamAlias("request_serial")
  private String requestSerial;
  /**
   * <pre>
   * 字段名：用户账户展示名称
   * 变量名：contract_display_account
   * 是否必填：是
   * 类型：String(32)
   * 示例值：微信代扣
   * 描述：签约用户的名称，用于页面展示，参数值不支持UTF8非3字节编码的字符，例如表情符号，所以请勿传微信昵称到该字段
   * </pre>
   */
  @XStreamAlias("contract_display_account")
  private String contractDisplayAccount;
  /**
   * <pre>
   * 字段名：回调通知url
   * 变量名：notify_url
   * 是否必填：是
   * 类型：String
   * 示例值：https://weixin.qq.com
   * 描述：用于接收签约成功消息的回调通知地址，以http或https开头。请对notify_url参数值进行encode处理。当签约场景为APP时，且系统为ios时，需要对参数值encode两次
   * </pre>
   */
  @XStreamAlias("notify_url")
  private String notifyUrl;
  /**
   * <pre>
   * 字段名：时间戳
   * 变量名：timestamp
   * 是否必填：是
   * 类型：String(10)
   * 示例值：1414488825
   * 描述：系统当前时间，10位
   * </pre>
   */
  @XStreamAlias("timestamp")
  private String timestamp;
  /**
   * <pre>
   * 字段名：版本号
   * 变量名：version
   * 是否必填：是
   * 类型：String
   * 示例值：1.0
   * 描述：固定值1.0
   * </pre>
   */
  @XStreamAlias("version")
  private String version;
  /**
   * <pre>
   * 字段名：客户端 IP
   * 变量名：clientip
   * 是否必填：否
   * 类型：String
   * 示例值：119.145.83.6
   * 描述：点分IP格式(客户端IP)
   * </pre>
   */
  @XStreamAlias("clientip")
  private String clientip;
  /**
   * <pre>
   * 字段名：设备ID
   * 变量名：deviceid
   * 是否必填：否
   * 类型：String
   * 示例值：baf04e6bbbd06f7b1a197d18ed53b7f1
   * 描述：android填imei的一次md5; ios填idfa的一次md5
   * </pre>
   */
  @XStreamAlias("deviceid")
  private String deviceid;
  /**
   * <pre>
   * 字段名：手机号
   * 变量名：mobile
   * 是否必填：否
   * 类型：String
   * 示例值：18933432355
   * 描述：用户手机号
   * </pre>
   */
  @XStreamAlias("mobile")
  private String mobile;
  /**
   * <pre>
   * 字段名：邮箱地址
   * 变量名：email
   * 是否必填：否
   * 类型：String
   * 示例值：aobama@whitehouse.com
   * 描述：用户邮箱地址
   * </pre>
   */
  @XStreamAlias("email")
  private String email;
  /**
   * <pre>
   * 字段名：QQ号
   * 变量名：qq
   * 是否必填：否
   * 类型：String
   * 示例值：100243
   * 描述：用户QQ号
   * </pre>
   */
  @XStreamAlias("qq")
  private String qq;
  /**
   * <pre>
   * 字段名：微信open ID
   * 变量名：openid
   * 是否必填：否
   * 类型：String
   * 示例值：baf04e6bbbd06f7b1a197d18ed53b7f1
   * 描述：用户微信open ID
   * </pre>
   */
  @XStreamAlias("openid")
  private String openid;
  /**
   * <pre>
   * 字段名：身份证号
   * 变量名：creid
   * 是否必填：否
   * 类型：String
   * 示例值：110102199701011000
   * 描述：用户身份证号
   * </pre>
   */
  @XStreamAlias("creid")
  private String creid;
  /**
   * <pre>
   * 字段名：商户侧用户标识
   * 变量名：outerid
   * 是否必填：否
   * 类型：String
   * 示例值：aaa
   * 描述：用户在商户侧的标识
   * </pre>
   */
  @XStreamAlias("outerid")
  private String outerid;

  @Override
  protected boolean ignoreNonceStr() {
    return true;
  }

  @Override
  protected void checkConstraints() throws WxPayException {
    if(StringUtils.isEmpty(this.timestamp)) {
      this.setTimestamp(String.valueOf(System.currentTimeMillis()));
    }
  }
}
