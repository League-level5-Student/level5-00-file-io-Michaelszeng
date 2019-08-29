package _02_File_Encrypt_Decrypt;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import _02_File_Encrypt_Decrypt.Utilities;

public class FileDecryptor {
	// Create a program that opens the file created by FileEncryptor and display
	// the decrypted message to the user in a JOptionPane.
	public static void main(String[] args) {
		try {
			FileReader fr = new FileReader("src/_02_File_Encrypt_Decrypt/file.txt");
			String content = "";
			int charCode = fr.read();
			while (charCode != -1) {
				content += (char) charCode;
				charCode = fr.read();
			}
			fr.close();
			String s = Utilities.decrypt(content, (byte)('c'));
			System.out.println(s);
			
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
