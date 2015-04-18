package org.owen.batisx.web.util;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Created by gexin on 15/4/1.
 */
public final class SmsUtils {
    private static Logger logger = LoggerFactory.getLogger(SmsUtils.class);
    private static String URL = "http://42.121.122.61:18002/send.do?";
    private static String USERNAME = "yanghl";
    private static String PASSWORD = "198311";
    private static HttpClient httpClient = new HttpClient();

    public static boolean send(String content, String... phones) {
        String response = "";
        GetMethod getMethod = new GetMethod(URL + "ua=" + USERNAME + "&pw=" + PASSWORD + "&mb=" + converToString(phones) + "&ms="+content);
        try {
            int statusCode = httpClient.executeMethod(getMethod);
            if (statusCode != HttpStatus.SC_OK) {
                logger.error("Method failed: " + getMethod.getStatusLine());
            }
            response = getMethod.getResponseBodyAsString();
        } catch (HttpException e) {
            logger.error("Please check your provided http address!");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            getMethod.releaseConnection();
        }
        logger.debug("send sms return : {}", response);
        return response.startsWith("0");
    }

    /**
     * @Description:把数组转换为一个用逗号分隔的字符串 ，以便于用in+String 查询
     */
    private static String converToString(String[] ig) {
        String str = "";
        if (ig != null && ig.length > 0) {
            for (int i = 0; i < ig.length; i++) {
                str += ig[i] + ",";
            }
        }
        str = str.substring(0, str.length() - 1);
        return str;
    }

}
