package com.github.christopheml.day02

import com.github.christopheml.common.PuzzleInput
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SolverTest {

    @Test
    internal fun `acceptance test`() {
        val instructions = PuzzleInput(2).asSingleLine().split(",").map { it.toInt() }
        val program = IntcodeProgram(instructions)
        val computer = IntcodeComputer()
        val (noun, verb) = solve(computer, program, 3790645)
        assertThat(noun).isEqualTo(12)
        assertThat(verb).isEqualTo(2)
    }

}
