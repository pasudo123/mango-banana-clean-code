package `006-object`.`003-자료추상화`

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class ObjectOrientedCase {

    @Test
    fun `객체지향적 도형을 테스트한다`() {

        // given
        val square = Square(ProceduralCase.Point(1.0, 1.0), 5.0)
        val rectangle = Rectangle(ProceduralCase.Point(1.0, 1.0), 3.0, 4.0)

        // when
        val squareArea = square.area()
        val rectangleArea = rectangle.area()

        // then
        squareArea shouldBe 25.0
        rectangleArea shouldBe 12.0
    }

    interface Shape {
        fun area(): Double
    }

    class Point(
        val x: Double,
        val y: Double,
    )

    class Square(
        private val topLeft: ProceduralCase.Point,
        private val side: Double,
    ) : Shape {
        override fun area(): Double {
            return this.side * side
        }
    }

    class Rectangle(
        private val topLeft: ProceduralCase.Point,
        private val height: Double,
        private val width: Double,
    ) : Shape {
        override fun area(): Double {
            return this.height * this.width
        }
    }

    class Circle(
        private val center: ProceduralCase.Point,
        private val radius: Double,
    ) : Shape {
        companion object {
            const val PI = 3.141592
        }

        override fun area(): Double {
            return PI * radius * radius
        }
    }
}