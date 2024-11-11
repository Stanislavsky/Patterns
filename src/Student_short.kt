class Student_short(
    ID: Int,
    fullNameInitials: String,
    git: String,
    contact: String,
) : StudentBase(ID, fullNameInitials, git, contact) {

    constructor(student: Student) : this(
        ID = student.id,
        fullNameInitials = student.fullName,
        git = student.git,
        contact = student.contact
    )

    constructor(ID: Int, data: String) : this(
        ID = ID,
        fullNameInitials = parseFullName(data),
        git = parseGit(data),
        contact = parseContact(data)
    )
}