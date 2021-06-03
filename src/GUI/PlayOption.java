package GUI;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.Point;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import API.Fichi;

public class PlayOption extends JFrame implements ComponentListener {
	
	private Clip clip;
	private Menu frame;
	private JPanel playoptionPanel;
	private JLabel btnnewgame;
	private JLabel btncontinue;
	private JLabel btnback;
	private static Point loc;
	private boolean listening = true;
	private boolean opcao;
	private int selected;
	private static boolean bool;
	private int widthfile = 0;
	private int heightfile = 0;
	private int soundfile = 0;
	private static long clipTimePostion;
	private static boolean music = false;
	public int count = 0;
	public int count1 = 1;

	public PlayOption() {
		bool = true;
		
		KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {

			@Override
	        public boolean dispatchKeyEvent(KeyEvent ke) { 
	        	if(listening) {
		        	switch (ke.getID()) {
		        	case KeyEvent.KEY_PRESSED:
		        		if (ke.getKeyCode() == KeyEvent.VK_RIGHT) {
		        			
		        			if(opcao) {
		        				API.Images.setImage(btnnewgame, getClass().getResource("/multimedia/imagens/button_newgame_exited.png"));
		        				API.Images.setImage(btncontinue, getClass().getResource("/multimedia/imagens/button_continue_entered.png"));
		        				API.Images.setImage(btnback, getClass().getResource("/multimedia/imagens/button_back_exited.png"));
			        			opcao = false;
			        			selected = 2;
		        			}else {
			        			API.Images.setImage(btnnewgame, getClass().getResource("/multimedia/imagens/button_newgame_entered.png"));
		        				API.Images.setImage(btncontinue, getClass().getResource("/multimedia/imagens/button_continue_exited.png"));
		        				API.Images.setImage(btnback, getClass().getResource("/multimedia/imagens/button_back_exited.png"));
			        			opcao = true;
			        			selected = 1;
		        			}
		        			
		        		}else if (ke.getKeyCode() == KeyEvent.VK_LEFT) {
		        			
		        			if(opcao) {
		        				API.Images.setImage(btnnewgame, getClass().getResource("/multimedia/imagens/button_newgame_exited.png"));
		        				API.Images.setImage(btncontinue, getClass().getResource("/multimedia/imagens/button_continue_entered.png"));
		        				API.Images.setImage(btnback, getClass().getResource("/multimedia/imagens/button_back_exited.png"));
			        			opcao = false;
			        			selected = 2;
		        			}else {
			        			API.Images.setImage(btnnewgame, getClass().getResource("/multimedia/imagens/button_newgame_entered.png"));
		        				API.Images.setImage(btncontinue, getClass().getResource("/multimedia/imagens/button_continue_exited.png"));
		        				API.Images.setImage(btnback, getClass().getResource("/multimedia/imagens/button_back_exited.png"));
			        			opcao = true;
			        			selected = 1;
		        			}
		        			
		        		}else if (ke.getKeyCode() == KeyEvent.VK_UP) {
		        			
		        			API.Images.setImage(btnnewgame, getClass().getResource("/multimedia/imagens/button_newgame_exited.png"));
		    				API.Images.setImage(btncontinue, getClass().getResource("/multimedia/imagens/button_continue_exited.png"));
		    				API.Images.setImage(btnback, getClass().getResource("/multimedia/imagens/button_back_entered.png"));
		    				selected = 3;
		        			
		        		}else if (ke.getKeyCode() == KeyEvent.VK_DOWN) {
		        			
		        			API.Images.setImage(btnnewgame, getClass().getResource("/multimedia/imagens/button_newgame_exited.png"));
		    				API.Images.setImage(btncontinue, getClass().getResource("/multimedia/imagens/button_continue_exited.png"));
		    				API.Images.setImage(btnback, getClass().getResource("/multimedia/imagens/button_back_entered.png"));
		    				selected = 3;
		        			
		        		}else if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
                    		switch (selected) {
	                  		  case 1:
	                  			System.out.println("Monday1");
	                  		    break;
	                  		  case 2:
	                  			System.out.println("Tuesday1");
	                  		    break;
	                  		  case 3:
	                  			System.out.println("Wednesday1");
	                  		    break;
	                  		}
                        }
		        		
		        		break;
		        	}
	        	}
	        	return false;
			}
            
        });
		
		String[] str = Fichi.readPrefs("preferencias.ap").split("\n");
		widthfile = Integer.parseInt(str[0].replaceAll("\\D+",""));
		heightfile = Integer.parseInt(str[1].replaceAll("\\D+",""));
		soundfile = Integer.parseInt(str[2].replaceAll("\\D+",""));
		
		
		try {
			
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(getClass().getResource("/multimedia/audios/music.wav").getFile()));
			clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
			gainControl.setValue((float)(soundfile-84));
			
			if (Menu.getTimeMusic() > (34360748*count1)) {
				count++;
				count1++;
			}
			clip.setMicrosecondPosition(Menu.getTimeMusic() - (34360748*count));
			
			//clip.setMicrosecondPosition(Menu.getTimeMusic());
			clip.start();
			clip.loop(Clip.LOOP_CONTINUOUSLY);
			
		} catch (LineUnavailableException | UnsupportedAudioFileException | IOException e1) {
			e1.printStackTrace();
		}
		
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/multimedia/imagens/logo.png")));
		setTitle("Quatro em Linha");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Point loc = Menu.getLoca();
		setBounds(loc.x, loc.y, widthfile, heightfile);
		setResizable(false);
		
		playoptionPanel = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
            	super.paintComponent(g);
                ImageIcon img = new ImageIcon(getClass().getResource("/multimedia/imagens/background_menu.png"));
                g.drawImage(img.getImage(), 0, 0, this.getWidth(), this.getHeight(), null);
            }
        };
        playoptionPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				API.Images.setImage(btnnewgame, getClass().getResource("/multimedia/imagens/button_newgame_exited.png"));
				API.Images.setImage(btncontinue, getClass().getResource("/multimedia/imagens/button_continue_exited.png"));
				API.Images.setImage(btnback, getClass().getResource("/multimedia/imagens/button_back_exited.png"));
        		opcao = false;
        		selected = 0;
			}
		});
		playoptionPanel.setBackground(SystemColor.control);
		playoptionPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		playoptionPanel.setLayout(null);
		setContentPane(playoptionPanel);
		
		btnnewgame = new JLabel();
		btnnewgame.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				API.Images.setImage(btnnewgame, getClass().getResource("/multimedia/imagens/button_newgame_entered.png"));
				API.Images.setImage(btncontinue, getClass().getResource("/multimedia/imagens/button_continue_exited.png"));
				API.Images.setImage(btnback, getClass().getResource("/multimedia/imagens/button_back_exited.png"));
				selected = 1;
			}
			@Override
			public void mouseExited(MouseEvent e) {
				API.Images.setImage(btnnewgame, getClass().getResource("/multimedia/imagens/button_newgame_exited.png"));
				selected = 0;
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		btnnewgame.setBounds(164, 310, 296, 112);
		API.Images.setImage(btnnewgame, getClass().getResource("/multimedia/imagens/button_newgame_exited.png"));
		playoptionPanel.add(btnnewgame);
		
		btncontinue = new JLabel();
		btncontinue.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				API.Images.setImage(btncontinue, getClass().getResource("/multimedia/imagens/button_continue_entered.png"));
				API.Images.setImage(btnnewgame, getClass().getResource("/multimedia/imagens/button_newgame_exited.png"));
				API.Images.setImage(btnback, getClass().getResource("/multimedia/imagens/button_back_exited.png"));
				selected = 2;
			}
			@Override
			public void mouseExited(MouseEvent e) {
				API.Images.setImage(btncontinue, getClass().getResource("/multimedia/imagens/button_continue_exited.png"));
				selected = 0;
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		btncontinue.setBounds(556, 307, 296, 112);
		API.Images.setImage(btncontinue, getClass().getResource("/multimedia/imagens/button_continue_exited.png"));
		playoptionPanel.add(btncontinue);
		
		btnback = new JLabel();
		btnback.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				API.Images.setImage(btnback, getClass().getResource("/multimedia/imagens/button_back_entered.png"));
				API.Images.setImage(btnnewgame, getClass().getResource("/multimedia/imagens/button_newgame_exited.png"));
				API.Images.setImage(btncontinue, getClass().getResource("/multimedia/imagens/button_continue_exited.png"));
				selected = 3;
			}
			@Override
			public void mouseExited(MouseEvent e) {
				API.Images.setImage(btnback, getClass().getResource("/multimedia/imagens/button_back_exited.png"));
				selected = 0;
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				setLoca(getLocation());
				opcao = false;
				selected = 0;
				listening = false;
				Menu.setPlayop(true);
				clipTimePostion = clip.getMicrosecondPosition();
				clip.stop();
				frame = new Menu();
				frame.setVisible(true);
				
				dispose();
			}
		});
		btnback.setBounds(354, 566, 296, 112);
		API.Images.setImage(btnback, getClass().getResource("/multimedia/imagens/button_back_exited.png"));
		playoptionPanel.add(btnback);
		
		getContentPane().addComponentListener(this);
		
	}
	
	public void setLoca(Point loc) {
		this.loc = loc;
	}
	
	public static Point getLoca() {
		return loc;
	}
	
	public static void setBool(boolean bool1) {
		bool = bool1;
	}
	
	public static boolean getBool() {
		return bool;
	}
	
	public static long getTimeMusic() {
		return clipTimePostion;
	}
	
	@Override
	public void componentHidden(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentMoved(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentResized(ComponentEvent arg0) {
		int height = this.getHeight();
	    int width = this.getWidth();
	    
	    btnnewgame.setBounds(164, 310+((height-800)/3), 296+((width-1024)/2), 112+((height-800)/6));
	    API.Images.setImage(btnnewgame, getClass().getResource("/multimedia/imagens/button_newgame_exited.png"));
	    btncontinue.setBounds(556+((width-1024)/2), 307+((height-800)/3), 296+((width-1024)/2), 112+((height-800)/6));
	    API.Images.setImage(btncontinue, getClass().getResource("/multimedia/imagens/button_continue_exited.png"));
	    btnback.setBounds(354+((width-1024)/4), 566+((height-800)/2), 296+((width-1024)/2), 112+((height-800)/6));
	    API.Images.setImage(btnback, getClass().getResource("/multimedia/imagens/button_back_exited.png"));
	}

	@Override
	public void componentShown(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
