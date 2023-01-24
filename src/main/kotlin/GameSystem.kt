import player.AlphaSeotda
import player.Human
import player.Player

object GameSystem {
    private const val BATTING_MAX_COUNT = 5
    private const val PLAYER_DEFAULT_MONEY = 100

    private val _playersList : MutableList<Player> = mutableListOf()
    val getPlayerList : List<Player>
        get() =  _playersList

    val getHuman : Player
        get() = _playersList[0]

    private var battingMoney : Int = 0


    fun main() {
        initGame()
        batting()
        decisionWinner()
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
    private fun batting() {
        var battingCount = BATTING_MAX_COUNT
        val batting = Batting()
        while(_playersList.filter { !it.isDeath() }.size >= 3 && battingCount > 0){
            batting.run()

            battingCount--
        }

        battingMoney = batting.battingMoney
        println("총 ${battingMoney}억 배팅")
    }
    private fun decisionWinner() {
        val alivePlayer = _playersList.filter { !it.isDeath() }
        if(alivePlayer.isEmpty()){
            GameUi.printNoneWinner()
            return
        }

        var winnerPlayer = alivePlayer[0]
        for(i in alivePlayer.slice(1 until alivePlayer.size)){
            if(winnerPlayer.getScore().isDDeng){
                if(i.getScore().isDDeng){
                    if(winnerPlayer.getScore().number < i.getScore().number || i.getScore().number == 0){
                        winnerPlayer = i
                    }
                }
            }
            else {
                if(winnerPlayer.getScore().number < i.getScore().number){
                    winnerPlayer = i
                }
            }
        }

        GameUi.showWinner(winnerPlayer)
    }
}