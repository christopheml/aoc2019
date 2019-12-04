package com.github.christopheml.day02

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class IntcodeProgramTest {

    @Test
    internal fun `read value`() {
        val program = IntcodeProgram(listOf(1, 2, 3))
        assertThat(program.valueAt(0)).isEqualTo(1)
        assertThat(program.valueAt(1)).isEqualTo(2)
        assertThat(program.valueAt(2)).isEqualTo(3)
    }

    @Test
    internal fun `set value`() {
        val program = IntcodeProgram(listOf(1, 2, 3))
        program.setValue(2, 55)
        assertThat(program.toString()).isEqualTo("1,2,55")
    }

    @Test
    internal fun `equals implementation`() {
        val program1 = IntcodeProgram(listOf(1, 2, 3))
        val program2 = IntcodeProgram(listOf(1, 2, 3))
        assertThat(program1).isEqualTo(program2)
    }

}
