import java.sql.Date

fun main() {

    val StudentData = "34234, Максюта Станислва Витальевич, https://github.com/Stanislavsky/Patterns.git, +79182660030"
    val student = Student(StudentData)

    println(student.id)
    println(student.fullName)
    println(student.git)
    println(student.contact)

    println(student.getInfo())

}