/**
 * 
 */
package com.xing.tif.hutool.service;

import com.xing.tif.hutool.client.EnglishChineseClient;

/**
 * @author xpy
 *
 */
public class EnglishChineseService {
	public static final String URL = "http://fy.webxml.com.cn/webservices/EnglishChinese.asmx/TranslatorString";
	public String englishToChinese(String word) {
		EnglishChineseClient client = new EnglishChineseClient();
		String string = client.englishChinese(word, URL);
		System.out.println(string);
		return null;
	}
}
