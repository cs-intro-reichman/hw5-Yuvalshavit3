/**
 * A library of string functions.
 */
public class MyString {
    public static void main(String args[]) {
        String hello = "hello";
        System.out.println(countChar(hello, 'h'));
        System.out.println(countChar(hello, 'l'));
        System.out.println(countChar(hello, 'z'));
        System.out.println(subsetOf("he", "hello"));
        System.out.println(spacedString(hello));
        System.out.println(randomStringOfLetters(10));
        System.out.println(remove("chello", "hel"));
        System.out.println(remove("he", "hello"));
        System.out.println(insertRandomly('h', "hel"));

        
        //// Put your other tests here.
    }

    /**
     * Returns the number of times the given character appears in the given string.
     * Example: countChar("Center",'e') returns 2 and countChar("Center",'c') returns 0. 
     * 
     * @param str - a string
     * @param c - a character
     * @return the number of times c appears in str
     */
    public static int countChar(String str, char ch) {
        int counter = 0;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == ch){
                counter++;
            }
        }
        return counter;
    }

    /** Returns true if str1 is a subset string str2, false otherwise
     *  Examples:
     *  subsetOf("sap","space") returns true
     *  subsetOf("spa","space") returns true
     *  subsetOf("pass","space") returns false
     *  subsetOf("c","space") returns true
     *
     * @param str1 - a string
     * @param str2 - a string
     * @return true is str1 is a subset of str2, false otherwise
     */
    public static boolean subsetOf(String word, String hand) {
        int[] handCounts = new int[26]; // To store frequency of each letter in hand
        int[] wordCounts = new int[26]; // To store frequency of each letter in word
    
        // Count the frequency of each character in the hand
        for (char c : hand.toCharArray()) {
            handCounts[c - 'a']++;
        }
    
        // Count the frequency of each character in the word
        for (char c : word.toCharArray()) {
            wordCounts[c - 'a']++;
            // If the word requires more of a letter than is available in the hand
            if (wordCounts[c - 'a'] > handCounts[c - 'a']) {
                return false;
            }
        }
    
        return true; // All characters in the word are found in the hand
    }

    /** Returns a string which is the same as the given string, with a space
     * character inserted after each character in the given string, except
     * for the last character. 
     * Example: spacedString("silent") returns "s i l e n t"
     * 
     * @param str - a string
     * @return a string consisting of the characters of str, separated by spaces.
     */
    public static String spacedString(String str) {
        if (str.isEmpty()) {
            return "";
        }
        String strnew = "";
        for(int i = 0; i < str.length() - 1; i++){
            strnew += str.charAt(i) + " ";
        }

        strnew += str.charAt(str.length() - 1);

        return strnew;
    }
  
    /**
     * Returns a string of n lowercase letters, selected randomly from 
     * the English alphabet 'a', 'b', 'c', ..., 'z'. Note that the same
     * letter can be selected more than once.
     * 
     * Example: randomStringOfLetters(3) can return "zoo"
     * 
     * @param n - the number of letter to select
     * @return a randomly generated string, consisting of 'n' lowercase letters
     */
    public static String randomStringOfLetters(int n) {
        String str = "";
        for(int i = 0; i < n; i++){
            char charat = (char)((int)(Math.random() * 26) + 97);
            str += charat;
        }
        return str;
    }

    /**
     * Returns a string consisting of the string str1, minus all the characters in the
     * string str2. Assumes (without checking) that str2 is a subset of str1.
     * Example: remove("meet","committee") returns "comit"
     *
     * @param str1 - a string
     * @param str2 - a string
     * @return a string consisting of str1 minus all the characters of str2
     */
    public static String remove(String str1, String str2) {
       String str1new = "";
       char charAt;
       boolean[] used = new boolean[str2.length()];

       for (int i = 0; i < str1.length(); i++){
            boolean isMatched = false;
            charAt = str1.charAt(i);
            for(int j = 0; j < str2.length(); j++){
                if(charAt == str2.charAt(j) && used[j] == false){
                    isMatched = true;
                    used[j] = true;
                    break;
                    }
                }
            if(isMatched == false){
                str1new += charAt;
            }
            }
            
            
            return str1new;
       }
        
    

    /**
     * Returns a string consisting of the given string, with the given
     * character inserted randomly somewhere in the string.
     * For example, insertRandomly("s","cat") can return "scat", or "csat", or "cast", or "cats".  
     * @param ch - a character
     * @param str - a string
     * @return a string consisting of str with ch inserted somewhere
     */
    public static String insertRandomly(char ch, String str) {
         int randomIndex = (int) (Math.random() * (str.length() + 1));
         String result = str.substring(0, randomIndex) + ch + str.substring(randomIndex);
         return result;
    }    
}
