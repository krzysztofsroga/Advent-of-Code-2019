import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.core.FuelManager
import com.github.kittinunf.result.Result

import kotlinx.coroutines.*
import java.io.File
import kotlin.math.abs

//import kotlin.math.pow
//import kotlin.system.measureTimeMillis

fun main() {

    var a = 0
    var b = 0
    var c = 0
    var d = 0
    val set = mutableSetOf<Any>()
    val iSet = mutableSetOf<Int>()
    val cSet = mutableSetOf<Char>()
    val sSet = mutableSetOf<String>()
    val posSet = mutableMapOf<Vector, Int>()
    var minDistance: Int = 10000000

    aocSolution(3) {

        first().let {
            var steps = 0
            val s = it.split(",")
            var currentPos = Vector(0, 0)
            s.forEach {
                try {
                    val direction = when(it.first()) {
                        'R' -> Vector(1, 0)
                        'L' -> Vector(-1, 0)
                        'U' -> Vector(0, 1)
                        'D' -> Vector(0, -1)
                        else -> throw Exception()
                    }
                    val iterations = it.drop(1).toInt()
                    for(x in 0 until iterations) {
                        steps += 1
                        currentPos += direction
                        if(!posSet.containsKey(currentPos)) {
                            posSet[currentPos] = steps
                        }

                    }

                } catch (e: Exception) {}
            }
        }

        this[1].let {

            val s = it.split(",")
            var steps = 0
            var currentPos = Vector(0, 0)
            s.forEach {
                try {
                    val direction = when(it.first()) {
                        'R' -> Vector(1, 0)
                        'L' -> Vector(-1, 0)
                        'U' -> Vector(0, 1)
                        'D' -> Vector(0, -1)
                        else -> throw Exception()
                    }
                    val iterations = it.drop(1).toInt()
                    for(x in 0 until iterations) {
                        currentPos += direction
                        steps += 1
                        if(posSet.containsKey(currentPos)) {

                            val dist = posSet[currentPos]!! + steps
                            if(dist < minDistance) {
                                minDistance = dist
                            }

                        }
                    }

                } catch (e: Exception) {}
            }
        }

        minDistance
    }
/*
237 is wrong
300 is wrong
373 is wrong

93654 is right (part 2)
joinToString(",").let
 */
}

class Vector(val x: Int, val y: Int) {
    operator fun plus(other: Vector) : Vector{
        return Vector(x + other.x, y + other.y)
    }
    operator fun minus(other: Vector) : Vector{
        return Vector(x - other.x, y - other.y)
    }

    operator override fun equals(other: Any?): Boolean {
        if(other is Vector) {
            if(x ==other.x && y == other.y) {
                return true
            }
        }
        return super.equals(other)
    }

    override fun hashCode(): Int {
        var result = x
        result = 31 * result + y
        return result
    }

}
/*
// DAY 2 part 1 (2019)
var x = 0
var y = 0
var a = 0
var b = 0
var c = 0
var d = 0
val set = mutableSetOf<Any>()
val iSet = mutableSetOf<Int>()
val cSet = mutableSetOf<Char>()
val sSet = mutableSetOf<String>()
aocSolution(2) {
    joinToString(",").split(",").mapToIntNotNull().toMutableList().let { list ->
        list[1] = 12
        list[2] = 2
       iterate(4) {i ->
           when (list[i]) {
               1 -> list[list[i+3]] = list[list[i+1]] + list[list[i+2]]
               2 -> list[list[i+3]] = list[list[i+1]] * list[list[i+2]]
               99 -> return@aocSolution list[0]
           }
       }
    }
    0
}
2692315


// part 2
var a = 0
var b = 0
var c = 0
var d = 0
val set = mutableSetOf<Any>()
val iSet = mutableSetOf<Int>()
val cSet = mutableSetOf<Char>()
val sSet = mutableSetOf<String>()
aocSolution(2) {
    joinToString(",").split(",").mapToIntNotNull().toTypedArray().let { list ->
        for(x in 0..100) {
            for(y in 0..100) {
                val l = mutableListOf(*list)
                l[1] = x
                l[2] = y
                try {
                    iterate(4) { i ->
                        when (l[i]) {
                            1 -> l[l[i + 3]] = l[l[i + 1]] + l[l[i + 2]]
                            2 -> l[l[i + 3]] = l[l[i + 1]] * l[l[i + 2]]
                            99 -> if (l[0] == 19690720) return@aocSolution x * 100 + y else return@iterate
                        }
                    }
                } catch (e: Exception) {}
            }
        }


    }
    0
}.postLevel(2)
 */


fun cmp(s1: String, s2: String) {
    s1.zip(s2).count { it.first == it.second }
}

fun day1() {
    AdventOfCodeConnection.year = 2018
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
}

fun day2() {
    AdventOfCodeConnection.year = 2018
    var x = 0
    var y = 0
    var a = 0
    var b = 0
    var c = 0
    var d = 0
    val set = mutableSetOf<Any>()
    val iSet = mutableSetOf<Int>()
    val cSet = mutableSetOf<Char>()
    val sSet = mutableSetOf<String>()
    aocSolution(2) {
        forEach { s ->
            s.forEach {
                set+=it
            }
            set.map {c ->
                s.count { it == c }
            }.let {
                if (it.contains(2)) x += 1
                if(it.contains(3)) y += 1
            }
            set.clear()
        }
        x*y
    }.postLevel(1)
    aocSolution(2) {
        forEach { s1 ->
            forEach {s2 ->
                if (s1.zip(s2).count { it.first != it.second } == 1) {
                    s1.toSet().toList().zip(s2.toSet().toList()).filter { it.first == it.second }.joinToString("") { it.first.toString() }.let { println(it) }

                }
            }
        }
        0
    }
}

inline fun iterate(step: Int = 1, block: (Int) -> Unit) {
    var i = 0
    while (true) {
        block(i)
        i+= step
    }
}

fun calculateFuel1(fuel: Int) = fuel / 3 - 2

fun calculateFuel2(fuel: Int): Int {
    val a = calculateFuel1(fuel)
    return if (a > 0) {
        a + calculateFuel2(a)
    } else 0
}

fun aocSolution(day: Int, solutionCode: List<String>.() -> Int) : AocSolution {
    val answer = solutionCode(AdventOfCodeConnection.fetchInput(day).lines().filter { it.isNotBlank() })
    val solution = AocSolution(day, answer)
    println(solution)
    return solution
}

fun Iterable<String>.mapToIntNotNull(): List<Int> = mapNotNull { it.toIntOrNull() }

fun<T> MutableList<T>.pop(): T {
    return removeAt(size-1)
}

data class AocSolution(val day: Int, val answer: Int)  {
    fun postLevel(level: Int) {
        val responseString = AdventOfCodeConnection.postAnswer(day, level, answer)
        println("Solution posted")
        println(responseString)
    }
}