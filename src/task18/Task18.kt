//Задание 18: Конструктор
//Усовершенствуйте программу для авиакомпании.
//Пусть свойства: максимальная дальность полета и вместимость бака определяются через конструктор.
package task18

fun main(args: Array<String>) {
    val aircraft = Aircraft(201.2, 100.5)
    println("Расход топлива - ${aircraft.fuelConsumption} л/100км")
}

class Aircraft(val maximumRange: Double, val tankCapacity: Double) {
    val fuelConsumption
        get() = tankCapacity / maximumRange * 100
}
