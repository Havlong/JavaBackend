package fourth;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Vector;

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
        writer.print("Медиана = ");
        System.out.print("Медиана = ");
        if (size % 2 == 0) {
            writer.println((doubleVector.get(size / 2) + doubleVector.get(size / 2 - 1)) / 2);
            System.out.println((doubleVector.get(size / 2) + doubleVector.get(size / 2 - 1)) / 2);
        } else {
            writer.println(doubleVector.get(size / 2));
            System.out.println(doubleVector.get(size / 2));
        }
        writer.println("Среднее значение = " + (doubleVector.stream().mapToDouble(aDouble -> aDouble).sum() / size));
        System.out.println("Среднее значение = " + (doubleVector.stream().mapToDouble(aDouble -> aDouble).sum() / size));
    }
}
