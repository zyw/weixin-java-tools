package com.github.binarywang.wxpay.bean.request;

import com.github.binarywang.wxpay.exception.WxPayException;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.*;
import org.apache.commons.lang3.StringUtils;


@EqualsAndHashCode(callSuper = true)
@Data
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
@AllArgsConstructor
@XStreamAlias("xml")
public class WxQueryContractRequest extends BaseWxPayRequest {
  /**
   * <pre>
   * 字段名：委托代扣协议id
   * 变量名：contract_id
   * 是否必填：否
   * 类型：String
   * 示例值：Wx15463511252015071056489715
   * 描述：委托代扣签约成功后由微信返回的委托代扣协议id，选择contract_id解约，则此参数必填
   * </pre>
   */
  @XStreamAlias("contract_id")
  private String contractId;
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

  @Override
  protected boolean ignoreNonceStr() {
    return true;
  }

  @Override
  protected void checkConstraints() throws WxPayException {
    if(StringUtils.isEmpty(version)) {
      this.setVersion("1.0");
    }
  }
}
