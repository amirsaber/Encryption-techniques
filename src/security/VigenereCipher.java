/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package security;

/**
 *
 * @author amir
 */
public class VigenereCipher

{

    public static String encrypt(String text, final String key)

    {

        String res = "";

        text = text.toUpperCase();
           String k = key.toUpperCase();

        for (int i = 0, j = 0; i < text.length(); i++)

        {

            char c = text.charAt(i);

            if (c < 'A' || c > 'Z')  continue;

              

            res += (char) ((c + k.charAt(j)) % 26 + 65);

            j = ++j % k.length();

        }

        return res;

    }

 

    public static String decrypt(String text, final String key)

    {

        String res = "";

        text = text.toUpperCase();
        String k = key.toUpperCase();

        for (int i = 0, j = 0; i < text.length(); i++)

        {

            char c = text.charAt(i);

            if (c < 'A' || c > 'Z')

                continue;

            res += (char) ((c - k.charAt(j) + 26) % 26 + 65);

            j = ++j % k.length();

        }

        return res;

    }

 

 

}