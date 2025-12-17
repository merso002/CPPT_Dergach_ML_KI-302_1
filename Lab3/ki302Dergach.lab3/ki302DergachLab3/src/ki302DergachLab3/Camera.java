package ki302DergachLab3; 
 
import java.io.IOException; 
import java.util.Random; 
 
/** 
* Клас, що представляє фотоапарат. Він містить інформацію про об'єктив, карту пам'яті, 
* батарею та інші властивості фотоапарата. Забезпечує функції для управління 
* фотоапаратом, зокрема, вмикання/вимикання, знімання фотографій, зміна об'єктива, 
* зарядка батареї, форматування карти пам'яті, видалення фотографій, перевірка стану, 
* застосування фільтрів і проведення фотосесій. 
*/ 
public abstract class Camera { 
    protected Lens lens; 
    protected Memory memory; 
    protected Battery battery; 
    protected Logger logger; 
    protected boolean isOn; 
    protected int photosTaken; 
    protected String currentFilter; 
 
    /** 
     * Конструктор для створення фотоапарата з заданим початковим станом. 
     * 
     * @param isOn початковий стан фотоапарата (увімкнено чи вимкнено) 
     * @throws IOException якщо виникає помилка при створенні логера 
     */ 
    public Camera(boolean isOn) throws IOException { 
        this.lens = new Lens(); 
        this.memory = new Memory(); 
        this.battery = new Battery(); 
        this.isOn = false; 
        this.photosTaken = 0; 
        this.currentFilter = "Нормальний"; 
 
        this.logger = new Logger("camera_log.txt"); 
 
        logger.log(String.format("Камера %s створена.", this.toString())); 
    } 
 
    /** 
     * Конструктор для створення фотоапарата з заданим об'єктивом, картою пам'яті, батареєю і фільтром. 
     * 
     * @param lens новий об'єктив 
     * @param memory нова карта пам'яті 
     * @param battery нова батарея 
     * @param filter початковий фільтр 
     * @throws IOException якщо виникає помилка при створенні логера 
     */ 
    public Camera(Lens lens, Memory memory, Battery battery, String filter) throws IOException { 
        this.lens = lens; 
        this.memory = memory; 
        this.battery = battery; 
        this.isOn = false; 
        this.photosTaken = 0; 
        this.currentFilter = filter; 
 
        this.logger = new Logger("camera_log.txt"); 
 
        logger.log(String.format("Камера %s створена.", this.toString())); 
    } 
 
    /** 
     * Метод для увімкнення пристрою. 
     * 
     * @throws IOException якщо виникає помилка під час увімкнення пристрою 
     */ 
    public abstract void turnOn() throws IOException; 
    /** 
     * Метод для вимкнення пристрою. 
     * 
     * @throws IOException якщо виникає помилка під час вимкнення пристрою 
     */ 
    public abstract void turnOff() throws IOException; 
 
    /** 
     * Метод для створення фотографії. 
     * 
     * @throws IOException якщо виникає помилка під час зйомки фото 
     */ 
    public abstract void takePhoto() throws IOException; 
 
    /** 
     * Змінює об'єктив. 
     * 
     * @param newLens новий об'єктив, який потрібно встановити 
     * @throws IOException якщо виникає помилка при запису в лог 
     */ 
    public void changeLens(Lens newLens) throws IOException { 
        this.lens = newLens; 
 
        logger.log("Змінено об'єктив на " + newLens.getFocalLength() + "мм"); 
        System.out.println("Змінено об'єктив на " + newLens.getFocalLength() + "мм"); 
    } 
 
    /** 
     * Заряджає батарею. 
     * 
     * Запускає процес зарядки батареї і оновлює запис у логах. 
     * 
     * @throws IOException якщо виникає помилка при запису в лог 
     */ 
    public void chargeBattery() throws IOException { 
        battery.charge(); 
 
        logger.log("Батарею заряджено. Поточний заряд: " + battery.getCharge() + "%"); 
        System.out.println("Батарею заряджено. Поточний заряд: " + battery.getCharge() + "%"); 
    } 
 
