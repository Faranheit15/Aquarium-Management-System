import java.util.*

fun main(args: Array<String>) {
    println("Aquarium Management System")
    feedTheFish()
}
fun shouldChangeWater(day: String, temperature: Int=22, dirty: Int=20): Boolean {
        val isTooHot=temperature>30
        val isDirty=dirty>30
        val isSunday=day=="Sunday"
        return when {
            isTooHot(temperature) -> true
            isDirty(dirty) -> true
            isSunday(day)->true
            else->false
        }
}
var dirty=20

val waterFilter: (Int) -> Int = {dirty -> dirty/2}
fun feedFish(dirty: Int) = dirty+10

fun updateDirty(dirty: Int, operation : (Int) -> Int) : Int {
    return operation(dirty)
}

fun dirtyProcessor() {
    dirty=updateDirty(dirty,waterFilter)
    dirty=updateDirty(dirty, ::feedFish)
    dirty=updateDirty(dirty, {dirty->
        dirty+50
    })
}

fun isTooHot(temperature: Int)=temperature>30
fun isDirty(dirty: Int)=dirty>30
fun isSunday(day: String)=day=="Sunday"
fun shouldChangeWater2(temperature: Int=22, dirty: Int=20, day: String){
}
fun feedTheFish() {
    val day=randomDay()
    val food=fishFood(day)
    println("The day is $day and $food have to be fed to the fish today")
    shouldChangeWater(day, 20, 50)
    shouldChangeWater(day)
    shouldChangeWater(day, 50)
    shouldChangeWater2(day="Momday")
    if(shouldChangeWater(day)) {
        println("Change the water today")
    }
    else {
        println("Aquarium is clean as of now")
    }

    dirtyProcessor()
}
fun randomDay(): String {
    val week=listOf("Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday")
    return week[Random().nextInt(7)];
}
fun fishFood(day: String):String {
    return when(day) {
        "Sunday"->"flakes"
        "Monday"->"pellets"
        "Tuesday"->"redworms"
        "Wednesday"->"granules"
        "Thursday"->"mosquitoes"
        "Friday"->"plankton"
        "Saturday"->"grains"
        else->"fasting"
    }
}