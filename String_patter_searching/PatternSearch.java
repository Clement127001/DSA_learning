import java.util.Scanner;

class PatternSearch {
    // pattern searching algorithms:
    // where n-> length of the text m-> length of the pattern

    // no preprocessing required

    // 1 -> naive pattern search O((n-m+1)*m) -> quadratic
    // 2 -> improved pattern search O(n) -> only when the pattern is distinct

    // preprocessing based algorithms
    // a-> preprocessing the pattern O(m)

    // 3-> using rabin karp O((n-m)*m) -> but better than naive on average,
    // quadratic only when the pattern is not distinct
    // 4-> using kmp O(n) where we need to preprocess the pattern (O(m)) -> overall
    // O(m+n)

    // b-> preprocessing the text O(n)
    // 5-> using the trie data structure, to search in the pattern

    // 1-> naive pattern search
    static final int CHAR = 256;

    public static void naivePatternSearch(String txt, String pat, int len1, int len2) {

        for (int i = 0; i < len1; i++) {
            int j = 0;

            for (; j < len2; j++) {
                if (txt.charAt(i + j) != pat.charAt(j))
                    break;
            }

            if (j == len2)
                System.out.print(i + " ");
        }
    }

    // 2-> improved naive pattern search
    public static void improvedNaivePatternSearch(String txt, String pat, int len1, int len2) {

        for (int i = 0; i < len1;) {
            int j = 0;

            for (; j < len2; j++) {
                if (txt.charAt(i + j) != pat.charAt(j))
                    break;
            }

            if (j == len2)
                System.out.print(i + " ");

            if (j == 0)
                i++;
            else
                i += j;
        }
    }

    // 3-> rabin karp , using the rolling hash technique
    public static void rabinKarp(String txt, String pat, int len1, int len2) {
        // h -> h^len2 ,q -> prime number to build the weighted hash,d -> input size
        // (total character length 256 in case of characters)
        int q = 101, d = 256;

        // a slight optimisation
        if (len2 > len1)
            return;

        int h = 1;
        for (int i = 1; i < len2; i++)
            h = (h * d) % q;

        // pattern hash, first windows text hash -> building the weighted sum
        // p=pat[0]*d^2+pat[1]*d+pat[2],same in case of text hash value
        int t = 0, p = 0; // using the horner's rule
        for (int i = 0; i < len2; i++) {
            p = (p * d + pat.charAt(i)) % q;
            t = (t * d + txt.charAt(i)) % q;
        }

        // comparison, more like the naive pattern search
        for (int i = 0; i <= (len1 - len2); i++) {
            int j = 0;
            // compare only when their weighted sum are same
            if (t == p) {
                for (; j < len2; j++)
                    if (txt.charAt(i + j) != pat.charAt(j))
                        break;
            }

            if (j == len2)
                System.out.print(i + " ");

            // to alter the hash , by removing the previous windows first character and add
            // the last character of the current window
            if (i < (len1 - len2)) {
                t = ((d * (t - txt.charAt(i) * h)) + txt.charAt(i + len2)) % q;

                if (t < 0)
                    t += q;
            }
        }

    }

    // using kmp algorithm that uses the technique called longest proper prefix that
    // is also suffix (lps array) for optimisation

    // building the lps array
    public static void buildLps(String pat, int n, int lps[]) {

        int len = 0;
        lps[0] = 0;

        int i = 1;

        while (i < n) {

            // case 1 if lps[i]==lps[len]
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            }

            // case 2 if they are not same
            else {
                // case a
                if (len == 0) {
                    lps[i] = 0;
                    i++;
                } else
                    len = lps[len - 1];
            }
        }
    }

    // actual algorithm - KMP implementation
    public static void KMP(String txt, String pat, int len1, int len2) {

        int lps[] = new int[len2];
        buildLps(pat, len2, lps);

        // comparisons
        int i = 0, j = 0;
        while (i < len1) {
            if (txt.charAt(i) == pat.charAt(j)) {
                i++;
                j++;
            }

            if (j == len2) {
                System.out.print(i - len2 + " ");
                j = lps[j - 1];
            }

            else if (i < len1 && txt.charAt(i) != pat.charAt(j)) {
                if (j == 0)
                    i++;

                else
                    j = lps[j - 1];
            }
        }

    }

    // check for the freq same
    public static boolean areSame(int CT[], int CP[], int m) {
        for (int i = 0; i < CHAR; i++) {
            if (CT[i] != CP[i])
                return false;
        }

        return true;
    }

    // check for anagram
    public static boolean isAnagram(String txt, String pat, int n, int m) {

        if (n < m)
            return false;

        // calculate the freq of the both string of size m
        int CP[] = new int[CHAR];
        int CT[] = new int[CHAR];

        int i;

        for (i = 0; i < m; i++) {
            CP[pat.charAt(i)]++;
            CT[txt.charAt(i)]++;
        }

        if (areSame(CT, CP, m))
            return true;

        for (; i < n; i++) {
            if (areSame(CP, CT, m))
                return true;

            // increasing the char freq of the current window
            CT[txt.charAt(i)]++;
            // reducing the char freq of the previous window
            CT[txt.charAt(i - m)]--;
        }

        return false;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the search string");
        String txt = sc.next();
        System.out.println("Enter the pattern to be searched");
        String pat = sc.next();

        int len1 = txt.length();
        int len2 = pat.length();

        // System.out.println("Using the simple naive pattern search:");
        // naivePatternSearch(txt, pat, len1, len2);

        // System.out.println("Using the improved naive pattern search : ");
        // improvedNaivePatternSearch(txt, pat, len1, len2);

        // System.out.println("Using the Rabin Karp algorithm : ");
        // rabinKarp(txt, pat, len1, len2);

        // System.out.println("Using the kmp algorithm with lps array technique : ");
        // KMP(txt, pat, len1, len2);

        System.out.println("Checking for anagram : ");
        System.out.println(isAnagram(txt, pat, len1, len2));
        System.out.println();

        sc.close();

    }
}