package com.example.vrt.global.status;

import com.example.vrt.global.BaseErrorCode;
import com.example.vrt.global.ErrorReasonDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorStatus implements BaseErrorCode {

    // 가장 일반적인 응답
    _INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "COMMON500", "서버 에러, 관리자에게 문의 바랍니다."),
    _BAD_REQUEST(HttpStatus.BAD_REQUEST,"COMMON400","잘못된 요청입니다."),
    _UNAUTHORIZED(HttpStatus.UNAUTHORIZED,"COMMON401","인증이 필요합니다."),
    _FORBIDDEN(HttpStatus.FORBIDDEN, "COMMON403", "금지된 요청입니다."),

    // 퀴즈 관련 에러
    QUIZ_NOT_FOUND(HttpStatus.BAD_REQUEST, "QUIZ4001", "존재하지 않는 퀴즈입니다."),
    USER_QUIZ_ALREADY_SOLVED(HttpStatus.BAD_REQUEST, "QUIZ4002", "이미 푼 퀴즈입니다."),
    REVIEW_ALREADY_ADDED(HttpStatus.BAD_REQUEST, "QUIZ4003", "이미 복습 리스트에 추가된 퀴즈입니다."),
    QUIZ_LOCKED(HttpStatus.FORBIDDEN, "QUIZ4004", "잠겨있는 퀴즈입니다."),
    INVALID_QUIZ_ANSWER(HttpStatus.BAD_REQUEST, "QUIZ4005", "잘못된 퀴즈 답안입니다."),
    QUIZ_SEARCH_NO_RESULTS(HttpStatus.BAD_REQUEST, "QUIZ4006", "검색 결과가 없습니다."),
    QUIZ_REVIEW_NOT_FOUND(HttpStatus.BAD_REQUEST, "QUIZ4004", "복습 리스트에 해당 퀴즈가 존재하지 않습니다."),
    QUIZ_NOT_SOLVED(HttpStatus.BAD_REQUEST, "QUIZ4008", "풀지 않은 문제는 복습 리스트에 추가할 수 없습니다."),

    // 사용자 관련 에러
    USER_ALREADY_EXISTS(HttpStatus.BAD_REQUEST, "USER4001", "이미 존재하는 사용자입니다."),
    INVALID_CREDENTIALS(HttpStatus.UNAUTHORIZED, "USER4002", "이메일 또는 비밀번호가 올바르지 않습니다."),
    TOKEN_NOT_FOUND(HttpStatus.UNAUTHORIZED, "USER4003", "토큰이 존재하지 않습니다."),
    TOKEN_INVALID(HttpStatus.UNAUTHORIZED, "USER4004", "유효하지 않은 토큰입니다."),
    TOKEN_EXPIRED(HttpStatus.UNAUTHORIZED, "USER4005", "만료된 토큰입니다."),
    REFRESH_TOKEN_NOT_FOUND(HttpStatus.UNAUTHORIZED, "USER4006", "Refresh Token이 존재하지 않습니다."),
    USER_NOT_FOUND(HttpStatus.BAD_REQUEST, "USER4007", "존재하지 않는 사용자입니다."),
    INVALID_REFRESH_TOKEN(HttpStatus.UNAUTHORIZED, "USER4008", "유효하지 않은 Refresh Token입니다."),
    JOIN_DATE_ALREADY_REGISTERED(HttpStatus.BAD_REQUEST, "USER4012", "이미 입사일이 등록된 사용자입니다."),

    // 업무 용어 관련 에러
    VOCA_NOT_FOUND(HttpStatus.NOT_FOUND, "VOCA4041", "해당 업무 용어를 찾을 수 없습니다."),
    VOCA_LIST_NOT_FOUND(HttpStatus.NOT_FOUND, "VOCA4042", "해당 카테고리의 업무 용어 리스트를 찾을 수 없습니다."),
    VOCA_SEARCH_NO_RESULTS(HttpStatus.NOT_FOUND, "VOCA4043", "검색 결과가 없습니다."),
    VOCA_ALREADY_FAVORITED(HttpStatus.BAD_REQUEST, "VOCA4001", "이미 즐겨찾기에 추가된 용어입니다."),
    VOCA_FAVORITE_NOT_FOUND(HttpStatus.NOT_FOUND, "VOCA4044", "즐겨찾기에 없는 용어입니다."),

    // 매너 설명서 관련 에러
    MANNER_NOT_FOUND(HttpStatus.NOT_FOUND, "MANNER4041", "해당 매너 설명서를 찾을 수 없습니다."),
    MANNER_LIST_NOT_FOUND(HttpStatus.NOT_FOUND, "MANNER4042", "해당 카테고리의 매너 리스트를 찾을 수 없습니다."),
    MANNER_SEARCH_NO_RESULTS(HttpStatus.NOT_FOUND, "MANNER4043", "검색 결과가 없습니다."),
    MANNER_ALREADY_FAVORITED(HttpStatus.BAD_REQUEST, "MANNER4001", "이미 즐겨찾기에 추가된 매너입니다."),
    MANNER_FAVORITE_NOT_FOUND(HttpStatus.NOT_FOUND, "MANNER4044", "즐겨찾기에 없는 매너입니다."),

    // OAuth 관련 에러
    OAUTH_REQUEST_FAILED(HttpStatus.BAD_REQUEST, "OAUTH4001", "OAuth 요청 처리 중 에러가 발생했습니다."),
    OAUTH_UNSUPPORTED_PROVIDER(HttpStatus.BAD_REQUEST, "OAUTH4002", "지원하지 않는 소셜 로그인 방식입니다."),
    OAUTH_JSON_PARSE_ERROR(HttpStatus.BAD_REQUEST, "OAUTH4003", "OAuth 응답 파싱에 실패했습니다."),
    OAUTH_ACCESS_DENIED(HttpStatus.UNAUTHORIZED, "OAUTH4004", "OAuth 인증에 실패했습니다."),
    SOCIAL_PROVIDER_CONFLICT(HttpStatus.CONFLICT, "AUTH4004", "다른 소셜 로그인으로 이미 가입된 이메일입니다."),
    OAUTH_ACCESS_TOKEN_MISSING(HttpStatus.BAD_REQUEST, "OAUTH4005", "Access Token이 누락되었습니다."),
    OAUTH_USERINFO_FETCH_FAILED(HttpStatus.UNAUTHORIZED, "OAUTH4006", "소셜 사용자 정보를 가져오는 데 실패했습니다."),
    OAUTH_EMAIL_NOT_PROVIDED(HttpStatus.BAD_REQUEST, "OAUTH4007", "소셜 로그인에 이메일 정보가 포함되어 있지 않습니다."),
    OAUTH_REFRESH_TOKEN_SAVE_FAILED(HttpStatus.INTERNAL_SERVER_ERROR, "OAUTH5001", "Redis에 Refresh Token 저장에 실패했습니다."),

    // 인증코드 관련 에러
    CODE_EXPIRED(HttpStatus.BAD_REQUEST, "USER4009", "인증코드가 만료되었습니다."),
    CODE_MISMATCH(HttpStatus.BAD_REQUEST, "USER4010", "인증코드가 일치하지 않습니다."),

    // 비밀번호 변경 관리 에러
    PASSWORD_NOT_MATCH(HttpStatus.BAD_REQUEST, "USER4011", "새 비밀번호와 비밀번호 확인이 일치하지 않습니다."),

    // 모의고사 관련 에러
    MOCK_TEST_NOT_FOUND(HttpStatus.NOT_FOUND, "MOCK4041", "해당 모의고사를 찾을 수 없습니다."),
    // MOCK_TEST_ALREADY_SUBMITTED(HttpStatus.BAD_REQUEST, "MOCK4001", "이미 제출된 모의고사입니다."),
    MOCK_TEST_QUIZ_NOT_FOUND(HttpStatus.NOT_FOUND, "MOCK4042", "해당 모의고사 문제를 찾을 수 없습니다."),
    MOCK_TEST_USER_NOT_FOUND(HttpStatus.BAD_REQUEST, "MOCK4002", "해당 사용자의 모의고사를 찾을 수 없습니다.");

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    @Override
    public ErrorReasonDTO getReason() {
        return ErrorReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .build();
    }

    @Override
    public ErrorReasonDTO getReasonHttpStatus() {
        return ErrorReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .httpStatus(httpStatus)
                .build();
    }

}