package com.github.binarywang.wxpay.service.impl;

import com.github.binarywang.wxpay.bean.notify.WxContractNotifyResult;
import com.github.binarywang.wxpay.bean.notify.WxPayPaPNotifyResult;
import com.github.binarywang.wxpay.bean.request.*;
import com.github.binarywang.wxpay.bean.result.*;
import com.github.binarywang.wxpay.config.WxPayConfig;
import com.github.binarywang.wxpay.exception.WxPayException;
import com.github.binarywang.wxpay.service.PaPPayService;
import com.github.binarywang.wxpay.service.WxPayService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <pre>
 * 微信代扣费接口
 * https://pay.weixin.qq.com/wiki/doc/api/pap_sl.php?chapter=18_16&index=1
 * </pre>
 * @author <a href="https://github.com/zyw">ZYW</a>
 * @date 2018/5/18
 */
public class PaPPayServiceImpl implements PaPPayService {

  private final Logger log = LoggerFactory.getLogger(this.getClass());

  private WxPayService wxPayService;

  public PaPPayServiceImpl(WxPayService wxPayService) {
    this.wxPayService = wxPayService;
  }

  @Override
  public WxPayConfig getConfig() {
    return wxPayService.getConfig();
  }

  @Override
  public WxContractResult contract(WxContractRequest request) throws WxPayException {
    WxPayConfig config = this.getConfig();
    request.checkAndSign(config);
    log.debug("微信支付签约请求参数: " + request.toXML());
    return WxContractResult.newBuilder()
      .appId(config.getAppId())
      .mchId(config.getMchId())
      .subMchId(config.getSubMchId())
      .planId(config.getPlanId())
      .contractCode(request.getContractCode())
      .requestSerial(request.getRequestSerial())
      .contractDisplayAccount(request.getContractDisplayAccount())
      .notifyUrl(request.getNotifyUrl())
      .timestamp(request.getTimestamp())
      .version(request.getVersion())
      .sign(request.getSign())
      .build();
  }
  /**
   * 签约回调接口
   * @param notifyXml 微信返回xml
   * @return 返回签约的对象
   */
  @Override
  public WxContractNotifyResult parseContractNotifyResult(String notifyXml) throws WxPayException {
    try {
      log.debug("微信支付签约异步通知请求参数：{}", notifyXml);
      WxContractNotifyResult result = BaseWxPayResult.fromXML(notifyXml,WxContractNotifyResult.class);
      log.debug("微信支付签约异步通知请求解析后的对象：{}", result);
      result.checkResult(this.wxPayService, this.wxPayService.getConfig().getSignType(), false);
      return result;
    } catch (WxPayException e) {
      log.error(e.getMessage(), e);
      throw e;
    } catch (Exception e) {
      log.error(e.getMessage(), e);
      throw new WxPayException("发生异常，" + e.getMessage(), e);
    }
  }
  /**
   * 申请扣款接口
   */
  @Override
  public WxApplyPayResult applyPay(WxApplyPayRequest request) throws WxPayException {
    request.checkAndSign(this.wxPayService.getConfig());
    String url = this.wxPayService.getPayBaseUrl() + "/pay/partner/pappayapply";

    String responseContent = this.wxPayService.post(url, request.toXML(), false);
    WxApplyPayResult result = BaseWxPayResult.fromXML(responseContent, WxApplyPayResult.class);
    result.checkResult(this.wxPayService, request.getSignType(), true);
    return result;
  }

  @Override
  public WxPayPaPNotifyResult parseOrderNotifyResult(String notifyXml) throws WxPayException {
    try {
      log.debug("微信支付申请支付异步通知请求参数：{}", notifyXml);
      WxPayPaPNotifyResult result = BaseWxPayResult.fromXML(notifyXml,WxPayPaPNotifyResult.class);
      log.debug("微信支付申请支付异步通知请求解析后的对象：{}", result);
      result.checkResult(this.wxPayService, this.wxPayService.getConfig().getSignType(), false);
      return result;
    } catch (WxPayException e) {
      log.error(e.getMessage(), e);
      throw e;
    } catch (Exception e) {
      log.error(e.getMessage(), e);
      throw new WxPayException("发生异常，" + e.getMessage(), e);
    }
  }

  @Override
  public WxQueryContractResult queryContract(WxQueryContractRequest request) throws WxPayException {
    String url = this.wxPayService.getPayBaseUrl() + "/papay/partner/querycontract";
    request.checkAndSign(this.wxPayService.getConfig());
    String responseContent = this.wxPayService.post(url, request.toXML(), false);
    return WxQueryContractResult.fromXML(responseContent,WxQueryContractResult.class);
  }

  @Override
  public WxDeleteContractResult deleteContract(WxDeleteContractRequest request) throws WxPayException {
    String url = this.wxPayService.getPayBaseUrl() + "/papay/partner/deletecontract";
    request.checkAndSign(this.wxPayService.getConfig());
    String responseContent = this.wxPayService.post(url, request.toXML(), false);
    return WxDeleteContractResult.fromXML(responseContent,WxDeleteContractResult.class);
  }

  @Override
  public WxOrderQueryResult orderQuery(String outTradeNo) throws WxPayException {
    String url = this.wxPayService.getPayBaseUrl() + "/pay/partner/paporderquery";
    WxPapOrderQueryRequest request = new WxPapOrderQueryRequest();
    request.setOutTradeNo(outTradeNo);
    request.checkAndSign(this.wxPayService.getConfig());
    String responseContent = this.wxPayService.post(url, request.toXML(), false);
    return WxOrderQueryResult.fromXML(responseContent,WxOrderQueryResult.class);
  }
}
