import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

import static java.lang.System.exit;

public class Main {
    public static void main(String[] args) {

        Album album1 = new Album("Butta Bomma","Armaan Malik");
        Album album2 = new Album("Doorie","Atif Aslam");

        album1.addSong("Butta Bomma",4.3);
        album1.addSong("Srivalli",3.2);

        album2.addSong("Doorie",3.1);
        album2.addSong("Kuch Is Tarah",4.2);
        album2.addSong("Mahi Ve",4);
        album2.addSong("Mahi Ve",4);

        // find Song
        if(album1.findSong("abc")){
            System.out.println("abc is present");
        }
        else {
            System.out.println("abc is not present");
        }

        if(album2.findSong("Doorie")){
            System.out.println("Doorie is present");
        }
        else {
            System.out.println("Doorie is absent");
        }

        //create playlist
        LinkedList<Song> myPlayList = new LinkedList<>();
        album1.addToPlaylistFromAlbum("Srivalli",myPlayList);
        album2.addToPlaylistFromAlbum(2,myPlayList);
        album1.addToPlaylistFromAlbum(1,myPlayList);

        // wrong song
        album1.addToPlaylistFromAlbum(5,myPlayList);
        album2.addToPlaylistFromAlbum("random",myPlayList);

        play(myPlayList);
    }

    public static void play(LinkedList<Song> playList){

        ListIterator<Song> itr = playList.listIterator();

        // if list is empty
        if(!itr.hasNext()){
            System.out.println("Your playlist is empty");
            return;
        }

        System.out.println("Now playing: ");
        System.out.println(itr.next());

        printMenu();

        Scanner sc = new Scanner(System.in);

        boolean quit = false;
        while(true){

            System.out.println("Please enter your option");
            int option = sc.nextInt();
            switch(option){
                case 1:
                    if(itr.hasNext()){
                        System.out.println("Now playing: ");
                        System.out.println(itr.next());
                    }
                    else{
                        System.out.println("You have reached the end of the playlist");
                    }
                    break;
                case 2:
                    if(itr.hasPrevious()){
                        System.out.println("Now playing: ");
                        System.out.println(itr.previous());
                    }
                    else{
                        System.out.println("You are at the starting of the playlist");
                    }
                    break;
                case 3:
                    break;
                case 4:
                    printSongs(playList);
                    break;
                case 5:
                    break;
                case 6:
                    printMenu();
                    break;
                case 7:
                    exit(0);
            }
        }
    }

    public static void printSongs(LinkedList<Song> playList){
        for(Song s: playList){
            System.out.println(s);
        }
        return;
    }

    public static void printMenu(){

        System.out.println("1. Play next song");
        System.out.println("2. Play previous song");
        System.out.println("3. Repeat the current song");
        System.out.println("4. Show all songs in playlist");
        System.out.println("5. delete the current song");
        System.out.println("6. Show the menu again");
        System.out.println("7. Exit");
    }
}