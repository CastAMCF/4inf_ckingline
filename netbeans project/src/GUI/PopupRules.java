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

/**
 * Inicia o JDialog das regras
 * @author Asus
 */
public class PopupRules extends JDialog implements MouseListener {
	
	private JLabel btnOk;
	private JLabel text;
	private JLabel image;
	private Point loc;
	private int dim_width = 924;
	private int dim_height = 750;
	private boolean listening = true;
	private int selected;
	private int volume;
	
	
	public PopupRules(Frame parent, int soundfile) {
		
		super(parent,"Regras",true);
		
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
	    
		btnOk = new JLabel();
		btnOk.setBounds(361, 566, 178, 92);
		btnOk.addMouseListener(this);
		API.Images.setImage(btnOk, getClass().getResource("/multimedia/imagens/button_ok_exited.png"));
		contentPane.add(btnOk);
        
		String html = "<html><body style='width: %1spx'>%1s";
		text = new JLabel(String.format(html, 540, "Quatro em linha é um jogo bastante simples de jogar. O jogo consiste em 2 jogadores e um tabuleiro, no qual cada jogador tenta colocar quatro peças da mesma cor em linha, tanto na diagonal, como na horizontal ou vertical. O jogador que conseguir colocar as 4 peças em linha da sua cor, é o vencedor, mas se nenhum dos jogadores o conseguir fazer, é considerado empate. ''Durante o jogo aperte G para salvar o mesmo exceto no modo Mistério''"), SwingConstants.CENTER);
		text.setBounds(102, 241, 700, 356);
		text.setFont(Fonts.Crackman.Normal(25));
		text.setForeground(Color.decode("#FF8B3E"));
		contentPane.add(text);
		
		
        ImageIcon gif = new ImageIcon(getClass().getResource("/multimedia/imagens/game_example.gif"));
		image = new JLabel(gif);
		image.setBounds(332, 82, 240, 190);
		contentPane.add(image);
        
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