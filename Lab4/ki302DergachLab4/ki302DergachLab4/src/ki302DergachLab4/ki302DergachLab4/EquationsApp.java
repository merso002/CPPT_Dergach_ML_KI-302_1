package ki302DergachLab4; 
 
import java.io.IOException; 
import java.util.Scanner; 
 
/** 
* Драйвер для запуску програми обчислення виразу. 
* <p> 
* Клас Main відповідає за ініціалізацію обчислювача виразів та взаємодію з користувачем через консоль. 
* Користувач вводить значення змінної x, після чого програма обчислює значення виразу та виводить результат. 
* Також результат зберігається у файл. 
* </p> 
* 
* @version 1.0 
*/ 
public class EquationsApp { 
 
    /** 
     * Точка входу до програми. Виконується отримання введеного користувачем значення, 
     * обчислення результату виразу та запис результату у файл. 
     * 
     * @param args аргументи командного рядка 
     */ 
    public static void main(String[] args) { 
        ExpressionCalculator calculator = new ExpressionCalculator(); 
        Scanner scanner = new Scanner(System.in); 
 
        try { 
            // Отримання значення x від користувача 
            System.out.print("Введіть значення x: "); 
            double x = scanner.nextDouble(); 
 
            // Обчислення результату 
            double result = calculator.calculate(x); 
            System.out.println("Результат: " + result); 
 
            // Запис результату у файл 
            String filePath = "result.txt"; 
            calculator.writeResultToFile(result, filePath); 
            System.out.println("Результат записано у файл: " + filePath); 
 
        } catch (IllegalArgumentException e) { 
            System.out.println("Помилка: " + e.getMessage()); 
        } catch (IOException e) { 
            System.out.println("Помилка запису у файл: " + e.getMessage()); 
        } finally { 
            // Закриття сканера для уникнення витоку ресурсів 
            scanner.close(); 
        } 
    } 
} 