##  공학용 계산기 팀 프로젝트
##### 날짜: 2020.05.10 | 작성자: 김지호 | Version: 1.0

------------------------------------

## 1. 요구사항 분석 (Requirement Analysis)
- 공학용 계산기 구현
- 안드로이드 애플리케이션으로 구현

## 2. 구조 설계 (Structure Design)
### 1) UML(Unified Modeling Language) Diagram
#### (1) Use Case Diagram
<img src="https://github.com/Kim-Ziho/KSA_Calculator/blob/main/UML_Diagram/usecaseDiagram.png"
width="600px" height="400px" title="Use Case Diagram" alt="Use Case Diagram"></img><br/>

#### (2) Sequence Diagram
<img
src="https://github.com/Kim-Ziho/KSA_Calculator/blob/main/UML_Diagram/sequenceDiagram.png"
width="600px" height="400px" title="Sequence Diagram" alt="Sequence Diagram"></img><br/>

#### (3) Class Diagram
<img src="https://github.com/Kim-Ziho/KSA_Calculator/blob/main/UML_Diagram/ClassDiagram.png"
width="800px" height="400px" title="Class Diagram" alt="Class Diagram"></img><br/>


### 2) 클래스 생성
* InputOutput 클래스
  - 수식의 연산 우선 순위의 HashMap, 연산자 Stack, 피연산자 Stack, 후위 연산 표기법으로 변환된 문자열의 ArrayList, 입력받은 수식 문자열 ArrayList의 자료구조를 필드로 갖고 있다.
  - 연산자의 우선순위를 결정해주기 위해 초기화 한다.
  - 출력할 때 필요한 메서드(popNumStack)를 포함한다.
  - numstack이 비었는지 확인하는 메서드(isEmptyNumStack)를 포함한다.
  - 입력된 수식의 연산자와 피연산자(숫자)를 분류하는 메서드(inputFunction)를 포함한다.
  - 후위 연산식으로 만드는 메서드(postFixFunction)을 포함한다.
  - 연산자에 따라서 연산식을 수행하는 메서드(calculatorFunction)를 포함한다.
  - 올바른 연산자인지 아닌지 판별하는 메서드(isOperation)을 포함한다.
  
* Operation 클래스
  - 입력으로 들어오는 연산자에 따라서 수식을 연산하는 기능을 포함하고 있다.
  - 기본적인 사칙연산(덧셈, 뺄셈 ,곱셈 ,나눗셈)을 구현하는 메서드를 포함하고 있다. 
  - 추가적으로 상용로그 연산, 지수 연산, 진법 변환, 팩토리얼, 제곱근 연산, 삼각함수 연산, 절댓값 변환을 포함하고 있다.
     
* ConvertFunc 클래스
  -   사용자가 입력한 수식의 연산한 결과값을 분수를 소수로 변환하고, 소수는 최대공약수를 이용해서 분수로 변환하는 메소드을 포함하고 있다.
     
* History 클래스
 -   사용자가 입력한 수식을 연산한 결과값을 문자열(String)에 맨 마지막에 한 줄 띄어쓰기(“\n”)를 붙여 넣고 그 문자열을 반환하는 메서드를 포함하고 있다.

* MainActivity 클래스
  - 필드: Button 위젯의 id들을 선언, TextView 위젯의 id들을 선언, ScrollView 위젯의 id를 선언하고 있다.
  - 필드: InputOutput 클래스 선언, History 클래스 선언, ConvertFunc 클래스선언, 문자열 타입의 operExpression, input, historyData, comp 선언, double(실수형)타입의 result 선언하고 있다.
  - onCreate 메서드, init 메서드, setNumListener 메서드, onClick 메서드, setOperationListener 메서드를 포함하고 있다.


### 3) 기능(함수)
* InputOutput 클래스 안에 있는 메서드
  - init 메서드: ArrayList로 선언된 output과 inputString을 초기화하고 객체를 생성한다.
  - popNumStack 메서드 : 출력할때 numStack의 숫자를 하나씩 pop해주는 메서드
  - isEmptyStack 메서드 : numStack이 비었는지 여부를 확인하는 메서드
  - inputFunction 메서드: 입력된 수식(문자열)을 연산자와 피연산자(숫자)로 분류하는 메서드
  - postFixFunction 메서드: 입력된 수식(문자열)을 inputFunction메서드를 통해 연산자와 피연산자로 분류된 후, 후위 연산식으로 만드는 메서드
  - calculatorFunction 메서드: 입력된 수식(문자열)에서 연산자에 따라 연산을 진행하는 메서드
  - isOperation 메서드: HashMap에 저장되어 있는 올바른 연산자인지 아닌지 판별하는 메서드

