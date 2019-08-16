//Задание 19: Авиакомпания 3. Наследование
//Создадим наследника класса Aircraft с названием Boeing747 и добавим ему свойство, обозначающее вместимость пассажиров
package task19

fun main(args: Array<String>) {
    val boeing1 = Boeing747(10.0, 12.0, 14)
    val boeing2: Aircraft
    boeing2 = Boeing747(100.0, 100.0, 200)
    println("Расход топлива boeing1- ${boeing1.fuelConsumption}, вместимость пассажиров boeing1 - ${boeing1.passengerCapacity}")
    println("Расход топлива boeing2 - ${boeing2.fuelConsumption}, вместимость пассажиров boeing2 - ${boeing2.passengerCapacity}")
}

class Boeing747(maximumRange: Double, tankCapacity: Double, var passengerCapacity: Int) : Aircraft(maximumRange, tankCapacity)


open class Aircraft(var maximumRange: Double, var tankCapacity: Double) {
    val fuelConsumption
        get() = tankCapacity / maximumRange * 100
}