package player

class Human(money: Int) : Player(money){
    constructor() : this(defaultMoney)

    override fun getScore(): Int {
        TODO("Not yet implemented")
    }

    override fun toString(): String {
        return "Human(nums=$nums money=$_money)"
    }
}