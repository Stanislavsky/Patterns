data class Student(
    private var id: Int,
    private var lastName: String,
    private var firstName: String,
    private var middleName: String,
    private var phone: String? = null,
    private var telegram: String? = null,
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
            Отчество: ${middleName}
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

        fun isValidEmail(email: String?): Boolean {
            return email?.matches(Regex("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$")) ?: false
        }

        fun isValidGitHub(gitHub: String?): Boolean {
            return gitHub?.startsWith("github.com/") ?: false
        }

        fun validate(gitHub: String?, phone: String?, telegram: String?, email: String?): Boolean {
            if (gitHub == null) {
                throw IllegalArgumentException("Требуется гитхаб")
            }
            if (phone == null && telegram == null && email == null) {
                println("Требуется хотя бы один контакт (номер телефона, телеграм или почта)")
                println("Дальше введите контактные данные")
            }
            return true
        }
    }
    init {
        if (validate(gitHub, phone, telegram, email))
        {
            if (phone == null && email == null && telegram == null)
            {
                setContacts()
            }
            
            if (phone != null && !isValidPhone(phone)) {
                throw IllegalArgumentException("Неверный номер телефона: $phone")
            }
            if (email != null && !isValidEmail(email)) {
                throw IllegalArgumentException("Неверная почта: $email")
            }
            if (!isValidGitHub(gitHub))
            {
                throw IllegalArgumentException("Неверный гитхаб: $gitHub")
            }
        }
    fun setContacts(newPhone: String? = readln(), newTelegram: String? = readln(), newEmail: String? = readln()) {
        if (newPhone != null && newPhone != "")
            phone = newPhone
        if (newTelegram != null && newPhone != "")
            telegram = newTelegram
        if (newEmail != null && newEmail != "")
            email = newEmail
    }
}
