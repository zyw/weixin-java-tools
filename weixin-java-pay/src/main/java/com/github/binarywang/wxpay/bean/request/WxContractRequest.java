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
public class WxContractRequest extends BaseWxPayRequest {

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
