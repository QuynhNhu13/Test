package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;
import model.Candidate;
import model.CandidateList;
import view.CandidateListView;
import view.Menu;

public class CandidateManager extends Menu {

    private CandidateList candidateList;
    private CandidateListView candidateListView;
    private Scanner scanner;

    public CandidateManager() {
        candidateList = new CandidateList();
        candidateListView = new CandidateListView();
        scanner = new Scanner(System.in);
    }

    @Override
    public void handleMenu() {
        int choice;
        do {
            displayMenu();
            System.out.print("Enter selection: ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        candidateList.loadCandidates("candidates_input.txt");
                        candidateListView.isMessage("Candidates loaded successfully!!!");
                        break;
                    case 2:
                        addNew();
                        break;
                    case 3:
                        searchByName();
                        break;
                    case 4:
                        deleteById();
                        break;
                    case 5:
                        candidateList.displayCandidatesSortedByGrades();
                        break;
                    case 6:
                        candidateListView.isMessage("Exit!!!");
                        break;
                    default:
                        candidateListView.isMessage("Invalid choice!!! Please try again.");
                }
            } else {
                System.out.println("Invalid input!!! Please enter a number.");
                scanner.nextLine();
                choice = -1;
            }
        } while (choice != 6);
    }

    private void addNew() {
        String id;
        while (true) {
            System.out.print("Enter ID: ");
            id = scanner.nextLine();

            if (candidateList.containsCandidateId(id)) {
                System.out.println("Invalid!!! Try again.");
            } else {
                break;
            }
        }
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        String dateOfBirth;
        while (true) {
            System.out.print("Enter Date of Birth (dd-MM-yyyy): ");
            dateOfBirth = scanner.nextLine();
            if (isValidDate(dateOfBirth)) {
                break;
            } else {
                System.out.println("Invalid!!! Try again.");
            }
        }

        double grades;
        while (true) {
            System.out.print("Enter Grades: ");
            if (scanner.hasNextDouble()) {
                grades = scanner.nextDouble();
                scanner.nextLine();
                break;
            } else {
                System.out.println("Invalid grades!!! Please enter a real number.");
                scanner.nextLine();
            }
        }

        System.out.print("Enter Email: ");
        String email = scanner.nextLine();

        Candidate newCandidate = new Candidate(id, name, dateOfBirth, grades, email);
        if (candidateList.addCandidate(newCandidate)) {
            candidateListView.isMessage("Candidate added successfully!!!");
        } else {
            candidateListView.isMessage("Candidate ID already exists!!!");
        }
    }

    private boolean isValidDate(String date) {
        SimpleDateFormat a = new SimpleDateFormat("dd-MM-yyyy");
        a.setLenient(false);
        try {
            a.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    private void deleteById() {
        System.out.print("Enter ID: ");
        String id = scanner.nextLine();
        if (candidateList.deleteCandidateById(id)) {
            candidateListView.isMessage("Candidate deleted successfully!!!");
        } else {
            candidateListView.isMessage("Not found!!! : " + id);
        }
    }

    private void searchByName() {
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        List<Candidate> result = candidateList.searchCandidatesByName(name);
        if (result.isEmpty()) {
            candidateListView.isMessage("Not found!!! : " + name);
        } else {
            candidateListView.isCandidates(result);
        }
    }

    public static void main(String[] args) {
        CandidateManager candidateManager = new CandidateManager();
        candidateManager.handleMenu();
    }
}
