package com.ps;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Book book1 = new Book(1, "0001", "Harry Potter and the Sorcerer's Stone", true);
        book1.checkOut("Joe");

        Book book2 = new Book(2, "0002", "Harry Potter and the Chamber of Secrets", false);
        Book book3 = new Book(3, "0003", "Harry Potter and the Prisoner of Azkaban", false);
        Book book4 = new Book(4, "0004", "Harry Potter and the Goblet of Fire", false);
        Book book5 = new Book(5, "0005", "Harry Potter and the Order of the Phoenix", true);
        book1.checkOut("Mia");

        Book book6 = new Book(6, "0006", "Harry Potter and the Half-Blood Prince", true);
        book6.checkOut("Owen");

        Book book7 = new Book(7, "0007", "Harry Potter and the Deathly Hallows", false);
        Book book8 = new Book(8, "0008", "The Hunger Games", false);
        Book book9 = new Book(9, "0009", "Catching Fire", false);
        Book book10 = new Book(10, "0010", "Mockingjay", true);
        book10.checkOut("Lucas");

        Book book11 = new Book(11, "0011", "The Ballad of Songbirds and Snakes", false);
        Book book12 = new Book(12, "0012", "Twilight", true);
        book12.checkOut("Harper");

        Book book13 = new Book(13, "0013", "New Moon", false);
        Book book14 = new Book(14, "0014", "Eclipse", true);
        book14.checkOut("Isabelle");

        Book book15 = new Book(15, "0015", "Breaking Dawn", true);
        book15.checkOut("Zoe");

        Book book16 = new Book(16, "0016", "Divergent", false);
        Book book17 = new Book(17, "0017", "Insurgent", false);
        Book book18 = new Book(18, "0018", "Allegiant", true);
        book18.checkOut("Eva");

        Book book19 = new Book(19, "0019", "Holes", true);
        book19.checkOut("Chloe");

        Book book20 = new Book(20, "0020", "The Giver", true);
        book20.checkOut("Ben");

        Book[] bookInventory = {book1, book2, book3, book4, book5, book6, book7, book8, book9, book10, book11, book12, book13, book14, book15, book16, book17, book18, book19, book20};

        // Store Home Screen

        int input;

        do {

            System.out.println("Please choose an option:");
            System.out.println("1 - See available books");
            System.out.println("2 - See checked out books");
            System.out.println("3 - Exit");

            Scanner scanner = new Scanner(System.in);
            input = scanner.nextInt();

            int bookInput;

            switch (input) {
                case 1:
                    System.out.println("Showing available books");
                    for (Book books : bookInventory) {
                        if (books.isCheckedOut()) {
                            //System.out.println(books);
                        } else {
                            System.out.println(books.getId() + " " + books.getIsbn() + " " + books.getTitle());
                        }
                    }
                    do {
                        System.out.println("Please choose an option: ");
                        System.out.println("1 - Check out a book");
                        System.out.println("2 - Return to HOME menu");

                        bookInput = scanner.nextInt();

                        switch (bookInput) {
                            case 1:
                                System.out.println("Enter in the id of the book you would like to check out");

                                int idOut;
                                idOut = scanner.nextInt();

                                System.out.println("Please enter in your name");
                                String user = scanner.next();

                                for (Book bookid : bookInventory) {
                                    if (idOut == bookid.getId() && !bookid.isCheckedOut()) {
                                        bookid.checkOut(user);
                                        //System.out.println(bookid);
                                        System.out.println(bookid.getTitle() + " was successfully checked out by " + user);
                                    } else if (idOut == bookid.getId() && bookid.isCheckedOut()){
                                        System.out.println("The selected book is unavailable.");
                                    }
                                }
                                break;
                            case 2:
                                System.out.println("Returning to HOME menu...");
                                break;
                        }

                    } while (bookInput != 2);
                    break;
                case 2:
                    System.out.println("Showing checked out books.");
                    for (Book checkedBooks : bookInventory) {
                        if (checkedBooks.isCheckedOut()) {
                            System.out.println(checkedBooks.getId() + " " + checkedBooks.getIsbn()
                                    + " " + checkedBooks.getTitle() + " checked out by " + checkedBooks.getCheckedOutTo());

                        } else {
//                            System.out.println("Book is available");
                        }
                    }
                    String userInput;
                    do {

                        System.out.println("Please choose an option:");
                        System.out.println("C - Check in a book");
                        System.out.println("X - Return to HOME menu");

                        userInput = scanner.next().toUpperCase().trim();

                        switch (userInput) {
                            case "C":
                                System.out.println("Please enter in the ID of the book you would like to check in");
                                int checkId;
                                checkId = scanner.nextInt();

                                for(Book inId:bookInventory) {
                                    if (checkId == inId.getId() && inId.isCheckedOut()) {
                                        inId.checkIn("");
                                        System.out.println(inId.getTitle() + " was successfully checked in.");
                                    } else if (checkId == inId.getId() && !inId.isCheckedOut()) {
                                        System.out.println("Book is already checked in.");
                                    }
                                }

                        }

                    } while (!userInput.equals("X"));
                    break;
            }
        } while (input != 3);
    }
}