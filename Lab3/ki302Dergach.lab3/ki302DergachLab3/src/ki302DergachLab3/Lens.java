package ki302DergachLab3; 
 
/** 
* Клас, що представляє об'єктив камери. 
* 
* Об'єктив має певну фокусну відстань, яку можна встановити та отримати. 
*/ 
public class Lens { 
    private int focalLength; 
 
    /** 
     * Конструктор без параметрів, що створює об'єктив з фокусною відстанню 50 мм. 
     */ 
    public Lens() { 
        this.focalLength = 50; 
    } 
 
    /** 
     * Конструктор для створення об'єктива з вказаною фокусною відстанню. 
     * 
     * @param focalLength фокусна відстань об'єктива в міліметрах 
     */ 
    public Lens(int focalLength) { 
        this.focalLength = focalLength; 
    } 
 
    /** 
     * Отримує фокусну відстань об'єктива. 
     * 
     * @return фокусна відстань об'єктива в міліметрах 
     */ 
    public int getFocalLength() { 
        return focalLength; 
    } 
} 