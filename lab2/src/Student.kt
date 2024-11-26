class Student(
    id: Int,
    fullName: String,
    git: String,
    contact: String
) : StudentBase(id, fullName, git, contact) {

    override fun formatBody(): String {
        return "$id: $fullName ($git), Contact: $contact"
    }
}