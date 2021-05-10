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
  - 입력된 수식의 연산자와 피연산자(숫자)를 분류하는 메서드(inputFunction)를 포함한다.
  - 후위 연산식으로 만드는 메서드(priorityFunction)을 포함한다.
  - 연산자에 따라서 연산식을 수행하는 메서드(calculatorFunction)를 포함한다.
  - 올바른 연산자인지 아닌지 판별하는 메서드(isOperation)을 포함한다.
  
* Operation 클래스
  - 입력으로 들어오는 연산자에 따라서 수식을 연산하는 기능을 포함하고 있다.
  - 기본적인 사칙연산(덧셈, 뺄셈 ,곱셈 ,나눗셈)을 구현하는 메서드를 포함하고 있다. 
  - 추가적으로 상용로그 연산, 지수 연산, 팩토리얼, 제곱근 연산, 삼각함수 연산을 포함하고 있다.
       
* History 클래스
 -   사용자가 입력한 수식을 연산한 결과값을 문자열(String)에 맨 마지막에 한 줄 띄어쓰기(“\n”)를 붙여 넣고 그 문자열을 반환하는 메서드를 포함하고 있다.

* MainActivity 클래스
  - 필드: Button 위젯의 id들을 선언, TextView 위젯의 id들을 선언, ScrollView 위젯의 id를 선언하고 있다.
  - 필드: InputOutput 클래스 선언, History 클래스 선언, 문자열 타입의 operExpression, input, historyData, double(실수형)타입의 result 선언하고 있다.
  - onCreate 메서드, init 메서드, setNumListener 메서드, onClick 메서드, setOperationListener 메서드를 포함하고 있다.


### 3) 기능(함수)
* InputOutput 클래스 안에 있는 메서드
  - init 메서드: ArrayList로 선언된 output과 inputString을 초기화하고 객체를 생성한다.
  - inputFunction 메서드: 입력된 수식(문자열)을 연산자와 피연산자(숫자)로 분류하는 메서드
  - priorityFunction 메서드: 입력된 수식(문자열)을 inputFunction메서드를 통해 연산자와 피연산자로 분류된 후, 후위 연산식으로 만드는 메서드
  - calculatorFunction 메서드: 입력된 수식(문자열)에서 연산자에 따라 연산을 진행하는 메서드
  - isOperation 메서드: HashMap에 저장되어 있는 올바른 연산자인지 아닌지 판별하는 메서드

* Operation 클래스 안에 있는 메서드
  - plus 메서드 : 입력된 숫자(피연산자) 2개를 사용하여 덧셈한다.
  - minus 메서드 : 입력된 숫자(피연산자) 2개를 사용하여 뺄셈하는 메서드(뻬고자 하는 숫자에 -1을 곱하여 덧셈을 한다.)
  - multiplication 메서드 : 입력된 숫자(피연산자) 2개를 사용하여 곱한다.
  - division 메서드 : 입력된 숫자(피연산자) 2개를 사용하여 나눈다.
  - mod 메서드: 입력된 숫자(피연산자) 2개를 사용하여 나머지 값을 구한다.
  - commonLogFunction 메서드 : 입력된 숫자(피연산자)1개를 사용하여 상용로그(10을 밑으로 하는 로그 함수) 함수 값을 구한다.
  - factorialFunction 메서드: 입력된 숫자(피연산자)1개(n)를 사용하여 1에서 n까지의 모든 자연수의 곱을 계산한 값을 구한다.
  - expFunction 메서드 : 입력된 숫자(피연산자) 1개를 사용하여 자연로그(e)의 지수 함수값을 구한다. 
  - involutionFunction 메서드 : 입력된 숫자(피연산자) 2개를 사용하여 거듭제곱 값을 구한다.
  - sinFunction 메서드 : 입력된 숫자(피연산자) 1개를 사용하여 sin(라디안)함수값을 구한다.
  - tanFunction 메서드 : 입력된 숫자(피연산자) 1개를 사용하여 tan(라디안)함수값을 구한다.
  - cosFunction 메서드 : 입력된 숫자(피연산자) 1개를 사용하여 cos(라디안)함수값을 구한다.
* History 클래스 안에 있는 메서드
  - histoyFunction 메서드  
