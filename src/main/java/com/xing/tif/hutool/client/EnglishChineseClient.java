/**
 * 
 */
package com.xing.tif.hutool.client;

import cn.hutool.http.HttpRequest;

/**
 * @author xpy
 * hutool地址：http://hutool.mydoc.io/undefined#category_76217
 */
public class EnglishChineseClient {
	public String englishChinese(String word,String url) {
		String body = HttpRequest.post(url)
		.header("Content-Type", "application/x-www-form-urlencoded")
		.form("wordKey", word)
		.timeout(2000)
		.execute().body();
		return body;
	}

}
