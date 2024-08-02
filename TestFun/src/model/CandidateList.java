package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CandidateList {
    private List<Candidate> candidates;

    public CandidateList() {
        candidates = new ArrayList<>();
    }

    public void loadCandidates(String filename) {
        try (BufferedReader b = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = b.readLine()) != null) {
                String[] parts = line.split(", ");
                if (parts.length == 5) {
                    String id = parts[0];
                    String name = parts[1];
                    String dateOfBirth = parts[2];
                    double grades = Double.parseDouble(parts[3]);
                    String email = parts[4];
                    candidates.add(new Candidate(id, name, dateOfBirth, grades, email));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean addCandidate(Candidate candidate) {
        for (Candidate c : candidates) {
            if (c.getId().equals(candidate.getId())) {
                return false;
            }
        }
        candidates.add(candidate);
        return true;
    }

    public List<Candidate> searchCandidatesByName(String name) {
        List<Candidate> result = new ArrayList<>();
        for (Candidate candidate : candidates) {
            if (candidate.getName().equalsIgnoreCase(name)) {
                result.add(candidate);
            }
        }
        return result;
    }

    public boolean deleteCandidateById(String id) {
        return candidates.removeIf(candidate -> candidate.getId().equals(id));
    }

    public void displayCandidatesSortedByGrades() {
        candidates.sort((c1, c2) -> Double.compare(c2.getGrades(), c1.getGrades()));
        for (Candidate candidate : candidates) {
            System.out.println(candidate);
        }
    }

        public boolean containsCandidateId(String id) {
        for (Candidate candidate : candidates) {
            if (candidate.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }
        
}