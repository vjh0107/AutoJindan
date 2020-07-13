import java.lang.NumberFormatException


fun isInt(str: String): Boolean {
    var isInt = false
    try {
        Integer.parseInt(str)
        isInt = true

    } catch(e: NumberFormatException) {

    } finally {
        return isInt
    }
}