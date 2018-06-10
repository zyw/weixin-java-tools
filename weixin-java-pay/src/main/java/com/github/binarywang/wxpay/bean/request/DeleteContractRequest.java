package com.github.binarywang.wxpay.bean.request;

import com.github.binarywang.wxpay.config.WxPayConfig;
import com.github.binarywang.wxpay.exception.WxPayException;
import com.github.binarywang.wxpay.util.SignUtils;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.*;


@EqualsAndHashCode(callSuper = true)
@Data
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
@AllArgsConstructor
@XStreamAlias("xml")
public class DeleteContractRequest extends BaseWxPayRequest {
    /**
     * <pre>
     * 字段名：模板id
     * 变量名：plan_id
     * 是否必填：否
     * 类型：String
     * 示例值：12251
     * 描述：商户在微信商户平台配置的代扣模版id，选择plan_id+contract_code解约，则此参数必填
     * </pre>
     */
    @XStreamAlias("plan_id")
    private String planId;
    /**
     * <pre>
     * 字段名：签约协议号
     * 变量名：contract_code
     * 是否必填：否
     * 类型：String
     * 示例值：1234
     * 描述：商户请求签约时传入的签约协议号，商户侧须唯一。选择plan_id+contract_code解约，则此参数必填
     * </pre>
     */
    @XStreamAlias("contract_code")
    private String contractCode;
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
     * 字段名：解约备注
     * 变量名：contract_termination_remark
     * 是否必填：是
     * 类型：String(256)
     * 示例值：解约原因
     * 描述：解约原因的备注说明，如：签约信息有误，须重新签约
     * </pre>
     */
    @XStreamAlias("contract_termination_remark")
    private String contractTerminationRemark;
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
    private String version="1.0";
    @Override
    protected void checkConstraints() throws WxPayException {

    }

    @Override
    public void checkAndSign(WxPayConfig config) throws WxPayException {
        super.checkAndSign(config);
        this.setNonceStr(null);
        //设置签名字段的值
        this.setSign(SignUtils.createSign(this, this.getSignType(), config.getMchKey(),
                this.ignoreSignType()));
    }
}
