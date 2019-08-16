//Задание 24: Итоговое задание
//1. Создайте в программе для авиакомпании еще пару классов, описывающих различные модели самолетов.
//Сделайте один из них грузовым, для этого создайте соответствующий интерфейс со свойством грузоподъёмность.
//2. Создайте интерфейс в консоли для пользователя, где пользователь может запрашивать информацию по моделям самолетов.
//Интерфейс должен отображать список команд, а пользователь в свою очередь выбирает номер команды.

package task24

fun main(args: Array<String>) {
    val boeing = Boeing747(14205.0, 214140.0, 624)
    val mig = Mig29(2000.0, 5830.0)
    val an = An24(1850.0, 4850.0, 6500.0)

    println("boeing:")
    boeing.printInfo()
    println("\nmig:")
    mig.printInfo()
    println("\nan:")
    an.printInfo()

}

class Boeing747(maximumRange: Double, tankCapacity: Double, override val passengerCapacity: Int)
    : Aircraft(maximumRange, tankCapacity), Passenger {
    override fun printInfo() {
        super.printInfo()
        println("Вместимость пассажиров - $passengerCapacity")
    }
}

class Mig29(maximumRange: Double, tankCapacity: Double) : Aircraft(maximumRange, tankCapacity)

class An24(maximumRange: Double, tankCapacity: Double, override val carryingCapacity: Double)
    : Aircraft(maximumRange, tankCapacity), Cargo {
    override fun printInfo() {
        super.printInfo()
        println("Грузоподъемность - $carryingCapacity")
    }
}


abstract class Aircraft(var maximumRange: Double, var tankCapacity: Double) {
    protected val fuelConsumption
        get() = tankCapacity / maximumRange * 100

    open fun printInfo() = println("""Максимальная дальность полета - $maximumRange
        |Вместимость бака - $tankCapacity"""
            .trimMargin())
}

interface Passenger {
    val passengerCapacity: Int
}

interface Cargo {
    val carryingCapacity: Double
}