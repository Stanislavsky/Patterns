class Student(
    private var id: Int,
    private var lastName: String,
    private var firstName: String,
    private var middleName: String,
    private var phone: String? = null,
    private var telegram: String? = null,
    private var email: String? = null,
    private var gitHub: String? = null
) {
    fun getId(): Int {
        return id
    }
    fun getLastName(): String {
        return lastName
    }
    fun getFirstName(): String {
        return firstName
    }
    fun getMiddleName(): String? {
        return middleName
    }
    fun getPhone(): String? {
        return phone
    }
    fun getTelegram(): String? {
        return telegram
    }
    fun getEmail(): String? {
        return email
    }
    fun getGitHub(): String? {
        return gitHub
    }
    fun setId(newId: Int) {
        id = newId
    }
    fun setLastName(newLastName: String) {
        lastName = newLastName
    }
    fun setFirstName(newFirstName: String) {
        firstName = newFirstName
    }
    fun setMiddleName(newMiddleName: String) {
        middleName = newMiddleName
    }
    fun setPhone(newPhone: String?) {
        phone = newPhone
    }
    fun setTelegram(newTelegram: String?) {
        telegram = newTelegram
    }
    fun setEmail(newEmail: String?) {
        email = newEmail
    }
    fun setGitHub(newGitHub: String?) {
        gitHub = newGitHub
    }
    fun showInfo(): String {
        return """
            ID: $id
            Фамилия: $lastName
            Имя: $firstName
            Отчество: ${middleName}
            Телефон: ${phone ?: "Не указан"}
            Телеграм: ${telegram ?: "Не указан"}
            Почта: ${email ?: "Не указана"}
            Гит: ${gitHub ?: "Не указан"}
        """.trimIndent()
    }
}