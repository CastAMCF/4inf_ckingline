package GUI;

import java.awt.Dimension;
import java.awt.EventQueue;
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
 * Cria o JFrame "Menu" e inicializa o mesmo(é o único JFrame q tem o método main)
 * @author Asus
 */
public class Menu extends JFrame implements ComponentListener {
	
	private Menu frame;
	private Clip clip;
	private JPanel contentPane;
	private JLabel label_play;
	private JLabel label_options;
	private JLabel label_exit;
	private JLabel label_logo;
	private JLabel label_rules;
	private JLabel label_about;
	private boolean play;
	private boolean options;
	private boolean exit;
	private boolean opcao;
	private int selected;
	private boolean listening = true;
	private static Point loc;
	private int widthfile = 0;
	private int heightfile = 0;
	private int soundfile = 0;
	private boolean optionsgui = false;
	private boolean playoptiongui = false;
	private static long clipTimePostion;
        /**Variável usada para diminuir o tempo da música*/
	public int count = 0;
        /**Variável usada para diminuir o tempo da música*/
	public int count1 = 1;
        /**Variável usada para diminuir o tempo da música*/
	public int count2 = 0;
        /**Variável usada para diminuir o tempo da música*/
	public int count3 = 1;
	private static boolean option = false;
	private static boolean playop = false;
	private boolean playf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Menu() {
		
		KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {

            @Override
            public boolean dispatchKeyEvent(KeyEvent ke) { 
            		if (listening) {
	                    switch (ke.getID()) {
	                    case KeyEvent.KEY_PRESSED:
	                        if (ke.getKeyCode() == KeyEvent.VK_DOWN) {
	                        	
	                        	try {  API.Sounds.PlaySound("/multimedia/audios/mouse_on.wav", soundfile);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {e.printStackTrace();}
	                        	if(play) {
	                        		if(selected == 2) {
	                        			API.Images.setImage(label_options, getClass().getResource("/multimedia/imagens/button_options_exited.png"));
		                        		API.Images.setImage(label_exit, getClass().getResource("/multimedia/imagens/button_exit_entered.png"));
		                        		API.Images.setImage(label_play, getClass().getResource("/multimedia/imagens/button_play_exited.png"));
		                        		API.Images.setImage(label_rules, getClass().getResource("/multimedia/imagens/button_rules_exited.png"));
		                				API.Images.setImage(label_about, getClass().getResource("/multimedia/imagens/button_about_exited.png"));
		                        		options = false;
		                        		play = false;
		                        		exit = true;
		                        		selected = 3;
	                        		}else {
		                        		API.Images.setImage(label_options, getClass().getResource("/multimedia/imagens/button_options_entered.png"));
		                        		API.Images.setImage(label_exit, getClass().getResource("/multimedia/imagens/button_exit_exited.png"));
		                        		API.Images.setImage(label_play, getClass().getResource("/multimedia/imagens/button_play_exited.png"));
		                        		API.Images.setImage(label_rules, getClass().getResource("/multimedia/imagens/button_rules_exited.png"));
		                				API.Images.setImage(label_about, getClass().getResource("/multimedia/imagens/button_about_exited.png"));
		                        		play = false;
		                        		options = true;
		                        		exit = false;
		                        		selected = 2;
	                        		}
	                        	}else if (options) {
	                        		if(selected == 3) {
	                        			API.Images.setImage(label_options, getClass().getResource("/multimedia/imagens/button_options_exited.png"));
		                        		API.Images.setImage(label_exit, getClass().getResource("/multimedia/imagens/button_exit_exited.png"));
		                        		API.Images.setImage(label_play, getClass().getResource("/multimedia/imagens/button_play_entered.png"));
		                        		API.Images.setImage(label_rules, getClass().getResource("/multimedia/imagens/button_rules_exited.png"));
		                				API.Images.setImage(label_about, getClass().getResource("/multimedia/imagens/button_about_exited.png"));
		                        		play = true;
		                        		options = false;
		                        		exit = false;
		                        		selected = 1;
	                        		}else {
		                        		API.Images.setImage(label_options, getClass().getResource("/multimedia/imagens/button_options_exited.png"));
		                        		API.Images.setImage(label_exit, getClass().getResource("/multimedia/imagens/button_exit_entered.png"));
		                        		API.Images.setImage(label_play, getClass().getResource("/multimedia/imagens/button_play_exited.png"));
		                        		API.Images.setImage(label_rules, getClass().getResource("/multimedia/imagens/button_rules_exited.png"));
		                				API.Images.setImage(label_about, getClass().getResource("/multimedia/imagens/button_about_exited.png"));
		                        		options = false;
		                        		play = false;
		                        		exit = true;
		                        		selected = 3;
		                        	}
	                        	}else if (exit) {
	                        		if (selected == 1) {
	                        			API.Images.setImage(label_options, getClass().getResource("/multimedia/imagens/button_options_entered.png"));
		                        		API.Images.setImage(label_exit, getClass().getResource("/multimedia/imagens/button_exit_exited.png"));
		                        		API.Images.setImage(label_play, getClass().getResource("/multimedia/imagens/button_play_exited.png"));
		                        		API.Images.setImage(label_rules, getClass().getResource("/multimedia/imagens/button_rules_exited.png"));
		                				API.Images.setImage(label_about, getClass().getResource("/multimedia/imagens/button_about_exited.png"));
		                        		options = true;
		                        		play = false;
		                        		exit = false;
		                        		selected = 2;
	                        		}else {
		                        		API.Images.setImage(label_options, getClass().getResource("/multimedia/imagens/button_options_exited.png"));
		                        		API.Images.setImage(label_exit, getClass().getResource("/multimedia/imagens/button_exit_exited.png"));
		                        		API.Images.setImage(label_play, getClass().getResource("/multimedia/imagens/button_play_entered.png"));
		                        		API.Images.setImage(label_rules, getClass().getResource("/multimedia/imagens/button_rules_exited.png"));
		                				API.Images.setImage(label_about, getClass().getResource("/multimedia/imagens/button_about_exited.png"));
		                        		exit = false;
		                        		play = true;
		                        		options = false;
		                        		selected = 1;
	                        		}
	                        	}else {
	                        		API.Images.setImage(label_options, getClass().getResource("/multimedia/imagens/button_options_exited.png"));
	                        		API.Images.setImage(label_exit, getClass().getResource("/multimedia/imagens/button_exit_exited.png"));
	                        		API.Images.setImage(label_play, getClass().getResource("/multimedia/imagens/button_play_entered.png"));
	                        		API.Images.setImage(label_rules, getClass().getResource("/multimedia/imagens/button_rules_exited.png"));
	                				API.Images.setImage(label_about, getClass().getResource("/multimedia/imagens/button_about_exited.png"));
	                        		play = true;
	                        		options = false;
	                        		exit = false;
	                        		selected = 1;
	                        	}
	                        	
	                        }else if (ke.getKeyCode() == KeyEvent.VK_UP) {
	                        	
	                        	try {  API.Sounds.PlaySound("/multimedia/audios/mouse_on.wav", soundfile);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {e.printStackTrace();}
	                        	if(play) {
	                        		if (selected == 1) {
	                        			API.Images.setImage(label_options, getClass().getResource("/multimedia/imagens/button_options_exited.png"));
		                        		API.Images.setImage(label_exit, getClass().getResource("/multimedia/imagens/button_exit_entered.png"));
		                        		API.Images.setImage(label_play, getClass().getResource("/multimedia/imagens/button_play_exited.png"));
		                        		API.Images.setImage(label_rules, getClass().getResource("/multimedia/imagens/button_rules_exited.png"));
		                				API.Images.setImage(label_about, getClass().getResource("/multimedia/imagens/button_about_exited.png"));
		                        		options = false;
		                        		play = false;
		                        		exit = true;
		                        		selected = 3;
	                        		}else {
		                        		API.Images.setImage(label_options, getClass().getResource("/multimedia/imagens/button_options_exited.png"));
		                        		API.Images.setImage(label_exit, getClass().getResource("/multimedia/imagens/button_exit_exited.png"));
		                        		API.Images.setImage(label_play, getClass().getResource("/multimedia/imagens/button_play_entered.png"));
		                        		API.Images.setImage(label_rules, getClass().getResource("/multimedia/imagens/button_rules_exited.png"));
		                				API.Images.setImage(label_about, getClass().getResource("/multimedia/imagens/button_about_exited.png"));
		                        		play = false;
		                        		options = false;
		                        		exit = true;
		                        		selected = 1;
	                        		}
	                        	}else if (options) {
	                        		if (selected == 2) {
	                        			API.Images.setImage(label_options, getClass().getResource("/multimedia/imagens/button_options_exited.png"));
		                        		API.Images.setImage(label_exit, getClass().getResource("/multimedia/imagens/button_exit_exited.png"));
		                        		API.Images.setImage(label_play, getClass().getResource("/multimedia/imagens/button_play_entered.png"));
		                        		API.Images.setImage(label_rules, getClass().getResource("/multimedia/imagens/button_rules_exited.png"));
		                				API.Images.setImage(label_about, getClass().getResource("/multimedia/imagens/button_about_exited.png"));
		                        		play = false;
		                        		options = false;
		                        		exit = true;
		                        		selected = 1;
	                        		}else {
		                        		API.Images.setImage(label_options, getClass().getResource("/multimedia/imagens/button_options_entered.png"));
		                        		API.Images.setImage(label_exit, getClass().getResource("/multimedia/imagens/button_exit_exited.png"));
		                        		API.Images.setImage(label_play, getClass().getResource("/multimedia/imagens/button_play_exited.png"));
		                        		API.Images.setImage(label_rules, getClass().getResource("/multimedia/imagens/button_rules_exited.png"));
		                				API.Images.setImage(label_about, getClass().getResource("/multimedia/imagens/button_about_exited.png"));
		                        		options = false;
		                        		play = true;
		                        		exit = false;
		                        		selected = 2;
	                        		}
	                        	}else if (exit) {
	                        		if (selected == 3) {
	                        			API.Images.setImage(label_options, getClass().getResource("/multimedia/imagens/button_options_entered.png"));
		                        		API.Images.setImage(label_exit, getClass().getResource("/multimedia/imagens/button_exit_exited.png"));
		                        		API.Images.setImage(label_play, getClass().getResource("/multimedia/imagens/button_play_exited.png"));
		                        		API.Images.setImage(label_rules, getClass().getResource("/multimedia/imagens/button_rules_exited.png"));
		                				API.Images.setImage(label_about, getClass().getResource("/multimedia/imagens/button_about_exited.png"));
		                        		options = false;
		                        		play = true;
		                        		exit = false;
		                        		selected = 2;
	                        		}else {
		                        		API.Images.setImage(label_options, getClass().getResource("/multimedia/imagens/button_options_exited.png"));
		                        		API.Images.setImage(label_exit, getClass().getResource("/multimedia/imagens/button_exit_entered.png"));
		                        		API.Images.setImage(label_play, getClass().getResource("/multimedia/imagens/button_play_exited.png"));
		                        		API.Images.setImage(label_rules, getClass().getResource("/multimedia/imagens/button_rules_exited.png"));
		                				API.Images.setImage(label_about, getClass().getResource("/multimedia/imagens/button_about_exited.png"));
		                        		exit = false;
		                        		play = false;
		                        		options = true;
		                        		selected = 3;
	                        		}
	                        	}else {
	                        		API.Images.setImage(label_options, getClass().getResource("/multimedia/imagens/button_options_exited.png"));
	                        		API.Images.setImage(label_exit, getClass().getResource("/multimedia/imagens/button_exit_entered.png"));
	                        		API.Images.setImage(label_play, getClass().getResource("/multimedia/imagens/button_play_exited.png"));
	                        		API.Images.setImage(label_rules, getClass().getResource("/multimedia/imagens/button_rules_exited.png"));
	                				API.Images.setImage(label_about, getClass().getResource("/multimedia/imagens/button_about_exited.png"));
	                        		play = false;
	                        		options = true;
	                        		exit = false;
	                        		selected = 3;
	                        	}
	                        	
	                        }else if (ke.getKeyCode() == KeyEvent.VK_RIGHT) {
			        			
			        			try {  API.Sounds.PlaySound("/multimedia/audios/mouse_on.wav", soundfile);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {e.printStackTrace();}
			        			if(opcao) {API.Images.setImage(label_options, getClass().getResource("/multimedia/imagens/button_options_exited.png"));
	                        		API.Images.setImage(label_exit, getClass().getResource("/multimedia/imagens/button_exit_exited.png"));
	                        		API.Images.setImage(label_play, getClass().getResource("/multimedia/imagens/button_play_exited.png"));
	                        		API.Images.setImage(label_rules, getClass().getResource("/multimedia/imagens/button_rules_exited.png"));
	                				API.Images.setImage(label_about, getClass().getResource("/multimedia/imagens/button_about_entered.png"));
				        			opcao = false;
				        			selected = 5;
			        			}else {API.Images.setImage(label_options, getClass().getResource("/multimedia/imagens/button_options_exited.png"));
	                        		API.Images.setImage(label_exit, getClass().getResource("/multimedia/imagens/button_exit_exited.png"));
	                        		API.Images.setImage(label_play, getClass().getResource("/multimedia/imagens/button_play_exited.png"));
	                        		API.Images.setImage(label_rules, getClass().getResource("/multimedia/imagens/button_rules_entered.png"));
	                				API.Images.setImage(label_about, getClass().getResource("/multimedia/imagens/button_about_exited.png"));
				        			opcao = true;
				        			selected = 4;
			        			}
			        			
			        		}else if (ke.getKeyCode() == KeyEvent.VK_LEFT) {
			        			
			        			try {  API.Sounds.PlaySound("/multimedia/audios/mouse_on.wav", soundfile);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {e.printStackTrace();}
			        			if(opcao) {API.Images.setImage(label_options, getClass().getResource("/multimedia/imagens/button_options_exited.png"));
	                        		API.Images.setImage(label_exit, getClass().getResource("/multimedia/imagens/button_exit_exited.png"));
	                        		API.Images.setImage(label_play, getClass().getResource("/multimedia/imagens/button_play_exited.png"));
	                        		API.Images.setImage(label_rules, getClass().getResource("/multimedia/imagens/button_rules_exited.png"));
	                				API.Images.setImage(label_about, getClass().getResource("/multimedia/imagens/button_about_entered.png"));
				        			opcao = false;
				        			selected = 5;
			        			}else {API.Images.setImage(label_options, getClass().getResource("/multimedia/imagens/button_options_exited.png"));
	                        		API.Images.setImage(label_exit, getClass().getResource("/multimedia/imagens/button_exit_exited.png"));
	                        		API.Images.setImage(label_play, getClass().getResource("/multimedia/imagens/button_play_exited.png"));
	                        		API.Images.setImage(label_rules, getClass().getResource("/multimedia/imagens/button_rules_entered.png"));
	                				API.Images.setImage(label_about, getClass().getResource("/multimedia/imagens/button_about_exited.png"));
				        			opcao = true;
				        			selected = 4;
			        			}
			        			
			        		}else if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
			        			
	                    		switch (selected) {
		                  		  case 1:
		                  			try {  API.Sounds.PlaySound("/multimedia/audios/mouse_click.wav", soundfile);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {e.printStackTrace();}
		                  		    playoptionsgui();
		                  		    break;
		                  		  case 2:
		                  			try {  API.Sounds.PlaySound("/multimedia/audios/mouse_click.wav", soundfile);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {e.printStackTrace();}
		                  		    optionsgui();
		                  		    break;
		                  		  case 3:
		                  			try {  API.Sounds.PlaySound("/multimedia/audios/mouse_click.wav", soundfile);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {e.printStackTrace();}
		                  		    exit();
		                  		    break;
		                  		  case 4:
		                  			try {  API.Sounds.PlaySound("/multimedia/audios/mouse_click.wav", soundfile);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {e.printStackTrace();}
		                  			rulesgui();
		                  			break;
		                  		  case 5:
		                  			try {  API.Sounds.PlaySound("/multimedia/audios/mouse_click.wav", soundfile);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {e.printStackTrace();}
		                  			aboutgui();
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
		
		playf = true;
		try {
			if (option) {
				
				InputStream in = getClass().getResourceAsStream("/multimedia/audios/music.wav");
				InputStream bufferedIn = new BufferedInputStream(in);
				AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(bufferedIn);
				clip = AudioSystem.getClip();
				clip.open(audioInputStream);
				FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
				gainControl.setValue((float)(soundfile-84));
				
				while (Options.getTimeMusic() > (34360748*count1)) {
					count++;
					count1++;
					count2 = count;
					count3 = count1;
				}
				clip.setMicrosecondPosition(Options.getTimeMusic() - (34360748*count));
				setOption(false);
				
				clip.start();
				clip.loop(Clip.LOOP_CONTINUOUSLY);
				playf = false;
			}
			
			if (playop) {
				
				InputStream in = getClass().getResourceAsStream("/multimedia/audios/music.wav");
				InputStream bufferedIn = new BufferedInputStream(in);
				AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(bufferedIn);
				clip = AudioSystem.getClip();
				clip.open(audioInputStream);
				FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
				gainControl.setValue((float)(soundfile-84));
				
				while (PlayOption.getTimeMusic() > (34360748*count3)) {
					count2++;
					count3++;
					count = count2;
					count1 = count3;
				}
				clip.setMicrosecondPosition(PlayOption.getTimeMusic() - (34360748*count2));
				setPlayop(false);
				
				clip.start();
				clip.loop(Clip.LOOP_CONTINUOUSLY);
				playf = false;
			}
				
		} catch (LineUnavailableException | UnsupportedAudioFileException | IOException e1) {
			e1.printStackTrace();
		}
		
		
		Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
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
		
		
		optionsgui = Options.getBool();
		playoptiongui = PlayOption.getBool();
		
		if(playoptiongui) {
			Point loc = PlayOption.getLoca();
			setBounds(loc.x, loc.y, widthfile, heightfile);
			PlayOption.setBool(false);
		}else if (optionsgui){
			Point loc1 = Options.getLoca();
			setBounds(loc1.x, loc1.y, widthfile, heightfile);
			Options.setBool(false);
		}else {
			setBounds((int)(size.getWidth()/2)-(widthfile/2), (int)(size.getHeight()/2)-(heightfile/2), widthfile, heightfile);
		}
		
		setResizable(false);
		
		contentPane = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
            	super.paintComponent(g);
                ImageIcon img = new ImageIcon(getClass().getResource("/multimedia/imagens/background_menu.png"));
                g.drawImage(img.getImage(), 0, 0, this.getWidth(), this.getHeight(), null);
            }
        };
        contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				API.Images.setImage(label_options, getClass().getResource("/multimedia/imagens/button_options_exited.png"));
				API.Images.setImage(label_exit, getClass().getResource("/multimedia/imagens/button_exit_exited.png"));
        		API.Images.setImage(label_play, getClass().getResource("/multimedia/imagens/button_play_exited.png"));
        		API.Images.setImage(label_rules, getClass().getResource("/multimedia/imagens/button_rules_exited.png"));
				API.Images.setImage(label_about, getClass().getResource("/multimedia/imagens/button_about_exited.png"));
        		play = false;
        		options = false;
        		exit = false;
        		selected = 0;
			}
		});
		contentPane.setBackground(SystemColor.control);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		label_play = new JLabel();
		
		label_play.setBounds(350, 340, 296, 112);
		label_play.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				try {  API.Sounds.PlaySound("/multimedia/audios/mouse_on.wav", soundfile);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {e.printStackTrace();}
				API.Images.setImage(label_options, getClass().getResource("/multimedia/imagens/button_options_exited.png"));
				API.Images.setImage(label_play, getClass().getResource("/multimedia/imagens/button_play_entered.png"));
				API.Images.setImage(label_exit, getClass().getResource("/multimedia/imagens/button_exit_exited.png"));
				API.Images.setImage(label_rules, getClass().getResource("/multimedia/imagens/button_rules_exited.png"));
				API.Images.setImage(label_about, getClass().getResource("/multimedia/imagens/button_about_exited.png"));
				play = true;
				selected = 2;
			}
			@Override
			public void mouseExited(MouseEvent e) {
				API.Images.setImage(label_play, getClass().getResource("/multimedia/imagens/button_play_exited.png"));
				play = false;
				selected = 0;
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				playoptionsgui();
			}
		});
		
		label_logo = new JLabel();
		label_logo.setBounds(396, 131, 204, 204);
		API.Images.setImage(label_logo, getClass().getResource("/multimedia/imagens/logoHD_transparent.png"));
		contentPane.add(label_logo);
		API.Images.setImage(label_play, getClass().getResource("/multimedia/imagens/button_play_exited.png"));
		contentPane.add(label_play);
		
		label_options = new JLabel();
		label_options.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				try {  API.Sounds.PlaySound("/multimedia/audios/mouse_on.wav", soundfile);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {e.printStackTrace();}
				API.Images.setImage(label_options, getClass().getResource("/multimedia/imagens/button_options_entered.png"));
				API.Images.setImage(label_play, getClass().getResource("/multimedia/imagens/button_play_exited.png"));
				API.Images.setImage(label_exit, getClass().getResource("/multimedia/imagens/button_exit_exited.png"));
				API.Images.setImage(label_rules, getClass().getResource("/multimedia/imagens/button_rules_exited.png"));
				API.Images.setImage(label_about, getClass().getResource("/multimedia/imagens/button_about_exited.png"));
				options = true;
				selected = 2;
			}
			@Override
			public void mouseExited(MouseEvent e) {
				API.Images.setImage(label_options, getClass().getResource("/multimedia/imagens/button_options_exited.png"));
				options = false;
				selected = 0;
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				optionsgui();
			}
		});
		label_options.setBounds(350, 442, 296, 112);
		API.Images.setImage(label_options, getClass().getResource("/multimedia/imagens/button_options_exited.png"));
		contentPane.add(label_options);
		
		label_exit = new JLabel();
		label_exit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				try {  API.Sounds.PlaySound("/multimedia/audios/mouse_on.wav", soundfile);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {e.printStackTrace();}
				API.Images.setImage(label_exit, getClass().getResource("/multimedia/imagens/button_exit_entered.png"));
				API.Images.setImage(label_play, getClass().getResource("/multimedia/imagens/button_play_exited.png"));
				API.Images.setImage(label_options, getClass().getResource("/multimedia/imagens/button_options_exited.png"));
				API.Images.setImage(label_rules, getClass().getResource("/multimedia/imagens/button_rules_exited.png"));
				API.Images.setImage(label_about, getClass().getResource("/multimedia/imagens/button_about_exited.png"));
				exit = true;
				selected = 3;
			}
			@Override
			public void mouseExited(MouseEvent e) {
				API.Images.setImage(label_exit, getClass().getResource("/multimedia/imagens/button_exit_exited.png"));
				exit = false;
				selected = 0;
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				try {  API.Sounds.PlaySound("/multimedia/audios/mouse_click.wav", soundfile);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {e1.printStackTrace();}
				exit();
			}
		});
		label_exit.setBounds(350, 544, 296, 112);
		API.Images.setImage(label_exit, getClass().getResource("/multimedia/imagens/button_exit_exited.png"));
		contentPane.add(label_exit);
		
		label_rules = new JLabel();
		label_rules.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				try {  API.Sounds.PlaySound("/multimedia/audios/mouse_on.wav", soundfile);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {e.printStackTrace();}
				API.Images.setImage(label_exit, getClass().getResource("/multimedia/imagens/button_exit_exited.png"));
				API.Images.setImage(label_play, getClass().getResource("/multimedia/imagens/button_play_exited.png"));
				API.Images.setImage(label_options, getClass().getResource("/multimedia/imagens/button_options_exited.png"));
				API.Images.setImage(label_rules, getClass().getResource("/multimedia/imagens/button_rules_entered.png"));
				API.Images.setImage(label_about, getClass().getResource("/multimedia/imagens/button_about_exited.png"));
				opcao = true;
				selected = 4;
			}
			@Override
			public void mouseExited(MouseEvent e) {
				API.Images.setImage(label_rules, getClass().getResource("/multimedia/imagens/button_rules_exited.png"));
				exit = false;
				selected = 0;
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				rulesgui();
			}
		});
		label_rules.setBounds(496, 661, 236, 92);
		API.Images.setImage(label_rules, getClass().getResource("/multimedia/imagens/button_rules_exited.png"));
		contentPane.add(label_rules);
		
		label_about = new JLabel();
		label_about.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				try {  API.Sounds.PlaySound("/multimedia/audios/mouse_on.wav", soundfile);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {e.printStackTrace();}
				API.Images.setImage(label_exit, getClass().getResource("/multimedia/imagens/button_exit_exited.png"));
				API.Images.setImage(label_play, getClass().getResource("/multimedia/imagens/button_play_exited.png"));
				API.Images.setImage(label_options, getClass().getResource("/multimedia/imagens/button_options_exited.png"));
				API.Images.setImage(label_rules, getClass().getResource("/multimedia/imagens/button_rules_exited.png"));
				API.Images.setImage(label_about, getClass().getResource("/multimedia/imagens/button_about_entered.png"));
				selected = 5;
			}
			@Override
			public void mouseExited(MouseEvent e) {
				API.Images.setImage(label_about, getClass().getResource("/multimedia/imagens/button_about_exited.png"));
				exit = false;
				selected = 0;
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				aboutgui();
			}
		});
		label_about.setBounds(744, 661, 236, 92);
		API.Images.setImage(label_about, getClass().getResource("/multimedia/imagens/button_about_exited.png"));
		contentPane.add(label_about);
		
		
		if(playf) {
			
			try {
				InputStream in = getClass().getResourceAsStream("/multimedia/audios/music.wav");
				InputStream bufferedIn = new BufferedInputStream(in);
				AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(bufferedIn);
				clip = AudioSystem.getClip();
				clip.open(audioInputStream);
				FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
				gainControl.setValue((float)(soundfile-84));
				
				clip.start();
				clip.loop(Clip.LOOP_CONTINUOUSLY);
					
			} catch (LineUnavailableException | UnsupportedAudioFileException | IOException e1) {
				e1.printStackTrace();
			}
			
		}
		
		getContentPane().addComponentListener(this);
		
	}
	
