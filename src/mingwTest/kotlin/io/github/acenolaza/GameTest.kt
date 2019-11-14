package io.github.acenolaza

import kotlin.test.*

class GameTest {
    private var game: Game? = null

    @BeforeTest
    fun init() {
        game = Game(
            State(3, 3, true),
            State(0, 0, false)
        )
    }

    // Valid options
    @Test
    fun tryCrossingOneWolfAndOneMonkeyTest() {
        assertTrue(game!!.tryCrossing(Boat(Pair(AnimalType.WOLF, AnimalType.MONKEY))))
    }

    @Test
    fun tryCrossingOneMonkeyAndOneWolfTest() {
        assertTrue(game!!.tryCrossing(Boat(Pair(AnimalType.MONKEY, AnimalType.WOLF))))
    }

    @Test
    fun tryCrossingTwoWolvesTest() {
        assertTrue(game!!.tryCrossing(Boat(Pair(AnimalType.WOLF, AnimalType.WOLF))))
    }

    @Test
    fun tryCrossingOneWolfTest() {
        assertTrue(game!!.tryCrossing(Boat(Pair(AnimalType.WOLF, null))))
    }

    // Invalid options
    @Test
    fun tryCrossingTwoMonkeysTest() {
        assertFalse(game!!.tryCrossing(Boat(Pair(AnimalType.MONKEY, AnimalType.MONKEY))))
    }

    @Test
    fun tryCrossingOneMonkeysTest() {
        assertFalse(game!!.tryCrossing(Boat(Pair(AnimalType.MONKEY, null))))
    }

    // Solve game
    @Test
    fun solveGameTest() {
        assertTrue(game!!.tryCrossing(Boat(Pair(AnimalType.WOLF, AnimalType.MONKEY))))
        assertTrue(game!!.endShore.hasBoat)
        assertTrue(game!!.tryCrossing(Boat(Pair(AnimalType.MONKEY, null))))
        assertTrue(game!!.startShore.hasBoat)
        assertTrue(game!!.tryCrossing(Boat(Pair(AnimalType.WOLF, AnimalType.WOLF))))
        assertTrue(game!!.endShore.hasBoat)
        assertTrue(game!!.tryCrossing(Boat(Pair(AnimalType.WOLF, null))))
        assertTrue(game!!.startShore.hasBoat)
        assertTrue(game!!.tryCrossing(Boat(Pair(AnimalType.MONKEY, AnimalType.MONKEY))))
        assertTrue(game!!.endShore.hasBoat)
        assertTrue(game!!.tryCrossing(Boat(Pair(AnimalType.WOLF, AnimalType.MONKEY))))
        assertTrue(game!!.startShore.hasBoat)
        assertTrue(game!!.tryCrossing(Boat(Pair(AnimalType.MONKEY, AnimalType.MONKEY))))
        assertTrue(game!!.endShore.hasBoat)
        assertTrue(game!!.tryCrossing(Boat(Pair(AnimalType.WOLF, null))))
        assertTrue(game!!.startShore.hasBoat)
        assertTrue(game!!.tryCrossing(Boat(Pair(AnimalType.WOLF, AnimalType.WOLF))))
        assertTrue(game!!.endShore.hasBoat)
        assertTrue(game!!.tryCrossing(Boat(Pair(AnimalType.MONKEY, null))))
        assertTrue(game!!.startShore.hasBoat)
        assertTrue(game!!.tryCrossing(Boat(Pair(AnimalType.WOLF, AnimalType.MONKEY))))
        assertTrue(game!!.endShore.hasBoat)

        assertEquals(3, game!!.endShore.wolves)
        assertEquals(3, game!!.endShore.monkeys)
    }
}