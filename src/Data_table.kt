class Data_table<T>(val data: Array<Array<T>>) {

    fun getTableData(): Array<Array<T>> {
        return data
    }

    fun getRow(index: Int): Array<T> {
        if (index < 0 || index >= data.size) {
            throw IndexOutOfBoundsException("Неверный индекс строки: $index")
        }
        return data[index]
    }

    fun getRowCount(): Int {
        return data.size
    }

    fun getColumnCount(): Int {
        return if (data.isNotEmpty()) data[0].size else 0
    }
}
