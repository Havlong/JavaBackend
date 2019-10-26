package third;

/**
 * 11.09.2019
 * GeographicalObject
 *
 * <p>Класс, отображающий собой географический объект</p>
 *
 * @author havlong
 * @version 1.0
 */
public class GeographicalObject {
    /**
     * Название объекта
     */
    private String name;
    /**
     * Координата широты
     */
    private double latitude;
    /**
     * Координата долготы
     */
    private double longitude;
    /**
     * Рейтинг места по десятибальной шкале
     */
    private byte rating;
    /**
     * Является ли объект свободнодоступным
     */
    private boolean isPublic;

    /**
     * Конструктор класса географический объект
     *
     * @param name      название горы
     * @param latitude  широта
     * @param longitude долгота
     * @param rating    рейтинг
     * @param isPublic  доступность
     */
    public GeographicalObject(String name, double latitude, double longitude, byte rating, boolean isPublic) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        if (rating > 0 && rating < 11)
            this.rating = rating;
        else
            this.rating = 0;
        this.isPublic = isPublic;
    }

    /**
     * Метод для получения значения рейтинга
     *
     * @return рейтинг или 0, если место не оценено
     */
    public byte getRating() {
        return rating;
    }

    /**
     * Устанавливает новое значение рейтинга
     *
     * @param rating новое значение рейтинга от 1 до 10
     */
    public void setRating(byte rating) {
        if (rating > 0 && rating < 11)
            this.rating = rating;
    }

    /**
     * Метод, сообщающий открыто ли место
     *
     * @return true, если открыто, иначе false
     */
    public boolean isPublic() {
        return isPublic;
    }

    /**
     * Устанавливает новый статус доступности
     *
     * @param isPublic true, если объект становится открытым, иначе false
     */
    public void setPublic(boolean isPublic) {
        this.isPublic = isPublic;
    }

    /**
     * Метод, позволяющий получить широту
     *
     * @return широта в виде вещественного числа
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * Метод, позволяющий получить долготу
     *
     * @return долгота в виде вещественного числа
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * Метод, позволяющий узнать название объекта
     *
     * @return строка с названием
     */
    public String getName() {
        return name;
    }
}
