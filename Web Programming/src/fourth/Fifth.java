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
        Vector<Double> doubleVector = new Vector<>(args.length);
        try {
            Arrays.stream(args).map(s -> s.replaceAll("[,.]", ".")).mapToDouble(Double::parseDouble)
                    .forEach(doubleVector::add);
        } catch (NumberFormatException e) {
            System.err.println("Do not enter not numbers");
            return;
        }
        int size = doubleVector.size();
        if (size == 0) {
            writer.println("Thanks for no args");
            System.out.println("Thanks for no args");
            return;
        }
        writer.print("Vector before sort: [ ");
        System.out.print("Vector before sort: [ ");
        doubleVector.forEach(aDouble -> writer.print(aDouble + " "));
        doubleVector.forEach(aDouble -> System.out.print(aDouble + " "));
        writer.println("]");
        System.out.println("]");
        doubleVector.sort(Double::compareTo);
        writer.print("Vector after sort: [ ");
        System.out.print("Vector after sort: [ ");
        doubleVector.forEach(aDouble -> writer.print(aDouble + " "));
        doubleVector.forEach(aDouble -> System.out.print(aDouble + " "));
        writer.println("]");
        System.out.println("]");
        writer.print("Median is ");
        System.out.print("Median is ");
        if (size % 2 == 0) {
            writer.println((doubleVector.get(size / 2) + doubleVector.get(size / 2 - 1)) / 2);
            System.out.println((doubleVector.get(size / 2) + doubleVector.get(size / 2 - 1)) / 2);
        } else {
            writer.println(doubleVector.get(size / 2));
            System.out.println(doubleVector.get(size / 2));
        }
        writer.println("Average value is " + (doubleVector.stream().mapToDouble(aDouble -> aDouble).sum() / size));
        System.out.println("Average value is " + (doubleVector.stream().mapToDouble(aDouble -> aDouble).sum() / size));
    }
}
