package API;

import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Fichi {
	
	public static void write(String filename, String text) {
		FileOutputStream f;
		try {
			f = new FileOutputStream(filename);   
            byte byteText[]=text.getBytes();
			f.write(byteText);
			f.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String read(String filename) {
		int intText = 0;
		FileInputStream f;
		String text = "";
		
		try {
			f = new FileInputStream(filename);
            while((intText=f.read()) != -1){
            	System.out.print((char)intText);    
            }
            f.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return text;
	}
	
	public static void writePrefs(String filename, int width, int height, int sound, int vkLeft, int vkRight, int vkDown) {
		String text = "width=" + width + "\n"
					+ "height=" + height + "\n"
					+ "sound=" + sound + "\n"
					+ "leftarrow=" + vkLeft + "\n"
					+ "rightarrow=" + vkRight + "\n"
					+ "droparrow=" + vkDown;
		FileOutputStream f;
		try {
			f = new FileOutputStream(filename);   
            byte byteText[]=text.getBytes();
			f.write(byteText);
			f.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String readPrefs(String filename) {
		int intText = 0;
		String text = "";
		
		if(!fileExists(filename))
			writePrefs(filename, 1024, 800, 50, KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT, KeyEvent.VK_DOWN);
		
		FileInputStream f;
			
		try {
			f = new FileInputStream(filename);
	        while((intText=f.read()) != -1){
	            text += ((char)intText);    
	        }
	        f.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return text;
	}
	
	public static boolean fileExists(String filename) {
		File tmpDir = new File(filename);
		boolean exists = tmpDir.exists();
		return exists;
	}
	
}
