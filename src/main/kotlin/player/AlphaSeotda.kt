package player

import util.BattingOption

class AlphaSeotda(name : String, money : Int) : Player(name, money) {
    override fun batting(lastBattingMoney: Int): BattingOption {
        if(getMoney() < lastBattingMoney)
            return BattingOption.DIE

        if(getScore().isDDeng && getMoney() > lastBattingMoney * 2)
            return BattingOption.DDADANG

        if(getScore().number in 5..9)
            return BattingOption.CALL

        return BattingOption.DIE
    }

    override fun toString(): String {
        return "AlphaSeotda(nums=$nums money=$_money)"
    }
}