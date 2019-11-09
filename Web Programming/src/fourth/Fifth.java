package fourth;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Vector;

/**
 * 11.09.2019
 * Fifth
 *
 * <p>Четвёртая лабораторная работа по предмету Основы Web-программирования</p>
 * <p>Бригада №5<p/>
 *
 * @author havlong
 * @author Rabidus
 * @version 1.0
 */
public class Fifth {
    public static void main(String[] args) {
        try (
                PrintWriter writer = new PrintWriter(new FileWriter("4th Lab Output.txt"))
        ) {
            new Fifth().run(writer, args);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Программа, позволяющая проанализировать массив вещественных чисел, переданных через аргументы
     * <p>
     * Метод, при помощи которого можно избавиться от статики
     *
     * @param writer объект PrintWriter, направленный на выходной поток для вывода результата
     * @param args   аргументы командной строки
     */
    private void run(PrintWriter writer, String[] args) throws IOException {
        if (args.length == 0) {
            System.err.println("Пожалуйста, введите аргументы");
            System.err.println("Введите аргумент -h или --help, чтобы получить помощь");
            return;
        }
        if ("-h".equals(args[0]) || "--help".equals(args[0])) {
            System.out.println("Программа используется для проведения статистических операций над массивом вещественных чисел");
            System.out.println("Введите массив вещественных чисел в качестве аргументов и получите файл с отсортированным массивом, медианой и средним значением");
            System.out.println("Пример: java Fifth 1.0 2.0 7.0 -3,2");
            return;
        }
        Vector<Double> doubleVector = new Vector<>(args.length);
        try {
            Arrays.stream(args).map(s -> s.replaceAll("[,.]", ".")).mapToDouble(Double::parseDouble)
                    .forEach(doubleVector::add);
        } catch (NumberFormatException e) {
            System.err.println("Не передавайте в аргументы не числа");
            System.err.println("Введите аргумент -h или --help, чтобы получить помощь");
            return;
        }
        int size = doubleVector.size();
        if (size == 0) {
            System.err.println("Пожалуйста, введите числовые аргументы");
            System.err.println("Введите аргумент -h или --help, чтобы получить помощь");
            return;
        }
        sortVector(writer, doubleVector);
        calcMedian(writer, doubleVector);
        calcAverage(writer, doubleVector);
    }

    /**
     * Метод, сортирующий предоставленные числа и выводящий информацию о них
     * Дублирует информацию в командную строку
     *
     * @param writer       объект PrintWriter, направленный на выходной поток для вывода результата
     * @param doubleVector вектор из вещественных чисел для преобразования
     */
    private void sortVector(PrintWriter writer, Vector<Double> doubleVector) {
        writer.print("Vector до сортировки: [ ");
        System.out.print("Vector до сортировки: [ ");
        doubleVector.forEach(aDouble -> writer.print(aDouble + " "));
        doubleVector.forEach(aDouble -> System.out.print(aDouble + " "));
        writer.println("]");
        System.out.println("]");
        doubleVector.sort(Double::compareTo);
        writer.print("Vector после сортировки: [ ");
        System.out.print("Vector после сортировки: [ ");
        doubleVector.forEach(aDouble -> writer.print(aDouble + " "));
        doubleVector.forEach(aDouble -> System.out.print(aDouble + " "));
        writer.println("]");
        System.out.println("]");
    }

    /**
     * Метод, вычисляющий медиану
     * Дублирует информацию в командную строку
     *
     * @param writer       объект PrintWriter, направленный на выходной поток для вывода результата
     * @param doubleVector вектор из вещественных чисел для преобразования
     */
    private void calcMedian(PrintWriter writer, Vector<Double> doubleVector) {
        int size = doubleVector.size();
        writer.print("Медиана = ");
        System.out.print("Медиана = ");
        if (size % 2 == 0) {
            writer.println((doubleVector.get(size / 2) + doubleVector.get(size / 2 - 1)) / 2);
            System.out.println((doubleVector.get(size / 2) + doubleVector.get(size / 2 - 1)) / 2);
        } else {
            writer.println(doubleVector.get(size / 2));
            System.out.println(doubleVector.get(size / 2));
        }
    }

    /**
     * Метод, вычисляющий среднее значение
     * Дублирует информацию в командную строку
     *
     * @param writer       объект PrintWriter, направленный на выходной поток для вывода результата
     * @param doubleVector вектор из вещественных чисел для преобразования
     */
    private void calcAverage(PrintWriter writer, Vector<Double> doubleVector) {
        int size = doubleVector.size();
        writer.println("Среднее значение = " + (doubleVector.stream().mapToDouble(aDouble -> aDouble).sum() / size));
        System.out.println("Среднее значение = " + (doubleVector.stream().mapToDouble(aDouble -> aDouble).sum() / size));
    }
}
