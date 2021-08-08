package `002-naming`.`012-말장난을_하지마라`

import io.kotest.matchers.collections.shouldContainInOrder
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class BestCase {

    @Test
    fun `add 메소드로 일관성을 맞추지 말고, 메소드 구현 내용에 따라 메소드의 의도를 밝히는 이름으로 변경한다`() {

        // calculator
        // given
        val calculator = Calculator.create()

        // when
        val output = calculator.add(10)

        // then
        output shouldBe 10


        // cafe
        // given
        val cafe = Cafe.create()
        val personGroupA = listOf(Cafe.Person("홍길동"), Cafe.Person("둘리"))
        val personGroupB = listOf(Cafe.Person("또치"), Cafe.Person("마이콜"))

        // when
        cafe.append(personGroupA)
        cafe.insert(personGroupB)

        // then
        cafe.persons.count() shouldBe 4
        cafe.persons.map { person -> person.name } shouldContainInOrder listOf("홍길동", "둘리", "또치", "마이콜")
    }
}

class Cafe private constructor(
    val persons: MutableList<Person> = mutableListOf(),
) {

    /**
     * 일관성 있는 어휘를 사용하는 것도 좋지만, 실제 그 어휘가
     * 다른 메소드와 일관성을 유지할 수 있는 메소드 어휘가 이나라면 과감히 다른 명칭으로 변경하는 것이 좋다.
     */
    @Deprecated(
        message = "일관성 있는 어휘를 사용하는 것도 좋지만, 실제 그 어휘가" +
                "다른 메소드와 일관성을 유지할 수 있는 메소드 어휘가 이나라면 과감히 다른 명칭으로 변경하는 것이 좋다.",
        replaceWith = ReplaceWith("this.persons.insert(persons) or this.persons.append(persons)"))
    fun add(persons: List<Person>) {
        this.persons.addAll(persons)
    }

    fun insert(persons: List<Person>) {
        this.persons.addAll(persons)
    }

    fun append(persons: List<Person>) {
        this.persons.addAll(persons)
    }

    data class Person(
        val name: String,
    )

    companion object {
        fun create(): Cafe {
            return Cafe()
        }
    }
}

class Calculator private constructor(
    private var currentValue: Long = 0,
) {

    fun add(input: Long): Long {
        this.currentValue += input
        return this.currentValue
    }

    companion object {
        fun create(): Calculator {
            return Calculator()
        }
    }
}