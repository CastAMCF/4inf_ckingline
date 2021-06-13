package Fonts;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.IOException;

/**
 * Fonte customizada
 * @author Asus
 */
public class Crackman {
	
        /**Variável para a fonte normal*/
	protected static Font font_normal;
        /**Variável para a fonte atrás*/
	protected static Font font_back;
        /**Variável para a fonte frente*/
	protected static Font font_front;
	
        /**
         * Criação da fonte customizada normal com o tamanho designado
         * @param size
         * @return 
         */
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
	
        /**
         * Criação da fonte customizada atrás com o tamanho designado
         * @param size
         * @return 
         */
	public static Font Back(float size) {
		
		//cria a fonte
		try {
			font_back = Font.createFont(Font.TRUETYPE_FONT, Crackman.class.getResourceAsStream("/Fonts/crackman_back.ttf")).deriveFont(size);
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
	
        /**
         * Criação da fonte customizada frente com o tamanho designado
         * @param size
         * @return 
         */
	public static Font Front(float size) {
		
		//cria a fonte
		try {
			font_front = Font.createFont(Font.TRUETYPE_FONT, Crackman.class.getResourceAsStream("/Fonts/crackman_front.ttf")).deriveFont(size);
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
