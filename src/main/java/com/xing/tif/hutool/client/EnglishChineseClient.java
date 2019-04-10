/**
 * 
 */
package com.xing.tif.hutool.client;

import cn.hutool.http.HttpRequest;

import java.util.Map;

/**
 * @author xpy
 * hutool地址：http://hutool.mydoc.io/undefined#category_76217
 */
public class EnglishChineseClient {
	public String englishChinese(String word,String url) {
		String body = HttpRequest.post(url)
		.header("Content-Type", "application/x-www-form-urlencoded")
		.form("theCityName", word)
		.timeout(2000)
		.execute().body();
		return body;
	}

	public String wether(Map<String,Object> map,String url){
		String body = HttpRequest.post(url)
				.header("Content-Type", "application/x-www-form-urlencoded")
				.form(map)
				.timeout(2000)
				.execute().body();
		return body;
	}

}
