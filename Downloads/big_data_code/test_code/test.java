// Test java class which detected hidden characters in orginal
// csv files

import java.io.*;

public class test{
    public static void main(String[] args) throws IOException{
        try (BufferedReader br = new BufferedReader(new FileReader("Employee_Dataset.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
               String [] words = line.split(",");
               System.out.println(words[3].charAt(0));
               words[3] = words[3].replaceAll("[^A-Za-z0-9]", "");
               if (words[3].contains("TEACHER")){
                   System.out.println(words[3]);
               }
            }
        }
        catch(NumberFormatException e){
            System.out.println("error here");
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            System.out.println("error");
        }

        
    }
}