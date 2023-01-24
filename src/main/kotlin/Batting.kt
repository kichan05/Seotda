import util.BattingOption.*

class Batting {
    private var _battingMoney: Int = 0
    val battingMoney : Int
        get() = _battingMoney

    private var lastMoney: Int = 1

    fun run() {
        val players = GameSystem.getPlayerList.filter { !it.isDeath() }

        for (i in players) {
            val playerBattingMoney = i.batting(lastMoney)

            when (playerBattingMoney) {
                CALL -> {
                    GameUi.printBattingMessage(i, CALL, lastMoney, _battingMoney + lastMoney)
                    i.minuseMoney(lastMoney)
                    _battingMoney += lastMoney
                }
                DDADANG -> {
                    GameUi.printBattingMessage(i, DDADANG, lastMoney * 2, _battingMoney + lastMoney * 2)
                    i.minuseMoney(lastMoney * 2)
                    _battingMoney += lastMoney * 2
                    lastMoney *= 2
                }
                DIE -> {
                    i.killPlayer()

                    GameUi.printPlayerDieMessage(i)
                }
            }
        }
    }
}