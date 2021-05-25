package Model;

import javafx.scene.media.AudioClip;

public class Audio {
    private static boolean musicPlaying;

    /*Plays the music in the location of musicFile indefinitely*/
    public static void playMusic(String musicFile){
        AudioClip clip =
                new AudioClip(Audio.class.getResource(musicFile).toString());
        clip.setCycleCount(AudioClip.INDEFINITE);
        clip.setVolume(0.5);
        clip.play();
    }
    /*Returns whether the game music is already playing*/
    public static boolean isMusicPlaying() {
        return musicPlaying;
    }
    /*Sets the value of the musicPlaying boolean variable*/
    public static void setPlaying(boolean p){
        musicPlaying = p;
    }
}
