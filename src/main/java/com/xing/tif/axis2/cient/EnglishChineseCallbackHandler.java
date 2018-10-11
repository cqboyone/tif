/**
 * EnglishChineseCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.4  Built on : Dec 28, 2015 (10:03:39 GMT)
 */
package com.xing.tif.axis2.cient;


/**
 *  EnglishChineseCallbackHandler Callback class, Users can extend this class and implement
 *  their own receiveResult and receiveError methods.
 */
public abstract class EnglishChineseCallbackHandler {
    protected Object clientData;

    /**
     * User can pass in any object that needs to be accessed once the NonBlocking
     * Web service call is finished and appropriate method of this CallBack is called.
     * @param clientData Object mechanism by which the user can pass in user data
     * that will be avilable at the time this callback is called.
     */
    public EnglishChineseCallbackHandler(Object clientData) {
        this.clientData = clientData;
    }

    /**
     * Please use this constructor if you don't want to set any clientData
     */
    public EnglishChineseCallbackHandler() {
        this.clientData = null;
    }

    /**
     * Get the client data
     */
    public Object getClientData() {
        return clientData;
    }

    /**
     * auto generated Axis2 call back method for translatorString method
     * override this method for handling normal response from translatorString operation
     */
    public void receiveResulttranslatorString(
        com.xing.tif.axis2.cient.EnglishChineseStub.TranslatorStringResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from translatorString operation
     */
    public void receiveErrortranslatorString(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for translatorSentenceString method
     * override this method for handling normal response from translatorSentenceString operation
     */
    public void receiveResulttranslatorSentenceString(
        com.xing.tif.axis2.cient.EnglishChineseStub.TranslatorSentenceStringResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from translatorSentenceString operation
     */
    public void receiveErrortranslatorSentenceString(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for translator method
     * override this method for handling normal response from translator operation
     */
    public void receiveResulttranslator(
        com.xing.tif.axis2.cient.EnglishChineseStub.TranslatorResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from translator operation
     */
    public void receiveErrortranslator(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for getMp3 method
     * override this method for handling normal response from getMp3 operation
     */
    public void receiveResultgetMp3(
        com.xing.tif.axis2.cient.EnglishChineseStub.GetMp3Response result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from getMp3 operation
     */
    public void receiveErrorgetMp3(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for suggestWord method
     * override this method for handling normal response from suggestWord operation
     */
    public void receiveResultsuggestWord(
        com.xing.tif.axis2.cient.EnglishChineseStub.SuggestWordResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from suggestWord operation
     */
    public void receiveErrorsuggestWord(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for translatorReferString method
     * override this method for handling normal response from translatorReferString operation
     */
    public void receiveResulttranslatorReferString(
        com.xing.tif.axis2.cient.EnglishChineseStub.TranslatorReferStringResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from translatorReferString operation
     */
    public void receiveErrortranslatorReferString(java.lang.Exception e) {
    }
}
