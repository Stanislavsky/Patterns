import java.sql.Date

fun main() {

//    val StudentData = "34234, Максюта Станислва Витальевич, https://github.com/Stanislavsky/Patterns.git, +79182660030"
//    val student = Student(StudentData)

//    println(student.id)
//    println(student.fullName)
//    println(student.git)
//    println(student.contact)

//    println(student.getInfo())

//    val student2 = Student(1, "Иван Иванович Иванов", "https://github.com/ivan", "+79001234567")
//    val studentShort = Student_short(student2)
//    println(studentShort.git)
//
//    val studentShort2 = Student_short(1, "Иван И., https://github.com/lelik, +79001234567")
//    println(studentShort2.git)

//    val studentData = " 1, Максюта Станисалв Витальевич, https://github.com/johndoe, +72345678901"
//    val student = Student(studentData)
//    println("Student Info: ${student.getInfo()}")
//    val students = student.read_from_txt("src/students.txt")
//    println("Список студентов:")
//    students.forEach { student ->
//        println(student.getInfo())
//    }

//    val filePath = "src/"
//    val fileName = "students_output.txt"
//
//    try {
//        student.write_to_txt(filePath, fileName, students)
//        println("Список студентов успешно записан в файл $fileName.")
//    } catch (e: Exception) {
//        println("Произошла ошибка при записи в файл: ${e.message}")
//    }

//    val tableData = arrayOf(
//        arrayOf(1, "John", 25),
//        arrayOf(2, "Jane", 30)
//    )
//
//    val dataTable = Data_table(tableData)
//
//    println("Количество строк: ${dataTable.rowCount()}")
//    println("Количество столбцов: ${dataTable.columnCount()}")
//
//    println("Элемент в строке 1, столбце 1: ${dataTable.getElement(1, 1)}")
//    println("Элемент в строке 2, столбце 2: ${dataTable.getElement(1, 2)}")

    val numbers = listOf(5, 2, 8, 3, 1)
    val dataList = Data_list(numbers)

    println("Все элементы в Data_list (упорядоченные): ${dataList.getElements()}")

    try {
        val selectedElement = dataList.select(2)
        println("Элемент с индексом 2: $selectedElement")
    } catch (e: IndexOutOfBoundsException) {
        println("Ошибка: ${e.message}")
    }

    try {
        val invalidElement = dataList.select(10)
        println("Элемент с индексом 10: $invalidElement")
    } catch (e: IndexOutOfBoundsException) {
        println("Ошибка: ${e.message}")
    }
}