        /**
         * Deixa de "ouvir" as teclas deste JFrame
         * Inicializa o JDialog "PopupAbout" e é apresentado com o mesmo
         * Volta "ouvir" as teclas deste JFrame
         */
	private void aboutgui() {
		try {  API.Sounds.PlaySound("/multimedia/audios/mouse_click.wav", soundfile);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {e1.printStackTrace();}
		
		listening = false;
		PopupAbout dialog = new PopupAbout(this, soundfile);
		dialog.run(widthfile, heightfile);
		listening = true;
	}
	
        /**
         * Deixa de "ouvir" as teclas deste JFrame
         * Inicializa o JDialog "PopupRules" e é apresentado com o mesmo
         * Volta "ouvir" as teclas deste JFrame
         */
	private void rulesgui() {
		try {  API.Sounds.PlaySound("/multimedia/audios/mouse_click.wav", soundfile);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {e1.printStackTrace();}
		
		listening = false;
		PopupRules dialog = new PopupRules(this, soundfile);
		dialog.run(widthfile, heightfile);
		listening = true;
	}
	
        /**
         * Deixa de "ouvir" as teclas deste JFrame
         * Inicializa o JFrame "PlayOption" e é apresentado com o mesmo
         * Fecha este JFrame
         */
	private void playoptionsgui() {
		try {  API.Sounds.PlaySound("/multimedia/audios/mouse_click.wav", soundfile);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {e1.printStackTrace();}
		setLoca(getLocation());
		play = false;
		options = false;
		exit = false;
		selected = 0;
		listening = false;
		clipTimePostion = clip.getMicrosecondPosition();
		clip.stop();
		PlayOption.setMenu(true);
		PlayOption frame = new PlayOption();
		frame.setVisible(true);
		
		dispose();
	}
	
        /**
         * Deixa de "ouvir" as teclas deste JFrame
         * Inicializa o JFrame "Options" e é apresentado com o mesmo
         * Fecha este JFrame
         */
	private void optionsgui() {
		try {  API.Sounds.PlaySound("/multimedia/audios/mouse_click.wav", soundfile);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {e1.printStackTrace();}
		setLoca(getLocation());
		play = false;
		options = false;
		exit = false;
		selected = 0;
		listening = false;
		clipTimePostion = clip.getMicrosecondPosition();
		clip.stop();
		Options frame = new Options();
		frame.setVisible(true);
		
		dispose();
	}
	
        /**
         * Deixa de "ouvir" as teclas deste JFrame
         * Inicializa o JDialog "PopupTwoOptions" e é apresentado com o mesmo
         * Se sim fecha este JFrame
         * Se não fecha apenas o JDialog
         * Volta "ouvir" as teclas deste JFrame
         */
	private void exit() {
		listening = false;
		PopupTwoOptions fram = new PopupTwoOptions(this, "Tem a certeza que pretende sair ?", soundfile);
		
		if(fram.run(widthfile, heightfile)) {
			System.exit(0);
		}
		listening = true;
    }
	
        /**
         * Define a localização deste JFrame 
         */
	public void setLoca(Point loc) {
		this.loc = loc;
	}
	
        /**
         * Recebe a localização deste JFrame 
         */
	public static Point getLoca() {
		return loc;
	}
	
        /**
         * Recebe o tempo onde a música parou neste JFrame 
         */
	public static long getTimeMusic() {
		return clipTimePostion;
	}
	
        /**
         * Define se o JFrame "Options" foi aberto
         */
	public static void setOption(boolean option1) {
		option = option1;
	}
	
        /**
         * Define se o JFrame "PlayOptions" foi aberto
         */
	public static void setPlayop(boolean playop1) {
		playop = playop1;
	}
        
        /**
         * Esta classe é defenida mas não é usada
         */
	@Override
	public void componentHidden(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		
	}
        
        /**
         * Esta classe é defenida mas não é usada
         */
	@Override
	public void componentMoved(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		
	}
        
        /**
         * Verifica se o tamanho do JFrame foi alterado se sim vai mudar as posições e em alguns casos aumentar o tamanho dos componetes referidos
         */
	@Override
	public void componentResized(ComponentEvent arg0) {
		int height = this.getHeight();
	    int width = this.getWidth();
	    
	    label_play.setBounds(350+((width-1024)/4), 340+((height-800)/3), 296+((width-1024)/2), 112+((height-800)/6));
	    API.Images.setImage(label_play, getClass().getResource("/multimedia/imagens/button_play_exited.png"));
	    label_options.setBounds(350+((width-1024)/4), (int)(442+((height-800)/2.5)), 296+((width-1024)/2), 112+((height-800)/6));
	    API.Images.setImage(label_options, getClass().getResource("/multimedia/imagens/button_options_exited.png"));
	    label_exit.setBounds(350+((width-1024)/4), 544+((height-800)/2), 296+((width-1024)/2), 112+((height-800)/6));
	    API.Images.setImage(label_exit, getClass().getResource("/multimedia/imagens/button_exit_exited.png"));
	    label_logo.setBounds(396+((width-1024)/4), 131+((height-800)/6), 204+((width-1024)/2), 204+((height-800)/6));
	    API.Images.setImage(label_logo, getClass().getResource("/multimedia/imagens/logoHD_transparent.png"));
	    label_rules.setBounds(496+((width-1024)/4), (int)(661+((height-800)/1.5)), 236+((width-1024)/2), 92+((height-800)/4));
	    API.Images.setImage(label_rules, getClass().getResource("/multimedia/imagens/button_rules_exited.png"));
	    label_about.setBounds((int)(744+((width-1024)/1.6)), (int)(661+((height-800)/1.5)), 236+((width-1024)/2), 92+((height-800)/4));
	    API.Images.setImage(label_about, getClass().getResource("/multimedia/imagens/button_about_exited.png"));
	}
        
        /**
         * Esta classe é defenida mas n é usada
         */
	@Override
	public void componentShown(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
