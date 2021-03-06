package com.wedens.file.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Util {
	
	public static BufferedReader getBufReader(String filename)
	{
		BufferedReader inputStream = null;
		
		try {
			File f = new File(filename);
			filename = f.getCanonicalPath();
			if (f.exists()) {
				inputStream = new BufferedReader(new FileReader(f));
				return inputStream;
			} else {
				System.out.printf("File: %s does not exist\n", filename);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.printf("File Not Found: %s\n", filename);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.printf("IOException: %s\n", filename);
		}
		catch (NullPointerException e){
			e.printStackTrace();
			System.out.printf("NullPointerException on file: %s\n", filename);
		}
		return null;
	}

}
