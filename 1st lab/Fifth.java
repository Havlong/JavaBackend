import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * 09.09.2019
 * Fifth
 * 
 * <p>Первая лабораторная работа по предмету Основы Web-программирования</p>
 * <p>Бригада №5</p>
 *
 * @author havlong
 * @version 1.0
 */
public class Fifth {
    public static void main(String args[]) {
        try(
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter writer = new PrintWriter(System.out);
        ) { // Применяем Java 7 try-with-resources для того, чтобы инициализировать ввод-вывод из консоли
            new Fifth().run(reader, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Программа вычисляет значение ряда: n - n/2 + n/3 + ... + n/9999 - n/10000
     * 
     * Метод, при помощи которого можно избавиться от статики
     * 
     * Выход осуществляется по строке /exit
     *
     * @param reader объект BufferedReader, направленный на входной поток для чтения числа n
     * @param writer объект PrintWriter, направленный на выходной поток для вывода результата
     * @throws IOException пробрасывает ошибку ввода-вывода, которая может возникнуть при работе с данными
     */
    public void run(BufferedReader reader, PrintWriter writer) throws IOException {
        while (true) {
            writer.println("Введите число n: (для выхода /exit)");
            writer.flush();
            String s = reader.readLine().trim();
            if ("/exit".equals(s))
                return;
            while (!s.matches("-?\\d+([.,]\\d+)?")) {
                writer.println("Введите число n: (для выхода /exit)");
                writer.println("Введите число n:");
                writer.flush();
                s = reader.readLine().trim();
                if ("/exit".equals(s))
                    return;
            }
            double n = Double.parseDouble(s.replaceAll(",", "."));
            double result = 0;
            for (int i = 1; i <= 10000; i++) {
                // При делении на чётное число домножаем на -1, чтобы получить отрицательное
                result += (i % 2 == 0 ? -1.0 : 1.0) * n / i;
            }
            writer.println("n - n/2 + n/3 + ... + n/9999 - n/10000 = " + result);
        }
    }
}
