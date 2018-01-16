package dictionaryattack;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.security.*;
import java.math.*;
import java.io.*;
/**
 *
 * @author channsey
 */
public class DictionaryAttack {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        //System.out.println(md5("181003"));
        long epoch = System.nanoTime();
        long time;
        String pass;
        BufferedReader pwd = null;
        BufferedReader dict = null;
            try {
                String passline;
                String dictline;
                pwd = new BufferedReader(new FileReader("pwd.txt"));
                while ((passline = pwd.readLine()) != null) {
                    dict = new BufferedReader(new FileReader("realhuman_phill.txt"));
                    while ((dictline = dict.readLine()) !=                   null) {
                        pass = md5(dictline);
                        if (passline.equals(pass)) {
                            time = System.nanoTime() - epoch;
                            System.out.println("The password for hash value " + passline + " is " + dictline + ", it takes the program " + time + " sec to recover this password");
                        }
                    }
                }
            } catch (IOException e) {
                    e.printStackTrace();
            } finally {
                    try {
                            if (pwd != null)pwd.close();
                    } catch (IOException ex) {
                            ex.printStackTrace();
                    }
            }      
    }
    public static String md5(String input) {
        String md5 = null;
        if(null == input) 
            return null;
        try {
        //Create MessageDigest object for MD5
        MessageDigest digest = MessageDigest.getInstance("MD5");
        //Update input string in message digest
        digest.update(input.getBytes(), 0, input.length());
        //Converts message digest value in base 16 (hex) 
        md5 = new BigInteger(1, digest.digest()).toString(16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return md5;
    }
    /*  Example
        hashdict("hashed_dict", "realhuman_phill.txt");
        System.out.println("done");
    */
    public static void hashdict(String dictFileName, String newFileName) throws IOException {
        File file = new File(newFileName);
        // creates the file
        file.createNewFile();
        // creates a FileWriter Object
        FileWriter writer = new FileWriter(file); 
        // Writes the content to the file
        String pass;
        BufferedReader dict = new BufferedReader(new FileReader(dictFileName));
        try {
            String dictline;
            while ((dictline = dict.readLine()) !=                   null) {
                    pass = md5(dictline);
                    writer.write(pass + "\n");
                }
        } catch (IOException e) {
                e.printStackTrace();
        } 
        writer.flush();
        writer.close();
    }
}
