package `002-naming`.`001-의도를_분명히_밝혀라`

import `002-naming`.NamingTestSupport
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class WorstCase: NamingTestSupport(){

    /**
     * 1. theList 에는 무슨 값이 들어가있는가?
     * 2. theList 의 첫번째 값이 뭐때문에 중요한 값인가?
     * 3. 값 4는 무슨 의미인가?
     * 4. 함수가 반환하는 arrays 는 어떻게 사용하는가?
     */
    @Test
    @DisplayName("인자값에 메소드 내 변수가 의도를 나타내지 않는다.")
    fun worstCaseTest() {

        // given
        val theList = givenData

        // when
        val result = getThem(theList)

        // then
        result.count() shouldBe 1
        result.first().first() shouldBe 4
    }

    private fun getThem(theList: List<IntArray>): List<IntArray> {
        val arrays: MutableList<IntArray> = mutableListOf()

        for (x in theList) {
            if(x[0] == 4) {
                arrays.add(x)
            }
        }

        return arrays
    }
}