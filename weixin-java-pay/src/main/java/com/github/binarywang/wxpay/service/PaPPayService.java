package com.github.binarywang.wxpay.service;

import com.github.binarywang.wxpay.bean.notify.WxContractNotifyResult;
import com.github.binarywang.wxpay.bean.notify.WxPayPaPNotifyResult;
import com.github.binarywang.wxpay.bean.request.WxPayApplyPayRequest;
import com.github.binarywang.wxpay.bean.request.WxPayContractRequest;
import com.github.binarywang.wxpay.bean.request.WxPayDeleteContractRequest;
import com.github.binarywang.wxpay.bean.request.WxPayQueryContractRequest;
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
  WxPayContractResult contract(WxPayContractRequest request) throws WxPayException;
  /**
   * 签约回调接口
   * @return 返回签约的对象
   */
  WxContractNotifyResult parseContractNotifyResult(String notifyXml)throws WxPayException;
  /**
   * 申请支付的接口
   */
  WxPayApplyPayResult applyPay(WxPayApplyPayRequest applyPayRequest) throws WxPayException;
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
  WxPayQueryContractResult queryContract(WxPayQueryContractRequest request) throws WxPayException;
  /**
   * 申请解约接口
   * @param request 申请解约参数
   * @return
   * @throws WxPayException
   */
  WxPayDeleteContractResult deleteContract(WxPayDeleteContractRequest request) throws WxPayException;
  /**
   * 订单查询接口
   */
  WxPayPaPOrderQueryResult orderQuery(String transactionId) throws WxPayException;
}
