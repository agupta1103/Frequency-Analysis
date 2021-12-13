
/**
 * Write a description of class FrequencyAnalysisTester here.
 *
 * @author Anish Gupta
 * @version 9/13/21
 */
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
public class FrequencyAnalysisTester
{
    public static void main(String[] args) throws IOException
    {
        Scanner in = new Scanner(System.in);

        System.out.println("Welcome to the Frequency Analysis and Deciphering Program (FADP)!");
        System.out.print("Please enter the name of the file (e.g Cool Kids) of which you choose to be read: ");
        String choice = in.nextLine();
        String inFileName = choice + ".txt";
        String outFileName = choice + "Freq.txt";
        System.out.println();

        File fileName = new File(inFileName);
        Scanner inFile = new Scanner(fileName);
        
        int [] freq = new int[25];
        int [] freq1 = new int[25];

        // while loop will continue while inFile has a next token to read
        while(inFile.hasNext())
        {
            String word = inFile.next();  // read next token from file
            FrequencyAnalysis frequency = new FrequencyAnalysis();
            freq1 = frequency.freqCalc(word);
            for(int i = 0; i < 25; i++)
            {
                freq[i] += freq1[i];
            }
        }
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        
        int totalLetter = 0;
        for(int i = 0; i < 25;  i++)
        {
            totalLetter += freq[i];
        }
        
        inFile.close();
        
        PrintWriter outfile = new PrintWriter(new File(outFileName));
        
        for(int i = 0; i < 25;  i++)
        {
            double percent = freq[i] * 100.0 / totalLetter;
            outfile.printf("Frequency of %c is %d and it represents a total of %2.2f %s of all the letters in this file \n", alphabet.charAt(i), freq[i], percent, "%");
            System.out.printf("Frequency of %c is %d and it represents a total of %2.2f %s of all the letters in this file \n", alphabet.charAt(i), freq[i], percent, "%");
        }
        
        outfile.close();
    }
}
