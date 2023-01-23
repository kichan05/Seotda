package player

abstract class Player(var money : Int) {
    fun minuseMoney(money : Int) {
        this.money -= money
    }
    fun addMoney(money : Int) {
        this.money += money
    }

    private val nums : MutableList<Int> = mutableListOf()
    fun addNumber(num : Int) {
        nums.add(num)
    }
    fun getNumber(index : Int) : Int {
        if(index > nums.size) {
            throw Exception("Index out of bounds")
        }

        return nums[index]
    }
    abstract fun getScore() : Int

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
}