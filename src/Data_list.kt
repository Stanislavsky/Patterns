class Data_list<T : Comparable<T>>(elements: List<T>) {

    private val data: List<T> = elements.sorted()

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
}