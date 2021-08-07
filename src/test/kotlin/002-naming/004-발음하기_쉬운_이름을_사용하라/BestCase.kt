package `002-naming`.`004-발음하기_쉬운_이름을_사용하라`

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import java.time.LocalDateTime
import kotlin.random.Random

class BestCase {

    /**
     * 명확한 변수명을 통하여 지적인 대화가 가능해진다.
     */
    @Test
    fun `명확한 변수명을 통해서 커뮤니케이션을 하도록 한다`() {


        // given
        val customers = listOf(
            Customer(
                recordId = Random.nextLong(),
                generationDate = LocalDateTime.now(),
                modifiedDate = LocalDateTime.now()
            )
        )

        // when
        val size = customers.count()

        // then
        size shouldBe 1
    }
}

data class Customer(
    val recordId: Long,
    val generationDate: LocalDateTime,
    val modifiedDate: LocalDateTime,
)

