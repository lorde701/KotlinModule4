//Задание 23: Data class
//Создайте data класс для автомобилей. Он должен содержать марку автомобиля, цвет и номер.
//Выведите информацию об автомобилях в консоль.

package task23

fun main(args: Array<String>) {
    val car1 = Car("Alfa Romeo", "black", "123e")
    val car2 = Car("Aston Martin", "red", "159r")
    val car3 = Car("Audi", "green", "458t")

    println(car1)
    println(car2)
    println(car3)
}

data class Car(val brand: String, val color: String, val number: String)
