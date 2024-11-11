class Student_short (val ID: Int, val fullNameInitials: String, val git: String, val contact: String) {

    constructor(student: Student) : this(
        ID = student.id,
        fullNameInitials = student.fullName,
        git = student.git,
        contact = student.contact
    )

    constructor(ID: Int, data: String) : this(
        ID = ID,
        fullNameInitials = data.split(",")[0].trim(),
        git = data.split(",")[1].trim(),
        contact = data.split(",")[2].trim()
    )
}