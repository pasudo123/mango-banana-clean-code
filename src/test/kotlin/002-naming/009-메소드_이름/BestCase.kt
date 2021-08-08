package `002-naming`.`009-메소드_이름`

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class BestCase {

    @Test
    fun `생성자 오버로딩 시에는 정적팩토리 메소드를 이용한다`() {

        // given
        val box1 = Box.from(5)
        val box2 = Box.from("hello world")

        // then
        box1.treasure shouldBe 5
        box2.treasure shouldBe "hello world"

    }
}

class Box<T> private constructor(
    val treasure: T? = null,
) {
    companion object {
        fun from(treasure: Int): Box<Int> {
            return Box(treasure)
        }

        fun from(treasure: String): Box<String> {
            return Box(treasure)
        }
    }
}