package GUI;

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
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

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

/**
 * Inicia a opçao de jogo
 * @author Asus
 */
public class NewGameOptions extends JFrame implements ComponentListener {
	
	private Clip clip;
	private PlayOption frame;
	private JPanel playoptionPanel;
	private JLabel btnsingleplayer;
	private JLabel btnmultiplayer;
	private JLabel btnonline;
	private JLabel btnback;
	private static Point loc;
	private boolean listening = true;
	private int selected;
	private static boolean bool;
	private int widthfile = 0;
	private int heightfile = 0;
	private int soundfile = 0;
	private static long clipTimePostion;
	private static boolean music = false;
	private int count = 0;
	private int count1 = 1;
	private int count2 = 0;
	private int count3 = 1;
	private int count4 = 0;
	private int count5 = 1;
	private int count6 = 0;
	private int count7 = 1;
	private boolean singleplayer;
	private boolean multiplayer;
	private boolean online;
	private static boolean singleop = false;
	private static boolean playop = false;
	private static boolean mysterymode = false;
	private boolean singleplayeroptionsgui = false;
	private boolean playoptiongui = false;
	private boolean mysterymodegui = false;

	public NewGameOptions() {
		bool = true;
		
		KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {

			@Override
	        public boolean dispatchKeyEvent(KeyEvent ke) { 
	        	if(listening) {
		        	switch (ke.getID()) {
		        	case KeyEvent.KEY_PRESSED:
		        		if (ke.getKeyCode() == KeyEvent.VK_RIGHT) {
		        			try {  API.Sounds.PlaySound("/multimedia/audios/mouse_on.wav", soundfile);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {e1.printStackTrace();}
		        			if(singleplayer) {
                        		if(selected == 2) {
                        			API.Images.setImage(btnmultiplayer, getClass().getResource("/multimedia/imagens/button_multiplayer_exited.png"));
	                        		API.Images.setImage(btnonline, getClass().getResource("/multimedia/imagens/button_mystery_entered.png"));
	                        		API.Images.setImage(btnsingleplayer, getClass().getResource("/multimedia/imagens/button_singleplayer_exited.png"));
	                        		API.Images.setImage(btnback, getClass().getResource("/multimedia/imagens/button_back_exited.png"));
	                        		multiplayer = false;
	                        		singleplayer = false;
	                        		online = true;
	                        		selected = 3;
                        		}else {
	                        		API.Images.setImage(btnmultiplayer, getClass().getResource("/multimedia/imagens/button_multiplayer_entered.png"));
	                        		API.Images.setImage(btnonline, getClass().getResource("/multimedia/imagens/button_mystery_exited.png"));
	                        		API.Images.setImage(btnsingleplayer, getClass().getResource("/multimedia/imagens/button_singleplayer_exited.png"));
	                        		API.Images.setImage(btnback, getClass().getResource("/multimedia/imagens/button_back_exited.png"));
	                        		singleplayer = false;
	                        		multiplayer = true;
	                        		online = false;
	                        		selected = 2;
                        		}
                        	}else if (multiplayer) {
                        		if(selected == 3) {
                        			API.Images.setImage(btnmultiplayer, getClass().getResource("/multimedia/imagens/button_multiplayer_exited.png"));
	                        		API.Images.setImage(btnonline, getClass().getResource("/multimedia/imagens/button_mystery_exited.png"));
	                        		API.Images.setImage(btnsingleplayer, getClass().getResource("/multimedia/imagens/button_singleplayer_entered.png"));
	                        		API.Images.setImage(btnback, getClass().getResource("/multimedia/imagens/button_back_exited.png"));
	                        		singleplayer = true;
	                        		multiplayer = false;
	                        		online = false;
	                        		selected = 1;
                        		}else {
	                        		API.Images.setImage(btnmultiplayer, getClass().getResource("/multimedia/imagens/button_multiplayer_exited.png"));
	                        		API.Images.setImage(btnonline, getClass().getResource("/multimedia/imagens/button_mystery_entered.png"));
	                        		API.Images.setImage(btnsingleplayer, getClass().getResource("/multimedia/imagens/button_singleplayer_exited.png"));
	                        		API.Images.setImage(btnback, getClass().getResource("/multimedia/imagens/button_back_exited.png"));
	                        		multiplayer = false;
	                        		singleplayer = false;
	                        		online = true;
	                        		selected = 3;
	                        	}
                        	}else if (online) {
                        		if (selected == 1) {
                        			API.Images.setImage(btnmultiplayer, getClass().getResource("/multimedia/imagens/button_multiplayer_entered.png"));
	                        		API.Images.setImage(btnonline, getClass().getResource("/multimedia/imagens/button_mystery_exited.png"));
	                        		API.Images.setImage(btnsingleplayer, getClass().getResource("/multimedia/imagens/button_singleplayer_exited.png"));
	                        		API.Images.setImage(btnback, getClass().getResource("/multimedia/imagens/button_back_exited.png"));
	                        		multiplayer = true;
	                        		singleplayer = false;
	                        		online = false;
	                        		selected = 2;
                        		}else {
	                        		API.Images.setImage(btnmultiplayer, getClass().getResource("/multimedia/imagens/button_multiplayer_exited.png"));
	                        		API.Images.setImage(btnonline, getClass().getResource("/multimedia/imagens/button_mystery_exited.png"));
	                        		API.Images.setImage(btnsingleplayer, getClass().getResource("/multimedia/imagens/button_singleplayer_entered.png"));
	                        		API.Images.setImage(btnback, getClass().getResource("/multimedia/imagens/button_back_exited.png"));
	                        		online = false;
	                        		singleplayer = true;
	                        		multiplayer = false;
	                        		selected = 1;
                        		}
                        	}else {
                        		API.Images.setImage(btnmultiplayer, getClass().getResource("/multimedia/imagens/button_multiplayer_exited.png"));
                        		API.Images.setImage(btnonline, getClass().getResource("/multimedia/imagens/button_mystery_exited.png"));
                        		API.Images.setImage(btnsingleplayer, getClass().getResource("/multimedia/imagens/button_singleplayer_entered.png"));
                        		API.Images.setImage(btnback, getClass().getResource("/multimedia/imagens/button_back_exited.png"));
                        		singleplayer = true;
                        		multiplayer = false;
                        		online = false;
                        		selected = 1;
                        	}
		        			
		        		}else if (ke.getKeyCode() == KeyEvent.VK_LEFT) {
		        			try {  API.Sounds.PlaySound("/multimedia/audios/mouse_on.wav", soundfile);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {e1.printStackTrace();}
		        			if(singleplayer) {
                        		if (selected == 1) {
                        			API.Images.setImage(btnmultiplayer, getClass().getResource("/multimedia/imagens/button_multiplayer_exited.png"));
	                        		API.Images.setImage(btnonline, getClass().getResource("/multimedia/imagens/button_mystery_entered.png"));
	                        		API.Images.setImage(btnsingleplayer, getClass().getResource("/multimedia/imagens/button_singleplayer_exited.png"));
	                        		API.Images.setImage(btnback, getClass().getResource("/multimedia/imagens/button_back_exited.png"));
	                        		multiplayer = false;
	                        		singleplayer = false;
	                        		online = true;
	                        		selected = 3;
                        		}else {
	                        		API.Images.setImage(btnmultiplayer, getClass().getResource("/multimedia/imagens/button_multiplayer_exited.png"));
	                        		API.Images.setImage(btnonline, getClass().getResource("/multimedia/imagens/button_mystery_exited.png"));
	                        		API.Images.setImage(btnsingleplayer, getClass().getResource("/multimedia/imagens/button_singleplayer_entered.png"));
	                        		API.Images.setImage(btnback, getClass().getResource("/multimedia/imagens/button_back_exited.png"));
	                        		singleplayer = false;
	                        		multiplayer = false;
	                        		online = true;
	                        		selected = 1;
                        		}
                        	}else if (multiplayer) {
                        		if (selected == 2) {
                        			API.Images.setImage(btnmultiplayer, getClass().getResource("/multimedia/imagens/button_multiplayer_exited.png"));
	                        		API.Images.setImage(btnonline, getClass().getResource("/multimedia/imagens/button_mystery_exited.png"));
	                        		API.Images.setImage(btnsingleplayer, getClass().getResource("/multimedia/imagens/button_singleplayer_entered.png"));
	                        		API.Images.setImage(btnback, getClass().getResource("/multimedia/imagens/button_back_exited.png"));
	                        		singleplayer = false;
	                        		multiplayer = false;
	                        		online = true;
	                        		selected = 1;
                        		}else {
	                        		API.Images.setImage(btnmultiplayer, getClass().getResource("/multimedia/imagens/button_multiplayer_entered.png"));
	                        		API.Images.setImage(btnonline, getClass().getResource("/multimedia/imagens/button_mystery_exited.png"));
	                        		API.Images.setImage(btnsingleplayer, getClass().getResource("/multimedia/imagens/button_singleplayer_exited.png"));
	                        		API.Images.setImage(btnback, getClass().getResource("/multimedia/imagens/button_back_exited.png"));
	                        		multiplayer = false;
	                        		singleplayer = true;
	                        		online = false;
	                        		selected = 2;
                        		}
                        	}else if (online) {
                        		if (selected == 3) {
                        			API.Images.setImage(btnmultiplayer, getClass().getResource("/multimedia/imagens/button_multiplayer_entered.png"));
	                        		API.Images.setImage(btnonline, getClass().getResource("/multimedia/imagens/button_mystery_exited.png"));
	                        		API.Images.setImage(btnsingleplayer, getClass().getResource("/multimedia/imagens/button_singleplayer_exited.png"));
	                        		API.Images.setImage(btnback, getClass().getResource("/multimedia/imagens/button_back_exited.png"));
	                        		multiplayer = false;
	                        		singleplayer = true;
	                        		online = false;
	                        		selected = 2;
                        		}else {
	                        		API.Images.setImage(btnmultiplayer, getClass().getResource("/multimedia/imagens/button_multiplayer_exited.png"));
	                        		API.Images.setImage(btnonline, getClass().getResource("/multimedia/imagens/button_mystery_entered.png"));
	                        		API.Images.setImage(btnsingleplayer, getClass().getResource("/multimedia/imagens/button_singleplayer_exited.png"));
	                        		API.Images.setImage(btnback, getClass().getResource("/multimedia/imagens/button_back_exited.png"));
	                        		online = false;
	                        		singleplayer = false;
	                        		multiplayer = true;
	                        		selected = 3;
                        		}
                        	}else {
                        		API.Images.setImage(btnmultiplayer, getClass().getResource("/multimedia/imagens/button_multiplayer_exited.png"));
                        		API.Images.setImage(btnonline, getClass().getResource("/multimedia/imagens/button_mystery_entered.png"));
                        		API.Images.setImage(btnsingleplayer, getClass().getResource("/multimedia/imagens/button_singleplayer_exited.png"));
                        		API.Images.setImage(btnback, getClass().getResource("/multimedia/imagens/button_back_exited.png"));
                        		singleplayer = false;
                        		multiplayer = true;
                        		online = false;
                        		selected = 3;
                        	}
		        			
		        		}else if (ke.getKeyCode() == KeyEvent.VK_UP) {
		        			try {  API.Sounds.PlaySound("/multimedia/audios/mouse_on.wav", soundfile);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {e1.printStackTrace();}
		        			API.Images.setImage(btnsingleplayer, getClass().getResource("/multimedia/imagens/button_singleplayer_exited.png"));
		    				API.Images.setImage(btnmultiplayer, getClass().getResource("/multimedia/imagens/button_multiplayer_exited.png"));
		    				API.Images.setImage(btnback, getClass().getResource("/multimedia/imagens/button_back_entered.png"));
		    				API.Images.setImage(btnonline, getClass().getResource("/multimedia/imagens/button_mystery_exited.png"));
		    				singleplayer = false;
		            		multiplayer = false;
		            		online = false;
		    				selected = 4;
		        			
		        		}else if (ke.getKeyCode() == KeyEvent.VK_DOWN) {
		        			try {  API.Sounds.PlaySound("/multimedia/audios/mouse_on.wav", soundfile);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {e1.printStackTrace();}
		        			API.Images.setImage(btnsingleplayer, getClass().getResource("/multimedia/imagens/button_singleplayer_exited.png"));
		    				API.Images.setImage(btnmultiplayer, getClass().getResource("/multimedia/imagens/button_multiplayer_exited.png"));
		    				API.Images.setImage(btnback, getClass().getResource("/multimedia/imagens/button_back_entered.png"));
		    				API.Images.setImage(btnonline, getClass().getResource("/multimedia/imagens/button_mystery_exited.png"));
		    				singleplayer = false;
		            		multiplayer = false;
		            		online = false;
		    				selected = 4;
		        			
		        		}else if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
		        			
                    		switch (selected) {
	                  		  case 1:
	                  			try {  API.Sounds.PlaySound("/multimedia/audios/mouse_click.wav", soundfile);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {e1.printStackTrace();}
	                  			singleplgui();
	                  		    break;
	                  		  case 2:
	                  			try {  API.Sounds.PlaySound("/multimedia/audios/mouse_click.wav", soundfile);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {e1.printStackTrace();}
	                  			multiplgui();
	                  		    break;
	                  		  case 3:
	                  			try {  API.Sounds.PlaySound("/multimedia/audios/mouse_click.wav", soundfile);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {e1.printStackTrace();}
	                  			mysterygui();
	                  		    break;
	                  		  case 4:
	                  			try {  API.Sounds.PlaySound("/multimedia/audios/mouse_click.wav", soundfile);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {e1.printStackTrace();}
	                  			back();
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
			
			InputStream in = getClass().getResourceAsStream("/multimedia/audios/music.wav");
			InputStream bufferedIn = new BufferedInputStream(in);
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(bufferedIn);
			clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
			gainControl.setValue((float)(soundfile-84));
			
			if (singleop) {
				while (SinglePlayerOptions.getTimeMusic() > (34360748*count1)) {
					count++;
					count1++;
					count2 = count;
					count3 = count1;
					count4 = count;
					count5 = count1;
					count6 = count;
					count7 = count1;
				}
				clip.setMicrosecondPosition(SinglePlayerOptions.getTimeMusic() - (34360748*count));
				setSingleop(false);
			}else if (playop) {
				while (PlayOption.getTimeMusic() > (34360748*count3)) {
					count2++;
					count3++;
					count = count2;
					count1 = count3;
					count4 = count2;
					count5 = count3;
					count6 = count2;
					count7 = count3;
				}
				clip.setMicrosecondPosition(PlayOption.getTimeMusic() - (34360748*count2));
				setPlayop(false);
			}else if (mysterymode) {
				while (MysteryModeOptions.getTimeMusic() > (34360748*count7)) {
					count6++;
					count7++;
					count = count6;
					count1 = count7;
					count2 = count6;
					count3 = count7;
					count4 = count6;
					count5 = count7;
				}
				clip.setMicrosecondPosition(MysteryModeOptions.getTimeMusic() - (34360748*count6));
				setPlayop(false);
			}else {
				while (MultiPlayerOptions.getTimeMusic() > (34360748*count5)) {
					count4++;
					count5++;
					count = count4;
					count1 = count5;
					count2 = count4;
					count3 = count5;
					count6 = count4;
					count7 = count5;
				}
				clip.setMicrosecondPosition(MultiPlayerOptions.getTimeMusic() - (34360748*count4));
			}
			
			//clip.setMicrosecondPosition(Menu.getTimeMusic());
			clip.start();
			clip.loop(Clip.LOOP_CONTINUOUSLY);
			
		} catch (LineUnavailableException | UnsupportedAudioFileException | IOException e1) {
			e1.printStackTrace();
		}
		
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/multimedia/imagens/logo.png")));
		setTitle("Quatro em Linha");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowListener() {
					@Override
					public void windowOpened(WindowEvent paramWindowEvent) {
						// TODO Auto-generated method stub
						
					}
					@Override
					public void windowClosing(WindowEvent paramWindowEvent) {
						
						exit();
						
					}
					@Override
					public void windowClosed(WindowEvent paramWindowEvent) {
						// TODO Auto-generated method stub
						
					}
					@Override
					public void windowIconified(WindowEvent paramWindowEvent) {
						// TODO Auto-generated method stub
						
					}
					@Override
					public void windowDeiconified(WindowEvent paramWindowEvent) {
						// TODO Auto-generated method stub
						
					}
					@Override
					public void windowActivated(WindowEvent paramWindowEvent) {
						// TODO Auto-generated method stub
						
					}
					@Override
					public void windowDeactivated(WindowEvent paramWindowEvent) {
						// TODO Auto-generated method stub
						
					}
		});
		
		singleplayeroptionsgui = SinglePlayerOptions.getBool();
		playoptiongui = PlayOption.getBool();
		mysterymodegui = MysteryModeOptions.getBool();
		
		if(playoptiongui) {
			Point loc = PlayOption.getLoca();
			setBounds(loc.x, loc.y, widthfile, heightfile);
			PlayOption.setBool(false);
		}else if (singleplayeroptionsgui){
			Point loc1 = SinglePlayerOptions.getLoca();
			setBounds(loc1.x, loc1.y, widthfile, heightfile);
			SinglePlayerOptions.setBool(false);
		}else if (mysterymodegui){
			Point loc1 = MysteryModeOptions.getLoca();
			setBounds(loc1.x, loc1.y, widthfile, heightfile);
			MysteryModeOptions.setBool(false);
		}else {
			Point loc1 = MultiPlayerOptions.getLoca();
			setBounds(loc1.x, loc1.y, widthfile, heightfile);
			MultiPlayerOptions.setBool(false);
		}
		
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
				API.Images.setImage(btnsingleplayer, getClass().getResource("/multimedia/imagens/button_singleplayer_exited.png"));
				API.Images.setImage(btnmultiplayer, getClass().getResource("/multimedia/imagens/button_multiplayer_exited.png"));
				API.Images.setImage(btnback, getClass().getResource("/multimedia/imagens/button_back_exited.png"));
				API.Images.setImage(btnonline, getClass().getResource("/multimedia/imagens/button_mystery_exited.png"));
				singleplayer = false;
        		multiplayer = false;
        		online = false;
        		selected = 0;
			}
		});
		playoptionPanel.setBackground(SystemColor.control);
		playoptionPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		playoptionPanel.setLayout(null);
		setContentPane(playoptionPanel);
		
		btnsingleplayer = new JLabel();
		btnsingleplayer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				try {  API.Sounds.PlaySound("/multimedia/audios/mouse_on.wav", soundfile);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {e1.printStackTrace();}
				API.Images.setImage(btnsingleplayer, getClass().getResource("/multimedia/imagens/button_singleplayer_entered.png"));
				API.Images.setImage(btnmultiplayer, getClass().getResource("/multimedia/imagens/button_multiplayer_exited.png"));
				API.Images.setImage(btnback, getClass().getResource("/multimedia/imagens/button_back_exited.png"));
				API.Images.setImage(btnonline, getClass().getResource("/multimedia/imagens/button_mystery_exited.png"));
				singleplayer = true;
				selected = 2;
			}
			@Override
			public void mouseExited(MouseEvent e) {
				API.Images.setImage(btnsingleplayer, getClass().getResource("/multimedia/imagens/button_singleplayer_exited.png"));
				singleplayer = false;
				selected = 0;
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				singleplgui();
			}
		});
		btnsingleplayer.setBounds(43, 313, 296, 112);
		API.Images.setImage(btnsingleplayer, getClass().getResource("/multimedia/imagens/button_singleplayer_exited.png"));
		playoptionPanel.add(btnsingleplayer);
		
		btnmultiplayer = new JLabel();
		btnmultiplayer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				try {  API.Sounds.PlaySound("/multimedia/audios/mouse_on.wav", soundfile);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {e1.printStackTrace();}
				API.Images.setImage(btnmultiplayer, getClass().getResource("/multimedia/imagens/button_multiplayer_entered.png"));
				API.Images.setImage(btnsingleplayer, getClass().getResource("/multimedia/imagens/button_singleplayer_exited.png"));
				API.Images.setImage(btnback, getClass().getResource("/multimedia/imagens/button_back_exited.png"));
				API.Images.setImage(btnonline, getClass().getResource("/multimedia/imagens/button_mystery_exited.png"));
				multiplayer = true;
				selected = 2;
			}
			@Override
			public void mouseExited(MouseEvent e) {
				API.Images.setImage(btnmultiplayer, getClass().getResource("/multimedia/imagens/button_multiplayer_exited.png"));
				multiplayer = false;
				selected = 0;
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				multiplgui();
			}
		});
		btnmultiplayer.setBounds(363, 310, 296, 112);
		API.Images.setImage(btnmultiplayer, getClass().getResource("/multimedia/imagens/button_multiplayer_exited.png"));
		playoptionPanel.add(btnmultiplayer);
		
		btnonline = new JLabel();
		btnonline.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				try {  API.Sounds.PlaySound("/multimedia/audios/mouse_on.wav", soundfile);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {e1.printStackTrace();}
				API.Images.setImage(btnback, getClass().getResource("/multimedia/imagens/button_back_exited.png"));
				API.Images.setImage(btnsingleplayer, getClass().getResource("/multimedia/imagens/button_singleplayer_exited.png"));
				API.Images.setImage(btnmultiplayer, getClass().getResource("/multimedia/imagens/button_multiplayer_exited.png"));
				API.Images.setImage(btnonline, getClass().getResource("/multimedia/imagens/button_mystery_entered.png"));
        		online = true;
				selected = 3;
			}
			@Override
			public void mouseExited(MouseEvent e) {
				API.Images.setImage(btnonline, getClass().getResource("/multimedia/imagens/button_mystery_exited.png"));
				selected = 0;
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				mysterygui();
			}
		});
		btnonline.setBounds(671, 307, 296, 112);
		API.Images.setImage(btnonline, getClass().getResource("/multimedia/imagens/button_mystery_exited.png"));
		playoptionPanel.add(btnonline);
		
		btnback = new JLabel();
		btnback.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				try {  API.Sounds.PlaySound("/multimedia/audios/mouse_on.wav", soundfile);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {e1.printStackTrace();}
				API.Images.setImage(btnback, getClass().getResource("/multimedia/imagens/button_back_entered.png"));
				API.Images.setImage(btnsingleplayer, getClass().getResource("/multimedia/imagens/button_singleplayer_exited.png"));
				API.Images.setImage(btnmultiplayer, getClass().getResource("/multimedia/imagens/button_multiplayer_exited.png"));
				API.Images.setImage(btnonline, getClass().getResource("/multimedia/imagens/button_mystery_exited.png"));
				singleplayer = false;
        		multiplayer = false;
        		online = false;
				selected = 4;
			}
			@Override
			public void mouseExited(MouseEvent e) {
				API.Images.setImage(btnback, getClass().getResource("/multimedia/imagens/button_back_exited.png"));
				selected = 0;
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				back();
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
	
	public static void setSingleop(boolean singleop1) {
		singleop = singleop1;
	}
	
	public static void setPlayop(boolean playop1) {
		playop = playop1;
	}
	
	public static void setMysterymode(boolean mysterymode1) {
		mysterymode = mysterymode1;
	}
	
	private void singleplgui() {
		try {  API.Sounds.PlaySound("/multimedia/audios/mouse_click.wav", soundfile);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {e1.printStackTrace();}
		
		setLoca(getLocation());
		singleplayer = false;
		multiplayer = false;
		online = false;
		selected = 0;
		listening = false;
		clipTimePostion = clip.getMicrosecondPosition();
		clip.stop();
		SinglePlayerOptions frame = new SinglePlayerOptions();
		frame.setVisible(true);
		
		dispose();
	}
	
	private void multiplgui() {
		try {  API.Sounds.PlaySound("/multimedia/audios/mouse_click.wav", soundfile);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {e1.printStackTrace();}
		
		setLoca(getLocation());
		singleplayer = false;
		multiplayer = false;
		online = false;
		selected = 0;
		listening = false;
		clipTimePostion = clip.getMicrosecondPosition();
		clip.stop();
		MultiPlayerOptions frame = new MultiPlayerOptions();
		frame.setVisible(true);
		
		dispose();
	}
	
	private void mysterygui() {
		try {  API.Sounds.PlaySound("/multimedia/audios/mouse_click.wav", soundfile);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {e1.printStackTrace();}
		
		setLoca(getLocation());
		singleplayer = false;
		multiplayer = false;
		online = false;
		selected = 0;
		listening = false;
		clipTimePostion = clip.getMicrosecondPosition();
		clip.stop();
		MysteryModeOptions frame = new MysteryModeOptions();
		frame.setVisible(true);
		
		dispose();
	}
	
	private void back() {
		try {  API.Sounds.PlaySound("/multimedia/audios/mouse_click.wav", soundfile);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {e1.printStackTrace();}
		
		setLoca(getLocation());
		singleplayer = false;
		multiplayer = false;
		online = false;
		selected = 0;
		listening = false;
		clipTimePostion = clip.getMicrosecondPosition();
		clip.stop();
		PlayOption.setNewGame(true);
		frame = new PlayOption();
		frame.setVisible(true);
		
		dispose();
	}
	
	private void exit() {
		listening = false;
		PopupTwoOptions fram = new PopupTwoOptions(this, "Tem a certeza que pretende sair ?", soundfile);
		
		if(fram.run(widthfile, heightfile)) {
			System.exit(0);
		}
		listening = true;
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
	    
	    btnsingleplayer.setBounds(43, 313+((height-800)/2), 296+((width-1024)/3), 112+((height-800)/4));
	    API.Images.setImage(btnsingleplayer, getClass().getResource("/multimedia/imagens/button_singleplayer_exited.png"));
	    btnmultiplayer.setBounds(363+((width-1024)/4), 310+((height-800)/2), 296+((width-1024)/3), 112+((height-800)/4));
	    API.Images.setImage(btnmultiplayer, getClass().getResource("/multimedia/imagens/button_multiplayer_exited.png"));
	    btnonline.setBounds(671+((width-1024)/2), 307+((height-800)/2), 296+((width-1024)/3), 112+((height-800)/4));
	    API.Images.setImage(btnonline, getClass().getResource("/multimedia/imagens/button_mystery_exited.png"));
	    btnback.setBounds(354+((width-1024)/4), 566+((height-800)/2), 296+((width-1024)/3), 112+((height-800)/4));
	    API.Images.setImage(btnback, getClass().getResource("/multimedia/imagens/button_back_exited.png"));
	}

	@Override
	public void componentShown(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
