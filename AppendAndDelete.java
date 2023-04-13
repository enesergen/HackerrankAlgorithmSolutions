//URL:https://www.hackerrank.com/challenges/append-and-delete/problem
public static String appendAndDelete(String s, String t, int k) {
        // if s==t then k>=2*s.length or k%2==0
        // else how many chars they share
        if (s.equals(t)) {
            return (k >= s.length() * 2 || k % 2 == 0) ? "Yes" : "No";
        } else {
            int index = -1;//abc adc index should be 0 because only 'a' is common
            for (int i = 0; i < Math.min(s.length(), t.length()); i++) {
                if (s.charAt(i) != t.charAt(i)) {
                    break;
                }
                index++;
            }
            int deleteOperation = s.length() - index - 1;// s:abc t:adb then index:0 => 3-0-1=2 delete
            int appendOperation = t.length() - index - 1;// s:abc t:adb then index:0 => 3-0-1=2 append

            //Conditions
            boolean con1 = deleteOperation + appendOperation == k;
            //abcdef abjh del=4 append=2 k=6
            boolean con2 = s.length() + t.length() <= k;
            //blank string deleting operation return blank string
            boolean con3 = (deleteOperation + appendOperation < k) && (deleteOperation + appendOperation - k) % 2 == 0;
            //aaaaaaaa aaaaa only one char used for 2 string s:8 t:5 and k=7
            // => delete:3 append:0 3-7=-4%2=0
            // => delete:4 append:1 5-7=-2%2=0
            //
            return (con1 || con2 || con3) ? "Yes" : "No";
        }
    }
