package com.example.task05;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Task05Main {
    public static void main(String[] args) {
        String pathToFile = args[0]; // "/home/user/file.txt"

        try
        {
            String s = readFile(pathToFile);
            System.out.println(s);
        } catch (FileNotFoundException ex)
        {
            String message = String.format("файл \"%s\" не найден\n", pathToFile);
            System.out.print(message);
        } catch (IOException ex)
        {
            String message = String.format("произошла ошибка при чтении файла \"%s\"\n", pathToFile);
            System.out.print(message);
        }
    }


    public static String readFile(String pathToFile) throws IOException {
        FileReader fileReader = new FileReader(pathToFile);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        StringBuilder stringBuilder = new StringBuilder();
        String currentLine;
        while ((currentLine = bufferedReader.readLine()) != null) {
            stringBuilder.append(currentLine);
            stringBuilder.append("\n");
        }
        bufferedReader.close();

        return stringBuilder.toString();
    }
}