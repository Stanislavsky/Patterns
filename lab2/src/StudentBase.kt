open class StudentBase(
    var id: Int,
    var fullName: String,
    var git: String,
    var contact: String
) {

    // Шаблонный метод
    fun formatDataTemplate(): String {
        val header = formatHeader()
        val body = formatBody()
        return "$header\n$body"
    }

    // Общая часть (может быть неизменной)
    open fun formatHeader(): String {
        return "ID, Full Name, Git, Contact"
    }

    // Специфическая часть (реализуется в наследниках)
    open fun formatBody(): String {
        return "$id, $fullName, $git, $contact"
    }
}