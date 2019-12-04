package com.github.christopheml.day02

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class IntcodeComputerTest {

    class ProgramExecution(val initial: IntcodeProgram, val final: IntcodeProgram) {
        override fun toString(): String {
            return "$initial becomes $final"
        }
    }

    private fun part1ProvidedExamples() = Stream.of(
            ProgramExecution(program(1, 0, 0, 0, 99), program(2, 0, 0, 0, 99)),
            ProgramExecution(program(2, 3, 0, 3, 99), program(2, 3, 0, 6, 99)),
            ProgramExecution(program(2, 4, 4, 5, 99, 0), program(2, 4, 4, 5, 99, 9801)),
            ProgramExecution(program(1, 1, 1, 4, 99, 5, 6, 0, 99), program(30, 1, 1, 4, 2, 5, 6, 0, 99))
    )

    @ParameterizedTest
    @MethodSource("part1ProvidedExamples")
    internal fun `part 1 acceptance test`(example: ProgramExecution) {
        val computer = IntcodeComputer()
        computer.run(example.initial)
        assertThat(example.initial).isEqualTo(example.final)
    }

    private fun program(vararg instructions: Int): IntcodeProgram {
        return IntcodeProgram(instructions.toList())
    }

}
