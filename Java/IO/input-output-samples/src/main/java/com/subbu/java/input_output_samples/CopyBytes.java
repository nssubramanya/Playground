package com.subbu.java.input_output_samples;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Hello world!
 *
 */
public class CopyBytes 
{	
    public static void main( String[] args )
    {
//    	FileInputStream in = null;
//    	
//    	try {
//			in = new FileInputStream("xanadu.txt");
////    		in = new FileInputStream(getClass().getResourceAsStream("xanadu.txt"));
//			
//			int c;
//			
//			while((c = in.read()) != -1) {
//				System.out.print((char)c);
//			}
//			in.close();
//			
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch(IOException e) {
//			e.printStackTrace();
//		} finally {
//			
//		}
    	
    	System.out.println("Starting the App...");
    	
    	FileInputStream in = null;
        FileOutputStream out = null;

        try {
            in = new FileInputStream("xanadu.txt");
            out = new FileOutputStream("outagain.txt");
            int c;

            while ((c = in.read()) != -1) {
                out.write(c);
            }
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
            System.out.println("Copy Successful...");
            
        } catch (FileNotFoundException e) {
        	e.printStackTrace();
        } catch (IOException e) {
        	e.printStackTrace();
        }
    }
}
