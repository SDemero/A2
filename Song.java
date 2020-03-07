/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a2;

/**
 *
 * @author samueldemero
 */
public class Song {

    private String name;
    private String artist;
    
    public Song(String name, String artist) {
        this.name = name;
        this.artist = artist;


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

    public void setArtist(String Artist) {
        this.artist = Artist;
    }
    
public String toString() {
        return this.name + " by " + this.artist;
    }
}
