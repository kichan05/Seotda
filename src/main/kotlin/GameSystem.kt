import player.AlphaSeotda
import player.Human
import player.Player
import util.BattingOption

object GameSystem {
    private val _playersList : MutableList<Player> = mutableListOf()
    val getPlayerList : List<Player>
        get() =  _playersList

    val getHuman : Player
        get() = _playersList[0]


    fun main() {
        initGame()

        GameUi.showHumanInfo()

        val batting = Batting()
        val battingMoney = batting.run()
        println("총 ${battingMoney}억 배팅")

        GameUi.showHumanInfo()
    }

    private fun initGame() {
        val human = Human("플.레.이.어").apply {
            addNumber((0..9).random())
            addNumber((0..9).random())
        }
        _playersList.add(human)

        for (i in 0..6) {
            val alphaSeotda = AlphaSeotda("인공지능 ${i + 1}").apply {
                addNumber((0..9).random())
                addNumber((0..9).random())
            }
            _playersList.add(alphaSeotda)
        }
    }
}