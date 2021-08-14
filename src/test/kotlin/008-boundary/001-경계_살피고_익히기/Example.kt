package `008-boundary`.`001-경계_살피고_익히기`

import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import org.apache.logging.log4j.Level
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.core.config.Configurator
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import java.time.LocalDateTime

/**
 * reference : https://github.com/apache/logging-log4j2
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class Example {

    /**
     * - 필요한 것만 빠르게 익힘
     * - 혹시나 버전업을 하게되는 경우 여기 학습 테스트에서 잡히기 때문에 이후 버전 이전이 용이해진다.
     */
    @Test
    fun `학습 테스트를 통해서 LocalDateTime 의 기능을 익혀보자`() {

        // given
        val now = LocalDateTime.now()

        // when
        val dayOfWeek = now.dayOfWeek

        // then
        dayOfWeek.name shouldNotBe null
        dayOfWeek.name shouldBe "SATURDAY"
        dayOfWeek.name.contains("SAT") shouldBe true

        dayOfWeek.value shouldNotBe null
        dayOfWeek.value shouldBe 6  // 토요일 날짜의 값이 이후에 6이 아닌 다른 값으로 잡혔다면 그것을 이후에 쉽게 잡을 수 있다.
    }

    @ParameterizedTest
    @ValueSource(strings = ["OFF", "ERROR", "WARN", "INFO", "DEBUG", "ALL"])
    fun `학습 테스트를 통해서 Logger 의 기능을 익혀보자`(level: String) {

        // given
        Configurator.setRootLevel(Level.valueOf(level));


        // when
        val logger = LogManager.getLogger()

        // then
        logger.always().withLocation().log("Hello World : WithLocation Method")
        logger.error("Hello World")
        logger.debug("Hello World")
        logger.info("Hello World")
    }
}