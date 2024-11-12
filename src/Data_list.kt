class Data_list<T : Any>(elements: List<T>) {

    private val data: List<T> = elements

    private val selectedIndexes: MutableList<Int> = mutableListOf()

    fun getElements(): List<T> = data.toList()

    fun select(number: Int): T {
        if (number < 0 || number >= data.size) {
            throw IndexOutOfBoundsException("Неверный индекс: $number. Индекс должен быть в пределах от 0 до ${data.size - 1}.")
        }
        selectedIndexes.add(number)
        return data[number]
    }

    fun get_selected(): List<Int> {
        return selectedIndexes.toList()
    }

    fun get_names(): List<String> {
        val firstElement = data.firstOrNull()
        if (firstElement == null) {
            throw IllegalArgumentException("Список пуст или элементы не имеют полей.")
        }

        val fields = firstElement::class.java.declaredFields.map { it.name }

        return fields.filter { it != "id" }
    }
}