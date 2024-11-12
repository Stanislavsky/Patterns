import java.io.File
import java.io.IOException

open class StudentBase(
    var id: Int,
    var fullName: String,
    var git: String,
    var contact: String
) {

    companion object
    {
        fun parseData(data: String): List<String> {
            val parts = data.split(",").map { it.trim() }
            if (parts.size != 4) {
                throw IllegalArgumentException("Неверное количество данных в строке. Ожидаются 4 значения.")
            }
            return parts
        }

        fun parseId(data: String): Int {
            val parts = parseData(data)
            val idValue = parts[0].toIntOrNull()
                ?: throw IllegalArgumentException("Ошибка при парсинге ID: ID должно быть числом.")
            if (idValue <= 0) throw IllegalArgumentException("ID должен быть положительным числом.")
            return idValue
        }

        fun parseFullName(data: String): String {
            val parts = parseData(data)
            val fullName = parts[1]
            if (fullName.isEmpty()) throw IllegalArgumentException("ФИО не может быть пустым.")
            return fullName
        }

        fun parseGit(data: String): String {
            val parts = parseData(data)
            val git = parts[2]
            if (git.isEmpty() || !git.startsWith("https://")) {
                throw IllegalArgumentException("Git репозиторий должен начинаться с https://")
            }
            return git
        }

        fun parseContact(data: String): String {
            val parts = parseData(data)
            val contact = parts[3]
            if (contact.isEmpty() || !contact.matches("\\+?\\d{10,15}".toRegex())) {
                throw IllegalArgumentException("Номер телефона должен быть валидным и содержать только цифры.")
            }
            return contact
        }
    }

    fun read_from_txt(filePath: String): List<Student> {
        val file = File(filePath)
        if (!file.exists() || !file.canRead()) {
            throw IllegalArgumentException("Некорректный путь к файлу или файл не доступен для чтения.")
        }

        val students = mutableListOf<Student>()

        try {
            file.forEachLine { line ->
                try {
                    val student = Student(line)
                    students.add(student)
                } catch (e: Exception) {
                    throw IllegalArgumentException("Ошибка при парсинге данных для строки: '$line'. ${e.message}")
                }
            }
        } catch (e: IOException) {
            throw IOException("Ошибка при чтении файла: ${e.message}")
        }

        return students
    }

    private fun getInitials(): String {
        val parts = fullName.split(" ")
        val lastName = parts[0]
        val initials = if (parts.size > 1) {
            parts[1].take(1) + "." + parts[2].take(1)
        } else {
            ""
        }
        return "$lastName $initials"
    }

    open fun getInfo(): String {
        val initials = getInitials()
        return "$initials; $git; $contact"
    }
}