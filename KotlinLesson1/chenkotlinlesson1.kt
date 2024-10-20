/**
 * zhifu chen
 */

fun part2Step1ExploreNumericOperators() {
    println("1 + 1 = ${1 + 1}")
    println("53 - 3 = ${53 - 3}")
    println("50 / 10 = ${50 / 10}")
    println("1.0 / 2.0 = ${1.0 / 2.0}")
    println("2.0 * 3.5 = ${2.0 * 3.5}")
    println("6 * 50 = ${6 * 50}")
    println("6.0 * 50.0 = ${6.0 * 50.0}")
    println("6.0 * 50 = ${6.0 * 50}")

    println("2.times(3) = ${2.times(3)}")
    println("3.5.plus(4) = ${3.5.plus(4)}")
    println("2.4.div(2) = ${2.4.div(2)}")
}

fun part2Step2PracticeUsingTypes() {
    val i: Int = 6
    val b1 = i.toByte()
    println(b1)

    val b2: Byte = 1 // OK, literals are checked statically
    println(b2)

    //error: val i1: Int = b2
    //error: val i1: Int = b2
    //error: val i2: String = b2
    //error: val i3: Double = b2
    val i4: Int = b2.toInt() // OK!
    println(i4)

    val i5: String = b2.toString()
    println(i5)

    val i6: Double = b2.toDouble()
    println(i6)

    val oneMillion = 1_000_000
    val socialSecurityNumber = 999_99_9999L
    val hexBytes = 0xFF_EC_DE_5E
    val bytes = 0b11010010_01101001_10010100_10010010
}

fun part2Step3LearnTheValueOfVariableTypes() {
    var fish = 1
    fish = 2
    val aquarium = 1
    //aquarium = 2
    var lakes: Double = 2.5
}

fun part2Step4LearnAboutStringsAndCharacters() {
    val numberOfFish = 5
    val numberOfPlants = 12
    println("I have $numberOfFish fish and $numberOfPlants plants")
    println("I have ${numberOfFish + numberOfPlants} fish and plants")
}

fun part3() {
    val numberOfFish = 50
    val numberOfPlants = 23
    if (numberOfFish > numberOfPlants) {
        println("Good ratio!")
    } else {
        println("Unhealthy ratio")
    }

    val fish = 50
    if (fish in 1..100) {
        println(fish)
    }

    if (numberOfFish == 0) {
        println("Empty tank")
    } else if (numberOfFish < 40) {
        println("Got fish!")
    } else {
        println("That's a lot of fish!")
    }

    when (numberOfFish) {
        0 -> println("Empty tank")
        in 1..39 -> println("Got fish!")
        else -> println("That's a lot of fish!")
    }
}

fun part4Step1LearnAboutNullability() {
    // error: var rocks: Int = null
    var marbles: Int? = null
}

fun part4Step2LearnAboutOperators() {
    var fishFoodTreats: Int? = 6
    if (fishFoodTreats != null) {
        fishFoodTreats = fishFoodTreats.dec()
    }

    fishFoodTreats = fishFoodTreats?.dec()

    fishFoodTreats = fishFoodTreats?.dec() ?: 0

    var s = ""
    val len = s!!.length   // throws NullPointerException if s is null
}

fun part5Step1MakeLists() {
    val school = listOf("mackerel", "trout", "halibut")
    println(school)

    val myList = mutableListOf("tuna", "salmon", "shark")
    println(myList.remove("shark"))
}

fun part5Step2CreateArrays() {
    val school = arrayOf("shark", "salmon", "minnow")
    println(java.util.Arrays.toString(school))
    val mix = arrayOf("fish", 2)
    println(mix)

    val numbers = intArrayOf(1, 2, 3)

    val numbers3 = intArrayOf(4, 5, 6)
    val foo2 = numbers3 + numbers
    println(foo2[5])

    val oceans = listOf("Atlantic", "Pacific")
    val oddList = listOf(numbers, oceans, "salmon")
    println(oddList)

    val array = Array(5) { it * 2 }
    println(java.util.Arrays.toString(array))
}

fun part5Step3CreateLoops() {
    val school = arrayOf("shark", "salmon", "minnow")
    for (element in school) {
        print(element + " ")
    }

    for ((index, element) in school.withIndex()) {
        println("Item at $index is $element\n")
    }

    for (i in 1..5) print(i)
    for (i in 5 downTo 1) print(i)
    for (i in 3..6 step 2) print(i)
    for (i in 'd'..'g') print(i)

    var bubbles = 0
    while (bubbles < 50) {
        bubbles++
    }
    println("$bubbles bubbles in the water\n")

    do {
        bubbles--
    } while (bubbles > 50)
    println("$bubbles bubbles in the water\n")

    repeat(2) {
        println("A fish is swimming")
    }

}

fun main() {
    part2Step1ExploreNumericOperators()
    part2Step2PracticeUsingTypes()
    part2Step3LearnTheValueOfVariableTypes()
    part2Step4LearnAboutStringsAndCharacters()

    part3()

    part4Step1LearnAboutNullability()
    part4Step2LearnAboutOperators()

    part5Step1MakeLists()
    part5Step2CreateArrays()
    part5Step3CreateLoops()
}