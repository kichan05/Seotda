package player

import GameUi
import util.BattingOption
import java.util.Base64
import java.util.Scanner

class Human(money: Int = defaultMoney) : Player(money){

    override fun batting(): BattingOption {
        GameUi.printBattingOption()
        GameUi.printSystemMessage("원하는 배팅을 선택하세요 : ")
        val selectOption = Scanner(System.`in`).nextInt()

        return when(selectOption - 1) {
            BattingOption.CALL.ordinal -> {
                BattingOption.CALL
            }
            BattingOption.DDADANG.ordinal -> {
                BattingOption.DDADANG
            }
            BattingOption.DIE.ordinal -> {
                BattingOption.DIE
            }
            else -> BattingOption.DIE
        }
    }

    override fun toString(): String {
        return "Human(nums=$nums money=$_money)"
    }
}