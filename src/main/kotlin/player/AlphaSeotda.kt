package player

import util.BattingOption

class AlphaSeotda(name : String, money : Int = defaultMoney) : Player(name, money) {
    override fun batting(): BattingOption {
        return BattingOption.DDADANG
    }

    override fun toString(): String {
        return "AlphaSeotda(nums=$nums money=$_money)"
    }
}