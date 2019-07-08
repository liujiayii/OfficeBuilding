package com.chuanglan.demo;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.alibaba.fastjson.JSON;
import com.chuanglan.sms.request.SmsSendRequest;
import com.chuanglan.sms.response.SmsSendResponse;
import com.chuanglan.sms.util.ChuangLanSmsUtil;

/**
 *
 * @author tianyh
 * @Description:��ͨ���ŷ���
 */
public class SmsSendDemo {
    public static final String charset = "utf-8";

    public static String account = "N6493909";

    public static String password = "nxzYdS87Ttb688";

    public static void send(String number ,String st) throws UnsupportedEncodingException {
        String smsSingleRequestServerUrl = "https://smssh1.253.com/msg/send/json";

        String testbytes2 = new String(hexstr2bytes("0xF0 0x9F 0x8C 0xB9"),"utf-8");

        String msg1 = st;
        String msg=URLEncoder.encode(msg1,"utf-8");

        String phone  = number;

        String report= "true";

        String extend = "123";

        SmsSendRequest smsSingleRequest = new SmsSendRequest(account, password, msg, phone,report,extend);

        String requestJson = JSON.toJSONString(smsSingleRequest);

        System.out.println("before request string is: " + requestJson);

        String response = ChuangLanSmsUtil.sendSmsByPost(smsSingleRequestServerUrl, requestJson);

        System.out.println("response after request result is :" + response);

        SmsSendResponse smsSingleResponse = JSON.parseObject(response, SmsSendResponse.class);

        System.out.println("response  toString is :" + smsSingleResponse);
    }

    //eg. param: 0xF0 0x9F 0x8F 0x80
    public static byte[] hexstr2bytes(String hexstr){
        String[] hexstrs = hexstr.split(" ");
        byte[] b = new byte[hexstrs.length];
        for(int i=0;i<hexstrs.length;i++){
            b[i] = hexStringToByte(hexstrs[i].substring(2))[0];
        }
        System.out.println("b"+b);
        return b;
    }

    public static byte[] hexStringToByte(String hex) {
        int len = (hex.length() / 2);
        byte[] result = new byte[len];
        char[] achar = hex.toCharArray();
        for (int i = 0; i < len; i++) {
            int pos = i * 2;
            result[i] = (byte) ("0123456789ABCDEF".indexOf(achar[pos]) << 4 | "0123456789ABCDEF".indexOf(achar[pos + 1]));
        }
        System.out.println("result"+result);
        return result;
    }
}
