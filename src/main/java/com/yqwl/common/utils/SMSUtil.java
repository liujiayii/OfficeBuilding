package com.yqwl.common.utils;

import java.util.Random;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bcloud.msg.http.HttpSender;










/**
 * 短信验证码工具类
 * 
 * @description 
 *
 * @author ChenZhipeng
 * @createDate 2015年12月22日
 */
public class SMSUtil {
	
	 private static Logger logger = LoggerFactory.getLogger(SMSUtil.class);
	
	/**
	 * 短信验证码
	 * @description 
	 *
	 * @author Chenzhipeng
	 * @createDate 2015年12月22日
	 * @param smsAccount 短信账号
	 * @param smsPassword 短信密码
	 * @param mobile 手机号码
	 * @param content 短信模板
	 * @param effectiveTime 有效时长
	 * @param scene 短信发送场景
	 * @param isSend 是否发送邮件：测试环境不发送，正式环境需发送
	 */
	@SuppressWarnings("null")
	public static void sendCode(String smsAccount,String smsPassword,String mobile,String content,
			String effectiveTime, String scene ,boolean isSend) {
		int randomCode = (new Random()).nextInt(899999) + 100000;// 最大值位999999
		String SMScontent = null;
		/* 判断验证码在有效期内是否存在于缓存中 */
		//Object cache = Cache.get(mobile + scene);
		HttpSession session = null;
		Object brokerVo = session.getAttribute(mobile + scene);
    	if(brokerVo != null){
    		SMScontent = content.replace("validate", brokerVo.toString());
    	}else {
    		SMScontent = content.replace("sms_code", randomCode+"");
    		session.setAttribute(mobile + scene, randomCode + "");
		}
    	
    	
    	/* 是否发送短信 */
		if(isSend){
			sendSMS(smsAccount, smsPassword, mobile, SMScontent);
			//EimsSMS.send(smsAccount, smsPassword, SMScontent, mobile);
		}
		logger.info(SMScontent);
	}
	
	/**
	 * 发送短信
	 * @param smsAccount
	 * @param smsPassword
	 * @param mobile
	 * @param SMScontent
	 */
	public static void sendSMS(String smsAccount,String smsPassword,String mobile,String SMScontent){
		String url = "http://vsms.253.com/msg/send/json";// 应用地址
    	boolean needstatus = false;// 是否需要状态报告，需要true，不需要false
    	String product = null;// 产品ID
		String extno = null;// 扩展码
		try {
			//HttpSender.send(url, smsAccount, smsPassword, mobile, SMScontent, needstatus, product, extno);
			HttpSender.batchSend(url, smsAccount, smsPassword, mobile, SMScontent, needstatus, product, extno) ;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		
		sendSMS("N6493909", "nxzYdS87Ttb688", "15232136056", "喔家房产");
		
		
	}
	
}
