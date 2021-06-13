package API;

import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Tratamento de ficheiros
 * @author Asus
 */
public class Fichi {
	/**
         * Escreve no ficheiro pelo o nome designado o texto designado
         * @param filename
         * @param text 
         */
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
	
        /**
         * Lê o ficheiro pelo o nome designado e retorna o texto em formato string
         * @param filename
         * @throws IOException 
         */
	public static String read(String filename) throws IOException {
		int intText = 0;
		FileInputStream f;
		String text = "";
		
		f = new FileInputStream(filename);
        while((intText=f.read()) != -1){
        	text += ((char)intText);
        }
        f.close();
        
		return text;
	}
	
        /**
         * Escreve no ficheiro pelo o nome designado a largura, a altura, o volume, o código da tecla designada, o código da tecla designada, o código da tecla designada
         * @param filename
         * @param width
         * @param height
         * @param sound
         * @param vkLeft
         * @param vkRight
         * @param vkDown
         */
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
	
        /**
         * Lê o ficheiro pelo o nome designado se não o encontrar cria um novo com o nome designado e retorna as preferências no formato string
         * @param filename
         */
	public static String readPrefs(String filename) {
		int intText = 0;
		String text = "";
		
		if(!fileExists(filename))
			writePrefs(filename, 1024, 800, 73, KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT, KeyEvent.VK_DOWN);
		
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
	
        /**
         * Verifica se o ficheiro existe
         * @param filename 
         */
	public static boolean fileExists(String filename) {
		File tmpDir = new File(filename);
		boolean exists = tmpDir.exists();
		return exists;
	}
	
}
