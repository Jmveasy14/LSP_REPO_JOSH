package org.howard.edu.lsp.midterm.question3;

import java.util.HashMap;
import java.util.Map;

/**
 * Class to manage votes for different candidates
 */
public class VotingMachine {
    private Map<String, Integer> candidates = new HashMap<>();

    // Adds a candidate with 0 initial votes
    public void addCandidate(String name) {
        candidates.put(name, 0);
    }

    // Cast a vote for an existing candidate
    public boolean castVote(String name) {
        if (!candidates.containsKey(name)) return false;
        candidates.put(name, candidates.get(name) + 1);
        return true;
    }

    // Gets the candidate with the highest vote count
    public String getWinner() {
        String winner = null;
        int maxVotes = -1;

        for (Map.Entry<String, Integer> entry : candidates.entrySet()) {
            if (entry.getValue() > maxVotes) {
                maxVotes = entry.getValue();
                winner = entry.getKey();
            }
        }

        return winner + " WINS with " + maxVotes + " votes!!";
    }
}