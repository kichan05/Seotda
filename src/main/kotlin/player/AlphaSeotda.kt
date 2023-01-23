package player

import util.BattingOption

class AlphaSeotda(money : Int = defaultMoney) : Player(money) {
    override fun batting(): BattingOption {
        return BattingOption.DDADANG
    }

    override fun toString(): String {
        return "AlphaSeotda(nums=$nums money=$_money)"
    }
}