package GUI;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;

import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.URL;
import java.awt.Image;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Toolkit;

/**
 * Inicia o JDialog com duas opções
 * @author Asus
 */
public class PopupTwoOptions extends JDialog implements MouseListener {
	
	private boolean data = false;
	private JLabel btnYes;
	private JLabel btnNo;
	private JLabel text;
	private Point loc;
	private int dim_width = 600;
	private int dim_height = 500;
	private boolean listening = true;
	private boolean opcao;
	private int selected;
	private int volume;
	
	
	public PopupTwoOptions(Frame parent, String txt, int soundfile) {
		
		super(parent,"Confirmação",true);
		
		volume = soundfile;
		
		KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {

	        @Override
	        public boolean dispatchKeyEvent(KeyEvent ke) { 
	        	if(listening) {
		        	switch (ke.getID()) {
		        	case KeyEvent.KEY_PRESSED:
		        		if (ke.getKeyCode() == KeyEvent.VK_RIGHT) {
		        			
		        			try {  API.Sounds.PlaySound("/multimedia/audios/mouse_on.wav", volume);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {e.printStackTrace();}
		        			if(opcao) {
		        				API.Images.setImage(btnYes, getClass().getResource("/multimedia/imagens/button_yes_exited.png"));
			        			API.Images.setImage(btnNo, getClass().getResource("/multimedia/imagens/button_no_entered.png"));
			        			opcao = false;
			        			selected = 2;
		        			}else {
		        				API.Images.setImage(btnYes, getClass().getResource("/multimedia/imagens/button_yes_entered.png"));
			        			API.Images.setImage(btnNo, getClass().getResource("/multimedia/imagens/button_no_exited.png"));
			        			opcao = true;
			        			selected = 1;
		        			}
		        			
		        		}else if (ke.getKeyCode() == KeyEvent.VK_LEFT) {
		        			
		        			try {  API.Sounds.PlaySound("/multimedia/audios/mouse_on.wav", volume);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {e.printStackTrace();}
		        			if(opcao) {
		        				API.Images.setImage(btnYes, getClass().getResource("/multimedia/imagens/button_yes_exited.png"));
			        			API.Images.setImage(btnNo, getClass().getResource("/multimedia/imagens/button_no_entered.png"));
			        			opcao = false;
			        			selected = 2;
		        			}else {
		        				API.Images.setImage(btnYes, getClass().getResource("/multimedia/imagens/button_yes_entered.png"));
			        			API.Images.setImage(btnNo, getClass().getResource("/multimedia/imagens/button_no_exited.png"));
			        			opcao = true;
			        			selected = 1;
		        			}
		        			
		        		}else if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
		        			
                    		switch (selected) {
	                  		  case 1:
	                  			try {  API.Sounds.PlaySound("/multimedia/audios/mouse_click.wav", soundfile);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {e1.printStackTrace();}
	                  			data = true;
	                  			dispose();
	                  		    break;
	                  		  case 2:
	                  			try {  API.Sounds.PlaySound("/multimedia/audios/mouse_click.wav", soundfile);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {e1.printStackTrace();}
	                  			data = false;
	                  			dispose();
	                  		    break;
	                  		}
                        }
		        		
		        		break;
		        	}
	        	}
	        	return false;
	        	
	        }
            
        });
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/multimedia/imagens/logo.png")));
		setResizable(false);
		loc = parent.getLocation();
		
		JPanel contentPane = new JPanel(){
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				ImageIcon img = new ImageIcon(getClass().getResource("/multimedia/imagens/background_settings.png"));
				g.drawImage(img.getImage(), 0, 0, this.getWidth(), this.getHeight(), null);
			}
		};
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				API.Images.setImage(btnYes, getClass().getResource("/multimedia/imagens/button_yes_exited.png"));
        		API.Images.setImage(btnNo, getClass().getResource("/multimedia/imagens/button_no_exited.png"));
        		opcao = false;
        		selected = 0;
			}
		});
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
	    
		btnYes = new JLabel();
		btnYes.setBounds(41, 362, 178, 92);
		btnYes.addMouseListener(this);
		API.Images.setImage(btnYes, getClass().getResource("/multimedia/imagens/button_yes_exited.png"));
		contentPane.add(btnYes);
	    
		btnNo = new JLabel();
		btnNo.setBounds(312, 362, 178, 92);
		btnNo.addMouseListener(this);
		API.Images.setImage(btnNo, getClass().getResource("/multimedia/imagens/button_no_exited.png"));
		contentPane.add(btnNo);
        
		String html = "<html><body style='width: %1spx'>%1s";
		text = new JLabel(String.format(html, 300, txt), SwingConstants.CENTER);
		text.setBounds(12, 86, 570, 246);
		text.setFont(Fonts.Crackman.Normal(45));
		text.setForeground(Color.decode("#601825"));
		contentPane.add(text);
        
		getContentPane().add(contentPane);
		pack();
    }
   
	@Override
	public void mouseEntered(MouseEvent ae) {
		
		try {  API.Sounds.PlaySound("/multimedia/audios/mouse_on.wav", volume);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {e.printStackTrace();}
		Object source = ae.getSource();
		if (source == btnYes) {
			API.Images.setImage(btnYes, getClass().getResource("/multimedia/imagens/button_yes_entered.png"));
			API.Images.setImage(btnNo, getClass().getResource("/multimedia/imagens/button_no_exited.png"));
			opcao = true;
			selected = 1;
		}
		if (source == btnNo) {
			API.Images.setImage(btnNo, getClass().getResource("/multimedia/imagens/button_no_entered.png"));
			API.Images.setImage(btnYes, getClass().getResource("/multimedia/imagens/button_yes_exited.png"));
			selected = 2;
		}
	}
	
	@Override
	public void mouseExited(MouseEvent ae) {
		Object source = ae.getSource();
		if (source == btnYes) {
			API.Images.setImage(btnYes, getClass().getResource("/multimedia/imagens/button_yes_exited.png"));
		}
		if (source == btnNo) {
			API.Images.setImage(btnNo, getClass().getResource("/multimedia/imagens/button_no_exited.png"));
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent ae) {
		
		try {  API.Sounds.PlaySound("/multimedia/audios/mouse_click.wav", volume);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {e.printStackTrace();}
		Object source = ae.getSource();
		if (source == btnYes) {
			data = true;
		}
		else {
			data = false;
		}
		dispose();
	}
	
	@Override
	public void mouseReleased(MouseEvent ae) {
		
	}
	
	@Override
	public void mousePressed(MouseEvent arg0) {
		
	}
	
	public boolean run(int dim_x, int dim_y) {
		listening = true;
		this.setBounds(loc.x+(Math.abs((dim_width/2)-(dim_x/2))), loc.y+(Math.abs((dim_height/2)-(dim_y/2))), dim_width, dim_height);
		this.setVisible(true);
		listening = false;
		return data;
	}
   
}