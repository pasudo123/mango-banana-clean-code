package `002-naming`.`002-그릇된_정보를_피하라`

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class WorstCase {

    /**
     * 변수명에 그릇된 정보를 피해라.
     */
    @Test
    @DisplayName("실제 컨테이너가 List 라도 변수명에 list 를 쓰지 않는 것이 좋다.")
    fun `그릇된 정보는 피하라`() {

        /**
         * accountList 로 변수명을 짓지 말아야 한다. : 책에서는 나중에 살펴본다고 한다.
         */
        // given
        val accounts = listOf(
            Account("홍길동", 55),
            Account("둘리", 30),
            Account("또치", 28),
            Account("마이콜", 43),
            Account("둘리아빠", 65),
            Account("둘리엄마", 68),
        )

        // when
        val accountGroup = accounts.filter { account ->  account.age >= 50 }

        // then
        accountGroup.count() shouldBe 3
    }
}

data class Account(
    val name: String,
    val age: Int
)