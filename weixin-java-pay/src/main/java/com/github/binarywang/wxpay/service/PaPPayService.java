package com.github.binarywang.wxpay.service;

import com.github.binarywang.wxpay.bean.notify.WxContractNotifyResult;
import com.github.binarywang.wxpay.bean.notify.WxPayPaPNotifyResult;
import com.github.binarywang.wxpay.bean.request.WxApplyPayRequest;
import com.github.binarywang.wxpay.bean.request.WxContractRequest;
import com.github.binarywang.wxpay.bean.request.WxDeleteContractRequest;
import com.github.binarywang.wxpay.bean.request.WxQueryContractRequest;
import com.github.binarywang.wxpay.bean.result.*;
import com.github.binarywang.wxpay.config.WxPayConfig;
import com.github.binarywang.wxpay.exception.WxPayException;

/**
 * <pre>
 * 微信代扣费接口
 * https://pay.weixin.qq.com/wiki/doc/api/pap_sl.php?chapter=18_16&index=1
 * </pre>
 * @author <a href="https://github.com/zyw">ZYW</a>
 * @date 2018/5/18
 */
public interface PaPPayService {
  /**
   * 获取配置.
   */
  WxPayConfig getConfig();
  /**
   * 签约申请接口
   * @return 返回签约的对象
   */
  WxContractResult contract(WxContractRequest request) throws WxPayException;
  /**
   * 签约回调接口
   * @return 返回签约的对象
   */
  WxContractNotifyResult parseContractNotifyResult(String notifyXml)throws WxPayException;
  /**
   * 申请支付的接口
   */
  WxApplyPayResult applyPay(WxApplyPayRequest applyPayRequest) throws WxPayException;
  /**
   * 支付通知接口
   */
  WxPayPaPNotifyResult parseOrderNotifyResult(String notifyXml) throws WxPayException;
  /**
   * 查询签约结果
   * @param request
   * @return
   * @throws WxPayException
   */
  WxQueryContractResult queryContract(WxQueryContractRequest request) throws WxPayException;
  /**
   * 申请解约接口
   * @param request 申请解约参数
   * @return
   * @throws WxPayException
   */
  WxDeleteContractResult deleteContract(WxDeleteContractRequest request) throws WxPayException;
  /**
   * 订单查询接口
   */
  WxOrderQueryResult orderQuery(String transactionId) throws WxPayException;
}
