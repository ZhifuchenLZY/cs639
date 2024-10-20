/**
 * zhifu chen
 */
import java.util.*

fun printHello() {
    println("Hello World")
}

//part 3 step1 start
fun randomDay(): String {
    val week = arrayOf("Monday", "Tuesday", "Wednesday", "Thursday",
            "Friday", "Saturday", "Sunday")
    return week[Random().nextInt(week.size)]
}

fun part3Step1feedTheFish() {
    val day = randomDay()
    val food = "pellets"
    println("Today is $day and the fish eat $food")
}
//part 3 step1 end

//part 3 step 2 start
fun fishFood1(day: String): String {
    var food = ""
    when (day) {
        "Monday" -> food = "flakes"
        "Tuesday" -> food = "pellets"
        "Wednesday" -> food = "redworms"
        "Thursday" -> food = "granules"
        "Friday" -> food = "mosquitoes"
        "Saturday" -> food = "lettuce"
        "Sunday" -> food = "plankton"
    }
    return food
}

fun fishFood2(day: String): String {
    val food: String
    when (day) {
        "Monday" -> food = "flakes"
        "Wednesday" -> food = "redworms"
        "Thursday" -> food = "granules"
        "Friday" -> food = "mosquitoes"
        "Sunday" -> food = "plankton"
        else -> food = "nothing"
    }
    return food
}

fun fishFood3(day: String): String {
    return when (day) {
        "Monday" -> "flakes"
        "Wednesday" -> "redworms"
        "Thursday" -> "granules"
        "Friday" -> "mosquitoes"
        "Sunday" -> "plankton"
        else -> "nothing"
    }
}

fun part3Step2FeedTheFish() {
    val day = randomDay()
    val food1 = fishFood1(day)
    println("Today is $day and the fish eat $food1")

    val food2 = fishFood2(day)
    println("Today is $day and the fish eat $food2")

    val food3 = fishFood3(day)
    println("Today is $day and the fish eat $food3")
}
//part 3 step 2 end

//part 4 step 1 start
fun swim(speed: String = "fast") {
    println("swimming $speed")
}
//part 4 step 1 end

//part 4 step 2 start
fun shouldChangeWater(day: String, temperature: Int = 22, dirty: Int = 20): Boolean {
    return when {
        temperature > 30 -> true
        dirty > 30 -> true
        day == "Sunday" -> true
        else -> false
    }
}

fun feedTheFish() {
    val day = randomDay()
    val food = fishFood3(day)
    println("Today is $day and the fish eat $food")
    println("Change water: ${shouldChangeWater(day)}")
}
//part 4 step 2 end

//part 4 step 3 start
fun isTooHot(temperature: Int) = temperature > 30

fun isDirty(dirty: Int) = dirty > 30

fun isSunday(day: String) = day == "Sunday"

fun shouldChangeWater2(day: String, temperature: Int = 22, dirty: Int = 20): Boolean {
    return when {
        isTooHot(temperature) -> true
        isDirty(dirty) -> true
        isSunday(day) -> true
        else -> false
    }
}
//part 4 step 3 end

//part 6 step 2 start
fun updateDirty(dirty: Int, operation: (Int) -> Int): Int {
    return operation(dirty)
}

fun increaseDirty(start: Int) = start + 1

//part 6 step 2 end
fun main(args: Array<String>) {
    //part1
    //step1
    printHello()
    //step2
    println("Hello, world!")
    //step4
    println("Hello, ${args[0]}")

    //part2
    // Will assign kotlin.Unit
    val isUnit = println("This is an expression")
    println(isUnit)
    val temperature = 10
    val isHot = if (temperature > 50) true else false
    println(isHot)
    val message = "The water temperature is ${if (temperature > 50) "too warm" else "OK"}."
    println(message)

    //part 3 step1
    part3Step1feedTheFish()

    //part 3 step 2
    part3Step2FeedTheFish()

    //part 4 step 1
    swim()   // uses default speed
    swim("slow")   // positional argument
    swim(speed = "turtle-like")   // named parameter

    //part 4 step 2
    feedTheFish()

    //part 5 step 1
    val decorations = listOf("rock", "pagoda", "plastic plant", "alligator", "flowerpot")
    println(decorations.filter { it[0] == 'p' })

    //part 5 step 2
    // eager, creates a new list
    val eager = decorations.filter { it[0] == 'p' }
    println("eager: $eager")
    // lazy, will wait until asked to evaluate
    val filtered = decorations.asSequence().filter { it[0] == 'p' }
    println("filtered: $filtered")
    // force evaluation of the lazy list
    val newList = filtered.toList()
    println("new list: $newList")
    val lazyMap = decorations.asSequence().map {
        println("access: $it")
        it
    }
    println("lazy: $lazyMap")
    println("-----")
    println("first: ${lazyMap.first()}")
    println("-----")
    println("all: ${lazyMap.toList()}")
    val lazyMap2 = decorations.asSequence().filter { it[0] == 'p' }.map {
        println("access: $it")
        it
    }
    println("-----")
    println("filtered: ${lazyMap2.toList()}")
    val mysports = listOf("basketball", "fishing", "running")
    val myplayers = listOf("LeBron James", "Ernest Hemingway", "Usain Bolt")
    val mycities = listOf("Los Angeles", "Chicago", "Jamaica")
    val mylist = listOf(mysports, myplayers, mycities)     // list of lists
    println("-----")
    println("Flat: ${mylist.flatten()}")

    //part 6 step 1
    var dirtyLevel = 20
    val waterFilter1 = { dirty: Int -> dirty / 2 }
    println(waterFilter1(dirtyLevel))
    val waterFilter2: (Int) -> Int = { dirty -> dirty / 2 }

    //part 6 step 2
    val waterFilter: (Int) -> Int = { dirty -> dirty / 2 }
    println(updateDirty(30, waterFilter))
    println(updateDirty(15, ::increaseDirty))

    var dirtyLevel2 = 19
    dirtyLevel2 = updateDirty(dirtyLevel2) { dirtyLevel2 -> dirtyLevel2 + 23 }
    println(dirtyLevel2)
}