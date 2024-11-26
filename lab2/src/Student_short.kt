class Student_short(
    ID: Int,
    fullNameInitials: String,
    git: String,
    contact: String
) : StudentBase(ID, fullNameInitials, git, contact) {

    override fun formatBody(): String {
        return "$id: $fullName (Initials), Git: $git"
    }
}