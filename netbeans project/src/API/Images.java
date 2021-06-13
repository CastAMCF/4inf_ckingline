package API;

import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * Tratamento das imagens
 * @author Asus
 */
public class Images {
	
        /**
         * Coloca a imagem pelo caminho especificado na label designada tornando a imagem do mesmo tamanho que a label designada
         * @param label
         * @param path 
         */
	public static void setImage(JLabel label, URL path) {
		ImageIcon ico = new ImageIcon(path);
		Image img = ico.getImage();
		Image imgScale = img.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon newimg = new ImageIcon(imgScale);
		label.setIcon(newimg);
    }
	
}
