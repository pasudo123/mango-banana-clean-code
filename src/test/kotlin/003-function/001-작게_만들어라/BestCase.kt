package `003-function`.`001-작게_만들어라`

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class BestCase {

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
            this.numbers = this.createLottoAllNumbers()
                .getLottoNumberAfterShuffled()
        }

        /**
         * 1 ~ 45 숫자를 섞고 6개의 번호를 추출한다.
         */
        private fun List<Int>.getLottoNumberAfterShuffled(): List<Int> {
            return this.shuffled().map { it }.take(LOTTO_NUMBER_COUNT)
        }

        /**
         * 좋은 예인지 모르겠다만 함수가 하나의 일만 수행할 수 있도록 한다.
         */
        private fun createLottoAllNumbers(): List<Int> {
            val lottoNumbers: MutableList<Int> = mutableListOf()
            for (number in 1..45) {
                lottoNumbers.add(number)
            }
            return lottoNumbers
        }

        companion object {
            const val LOTTO_NUMBER_COUNT = 6

            fun create(): Lotto {
                return Lotto()
            }
        }
    }
}