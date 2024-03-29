//Задание 20: Авиакомпания 4. Интерфейс
//Изменим реализацию пассажирских самолетов. Создадим Интерфейс с названием Passenger со свойством, обозначающим вместимость пассажиров.
// Уберем это свойство у класса Boeing747 и реализуем в нем новый интерфейс.
package task20

fun main(args: Array<String>) {
    val boeing1 = Boeing747(10.0, 12.0, 14)
    val boeing2: Aircraft = Boeing747(100.0, 100.0, 200)
    val passenger: Passenger = Boeing747(1.0, 2.0, 3)

    println("Расход топлива boeing1- ${boeing1.fuelConsumption}, вместимость пассажиров boeing1 - ${boeing1.passengerCapacity}")
    println("Расход топлива boeing2 - ${boeing2.fuelConsumption}")
    println("Вместимость пассажиров boeing2 - ${passenger.passengerCapacity}")
}

class Boeing747(maximumRange: Double, tankCapacity: Double, override val passengerCapacity: Int)
    : Aircraft(maximumRange, tankCapacity), Passenger

open class Aircraft(val maximumRange: Double, val tankCapacity: Double) {
    val fuelConsumption
        get() = tankCapacity / maximumRange * 100
}

interface Passenger {
    val passengerCapacity: Int
}

