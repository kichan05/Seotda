import player.AlphaSeotda
import player.Human
import player.Player

object GameSystem {
    val players: MutableList<Player> = mutableListOf()

    fun main() {
        initGame()

        for (i in players) {
            println(i)
        }
    }

    private fun initGame() {
        val human = Human(20).apply {
            addNumber((0..9).random())
            addNumber((0..9).random())
        }
        players.add(human)

        for (i in 0..7) {
            val alphaSeotda = AlphaSeotda().apply {
                addNumber((0..9).random())
                addNumber((0..9).random())
            }
            players.add(alphaSeotda)
        }
    }
}