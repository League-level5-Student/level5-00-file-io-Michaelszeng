package _02_File_Encrypt_Decrypt;

import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;
import _02_File_Encrypt_Decrypt.Utilities;

public class FileEncryptor extends Utilities{
	// Create a program that takes a message from the user.
	// Use the methods in the String and Character classes to save
	// an encrypted form of the message to a file
	public static void main(String[] args) {
		String s = JOptionPane.showInputDialog("GIVE ME YOUR SECRET MESSAGE");
		try {
			String encryptedStr = Utilities.encrypt(s.getBytes(), (byte)('c'));
			FileWriter fw = new FileWriter("src/_02_File_Encrypt_Decrypt/file.txt");
			fw.write(encryptedStr);
			fw.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
