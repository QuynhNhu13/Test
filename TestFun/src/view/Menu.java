package view;

import java.util.Scanner;

public abstract class Menu {
    protected Scanner scanner = new Scanner(System.in);

    public void displayMenu() {
        System.out.println("Candidate Management System");
        System.out.println("--------------------");
        System.out.println("1. Load candidates from file");
        System.out.println("2. Add new candidate");
        System.out.println("3. Search candidates by name");
        System.out.println("4. Delete candidate by ID");
        System.out.println("5. Display all candidates sorted by grades");
        System.out.println("6. Exit");
        System.out.println("--------------------");
    }

    public abstract void handleMenu();
}
