package third;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 11.09.2019
 * MountainComplex
 *
 * <p>Класс, представляющий собой горный комплекс</p>
 *
 * @author havlong
 * @version 1.0
 */
public class MountainComplex {
    /**
     * Горы, входящие в комплекс
     */
    private ArrayList<Mountain> mountains;

    /**
     * Кол-во гор в комплексе
     */
    private int mountainCount = 0;

    /**
     * Наивысшая точка комплекса
     */
    private double maxHeight = 0;

    /**
     * Название горного комплекса
     */
    private String complexName;

    /**
     * Площадь комплекса
     */
    private double complexArea = 0.0;

    /**
     * Конструктор
     *
     * @param mountains   горы
     * @param complexName название комплекса
     */
    public MountainComplex(ArrayList<Mountain> mountains, String complexName) {
        this.mountains = new ArrayList<>(mountains.size());
        mountains.forEach(this::addMountain);
        this.mountains.trimToSize();
        this.complexName = complexName;
    }

    /**
     * Второй конструктор, для комплекса, который изначально не содержит гор
     *
     * @param complexName название комплекса
     */
    public MountainComplex(String complexName) {
        this.mountains = new ArrayList<>();
        this.complexName = complexName;
    }

    @Override
    public String toString() {
        return "This is mountain complex named: " + complexName + ".\n" +
                "Total area is " + complexArea + " square meters and highest peak is " + maxHeight + " meters.";
    }

    /**
     * Метод для получения высшей точки
     *
     * @return null если гор в комплексе нет, иначе гора с наибольшей высотой
     */
    public Optional<Mountain> getHighestMountain() {
        if (mountainCount == 0) {
            return Optional.empty();
        }
        for (Mountain mountain : mountains) {
            if (mountain.getHeight() == maxHeight)
                return Optional.of(mountain);
        }
        return Optional.empty();
    }

    /**
     * Метод для получения кол-ва гор
     *
     * @return кол-во гор
     */
    public int getMountainCount() {
        return mountainCount;
    }

    /**
     * Метод для получения названия комплекса
     *
     * @return название комплекса
     */
    public String getComplexName() {
        return complexName;
    }

    /**
     * Метод для получения площади комплекса
     *
     * @return площадь комплекса
     */
    public double getComplexArea() {
        return complexArea;
    }

    /**
     * Метод для получения горы из комплекса по имени
     *
     * @param name название горы
     * @return null, если горы нет в комплексе, иначе гора
     */
    public Optional<Mountain> getMountainByName(String name) {
        if (name == null)
            return Optional.empty();
        for (Mountain mountain : mountains) {
            if (mountain.getName().equals(name))
                return Optional.of(mountain);
        }
        return Optional.empty();
    }

    /**
     * Метод для получения гор выше 1000 метров
     *
     * @return список гор выше 1000 метров
     */
    public List<Mountain> getMountainsHigherThan1000() {
        return mountains.stream().filter(mountain -> mountain.getHeight() > 1000.0).collect(Collectors.toList());
    }

    /**
     * Метод для изменения горы, идентифицируемой названием
     *
     * @param name     название изменяемой горы
     * @param property изменяемое свойство @see MountainProperty
     * @param newValue новое значение свойства
     */
    public void editMountain(String name, MountainProperty property, Object newValue) {
        for (int i = 0; i < mountainCount; ++i) {
            if (mountains.get(i).getName().equals(name)) {
                editMountain(i, property, newValue);
                return;
            }
        }
    }

    /**
     * Метод для изменения горы, идентифицируемой индексом в списке гор
     *
     * @param index    индекс изменяемой горы
     * @param property изменяемое свойство @see MountainProperty
     * @param newValue новое значение свойства
     */
    public void editMountain(int index, MountainProperty property, Object newValue) {
        switch (property) {
            case HEIGHT: {
                if (newValue instanceof Double) {
                    mountains.get(index).setHeight((Double) newValue);
                }
                break;
            }
            case PUBLIC: {
                if (newValue instanceof Boolean) {
                    mountains.get(index).setPublic((Boolean) newValue);
                }
                break;
            }
            case RATING: {
                if (newValue instanceof Byte) {
                    mountains.get(index).setRating((Byte) newValue);
                }
                break;
            }
            case ADD_CLIMBERS: {
                if (newValue instanceof Long) {
                    mountains.get(index).addClimbers((Long) newValue);
                } else if (newValue instanceof Integer) {
                    mountains.get(index).addClimbers((Integer) newValue);
                }
                break;
            }
            case PRESSURE: {
                if (newValue instanceof Double) {
                    mountains.get(index).setAveragePressure((Double) newValue);
                }
                break;
            }
            default: {
                return;
            }
        }
        System.out.println(mountains.get(index));
    }

    /**
     * Добавить гору
     *
     * @param newMountain гора для добавления
     */
    public void addMountain(Mountain newMountain) {
        if (newMountain != null) {
            mountains.add(newMountain);
            if (newMountain.getHeight() > maxHeight) {
                maxHeight = newMountain.getHeight();
            }
            complexArea += newMountain.getArea();
            mountainCount++;
        }
    }

    /**
     * Получить наибольшую высоту
     *
     * @return наибольшая высота горы или 0, если гор нет
     */
    public double getMaxHeight() {
        return maxHeight;
    }

    /**
     * Метод для получения гор, входящих в комплекс
     *
     * @return Список гор
     */
    public List<Mountain> getMountains() {
        return mountains;
    }

    /**
     * Метод для сортировки гор по высоте
     */
    public void sortMountains() {
        mountains.sort(Comparator.comparingDouble(Mountain::getHeight));
    }
}
