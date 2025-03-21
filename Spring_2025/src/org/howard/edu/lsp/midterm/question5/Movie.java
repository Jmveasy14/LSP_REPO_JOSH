package org.howard.edu.lsp.midterm.question5;

//Movie implements the Streamable interface
public class Movie implements Streamable {
    
    // Private field to store the title of the movie
    private String movieTitle;

    // Constructor to initialize the movie with its title
    public Movie(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    // Implementation of the play() method from Streamable 
    @Override
    public void play() {
        // Output a message indicating the movie is being played
        System.out.println("Playing movie: " + movieTitle);
    }

    // Implementation of the pause() method 
    @Override
    public void pause() {
        // Output a message indicating the movie is paused
        System.out.println("Paused movie: " + movieTitle);
    }

    // Implementation of the stop() method 
    @Override
    public void stop() {
        // Output a message indicating the movie is stopped
        System.out.println("Stopped movie: " + movieTitle);
    }

    // Allows for rewinding the movie by a given number of seconds
    public void rewind(int seconds) {
        // Output a message indicating the movie is being rewound by the specified number of seconds
        System.out.println("Rewinding movie: " + movieTitle + " by " + seconds + " seconds");
    }
}
