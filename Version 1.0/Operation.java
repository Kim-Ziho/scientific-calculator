package com.example.calc;

public class Operation {

    // 사칙연산
    // 덧셈
    public double plus(double x, double y){
        return x+y;
    }

    // 뺄셈: -1을 곱한 것으로 변환
    public double minus(double x, double y){
        return x+(-1)*y;
    }

    // 곱셈
    public double multiplication(double x, double y){
        return x*y;
    }

    // 나눗셈
    public double division(double x, double y){
        return x/y;
    }

    // 나머지 연산
    public double mod(double x, double y){
        return x%y;
    }

    // exp() 지수 연산
    public double expFunction(double x){
        return Math.exp(x);
    }

    // 상용로그 연산
    public double commonLogFunction(double x){
        return Math.log10(x);
    }

    // 거듭제곱 연산
    public double involutionFunction(double x, double y) {
        return Math.pow(x,y);
    }

    // 팩토리얼 연산
    public double factorialFunction(double x) {
        if(x<=1) {
            return 1;
        }else {
            return factorialFunction(x - 1)*x;
        }
    }

    // 삼각함수 연산 made by 지호
    public double sinFunction(double x) { return Math.sin(Math.toRadians(x)); }
    public double cosFunction(double x) { return Math.cos(Math.toRadians(x)); }
    public double tanFunction(double x) { return Math.tan(Math.toRadians(x)); }
}