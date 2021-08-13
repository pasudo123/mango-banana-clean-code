## 클린코드

클린코드를 읽으면서 그냥 정리한다. 나의 기준대로.

### 1장 깨끗한 코드

* 나쁜 코드는 생산성을 떨어트린다.
  * 새로운 요구사항에 대해서 기능을 추가하기 위해 많은 시간이 소모될 수 있기 때문이다.

### 2장 의미 있는 이름

* [01-의도를 분명히 밝혀라](https://github.com/pasudo123/mango-banana-clean-code/blob/master/src/test/kotlin/002-naming/001-%EC%9D%98%EB%8F%84%EB%A5%BC_%EB%B6%84%EB%AA%85%ED%9E%88_%EB%B0%9D%ED%98%80%EB%9D%BC)
* [02-그릇된 정보는 피하라](https://github.com/pasudo123/mango-banana-clean-code/blob/master/src/test/kotlin/002-naming/002-%EA%B7%B8%EB%A6%87%EB%90%9C_%EC%A0%95%EB%B3%B4%EB%A5%BC_%ED%94%BC%ED%95%98%EB%9D%BC)
  * 이름으로 그릇된 정보를 제공하는 끔찍한 예가 `소문자 l` 과 `소문자 o` 이다. `l` 은 1처럼 보이고, `o` 는 0 처럼 보이기 때문이다.
* [03-의미 있게 구분하라](https://github.com/pasudo123/mango-banana-clean-code/blob/master/src/test/kotlin/002-naming/003-%EC%9D%98%EB%AF%B8_%EC%9E%88%EA%B2%8C_%EA%B5%AC%EB%B6%84%ED%95%98%EB%9D%BC)
  * 연속한 의미의 변수 또는 불용어(분석 시, 필요가 없어 보이는 표현) 를 지양한다.
* [04-발음하기_쉬운_이름을_사용하라](https://github.com/pasudo123/mango-banana-clean-code/blob/master/src/test/kotlin/002-naming/004-%EB%B0%9C%EC%9D%8C%ED%95%98%EA%B8%B0_%EC%89%AC%EC%9A%B4_%EC%9D%B4%EB%A6%84%EC%9D%84_%EC%82%AC%EC%9A%A9%ED%95%98%EB%9D%BC)
* 05-검색하기 쉬운 이름을 사용하라
  * 단순 매직넘버로 표현하지 말고 의미있는 정적변수로 치환해서 값을 사용하도록 한다.
  * 이후에 검색할 시에도 매직넘버 검색이 아닌 의미있는 변수 명칭으로 검색이 가능하기 때문이다.
* 07-자신의 기억력을 자랑하지 마라
* 08-클래스 이름
  * 클래스 이름에 동사는 사용하지 않느다. 명사 혹은 명사구를 사용할 수 있도록 한다.
* [09-메소드 이름](https://github.com/pasudo123/mango-banana-clean-code/blob/master/src/test/kotlin/002-naming/009-%EB%A9%94%EC%86%8C%EB%93%9C_%EC%9D%B4%EB%A6%84/BestCase.kt)
  * 메소드 이름에 동사나 동사구가 적합하다.
  * 접근자, 변경자, 조건자는 javabean 표준에 따라서 get, set, is 를 붙인다.
  * 생성자 오버로딩을 수행할 때는 팩토리 메소드 패턴을 이용한다.
* 10-기발한 이름은 피하라
  * 의도를 분명하고 솔직하게 표현하도록 하라.
* 11-한 개념에 한 단어를 사용하라
  * 똑같은 메소드를 클래스마다 `fetch`, `retrieve`, `get` 으로 제각각 부르면 혼란스럽다.
    * 일관성 있는 어휘를 사용하도록 한다.
* [12-말장난을 하지마라](https://github.com/pasudo123/mango-banana-clean-code/blob/master/src/test/kotlin/002-naming/012-%EB%A7%90%EC%9E%A5%EB%82%9C%EC%9D%84_%ED%95%98%EC%A7%80%EB%A7%88%EB%9D%BC/BestCase.kt)
  * _11-한 개념에 한 단어를 사용하라_ 와 _12-말장난을 하지마라_ 는 맥락을 같이한다. 일관성 있는 어휘를 사용하도록 하지만 메소드 내 구현내용에 따라 일관성 유지여부를 결정해주어야 한다.

### 3장 함수

* [01-작게 만들어라](https://github.com/pasudo123/mango-banana-clean-code/tree/master/src/test/kotlin/003-function/001-%EC%9E%91%EA%B2%8C_%EB%A7%8C%EB%93%A4%EC%96%B4%EB%9D%BC)
  * 들여쓰기를 최대한 줄일 수 있도록 한다.
  * 각 함수가 하나의 이야기를 표현할 수 있도록 한다.
* 02-한 가지만 해라
  * 함수는 한가지를 해야한다. 그 한가지를 잘 해야한다. 그 한가지만을 해야한다.
* 03-함수 당 추상화 수준은 하나로
  * `getHtml()` 은 함수의 추상화 수준이 매우 높다.
  * `String pagePathName = PathParser.render(pagePath)` 는 함수의 추상화 수준이 중간이다.
  * `.append()` 는 함수의 추상화 수준이 매우 낮다.
  * 하나의 함수 내 추상화 수준이 일정하여야 한다. : 섞지 말아야 한다.
  * 이야기처럼 위에서 아래로 코드가 읽혀야 좋은 코드이다.
* 04-SWITCH 문
  * 스위치문은 함수를 작게 만들기 어렵다.
* 05-서술적인 이름을 사용하라
  * `이름을 정하느라 시간을 들여도 좋다.` 이런저런 이름을 넣어보고, 코드를 읽어보면 더 좋다.
* [06-함수 인수](https://github.com/pasudo123/mango-banana-clean-code/blob/master/src/test/kotlin/003-function/006-%ED%95%A8%EC%88%98_%EC%9D%B8%EC%88%98)
  * 함수에서 가장 이상적인 인수의 개수는 0개 (무항이다.)
  * 그 다음은 1항이고, 그 다음은 2항이고 3개부터는 피하는 것이 좋다.
* [07-부수효과를 일으키지 마라](https://github.com/pasudo123/mango-banana-clean-code/blob/master/src/test/kotlin/003-function/007-%EB%B6%80%EC%88%98%ED%9A%A8%EA%B3%BC%EB%A5%BC_%EC%9D%BC%EC%9C%BC%ED%82%A4%EC%A7%80_%EB%A7%88%EB%9D%BC)
  * 함수에서 한가지 일을 하겠다고 하고, 다른 일을 하는 우를 범하지 마라.
* [08-명령과 조회를 분리하라](https://github.com/pasudo123/mango-banana-clean-code/tree/master/src/test/kotlin/003-function/008-%EB%AA%85%EB%A0%B9%EA%B3%BC_%EC%A1%B0%ED%9A%8C%EB%A5%BC_%EB%B6%84%EB%A6%AC%ED%95%98%EB%9D%BC)
  * 오브젝트 책에서도 본 내용이다. : 명령은 명령만 수행하고 조회는 조회만 수행하여야 한다. 섞어쓰면 안된다.

### 4장 주석

* 나쁜주석
  * 주절거리는 주석
  * 두 라인에 걸쳐서 같은 이야기를 반복하는 주석
  * 있으나 마나한 주석 ex) 생성자나 getter, setter 에 다는 주석
  * 닫는 괄호에 다는 주석 : 닫는 괄호에 주석을 달아야 할 만큼 함수의 길이가 길다면, 그 함수는 더 잘게 만들어야 하는 함수일 것이다.
  * 주석으로 처리한 코드
    * 최대한 빨리 제거를 하던가 또는 리팩토링을하여 코드 내에 존재하지 않도록 만들어야 한다.
* 그 밖에 좋은주석도 있지만, 나쁜주석을 하지 않는 것이 더 중요하다고 생각한다.

### 5장 형식 맞추기

* 상수를 저차원 함수, private method 안에 넣도록 하지말고 인자로 받을 수 있도록 하자.
  * 상수를 마땅히 알아야할 함수에서 실제로 사용하는 함수로 상수를 넘겨주는 방법이 좋다. (p.105) 
