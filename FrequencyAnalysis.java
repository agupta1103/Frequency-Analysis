
/**
 * Write a description of class FrequencyAnalysis here.
 *
 * @author Anish Gupta
 * @version 9/13/21
 */
import java.lang.Character;
public class FrequencyAnalysis
{
    // instance variables - replace the example below with your own
    private static String alphabet = "abcdefghijklmnopqrstuvwxyz";

    public static int[] freqCalc(String word)
    {
        int[] freq = new int[alphabet.length()];
        for(int i = 0; i < word.length(); i++)
        {
            char wordLetter = Character.toLowerCase(word.charAt(i));
            for(int j = 0; j < alphabet.length(); j++)
            {                
                char alphabetLetter = alphabet.charAt(j);
                if(wordLetter == alphabetLetter)
                {
                    freq[j] += 1;
                }
            }
        }
        return freq;
    }
}
