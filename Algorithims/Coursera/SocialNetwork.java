/*package Coursera;
1. Question 1
Social network connectivity. Given a social network containing
 n members and a log file containing m timestamps at which times pairs of members
  formed friendships, design an algorithm to determine the earliest time at which all 
  members are connected (i.e., every member is a friend of a friend of a friend ... of a friend).
  Assume that the log file is sorted by timestamp and that friendship is an equivalence relation. 
  The running time of your algorithm should be mlogn or better and use extra space proportional
   to n.
/**
 * SocialNetwork
 */
import java.io.*;
import java.util.*;
public class SocialNetwork {
    public static void main(String[] args) {
        int n = StdIn.readInt();
        PathCompressedWQU uf = new PathCompressedWQU(n);
        String time;
        FileInputStream ins;
        try {
            ins = new FileInputStream("socialNetworkLog.txt");
            Scanner scanner = new Scanner(ins, "utf-8");
            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if(line != null && !line.trim().equals("")){
                    String[] lineArray = line.split(" ");
                    if(lineArray.length == 3){
                        String timestamp = lineArray[0];
                        int p = Integer.parseInt(lineArray[1]);
                        int q = Integer.parseInt(lineArray[2]);
                        if(uf.connected(p, q)) continue;
                        uf.union(p, q);
                        if(uf.count()==1) {
                            StdOut.println("All conencted at: " + timestamp);
                            break;
                        }
                    }
                }
                        
            }
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }
    }

}