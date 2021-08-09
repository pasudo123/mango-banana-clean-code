package `003-function`.`006-함수_인수`

import org.junit.jupiter.api.Test

class BestCase {

    @Test
    fun `여러 함수 인수를 인수 객체로 만들어 넘겨주도록 한다`() {

        // given
        val person = Person("홍길동", 50000, Person.Gender.MALE)

        // when
        val store = Store()

        // then
        store.enter(person)
    }

    data class Person(
        val name: String,
        val money: Long,
        val gender: Gender,
    ) {
        enum class Gender(val desc: String) {
            MALE("남자"), FEMALE("여자")
        }
    }

    class Store {
        /**
         * Worst Case 에 비해서 눈 속임이라고 생각할 수 있지만, 인수를 객체로 넘김으로서 개념을 표현하고 있다.
         */
        fun enter(person: Person) {
            println("성별이 ${person.gender.desc} 인 ${person.name} (이)가 가게에 ${person.money} 금액을 들고 들어왔습니다.")
        }
    }
}