open class Data_list<T>(elements: List<T>) {
    protected val data: List<T> = elements.sortedBy { it.hashCode() }

    // Шаблонный метод: общий алгоритм формирования данных
    open fun get_data(): Data_table<Any> {
        val tableData = mutableListOf<Array<Any>>()

        // Получение заголовка
        val header = arrayOf<Any>("№", *get_names().toTypedArray())
        tableData.add(header)

        // Добавление данных для каждой строки
        for ((index, element) in data.withIndex()) {
            val row = arrayOf<Any>(index + 1, *get_row_data(element))
            tableData.add(row)
        }

        return Data_table(tableData.toTypedArray())
    }

    // Шаблонный метод: заголовки данных
    open fun get_names(): List<String> {
        return listOf("ID") // Базовый набор заголовков
    }

    // Метод для формирования строки данных (должен быть переопределён)
    protected open fun get_row_data(element: T): Array<Any> {
        throw NotImplementedError("Метод get_row_data должен быть переопределён в наследниках")
    }

    fun select(number: Int): T {
        if (number < 0 || number >= data.size) {
            throw IndexOutOfBoundsException("Неверный индекс: $number")
        }
        return data[number]
    }
}
