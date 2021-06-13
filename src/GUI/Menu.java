package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.Point;
import java.awt.Toolkit;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import API.Fichi;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JSlider;

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
	public int count = 0;
	public int count1 = 1;
	public int count2 = 0;
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
	
	private void aboutgui() {
		try {  API.Sounds.PlaySound("/multimedia/audios/mouse_click.wav", soundfile);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {e1.printStackTrace();}
		
		listening = false;
		PopupAbout dialog = new PopupAbout(this, soundfile);
		dialog.run(widthfile, heightfile);
		listening = true;
	}
	
	private void rulesgui() {
		try {  API.Sounds.PlaySound("/multimedia/audios/mouse_click.wav", soundfile);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {e1.printStackTrace();}
		
		listening = false;
		PopupRules dialog = new PopupRules(this, soundfile);
		dialog.run(widthfile, heightfile);
		listening = true;
	}
	
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
	
	private void exit() {
		listening = false;
		PopupTwoOptions fram = new PopupTwoOptions(this, "Tem a certeza que pretende sair ?", soundfile);
		
		if(fram.run(widthfile, heightfile)) {
			System.exit(0);
		}
		listening = true;
    }
	
	public void setLoca(Point loc) {
		this.loc = loc;
	}
	
	public static Point getLoca() {
		return loc;
	}
	
	public static long getTimeMusic() {
		return clipTimePostion;
	}
	
	public static void setOption(boolean option1) {
		option = option1;
	}
	
	public static void setPlayop(boolean playop1) {
		playop = playop1;
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
	    
	    label_play.setBounds(350+((width-1024)/4), 340+((height-800)/3), 296+((width-1024)/2), 112+((height-800)/6));
	    API.Images.setImage(label_play, getClass().getResource("/multimedia/imagens/button_play_exited.png"));
	    label_options.setBounds(350+((width-1024)/4), (int)(442+((height-800)/2.5)), 296+((width-1024)/2), 112+((height-800)/6));
	    API.Images.setImage(label_options, getClass().getResource("/multimedia/imagens/button_options_exited.png"));
	    label_exit.setBounds(350+((width-1024)/4), 544+((height-800)/2), 296+((width-1024)/2), 112+((height-800)/6));
	    API.Images.setImage(label_exit, getClass().getResource("/multimedia/imagens/button_exit_exited.png"));
	    label_logo.setBounds(396+((width-1024)/4), 131+((height-800)/6), 204+((width-1024)/2), 204+((height-800)/6));
	    API.Images.setImage(label_logo, getClass().getResource("/multimedia/imagens/logoHD_transparent.png"));
	}

	@Override
	public void componentShown(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
