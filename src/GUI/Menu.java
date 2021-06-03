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
import java.io.File;
import java.io.IOException;
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
	
	private Clip clip;
	private JPanel contentPane;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private boolean play;
	private boolean options;
	private boolean exit;
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
	                        	
	                        	if(play) {
	                        		if(selected == 2) {
	                        			API.Images.setImage(label_1, getClass().getResource("/multimedia/imagens/button_options_exited.png"));
		                        		API.Images.setImage(label_2, getClass().getResource("/multimedia/imagens/button_exit_entered.png"));
		                        		API.Images.setImage(label, getClass().getResource("/multimedia/imagens/button_play_exited.png"));
		                        		options = false;
		                        		play = false;
		                        		exit = true;
		                        		selected = 3;
	                        		}else {
		                        		API.Images.setImage(label_1, getClass().getResource("/multimedia/imagens/button_options_entered.png"));
		                        		API.Images.setImage(label_2, getClass().getResource("/multimedia/imagens/button_exit_exited.png"));
		                        		API.Images.setImage(label, getClass().getResource("/multimedia/imagens/button_play_exited.png"));
		                        		play = false;
		                        		options = true;
		                        		exit = false;
		                        		selected = 2;
	                        		}
	                        	}else if (options) {
	                        		if(selected == 3) {
	                        			API.Images.setImage(label_1, getClass().getResource("/multimedia/imagens/button_options_exited.png"));
		                        		API.Images.setImage(label_2, getClass().getResource("/multimedia/imagens/button_exit_exited.png"));
		                        		API.Images.setImage(label, getClass().getResource("/multimedia/imagens/button_play_entered.png"));
		                        		play = true;
		                        		options = false;
		                        		exit = false;
		                        		selected = 1;
	                        		}else {
		                        		API.Images.setImage(label_1, getClass().getResource("/multimedia/imagens/button_options_exited.png"));
		                        		API.Images.setImage(label_2, getClass().getResource("/multimedia/imagens/button_exit_entered.png"));
		                        		API.Images.setImage(label, getClass().getResource("/multimedia/imagens/button_play_exited.png"));
		                        		options = false;
		                        		play = false;
		                        		exit = true;
		                        		selected = 3;
		                        	}
	                        	}else if (exit) {
	                        		if (selected == 1) {
	                        			API.Images.setImage(label_1, getClass().getResource("/multimedia/imagens/button_options_entered.png"));
		                        		API.Images.setImage(label_2, getClass().getResource("/multimedia/imagens/button_exit_exited.png"));
		                        		API.Images.setImage(label, getClass().getResource("/multimedia/imagens/button_play_exited.png"));
		                        		options = true;
		                        		play = false;
		                        		exit = false;
		                        		selected = 2;
	                        		}else {
		                        		API.Images.setImage(label_1, getClass().getResource("/multimedia/imagens/button_options_exited.png"));
		                        		API.Images.setImage(label_2, getClass().getResource("/multimedia/imagens/button_exit_exited.png"));
		                        		API.Images.setImage(label, getClass().getResource("/multimedia/imagens/button_play_entered.png"));
		                        		exit = false;
		                        		play = true;
		                        		options = false;
		                        		selected = 1;
	                        		}
	                        	}else {
	                        		API.Images.setImage(label_1, getClass().getResource("/multimedia/imagens/button_options_exited.png"));
	                        		API.Images.setImage(label_2, getClass().getResource("/multimedia/imagens/button_exit_exited.png"));
	                        		API.Images.setImage(label, getClass().getResource("/multimedia/imagens/button_play_entered.png"));
	                        		play = true;
	                        		options = false;
	                        		exit = false;
	                        		selected = 1;
	                        	}
	                        	
	                        }else if (ke.getKeyCode() == KeyEvent.VK_UP) {
	
	                        	if(play) {
	                        		if (selected == 1) {
	                        			API.Images.setImage(label_1, getClass().getResource("/multimedia/imagens/button_options_exited.png"));
		                        		API.Images.setImage(label_2, getClass().getResource("/multimedia/imagens/button_exit_entered.png"));
		                        		API.Images.setImage(label, getClass().getResource("/multimedia/imagens/button_play_exited.png"));
		                        		options = false;
		                        		play = false;
		                        		exit = true;
		                        		selected = 3;
	                        		}else {
		                        		API.Images.setImage(label_1, getClass().getResource("/multimedia/imagens/button_options_exited.png"));
		                        		API.Images.setImage(label_2, getClass().getResource("/multimedia/imagens/button_exit_exited.png"));
		                        		API.Images.setImage(label, getClass().getResource("/multimedia/imagens/button_play_entered.png"));
		                        		play = false;
		                        		options = false;
		                        		exit = true;
		                        		selected = 1;
	                        		}
	                        	}else if (options) {
	                        		if (selected == 2) {
	                        			API.Images.setImage(label_1, getClass().getResource("/multimedia/imagens/button_options_exited.png"));
		                        		API.Images.setImage(label_2, getClass().getResource("/multimedia/imagens/button_exit_exited.png"));
		                        		API.Images.setImage(label, getClass().getResource("/multimedia/imagens/button_play_entered.png"));
		                        		play = false;
		                        		options = false;
		                        		exit = true;
		                        		selected = 1;
	                        		}else {
		                        		API.Images.setImage(label_1, getClass().getResource("/multimedia/imagens/button_options_entered.png"));
		                        		API.Images.setImage(label_2, getClass().getResource("/multimedia/imagens/button_exit_exited.png"));
		                        		API.Images.setImage(label, getClass().getResource("/multimedia/imagens/button_play_exited.png"));
		                        		options = false;
		                        		play = true;
		                        		exit = false;
		                        		selected = 2;
	                        		}
	                        	}else if (exit) {
	                        		if (selected == 3) {
	                        			API.Images.setImage(label_1, getClass().getResource("/multimedia/imagens/button_options_entered.png"));
		                        		API.Images.setImage(label_2, getClass().getResource("/multimedia/imagens/button_exit_exited.png"));
		                        		API.Images.setImage(label, getClass().getResource("/multimedia/imagens/button_play_exited.png"));
		                        		options = false;
		                        		play = true;
		                        		exit = false;
		                        		selected = 2;
	                        		}else {
		                        		API.Images.setImage(label_1, getClass().getResource("/multimedia/imagens/button_options_exited.png"));
		                        		API.Images.setImage(label_2, getClass().getResource("/multimedia/imagens/button_exit_entered.png"));
		                        		API.Images.setImage(label, getClass().getResource("/multimedia/imagens/button_play_exited.png"));
		                        		exit = false;
		                        		play = false;
		                        		options = true;
		                        		selected = 3;
	                        		}
	                        	}else {
	                        		API.Images.setImage(label_1, getClass().getResource("/multimedia/imagens/button_options_exited.png"));
	                        		API.Images.setImage(label_2, getClass().getResource("/multimedia/imagens/button_exit_entered.png"));
	                        		API.Images.setImage(label, getClass().getResource("/multimedia/imagens/button_play_exited.png"));
	                        		play = false;
	                        		options = true;
	                        		exit = false;
	                        		selected = 3;
	                        	}
	                        	
	                        }else if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
	                    		switch (selected) {
		                  		  case 1:
		                  		    System.out.println("Monday");
		                  		    break;
		                  		  case 2:
		                  		    System.out.println("Tuesday");
		                  		    break;
		                  		  case 3:
		                  		    exit();
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
			
			if(option) {
				if (Options.getTimeMusic() > (34360748*count1)) {
					count++;
					count1++;
					count2 = count;
					count3 = count1;
				}
				clip.setMicrosecondPosition(Options.getTimeMusic() - (34360748*count));
				setOption(false);
			}
			
			if(playop) {
				if (PlayOption.getTimeMusic() > (34360748*count3)) {
					count2++;
					count3++;
					count = count2;
					count1 = count3;
				}
				clip.setMicrosecondPosition(PlayOption.getTimeMusic() - (34360748*count2));
				setPlayop(false);
			}
				
			//clip.setMicrosecondPosition(Options.getTimeMusic());
			clip.start();
			clip.loop(Clip.LOOP_CONTINUOUSLY);
				
		} catch (LineUnavailableException | UnsupportedAudioFileException | IOException e1) {
			e1.printStackTrace();
		}
		
		
		
		Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/multimedia/imagens/logo.png")));
		setTitle("Quatro em Linha");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
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
				API.Images.setImage(label_1, getClass().getResource("/multimedia/imagens/button_options_exited.png"));
				API.Images.setImage(label_2, getClass().getResource("/multimedia/imagens/button_exit_exited.png"));
        		API.Images.setImage(label, getClass().getResource("/multimedia/imagens/button_play_exited.png"));
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
		
		label = new JLabel();
		
		label.setBounds(350, 340, 296, 112);
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				API.Images.setImage(label_1, getClass().getResource("/multimedia/imagens/button_options_exited.png"));
				API.Images.setImage(label, getClass().getResource("/multimedia/imagens/button_play_entered.png"));
				API.Images.setImage(label_2, getClass().getResource("/multimedia/imagens/button_exit_exited.png"));
				play = true;
				selected = 2;
			}
			@Override
			public void mouseExited(MouseEvent e) {
				API.Images.setImage(label, getClass().getResource("/multimedia/imagens/button_play_exited.png"));
				play = false;
				selected = 0;
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				setLoca(getLocation());
				play = false;
				options = false;
				exit = false;
				selected = 0;
				listening = false;
				clipTimePostion = clip.getMicrosecondPosition();
				clip.stop();
				PlayOption frame = new PlayOption();
				frame.setVisible(true);
				
				dispose();
			}
		});
		API.Images.setImage(label, getClass().getResource("/multimedia/imagens/button_play_exited.png"));
		contentPane.add(label);
		
		label_1 = new JLabel();
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				API.Images.setImage(label_1, getClass().getResource("/multimedia/imagens/button_options_entered.png"));
				API.Images.setImage(label, getClass().getResource("/multimedia/imagens/button_play_exited.png"));
				API.Images.setImage(label_2, getClass().getResource("/multimedia/imagens/button_exit_exited.png"));
				options = true;
				selected = 2;
			}
			@Override
			public void mouseExited(MouseEvent e) {
				API.Images.setImage(label_1, getClass().getResource("/multimedia/imagens/button_options_exited.png"));
				options = false;
				selected = 0;
			}
			@Override
			public void mouseClicked(MouseEvent e) {
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
		});
		label_1.setBounds(350, 442, 296, 112);
		API.Images.setImage(label_1, getClass().getResource("/multimedia/imagens/button_options_exited.png"));
		contentPane.add(label_1);
		
		label_2 = new JLabel();
		label_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				API.Images.setImage(label_2, getClass().getResource("/multimedia/imagens/button_exit_entered.png"));
				API.Images.setImage(label, getClass().getResource("/multimedia/imagens/button_play_exited.png"));
				API.Images.setImage(label_1, getClass().getResource("/multimedia/imagens/button_options_exited.png"));
				exit = true;
				selected = 3;
			}
			@Override
			public void mouseExited(MouseEvent e) {
				API.Images.setImage(label_2, getClass().getResource("/multimedia/imagens/button_exit_exited.png"));
				exit = false;
				selected = 0;
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				exit();
			}
		});
		label_2.setBounds(350, 544, 296, 112);
		API.Images.setImage(label_2, getClass().getResource("/multimedia/imagens/button_exit_exited.png"));
		contentPane.add(label_2);
		
		label_3 = new JLabel();
		label_3.setBounds(396, 131, 204, 204);
		API.Images.setImage(label_3, getClass().getResource("/multimedia/imagens/logoHD_transparent.png"));
		contentPane.add(label_3);
		
		getContentPane().addComponentListener(this);
		
	}
	
	private void playoptioGui() {
		
    }
	
	private void optionGui() {
		
    }
	
	private void exit() {
		listening = false;
		Popup fram = new Popup(this, "Tem a certeza que pretende sair ?");
		
		if(fram.run(1024, 800)) {
			dispose();
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
	    
	    label.setBounds(350+((width-1024)/4), 340+((height-800)/3), 296+((width-1024)/2), 112+((height-800)/6));
	    API.Images.setImage(label, getClass().getResource("/multimedia/imagens/button_play_exited.png"));
	    label_1.setBounds(350+((width-1024)/4), (int)(442+((height-800)/2.5)), 296+((width-1024)/2), 112+((height-800)/6));
	    API.Images.setImage(label_1, getClass().getResource("/multimedia/imagens/button_options_exited.png"));
	    label_2.setBounds(350+((width-1024)/4), 544+((height-800)/2), 296+((width-1024)/2), 112+((height-800)/6));
	    API.Images.setImage(label_2, getClass().getResource("/multimedia/imagens/button_exit_exited.png"));
	    label_3.setBounds(396+((width-1024)/4), 131+((height-800)/6), 204+((width-1024)/2), 204+((height-800)/6));
	    API.Images.setImage(label_3, getClass().getResource("/multimedia/imagens/logoHD_transparent.png"));
	}

	@Override
	public void componentShown(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
