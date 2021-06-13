package GUI;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.imageio.ImageIO;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.Icon;
import javax.swing.ImageIcon;

import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.awt.Image;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Toolkit;

public class PopupAbout extends JDialog implements MouseListener {
	
	private JLabel btnOk;
	private JLabel text;
	private JLabel text1;
	private JLabel text2;
	private JLabel text3;
	private JLabel text4;
	private JLabel text5;
	private JLabel text6;
	private JLabel text7;
	private JLabel text8;
	private JLabel image1;
	private JLabel image2;
	private Point loc;
	private int dim_width = 924;
	private int dim_height = 750;
	private boolean listening = true;
	private int selected;
	private int volume;
	
	
	public PopupAbout(Frame parent, int soundfile) {
		
		super(parent,"Acerca",true);
		
		volume = soundfile;
		
		KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {

	        @Override
	        public boolean dispatchKeyEvent(KeyEvent ke) { 
	        	if(listening) {
		        	switch (ke.getID()) {
		        	case KeyEvent.KEY_PRESSED:
		        		if (ke.getKeyCode() == KeyEvent.VK_RIGHT) {
		        			
		        			try {  API.Sounds.PlaySound("/multimedia/audios/mouse_on.wav", volume);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {e.printStackTrace();}
		        			API.Images.setImage(btnOk, getClass().getResource("/multimedia/imagens/button_ok_entered.png"));
		        			selected = 1;
		        			
		        		}else if (ke.getKeyCode() == KeyEvent.VK_LEFT) {
		        			
		        			try {  API.Sounds.PlaySound("/multimedia/audios/mouse_on.wav", volume);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {e.printStackTrace();}
		        			API.Images.setImage(btnOk, getClass().getResource("/multimedia/imagens/button_ok_entered.png"));
		        			selected = 1;
		        			
		        		}else if (ke.getKeyCode() == KeyEvent.VK_UP) {
		        			
		        			try {  API.Sounds.PlaySound("/multimedia/audios/mouse_on.wav", volume);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {e.printStackTrace();}
		        			API.Images.setImage(btnOk, getClass().getResource("/multimedia/imagens/button_ok_entered.png"));
		        			selected = 1;
		        			
		        		}else if (ke.getKeyCode() == KeyEvent.VK_DOWN) {
		        			
		        			try {  API.Sounds.PlaySound("/multimedia/audios/mouse_on.wav", volume);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {e.printStackTrace();}
		        			API.Images.setImage(btnOk, getClass().getResource("/multimedia/imagens/button_ok_entered.png"));
		        			selected = 1;
		        			
		        		}else if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
		        			
                    		switch (selected) {
	                  		  case 1:
	                  			try {  API.Sounds.PlaySound("/multimedia/audios/mouse_click.wav", soundfile);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {e1.printStackTrace();}
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
				ImageIcon img = new ImageIcon(getClass().getResource("/multimedia/imagens/background_game.png"));
				g.drawImage(img.getImage(), 0, 0, this.getWidth(), this.getHeight(), null);
			}
		};
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				API.Images.setImage(btnOk, getClass().getResource("/multimedia/imagens/button_ok_exited.png"));
        		selected = 0;
			}
		});
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
	    
		String html = "<html><body style='width: %1spx'>%1s";
		text = new JLabel(String.format(html, 540, "Projeto final designado como quatro em linha desenvolvido no âmbito da cadeira de Programação Orientada a Objetos"), SwingConstants.CENTER);
		text.setHorizontalAlignment(SwingConstants.CENTER);
		text.setBounds(102, 301, 700, 356);
		text.setFont(Fonts.Crackman.Normal(25));
		text.setForeground(Color.decode("#FF8B3E"));
		contentPane.add(text);
		
		text1 = new JLabel(String.format("Engenharia Informática"));
		text1.setHorizontalAlignment(SwingConstants.CENTER);
		text1.setBounds(282, 91, 350, 56);
		text1.setFont(Fonts.Crackman.Normal(24));
		text1.setForeground(Color.decode("#FF8B3E"));
		contentPane.add(text1);
		
		text2 = new JLabel(String.format("1º Ano"));
		text2.setHorizontalAlignment(SwingConstants.CENTER);
		text2.setBounds(282, 141, 350, 56);
		text2.setFont(Fonts.Crackman.Normal(24));
		text2.setForeground(Color.decode("#FF8B3E"));
		contentPane.add(text2);
		
		text3 = new JLabel(String.format("Turma B"));
		text3.setHorizontalAlignment(SwingConstants.CENTER);
		text3.setBounds(282, 191, 350, 56);
		text3.setFont(Fonts.Crackman.Normal(24));
		text3.setForeground(Color.decode("#FF8B3E"));
		contentPane.add(text3);
		
		text4 = new JLabel(String.format("2021/2022"));
		text4.setHorizontalAlignment(SwingConstants.CENTER);
		text4.setBounds(282, 241, 350, 56);
		text4.setFont(Fonts.Crackman.Normal(24));
		text4.setForeground(Color.decode("#FF8B3E"));
		contentPane.add(text4);
		
		text5 = new JLabel(String.format("Afonso Castelão"));
		text5.setHorizontalAlignment(SwingConstants.CENTER);
		text5.setBounds(62, 292, 230, 56);
		text5.setFont(Fonts.Crackman.Normal(24));
		text5.setForeground(Color.decode("#FF8B3E"));
		contentPane.add(text5);
		
		text6 = new JLabel(String.format("22921"));
		text6.setHorizontalAlignment(SwingConstants.CENTER);
		text6.setBounds(72, 322, 210, 56);
		text6.setFont(Fonts.Crackman.Normal(24));
		text6.setForeground(Color.decode("#FF8B3E"));
		contentPane.add(text6);
		
		text7 = new JLabel(String.format("Pedro Cortesão"));
		text7.setHorizontalAlignment(SwingConstants.CENTER);
		text7.setBounds(632, 292, 210, 56);
		text7.setFont(Fonts.Crackman.Normal(24));
		text7.setForeground(Color.decode("#FF8B3E"));
		contentPane.add(text7);
		
		text8 = new JLabel(String.format("23373"));
		text8.setHorizontalAlignment(SwingConstants.CENTER);
		text8.setBounds(632, 322, 210, 56);
		text8.setFont(Fonts.Crackman.Normal(24));
		text8.setForeground(Color.decode("#FF8B3E"));
		contentPane.add(text8);
		
		btnOk = new JLabel();
		btnOk.setBounds(361, 556, 178, 92);
		btnOk.addMouseListener(this);
		API.Images.setImage(btnOk, getClass().getResource("/multimedia/imagens/button_ok_exited.png"));
		contentPane.add(btnOk);
		
		image1 = new JLabel();
		image1.setBounds(72, 82, 210, 210);
		API.Images.setImage(image1, getClass().getResource("/multimedia/imagens/gostoso1.png"));
		contentPane.add(image1);
		
		image2 = new JLabel();
		image2.setBounds(632, 82, 210, 210);
		API.Images.setImage(image2, getClass().getResource("/multimedia/imagens/gostoso2.png"));
		contentPane.add(image2);
        
		getContentPane().add(contentPane);
		pack();
    }
   
	@Override
	public void mouseEntered(MouseEvent ae) {
		
		try {  API.Sounds.PlaySound("/multimedia/audios/mouse_on.wav", volume);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {e.printStackTrace();}
		Object source = ae.getSource();
		if (source == btnOk) {
			API.Images.setImage(btnOk, getClass().getResource("/multimedia/imagens/button_ok_entered.png"));
			selected = 1;
		}
	}
	
	@Override
	public void mouseExited(MouseEvent ae) {
		Object source = ae.getSource();
		if (source == btnOk) {
			API.Images.setImage(btnOk, getClass().getResource("/multimedia/imagens/button_ok_exited.png"));
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent ae) {
		
		try {  API.Sounds.PlaySound("/multimedia/audios/mouse_click.wav", volume);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {e.printStackTrace();}
		
		dispose();
	}
	
	@Override
	public void mouseReleased(MouseEvent ae) {
		
	}
	
	@Override
	public void mousePressed(MouseEvent arg0) {
		
	}
	
	public void run(int dim_x, int dim_y) {
		listening = true;
		this.setBounds(loc.x+(Math.abs((dim_width/2)-(dim_x/2))), loc.y+(Math.abs((dim_height/2)-(dim_y/2))), dim_width, dim_height);
		this.setVisible(true);
		listening = false;
	}
   
}