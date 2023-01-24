class KMP_String_Matching {

    /**
     * The basic idea behind KMP’s algorithm is: whenever we detect a mismatch
     * (after some matches), we already know some of the characters in the text
     * of the next window. We take advantage of this information to avoid matching
     * the characters that we know will anyway match.
     *
     * name lps indicates the longest proper prefix which is also a suffix
     **/
    void KMPSearch(String pat, String txt)
    {
        int M = pat.length();
        int N = txt.length();

        // create lps[] that will hold the longest
        // prefix suffix values for pattern
        int lps[] = new int[M];
        int j = 0; // index for pat[]

        // Preprocess the pattern (calculate lps[] array)
        computeLPSArray(pat, M, lps);

        int i = 0; // index for txt[]
        while ((N - i) >= (M - j)) {
            if (pat.charAt(j) == txt.charAt(i)) { // match --> continue to check
                j++;
                i++;
            }
            if (j == M) { // reached the end of the pattern and all matched
                System.out.println("Found pattern "
                        + "at index " + (i - j));
                j = lps[j - 1]; // indicates how much I can skip
            }

            // mismatch after j matches
            else if (i < N && pat.charAt(j) != txt.charAt(i)) {
                // Do not match lps[0..lps[j-1]] characters,
                // they will match anyway
                if (j != 0)
                    j = lps[j - 1];
                else
                    i = i + 1;
            }
        }
    }

    void computeLPSArray(String pat, int M, int lps[])
    {
        // length of the previous longest prefix suffix
        int len = 0;
        int i = 1;
        lps[0] = 0; // lps[0] is always 0

        // the loop calculates lps[i] for i = 1 to M-1
        while (i < M) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            }
            else // (pat[i] != pat[len])
            {
                // will continue to fall here until they match or we reached the beginning of the pat
                if (len != 0) {
                    len = lps[len - 1];

                    // Also, note that we do not increment
                    // i here
                }
                else // if (len == 0)
                {
                    lps[i] = len;
                    i++;
                }
            }
        }
    }

    // Driver code
    public static void main(String args[])
    {
        String txt = "ABABDABACDABABCABABCABAB";
        String pat = "ABABCABAB";
        new KMP_String_Matching().KMPSearch(pat, txt);
    }
}
// This code has been contributed by Amit Khandelwal.
