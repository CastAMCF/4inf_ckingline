package Fonts;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.IOException;

public class Crackman {
	
	protected static Font font_normal;
	protected static Font font_back;
	protected static Font font_front;
	
	public static Font Normal(float size) {
		
		//cria a fonte
		try {
			font_normal = Font.createFont(Font.TRUETYPE_FONT, Crackman.class.getResourceAsStream("/Fonts/crackman.ttf")).deriveFont(size);
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			//alistar a fonte
			ge.registerFont(font_normal);
		} catch (IOException e) {
			e.printStackTrace();
		} catch(FontFormatException e) {
			e.printStackTrace();
		}
		
		return font_normal;
		
	}
	
	public static Font Back(float size) {
		
		//cria a fonte
		try {
			font_back = Font.createFont(Font.TRUETYPE_FONT, Crackman.class.getResourceAsStream("/Fonts/crackman.ttf")).deriveFont(size);
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			//alistar a fonte
			ge.registerFont(font_back);
		} catch (IOException e) {
			e.printStackTrace();
		} catch(FontFormatException e) {
			e.printStackTrace();
		}
		
		return font_back;
		
	}
	
	public static Font Front(float size) {
		
		//cria a fonte
		try {
			font_front = Font.createFont(Font.TRUETYPE_FONT, Crackman.class.getResourceAsStream("/Fonts/crackman.ttf")).deriveFont(size);
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			//alistar a fonte
			ge.registerFont(font_front);
		} catch (IOException e) {
			e.printStackTrace();
		} catch(FontFormatException e) {
			e.printStackTrace();
		}
		
		return font_front;
		
	}
	
}
