//Задание 18: Конструктор
//Усовершенствуйте программу для авиакомпании. Пусть свойства: максимальная дальность полета и вместимость бака определяются через конструктор.

fun main(args: Array<String>) {
    val aircraft = Aircraft2(201.2, 100.5)
    println("Расход топлива - ${aircraft.fuelConsumption} л/100км")
}

class Aircraft2(var maximumRange: Double, var tankCapacity: Double) {
    val fuelConsumption
        get() = tankCapacity / maximumRange * 100
}
