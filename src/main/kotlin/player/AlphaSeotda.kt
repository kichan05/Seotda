package player

class AlphaSeotda(money : Int) : Player(money) {
    constructor() : this(defaultMoney)

    override fun getScore(): Int {
        TODO("Not yet implemented")
    }

    override fun toString(): String {
        return "AlphaSeotda(nums=$nums money=$money)"
    }
}