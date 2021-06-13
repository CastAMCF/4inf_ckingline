package API;

import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Images {
	
	public static void setImage(JLabel label, URL path) {
		ImageIcon ico = new ImageIcon(path);
		Image img = ico.getImage();
		Image imgScale = img.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon newimg = new ImageIcon(imgScale);
		label.setIcon(newimg);
    }
	
}
