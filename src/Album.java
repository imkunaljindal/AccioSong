import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Album {

    private String name;

    private String artist;

    private List<Song> songs;

    public Album() {
    }

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    public boolean findSong(String title){

        for(Song s: this.songs){
            if(s.getTitle().equals(title)){
                return true;
            }
        }
        return false;
    }

    public boolean addSong(String title, double duration){

        if(!findSong(title)){
            Song s = new Song(title,duration);
            this.songs.add(s);
            System.out.println("Song has been added!!");
            return true;
        }

        System.out.println("Song is already present in the album");
        return false;
    }

    // Method Overloading -> Compile time Polymorphsim
    public boolean addToPlaylistFromAlbum(String title, LinkedList<Song> myPlayList){

        if(findSong(title)){
            for(Song s: this.songs){
                if(s.getTitle().equals(title)){
                    myPlayList.add(s);
                    System.out.println("Congrats!! Song has been added to your playlist");
                    return true;
                }
            }
        }
        System.out.println("Sorry! The song is not present in the album");
        return false;
    }

    public boolean addToPlaylistFromAlbum(int index, LinkedList<Song> myPlayList){

        index = index - 1;
        if(index>=0 && index<this.songs.size()){
            myPlayList.add(this.songs.get(index));
            System.out.println("Congrats! Song has been added");
            return true;
        }

        System.out.println("Invalid song number!!");
        return false;
    }
}
