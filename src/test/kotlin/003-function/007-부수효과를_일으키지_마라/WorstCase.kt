package `003-function`.`007-부수효과를_일으키지_마라`

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class WorstCase {

    @Test
    fun `함수는 메소드 명과 다르게 두가지 일을 수행하고 우리를 속이고 있다`() {

        // given
        val person = Person("홍길동", 40000)
        val store = Store()

        // when
        val possible = store.isEnterPossible(person)

        // then
        possible shouldBe true
        person.money shouldBe 40000 - Store.ADMISSION_FEE
    }

    class Person(
        val name: String,
        var money: Long,
    ) {

        fun takeOutMoneyBy(money: Long) {
            if (money < 0) {
                throw RuntimeException("금액은 0보다 작을 수 없습니다.")
            }

            this.money -= money
        }
    }

    class Store {

        companion object {
            const val ADMISSION_FEE = 3000L
        }

        fun isEnterPossible(person: Person): Boolean {
            if (person.money >= ADMISSION_FEE) {
                person.takeOutMoneyBy(ADMISSION_FEE)
                return true
            }

            return false
        }
    }
}