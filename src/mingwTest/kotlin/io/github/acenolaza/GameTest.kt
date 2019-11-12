package io.github.acenolaza

import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class GameTest {

    @Test
    fun tryCrossingTest() {
        val game = Game(
            State(3, 3, true),
            State(0, 0, false)
        )

        // Valid options
        assertTrue(game.tryCrossing(Boat(Pair(AnimalType.WOLF, AnimalType.MONKEY))))
        assertTrue(game.tryCrossing(Boat(Pair(AnimalType.MONKEY, AnimalType.WOLF))))
        assertTrue(game.tryCrossing(Boat(Pair(AnimalType.WOLF, AnimalType.WOLF))))
        assertTrue(game.tryCrossing(Boat(Pair(AnimalType.WOLF, null))))

        // Invalid options
        assertFalse(game.tryCrossing(Boat(Pair(AnimalType.MONKEY, AnimalType.MONKEY))))
        assertFalse(game.tryCrossing(Boat(Pair(AnimalType.MONKEY, null)))) // Why true?
    }
}