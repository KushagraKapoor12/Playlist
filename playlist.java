import java.util.ArrayList;
import java.util.Scanner;

// Class representing a song
class Song {
    private String title;
    private String artist;
    private double duration;

    public Song(String title, String artist, double duration) {
        this.title = title;
        this.artist = artist;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public double getDuration() {
        return duration;
    }

    public void play() {
        System.out.println("🎶 Now playing: " + title + " by " + artist + " (" + duration + " mins)");
    }

    public String toString() {
        return title + " - " + artist + " (" + duration + " mins)";
    }
}

// Class that manages the playlist
class PlaylistManager {
    private ArrayList<Song> songs = new ArrayList<>();

    public void addSong(Song song) {
        songs.add(song);
        System.out.println("✅ Song added: " + song.getTitle());
    }

    public void removeSong(String title) {
        for (Song song : songs) {
            if (song.getTitle().equalsIgnoreCase(title)) {
                songs.remove(song);
                System.out.println("🗑 Song removed: " + title);
                return;
            }
        }
        System.out.println("⚠ Song not found!");
    }

    public void showPlaylist() {
        if (songs.isEmpty()) {
            System.out.println("📭 Playlist is empty!");
            return;
        }
        System.out.println("\n🎧 Playlist:");
        for (int i = 0; i < songs.size(); i++) {
            System.out.println((i + 1) + ". " + songs.get(i));
        }
    }

    public void playSong(String title) {
        for (Song song : songs) {
            if (song.getTitle().equalsIgnoreCase(title)) {
                song.play();
                return;
            }
        }
        System.out.println("⚠ Song not found in playlist!");
    }
}

// Main public class
public class playlist {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PlaylistManager playlist = new PlaylistManager();
        int choice;

        do {
            System.out.println("\n=== 🎵 Music Playlist Menu ===");
            System.out.println("1. Add Song");
            System.out.println("2. Remove Song");
            System.out.println("3. Show Playlist");
            System.out.println("4. Play Song");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // Consume the newline

            switch (choice) {
                case 1:
                    System.out.print("Enter song title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter artist name: ");
                    String artist = sc.nextLine();
                    System.out.print("Enter duration (in minutes): ");
                    double duration = sc.nextDouble();
                    sc.nextLine(); // Consume the newline
                    playlist.addSong(new Song(title, artist, duration));
                    break;

                case 2:
                    System.out.print("Enter song title to remove: ");
                    String removeTitle = sc.nextLine();
                    playlist.removeSong(removeTitle);
                    break;

                case 3:
                    playlist.showPlaylist();
                    break;

                case 4:
                    System.out.print("Enter song title to play: ");
                    String playTitle = sc.nextLine();
                    playlist.playSong(playTitle);
                    break;

                case 5:
                    System.out.println("👋 Exiting playlist... Goodbye!");
                    break;

                default:
                    System.out.println("❌ Invalid choice! Try again.");
            }

        } while (choice != 5);

        sc.close();
    }
}
