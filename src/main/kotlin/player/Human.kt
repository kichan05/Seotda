package player

import GameUi
import util.BattingOption
import java.util.Scanner

class Human(name : String, money: Int) : Player(name, money){
    override fun batting(lastBattingMoney: Int): BattingOption {
        GameUi.showHumanInfo()
        while (true){
            GameUi.printBattingOption(lastBattingMoney)
            GameUi.printSystemMessage("원하는 배팅을 선택하세요 : ")
            val selectOption = Scanner(System.`in`).nextInt()

            when(selectOption - 1) {
                BattingOption.CALL.ordinal -> {
                    if(lastBattingMoney > _money) {
                        GameUi.printSystemMessage("배팅 금액이 부족합니다.")
                        continue
                    }

                    return BattingOption.CALL
                }
                BattingOption.DDADANG.ordinal -> {
                    if (lastBattingMoney * 2 > _money){
                        GameUi.printSystemMessage("배팅 금액이 부족합니다.")
                        continue
                    }

                    return BattingOption.DDADANG
                }
                BattingOption.DIE.ordinal -> {
                    GameUi.printSystemMessage("죽음을 선택하셨습니다.")
                    return BattingOption.DIE
                }
                else -> {
                    GameUi.printSystemMessage("올바른 값을 입력해주세요.")
                    continue
                }
            }
        }
    }

    override fun toString(): String {
        return "Human(nums=$nums money=$_money)"
    }
}