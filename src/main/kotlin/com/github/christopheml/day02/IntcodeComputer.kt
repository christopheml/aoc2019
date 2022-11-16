package com.github.christopheml.day02

import com.github.christopheml.common.PuzzleInput

class IntcodeComputer {

    internal fun run(program: IntcodeProgram) {
        var position = 0
        var opcode: Int
        while (true) {
            opcode = program.valueAt(position)
            if (opcode == 99) {
                break
            }

            val operand1 = program.valueAt(program.valueAt(position + 1))
            val operand2 = program.valueAt(program.valueAt(position + 2))
            val destination = program.valueAt(position + 3)
            when (opcode) {
                1 -> program.setValue(destination, operand1 + operand2)
                2 -> program.setValue(destination, operand1 * operand2)
            }
            position += 4
        }
    }

    fun runWithInputs(program: IntcodeProgram, noun: Int, verb: Int): Int {
        val programCopy = IntcodeProgram(program)
        programCopy.setValue(1, noun)
        programCopy.setValue(2, verb)
        run(programCopy)
        return programCopy.valueAt(0)
    }

}

fun main() {
    val instructions = PuzzleInput(2).asSingleLine().split(",").map { it.toInt() }
    val program = IntcodeProgram(instructions)
    val computer = IntcodeComputer()
    val result = computer.runWithInputs(program, 12, 2)
    println("The value left at position 0 is $result")
}
