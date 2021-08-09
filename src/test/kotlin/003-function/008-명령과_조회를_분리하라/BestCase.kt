package `003-function`.`008-명령과_조회를_분리하라`

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class BestCase {

    @Test
    fun `명령과 조회가 같이있는 메소드를 지양하라`() {

        // given
        val bag = Bag()

        // then
        bag.append("apple")
        bag.append("banana")

        // when
        bag.elements.count() shouldBe 2
        bag.isNonExistAndAppend("grape") shouldBe true
        bag.elements.count() shouldBe 3
    }

    class Bag(
        val elements: MutableList<String> = mutableListOf(),
    ) {

        /**
         * 조회와 명령을 같이 한다.
         * 이런 혼란은 생기면 안된다. !!
         */
        fun isNonExistAndAppend(element: String): Boolean {
            if (elements.contains(element)) {
                return false
            }

            append(element)
            return true
        }

        fun append(element: String) {
            elements.add(element)
        }
    }
}