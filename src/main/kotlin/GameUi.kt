import player.Player
import util.BattingOption
import util.Color
import java.util.StringJoiner

object GameUi {
    private fun getColorString(message: String, color: Color): String {
        return color.fontColor + message + Color.RESET.fontColor
    }

    fun printSystemMessage(message: String) {
        println(getColorString(message, Color.PURPLE))
    }

    private fun printLine(length: Int = 20) {
        val line = StringJoiner("")
        for (i in 0..length) {
            line.add("-")
        }
        println(line.toString())
    }

    /*
     * 전체 사용자의 데이터를 목룍 형식으로 출력한다.
     * */
    fun showPlayerList() {
        val playerList = GameSystem.getPlayerList

        for ((n, i) in playerList.withIndex()) {
            if (n == 0) {
                print("${Color.BOLD.fontColor}${Color.BLUE.fontColor}플레이어\t\t")
            } else {
                print("${Color.RED.fontColor}인공지능 $n\t")
            }

            print("${i.getNumber(0)}, ${i.getNumber(1)}\t")
            print("${i.getMoney()}억원")
            println(Color.RESET.fontColor)
            printLine()
        }
    }

    /*
    * 사용자의 정보를 화면에 보여준다.
    * */
    fun showHumanInfo() {
        printLine()

        val player = GameSystem.getHuman
        printSystemMessage("내 정보")
        println("보유 숫자 : ${player.getNumber(0)}, ${player.getNumber(1)}")
        println("보유 금액 : ${player.getMoney()}억원")

        printLine()
    }

    /*
    사용자에게 보여주는 배팅 옵션 목록 출력
    * */
    fun printBattingOption(lastBattingMoney : Int) {
        printSystemMessage("배팅 옵션")
        for (i in BattingOption.values()) {
            print("${i.ordinal + 1}. ${i.nameKo} ")
            when(i) {
                BattingOption.CALL -> {
                    println("(${lastBattingMoney}억 배팅)")
                }
                BattingOption.DDADANG -> {
                    println("(${lastBattingMoney * 2}억 배팅)")
                }
                BattingOption.DIE -> {
                   println()
                }
            }
        }
        printLine()
    }

    /*
    * 플레이어 배팅 알림
    * */
    fun printBattingMessage(player: Player, battingOption: BattingOption, addMoney : Int, totalMoney: Int) {
        val message = "${getColorString(player.name, Color.CYAN)}님이 " +
                      "${getColorString(battingOption.nameKo, Color.YELLOW)}(${addMoney}억), " +
                      "총 배팅액 : ${getColorString("${totalMoney}억", Color.YELLOW)}"

        println(message)
    }

    /*
    플레이어 다이 알림
    * */
    fun printPlayerDieMessage(player: Player) {
        println("${getColorString(player.name, Color.CYAN)}님이 ${getColorString("다이", Color.RED)} 하셨습니다.")
    }
}