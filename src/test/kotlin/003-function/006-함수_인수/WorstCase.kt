package `003-function`.`006-함수_인수`

import org.junit.jupiter.api.Test

class WorstCase {

    @Test
    fun `많은 함수 인수로 인해서 테스트 하기가 어렵다`() {

        // given
        val name = "홍길동"
        val money = 50000L
        val gender = "남자"

        // when
        val store = Store()

        // then
        store.enter(name, money, gender)
    }

    class Store {
        fun enter(name: String, money: Long, gender: String) {
            println("성별이 ${gender} 인 ${name} (이)가 가게에 ${money} 금액을 들고 들어왔습니다.")
        }
    }
}