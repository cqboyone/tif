/**
 * 
 */
package com.xing.tif.axis2.service;

import java.util.Arrays;

import org.apache.axis2.AxisFault;

import com.xing.tif.axis2.cient.EnglishChineseStub;
import com.xing.tif.axis2.cient.EnglishChineseStub.ArrayOfString;
import com.xing.tif.axis2.cient.EnglishChineseStub.TranslatorStringResponse;

/**
 * @author xpy
 *
 */
public class EnglishChineseService {
	public static final String URL = "http://fy.webxml.com.cn/webservices/EnglishChinese.asmx";
	public String englishToChinese(String word) {
		try {
			EnglishChineseStub stub = new EnglishChineseStub(URL);
			EnglishChineseStub.TranslatorString translator = new EnglishChineseStub.TranslatorString();
			translator.setWordKey(word);
			TranslatorStringResponse translatorString = stub.translatorString(translator);
			ArrayOfString stringResult = translatorString.getTranslatorStringResult();
			String[] strings = stringResult.getString();
			Arrays.asList(strings).forEach(t->System.out.println(t));
		} catch (AxisFault e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