    /** 
     * Форматує карту пам'яті. 
     * 
     * Очищає карту пам'яті і скидає кількість зроблених фотографій до нуля. 
     * 
     * @throws IOException якщо виникає помилка при запису в лог 
     */ 
    public void formatMemory() throws IOException { 
        memory.format(); 
        photosTaken = 0; 
 
        logger.log("Карту пам'яті відформатовано"); 
        System.out.println("Карту пам'яті відформатовано"); 
    } 
 
    /** 
     * Видаляє останнє фото. 
     * 
     * Якщо є зроблені фотографії, видаляє останню з них, збільшує вільне місце на карті пам'яті. 
     * 
     * @throws IOException якщо виникає помилка при запису в лог 
     */ 
    public void deleteLastPhoto() throws IOException { 
        if (photosTaken > 0) { 
            photosTaken--; 
            memory.freeSpace(); 
 
            logger.log("Видалено останнє фото. Залишилось фото: " + photosTaken); 
            System.out.println("Фото видалене"); 
        } else { 
            logger.log("Немає фото для видалення"); 
            System.out.println("Немає фото для видалення"); 
        } 
    } 
 
    /** 
     * Перевіряє стан фотоапарата. 
     * 
     * Виводить інформацію про поточний стан фотоапарата, включаючи чи він увімкнений, 
     * заряд батареї, вільне місце на карті пам'яті і кількість зроблених фотографій. 
     * 
     * @return рядок з інформацією про стан фотоапарата 
     * @throws IOException якщо виникає помилка при запису в лог 
     */ 
    public String checkStatus() throws IOException { 
        String info = "Стан фотоапарата: " + 
                "Увімкнено: " + isOn + 
                ", Заряд батареї: " + battery.getCharge() + "%" + 
                ", Вільне місце: " + memory.getFreeSpace() + 
                ", Зроблено фото: " + photosTaken; 
 
        logger.log(String.format("Інформація про %s", info)); 
        System.out.println(String.format("Інформація про %s", info)); 
        return info; 
    } 
 
    /** 
     * Застосовує фільтр до наступних фотографій. 
     * 
     * @param filter назва фільтру для застосування 
     * @throws IOException якщо виникає помилка при запису в лог 
     */ 
    public void applyFilter(String filter) throws IOException { 
        this.currentFilter = filter; 
        logger.log("Застосовано фільтр: " + filter); 
        System.out.println("Застосовано фільтр: " + filter); 
    } 
 
    /** 
     * Симулює фотосесію з випадковою кількістю фотографій. 
     * 
     * Перевіряє умови (включено фотоапарат, заряд батареї і вільне місце) і робить 
     * випадкову кількість фотографій, з затримкою між ними. 
     * 
     * @throws IOException якщо виникає помилка при запису в лог 
     */ 
    public void startPhotoSession() throws IOException { 
        if (isOn && battery.getCharge() > 0 && memory.getFreeSpace() > 0) { 
            Random rand = new Random(); 
            int photosInSession = rand.nextInt(10) + 1; 
 
            logger.log("Початок фотосесії. Заплановано фотографій: " + photosInSession); 
            System.out.println("Початок фотосесії. Заплановано фотографій: " + photosInSession); 
 
            for (int i = 0; i < photosInSession; i++) { 
                if (battery.getCharge() > 0 && memory.getFreeSpace() > 0) { 
                    takePhoto(); 
                    try { 
                        Thread.sleep(1000); 
                    } catch (InterruptedException e) { 
                        e.printStackTrace(); 
                    } 
                } else { 
                    break; 
                } 
            } 
 
            logger.log("Фотосесія завершена. Зроблено фотографій: " + photosInSession); 
            System.out.println("Фотосесія завершена. Зроблено фотографій: " + photosInSession); 
        } else { 
            logger.log("Неможливо почати фотосесію. Перевірте, чи фотоапарат увімкнено, заряд батареї та вільне місце"); 
            System.out.println("Неможливо почати фотосесію. Перевірте, чи фотоапарат увімкнено, заряд батареї та вільне місце"); 
        } 
    } 
 
    /** 
     * Метод для закриття логера. 
     * @throws IOException якщо виникає помилка під час закриття логера. 
     */ 
    public void closeLogger() throws IOException { 
        logger.close(); 
    } 
} 