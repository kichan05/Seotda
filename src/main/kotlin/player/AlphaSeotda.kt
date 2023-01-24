package player

import util.BattingOption

class AlphaSeotda(name : String, money : Int) : Player(name, money) {
    override fun batting(lastBattingMoney: Int): BattingOption {
//        return BattingOption.values().toList().shuffled()[0]

        if(lastBattingMoney * 2 <= _money) {
            return BattingOption.DDADANG
        }

        if(lastBattingMoney <= _money) {
            return BattingOption.CALL
        }

        return BattingOption.DIE
    }

    override fun toString(): String {
        return "AlphaSeotda(nums=$nums money=$_money)"
    }
}