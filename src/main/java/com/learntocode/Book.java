package com.learntocode;

import java.util.Scanner;

import static com.learntocode.NeighborhoodLibrary.books;
import static com.learntocode.NeighborhoodLibrary.numBooks;

public class Book {
    private int id;
    private String isbn;
    private String title;
    private boolean isCheckedOut;
    private String checkedOutTo;
    private String renterName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCheckedOut() {
        return isCheckedOut;
    }

    public void setCheckedOut(boolean checkedOut) {
        isCheckedOut = checkedOut;
    }

    public String getCheckedOutTo() {
        return checkedOutTo;
    }

    public void setCheckedOutTo(String checkedOutTo) {
        this.checkedOutTo = checkedOutTo;
    }

    public String getRenterName() {
        return renterName;
    }

    public void setRenterName(String renterName) {
        this.renterName = renterName;
    }


    public static void checkOutBook(int id) {
        for (Book book : books) {
            if ((book.getId() == id) && (!book.isCheckedOut())) {
                book.setCheckedOut(true);
                System.out.println("Checked out " + book.getTitle() + " checked out by " + book.renterName);
            }
        }
    }

    public static void checkInBook(int id) {
        for (Book book : books) {
            if ((book.getId() == id) && (book.isCheckedOut())) {
                book.setCheckedOut(false);
                System.out.println("Checked in " + book.getTitle() + " . Checked in by " + book.renterName);
            }
        }
    }


    public Book(int id, String isbn, String title) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.isCheckedOut = false;
        this.checkedOutTo = "";

    }

    public static void displayAvailableBooks() {
        System.out.println("Available books:");

        for (int i = 0; i < numBooks; i++) {
            if (!books[i].isCheckedOut()) {
                System.out.println(books[i].getTitle() + " " + books[i].getId() + " " + books[i].getIsbn());
            }
        }
        System.out.println("Would you like to check out a book? If so, please enter the book ID, or select 'X' to return to the home screen.");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        if (input.equalsIgnoreCase("X")) {
            return;

        } else {
            boolean bookFound = false;
            for (int i = 0; i < numBooks; i++) {
                if (Integer.parseInt(input) == books[i].getId()) {
                    if (books[i].isCheckedOut()) {
                        System.out.println("Sorry, this book is already checked out.");
                    } else {
                        System.out.println("Please confirm your selection by entering your name: ");
                        String rentersName = scanner.nextLine();
                        books[i].setRenterName(rentersName);
                        Book.checkOutBook(Integer.parseInt(input));
                        System.out.println("The book " + books[i].getTitle() + "has been checked out by " + rentersName);
                    }
                    bookFound = true;
                    break;
                }
            }

            if (!bookFound) {
                System.out.println("Invalid selection");

            }
        }
    }

    public static void displayCheckedOutBooks() {
        System.out.println("Checked out books: ");

        boolean anyCheckedOut = false;

        for (int i = 0; i < numBooks; i++) {
            if (books[i].isCheckedOut()) {
                System.out.println(books[i].getTitle() + " " + books[i].getId() + " " + books[i].getIsbn() + " checked out by " + books[i].renterName);
                anyCheckedOut = true;
            }
        }
        if (!anyCheckedOut) {
            System.out.println("There are currently no checked out books.");
            return;

        }

        System.out.println("Would you like to check in a book? Enter 'c' to check in a book or 'x' to return to the main menu: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        if (input.equalsIgnoreCase("X")) {
            return;

        }
        if (input.equalsIgnoreCase("c")) {
            System.out.println("Please enter the ID of the book you're checking in: ");
            String input2 = scanner.nextLine();


            boolean bookFound = false;
            for (int i = 0; i < numBooks; i++) {
                if (Integer.parseInt(input2) == books[i].getId()) {
                    if (!books[i].isCheckedOut()) {
                        System.out.println("Sorry, this book is already checked in.");
                    } else {
                        Book.checkInBook(Integer.parseInt(input2));
                        System.out.println("The book " + books[i].getTitle() + " has been checked in by " + books[i].getRenterName());
                    }
                    bookFound = true;
                    break;
                }
            }
            if (!bookFound) {
                    System.out.println("Invalid entry. ");
                }
            }
        }
    }


