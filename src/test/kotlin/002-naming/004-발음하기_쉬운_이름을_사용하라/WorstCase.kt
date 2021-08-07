package `002-naming`.`004-발음하기_쉬운_이름을_사용하라`

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import java.time.LocalDateTime
import kotlin.random.Random

class WorstCase {

    @Test
    fun `불분명한 변수명을 통해서 사용자를 혼란에 빠트린다`() {

        // given
        val dtaRcrds = listOf(
            DtaRcrd(
                rcrdId = Random.nextLong(),
                genDate = LocalDateTime.now(),
                modDate = LocalDateTime.now()
            )
        )

        // when
        val size = dtaRcrds.count()

        // then
        size shouldBe 1
    }
}

data class DtaRcrd(
    val rcrdId: Long,
    val genDate: LocalDateTime,
    val modDate: LocalDateTime,
)