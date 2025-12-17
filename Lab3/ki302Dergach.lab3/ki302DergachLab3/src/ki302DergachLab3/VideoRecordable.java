package ki302DergachLab3; 
 
import java.io.IOException; 
 
/** 
* Інтерфейс VideoRecordable, який визначає основні операції для пристроїв, що можуть записувати відео. 
*/ 
public interface VideoRecordable { 
 
    /** 
     * Метод для початку запису відео. 
     * 
     * @throws IOException якщо виникає помилка під час початку запису 
     */ 
    void startRecording() throws IOException; 
 
    /** 
     * Метод для зупинки запису відео. 
     * 
     * @throws IOException якщо виникає помилка під час зупинки запису 
     */ 
    void stopRecording() throws IOException; 
}