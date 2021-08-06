package `002-naming`

import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
abstract class NamingTestSupport {

    val givenData = listOf(
        intArrayOf(1, 2, 3, 4),
        intArrayOf(4, 3, 2, 1),
        intArrayOf(2, 3, 4, 1)
    )
}