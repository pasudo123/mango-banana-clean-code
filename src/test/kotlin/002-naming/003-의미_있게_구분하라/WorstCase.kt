package `002-naming`.`003-의미_있게_구분하라`

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class WorstCase {

    @Test
    @DisplayName("불용어와 연속된 표현은 사용하지 않도록 한다.")
    fun `불용어와 연속된 표현은 사용하지 않는다`() {

        // given
        val names = listOf("홍길동", "둘리", "또치", "마이콜", "고길동")

        /**
         * 두 개의 표현이 구분이 잘 되지 않는다. 불용어이다.
         */
        // when
        val customers = names.map { name -> Customer(name) }
        val customerInfos = names.map { name -> CustomerInfo(name) }

        // then
        customers.count() shouldBe 5
        customerInfos.count() shouldBe 5
    }
}

data class Customer(
    val name: String,
)

data class CustomerInfo(
    val name: String,
)