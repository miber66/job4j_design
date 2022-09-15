package ru.job4j.io;

import java.io.*;

public class Analizy {
    public static void unavailable(String source, String target) {
        try (BufferedReader read = new BufferedReader(new FileReader(source));
             PrintWriter out = new PrintWriter(new FileOutputStream(target))) {
                 boolean active = true;
                 for (String s: read.lines().toList()) {
                     if (active && s.startsWith("400") || s.startsWith("500")) {
                         out.append(s.split(" ")[1]).append((";"));
                         active = false;
                     } else if (!active && s.startsWith("200") || s.startsWith("300")) {
                         out.append(s.split(" ")[1]).append(";").append(System.lineSeparator());
                         active = true;
                     }
                 }
             } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        unavailable("server.log", "unavailable.csv");
    }
}
