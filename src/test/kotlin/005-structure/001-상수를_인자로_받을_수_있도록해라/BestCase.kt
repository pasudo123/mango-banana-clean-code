package `005-structure`.`001-상수를_인자로_받을_수_있도록해라`

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class BestCase {

    @Test
    fun `상수를 저차원 함수 외부에서 인자로 줄 수 있도록 하자`() {

        // given
        val fruitBasket = FruitBasket()

        // when
        val findFruitName = fruitBasket.findFruitName("banana")

        // then
        findFruitName shouldBe "apple"
    }

    class FruitBasket {

        companion object {
            const val DEFAULT_FRUIT_NAME = "apple"
        }

        private val fruitNames: MutableList<String> = mutableListOf()

        fun findFruitName(fruitName: String): String {
            return getFruitNameOrDefault(fruitName, DEFAULT_FRUIT_NAME)
        }

        /**
         * 두번째 인자는 상수로 디폴트 값을 넣어줄 수 있는 코틀릭의 특징이 있기 때문에 가능하다.
         */
        private fun getFruitNameOrDefault(fruitName: String, defaultFruitName: String = DEFAULT_FRUIT_NAME): String {
            if (this.fruitNames.contains(fruitName).not()) {
                return defaultFruitName
            }

            return fruitName
        }
    }
}