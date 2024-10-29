data class Student(
    private var id: Int,
    private var lastName: String,
    private var firstName: String,
    private var email: String? = null,
    private var gitHub: String? = null
)
{
    override fun toString(): String
    {
        return """
            ID: $id
            Фамилия: $lastName
            Имя: $firstName
            Отчество: ${middleName ?: "Не указано"}
            Телефон: ${phone ?: "Не указан"}
            Телеграм: ${telegram ?: "Не указан"}
            Почта: ${email ?: "Не указана"}
            Гит: ${gitHub ?: "Не указан"}
        """.trimIndent()
    }

    override fun equals(other: Any?): Boolean
    {
        if (this === other) return true
        if (other !is Student) return false
        return id == other.id
    }

}
