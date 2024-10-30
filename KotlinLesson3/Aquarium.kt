import kotlin.math.PI

/**
 * zhifu chen
 */
// part 2 start
class AquariumPart2 {
    var width: Int = 20
    var height: Int = 40
    var length: Int = 100
    fun printSize() {
        println(
            "Width: $width cm " +
                    "Length: $length cm " +
                    "Height: $height cm "
        )
    }
}

fun buildAquariumPart2() {
    val myAquarium = AquariumPart2()
    myAquarium.printSize()
    myAquarium.height = 60
    myAquarium.printSize()
}

// part 2 end

//part 3 start
open class AquariumPart3(var length: Int = 100, var width: Int = 20, open var height: Int = 40) {
    // step 1
    fun printSize() {
        println(
            "Width: $width cm " +
                    "Length: $length cm " +
                    "Height: $height cm "
        )

        // 1 liter = 1000 cm^3
        println("Volume: $volume liters")

        println(shape)
        println(
            "Width: $width cm " +
                    "Length: $length cm " +
                    "Height: $height cm "
        )
        // 1 l = 1000 cm^3
        println("Volume: $volume liters Water: $water liters (${water / volume * 100.0}% full)")
    }

    //step 2 start
    init {
        println("aquarium initializing")
    }

    init {
        // 1 liter = 1000 cm^3
        println("Volume: ${width * length * height / 1000} liters")
    }
    // step 2 end

    // step 3 start
    constructor(numberOfFish: Int) : this() {
        // 2,000 cm^3 per fish + extra room so water doesn't spill
        val tank = numberOfFish * 2000 * 1.1
    }
    // step 3 end

//    var volume: Int
//        get() = width * height * length / 1000
//        set(value) {
//            height = (value * 1000) / (width * length)
//        }

    open var volume: Int
        get() = width * height * length / 1000
        set(value) {
            height = (value * 1000) / (width * length)
        }

    open val shape = "rectangle"

    open var water: Double = 0.0
        get() = volume * 0.9

}

class TowerTank(override var height: Int, var diameter: Int) :
    AquariumPart3(height = height, width = diameter, length = diameter) {
    override var volume: Int
        // ellipse area = π * r1 * r2
        get() = (width / 2 * length / 2 * height / 1000 * PI).toInt()
        set(value) {
            height = ((value * 1000 / PI) / (width / 2 * length / 2)).toInt()
        }
    override var water = volume * 0.8
    override val shape = "cylinder"
}

fun buildAquariumPart3() {
    val aquarium1 = AquariumPart3()
    aquarium1.printSize()
    // default height and length
    val aquarium2 = AquariumPart3(width = 25)
    aquarium2.printSize()
    // default width
    val aquarium3 = AquariumPart3(height = 35, length = 110)
    aquarium3.printSize()
    // everything custom
    val aquarium4 = AquariumPart3(width = 25, height = 35, length = 110)
    aquarium4.printSize()

    val aquarium6 = AquariumPart3(numberOfFish = 29)
    aquarium6.printSize()
    println("Volume: ${aquarium6.width * aquarium6.length * aquarium6.height / 1000} liters")

    val aquarium7 = AquariumPart3(numberOfFish = 29)
    aquarium7.printSize()
    aquarium7.volume = 70
    aquarium7.printSize()

    val aquarium8 = AquariumPart3(length = 25, width = 25, height = 40)
    aquarium8.printSize()

    val myTower = TowerTank(diameter = 25, height = 40)
    myTower.printSize()
}


fun main() {
    buildAquariumPart2()

    buildAquariumPart3()
}