import player.AlphaSeotda
import player.Human
import player.Player

object GameSystem {
    private val _playersList : MutableList<Player> = mutableListOf()
    val getPlayerList : List<Player>
        get() =  _playersList

    val getHuman : Player
        get() = _playersList[0]

    fun main() {
        initGame()

        GameUi.showHumanInfo()
    }

    private fun initGame() {
        val human = Human(20).apply {
            addNumber((0..9).random())
            addNumber((0..9).random())
        }
        _playersList.add(human)

        for (i in 0..6) {
            val alphaSeotda = AlphaSeotda().apply {
                addNumber((0..9).random())
                addNumber((0..9).random())
            }
            _playersList.add(alphaSeotda)
        }
    }
}