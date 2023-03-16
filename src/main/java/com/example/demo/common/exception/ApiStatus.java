package com.example.demo.common.exception;

import org.springframework.http.HttpStatus;

/**
 * API 응답상태
 */
public enum ApiStatus {

    // ------------------------------------------------------------------------
    // 통신 응답부
    // ------------------------------------------------------------------------
    // 통신 성공
    HTTP_OK("Success", "Ok", HttpStatus.OK),
    // 통신 실패
    HTTP_NOT_MODIFIED("Fail", "NotModified", HttpStatus.NOT_MODIFIED),
    // 통신 실패
    HTTP_BAD_REQUEST("Fail", "BadRequest", HttpStatus.BAD_REQUEST),
    // 통신 실패
    HTTP_UNAUTHORIZED("Fail", "Unauthorized", HttpStatus.UNAUTHORIZED),
    // 통신 실패
    HTTP_DENIED("Fail", "Denied", HttpStatus.FORBIDDEN),
    // 통신 실패
    HTTP_NOTFOUND("Fail", "NotFound", HttpStatus.NOT_FOUND),
    // 통신 실패 서버
    HTTP_INTERNAL_SERVER_ERROR("Fail", "InternalServerError", HttpStatus.INTERNAL_SERVER_ERROR),

    // ------------------------------------------------------------------------
    // 업무 응답부
    // ------------------------------------------------------------------------
    // 업무 공통응답 성공
    AP_SUCCESS("success", "성공하였습니다.", HttpStatus.OK),
    // 업무 공통응답 실패
    AP_FAIL("fail", "", HttpStatus.OK),

    // 공통응답 성공 (리턴코드 숫자)
    AP_SUCCESS_0("0", "", HttpStatus.OK),

    // 공통응답 실패 (리턴코드 숫자)
    AP_FAIL_9("9", "", HttpStatus.OK);

    /**
     * 응답코드. 문자열. Success, Fail
     */
    private String code;

    /**
     * 응답메시지. 문자열. 응답설명
     */
    private String message;

    /**
     * 응답의 HTTP Status 객체. HttpStatus.
     */
    private HttpStatus status;

    /**
     * 응답상태 설정
     * @param code
     * @param message
     * @param status
     */
    ApiStatus(String code, String message, HttpStatus status) {
        this.code = code;
        this.message = message;
        this.status = status;
    };

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getHttpStatus() {
        return status;
    }
}
