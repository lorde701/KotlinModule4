//Задание 17: Авиакомпания
//Поможем авиакомпании в создании программы для учета авиапарка.
//Создайте класс Aircraft и реализуйте в нем свойства, содержащие следующее: максимальная дальность полета, вместимость бака, расход топлива на 100 км.
//Переопределите геттер свойства, содержащего расход топлива, чтобы он самостоятельно рассчитывался из свойств дальности полета и вместимости бака.
package task17

fun main(args: Array<String>) {
    val aircraft = Aircraft()
    aircraft.maximumRange = 201.2 //в км
    aircraft.tankCapacity = 100.5 //в л
    println("Расход топлива - ${aircraft.fuelConsumption} л/100км")
}

class Aircraft() {
    var maximumRange: Double = 0.0
    var tankCapacity: Double = 0.0

    val fuelConsumption
        get() = tankCapacity / maximumRange * 100
}

