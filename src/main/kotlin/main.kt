import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.core.FuelManager
import com.github.kittinunf.result.Result

import kotlinx.coroutines.*
import java.io.File

//import kotlin.math.pow
//import kotlin.system.measureTimeMillis

fun main() {
    AdventOfCodeConnection.year = 2018
    val input = AdventOfCodeConnection.fetchInput(1)
    var sum = 0
    val set = mutableSetOf<Int>()

    aocSolution(1) {
        mapToIntNotNull().sum()
    }

    aocSolution(1) {
        while(true) {
            mapToIntNotNull().forEach {
                sum += it
                if(set.contains(sum)) {
                    return@aocSolution sum
                }
                set+=sum
            }
        }
        0
    }

//    println(AdventOfCodeConnection.postAnswer(3, 2, 452))



//
//    val result1 = input.lines().mapNotNull { it.toIntOrNull() }.map(::calculateFuel1).sum()
//    val result2 = input.lines().mapNotNull { it.toIntOrNull() }.map(::calculateFuel2).sum()
//    println("Solution for day 1:")
//    println("part1: $result1")
//    println("part2: $result2")
}

fun calculateFuel1(fuel: Int) = fuel / 3 - 2

fun calculateFuel2(fuel: Int): Int {
    val a = calculateFuel1(fuel)
    return if (a > 0) {
        a + calculateFuel2(a)
    } else 0
}

fun aocSolution(day: Int, solutionCode: List<String>.() -> Int)  {
    val answer = solutionCode(AdventOfCodeConnection.fetchInput(day).lines())
    val solution = AocSolution(day, answer)
    println(solution)
}

fun Iterable<String>.mapToIntNotNull(): List<Int> = mapNotNull { it.toIntOrNull() }

data class AocSolution(val day: Int, val answer: Int)  {
    fun postLevel(level: Int) {
        val responseString = AdventOfCodeConnection.postAnswer(day, level, answer)
        println("Solution posted")
        println(responseString)
    }
}