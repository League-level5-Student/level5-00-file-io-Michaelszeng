package _01_File_Recorder;

import java.io.IOException;

import javax.swing.JOptionPane;
import java.io.FileWriter;

public class FileRecorder {
	public static void main(String[] args) {
		String s = JOptionPane.showInputDialog("Enter CONTENT Please: ");
		try {
			FileWriter fw = new FileWriter("src/_00_Intro_To_File_Input_and_Output/FileRecorderFile.txt");
			fw.write(s);
			fw.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
}
