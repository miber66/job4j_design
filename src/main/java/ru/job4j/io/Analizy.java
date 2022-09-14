package ru.job4j.io;

import java.io.*;

public class Analizy {
    public void unavailable(String source, String target) {
        try (BufferedReader read = new BufferedReader(new FileReader(source));
             PrintWriter out = new PrintWriter(new FileOutputStream(target))) {
                 boolean active = true;
                 for (String s: read.lines().toList()) {
                     if (active && s.startsWith("400") || s.startsWith("500")) {
                         out.print(s.split(" ") + ";");
                         active = false;
                     } else if (!active && s.startsWith("200") || s.startsWith("300")) {
                         out.print(s.split(" ") + ";" + System.lineSeparator());
                         active = true;
                     }
                 }
             } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        try (PrintWriter out = new PrintWriter(new FileOutputStream("unavailable.csv"))) {
            out.println("15:01:30;15:02:32");
            out.println("15:10:30;23:12:32");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
