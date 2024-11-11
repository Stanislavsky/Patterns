class Student(
    id: Int,
    fullName: String,
    git: String,
    contact: String
): StudentBase(id, fullName, git, contact) {

    constructor(data: String) : this(
        id = parseId(data),
        fullName = parseFullName(data),
        git = parseGit(data),
        contact = parseContact(data)
    )
}