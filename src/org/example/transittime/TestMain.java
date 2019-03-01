package org.example.transittime;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class TestMain {
	
	public static void main2(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("C:/Users/kumars28/Desktop/Assignment/learn.txt");
		int ch ;
		fis.skip(4);
		while((ch = fis.read())!=-1){
			System.out.print((char)ch);
		}
		fis.close();
		
	
	}
	
	public static void main(String[] args) throws IOException {
		/*FileWriter fw = new FileWriter("C:/Users/kumars28/Desktop/Assignment/learn.txt");
		fw.write("Hellow how r u");
		fw.close();*/
		
		FileOutputStream fos = new FileOutputStream("C:/Users/kumars28/Desktop/Assignment/learn.txt");
		byte[] a = "first line".getBytes();
		fos.write(a);
		PrintStream ps = new PrintStream(fos);
		ps.println("second line");
		ps.println("third line");
		ps.close();
		fos.close();
	}
	
	public static void main1(String args[]) throws IOException
    {
        // attach the file to FileInputStream
        FileInputStream fin = new FileInputStream("file1.txt");
 
        BufferedInputStream bin = new BufferedInputStream(fin);
 
        // illustrating available method
        System.out.println("Number of remaining bytes:" +
                                            bin.available());
 
        // illustrating markSupported() and mark() method
        boolean b=bin.markSupported();
        if (b)
            bin.mark(bin.available());
 
        // illustrating skip method
        /*Original File content:
        * This is my first line
        * This is my second line*/
        bin.skip(4);
        System.out.println("FileContents :");
 
        // read characters from FileInputStream and
        // write them
        int ch;
        while ((ch=bin.read()) != -1)
            System.out.print((char)ch);
 
        // illustrating reset() method
        bin.reset();
        while ((ch=bin.read()) != -1)
            System.out.print((char)ch);
 
        // close the file
        fin.close();
    }
}
