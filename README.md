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