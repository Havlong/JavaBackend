package third;

import java.util.Locale;

/**
 * 11.09.2019
 * Mountain
 *
 * <p>Географический объект типа гора</p>
 *
 * @author havlong
 * @version 1.0
 */
public class Mountain extends GeographicalObject {
    /**
     * Высота горы
     */
    private double height;

    /**
     * Среднее давление
     */
    private double averagePressure;

    /**
     * Заснеженная ли вершина
     */
    private boolean hasSnowyPeak;

    /**
     * Площадь
     */
    private double area;

    /**
     * Кол-во восхождений
     */
    private long climbersCount;

    /**
     * Конструктор класса гора
     *
     * @param name            название горы
     * @param latitude        широта
     * @param longitude       долгота
     * @param rating          рейтинг
     * @param isPublic        доступность
     * @param height          высота
     * @param averagePressure среднее давление
     * @param hasSnowyPeak    заснеженная ли вершина
     * @param area            площадь
     * @param climbersCount   кол-во восхождений
     */
    public Mountain(String name, double latitude, double longitude, byte rating, boolean isPublic, double height, double averagePressure, boolean hasSnowyPeak, double area, long climbersCount) {
        super(name, latitude, longitude, rating, isPublic);
        this.height = height;
        this.averagePressure = averagePressure;
        this.hasSnowyPeak = hasSnowyPeak;
        this.area = area;
        this.climbersCount = climbersCount;
    }

    /**
     * Метод для получения высоты горы
     *
     * @return высота горы
     */
    public double getHeight() {
        return height;
    }

    /**
     * Установить новое значение высоты
     *
     * @param height высота горы
     */
    public void setHeight(double height) {
        this.height = height;
    }

    /**
     * Метод для получения среднего давления
     *
     * @return среднее давление
     */
    public double getAveragePressure() {
        return averagePressure;
    }

    /**
     * Установка нового значения среднего давления
     *
     * @param averagePressure среднее значение
     */
    public void setAveragePressure(double averagePressure) {
        this.averagePressure = averagePressure;
    }

    /**
     * Метод для получения того, заснежена ли вершина
     *
     * @return true, если вершина заснежена, иначе false
     */
    public boolean hasSnowyPeak() {
        return hasSnowyPeak;
    }

    /**
     * Метод для получения площади
     *
     * @return площадь
     */
    public double getArea() {
        return area;
    }

    /**
     * Метод для получения кол-ва восхождений
     *
     * @return кол-во восхождений
     */
    public long getClimbersCount() {
        return climbersCount;
    }

    /**
     * Метод для добавления числа покорителей горы
     *
     * @param climbersCount кол-во новых покорителей
     */
    public void addClimbers(long climbersCount) {
        this.climbersCount += climbersCount;
    }

    @Override
    public String toString() {
        if (Locale.getDefault().getLanguage().equals("ru"))
            return "Вот немного информации об этой горе... Знали ли вы, что: \n" +
                    "Гора " + getName() + " является" + (isPublic() ? "" : " не") + " доступной. \n" +
                    "К тому же её высота " + height + " метров со средним давлением: " + averagePressure + "мм рт.ст.\n" +
                    "Она имеет " + (hasSnowyPeak() ? "" : "не") + "заснеженную вершину.\n" +
                    "Также её площадь " + area + " кв м. Уже " + climbersCount + " покорило её вершину.\n" +
                    "Вы можете найти её в " + getLatitude() + " ширины и " + getLongitude() + " долготы.\n" +
                    "Гора оценена в " + getRating() + " баллов из 10.";
        else
            return "Here is some info about this mountain... Did you know that: \n" +
                    "Mountain " + getName() + " is" + (isPublic() ? "" : " not") + " public. \n" +
                    "Also it's height is " + height + " meters with average pressure: " + averagePressure + "mm Hg.\n" +
                    "It has" + (hasSnowyPeak() ? "" : " not") + " snowy peak.\n" +
                    "Also area is " + area + " square meters. Already " + climbersCount + " conquered this mountain.\n" +
                    "You can find it at " + getLatitude() + " latitude and " + getLongitude() + " longitude.\n" +
                    "Mountain is rated: " + getRating() + "/10.";
    }
}