* MainActivity 클래스 안에 있는 메서드
  - @Override OnCreate 메서드: Button 리소스를 연결하기 위한 초기화(init), Button 리스너(setNumListener, setOperationListener)를 호출하고 있다.
  - init 메서드: Button을 각각의 기능과 연결해주고 하고 있다. 또한 InputOutput 객체와 History 객체를 생성하고 operExpression, input, result 변수를 초기화한다.
  - setNumListener 메서드: 리스너 정의를 한다.
  - @Override onClick 메서드: 숫자 버튼이 눌렸을 때, Button의 id 값에 따라서 수식을 저장하는 변수(operExpression)에 숫자 문자열(0~9)을 저장한다. 저장된 연산식이 화면에 출력되도록 한다. 각   Button 객체의 setOnClickListener 함수를 통해 이벤트 리스너를 등록한다.
  - setOperationListener 메서드: 리스너 정의를 한다.
  - @Override onClick 메서드: 연산자 버튼이 눌렸을 때, Button의 id값에 따라서 수식을 저장하는 변수(operExpression)에 연산자, 괄호, 소수점(+, -, *, /, mod, ^, log, exp, !, (,), ., =, sin, cos, tan)을 저장한다. '=' 연산자를 누르면 History에 저장되도록 한다. 'del'버튼을 누르면 해당 수식에서 가장 마지막에 들어간 것이 지워진다. 'reset' 버튼을 누르면 해당 수식이 모두 없어지도록 한다. 저장된 연산식이 화면에 출력되도록 한다. 'Clear' 버튼을 누르면 해당 수식과 History 기록이 모두 없어지도록 한다. 각 Button 객체의 setOnClickListener 함수를 통해 이벤트 리스너를 등록한다.


### 4) 레이아웃
* activity_main.xml: 사용자가 보는 화면으로 출력되는 UI를 나타낸다. ScrollView 위젯, TextView 위젯, Button 위젯들을 포함하고 있다.


## 3. 입력/출력 데이터 정의 (Data Structure Design)
* 데이터 종류: 피연산자(실수, double), 연산자(Character), Button 위젯 기능(0~9 정수, 소수점, 연산자(+,-,*,/,%,mod,log10,exp,pow,factorial,sin,cos,tan), reset, delete, clear), 수식(문자열, String)
* 입력: Button 위젯(피연산자, 연산자, reset, delete, clear)
* 출력: Textview 위젯(수식 계산한 결과값(문자열, String), 이전 계산 결과값(문자열, String)), ScrollView 위젯(history 기능으로 이전 계산 결과값이 쌓일 때 출력)
<br/>

## 4. 알고리즘 설계 및 구현 (Algorithm Design and Implementation)
- Operation 클래스
  - plus, minus, multiplication, division, mod, expFunction, commonLogFunction, involutionFunction, factorialFunction 알고리즘<br/>
 
<img src="https://github.com/Kim-Ziho/KSA_Calculator/blob/main/image/opeartionFlowChart.png" width="500px" height="400px" title="OperationFlowChart" alt="OperationFlowChart"></img><br/>

## 5. 테스트 이미지 (Test)
* 애플리케이션 sin 연산 : sin30 * 100 + 50

<img src="https://github.com/Kim-Ziho/KSA_Calculator/blob/main/image/sin30_100_50.PNG" width="400px" height="850px" title="calculateSin" alt="calculateSin"></img><br/>

* 애플리케이션 tan 연산 : 100 * tan45 / 50

<img src="https://github.com/Kim-Ziho/KSA_Calculator/blob/main/image/100_tan_45_50.PNG" width="400px" height="850px" title="calculateTan" alt="calculateTan"></img><br/>

* 애플리케이션 Clear

<img src="https://github.com/Kim-Ziho/KSA_Calculator/blob/main/image/clear.PNG" width="400px" height="850px" title="clear" alt="clear"></img><br/>

* 애플리케이션 cos 연산 : cos60 * 4 ^ 2

<img src="https://github.com/Kim-Ziho/KSA_Calculator/blob/main/image/cos60_4_2.PNG" width="400px" height="850px" title="calculatecos" alt="calculatecos"></img><br/>

