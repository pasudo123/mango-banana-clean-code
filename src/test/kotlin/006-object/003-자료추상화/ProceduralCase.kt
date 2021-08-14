package `006-object`.`003-자료추상화`

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class ProceduralCase {

    @Test
    fun `절차지향적 도형을 테스트한다`() {

        // given
        val square = Square(Point(1.0, 1.0), 5.0)
        val rectangle = Rectangle(Point(1.0, 1.0), 3.0, 4.0)
        val geometry = Geometry()

        // when
        val squareArea = geometry.area(square)
        val rectangleArea = geometry.area(rectangle)

        // then
        squareArea shouldBe 25.0
        rectangleArea shouldBe 12.0
    }

    class Point(
        val x: Double,
        val y: Double,
    )

    class Square(
        val topLeft: Point,
        val side: Double,
    )

    class Rectangle(
        val topLeft: Point,
        val height: Double,
        val width: Double,
    )

    class Circle(
        val center: Point,
        val radius: Double,
    )

    class Geometry {
        companion object {
            const val PI = 3.141592
        }

        fun area(shape: Any): Double {
            return when (shape) {
                is Square -> {
                    shape.side * shape.side
                }
                is Rectangle -> {
                    shape.height * shape.width
                }
                is Circle -> {
                    PI * shape.radius * shape.radius
                }
                else -> throw RuntimeException("해당하는 도형이 없습니다.")
            }
        }
    }
}