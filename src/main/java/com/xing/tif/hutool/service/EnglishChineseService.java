/**
 * 
 */
package com.xing.tif.hutool.service;

import com.xing.tif.hutool.client.EnglishChineseClient;

import java.util.Map;

/**
 * @author xpy
 *
 */
public class EnglishChineseService {
	public static final String URL = "http://www.webxml.com.cn/WebServices/WeatherWebService.asmx/getWeatherbyCityName";
	public String englishToChinese(String word) {
		EnglishChineseClient client = new EnglishChineseClient();
		String resStr = client.englishChinese(word, URL);
		System.out.println(resStr);
		return resStr;
	}

	public String weater(Map<String,Object> map){
		EnglishChineseClient client = new EnglishChineseClient();
		String resStr = client.wether(map, URL);
		System.out.println(resStr);
		return resStr;
	}

}
