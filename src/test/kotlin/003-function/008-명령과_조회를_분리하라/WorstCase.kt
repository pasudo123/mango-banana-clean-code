package `003-function`.`008-명령과_조회를_분리하라`

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class WorstCase {

    @Test
    fun `명령과 조회를 분리하라`() {

        // given
        val bag = Bag()

        // when
        bag.append("apple")
        bag.append("banana")

        // then
        bag.elements.count() shouldBe 2
        bag.isExist("apple") shouldBe true
        bag.isExist("banana") shouldBe true
        bag.isExist("grape") shouldBe false
        if (bag.isExist("grape").not()) {
            bag.append("grape")
        }
        bag.elements.count() shouldBe 3
    }

    class Bag(
        val elements: MutableList<String> = mutableListOf(),
    ) {

        fun isExist(element: String): Boolean {
            return elements.contains(element)
        }

        fun append(element: String) {
            elements.add(element)
        }
    }
}