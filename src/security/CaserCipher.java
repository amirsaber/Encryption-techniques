/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package security;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author amir
 */
public class CaserCipher {

    public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    public String cipherEncrypt(String msg, int shift) {
        msg = msg.toLowerCase();

        String cipherText = "";

        for (int i = 0; i < msg.length(); i++) {

            int charPosition = ALPHABET.indexOf(msg.charAt(i));

            int keyVal = (shift + charPosition) % 26;

            char replaceVal = ALPHABET.charAt(keyVal);

            cipherText += replaceVal;

        }

        return cipherText;
    }

    public String cipherDecypt(String msg, int shift) {
        msg = msg.toLowerCase();

        String plainText = "";

        for (int i = 0; i < msg.length(); i++) {

            int charPosition = ALPHABET.indexOf(msg.charAt(i));

            int keyVal = (charPosition - shift) % 26;

            if (keyVal < 0) {

                keyVal = ALPHABET.length() + keyVal;

            }

            char replaceVal = ALPHABET.charAt(keyVal);

            plainText += replaceVal;

        }

        return plainText;
    }
}
