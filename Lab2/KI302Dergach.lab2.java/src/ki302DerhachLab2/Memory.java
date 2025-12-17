package ki302DerhachLab2   ;
 
/** 
* Клас, що представляє карту пам'яті. 
*/ 
public class Memory { 
    private int capacity; 
    private int freeSpace; 
 
    /** 
     * Конструктор за замовчуванням. Ініціалізує карту пам'яті ємністю 1000 МБ та вільним простором 1000 МБ. 
     */ 
    public Memory() { 
        this.capacity = 1000; 
        this.freeSpace = 1000; 
    } 
 
    /** 
     * Зменшує вільний простір на карті пам'яті на одиницю. 
     * Вільний простір не зменшиться, якщо він вже дорівнює нулю. 
     */ 
    public void useSpace() { 
        if (freeSpace > 0) freeSpace--; 
    } 
 
    /** 
     * Збільшує вільний простір на карті пам'яті на одиницю. 
     * Вільний простір не збільшиться, якщо він вже дорівнює ємності карти пам'яті. 
     */ 
    public void freeSpace() { 
        if (freeSpace < capacity) freeSpace++; 
    } 
 
    /** 
     * Форматує карту пам'яті, відновлюючи вільний простір до повної ємності. 
     */ 
    public void format() { 
        freeSpace = capacity; 
    } 
 
    /** 
     * Отримує поточний вільний простір на карті пам'яті. 
     * 
     * @return Вільний простір на карті пам'яті в мегабайтах. 
     */ 
    public int getFreeSpace() { 
        return freeSpace; 
    } 
}