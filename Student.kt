data class Student(
    private var id: Int,
    private var lastName: String,
    private var firstName: String,
    private var email: String? = null,
    private var gitHub: String? = null
)

{
    constructor(params: Map<String, Any>) : this(
        id = params["id"] as Int,
        lastName = params["lastName"] as String,
        firstName = params["firstName"] as String,
        middleName = params["middleName"] as String,
        phone = params["phone"] as String?,
        telegram = params["telegram"] as String?,
        email = params["email"] as String?,
        gitHub = params["gitHub"] as String?
    )

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

    companion object {
        fun isValidPhone(phone: String?): Boolean {
            return phone?.matches(Regex("""^\+7\d{1,10}${'$'}""")) ?: false
        }
    }
    init {
        if (phone != null && !isValidPhone(phone)) {
            throw IllegalArgumentException("Неверный номер телефона: $phone")
        }
    }

}
