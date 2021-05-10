package com.example.calc;

import com.example.calc.Operation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class InputOutput {

    HashMap<String, Integer> opPriority;
    List<String> output = new ArrayList<>();
    List<String> inputString = new ArrayList<>();

    {
        /** 우선순위 **/
        opPriority = new HashMap<>();
        opPriority.put("(", 0);
        opPriority.put("+",1);
        opPriority.put("-", 1);
        opPriority.put("*", 2);
        opPriority.put("/", 2);
        opPriority.put("m", 2);
        opPriority.put("^", 2);
        opPriority.put("l", 3);
        opPriority.put("e", 3);
        opPriority.put("!", 3);
        opPriority.put("s", 3);
        opPriority.put("c", 3);
        opPriority.put("t", 3);
    }




    void init() {
        if(!output.isEmpty()){
            output.clear();
        }
        if(!inputString.isEmpty()){
            inputString.clear();
        }
        output = new ArrayList<>();
        inputString = new ArrayList<>();

    }




    Double inputFunction(String input) {
        init();
        int lastIndex = 0;


        //연산자와 숫자 분류
        for (int i=0; i<input.length(); i++) {
            char c = input.charAt(i);

            //연산자일 때
            if(isOperation(c+"")) {
                inputString.add(c+"");
            }
            //피연산자일 때
            else {
                lastIndex = inputString.size()-1;

                if(inputString.isEmpty() || isOperation(inputString.get(lastIndex))) {
                    inputString.add(c+"");
                }
                else {
                    inputString.set(lastIndex, inputString.get(lastIndex)+c);
                }
            }
        }
        return priorityFunction();
    }


    Double priorityFunction() {
        Stack<String> opStack = new Stack<>();


        //후위 연산식으로 만들기
        for (int i=0; i<inputString.size(); i++){
            String s = inputString.get(i);


            //연산자일 경우
            if (isOperation(s)){

                //여는 괄호일 경우
                //push
                if (s.equals("(")){
                    opStack.push(s);
                }
                //닫는 괄호일 경우
                //여는 괄호가 나올때까지 pop
                else if (s.equals(")")){
                    String top = opStack.pop();
                    while (!top.equals("(")){
                        output.add(top);
                        top = opStack.pop();
                    }
                }
                //그 외 연산자일 경우
                else{

                    //우선순위가 높거나 같으면 pop
                    while(!opStack.isEmpty() && opPriority.get(opStack.peek()) >= opPriority.get(s)) {
                        output.add(opStack.pop());
                    }
                    //우선순위가 낮거나 스택이 비어있으면 push
                    opStack.push(s);
                }
            }
            else{
                //피연산자일 경우
                output.add(s);
            }

        }
        //stack에 남아있는 연산자 출력
        while (!opStack.isEmpty()){
            output.add(opStack.pop());
        }
        System.out.print(output);

        return calculatorFunction();
    }



    Double calculatorFunction() {
        Double num1, num2 = 0.0;
        Stack<String> numStack = new Stack<>();
        Operation operation = new Operation();
        for(int i=0; i<output.size(); i++ ){
            String s = output.get(i);

            if(isOperation(s)) {
                switch(s) {
                    case "+":
                        if(numStack.size()>1) {
                            num2 = Double.parseDouble(numStack.pop());
                            num1 = Double.parseDouble(numStack.pop());
                            num1 = operation.plus(num1, num2);
                            numStack.add(num1+"");
                        }
                        break;
                    case "-":
                        if(numStack.size()>1) {
                            num2 = Double.parseDouble(numStack.pop());
                            num1 = Double.parseDouble(numStack.pop());
                            num1 = operation.minus(num1, num2);
                            numStack.add(num1 + "");
                        }
                        break;
                    case "*":
                        if(numStack.size()>1) {
                            num2 = Double.parseDouble(numStack.pop());
                            num1 = Double.parseDouble(numStack.pop());
                            num1 = operation.multiplication(num1, num2);
                            numStack.add(num1 + "");
                        }
                        break;
                    case "/":
                        if(numStack.size()>1) {
                            num2 = Double.parseDouble(numStack.pop());
                            num1 = Double.parseDouble(numStack.pop());
                            num1 = operation.division(num1, num2);
                            numStack.add(num1 + "");
                        }
                        break;
                    case "m":
                        if(numStack.size()>1) {
                            num2 = Double.parseDouble(numStack.pop());
                            num1 = Double.parseDouble(numStack.pop());
                            num1 = operation.mod(num1, num2);
                            numStack.add(num1 + "");
                        }
                        break;
                    case "^":
                        if(numStack.size()>1) {
                            num2 = Double.parseDouble(numStack.pop());
                            num1 = Double.parseDouble(numStack.pop());
                            num1 = operation.involutionFunction(num1, num2);
                            numStack.add(num1 + "");
                        }
                        break;
                    case "l":
                        if(numStack.size()>0) {
                            num2 = Double.parseDouble(numStack.pop());
                            num1 = operation.commonLogFunction(num2);
                            numStack.add(num1 + "");
                        }
                        break;
                    case "e":
                        if(numStack.size()>0) {
                            num2 = Double.parseDouble(numStack.pop());
                            num1 = operation.expFunction(num2);
                            numStack.add(num1 + "");
                        }
                        break;
                    case "!":
                        if(numStack.size()>0) {
                            num2 = Double.parseDouble(numStack.pop());
                            num1 = operation.factorialFunction(num2);
                            numStack.add(num1 + "");
                        }
                        break;
                        // 삼각함수 made by 지호
                    case "s":
                        if(numStack.size()>0) {
                            num2 = Double.parseDouble(numStack.pop());
                            num1 = operation.sinFunction(num2);
                            numStack.add(num1 + "");
                        }
                        break;
                    case "c":
                        if(numStack.size()>0) {
                            num2 = Double.parseDouble(numStack.pop());
                            num1 = operation.cosFunction(num2);
                            numStack.add(num1 + "");
                        }
                        break;
                    case "t":
                        if(numStack.size()>0) {
                            num2 = Double.parseDouble(numStack.pop());
                            num1 = operation.tanFunction(num2);
                            numStack.add(num1 + "");
                        }
                        break;
                }
            }
            else {
                numStack.push(s);
            }
        }
        if(!numStack.isEmpty()) {
            System.out.print(numStack.get(0));
            return Double.parseDouble(numStack.get(0));
        }else{
            return Double.parseDouble("0");
        }
    }




    //연산자 여부
    boolean isOperation(String s){
        if(s.equals(")")){
            return true;
        }
        return opPriority.containsKey(s);
    }
}
