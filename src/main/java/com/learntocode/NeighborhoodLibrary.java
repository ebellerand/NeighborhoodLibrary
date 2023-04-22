package com.learntocode;

import java.util.Scanner;

import static com.learntocode.Book.displayAvailableBooks;
import static com.learntocode.Book.displayCheckedOutBooks;

public class NeighborhoodLibrary {

    static Book[] books = new Book[6];
    static int numBooks = 6;

    public static void main(String[] args) {
        books[0] = new Book(1, "1111", "Rich Dad, Poor Dad");
        books[1] = new Book(2, "2222", "The Richest Man in Babylon");
        books[2] = new Book(3, "3333", "Lessons In Chemistry");
        books[3] = new Book(4, "4444", "Atomic Habits");
        books[4] = new Book(5, "5555", "The Intelligent Investor: The Classic Text on Value Investing");
        books[5] = new Book(6, "6666", "The Candy House");


        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Welcome to the Neighborhood Library. What would you like to do? ");
            System.out.println("1 - Show Available Books");
            System.out.println("2 - Show Checked Out Books");
            System.out.println("3 - Exit");
            System.out.println("Enter your command: ");

            int command = scanner.nextInt();
            scanner.nextLine();

            switch (command) {
                case 1:
                    displayAvailableBooks();

                    break;
                case 2:
                    displayCheckedOutBooks();

                    break;

                case 3:
                    System.out.println("See you next time! ");
                    return;


            }

        }
    }
}
