import util.Color
import java.util.StringJoiner

object GameUi {
    private fun getColorString(message : String, color : Color) : String {
        return color.fontColor + message + Color.RESET.fontColor
    }

    private fun printSystemMessage(message : String) {
        println(getColorString(message, Color.PURPLE))
    }

    private fun printLine(length : Int = 20) {
        val line = StringJoiner("")
        for (i in 0..length) {
            line.add("-")
        }
        println(line.toString())
    }

    /**
     * 전체 사용자의 데이터를 목룍 형식으로 출력한다.
     * */
    fun showPlayerList() {
        val playerList = GameSystem.getPlayerList

        for ((n, i) in playerList.withIndex()) {
            if(n == 0){
                print("${Color.BOLD.fontColor}${Color.BLUE.fontColor}플레이어\t\t")
            }
            else {
                print("${Color.RED.fontColor}인공지능 $n\t")
            }

            print("${i.getNumber(0)}, ${i.getNumber(1)}\t")
            print("${i.getMoney()}억원")
            println(Color.RESET.fontColor)
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
}