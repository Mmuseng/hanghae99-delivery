package com.hanghae.delivery.domain;

public class ExceptionMessage extends RuntimeException{
    //음식점 에러 메세지
    public static final String EXCEPTION_MIN_PRICE_ERROR = "허용된 가격값이 아닙니다.";
    public static final String EXCEPTION_MIN_UNIT_ERROR = "음식 가격은 100원단위로 입력해주세요.";
    public static final String EXCEPTION_FEE_PRICE_ERROR = "허용된 배달값이 아닙니다.";
    public static final String EXCEPTION_FEE_UNIT_ERROR = "배달비는 500원단위로 입력해주세요.";

    //메뉴판 에러 메세지
    public static final String EXCEPTION_SAME_MENU_ERROR = "같은 이름의 메뉴가 있습니다.";
    public static final String EXCEPTION_DUPLE_MENU_ERROR = "중복된 메뉴가 있습니다.";
    public static final String EXCEPTION_MIN_MENU_ERROR = "허용된 가격값이 아닙니다.";
    public static final String EXCEPTION_UNIT_MENU_ERROR = "음식 가격은 100원단위로 입력해주세요.";

    //주문 에러 메세지
    public static final String EXCEPTION_QUANTITY_ERROR = "주문 가능한 수량이 아닙니다.";
    public static final String EXCEPTION_TOTAL_MIN_PRICE_ERROR = "주문하신 총 가격이 최소주문 가격보다 낮습니다.";
}