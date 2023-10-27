import java.io.*;
 
// Main class
public class SQL_Format {
 
    // main driver method
    public static void main(String[] args) throws Exception
    {
 
        // File path is passed as parameter
        File file = new File(
            "C:\\Amazon\\Atlas\\Mod 3- SQL\\Class 4\\Case Study\\PlayersData.txt");
        FileWriter fWriter = new FileWriter(
                "C:\\Amazon\\Atlas\\Mod 3- SQL\\Class 4\\Case Study\\PlayersDataSQL.txt");
 
        // Note:  Double backquote is to avoid compiler
        // interpret words
        // like \test as \t (ie. as a escape sequence)
 
        // Creating an object of BufferedReader class
        BufferedReader br
            = new BufferedReader(new FileReader(file));
 
        // Declaring a string variable
        // Condition holds true till
        // there is character in a string

        int i;
        // Holds true till there is nothing to read
        while ((i = br.read()) != -1)
 
            // Print all the content of a file
        	fWriter.write(br.read());
    }
}
