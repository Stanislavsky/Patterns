import java.sql.Date

fun main() {

    val StudentData = "34234, Максюта Станислва Витальевич, https://github.com/Stanislavsky/Patterns.git, +79182660030"
    val student = Student(StudentData)

//    println(student.id)
//    println(student.fullName)
//    println(student.git)
//    println(student.contact)

//    println(student.getInfo())

    val student2 = Student(1, "Иван Иванович Иванов", "https://github.com/ivan", "+79001234567")
    val studentShort = Student_short(student2)
    println(studentShort.git)

    val studentShort2 = Student_short(1, "Иван И., https://github.com/lelik, +79001234567")
    println(studentShort2.git)

}