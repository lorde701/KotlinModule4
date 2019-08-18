//Задание 22: Авиакомпания 6. Вывод информации
//1. Создайте в классе Aircraft функцию для вывода характеристик самолетов в консоль.
//2. Переопределите данную функцию в классе Boeing747, так чтобы еще выводилась информация о пассажирах
//3. Сделайте свойства обоих классов видимыми только внутри этих классов и их наследниках, кроме свойства наследуемого от интерфейса.
// Свойства и функции интерфейсов не поддерживают модификатор protected и internal
package task22

fun main(args: Array<String>) {
    val boeing1 = Boeing747(10.0, 12.0, 14)
    val boeing2: Aircraft = Boeing747(100.0, 100.0, 200)

    println("Первый:")
    boeing1.printInfo()
    println("\nВторой:")
    boeing2.printInfo()
}

class Boeing747(maximumRange: Double, tankCapacity: Double, override val passengerCapacity: Int)
    : Aircraft(maximumRange, tankCapacity), Passenger {
    override fun printInfo() {
        super.printInfo()
        println("Вместимость пассажиров - $passengerCapacity")
    }
}

abstract class Aircraft(protected val maximumRange: Double, protected val tankCapacity: Double) {
    protected val fuelConsumption
        get() = tankCapacity / maximumRange * 100

    open fun printInfo() {
        println("""Максимальная дальность полета - $maximumRange
        |Вместимость бака - $tankCapacity"""
                .trimMargin())
    }
}

interface Passenger {
    val passengerCapacity: Int
}