/*
 Samuel DeMero
 */
package a2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.*;
import java.util.LinkedList;

public class A2 {

    
    public static void main(String[] args) throws FileNotFoundException {
    PrintStream ps = new PrintStream(new File("Output.txt"));
 Queue<Song> playlist = new LinkedList<>();
 library(playlist);
 Stack<Song> history = new Stack<>();

 
  boolean notDone = true;
  Scanner sc = new Scanner(System.in);
  
        do {
            /* calls method menu*/
            printMenu(ps);
           char choice = sc.next().charAt(0);

            switch (choice) { 
                case 'n':
                case 'N':
                    history.push(playlist.remove());
                    
      ps.println("Next song is, " +playlist.peek() +"\n");
                    break;
                    
                case 'p':
                case 'P':
                    if(!history.isEmpty()){
        ps.println("Previous song was, " + history.peek()+"\n");
                    }
                    else{
   ps.println("No song was played before this one\n");
                    }
      
                    
                    break;
                
                case 'c':
                case 'C':
         ps.println("Current song playing is, " + playlist.peek()+"\n");
                  break;
                
            case 'q':
                case 'Q':
                    /* calls method printAccts*/
                    ps.println("Thanks for listening!!!\n");
                    notDone = false;
                    break;

                default:
                    ps.println("Invalid selection\n");
                    break;}

        } while (notDone == true);
 
        
        
    }
    
    public static void library(Queue library) throws FileNotFoundException{
        File dir = new File
        ("/Users/samueldemero/Desktop/NetBeansProjects/A2/Week");
       LinkedList<Song> p2 = new LinkedList<>();

        for (File file : dir.listFiles()) {
            Scanner s = new Scanner(file);
            while (s.hasNext()) {
                String line = s.nextLine();
                String[] tokens = line.split(",");

                if (tokens[2].substring(0, 1).equals("\"")) {

                    Song mySong = new Song
        (tokens[1], tokens[2].substring(1, tokens[2].length() - 1));
                    

                    p2.add(mySong);
                    

                } else {
                    Song mySong = new Song(tokens[1], tokens[2]);
                    p2.add(mySong);
                }

            }
            s.close();
        } int n = p2.size();
      String temp;
        for (int j = 0; j < n; j++) {
   	   for (int i = j + 1; i < n; i++) {
		if (p2.get(i).getName().compareTo(p2.get(j).getName()) < 0) {
			temp = p2.get(j).getName();
			p2.get(j).setName(p2.get(i).getName());
                        p2.get(i).setName(temp);
			
		}
	   }
	  
	}
        
        library.addAll(p2);
    }
    private static void printMenu(PrintStream ps) {
        ps.println("Available actions:\npress");
        ps.println("Q - to quit\n" +
                "P - the previous song\n" +
                "C - the current song\n" +
                "N -  to play next song\n");
    }



}

