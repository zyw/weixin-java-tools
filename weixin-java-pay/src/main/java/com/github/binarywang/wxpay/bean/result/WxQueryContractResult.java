package com.github.binarywang.wxpay.bean.result;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author ZYW
 * @date 2018/6/8
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@XStreamAlias("xml")
public class WxQueryContractResult extends BaseWxPayResult {

    /**
     * 0-签约中
     * 1-解约
     */
    @XStreamAlias("contract_state")
    private Integer contractState;

    /**
     * 协议解约时间 当contract_state=1时，该值有效
     */
    @XStreamAlias("contract_terminated_time")
    private String contractTerminatedTime;
    /**
     * 协议解约方式
     * 当contract_state=1时，该值有效
     * 0-未解约
     * 1-有效期过自动解约
     * 2-用户主动解约
     * 3-商户API解约
     * 4-商户平台解约
     * 5-注销
     */
    @XStreamAlias("contract_termination_mode")
    private Integer contractTerminationMode;

    /**
     * 解约原因
     */
    @XStreamAlias("contract_termination_remark")
    private String contractTerminationRemark;
}
