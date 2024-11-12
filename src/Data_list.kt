class Data_list<T>(elements: List<T>) {

    private val data: List<T> = elements.sortedBy { it.hashCode() }

    fun getElements(): List<T> = data.toList()
}