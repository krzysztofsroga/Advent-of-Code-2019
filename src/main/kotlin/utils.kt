fun Int.splitIntoDigits(): List<Int> {
    if (this < 10) return listOf(this)
    return (this / 10).splitIntoDigits() + this % 10
}


class Vector(val x: Int, val y: Int) {
    operator fun plus(other: Vector): Vector {
        return Vector(x + other.x, y + other.y)
    }

    operator fun minus(other: Vector): Vector {
        return Vector(x - other.x, y - other.y)
    }

    override operator fun equals(other: Any?): Boolean {
        if (other is Vector) {
            if (x == other.x && y == other.y) {
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

fun cmp(s1: String, s2: String) {
    s1.zip(s2).count { it.first == it.second }
}

inline fun iterate(step: Int = 1, block: (Int) -> Unit) {
    var i = 0
    while (true) {
        block(i)
        i += step
    }
}

fun Iterable<String>.mapToIntNotNull(): List<Int> = mapNotNull { it.toIntOrNull() }

fun <T> MutableList<T>.pop(): T {
    return removeAt(size - 1)
}

