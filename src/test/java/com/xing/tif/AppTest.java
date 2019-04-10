/**
 * 
 */
package com.xing.tif;

import com.xing.tif.axis2.service.EnglishChineseService;
import com.xing.tif.feign.client.FeignApi;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 80003301
 *
 */
public class AppTest {
	@Test
	public void axis2() {
		EnglishChineseService service = new EnglishChineseService();
		String englishToChinese = service.englishToChinese("english");
		
	}
	@Test
	public void httpclient() {
		com.xing.tif.httpclient.service.EnglishChineseService service = new com.xing.tif.httpclient.service.EnglishChineseService();
		service.englishToChinese("java");
		//{success=true, resultCode=<?xml version="1.0" encoding="utf-8"?><soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:xsd="http://www.w3.org/2001/XMLSchema"><soap:Body><TranslatorStringResponse xmlns="http://WebXml.com.cn/"><TranslatorStringResult><string>Java</string><string>'dʒɑ:və</string><string /><string>n. 爪哇岛(印尼)</string><string>14126.mp3</string></TranslatorStringResult></TranslatorStringResponse></soap:Body></soap:Envelope>}
	}
	@Test
	public void hutool() {
		com.xing.tif.hutool.service.EnglishChineseService service = new com.xing.tif.hutool.service.EnglishChineseService();
		service.englishToChinese("thread");
		/**
		 * <?xml version="1.0" encoding="utf-8"?>
			<ArrayOfString xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns="http://WebXml.com.cn/">
			  <string>thread</string>
			  <string>θred</string>
			  <string />
			  <string>n. 线,纤维,思路,线索；v. 穿线于,穿过,成线</string>
			  <string>44854.mp3</string>
			</ArrayOfString>
		 * 
		 */
		
		
	}
	@Test
	public void feign() {
		FeignApi api = new FeignApi();
		String chinese = api.englishChinese("thread");
		System.out.println(chinese);
		//<?xml version="1.0" encoding="utf-8"?><soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:xsd="http://www.w3.org/2001/XMLSchema"><soap:Body><TranslatorStringResponse xmlns="http://WebXml.com.cn/"><TranslatorStringResult><string>thread</string><string>θred</string><string /><string>n. 线,纤维,思路,线索；v. 穿线于,穿过,成线</string><string>44854.mp3</string></TranslatorStringResult></TranslatorStringResponse></soap:Body></soap:Envelope>

	}

	@Test
	public void hutoolMap(){
		Map<String,Object> map = new HashMap<>(1);
		map.put("theCityName","重庆");
		com.xing.tif.hutool.service.EnglishChineseService englishChineseService = new com.xing.tif.hutool.service.EnglishChineseService();
		englishChineseService.weater(map);

	}

}
