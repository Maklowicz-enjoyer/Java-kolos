package org.example;

import org.example.models.BoardGame;
import org.example.models.Book;
import org.example.models.Client;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    //    public static void main(String[] args) {
//        LibrarryService librarryService = new LibrarryService();
//
//        Client client1 = new Client("John", "Smith", 20);
//        Client client2 = new Client("John", "Black", 11);
//        Client client3 = new Client("John", "White", 16);
    ////
//        Book book1 = new Book("BookName1", "Author1", 10);
//        Book book2 = new Book("BookName2", "Author2", 15);
//        Book book3 = new Book("BookName3", "Author3", 0);
//
//        BoardGame boardGame1 = new BoardGame("BG1",0, 100);
//        BoardGame boardGame2 = new BoardGame("BG2", 0, 100);
//
//        librarryService.display();
//
//        librarryService.addObjectsToClient(client1, book1);
//        librarryService.addObjectsToClient(client1, book2);
//        librarryService.addObjectsToClient(client1, book3);
//
//        librarryService.addObjectsToClient(client2, book1);
//        librarryService.addObjectsToClient(client2, book3);
//
//        librarryService.addObjectsToClient(client3, book1);
//        librarryService.addObjectsToClient(client3, boardGame1);
//        librarryService.addObjectsToClient(client3, boardGame2);
//
//        librarryService.display();
//
//        System.out.println(librarryService.amountOfAllBooksTaken());
//        System.out.println(librarryService.amountOfAllGameTaken());
//        System.out.println(librarryService.amountOfTakenThingsPerAgeGroup());
//
//        try {
//            librarryService.writeToFile();
//
//        } catch (Exception e) {
//            throw  new IllegalArgumentException("");
//        }
//
//    }

    private static LibrarryService librarryService = new LibrarryService();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {


        Client client1 = new Client("John", "Smith", 20);
        Client client2 = new Client("John", "Black", 11);
        Client client3 = new Client("John", "White", 16);
        //
        Book book1 = new Book("BookName1", "Author1", 10);
        Book book2 = new Book("BookName2", "Author2", 15);
        Book book3 = new Book("BookName3", "Author3", 0);

        BoardGame boardGame1 = new BoardGame("BG1", 0, 100);
        BoardGame boardGame2 = new BoardGame("BG2", 0, 100);


        librarryService.addObjectsToClient(client1, book1);
        librarryService.addObjectsToClient(client1, book2);
        librarryService.addObjectsToClient(client1, book3);

        librarryService.addObjectsToClient(client2, book1);
        librarryService.addObjectsToClient(client2, book3);

        librarryService.addObjectsToClient(client3, book1);
        librarryService.addObjectsToClient(client3, boardGame1);
        librarryService.addObjectsToClient(client3, boardGame2);

        System.out.println("Library Management System");

        while (true) {
            System.out.println("1. Assign Item;  2. Display;  3. Statistics;  4. Save to file;  5. Exit;");
            System.out.print("Choice: ");
            switch (scanner.nextLine().trim()) {
                case "1":
                    assignItem();
                    break;
                case "2":
                    librarryService.display();
                    break;
                case "3":
                    showStats();
                    break;
                case "4":
                    saveToFile();
                    break;
                case "5":
                case "quit":
                case "exit":
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void assignItem() {
        System.out.print("Client (first last age): ");
        String[] input = scanner.nextLine().split(" ");
        Client client = new Client(input[0], input[1], Integer.parseInt(input[2]));

        System.out.print("Item type (1=Book, 2=Game): ");
        if (scanner.nextLine().equals("1")) {
            System.out.print("BOOK_TITLE Author_NAME MIN_AGE: ");
            String[] book = scanner.nextLine().split(" ", 3);
            librarryService.addObjectsToClient(client, new Book(book[0], book[1], Integer.parseInt(book[2])));
        } else {
            System.out.print("BOARD_GAME_NAME MIN_AGE MAX_AGE: ");
            String[] game = scanner.nextLine().split(" ");
            librarryService.addObjectsToClient(client, new BoardGame(game[0], Integer.parseInt(game[1]), Integer.parseInt(game[2])));
        }
        System.out.println("Item assigned.");
    }

    private static void showStats() {
        System.out.println("Books taken: " + librarryService.amountOfAllBooksTaken());
        System.out.println("Games taken: " + librarryService.amountOfAllGameTaken());
        System.out.println("Per age group: " + librarryService.amountOfTakenThingsPerAgeGroup());
    }

    private static void saveToFile() {


        Thread t1 = new Thread(() -> {
            try {
                librarryService.writeToFile();
            } catch (IOException e) {
                System.out.println("shit happend");

                throw new RuntimeException(e);
            }
        });
        t1.start();


        System.out.println("Saved to file.");
    }


}