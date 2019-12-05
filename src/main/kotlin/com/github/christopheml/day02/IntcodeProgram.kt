package com.github.christopheml.day02

class IntcodeProgram(instructions: List<Int>) {

    private val instructions: MutableList<Int> = instructions.toMutableList()

    constructor(another: IntcodeProgram) : this(another.instructions)

    fun valueAt(position: Int): Int {
        return instructions[position]
    }

    fun setValue(position: Int, value: Int) {
        instructions[position] = value
    }

    override fun toString(): String {
        return instructions.joinToString(",", transform = { it.toString() })
    }

    override fun hashCode(): Int {
        return instructions.hashCode()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as IntcodeProgram

        if (instructions != other.instructions) return false

        return true
    }

}
