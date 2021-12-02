package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;

import content.Person;

public class SaveLineToFile implements Serializable {
	
	//static ObjectOutputStream out;
	static PrintWriter writer;
	
	public static void initializeMyFileWriter() throws IOException{
		writer = new PrintWriter(new File("output.txt"));  
		
	}
	
	public static void writeToFileInSeparateLine(String msg){
		writer.write(msg);
	}

	public static void saveLogFile() {
		writer.flush();
		writer.close();
	}


}
