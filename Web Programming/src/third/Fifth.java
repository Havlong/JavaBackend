package third;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;
import java.util.Optional;

/**
 * 11.09.2019
 * Fifth
 *
 * <p>Третья лабораторная работа по предмету Основы Web-программирования</p>
 * <p>Бригада №5<p/>
 *
 * @author havlong
 * @author Rabidus
 * @version 1.0
 */
public class Fifth {
    public static void main(String[] args) {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                PrintWriter writer = new PrintWriter(System.out)
        ) { // Применяем Java 7 try-with-resources для того, чтобы инициализировать вывод в консоль
            new Fifth().run(reader, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод, при помощи которого можно избавиться от статики
     * Работает с классами: @see Mountain, @see MountainComplex и @see MountainProperty
     *
     * @param writer объект PrintWriter, направленный на выходной поток для вывода результатов обработки
     * @throws IOException пробрасывает ошибку вывода, которая может возникнуть при работе с данными
     */
    private void run(BufferedReader reader, PrintWriter writer) throws IOException {
        writer.println("Введите название для нового горного комплекса");
        writer.flush();
        String complexName = reader.readLine();
        while (complexName.isBlank()) {
            writer.println("Введите не пустое название");
            writer.flush();
            complexName = reader.readLine();
        }
        MountainComplex complex = new MountainComplex(complexName);

        while (true) {
            writer.println("Выберите следующее действие или введите /exit для выхода");
            writer.println("1 - добавить новую гору");
            writer.println("2 - вывести информацию о самой высокой вершине");
            writer.println("3 - вывести информацию о вершинах выше 1000 метров");
            writer.println("4 - отсортировать вершины по высоте");
            writer.println("5 - вывести информацию о вершине с названием");
            writer.println("6 - изменить свойства о вершине с названием");
            writer.flush();
            String s = reader.readLine();
            if ("/exit".equals(s))
                return;
            if (s.matches("\\s*[1-6]\\s*")) {
                switch (Integer.parseInt(s)) {
                    case 1: {
                        writer.println("Введите название горы:");
                        writer.flush();
                        String mountainName = reader.readLine();
                        while (mountainName.isBlank()) {
                            writer.println("Введите не пустое название");
                            writer.flush();
                            mountainName = reader.readLine();
                        }

                        writer.println("Введите широту расположения горы:");
                        writer.flush();
                        String mountainLatitude = reader.readLine();
                        while (!mountainLatitude.matches("-?\\d+(\\.\\d+)?")) {
                            writer.println("Введите число в вещественном формате");
                            writer.flush();
                            mountainLatitude = reader.readLine();
                        }
                        double latitude = Double.parseDouble(mountainLatitude);

                        writer.println("Введите долготу расположения горы:");
                        writer.flush();
                        String mountainLongitude = reader.readLine();
                        while (!mountainLongitude.matches("-?\\d+(\\.\\d+)?")) {
                            writer.println("Введите число в вещественном формате");
                            writer.flush();
                            mountainLongitude = reader.readLine();
                        }
                        double longitude = Double.parseDouble(mountainLongitude);

                        writer.println("Введите рейтинг горы числом от 1 до 9:");
                        writer.flush();
                        String mountainRating = reader.readLine();
                        while (!mountainRating.matches("[1-9]")) {
                            writer.println("Введите число от 1 до 9");
                            writer.flush();
                            mountainRating = reader.readLine();
                        }
                        byte rating = Byte.parseByte(mountainRating, 10);

                        writer.println("Является ли гора доступной??? Введите 1, если да, и 0, если нет:");
                        writer.flush();
                        String mountainPublic = reader.readLine();
                        while (!mountainPublic.matches("[01]")) {
                            writer.println("Введите число от 0 до 1");
                            writer.flush();
                            mountainPublic = reader.readLine();
                        }
                        int n = Integer.parseInt(mountainPublic);
                        boolean isPublic = n == 1;

                        writer.println("Введите высоту горы:");
                        writer.flush();
                        String mountainHeight = reader.readLine();
                        while (!mountainHeight.matches("-?\\d+(\\.\\d+)?")) {
                            writer.println("Введите число в вещественном формате");
                            writer.flush();
                            mountainHeight = reader.readLine();
                        }
                        double height = Double.parseDouble(mountainHeight);

                        writer.println("Введите среднее давление горы:");
                        writer.flush();
                        String mountainPressure = reader.readLine();
                        while (!mountainPressure.matches("-?\\d+(\\.\\d+)?")) {
                            writer.println("Введите число в вещественном формате");
                            writer.flush();
                            mountainPressure = reader.readLine();
                        }
                        double pressure = Double.parseDouble(mountainPressure);

                        writer.println("Является ли пик горы заснеженным??? Введите 1, если да, и 0, если нет:");
                        writer.flush();
                        String mountainSnowy = reader.readLine();
                        while (!mountainSnowy.matches("[01]")) {
                            writer.println("Введите число от 0 до 1");
                            writer.flush();
                            mountainSnowy = reader.readLine();
                        }
                        n = Integer.parseInt(mountainSnowy);
                        boolean hasSnowyPeak = n == 1;

                        writer.println("Введите площадь горы:");
                        writer.flush();
                        String mountainArea = reader.readLine();
                        while (!mountainArea.matches("-?\\d+(\\.\\d+)?")) {
                            writer.println("Введите число в вещественном формате");
                            writer.flush();
                            mountainArea = reader.readLine();
                        }
                        double area = Double.parseDouble(mountainArea);

                        writer.println("Введите количество покорителей этой горы:");
                        writer.flush();
                        String mountainClimbers = reader.readLine();
                        while (!mountainClimbers.matches("\\d+")) {
                            writer.println("Введите неотрицательное целое число");
                            writer.flush();
                            mountainClimbers = reader.readLine();
                        }
                        int climbersCount = Integer.parseInt(mountainClimbers);
                        complex.addMountain(new Mountain(mountainName, latitude, longitude, rating, isPublic, height, pressure, hasSnowyPeak, area, climbersCount));
                        break;
                    }
                    case 2: {
                        Optional<Mountain> mountain = complex.getHighestMountain();
                        if (mountain.isPresent())
                            writer.println(mountain.get());
                        else
                            writer.println("Гор - нет. Создайте новую при помощи 1");
                        writer.flush();
                        break;
                    }
                    case 3: {
                        List<Mountain> mountains = complex.getMountainsHigherThan1000();
                        mountains.forEach(writer::println);
                        if (mountains.isEmpty())
                            writer.println("Таких гор - нет. Создайте новую при помощи 1");
                        writer.flush();
                        break;
                    }
                    case 4: {
                        complex.sortMountains();
                        writer.println("Они отсортированы по высоте");
                        writer.flush();
                        break;
                    }
                    case 5: {
                        String name = reader.readLine();
                        Optional<Mountain> mountain = complex.getMountainByName(name);
                        if (mountain.isPresent())
                            writer.println(mountain.get());
                        else
                            writer.println("Нет гор с таким названием");
                        writer.flush();
                        break;
                    }
                    case 6: {
                        try {
                            writer.println("Введите название горы");
                            writer.flush();
                            String myS = reader.readLine();
                            writer.println("Введите номер свойства, которое хотите изменить");
                            writer.println("1 - Высота горы");
                            writer.println("2 - Среднее давление горы");
                            writer.println("3 - Новые восхождения на гору");
                            writer.println("4 - Рейтинг");
                            writer.println("5 - Доступность горы");
                            writer.flush();
                            String option = reader.readLine();
                            while (!option.matches("[1-5]")) {
                                writer.println("Введите число от 1 до 5");
                                writer.flush();
                                option = reader.readLine();
                            }
                            byte byteOption = Byte.parseByte(option, 10);
                            writer.println("Введите новое значение, будьте осторожны");
                            writer.flush();
                            MountainProperty property;
                            Object newValue;
                            switch (byteOption) {
                                case 1: {
                                    property = MountainProperty.HEIGHT;
                                    newValue = Double.parseDouble(reader.readLine());
                                    break;
                                }
                                case 2: {
                                    property = MountainProperty.PRESSURE;
                                    newValue = Double.parseDouble(reader.readLine());
                                    break;
                                }
                                case 3: {
                                    property = MountainProperty.ADD_CLIMBERS;
                                    newValue = Integer.parseInt(reader.readLine());
                                    break;
                                }
                                case 4: {
                                    property = MountainProperty.RATING;
                                    newValue = Byte.parseByte(reader.readLine(), 10);
                                    break;
                                }
                                case 5: {
                                    property = MountainProperty.PUBLIC;
                                    newValue = Integer.parseInt(reader.readLine()) != 0;
                                    break;
                                }
                                default:
                                    throw new IllegalStateException("Unexpected value: " + byteOption);
                            }
                            complex.editMountain(myS, property, newValue);
                        } catch (Exception e) {
                            writer.println("Мы предупреждали, не ошибайтесь! Но вы всё равно ошиблись...");
                        }
                        break;
                    }
                }
            } else {
                writer.println("Выберите корректную опцию");
            }
        }
        /*
        // Создадим случайный горный комплекс
        MountainComplex mountainComplex = new MountainComplex("Some Mountain Complex");
        // Добавим гору
        mountainComplex.addMountain(new Mountain("Some mountain",
                43.34305555555556, 42.448611111111106, (byte) 9, true, 5642,
                473, true, 13450000, 13435));
        writer.println(mountainComplex);
        writer.println();
        writer.println("There are mountains higher than 1000 meters: ");
        // Выведем все горы, которые выше 1000 метров
        mountainComplex.getMountainsHigherThan1000().forEach(writer::println);
        writer.println();
        writer.flush();
        // Добавим трёх новых покорителя вершины
        mountainComplex.editMountain("Some mountain", MountainProperty.ADD_CLIMBERS, 3);
         */
    }
}
