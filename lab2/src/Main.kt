fun main() {
    // Создание тестовых данных
    val students = listOf(
        Student_short(1, "Иванов И.И.", "https://github.com/ivanov", "+79001234567"),
        Student_short(2, "Петров П.П.", "https://github.com/petrov", "+79007654321"),
        Student_short(3, "Сидоров С.С.", "https://github.com/sidorov", "+79009876543")
    )

    // Создание объекта Data_list_student_short
    val dataList = Data_list_student_short(students)

    // Получение таблицы данных
    val dataTable = dataList.get_data()

    // Тестирование вывода таблицы
    println("Таблица данных:")
    dataTable.data.forEach { row ->
        println(row.joinToString(" | "))
    }

    // Тестирование получения заголовков
    println("\nЗаголовки: ${dataList.get_names()}")

    // Тестирование выбора студента
    val selectedStudent = dataList.select(1)
    println("\nВыбранный студент:")
    println("Full Name: ${selectedStudent.fullName}")
    println("Git: ${selectedStudent.git}")
    println("Contact: ${selectedStudent.contact}")
}
