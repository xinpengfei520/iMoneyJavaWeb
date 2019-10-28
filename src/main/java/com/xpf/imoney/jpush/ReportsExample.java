package com.xpf.imoney.jpush;

import cn.jiguang.common.TimeUnit;
import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jpush.api.JPushClient;
import cn.jpush.api.report.*;
import cn.jpush.api.report.model.CheckMessagePayload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class ReportsExample {
    protected static final Logger LOG = LoggerFactory.getLogger(ReportsExample.class);

    // demo App defined in resources/jpush-api.conf 
	private static final String appKey = "7b4b94cca0d185d611e53cca";
	private static final String masterSecret = "860803cf613ed54aa3b941a8";
    public static final String REGISTRATION_ID1 = "0900e8d85ef";
    public static final String REGISTRATION_ID2 = "0a04ad7d8b4";
    public static final String REGISTRATION_ID3 = "18071adc030dcba91c0";

	public static void main(String[] args) {

//        testGetReceivedsDetail();
        testGetMessagesDetail();
//		testGetReport();
//		testGetMessages();
//		testGetUsers();
		testGetMessageStatus();
	}
	
    
	public static void testGetReport() {
        JPushClient jpushClient = new JPushClient(masterSecret, appKey);
		try {
            ReceivedsResult result = jpushClient.getReportReceiveds("1942377665");
            LOG.debug("Got result - " + result);
            
        } catch (APIConnectionException e) {
            LOG.error("Connection error. Should retry later. ", e);
            
        } catch (APIRequestException e) {
            LOG.error("Error response from JPush server. Should review and fix it. ", e);
            LOG.info("HTTP Status: " + e.getStatus());
            LOG.info("Error Code: " + e.getErrorCode());
            LOG.info("Error Message: " + e.getErrorMessage());
        }
	}

    public static void testGetUsers() {
        JPushClient jpushClient = new JPushClient(masterSecret, appKey);
        try {
            UsersResult result = jpushClient.getReportUsers(TimeUnit.DAY, "2014-06-10", 3);
            LOG.debug("Got result - " + result);

        } catch (APIConnectionException e) {
            LOG.error("Connection error. Should retry later. ", e);
            
        } catch (APIRequestException e) {
            LOG.error("Error response from JPush server. Should review and fix it. ", e);
            LOG.info("HTTP Status: " + e.getStatus());
            LOG.info("Error Code: " + e.getErrorCode());
            LOG.info("Error Message: " + e.getErrorMessage());
        }
    }

    public static void testGetMessages() {
        JPushClient jpushClient = new JPushClient(masterSecret, appKey);
        try {
            MessagesResult result = jpushClient.getReportMessages("269978303");
            LOG.debug("Got result - " + result);
            
        } catch (APIConnectionException e) {
            LOG.error("Connection error. Should retry later. ", e);
            
        } catch (APIRequestException e) {
            LOG.error("Error response from JPush server. Should review and fix it. ", e);
            LOG.info("HTTP Status: " + e.getStatus());
            LOG.info("Error Code: " + e.getErrorCode());
            LOG.info("Error Message: " + e.getErrorMessage());
        }
    }

    public static void testGetMessageStatus() {
        JPushClient jPushClient = new JPushClient(masterSecret, appKey);
        CheckMessagePayload payload = CheckMessagePayload.newBuilder()
                .setMsgId(3993287034L)
                .addRegistrationIds(REGISTRATION_ID1, REGISTRATION_ID2, REGISTRATION_ID3)
                .setDate("2017-08-08")
                .build();
        try {
            Map<String, MessageStatus> map = jPushClient.getMessageStatus(payload);
            for (Map.Entry<String, MessageStatus> entry : map.entrySet()) {
                LOG.info("registrationId: " + entry.getKey() + " status: " + entry.getValue().getStatus());
            }
        } catch (APIConnectionException e) {
            LOG.error("Connection error. Should retry later. ", e);
        } catch (APIRequestException e) {
            LOG.error("Error response from JPush server. Should review and fix it. ", e);
            LOG.info("HTTP Status: " + e.getStatus());
            LOG.info("Error Code: " + e.getErrorCode());
            LOG.info("Error Message: " + e.getErrorMessage());
        }
    }

    /**
     * 消息统计
     * https://docs.jiguang.cn/jpush/server/push/rest_api_v3_report/#vip
     */
    public static void testGetMessagesDetail() {

        JPushClient jPushClient = new JPushClient(masterSecret, appKey);
        String msgIds = "3993287034,3993287035,3993287036";
        try {
            MessageDetailResult result = jPushClient.getMessagesDetail(msgIds);
            LOG.info("msgIds: {}, MessageDetail: {}", msgIds, result.received_list);
        } catch (APIConnectionException e) {
            LOG.error("Connection error. Should retry later. ", e);
        } catch (APIRequestException e) {
            LOG.error("Error response from JPush server. Should review and fix it. ", e);
            LOG.info("HTTP Status: " + e.getStatus());
            LOG.info("Error Code: " + e.getErrorCode());
            LOG.info("Error Message: " + e.getErrorMessage());
        }

    }

    /**
     * 送达详情
     * https://docs.jiguang.cn/jpush/server/push/rest_api_v3_report/#_7
     */
    public static void testGetReceivedsDetail() {

        JPushClient jPushClient = new JPushClient(masterSecret, appKey);
        String msgIds = "3993287034,3993287035,3993287036";
        try {
            ReceivedsResult result = jPushClient.getReceivedsDetail(msgIds);
            LOG.info("msgIds: {}, ReceivedsDetail: {}", msgIds, result);
        } catch (APIConnectionException e) {
            LOG.error("Connection error. Should retry later. ", e);
        } catch (APIRequestException e) {
            LOG.error("Error response from JPush server. Should review and fix it. ", e);
            LOG.info("HTTP Status: " + e.getStatus());
            LOG.info("Error Code: " + e.getErrorCode());
            LOG.info("Error Message: " + e.getErrorMessage());
        }
    }

}

