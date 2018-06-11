package com.github.binarywang.wxpay.bean.result;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author ZYW
 * @date 2018/6/11
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(builderMethodName = "newBuilder")
public class ContractResult implements Serializable {
    /**
     * <pre>
     * 字段名：公众账号ID
     * 变量名：appid
     * 是否必填：是
     * 类型：String(32)
     * 示例值：wxd678efh567hg6787
     * 描述：微信分配的公众账号ID（企业号corpid即为此appId）
     * </pre>
     */
    private String appId;
    /**
     * <pre>
     * 字段名：商户号
     * 变量名：mch_id
     * 是否必填：是
     * 类型：String(32)
     * 示例值：1230000109
     * 描述：微信支付分配的商户号
     * </pre>
     */
    private String mchId;
    /**
     * <pre>
     * 字段名：服务商模式下的子商户号
     * 变量名：sub_mch_id
     * 是否必填：是
     * 类型：String(32)
     * 示例值：1230000109
     * 描述：微信支付分配的子商户号，开发者模式下必填
     * </pre>
     */
    private String subMchId;
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
    private String notifyUrl;
    /**
     * <pre>
     * 字段名：签名
     * 变量名：sign
     * 是否必填：是
     * 类型：String(32)
     * 示例值：C380BEC2BFD727A4B6845133519F3AD6
     * 描述：签名，详见签名生成算法
     * </pre>
     */
    private String sign;
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
    private String timestamp;
    /**
     * <pre>
     * 字段名：版本号
     * 变量名：version
     * 是否必填：是
     * 类型：string
     * 示例值：1.0
     * 描述：固定值1.0
     * </pre>
     */
    private String version;
    /**
     * <pre>
     * 字段名：子商户公众账号ID
     * 变量名：sub_appid
     * 是否必填：否
     * 类型：String(32)
     * 示例值：wxcbda96de0b165489
     * 描述：子商户号绑定的服务号，小程序，APP的appid(需要在服务商的商户平台为子商户绑定) 服务商模式下，如果是商户APP调起签约，此参数必传，签约后微信侧回跳到该sub_appid对应的应用
     * </pre>
     */
    private String subAppid;
}
