package _02_File_Encrypt_Decrypt;

import java.util.Base64;

public class Utilities {
	// This basic encryption scheme is called single-byte xor. It takes a single
	// byte and uses exclusive-or on every character in the String.
	public static String encrypt(byte[] plaintext, byte key) {
		for (int i = 0; i < plaintext.length; i++) {
			plaintext[i] = (byte) (plaintext[i] ^ key);
			//System.out.println(plaintext[i]);
		}
		//System.out.println(Base64.getEncoder().encodeToString(plaintext));
		return Base64.getEncoder().encodeToString(plaintext);
	}

	public static String decrypt(String cyphertext, byte key) {
		byte[] b = Base64.getDecoder().decode(cyphertext);
		for (int i = 0; i < b.length; i++) {
			b[i] = (byte) (b[i] ^ key);
			//System.out.println(b[i]);
		}
		//System.out.println(new String(b));
		return new String(b);
	}
}
