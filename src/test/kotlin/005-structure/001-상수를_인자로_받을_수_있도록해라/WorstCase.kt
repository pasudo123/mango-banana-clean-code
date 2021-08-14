package `005-structure`.`001-상수를_인자로_받을_수_있도록해라`

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class WorstCase {

    @Test
    fun `상수를 저차원 함수에 숨겨서 쓰지 말아라`() {

        // given
        val fruitBasket = FruitBasket()

        // when
        val findFruitName = fruitBasket.findFruitName("banana")

        // then
        findFruitName shouldBe "apple"
    }

    class FruitBasket {

        private val fruitNames: MutableList<String> = mutableListOf()

        fun findFruitName(fruitName: String): String {
            return getFruitNameOrDefault(fruitName)
        }

        private fun getFruitNameOrDefault(fruitName: String): String {
            val apple = "apple"
            if (this.fruitNames.contains(fruitName).not()) {
                return apple
            }

            return fruitName
        }
    }
}