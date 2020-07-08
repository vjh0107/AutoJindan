package selenium

import org.openqa.selenium.By
import org.openqa.selenium.chrome.ChromeDriver

val driver = ChromeDriver()
val elements: Array<String> = arrayOf("011", "02", "070", "080", "090")

fun clickerById(elements: Array<String>, id: String) {
    try {
        for (value in elements) {
            driver.findElement(By.id("$id$value")).click()
        }
    }
    catch(e: Exception) {e.printStackTrace()}
}


fun clickSections() {
    try {
        clickerById(elements, "rspns")
        Thread.sleep((100))
        driver.findElement(By.id("btnConfirm")).click()
    } catch (e: java.lang.Exception) {
        e.printStackTrace()}
}