/**
 * 
 */
package com.xing.tif.httpclient.service;

import java.util.LinkedHashMap;
import java.util.Map;
import com.xing.tif.httpclient.client.HttpclientForWebService;

/**
 * @author xpy
 *
 */
public class EnglishChineseService {
	public static final String URL = "http://fy.webxml.com.cn/webservices/EnglishChinese.asmx";
	public String englishToChinese(String word) {
		HttpclientForWebService service = new HttpclientForWebService(URL);
		Map<String, String> patameterMap = new LinkedHashMap<>();
		patameterMap.put("web:wordKey",word );
		Map<String, Object> result = service.invoke(patameterMap);
		System.out.println(result);
		return null;
	}
}
