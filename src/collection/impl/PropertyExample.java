package collection.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyExample {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		Properties p = new Properties();
//		p.setProperty("Brand", "MAC");
//		p.setProperty("Processor", "I7");
//		p.setProperty("OS", "Window");
//		p.setProperty("Model", "Latitude");
//		p.storeToXML(new FileOutputStream("C:/Users/OMKUMAR/Downloads/application.xml"), "Laptop");
		p.loadFromXML(new FileInputStream("C:/Users/OMKUMAR/Downloads/application.xml"));
		System.out.println(p);
	}
}
