import java.sql.Date

class Car(var brand: String, var color: String, var dateOfManufacture: Date, var speed: Int) {

    // Вторичный конструктор, который принимает строку инициализации
    constructor(data: String) : this(
        brand = try {
            val parts = data.split(",")
            if (parts.size != 4) throw IllegalArgumentException("Неверное количество данных в строке. Ожидаются 4 значения.")

            val brandValue = parts[0].trim()
            if (brandValue.isEmpty()) throw IllegalArgumentException("Марка автомобиля не может быть пустой.")
            brandValue
        } catch (e: Exception) {
            throw IllegalArgumentException("Ошибка при парсинге марки: ${e.message}")
        },

        // Аналогичная логика для других параметров
        color = try {
            val parts = data.split(",")
            val colorValue = parts[1].trim()
            if (colorValue.isEmpty()) throw IllegalArgumentException("Цвет автомобиля не может быть пустым.")
            colorValue
        } catch (e: Exception) {
            throw IllegalArgumentException("Ошибка при парсинге цвета: ${e.message}")
        },

        dateOfManufacture = try {
            val parts = data.split(",")
            val dateString = parts[2].trim()
            Date.valueOf(dateString)
        } catch (e: Exception) {
            throw IllegalArgumentException("Ошибка при парсинге даты производства: ${e.message}")
        },

        speed = try {
            val parts = data.split(",")
            val speedValue = parts[3].trim().toInt()
            if (speedValue < 0) throw IllegalArgumentException("Скорость не может быть отрицательной.")
            speedValue
        } catch (e: Exception) {
            throw IllegalArgumentException("Ошибка при парсинге скорости: ${e.message}")
        }
    )
}

