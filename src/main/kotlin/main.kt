//import kotlin.math.pow
//import kotlin.system.measureTimeMillis

fun main() {

}

fun day4() {
    aocSolution(4) {
        (240920..789857).asSequence().filter { it in 100_000..999_999 }.count { number ->
            var currentMax = 0
            var foundTwoConsecutive = false
            number.splitIntoDigits().forEach { digit ->
                when {
                    digit < currentMax -> return@count false
                    digit == currentMax -> foundTwoConsecutive = true
                }
                currentMax = digit
            }
            foundTwoConsecutive
        }

    }.postLevel(1)
    aocSolution(4) {
        (240920..789857).asSequence().filter { it in 100_000..999_999 }.count { number ->
            var currentMax = 0
            val consecutive = mutableMapOf<Int, Int>()
            number.splitIntoDigits().forEach { digit ->
                when {
                    digit < currentMax -> return@count false
                }
                consecutive[digit] = consecutive.getOrDefault(digit, 0) + 1
                currentMax = digit
            }
            consecutive.containsValue(2)
        }

    }.postLevel(2)
}


fun day3() {
    val posSet = mutableMapOf<Vector, Int>()
    var minDistance: Int = 10000000

    aocSolution(3) {

        first().let {
            var steps = 0
            val s = it.split(",")
            var currentPos = Vector(0, 0)
            s.forEach {
                try {
                    val direction = when (it.first()) {
                        'R' -> Vector(1, 0)
                        'L' -> Vector(-1, 0)
                        'U' -> Vector(0, 1)
                        'D' -> Vector(0, -1)
                        else -> throw Exception()
                    }
                    val iterations = it.drop(1).toInt()
                    for (x in 0 until iterations) {
                        steps += 1
                        currentPos += direction
                        if (!posSet.containsKey(currentPos)) {
                            posSet[currentPos] = steps
                        }

                    }

                } catch (e: Exception) {
                }
            }
        }

        this[1].let {

            val s = it.split(",")
            var steps = 0
            var currentPos = Vector(0, 0)
            s.forEach {
                try {
                    val direction = when (it.first()) {
                        'R' -> Vector(1, 0)
                        'L' -> Vector(-1, 0)
                        'U' -> Vector(0, 1)
                        'D' -> Vector(0, -1)
                        else -> throw Exception()
                    }
                    val iterations = it.drop(1).toInt()
                    for (x in 0 until iterations) {
                        currentPos += direction
                        steps += 1
                        if (posSet.containsKey(currentPos)) {

                            val dist = posSet[currentPos]!! + steps
                            if (dist < minDistance) {
                                minDistance = dist
                            }

                        }
                    }

                } catch (e: Exception) {
                }
            }
        }

        minDistance
    }
}


fun day2() {

    aocSolution(2) {
        joinToString(",").split(",").mapToIntNotNull().toMutableList().let { list ->
            list[1] = 12
            list[2] = 2
            iterate(4) { i ->
                when (list[i]) {
                    1 -> list[list[i + 3]] = list[list[i + 1]] + list[list[i + 2]]
                    2 -> list[list[i + 3]] = list[list[i + 1]] * list[list[i + 2]]
                    99 -> return@aocSolution list[0]
                }
            }
        }
        0
    }.postLevel(1)

    aocSolution(2) {
        joinToString(",").split(",").mapToIntNotNull().toTypedArray().let { list ->
            for (x in 0..100) {
                for (y in 0..100) {
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
                    } catch (e: Exception) {
                    }
                }
            }
        }
        0
    }.postLevel(2)
}

fun day1() {
    fun calculateFuel1(fuel: Int) = fuel / 3 - 2

    fun calculateFuel2(fuel: Int): Int = calculateFuel1(fuel).let {
        if (it > 0) it + calculateFuel2(it) else 0
    }

    aocSolution(1) {
        mapToIntNotNull().map(::calculateFuel1).sum()
    }.postLevel(1)

    aocSolution(1) {
        mapToIntNotNull().map(::calculateFuel2).sum()
    }.postLevel(2)

}

