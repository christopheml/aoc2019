package day01

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class FuelRequirementsTest {

    class FuelRequired(val mass: Long, val expectedFuel: Long) {
        override fun toString(): String {
            return "mass of $mass requires $expectedFuel fuel"
        }
    }

    private fun providedExamples() = Stream.of(
        FuelRequired(12, 2),
        FuelRequired(14, 2),
        FuelRequired(1969, 654),
        FuelRequired(100756, 33583)
    )

    @ParameterizedTest
    @MethodSource("providedExamples")
    internal fun `acceptance test`(example: FuelRequired) {
        assertThat(fuelRequirementFor(example.mass)).isEqualTo(example.expectedFuel)
    }

}
