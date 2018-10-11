package com.xing.tif.httpclient.client;

/**
 *
 */
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.ConnectException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.InputStreamRequestEntity;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author xpy
 */
public class HttpclientForWebService {
    private static final Logger LOGGER = LoggerFactory.getLogger(HttpclientForWebService.class);
    private static final String UTF_8 = "utf-8";
    private static final String CONTENT_TYPE = "text/xml; charset=utf-8";
    public static final String SUCCESS = "success";
    public static final String MSG = "msg";
    public static final String RESULTCODE = "resultCode";
    private String methodName;
    private String wsdlLocation;
	public HttpclientForWebService() {
		super();
	}
	public HttpclientForWebService(String wsdlLocation) {
        this.wsdlLocation = wsdlLocation;
    }
    public HttpclientForWebService(String methodName, String wsdlLocation) {
        this.methodName = methodName;
        this.wsdlLocation = wsdlLocation;
    }

    // 执行请求方法
    public Map<String, Object> invoke(Map<String, String> patameterMap) {
        PostMethod postMethod = new PostMethod(wsdlLocation);
        String soapRequestData = buildRequestData(patameterMap);
        LOGGER.info("请求报文数据：wsdlLocation:{},data:{}", wsdlLocation, soapRequestData);
        Map<String, Object> result = new HashMap<>();
        try {
            byte[] bytes = soapRequestData.getBytes(UTF_8);
            InputStream inputStream = new ByteArrayInputStream(bytes, 0, bytes.length);
            RequestEntity requestEntity = new InputStreamRequestEntity(inputStream, bytes.length,
                    CONTENT_TYPE);
            postMethod.setRequestEntity(requestEntity);

            HttpClient httpClient = new HttpClient();
            int statusCode = httpClient.executeMethod(postMethod);

            if (statusCode == 200) {
                String soapResponseData = postMethod.getResponseBodyAsString();
                result.put(RESULTCODE, soapResponseData);
                result.put(SUCCESS, true);
                return result;

            } else {
                LOGGER.info("soapRequestData 调用失败！错误码：{}", statusCode);
            }
            result.put(MSG, "Call fails" + statusCode);
            result.put(SUCCESS, false);
        } catch (UnsupportedEncodingException e) {
            result.put(MSG, "UnsupportedEncodingException");
            result.put(SUCCESS, false);
            LOGGER.error(e.getMessage());
        } catch (HttpException e) {
            result.put(MSG, "Http Request Exception");
            result.put(SUCCESS, false);
            LOGGER.error(e.getMessage());
        } catch(ConnectException e) {
        	result.put(MSG, "Connection refused");
            result.put(SUCCESS, false);
            LOGGER.error(e.getMessage());
        }catch (Exception e) {
            result.put(MSG, "Systematic analytic anomaly");
            result.put(SUCCESS, false);
            LOGGER.error(e.getMessage());
        }
        return result;
    }

    // 封装请求的body数据,每一个wsdl都不一样，可以使用soapui查看
    private String buildRequestData(Map<String, String> patameterMap) {
        StringBuilder soapRequestData = new StringBuilder();
        soapRequestData.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
        soapRequestData.append(
                "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:web=\"http://WebXml.com.cn/\">")
                .append("<soapenv:Header/>").append("<soapenv:Body>").append("<web:TranslatorString>");
        Set<String> nameSet = patameterMap.keySet();
        //可能会有多个参数
        for (String name : nameSet) {
            soapRequestData.append("<" + name + ">" + patameterMap.get(name) + "</" + name + ">");
        }
        soapRequestData.append("</web:TranslatorString>");
        soapRequestData.append("</soapenv:Body>");
        soapRequestData.append("</soapenv:Envelope>");
        return soapRequestData.toString();
    }
}
