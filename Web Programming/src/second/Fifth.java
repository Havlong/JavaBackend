package second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;

/**
 * 21.09.2019
 * Fifth
 *
 * <p>Вторая лабораторная работа по предмету Основы Web-программирования</p>
 * <p>Бригада №5</p>
 *
 * @author havlong
 * @author Rabidus
 * @version 1.1
 */
public class Fifth {
    public static void main(String[] args) {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                PrintWriter writer = new PrintWriter(System.out)
        ) {
            new Fifth().run(reader, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Программа определяющее является ли данная строчка датой в формате dd/mm/yyyy. Начиная с 1600 года до 9999 года
     * <p>
     * Метод, при помощи которого можно избавиться от статики
     * <p>
     * Выход осуществляется по строке /exit
     *
     * @param reader объект BufferedReader, направленный на входной поток для чтения даты
     * @param writer объект PrintWriter, направленный на выходной поток для вывода результата
     * @throws IOException пробрасывает ошибку ввода-вывода, которая может возникнуть при работе с данными
     */
    private void run(BufferedReader reader, PrintWriter writer) throws IOException {
        while (true) {
            String s = readDate(reader, writer);
            if (s == null)
                return;
            checkDate(s, writer);
        }
    }

    /**
     * Функция проверяет входную строку на соответствие формату даты dd/mm/yyyy
     *
     * @param s      Строка для проверки на правильность даты
     * @param writer объект PrintWriter, направленный на выходной поток для вывода результата
     */
    private void checkDate(String s, PrintWriter writer) {
        Matcher dateMatcher = Pattern.compile("(\\d{2})/(\\d{2})/(\\d{4})").matcher(s);
        if (dateMatcher.matches()) {
            int day = parseInt(dateMatcher.group(1));
            int month = parseInt(dateMatcher.group(2));
            int year = parseInt(dateMatcher.group(3));

            if (year < 1600 || day > 31 || day < 1 || month > 12 || month < 1) {
                writer.println("Вы пытались, но с датами сложно");
            } else if (month == 2) {
                if (year % 400 == 0 || (year % 100 != 0 && year % 4 == 0)) {
                    if (day < 30)
                        writer.println("У Вас получилось!");
                    else
                        writer.println("Вы пытались, но с датами сложно");
                } else {
                    if (day < 29)
                        writer.println("У Вас получилось!");
                    else
                        writer.println("Вы пытались, но с датами сложно");
                }
            } else if ((month % 2 == 0 ^ month > 7) && day > 30) {
                writer.println("Вы пытались, но с датами сложно");
            } else {
                writer.println("У Вас получилось!");
            }
            writer.flush();
        }
    }

    /**
     * Функция делает попытку прочтения даты из входного потока
     *
     * @param reader объект BufferedReader, направленный на входной поток для чтения даты
     * @param writer объект PrintWriter, направленный на выходной поток для вывода результата
     * @return Возвращает строку, которая претендует на проверку на корректность
     * @throws IOException пробрасывает ошибку ввода-вывода, которая может возникнуть при работе с данными
     */
    private String readDate(BufferedReader reader, PrintWriter writer) throws IOException {
        writer.println("Попытайтесь ввести дату в формате dd/mm/yyyy: (для выхода /exit)");
        writer.flush();
        String s = reader.readLine().trim();
        if ("/exit".equals(s))
            return null;
        while (!s.matches("(\\d{2})/(\\d{2})/(\\d{4})")) {
            writer.println("Попробуйте ещё раз: (для выхода /exit)");
            writer.flush();
            s = reader.readLine().trim();
            if ("/exit".equals(s))
                return null;
        }
        return s;
    }
}