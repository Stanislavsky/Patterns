fun main() {
    val student1 = Student(1, "Ivanov", "Ivan", "Ivanovich", phone = "+79001112233")
    val student2 = Student(2, "Petrov", "Petr", "Petrovich", telegram = "@petr")
    val student3 = Student(3, "Sidorov", "Sidr", "Sidrvich", email = "sidorov@example.com", gitHub = "github.com/sidorov")
    println(student1.showInfo())
    println(student2.showInfo())
    println(student3.showInfo())
}