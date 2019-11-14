package io.github.acenolaza

class Game(var startShore: State = State(3, 3, true),
           var endShore: State = State(0, 0, false)) {

    fun start() {
        do {
            crossRiver()
        } while (!everyoneHasCrossed())

        println("*".repeat(24))
        println("******* YOU WIN! *******")
        println("*".repeat(24))
    }

    private fun crossRiver() {
        println("* Start shore")
        printShore(startShore)
        println()
        println("* End shore")
        printShore(endShore)

        print("Enter FIRST animal to board ('W' for wolf and 'M' for monkey: ")
        val firstAnimal = getAnimalType(readLine()) ?: run {
            println("Must select a valid FIRST animal. Try again...")
            return
        }

        print("Enter SECOND animal to board ('W' for wolf and 'M' for monkey or click 'ENTER' for single animal ride: ")
        val secondAnimal = getAnimalType(readLine())

        tryCrossing(Boat(Pair(firstAnimal, secondAnimal)))
    }

    private fun printShore(shore: State) {
        for (i in 1..8) {
            for (j in 1..11) {
                if (i == 1 || i == 8 || j == 1 || j == 11)
                    print("*")
                else if (i == 3 && j == 5)
                    print("W")
                else if (i == 3 && j == 7)
                    print("M")
                else if (i == 4 && j == 5)
                    print(shore.wolves)
                else if (i == 4 && j == 7)
                    print(shore.monkeys)
                else if (i == 6 && j == 3 && shore.hasBoat)
                    print("__/|\\__")
                else if (i == 6 && j in 4..9 && shore.hasBoat)
                    continue
                else if (i == 7 && j == 3 && shore.hasBoat)
                    print("\\_____/")
                else if (i == 7 && j in 4..9 && shore.hasBoat)
                    continue
                else
                    print(" ")
            }
            println()
        }
    }

    private fun getAnimalType(input: String?): AnimalType? {
        return input?.let {
            if (input.isEmpty()) return null
            AnimalType.valueOf(input[0].toUpperCase()) ?: run {
                println("ERROR: Invalid selection")
                return null
            }
        }
    }

    fun tryCrossing(boat: Boat): Boolean {
        val startShoreCopy = State(startShore.wolves, startShore.monkeys, !startShore.hasBoat)
        val endShoreCopy = State(endShore.wolves, endShore.monkeys, !endShore.hasBoat)

        boat.animals.toList().forEach { animalType ->
            when (animalType) {
                AnimalType.WOLF -> {
                    if (startShore.hasBoat) {
                        startShoreCopy.wolves--
                        endShoreCopy.wolves++
                    } else {
                        startShoreCopy.wolves++
                        endShoreCopy.wolves--
                    }
                }
                AnimalType.MONKEY -> {
                    if (startShore.hasBoat) {
                        startShoreCopy.monkeys--
                        endShoreCopy.monkeys++
                    } else {
                        startShoreCopy.monkeys++
                        endShoreCopy.monkeys--
                    }
                }
            }
        }

        println(startShoreCopy)
        println(endShoreCopy)

        return if (startShoreCopy.isValid() && endShoreCopy.isValid()) {
            startShore = startShoreCopy
            endShore = endShoreCopy
            true
        } else false
    }

    fun everyoneHasCrossed(): Boolean {
        return endShore.wolves == 3 && endShore.monkeys == 3 && endShore.hasBoat
    }
}

data class State(
    var wolves: Int,
    var monkeys: Int,
    var hasBoat: Boolean
)

fun State.isValid(): Boolean {
    return this.wolves >= 0 && this.monkeys >= 0 && (this.wolves <= this.monkeys || this.monkeys == 0)
}

data class Boat(val animals: Pair<AnimalType, AnimalType?>)

enum class AnimalType(val type: Char) {
    WOLF('W'),
    MONKEY('M');

    companion object {
        fun valueOf(value: Char) = values().find { it.type == value }
    }
}