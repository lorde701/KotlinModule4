//Задание 21: Авиакомпания 5. Абстрактный класс
//Усовершенствуем программу так, чтобы нельзя было создать неопределенный тип самолета: сделайте класс Aircraft абстрактным.
package task21

fun main(args: Array<String>) {
    val boeing1 = Boeing747(10.0, 12.0, 14)
    val boeing2: Aircraft
    boeing2 = Boeing747(100.0, 100.0, 200)

    println("Расход топлива boeing1- ${boeing1.fuelConsumption}, вместимость пассажиров boeing1 - ${boeing1.passengerCapacity}")
    println("Расход топлива boeing2 - ${boeing2.fuelConsumption}, вместимость пассажиров boeing2 - ${boeing2.passengerCapacity}")
}

class Boeing747(maximumRange: Double, tankCapacity: Double, override val passengerCapacity: Int)
    : Aircraft(maximumRange, tankCapacity), Passenger

abstract class Aircraft(val maximumRange: Double, val tankCapacity: Double) {
    val fuelConsumption
        get() = tankCapacity / maximumRange * 100
}

interface Passenger {
    val passengerCapacity: Int
}


