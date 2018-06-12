package com.github.binarywang.wxpay.bean.result;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @Author: ZYW
 * @Description: 扣款申请回调结果
 * @Date: 2018/5/18 0018 17:10
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@XStreamAlias("xml")
public class WxDeleteContractResult extends BaseWxPayResult {
    @XStreamAlias("plan_id")
    private String planId;

    @XStreamAlias("contract_id")
    private String contractId;

    @XStreamAlias("contract_code")
    private String contractCode;
}
