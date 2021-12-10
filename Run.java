import java.util.*;
import java.io.*;


public class Run {
    public static void main(String args[]) throws Exception {
        try {
            String command1 = "javac " + args[0] + ".java";
            System.out.println(command1);
            Process p2 = Runtime.getRuntime().exec(command1);
            Thread.sleep(1500);
            String command2 = "java " + args[0] + " " + args[0] + "in.txt " + " " + args[0] + "out.txt";
            System.out.println(command2);
            Process p1 = Runtime.getRuntime().exec(command2);
            Thread.sleep(500);
            BufferedReader br = new BufferedReader(new InputStreamReader(p2.getErrorStream()));
            String line = br.readLine();
            if (line != null) {
                System.out.println("Found Error In Your Program");
                while (line != null) {
                    System.out.println(line);
                    line = br.readLine();
                }
            }
            
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
