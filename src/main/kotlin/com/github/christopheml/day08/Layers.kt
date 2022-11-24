package com.github.christopheml.day08

import com.github.christopheml.common.PuzzleInput

fun main() {
    val layerSize = 25 * 6

    val layers = PuzzleInput(8)
        .asSingleLine()
        .chunked(layerSize)

    val result = layers
        .map { layer -> layer.groupingBy { it }.eachCount() }
        .sortedBy { it['0'] }
        .first()
        .let { it['1']!! * it['2']!! }

    println("The number of 1 digits multiplied by the number of 2 digits is $result")

    IntRange(0, layerSize - 1).map { i ->
        layers.map { it[i] }.fold('2') { existing, below -> if (existing < '2') existing else below }
    }.chunked(25).forEach { line ->
        line.forEach {
            print(if (it == '1') '█' else ' ')
        }
        print("\n")
    }

}
