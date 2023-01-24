package player

import util.BattingOption
import util.SeotdaCombination

abstract class Player(val name : String, protected var _money : Int) {
    fun minuseMoney(money : Int) {
        if(this._money < money)
            throw java.lang.Exception("돈이 부족합니다.")

        this._money -= money
    }
    fun addMoney(money : Int) {
        this._money += money
    }

    fun getMoney() : Int {
        return _money
    }

    protected val nums : MutableList<Int> = mutableListOf()
    fun addNumber(num : Int) {
        nums.add(num)
    }
    fun getNumber(index : Int) : Int {
        if(index > nums.size) {
            throw Exception("Index out of bounds")
        }

        return nums[index]
    }
    fun getScore() : SeotdaCombination {
        if(nums[0] == nums[1]){
            return SeotdaCombination(nums[0], true)
        }

        return SeotdaCombination((nums[0] + nums[1]) % 10, false)
    }

    private var _isDeath : Boolean = false
    fun deathInit() {
        _isDeath = false
    }
    fun killPlayer() {
        _isDeath = true
    }
    fun isDeath() : Boolean {
        return _isDeath
    }

    abstract fun batting(lastBattingMoney : Int) : BattingOption
}