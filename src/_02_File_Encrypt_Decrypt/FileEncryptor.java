package _02_File_Encrypt_Decrypt;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileEncryptor {
	// Create a program that takes a message from the user.
	// Use the methods in the String and Character classes to save
	// an encrypted form of the message to a file
	public static void main(String[] args) {
		String s = JOptionPane.showInputDialog("GIVE ME YOUR SECRET MESSAGE");
		try {
			FileWriter fw = new FileWriter("src/_02_File_Encrypt_Decrypt/file.txt");
			fw.write(s);
			fw.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
