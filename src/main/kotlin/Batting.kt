import util.BattingOption.*

class Batting {
    private var battingMoney: Int = 0
    private var lastMoney: Int = 1

    fun run() {
        val players = GameSystem.getPlayerList.filter { !it.isDeath() }

        for (i in players) {
            val playerBattingMoney = i.batting()

            when (playerBattingMoney) {
                CALL -> {
                    GameUi.printBattingMessage(i, CALL, battingMoney + lastMoney)
                    battingMoney += lastMoney
                }
                DDADANG -> {
                    GameUi.printBattingMessage(i, DDADANG, battingMoney + lastMoney * 2)
                    battingMoney += lastMoney * 2
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