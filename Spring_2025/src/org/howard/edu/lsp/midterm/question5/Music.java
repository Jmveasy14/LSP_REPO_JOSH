package org.howard.edu.lsp.midterm.question5;

public class Music implements Streamable {
    private String songTitle;

    public Music(String songTitle) {
        this.songTitle = songTitle;
    }

    @Override
    public void play() {
        System.out.println("Playing music: " + songTitle);
    }

    @Override
    public void pause() {
        System.out.println("Paused music: " + songTitle);
    }

    @Override
    public void stop() {
        System.out.println("Stopped music: " + songTitle);
    }

    // Music-specific behavior: Add to playlist
    public void addToPlaylist(String playlistName) {
        System.out.println("Added " + songTitle + " to " + playlistName + " playlist");
    }
}
