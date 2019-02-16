package java.core.basics;

import java.util.ArrayList;
import java.util.List;

public class LCS {
    List<IntermediateResult> res = new ArrayList<>();

    static class IntermediateResult {
        final String a, b;
        final String sub;

        IntermediateResult(String a, String b, String sub) {
            this.a = a;
            this.b = b;
            this.sub = sub;
        }

        public boolean exists(String str1, String str2) {
            return a.equals(str1) && b.equals(str2);
        }
    }

    public static void main(String[] args) {
        String first = "ddsgaysdfasdfx";
        String second = "sdgasdssafgdzxcc";
        //Substring of a: ddsgaysdfasdfx	b: sdgasdssafgdzxcc
        //Sub String : sgasdsfx
        //sgasdsfx
        String sub = "";
        String lcs = new LCS().longestCommonSequence(first, second);
        System.out.println(lcs);
    }

    public String longestCommonSequence(String a, String b ) {
        String sub="",buffer = "";
        System.out.println("Iterating for a: " + a + "\tb: " + b);
        for (IntermediateResult x : res) {
            if (x.exists(a, b)) {
                System.out.println("Got in Buffer , value = " + x.sub);
                return x.sub;
            }

        }

        if (a == null || b == null || a.length() < 1 || b.length() < 1) {
            res.add(new IntermediateResult(a, b,sub));
            return sub;
        }
        if (a.charAt(0) == b.charAt(0)) {
            System.out.println("Char A :" + a.charAt(0) + "\tChar B : " + b.charAt(0));
            sub = String.valueOf( a.charAt(0) );
            if (a.length() >= 2 && b.length() >= 2)
                sub = sub +  longestCommonSequence(a.substring(1, a.length()),
                        b.substring(1, b.length()) );
        } else {
            String sub1 = sub;
            String sub2 = sub;
            if (b.length() >= 2)
                sub1 = longestCommonSequence(a, b.substring(1, b.length()) );
            else
                sub1 = sub;
            if (a.length() >= 2)
                sub2 = longestCommonSequence(a.substring(1, a.length()), b );
            else
                sub2 = sub;
            if (sub1.length() > sub2.length()) {
                sub = sub1;
            } else {
                sub = sub2;
            }
        }
        System.out.println("Substring of a: " + a + "\tb: " + b);
        System.out.println("Sub String : " + sub);
        res.add(new IntermediateResult(a, b,sub));
        return sub;
    }


}


