class Data_list<T : Any>(elements: List<T>) {

    private val data: List<T> = elements

    fun select(number: Int): T {
        if (number < 0 || number >= data.size) {
            throw IndexOutOfBoundsException("Неверный индекс: $number. Индекс должен быть в пределах от 0 до ${data.size - 1}.")
        }
        return data[number]
    }

    fun get_selected(): List<Int> {
        return data.mapIndexed { index, _ -> index }
    }

    fun get_names(): List<String> {
        val firstElement = data.firstOrNull()
        if (firstElement == null) {
            throw IllegalArgumentException("Список пуст или элементы не имеют полей.")
        }

        val fields = firstElement::class.java.declaredFields.map { it.name }
        return fields.filter { it != "id" }
    }

    fun get_data(): Data_table<Any> {
        val tableData = mutableListOf<Array<Any>>()

        val header = arrayOf<Any>("№", *get_names().toTypedArray())
        tableData.add(header)

        for ((index, element) in data.withIndex()) {
            val row = mutableListOf<Any>()
            row.add(index + 1)

            val fields = element::class.java.declaredFields
            for (field in fields) {
                field.isAccessible = true
                if (field.name != "id") {
                    row.add(field.get(element))
                }
            }

            tableData.add(row.toTypedArray())
        }

        return Data_table(tableData.toTypedArray())
    }
}
