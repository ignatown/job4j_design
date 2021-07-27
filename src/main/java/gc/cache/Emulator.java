package gc.cache;

import java.util.Scanner;

public class Emulator {
    public static void main(String[] args) {
       String directory = "C:\\Projects\\job4j_design";
       DirFileCache dirFileCache = new DirFileCache(directory);
       Scanner scanner = new Scanner(System.in);
       boolean canRun = true;
       System.out.println("Default directory: " + directory);
       System.out.println("Available commands:");
       while (canRun) {
           System.out.println("SET - set the directory");
           System.out.println("LOAD - Load file to cache");
           System.out.println("GET - Get file from cache");
           System.out.println("EXIT - Exit emulator");
           String command = scanner.nextLine();
           switch (command.toLowerCase()) {
               case ("set") -> {
                   System.out.println("Enter the path: ");
                   directory = scanner.nextLine();
                   dirFileCache = new DirFileCache(directory);
                   System.out.println("Done. " + System.lineSeparator());
               }
               case ("load") -> {
                   System.out.println("Enter file name: ");
                   dirFileCache.load(scanner.nextLine());
                   System.out.println("Done. " + System.lineSeparator());
               }
               case ("get") -> {
                   System.out.println("Enter file name: ");
                   System.out.println(dirFileCache.get(scanner.nextLine()));
                   System.out.println("Done. " + System.lineSeparator());
               }
               case ("exit") -> {
                   System.out.println("Exit..");
                   canRun = false;
               }
               default -> System.out.println("Unknown command: " + command);
           }
       }
    }
}
