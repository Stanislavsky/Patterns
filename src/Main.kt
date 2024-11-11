import java.sql.Date

fun main() {

    val carData = "Toyota, Red, 2022-01-01, 180"
    val car = Car(carData)

    println(car.color)
    println(car.brand)
    println(car.speed)
    println(car.dateOfManufacture)
}