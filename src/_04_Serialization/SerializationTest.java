package _04_Serialization;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class SerializationTest {
	private static final String DATA_FILE = "src/_04_Serialization/saved.dat";
	public static void main(String[] args) {
		ObjectTest ot1 = new ObjectTest("sam", 20);
		ObjectTest ot2 = new ObjectTest("dan", 29);
		ArrayList<ObjectTest> list = new ArrayList<ObjectTest>();
		save(list);
		ArrayList<ObjectTest> loadedData = (ArrayList) load();
		String name1 = loadedData.get(0).name;
		int age2 = loadedData.get(1).age;
		
		assertEquals(name1, "sam");
		assertEquals(age2, 29);
	}
	
	private static void save(Object data) {
		try (FileOutputStream fos = new FileOutputStream(new File(DATA_FILE)); 
		ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			oos.writeObject(data);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static Object load() {
		try (FileInputStream fis = new FileInputStream(new File(DATA_FILE)); 
		ObjectInputStream ois = new ObjectInputStream(fis)) {
			return (ArrayList) ois.readObject();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {
			// This can occur if the object we read from the file is not
			// an instance of any recognized class
			e.printStackTrace();
			return null;
		}
	}
}
