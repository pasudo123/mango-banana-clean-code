package `003-function`.`007-부수효과를_일으키지_마라`

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class BestCase {

    @Test
    fun `함수는 부수효과를 수행하지 않는다`() {

        // given
        val person = Person("홍길동", 50000)
        val store = Store()

        // when : 함수는 하나의 일만 수행하도록 한다.
        if (store.isEnterPossible(person)) {
            store.deductPersonMoney(person)
        }

        person.money shouldBe 50000 - WorstCase.Store.ADMISSION_FEE
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
                return true
            }

            return false
        }

        fun deductPersonMoney(person: Person) {
            person.takeOutMoneyBy(ADMISSION_FEE)
        }
    }
}