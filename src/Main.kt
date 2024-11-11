import java.sql.Date

fun main() {

    val StudentData = "34234, Максюта Станислва Витальевич, https://github.com/Stanislavsky/Patterns.git, +79182660030"
    val Student = Student(StudentData)

    println(Student.id)
    println(Student.fullName)
    println(Student.git)
    println(Student.contact)

}