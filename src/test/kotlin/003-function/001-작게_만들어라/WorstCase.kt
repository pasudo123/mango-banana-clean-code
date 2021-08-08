package `003-function`.`001-작게_만들어라`

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class WorstCase {

    @Test
    fun `로또를 생성한다`() {

        // given
        val lotto = Lotto.create()

        // when
        val numbers = lotto.numbers

        // then
        numbers.count() shouldBe 6
    }

    internal class Lotto private constructor() {

        var numbers: List<Int>

        init {
            val lottoNumbers: MutableList<Int> = mutableListOf()
            for (number in 1..45) {
                lottoNumbers.add(number)
            }
            this.numbers = lottoNumbers.shuffled().map { it }.take(LOTTO_NUMBER_COUNT)
        }

        companion object {
            const val LOTTO_NUMBER_COUNT = 6

            fun create(): Lotto {
                return Lotto()
            }
        }
    }
}