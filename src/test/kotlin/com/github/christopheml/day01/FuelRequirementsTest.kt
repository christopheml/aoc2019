package com.github.christopheml.day01

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

    private fun part1ProvidedExamples() = Stream.of(
        FuelRequired(12, 2),
        FuelRequired(14, 2),
        FuelRequired(1969, 654),
        FuelRequired(100756, 33583)
    )

    @ParameterizedTest
    @MethodSource("part1ProvidedExamples")
    internal fun `part 1 acceptance test`(example: FuelRequired) {
        assertThat(fuelRequirementFor(example.mass)).isEqualTo(example.expectedFuel)
    }

    private fun part2ProvidedExamples() = Stream.of(
            FuelRequired(14, 2),
            FuelRequired(1969, 966),
            FuelRequired(100756, 50346)
    )

    @ParameterizedTest
    @MethodSource("part2ProvidedExamples")
    internal fun `part 2 acceptance test`(example: FuelRequired) {
        assertThat(completeFuelRequirementFor(example.mass)).isEqualTo(example.expectedFuel)
    }

}
