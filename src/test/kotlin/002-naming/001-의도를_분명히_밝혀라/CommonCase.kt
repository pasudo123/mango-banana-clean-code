package `002-naming`.`001-의도를_분명히_밝혀라`

import `002-naming`.NamingTestSupport
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class CommonCase: NamingTestSupport() {

    /**
     * 상수는 의미있는 변수 명으로 치환해서 사용토록 한다.
     */
    companion object {
        private const val STATUS_VALUE = 0
        private const val FLAGGED = 4
    }

    @Test
    @DisplayName("인자값에 메소드 내 변수가 의도를 나타내도록 한다.")
    fun commonCaseTest() {

        // given
        val gameBoard = givenData

        // when
        val result = getFlaggedCellsBy(gameBoard)

        // then
        result.count() shouldBe 1
        result.first().first() shouldBe 4
    }

    private fun getFlaggedCellsBy(gameBoard: List<IntArray>): List<IntArray> {
        val flaggedCells: MutableList<IntArray> = mutableListOf()

        for (cell in gameBoard) {
            if (cell[STATUS_VALUE] == FLAGGED) {
                flaggedCells.add(cell)
            }
        }

        return flaggedCells
    }
}