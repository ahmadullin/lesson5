package ru.geekbrains.lesson5;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class Backup {
    public static void main(String[] args) throws IOException {
        File sourceDir = new File("."); // Исходная директория
        File backupDir = new File("backup"); // Новая директория для резервных копий
        createBackup(sourceDir, backupDir);
    }

    static void createBackup(File sourceDir, File backupDir) throws IOException {
        if (!sourceDir.isDirectory()) {
            throw new IllegalArgumentException("Исходная директория не является директорией");
        }

        if (!backupDir.exists()) {
            backupDir.mkdir();
        }

        File[] files = sourceDir.listFiles();
        if (files == null) return;

        for (File file : files) {
            File destFile = new File(backupDir, file.getName());
            Files.copy(file.toPath(), destFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Создана резервная копия файла: " + file.getName());
        }
    }
}