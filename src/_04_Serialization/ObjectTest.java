package _04_Serialization;

import java.io.Serializable;

public class ObjectTest implements Serializable{
	public String name;
	public int age;
	public ObjectTest(String n, int i) {
		name = n;
		age = i;
	}
	public String getName() {
		return name;
	}
}
