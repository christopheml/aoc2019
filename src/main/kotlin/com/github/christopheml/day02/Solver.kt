package com.github.christopheml.day02

import com.github.christopheml.common.PuzzleInput

fun solve(computer: IntcodeComputer, program: IntcodeProgram, expectedResult: Int): Pair<Int, Int> {
    for (verb in 0..100) {
        for (noun in 0..100) {
            val result = computer.runWithInputs(program, noun, verb)
            if (result == expectedResult) {
                return Pair(noun, verb)
            }
        }
    }
    return Pair(-1, -1)
}

fun main() {
    val instructions = PuzzleInput(2).asSingleLine().split(",").map { it.toInt() }
    val program = IntcodeProgram(instructions)
    val computer = IntcodeComputer()
    val (noun, verb) = solve(computer, program, 19690720)
    val answer = 100 * noun + verb
    println("Noun is $noun, verb is $verb, answer is $answer")
}
