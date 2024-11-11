import java.sql.Date

class Car(var brand: String, var color: String, var dateOfManufacture: Date, var speed: Int) {

    // Вторичный конструктор, который принимает строку инициализации
    constructor(data: String) : this(
        brand = data.split(",")[0].trim(),
        color = data.split(",")[1].trim(),
        dateOfManufacture = Date.valueOf(data.split(",")[2].trim()),
        speed = data.split(",")[3].trim().toInt()
    )
}

