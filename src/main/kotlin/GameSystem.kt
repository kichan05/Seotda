import player.AlphaSeotda
import player.Human
import player.Player
import util.BattingOption

object GameSystem {
    private const val BATTING_MAX_COUNT = 3
    private const val PLAYER_DEFAULT_MONEY = 100


    private val _playersList : MutableList<Player> = mutableListOf()
    val getPlayerList : List<Player>
        get() =  _playersList

    val getHuman : Player
        get() = _playersList[0]


    fun main() {
        initGame()

        var battingCount = BATTING_MAX_COUNT
        val batting = Batting()

        while(_playersList.filter { !it.isDeath() }.size >= 2 || battingCount > 0){
            println("${batting.battingMoney}억 적립")
            batting.run()

            battingCount--
        }
        println("총 ${batting.battingMoney}억 배팅")

        GameUi.showHumanInfo()
    }

    private fun initGame() {
        val human = Human("플.레.이.어", PLAYER_DEFAULT_MONEY).apply {
            addNumber((0..9).random())
            addNumber((0..9).random())
        }
        _playersList.add(human)

        for (i in 0..6) {
            val alphaSeotda = AlphaSeotda("인공지능 ${i + 1}", PLAYER_DEFAULT_MONEY).apply {
                addNumber((0..9).random())
                addNumber((0..9).random())
            }
            _playersList.add(alphaSeotda)
        }
    }
}