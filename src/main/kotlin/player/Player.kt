package player

import util.BattingOption

abstract class Player(protected var _money : Int) {
    fun minuseMoney(money : Int) {
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
    fun getScore() : Int {
        TODO("Not yet implemented")
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

    abstract fun batting() : BattingOption

    companion object {
        const val defaultMoney = 20
    }
}