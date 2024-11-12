class Data_table<T>(inputData: Array<Array<T>>) {

    private val data: Array<Array<T>> = inputData

    fun rowCount(): Int = data.size

    fun columnCount(): Int = if (data.isNotEmpty()) data[0].size else 0

    private fun getElement(row: Int, column: Int): T? {
        return if (row in data.indices && column in data[row].indices) {
            data[row][column]
        } else {
            null
        }
    }
}