* Operation 클래스 안에 있는 메서드
  - operationPlus 메서드 : 입력된 숫자(피연산자) 2개를 사용하여 덧셈한다.
  - operationMinus 메서드 : 입력된 숫자(피연산자) 2개를 사용하여 뺄셈하는 메서드(뻬고자 하는 숫자에 -1을 곱하여 덧셈을 한다.)
  - operationMulti 메서드 : 입력된 숫자(피연산자) 2개를 사용하여 곱한다.
  - operationDiv 메서드 : 입력된 숫자(피연산자) 2개를 사용하여 나눈다.
  - operationMod 메서드: 입력된 숫자(피연산자) 2개를 사용하여 나머지 값을 구한다.
  - operationLog10 메서드 : 입력된 숫자(피연산자)1개를 사용하여 상용로그(10을 밑으로 하는 로그 함수) 함수 값을 구한다.
  - operationSqrt 메서드: 입력된 숫자(피연산자)1개를 사용하여 제곱근을 반환한 값을 구한다.
  - operationInvolution 메서드: 입력된 숫자(피연산자)2개를 사용하여 x에 y승을 계산을 반환하여 값을 구한다.
  - operationFactorial 메서드: 입력된 숫자(피연산자)1개(n)를 사용하여 1에서 n까지의 모든 자연수의 곱을 계산한 값을 구한다.
  - operationTrigono 메서드:  입력된 숫자(피연산자)1개를 사용하여 사인, 코사인, 탄젠트를 계산한 값을 구한다.
  - operationAbs 메서드: 입력된 숫자(피연산자)1개를 사용하여 절대값을 구한다.
  - operationToDeposition 메서드 : 입력된 숫자(피연산자)1개를 사용하여 2진수,8진수,16진수 변환된 값을 구한다.
* ConvertFunc 클래스 안에 있는 메서드
  - convertSelect 메서드 : 입력된 문자를 ".","/"을 기준으로  소수-> 분수 , 분수 -> 소수를 바꾸는 것을 선택 할 수 있다.
  - operationFraction 메서드: 입력된 문자를 소수에서 분수로 바꿀 수 있다.
  - operationRealNum 메서드: 입력된 문자를 분수에서 소수로 바꿀 수 있다.
  - operationGcd 메서드 : 유클리드 호제법을 이용하여 최대 공약수를 구할 수 있다. 

* History 클래스 안에 있는 메서드
  - histoyFunction 메서드  

