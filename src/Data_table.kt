class Data_table<T>(private val tableData: Array<Array<T>>) {

    // Получение данных таблицы
    fun getTableData(): Array<Array<T>> {
        return tableData
    }

    // Метод для получения строки по индексу
    fun getRow(index: Int): Array<T> {
        if (index < 0 || index >= tableData.size) {
            throw IndexOutOfBoundsException("Неверный индекс строки: $index")
        }
        return tableData[index]
    }

    // Метод для получения количества строк
    fun getRowCount(): Int {
        return tableData.size
    }

    // Метод для получения количества столбцов
    fun getColumnCount(): Int {
        return if (tableData.isNotEmpty()) tableData[0].size else 0
    }
}
