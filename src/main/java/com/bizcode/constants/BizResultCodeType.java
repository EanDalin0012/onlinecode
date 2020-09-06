package com.bizcode.constants;

public enum BizResultCodeType {
    FILE_TYPE_CODE("01", "file type code for corp-banking"),
    CHANNEL_TYPE_CODE_CORP_BANKING("01", "Channel Type Code Corp Banking"),

    RESPONSE_SUCCESS_CODE("0000", "Response success code"),
    RESPONSE_SUCCESS_MESSAGE("Success", "Response success message"),

    RESPONSE_FAIL_CODE("0001", "Response fail code"),
    RESPONSE_FAIL_MESSAGE("Fail", "Response fail message"),

    RSA_SESSION_KEY("rsaCipher", "RSA session key"),
    AES_SESSION_KEY("aesCipher", "AES session key"),
    USR_SESSION_KEY("userSession", "User session key"),
    IP_SESSION_KEY("ipSession", "IP session key"),
    DT_SESSION_KEY("dtSession", "Session Date time key"),

    SERVICE_STATUS_ON_OFF_CODE("01", "Service status on/off code"),
    SERVICE_STATUS_TIME_CODE("11", "Service status time code"),
    SERVICE_STATUS_OFF_CODE("00", "Service status off code"),
    SERVICE_STATUS_ON_CODE("01", "Service status on code"),
    SERVICE_STATUS_NA_CODE("02", "Service status na code"),

    TRANSFER_MAX_LIMIT("1000", "Transfer max limit"),

    HEADER_CONTENT("Content-MD5", "Content MD5"),
    BODY("body", "body"),
    HEAD("header", "header"),

    ;

    final String value;
    final String description;

    private BizResultCodeType(String value, String description) {
        this.value = value;
        this.description = description;
    }

    public String getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }
}
