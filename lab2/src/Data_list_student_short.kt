class Data_list_student_short(elements: List<Student_short>) : Data_list<Student_short>(elements) {

    // Переопределяем заголовки
    override fun get_names(): List<String> {
        return listOf("Full Name", "Git", "Contact") // Убираем ID
    }

    // Переопределяем строки данных
    override fun get_row_data(element: Student_short): Array<Any> {
        return arrayOf(element.fullName, element.git, element.contact)
    }
}
