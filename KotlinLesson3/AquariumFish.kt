/**
 * zhifu chen
 */
abstract class AquariumFish {
    abstract val color: String
}

class Shark : AquariumFish(), FishAction {
    override val color = "grey"
    override fun eat() {
        println("hunt and eat fish")
    }
}

class Plecostomus : AquariumFish(), FishAction {
    override val color = "gold"
    override fun eat() {
        println("eat algae")
    }
}

fun makeFish() {
    val shark = Shark()
    val pleco = Plecostomus()

    println("Shark: ${shark.color}")
    shark.eat()
    println("Plecostomus: ${pleco.color}")
    pleco.eat()
}

interface FishAction {
    fun eat()
}

abstract class AquariumFish2 : FishAction {
    abstract val color: String
    override fun eat() = println("yum")
}

interface FishColor {
    val color: String
}

class Plecostomus2 : FishAction, FishColor {
    override val color = "gold"
    override fun eat() {
        println("eat algae")
    }
}

class Shark2 : FishAction, FishColor {
    override val color = "grey"
    override fun eat() {
        println("hunt and eat fish")
    }
}

object GoldColor : FishColor {
    override val color = "gold"
}

class Plecostomus3 : FishAction, FishColor by GoldColor {
    override fun eat() {
        println("eat algae")
    }
}

class Plecostomus4(fishColor: FishColor = GoldColor) : FishAction,
    FishColor by fishColor {
    override fun eat() {
        println("eat algae")
    }
}

class PrintingFishAction(val food: String) : FishAction {
    override fun eat() {
        println(food)
    }
}

class Plecostomus5(fishColor: FishColor = GoldColor) :
    FishAction by PrintingFishAction("eat algae"),
    FishColor by fishColor

fun main() {
    makeFish()
}