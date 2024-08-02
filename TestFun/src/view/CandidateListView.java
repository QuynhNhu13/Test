package view;

import java.util.List;
import model.Candidate;

public class CandidateListView {
    public void isCandidates(List<Candidate> candidates) {
        for (Candidate candidate : candidates) {
            System.out.println(candidate);
        }
    }

    public void isMessage(String message) {
        System.out.println(message);
    }
}