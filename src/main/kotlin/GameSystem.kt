import player.AlphaSeotda
import player.Human
import player.Player

object GameSystem {
    val players : MutableList<Player> = mutableListOf()

    fun initGame() {
        players.add(Human())
        for(i in 0..7){
            players.add(AlphaSeotda())
        }
    }
}