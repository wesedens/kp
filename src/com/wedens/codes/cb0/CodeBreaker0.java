package com.wedens.codes.cb0;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.wedens.file.util.Util;

public class CodeBreaker0 {

	/**
	 * @param args
	 */
	public static int main(String[] args) {

		BufferedReader inputStream = null;
		String         filename    = null;

		System.out.println("hello world");
//		if (args.length < 1) {
//			System.out.printf("usage: cb0 <filename>\n");
//		}

//		try {
//			filename    = args[0];
//			inputStream = Util.getBufReader(filename);
//			String l;
//			StringBuilder code = new StringBuilder();
//			while ((l = inputStream.readLine()) != null) {
//				code.append(l);
//				Decrypt.breakCode(code.toString());
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//			System.out.printf("IOException: %s\n", filename);
//		} finally {
//			if (inputStream != null) {
//				try {
//					inputStream.close();
//				} catch (IOException e) {
//					inputStream = null;
//				}
//			}
//		}
		return 0;
	}
}
