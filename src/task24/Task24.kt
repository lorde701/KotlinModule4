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
    val aircrafts = listOf<Aircraft>(mig, an, boeing)

    while (true) {
        println("\nСписок самолетов:")
        aircrafts.withIndex().forEach { (index, aircraft) -> println("${index + 1}. ${aircraft.name}") }
        println("Выберите номер самолета. Для выхода введите 0.")
        val choice = try {
            readLine().toString().toInt()
        } catch (e: NumberFormatException) {
            println("Введите число")
            continue
        }
        when (choice) {
            0 -> return
            in 1..aircrafts.size  -> aircrafts[choice - 1].printInfo()
            else -> println("Введите число из диапазона 0 - ${aircrafts.size}")
        }
    }
}

class Boeing747(maximumRange: Double, tankCapacity: Double, override val passengerCapacity: Int)
    : Aircraft("Боинг-747", maximumRange, tankCapacity), Passenger {
    override fun printInfo() {
        super.printInfo()
        println("Вместимость пассажиров - $passengerCapacity")
    }
}

class Mig29(maximumRange: Double, tankCapacity: Double) : Aircraft("МИГ-29", maximumRange, tankCapacity)

class An24(maximumRange: Double, tankCapacity: Double, override val carryingCapacity: Double)
    : Aircraft("АН-24", maximumRange, tankCapacity), Cargo {
    override fun printInfo() {
        super.printInfo()
        println("Грузоподъемность - $carryingCapacity")
    }
}


abstract class Aircraft(val name: String, val maximumRange: Double, val tankCapacity: Double) {
    protected val fuelConsumption
        get() = tankCapacity / maximumRange * 100

    open fun printInfo() {
        println("""Модель самолета - $name
        |Максимальная дальность полета - $maximumRange
        |Вместимость бака - $tankCapacity"""
                .trimMargin())
    }
}

interface Passenger {
    val passengerCapacity: Int
}

interface Cargo {
    val carryingCapacity: Double
}