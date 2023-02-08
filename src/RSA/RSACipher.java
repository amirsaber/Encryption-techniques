package RSA;

public class RSACipher {

    private int n, e, d;

    public RSACipher() {
        generateKeys();
    }

    private void generateKeys() {

        int p = 13;
        int q = 17;
        n = p * q;
        int phiN = (p - 1) * (q - 1);
        e = 7;

//      calculate d  ==>  d = e-1 mod(phiN)  ==>   e.d = 1 mod (phiN)
        int i = phiN + 1;
        while (i % e != 0) {
            i += phiN;
        }
        d = i / e;

    }


    public String encrypt(String message) {
        StringBuilder result = new StringBuilder();

        for (int charIndex = 0; charIndex < message.length(); charIndex++) {
            result.append(encryptCharacter(message.charAt(charIndex)));
        }

        return result.toString();
    }

    public String decrypt(String encryptedMessage) {
        StringBuilder result = new StringBuilder();

        for (int charIndex = 0; charIndex < encryptedMessage.length(); charIndex++) {
            result.append(decryptCharacter(encryptedMessage.charAt(charIndex)));
        }

        return result.toString();
    }


    private char encryptCharacter(char m) {
//        char c = (char) (Math.pow(m, e) % n);
        char c = (char) power(m, e, n);
        return c;
    }

    private char decryptCharacter(char c) {
//        char m = (char) ((Math.pow(c, d)) % n);
        char m = (char) power(c, d, n);
        return m;
    }


    /* Iterative Function to calculate    (x^y)%p in O(log y) */
    int power(int x, int y, int p) {
        System.out.println(x + "  ==  " + y + "  ==  " + p);
        // Initialize result
        int res = 1;

        // Update x if it is more than or equal to p
        x = x % p;

        while (y > 0) {
            System.out.println(x + " " + y + " " + res);

            // If y is odd, multiply x with result
            if ((y & 1) == 1)
                res = (res * x) % p;
            System.out.println(x + " : " + y + " : " + res);

            // y must be even now  y = y / 2
            y = y >> 1;
            x = (x * x) % p;
        }
        return res;
    }

}