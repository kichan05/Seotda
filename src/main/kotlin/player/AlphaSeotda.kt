package player

import Batting
import util.BattingOption

class AlphaSeotda(name : String, money : Int) : Player(name, money) {
    override fun batting(lastBattingMoney: Int): BattingOption {
        return BattingOption.values().toList().shuffled().first()
    }

    override fun toString(): String {
        return "AlphaSeotda(nums=$nums money=$_money)"
    }
}