class Data_list_student_short(elements: List<Student_short>) : Data_list<Student_short>(elements) {

    // Переопределяем метод get_names для Student_short
    override fun get_names(): List<String> {
        // Используем метод родителя для получения атрибутов и фильтруем поле "ID"
        val fieldNames = super.get_names()
        return fieldNames.filter { it != "ID" }
    }

    override fun get_data(): Data_table<Any> {
        val tableData = mutableListOf<Array<Any>>()

        val header = arrayOf<Any>("№", *get_names().toTypedArray())
        tableData.add(header)

        for ((index, element) in data.withIndex()) {
            val row = mutableListOf<Any>()
            row.add(index + 1)

            row.add(element.fullName)
            row.add(element.git)
            row.add(element.contact)

            tableData.add(row.toTypedArray())
        }

        return Data_table(tableData.toTypedArray())
    }
}
