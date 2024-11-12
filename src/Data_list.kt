open class Data_list<T>(elements: List<T>) {

    protected val data: List<T> = elements.sortedBy { it.hashCode() } // Сортируем элементы по hashCode

    // Метод для выделения элемента по индексу
    fun select(number: Int): T {
        if (number < 0 || number >= data.size) {
            throw IndexOutOfBoundsException("Неверный индекс: $number")
        }
        return data[number]
    }

    // Метод для получения массива всех атрибутов
    open fun get_names(): List<String> {
        // Этот метод должен быть реализован в наследниках
        return listOf()
    }

    // Метод для получения данных в виде таблицы
    open fun get_data(): Data_table<Any> {
        // Этот метод также должен быть реализован в наследниках
        throw NotImplementedError("Метод get_data должен быть реализован в наследниках.")
    }
}