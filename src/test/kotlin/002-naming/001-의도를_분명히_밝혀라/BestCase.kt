package `002-naming`.`001-의도를_분명히_밝혀라`

import `002-naming`.NamingTestSupport
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class BestCase: NamingTestSupport() {

    @Test
    @DisplayName("단순한 배열을 래핑해서 사용하여 상수 값을 감춰보도록 한다.")
    fun bestCaseTest() {

        // given
        val gameBoard = givenData.map { Cell(it) }

        // when
        val result = getFlaggedCellsBy(gameBoard)

        // then
        result.count() shouldBe 1
        result.first().elements.first() shouldBe 4
    }

    private fun getFlaggedCellsBy(gameBoard: List<Cell>): List<Cell> {
        val flaggedCells: MutableList<Cell> = mutableListOf()

        for(cell in gameBoard) {
            if (cell.isFlagged()) {
                flaggedCells.add(cell)
            }
        }

        return flaggedCells
    }
}

@Suppress("ArrayInDataClass")
data class Cell(
    val elements: IntArray
) {

    companion object {
        private const val STATUS_VALUE = 0
        private const val FLAGGED = 4
    }

    /**
     * 명시적으로 별도의 함수를 만들어서 네이밍을 명확하게 하였다.
     */
    fun isFlagged(): Boolean {
        return elements[STATUS_VALUE] == FLAGGED
    }
}