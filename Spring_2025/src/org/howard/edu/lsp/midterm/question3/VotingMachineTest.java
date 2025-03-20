package org.howard.edu.lsp.midterm.question3;

public class VotingMachineTest {
    public static void main(String[] args) {
        VotingMachine vm = new VotingMachine();
        
        // Set up election candidates
        vm.addCandidate("Alice");
        vm.addCandidate("Bob");
        vm.addCandidate("Charlie");
        
        // Cast some votes
        vm.castVote("Alice");
        vm.castVote("Alice");
        vm.castVote("Bob");
        vm.castVote("Charlie");
        vm.castVote("Charlie");
        vm.castVote("Charlie");
        
        // Tries voting for someone not on the ballot
        boolean success = vm.castVote("Eve");
        System.out.println("Vote for Eve successful? " + success);
        
        // Shows results
        System.out.println("Winner: " + vm.getWinner());
    }
}