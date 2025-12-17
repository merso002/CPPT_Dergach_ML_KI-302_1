package ki302DerhachLab2;
 
/** 
* Клас, що представляє батарею фотоапарата. 
* 
* Батарея має заряд, який можна використовувати або заряджати. 
*/ 
public class Battery { 
    private int charge; 
 
    /** 
     * Конструктор без параметрів, що створює батарею з зарядом 100%. 
     */ 
    public Battery() { 
        this.charge = 100; 
    } 
 
    /** 
     * Зменшує заряд батареї на одиницю, якщо заряд більше 0. 
     */ 
    public void useCharge() { 
        if (charge > 0) charge--; 
    } 
 
    /** 
     * Заряджає батарею до 100%. 
     */ 
    public void charge() { 
        charge = 100; 
    } 
 
    /** 
     * Отримує поточний рівень заряду батареї. 
     * 
     * @return поточний рівень заряду батареї у відсотках 
     */ 
    public int getCharge() { 
        return charge; 
    } 
} 