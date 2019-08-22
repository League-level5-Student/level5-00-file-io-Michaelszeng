package _02_File_Encrypt_Decrypt;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileDecryptor {
	// Create a program that opens the file created by FileEncryptor and display
	// the decrypted message to the user in a JOptionPane.
	public static void main(String[] args) {
		try {
			FileReader fr = new FileReader("src/_00_Intro_To_File_Input_and_Output/FileRecorderFile.txt");
			String content = "";
			int charCode = fr.read();
			while (charCode != -1) {
				content += (char) charCode;
				charCode = fr.read();
			}
			fr.close();
			System.out.println(content);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