* MainActivity 클래스 안에 있는 메서드
  - @Override OnCreate 메서드: Button 리소스를 연결하기 위한 초기화(init), Button 리스너(setNumListener, setOperationListener)를 호출하고 있다.
  - init 메서드: Button을 각각의 기능과 연결해주고 하고 있다. 또한 InputOutput 객체와 History 객체, ConvertFunc 객체를 생성하고 operExpression, input, result, comp 변수를 초기화한다.
  - setNumListener 메서드: 리스너 정의를 한다.
  - @Override onClick 메서드: 숫자 버튼이 눌렸을 때, Button의 id 값에 따라서 수식을 저장하는 변수(operExpression)에 숫자 문자열(0~9)을 저장한다. 저장된 연산식이 화면에 출력되도록 한다. 각   Button 객체의 setOnClickListener 함수를 통해 이벤트 리스너를 등록한다.
  - setOperationListener 메서드: 리스너 정의를 한다.
  - @Override onClick 메서드: 연산자 버튼이 눌렸을 때, Button의 id값에 따라서 수식을 저장하는 변수(operExpression)에 연산자, 괄호, 소수점(+, -, *, /, mod, ^, conv(,π , Sqrt( , Abs( ,   trigono( ,log(, !, (,), ., =)을 저장한다. 
  - '=' 연산자를 누르면 History에 저장되도록 한다. InputOutput객체의 numStack을 확인하여 삼각함수 연산이거나 진법 변환 연산일 경우, numStack에 담아놓은 값 3개를 pop하여 historyDisplay에   보이게 한다.
  - ‘S<=>D’버튼을 누르면 현재 입력된 수식이 소수인지 분수인지 확인하여 소수면 분수로 변환, 분수면 소수로 변환하여 연산식이 출력되도록 한다.
  -'del'버튼을 누르면 해당 수식에서 가장 마지막에 들어간 것이 지워진다. 'reset' 버튼을 누르면 해당 수식이 모두 없어지도록 한다. 저장된 연산식이 화면에 출력되도록 한다. 
  -각 Button 객체의 setOnClickListener 함수를 통해 이벤트 리스너를 등록한다.


### 4) 레이아웃
* activity_main.xml: 사용자가 보는 화면으로 출력되는 UI를 나타낸다. ScrollView 위젯, TextView 위젯, Button 위젯들을 포함하고 있다.


## 3. 입력/출력 데이터 정의 (Data Structure Design)
* 데이터 종류: 피연산자(실수, double), 연산자(Character), Button 위젯 기능(0~9 정수, 소수점, 파이, 연산자(+,-,*,/,%,mod,log10,pow,factorial, Sqrt, Abs, Trigono), 진법변환, ConvertSD,  reset, delete), 수식(문자열, String)
* 입력: Button 위젯(피연산자, 연산자, 진법변환, ConvertSD, reset, delete)
* 출력: Textview 위젯(수식 계산한 결과값(문자열, String), 이전 계산 결과값(문자열, String)), ScrollView 위젯(history 기능으로 이전 계산 결과값이 쌓일 때 출력)



## 4. 테스트 이미지 (Test)
* 애플리케이션 run
:시작 화면
이미지

* 애플리케이션 숫자 입력

:1234567890

<img src="https://github.com/pguhn9/KSA_Scientific_Calculator/blob/main/Image/start.png" width="400px" height="850px" title="start" alt="start"></img><br/>

* 애플리케이션 덧셈 연산

:17+22

<img src="https://github.com/pguhn9/KSA_Scientific_Calculator/blob/main/Image/plus.PNG" width="400px" height="850px" title="plus" alt="plus"></img><br/>

* 애플리케이션 뺄셈 연산

:39-40

<img src="https://github.com/pguhn9/KSA_Scientific_Calculator/blob/main/Image/minus.PNG" width="400px" height="850px" title="minus" alt="minus"></img><br/>

* 애플리케이션 곱셈 연산

:9*12

<img src="https://github.com/pguhn9/KSA_Scientific_Calculator/blob/main/Image/mult.PNG" width="400px" height="850px" title="mult" alt="mult"></img><br/>

* 애플리케이션 나눗셈 연산

:40/4

<img src="https://github.com/pguhn9/KSA_Scientific_Calculator/blob/main/Image/div.PNG" width="400px" height="850px" title="div" alt="div"></img><br/>

* 애플리케이션 나머지 연산

:13mod3

<img src="https://github.com/pguhn9/KSA_Scientific_Calculator/blob/main/Image/mod.PNG" width="400px" height="850px" title="mod" alt="mod"></img><br/>

* 애플리케이션 상용로그 연산 (log)

:log(100)

<img src="https://github.com/pguhn9/KSA_Scientific_Calculator/blob/main/Image/log10.PNG" width="400px" height="850px" title="log10" alt="log10"></img><br/>

* 애플리케이션 거듭제곱 연산

:3^4

<img src="https://github.com/pguhn9/KSA_Scientific_Calculator/blob/main/Image/pow.PNG" width="400px" height="850px" title="pow" alt="pow"></img><br/>

* 애플리케이션 팩토리얼 연산

:5!

<img src="https://github.com/pguhn9/KSA_Scientific_Calculator/blob/main/Image/Factorial.PNG" width="400px" height="850px" title="Factorial" alt="Factorial"></img><br/>

* 애플리케이션 소수점 연산

:1.1+3.4

<img src="https://github.com/pguhn9/KSA_Scientific_Calculator/blob/main/Image/dotplus.PNG" width="400px" height="850px" title="dotplus" alt="dotplus"></img><br/>

* 애플리케이션 괄호 연산

:5+2*(9-4)

<img src="https://github.com/pguhn9/KSA_Scientific_Calculator/blob/main/Image/operation.PNG" width="400px" height="850px" title="operation" alt="operation"></img><br/>

* 애플리케이션 절대값 연산

:Abs(-9)

<img src="https://github.com/pguhn9/KSA_Scientific_Calculator/blob/main/Image/abs.PNG" width="400px" height="850px" title="abs" alt="abs"></img><br/>

* 애플리케이션 삼각함수 연산

:Trigono(90)

<img src="https://github.com/pguhn9/KSA_Scientific_Calculator/blob/main/Image/trigono.PNG" width="400px" height="850px" title="trigono" alt="trigono"></img><br/>

* 애플리케이션 제곱근 연산

:Sqrt(16)

<img src="https://github.com/pguhn9/KSA_Scientific_Calculator/blob/main/Image/sqrt.PNG" width="400px" height="850px" title="sqrt" alt="sqrt"></img><br/>

* 애플리케이션 소수<->분수 기능

:4.12 <-> 103/25

<img src="https://github.com/pguhn9/KSA_Scientific_Calculator/blob/main/Image/fraction1.PNG" width="400px" height="850px" title="fraction1" alt="fraction1"></img><br/>
<img src="https://github.com/pguhn9/KSA_Scientific_Calculator/blob/main/Image/fraction2.PNG" width="400px" height="850px" title="fraction2" alt="fraction2"></img><br/>


* 애플리케이션 진법변환 기능

:Conv(18)

<img src="https://github.com/pguhn9/KSA_Scientific_Calculator/blob/main/Image/conv.PNG" width="400px" height="850px" title="conv" alt="conv"></img><br/>

* 애플리케이션 Delete 기능

:12345678

<img src="https://github.com/pguhn9/KSA_Scientific_Calculator/blob/main/Image/del.PNG" width="400px" height="850px" title="del" alt="del"></img><br/>

* 애플리케이션 Reset 기능

:CE

<img src="https://github.com/pguhn9/KSA_Scientific_Calculator/blob/main/Image/clear.PNG" width="400px" height="850px" title="clear" alt="clear"></img><br/>

* 애플리케이션 History 기능

:이전 연산 결과

<img src="https://github.com/pguhn9/KSA_Scientific_Calculator/blob/main/Image/history.PNG" width="400px" height="850px" title="history" alt="history"></img><br/>


