package _03_To_Do_List;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;

public class ToDoList implements ActionListener{
	/*
	 * Create a program with five buttons: add task, view tasks, remove task, save list, and load list. 
	 * 
	 * When add task is clicked:
	 * 		ask the user for a  task and save it to an array list
	 * 
	 * When the view tasks button is clicked:
	 *		show all the tasks in the list
	 * 
	 * When the remove task button is clicked:
	 * 		prompt the user for which task to remove and take it off of the list.
	 * 
	 * When the save list button is clicked:
	 * 		Save the list to a file
	 * 
	 * When the load list button is clicked:
	 * 		Prompt the user for the location of the file and load the list from that file
	 * 
	 * When the program starts, it should automatically load the last saved file into the list.
	 */
	
	JFrame f = new JFrame();
	JPanel p = new JPanel();
	JButton add = new JButton("Add Task");
	JButton view = new JButton("View Task");
	JButton rem = new JButton("Remove Task");
	JButton save = new JButton("Save Tasks");
	JButton load = new JButton("Load Tasks");
	
	ArrayList<String> tasks = new ArrayList<String>();
	public ToDoList() {
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(p);
		p.add(add);
		p.add(view);
		p.add(rem);
		p.add(save);
		p.add(load);
		f.pack();
	}
	
	public static void main(String[] args) {
		ToDoList tdl = new ToDoList();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == add) {
			String newTask = JOptionPane.showInputDialog("Enter Task To Add: ");
			tasks.add(newTask);
		}
		else if (e.getSource() == view) {
			for (String s : tasks) {
				System.out.println(s);
				System.out.println();
			}
		}
		else if (e.getSource() == rem) {
			while (true) {
				String task = JOptionPane.showInputDialog("Enter Task To Delete: ");
				for (int i=0; i<tasks.size(); i++) {
					String s = tasks.get(i);
					if (task.contentEquals(s)) {
						tasks.remove(i);
						System.out.println("Task Removed");
						System.out.println();
						break;
					}
					else {
						System.out.println("Sorry, Task does not exist.");
						System.out.println();
					}
				}
			}
			
		}
		else if (e.getSource() == save) {
			try {
				FileWriter f = new FileWriter("src/_03_To_Do_List/tasks.txt");
				String allTasks = "";
				for (String s : tasks) {
					allTasks += s+"\n";
				}
				f.write(allTasks);
					
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if (e.getSource() == load) {
			try {
				FileReader r = new FileReader("src/_03_To_Do_List/tasks.txt");
				int c = r.read();
				if (c == -1) {
					System.out.println("Sorry, No Tasks So Far!");
					System.out.println();
				}
				while (c != -1) {
					System.out.println((char) c);
					System.out.println();
					c = r.read();
				}
			}
			catch(IOException e2) {
				e2.printStackTrace();
			}
		}
	}
}
