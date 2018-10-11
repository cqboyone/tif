/**
 * 
 */
package com.xing.tif.feign.client;

import java.util.Map;
import java.util.Set;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import feign.Feign;
import feign.codec.Decoder;

/**
 * @author xpy
 *
 */
public class FeignApi {
	public String englishChinese(String word) {
		RemoteService service = Feign.builder()
				.encoder((o,type,template)->{
					JSONObject json = JSONUtil.parseObj(o);
					String data = buildRequestData(json);
					template.body(data);
				})
				.decoder((response,type)->{
					Decoder.Default d = new Decoder.Default();
					return d.decode(response, type);
				})
				.target(RemoteService.class,"http://fy.webxml.com.cn");
		
		return service.getChinese(word);
	}
	private String buildRequestData(JSONObject json) {
        StringBuilder soapRequestData = new StringBuilder();
        soapRequestData.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
        soapRequestData.append(
                "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:web=\"http://WebXml.com.cn/\">")
                .append("<soapenv:Header/>").append("<soapenv:Body>").append("<web:TranslatorString>");
        Set<String> nameSet = json.keySet();
        //可能会有多个参数
        for (String name : nameSet) {
            soapRequestData.append("<" + name + ">" + json.get(name) + "</" + name + ">");
        }
        soapRequestData.append("</web:TranslatorString>");
        soapRequestData.append("</soapenv:Body>");
        soapRequestData.append("</soapenv:Envelope>");
        return soapRequestData.toString();
    }
}
