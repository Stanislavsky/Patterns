fun main() {

    val params = mapOf(
        "id" to 1,
        "lastName" to "Ivanov",
        "firstName" to "Ivan",
        "middleName" to "Ivanovich",
        "phone" to "+79001112233",
        "email" to "ivanov@example.com"
    )
    val student = Student(params)
    println(student.toString())
}