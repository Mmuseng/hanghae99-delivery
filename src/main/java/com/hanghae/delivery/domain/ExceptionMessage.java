package com.hanghae.delivery.domain;

public class ExceptionMessage extends RuntimeException{
    //음식점 에러 메세지
    public static final String EXCEPTION_MIN_PRICE_ERROR = "허용된 가격이 아닙니다.";
    public static final String EXCEPTION_MIN_UNIT_ERROR = "허용된 단위값이 아닙니다. 100원단위로 입력해주세요.";
    public static final String EXCEPTION_FEE_PRICE_ERROR = "허용된 배달값이 아닙니다.";
    public static final String EXCEPTION_FEE_UNIT_ERROR = "허용된 단위값이 아닙니다. 500원단위로 입력해주세요.";

    //메뉴판 에러 메세지
    public static final String EXCEPTION_SAME_MENU_ERROR = "같은 메뉴명이 있습니다.";
    public static final String EXCEPTION_DUPLE_MENU_ERROR = "중복된 메뉴명이 있습니다.";
    public static final String EXCEPTION_MIN_MENU_ERROR = "허용된 가격이 아닙니다.";
    public static final String EXCEPTION_UNIT_MENU_ERROR = "허용된 단위값이 아닙니다. 100원단위로 입력해주세요.";

    //주문 에러 메세지
    public static final String EXCEPTION_QUANTITY_ERROR = "주문 가능한 수량이 아닙니다.";
    public static final String EXCEPTION_TOTAL_MIN_PRICE_ERROR = "주문하신 총 가격이 최소주문 가격보다 낮습니다.";
}