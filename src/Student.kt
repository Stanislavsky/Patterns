import java.lang.Exception

class Student(var id: Int, var fullName: String, var git: String, var contact: String) {


    constructor(data: String) : this(
        id = try {
            val parts = data.split(",")
            if (parts.size != 4) throw IllegalArgumentException("Неверное количество данных в строке. Ожидаются 4 значения.")

            
            val idValue = parts[0].trim().toInt()
            if (idValue <= 0) throw IllegalArgumentException("ID должен быть положительным числом.")
            idValue
        } catch (e: Exception) {
            throw IllegalArgumentException("Ошибка при парсинге ID: ${e.message}")
        },

        fullName = try {
            val parts = data.split(",")
            val fullNameValue = parts[1].trim()
            if (fullNameValue.isEmpty()) throw IllegalArgumentException("ФИО не может быть пустым.")
            fullNameValue
        } catch (e: Exception) {
            throw IllegalArgumentException("Ошибка при парсинге ФИО: ${e.message}")
        },

        git = try {
            val parts = data.split(",")
            val gitValue = parts[2].trim()
            if (gitValue.isEmpty() || !gitValue.startsWith("https://")) throw IllegalArgumentException("Git репозиторий должен начинаться с https://")
            gitValue
        } catch (e: Exception) {
            throw IllegalArgumentException("Ошибка при парсинге Git репозитория: ${e.message}")
        },

        contact = try {
            val parts = data.split(",")
            val contactValue = parts[3].trim()
            // Простая валидация контактного номера (например, номер телефона)
            if (contactValue.isEmpty() || !contactValue.matches("\\+?\\d{10,15}".toRegex())) {
                throw IllegalArgumentException("Номер телефона должен быть валидным и содержать только цифры.")
            }
            contactValue
        } catch (e: Exception) {
            throw IllegalArgumentException("Ошибка при парсинге контакта: ${e.message}")
        }
    )
}