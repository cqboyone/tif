/**
 * 
 */
package com.xing.tif.feign.client;

import feign.Headers;
import feign.Param;
import feign.RequestLine;

/**
 * @author xpy
 *
 */
public interface RemoteService {
	@RequestLine("POST /app/know/xxx")
	@Headers("Content-Type: application/json")
	String getCustomer(String params);
	
	@RequestLine("POST /webservices/EnglishChinese.asmx")
	@Headers("Content-Type: text/xml")
	String getChinese(@Param(value = "web:wordKey") String wordKey);
}
