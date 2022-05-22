import java.util.ArrayList;

import javax.sound.sampled.SourceDataLine;

public class StringArrayListDemo {
  public static void main(String[] args) {
    ArrayList<String> playlist = new ArrayList<>();
    playlist.add("song 1");
    playlist.add("song 2");
    System.out.println(playlist.toString());

    playlist.remove("song 1");
    System.out.println(playlist.toString());
    System.out.println(playlist.contains("Song 1"));
    playlist.add("song one");
    System.out.println(playlist.toString());
  }
}