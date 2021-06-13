package GUI;

import java.awt.Color;
import java.awt.Font;
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
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import API.FILException;
import API.Fichi;

public class SinglePlayerOptions extends JFrame implements ComponentListener {
	
	private Clip clip;
	private NewGameOptions frame;
	private JPanel contentPane;
	private JLabel btnbegin;
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
	private boolean opcao;
	private JLabel ballimage_1;
	private JLabel ballimage_2;
	private JLabel ballimage_3;
	private JLabel ballimage_4;
	private JLabel difbot_2;
	private JLabel difbot_3;
	private JLabel difbot_4;
	private JLabel setadir_1;
	private JLabel setaesq_1;
	private JLabel placeholder_1;
	private JLabel setadir_2;
	private JLabel setaesq_2;
	private JLabel setaesqdif_2;
	private JLabel setadirdif_2;
	private JLabel placeholder_2;
	private JLabel setadir_3;
	private JLabel setaesq_3;
	private JLabel setaesqdif_3;
	private JLabel setadirdif_3;
	private JLabel placeholder_3;
	private JLabel setadir_4;
	private JLabel setaesq_4;
	private JLabel setaesqdif_4;
	private JLabel setadirdif_4;
	private JLabel placeholder_4;
	private JLabel placeholder_lines;
	private JLabel setaesq_numlines;
	private JLabel setadir_numlines;
	private JLabel placeholder_columns;
	private JLabel setaesq_numcolumns;
	private JLabel setadir_numcolumns;
	private JLabel placeholder_pecheck;
	private JLabel setaesq_numpecheck;
	private JLabel setadir_numpecheck;
	private JLabel setaesqnumbot;
	private JLabel setadirnumbot;
	private JTextField txtJogador_1;
	private JTextField txtJogador_2;
	private JTextField txtJogador_3;
	private JTextField txtJogador_4;
	private JLabel numerolines;
	private JLabel numerocolumns;
	private JLabel numeropecheck;
	private JLabel numerobot;
	private int ballimagenum1 = 1;
	private int ballimagenum2 = 2;
	private int ballimagenum3 = 3;
	private int ballimagenum4 = 4;
	private String[] botconfigtxt = {"Fácil", "Normal", "Médio", "Difícil"};
	private int botconfigint2 = 0;
	private int botconfigint3 = 0;
	private int botconfigint4 = 0;
	private int numlines = 6;
	private int numcolumns = 7;
	private int numcheck = 4;
	private int numbots = 1;

	public SinglePlayerOptions() {
		bool = true;
		
		KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {

			@Override
	        public boolean dispatchKeyEvent(KeyEvent ke) { 
	        	if(listening) {
		        	switch (ke.getID()) {
		        	case KeyEvent.KEY_PRESSED:
		        		if (ke.getKeyCode() == KeyEvent.VK_RIGHT) {
		        			try {  API.Sounds.PlaySound("/multimedia/audios/mouse_on.wav", soundfile);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {e.printStackTrace();}
		        			if(opcao) {
		        				API.Images.setImage(btnbegin, getClass().getResource("/multimedia/imagens/button_begin_exited.png"));
		        				API.Images.setImage(btnback, getClass().getResource("/multimedia/imagens/button_back_entered.png"));
			        			opcao = false;
			        			selected = 2;
		        			}else {
		        				API.Images.setImage(btnbegin, getClass().getResource("/multimedia/imagens/button_begin_entered.png"));
			        			API.Images.setImage(btnback, getClass().getResource("/multimedia/imagens/button_back_exited.png"));
			        			opcao = true;
			        			selected = 1;
		        			}
		        			
		        		}else if (ke.getKeyCode() == KeyEvent.VK_LEFT) {
		        			try {  API.Sounds.PlaySound("/multimedia/audios/mouse_on.wav", soundfile);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {e.printStackTrace();}
		        			if(opcao) {
		        				API.Images.setImage(btnbegin, getClass().getResource("/multimedia/imagens/button_begin_exited.png"));
		        				API.Images.setImage(btnback, getClass().getResource("/multimedia/imagens/button_back_entered.png"));
			        			opcao = false;
			        			selected = 2;
		        			}else {
		        				API.Images.setImage(btnbegin, getClass().getResource("/multimedia/imagens/button_begin_entered.png"));
			        			API.Images.setImage(btnback, getClass().getResource("/multimedia/imagens/button_back_exited.png"));
			        			opcao = true;
			        			selected = 1;
		        			}
		        			
		        		}else if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
		        			
                    		switch (selected) {
	                  		  case 1:
	                  			try {  API.Sounds.PlaySound("/multimedia/audios/mouse_click.wav", soundfile);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {e1.printStackTrace();}
	                  			begin();
	                  		    break;
	                  		  case 2:
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
		
		boolean begingamebot = BeginGameBot.getBool();
		
		try {
			
			InputStream in = getClass().getResourceAsStream("/multimedia/audios/music.wav");
			InputStream bufferedIn = new BufferedInputStream(in);
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(bufferedIn);
			clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
			gainControl.setValue((float)(soundfile-84));
			
			if(begingamebot) {
				while (BeginGameBot.getTimeMusic() > (34360748*count1)) {
					count++;
					count1++;
					count2 = count;
					count3 = count1;
				}
				clip.setMicrosecondPosition(BeginGameBot.getTimeMusic() - (34360748*count));
			}else {
				while (NewGameOptions.getTimeMusic() > (34360748*count3)) {
					count2++;
					count3++;
					count = count2;
					count1 = count3;
				}
				clip.setMicrosecondPosition(NewGameOptions.getTimeMusic() - (34360748*count2));
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
		
		if(begingamebot) {
			Point loc = BeginGameBot.getLoca();
			setBounds(loc.x, loc.y, widthfile, heightfile);
			begingamebot = false;
		}else {
			Point loc = NewGameOptions.getLoca();
			setBounds(loc.x, loc.y, widthfile, heightfile);
		}
		
		
		setResizable(false);
		
		contentPane = new JPanel(){
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
				API.Images.setImage(btnbegin, getClass().getResource("/multimedia/imagens/button_begin_exited.png"));
				API.Images.setImage(btnback, getClass().getResource("/multimedia/imagens/button_back_exited.png"));
				opcao = false;
        		selected = 0;
			}
		});
		contentPane.setBackground(SystemColor.control);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		btnbegin = new JLabel();
		btnbegin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				try {  API.Sounds.PlaySound("/multimedia/audios/mouse_on.wav", soundfile);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {e.printStackTrace();}
				API.Images.setImage(btnbegin, getClass().getResource("/multimedia/imagens/button_begin_entered.png"));
				API.Images.setImage(btnback, getClass().getResource("/multimedia/imagens/button_back_exited.png"));
				
				selected = 2;
			}
			@Override
			public void mouseExited(MouseEvent e) {
				API.Images.setImage(btnbegin, getClass().getResource("/multimedia/imagens/button_begin_exited.png"));
				
				selected = 0;
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				begin();
			}
		});
		btnbegin.setBounds(520, 626, 296, 112);
		API.Images.setImage(btnbegin, getClass().getResource("/multimedia/imagens/button_begin_exited.png"));
		contentPane.add(btnbegin);
		
		btnback = new JLabel();
		btnback.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				try {  API.Sounds.PlaySound("/multimedia/audios/mouse_on.wav", soundfile);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {e.printStackTrace();}
				API.Images.setImage(btnback, getClass().getResource("/multimedia/imagens/button_back_entered.png"));
				API.Images.setImage(btnbegin, getClass().getResource("/multimedia/imagens/button_begin_exited.png"));
				
				selected = 1;
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
		btnback.setBounds(48, 626, 296, 112);
		API.Images.setImage(btnback, getClass().getResource("/multimedia/imagens/button_back_exited.png"));
		contentPane.add(btnback);
		
		//------------------------------------------------------------------------------------------------------------
		//----------------------------------------------- Jogador 1 --------------------------------------------------
		//------------------------------------------------------------------------------------------------------------
		setadir_1 = new JLabel();
		setadir_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				try {  API.Sounds.PlaySound("/multimedia/audios/mouse_on.wav", soundfile);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {e.printStackTrace();}
				API.Images.setImage(setadir_1, getClass().getResource("/multimedia/imagens/right_arrow_entered.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				API.Images.setImage(setadir_1, getClass().getResource("/multimedia/imagens/right_arrow_exited.png"));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				try {  API.Sounds.PlaySound("/multimedia/audios/mouse_click.wav", soundfile);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {e1.printStackTrace();}
				ballimagenum1++;
            	if(ballimagenum1 > 28)
            		ballimagenum1 = 1;
            	
            	API.Images.setImage(ballimage_1, getClass().getResource("/multimedia/imagens/ball" + ballimagenum1 + ".png"));
				
			}
		});
		setadir_1.setBounds(621, 63, 62, 62);
		API.Images.setImage(setadir_1, getClass().getResource("/multimedia/imagens/right_arrow_exited.png"));
		contentPane.add(setadir_1);
		
		ballimage_1 = new JLabel();
		ballimage_1.setBounds(491, 39, 110, 110);
		API.Images.setImage(ballimage_1, getClass().getResource("/multimedia/imagens/ball" + ballimagenum1 + ".png"));
		contentPane.add(ballimage_1);
		
		setaesq_1 = new JLabel();
		setaesq_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				try {  API.Sounds.PlaySound("/multimedia/audios/mouse_on.wav", soundfile);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {e.printStackTrace();}
				API.Images.setImage(setaesq_1, getClass().getResource("/multimedia/imagens/left_arrow_entered.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				API.Images.setImage(setaesq_1, getClass().getResource("/multimedia/imagens/left_arrow_exited.png"));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				try {  API.Sounds.PlaySound("/multimedia/audios/mouse_click.wav", soundfile);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {e1.printStackTrace();}
				ballimagenum1--;
        		if(ballimagenum1 < 1)
        			ballimagenum1 = 28;
            	
            	API.Images.setImage(ballimage_1, getClass().getResource("/multimedia/imagens/ball" + ballimagenum1 + ".png"));
				
			}
		});
		setaesq_1.setBounds(409, 63, 62, 62);
		API.Images.setImage(setaesq_1, getClass().getResource("/multimedia/imagens/left_arrow_exited.png"));
		contentPane.add(setaesq_1);
		
		txtJogador_1 = new JTextField("Jogador 1", SwingConstants.CENTER);
		txtJogador_1.setHorizontalAlignment(JTextField.CENTER);
		txtJogador_1.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		txtJogador_1.setOpaque(false);
		txtJogador_1.setForeground(Color.decode("#FF8B3E"));
		txtJogador_1.setFont(Fonts.Crackman.Normal(35));
		txtJogador_1.setBounds(440, 237, 210, 43);
		contentPane.add(txtJogador_1);
		txtJogador_1.setColumns(10);
		
		placeholder_1 = new JLabel();
		placeholder_1.setBounds(409, 221, 274, 72);
		API.Images.setImage(placeholder_1, getClass().getResource("/multimedia/imagens/placeholder_depth.png"));
		contentPane.add(placeholder_1);
		
		//------------------------------------------------------------------------------------------------------------
		//----------------------------------------------- Jogador 2 --------------------------------------------------
		//------------------------------------------------------------------------------------------------------------
		setadir_2 = new JLabel();
		setadir_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				try {  API.Sounds.PlaySound("/multimedia/audios/mouse_on.wav", soundfile);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {e.printStackTrace();}
				API.Images.setImage(setadir_2, getClass().getResource("/multimedia/imagens/right_arrow_entered.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				API.Images.setImage(setadir_2, getClass().getResource("/multimedia/imagens/right_arrow_exited.png"));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				try {  API.Sounds.PlaySound("/multimedia/audios/mouse_click.wav", soundfile);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {e1.printStackTrace();}
				ballimagenum2++;
            	if(ballimagenum2 > 28)
            		ballimagenum2 = 1;
            	
            	API.Images.setImage(ballimage_2, getClass().getResource("/multimedia/imagens/ball" + ballimagenum2 + ".png"));
				
			}
		});
		setadir_2.setBounds(933, 63, 62, 62);
		API.Images.setImage(setadir_2, getClass().getResource("/multimedia/imagens/right_arrow_exited.png"));
		contentPane.add(setadir_2);
		
		ballimage_2 = new JLabel();
		ballimage_2.setBounds(803, 39, 110, 110);
		API.Images.setImage(ballimage_2, getClass().getResource("/multimedia/imagens/ball" + ballimagenum2 + ".png"));
		contentPane.add(ballimage_2);
		
		setaesq_2 = new JLabel();
		setaesq_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				try {  API.Sounds.PlaySound("/multimedia/audios/mouse_on.wav", soundfile);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {e.printStackTrace();}
				API.Images.setImage(setaesq_2, getClass().getResource("/multimedia/imagens/left_arrow_entered.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				API.Images.setImage(setaesq_2, getClass().getResource("/multimedia/imagens/left_arrow_exited.png"));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				try {  API.Sounds.PlaySound("/multimedia/audios/mouse_click.wav", soundfile);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {e1.printStackTrace();}
				ballimagenum2--;
        		if(ballimagenum2 < 1)
        			ballimagenum2 = 28;
            	
            	API.Images.setImage(ballimage_2, getClass().getResource("/multimedia/imagens/ball" + ballimagenum2 + ".png"));
				
			}
		});
		setaesq_2.setBounds(721, 63, 62, 62);
		API.Images.setImage(setaesq_2, getClass().getResource("/multimedia/imagens/left_arrow_exited.png"));
		contentPane.add(setaesq_2);
		
		setaesqdif_2 = new JLabel();
		setaesqdif_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				try {  API.Sounds.PlaySound("/multimedia/audios/mouse_on.wav", soundfile);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {e.printStackTrace();}
				API.Images.setImage(setaesqdif_2, getClass().getResource("/multimedia/imagens/left_arrow_entered.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				API.Images.setImage(setaesqdif_2, getClass().getResource("/multimedia/imagens/left_arrow_exited.png"));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				try {  API.Sounds.PlaySound("/multimedia/audios/mouse_click.wav", soundfile);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {e1.printStackTrace();}
				botconfigint2--;
        		if(botconfigint2 < 0)
        			botconfigint2 = 3;
        		
        		difbot_2.setText(botconfigtxt[botconfigint2]);
				
			}
		});
		setaesqdif_2.setBounds(721, 154, 62, 62);
		API.Images.setImage(setaesqdif_2, getClass().getResource("/multimedia/imagens/left_arrow_exited.png"));
		contentPane.add(setaesqdif_2);
		
		difbot_2 = new JLabel(botconfigtxt[botconfigint2], SwingConstants.CENTER);
		difbot_2.setForeground(Color.decode("#601825"));
		difbot_2.setFont(Fonts.Crackman.Normal(35));
		difbot_2.setBounds(783, 149, 150, 72);
		contentPane.add(difbot_2);
		
		setadirdif_2 = new JLabel();
		setadirdif_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				try {  API.Sounds.PlaySound("/multimedia/audios/mouse_on.wav", soundfile);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {e.printStackTrace();}
				API.Images.setImage(setadirdif_2, getClass().getResource("/multimedia/imagens/right_arrow_entered.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				API.Images.setImage(setadirdif_2, getClass().getResource("/multimedia/imagens/right_arrow_exited.png"));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				try {  API.Sounds.PlaySound("/multimedia/audios/mouse_click.wav", soundfile);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {e1.printStackTrace();}
				botconfigint2++;
            	if(botconfigint2 > 3)
            		botconfigint2 = 0;
            	
            	difbot_2.setText(botconfigtxt[botconfigint2]);
				
			}
		});
		setadirdif_2.setBounds(933, 154, 62, 62);
		API.Images.setImage(setadirdif_2, getClass().getResource("/multimedia/imagens/right_arrow_exited.png"));
		contentPane.add(setadirdif_2);
		
		txtJogador_2 = new JTextField("Jogador 2", 10);
		txtJogador_2.setHorizontalAlignment(JTextField.CENTER);
		txtJogador_2.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		txtJogador_2.setOpaque(false);
		txtJogador_2.setForeground(Color.decode("#FF8B3E"));
		txtJogador_2.setFont(new Font("CrackMan", Font.PLAIN, 35));
		txtJogador_2.setBounds(752, 237, 210, 43);
		contentPane.add(txtJogador_2);
		
		placeholder_2 = new JLabel();
		placeholder_2.setBounds(721, 221, 274, 72);
		API.Images.setImage(placeholder_2, getClass().getResource("/multimedia/imagens/placeholder_depth.png"));
		contentPane.add(placeholder_2);
		
		//------------------------------------------------------------------------------------------------------------
		//----------------------------------------------- Jogador 3 --------------------------------------------------
		//------------------------------------------------------------------------------------------------------------
		setadir_3 = new JLabel();
		setadir_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				try {  API.Sounds.PlaySound("/multimedia/audios/mouse_on.wav", soundfile);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {e.printStackTrace();}
				API.Images.setImage(setadir_3, getClass().getResource("/multimedia/imagens/right_arrow_entered.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				API.Images.setImage(setadir_3, getClass().getResource("/multimedia/imagens/right_arrow_exited.png"));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				try {  API.Sounds.PlaySound("/multimedia/audios/mouse_click.wav", soundfile);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {e1.printStackTrace();}
				ballimagenum3++;
            	if(ballimagenum3 > 28)
            		ballimagenum3 = 1;
            	
            	API.Images.setImage(ballimage_3, getClass().getResource("/multimedia/imagens/ball" + ballimagenum3 + ".png"));
				
			}
		});
		setadir_3.setBounds(621, 371, 62, 62);
		API.Images.setImage(setadir_3, getClass().getResource("/multimedia/imagens/right_arrow_exited.png"));
		contentPane.add(setadir_3);
		
		ballimage_3 = new JLabel();
		ballimage_3.setBounds(491, 347, 110, 110);
		API.Images.setImage(ballimage_3, getClass().getResource("/multimedia/imagens/ball" + ballimagenum3 + ".png"));
		contentPane.add(ballimage_3);
		
		setaesq_3 = new JLabel();
		setaesq_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				try {  API.Sounds.PlaySound("/multimedia/audios/mouse_on.wav", soundfile);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {e.printStackTrace();}
				API.Images.setImage(setaesq_3, getClass().getResource("/multimedia/imagens/left_arrow_entered.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				API.Images.setImage(setaesq_3, getClass().getResource("/multimedia/imagens/left_arrow_exited.png"));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				try {  API.Sounds.PlaySound("/multimedia/audios/mouse_click.wav", soundfile);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {e1.printStackTrace();}
				ballimagenum3--;
        		if(ballimagenum3 < 1)
        			ballimagenum3 = 28;
            	
            	API.Images.setImage(ballimage_3, getClass().getResource("/multimedia/imagens/ball" + ballimagenum3 + ".png"));
				
			}
		});
		setaesq_3.setBounds(409, 371, 62, 62);
		API.Images.setImage(setaesq_3, getClass().getResource("/multimedia/imagens/left_arrow_exited.png"));
		contentPane.add(setaesq_3);
		
		setaesqdif_3 = new JLabel();
		setaesqdif_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				try {  API.Sounds.PlaySound("/multimedia/audios/mouse_on.wav", soundfile);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {e.printStackTrace();}
				API.Images.setImage(setaesqdif_3, getClass().getResource("/multimedia/imagens/left_arrow_entered.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				API.Images.setImage(setaesqdif_3, getClass().getResource("/multimedia/imagens/left_arrow_exited.png"));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				try {  API.Sounds.PlaySound("/multimedia/audios/mouse_click.wav", soundfile);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {e1.printStackTrace();}
				botconfigint3--;
        		if(botconfigint3 < 0)
        			botconfigint3 = 3;
        		
        		difbot_3.setText(botconfigtxt[botconfigint3]);
				
			}
		});
		setaesqdif_3.setBounds(409, 462, 62, 62);
		API.Images.setImage(setaesqdif_3, getClass().getResource("/multimedia/imagens/left_arrow_exited.png"));
		contentPane.add(setaesqdif_3);
		
		difbot_3 = new JLabel(botconfigtxt[botconfigint3], SwingConstants.CENTER);
		difbot_3.setForeground(new Color(96, 24, 37));
		difbot_3.setFont(new Font("CrackMan", Font.PLAIN, 35));
		difbot_3.setBounds(471, 457, 150, 72);
		contentPane.add(difbot_3);
		
		setadirdif_3 = new JLabel();
		setadirdif_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				try {  API.Sounds.PlaySound("/multimedia/audios/mouse_on.wav", soundfile);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {e.printStackTrace();}
				API.Images.setImage(setadirdif_3, getClass().getResource("/multimedia/imagens/right_arrow_entered.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				API.Images.setImage(setadirdif_3, getClass().getResource("/multimedia/imagens/right_arrow_exited.png"));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				try {  API.Sounds.PlaySound("/multimedia/audios/mouse_click.wav", soundfile);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {e1.printStackTrace();}
				botconfigint3++;
            	if(botconfigint3 > 3)
            		botconfigint3 = 0;
            	
            	difbot_3.setText(botconfigtxt[botconfigint3]);
				
			}
		});
		setadirdif_3.setBounds(621, 462, 62, 62);
		API.Images.setImage(setadirdif_3, getClass().getResource("/multimedia/imagens/right_arrow_exited.png"));
		contentPane.add(setadirdif_3);
		
		txtJogador_3 = new JTextField("Jogador 3", 10);
		txtJogador_3.setHorizontalAlignment(JTextField.CENTER);
		txtJogador_3.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		txtJogador_3.setOpaque(false);
		txtJogador_3.setForeground(Color.decode("#FF8B3E"));
		txtJogador_3.setFont(new Font("CrackMan", Font.PLAIN, 35));
		txtJogador_3.setBounds(440, 545, 210, 43);
		contentPane.add(txtJogador_3);
		
		placeholder_3 = new JLabel();
		placeholder_3.setBounds(409, 529, 274, 72);
		API.Images.setImage(placeholder_3, getClass().getResource("/multimedia/imagens/placeholder_depth.png"));
		contentPane.add(placeholder_3);
		
		//------------------------------------------------------------------------------------------------------------
		//----------------------------------------------- Jogador 4 --------------------------------------------------
		//------------------------------------------------------------------------------------------------------------
		setadir_4 = new JLabel();
		setadir_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				try {  API.Sounds.PlaySound("/multimedia/audios/mouse_on.wav", soundfile);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {e.printStackTrace();}
				API.Images.setImage(setadir_4, getClass().getResource("/multimedia/imagens/right_arrow_entered.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				API.Images.setImage(setadir_4, getClass().getResource("/multimedia/imagens/right_arrow_exited.png"));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				try {  API.Sounds.PlaySound("/multimedia/audios/mouse_click.wav", soundfile);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {e1.printStackTrace();}
				ballimagenum4++;
            	if(ballimagenum4 > 28)
            		ballimagenum4 = 1;
            	
            	API.Images.setImage(ballimage_4, getClass().getResource("/multimedia/imagens/ball" + ballimagenum4 + ".png"));
				
			}
		});
		setadir_4.setBounds(933, 371, 62, 62);
		API.Images.setImage(setadir_4, getClass().getResource("/multimedia/imagens/right_arrow_exited.png"));
		contentPane.add(setadir_4);
		
		ballimage_4 = new JLabel();
		ballimage_4.setBounds(803, 347, 110, 110);
		API.Images.setImage(ballimage_4, getClass().getResource("/multimedia/imagens/ball" + ballimagenum4 + ".png"));
		contentPane.add(ballimage_4);
		
		setaesq_4 = new JLabel();
		setaesq_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				try {  API.Sounds.PlaySound("/multimedia/audios/mouse_on.wav", soundfile);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {e.printStackTrace();}
				API.Images.setImage(setaesq_4, getClass().getResource("/multimedia/imagens/left_arrow_entered.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				API.Images.setImage(setaesq_4, getClass().getResource("/multimedia/imagens/left_arrow_exited.png"));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				try {  API.Sounds.PlaySound("/multimedia/audios/mouse_click.wav", soundfile);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {e1.printStackTrace();}
				ballimagenum4--;
        		if(ballimagenum4 < 1)
        			ballimagenum4 = 28;
            	
            	API.Images.setImage(ballimage_4, getClass().getResource("/multimedia/imagens/ball" + ballimagenum4 + ".png"));
				
			}
		});
		setaesq_4.setBounds(721, 371, 62, 62);
		API.Images.setImage(setaesq_4, getClass().getResource("/multimedia/imagens/left_arrow_exited.png"));
		contentPane.add(setaesq_4);
		
		setaesqdif_4 = new JLabel();
		setaesqdif_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				try {  API.Sounds.PlaySound("/multimedia/audios/mouse_on.wav", soundfile);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {e.printStackTrace();}
				API.Images.setImage(setaesqdif_4, getClass().getResource("/multimedia/imagens/left_arrow_entered.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				API.Images.setImage(setaesqdif_4, getClass().getResource("/multimedia/imagens/left_arrow_exited.png"));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				try {  API.Sounds.PlaySound("/multimedia/audios/mouse_click.wav", soundfile);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {e1.printStackTrace();}
				botconfigint4--;
        		if(botconfigint4 < 0)
        			botconfigint4 = 3;
        		
        		difbot_4.setText(botconfigtxt[botconfigint4]);
				
			}
		});
		setaesqdif_4.setBounds(721, 462, 62, 62);
		API.Images.setImage(setaesqdif_4, getClass().getResource("/multimedia/imagens/left_arrow_exited.png"));
		contentPane.add(setaesqdif_4);
		
		difbot_4 = new JLabel(botconfigtxt[botconfigint4], SwingConstants.CENTER);
		difbot_4.setForeground(new Color(96, 24, 37));
		difbot_4.setFont(new Font("CrackMan", Font.PLAIN, 35));
		difbot_4.setBounds(783, 457, 150, 72);
		contentPane.add(difbot_4);
		
		setadirdif_4 = new JLabel();
		setadirdif_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				try {  API.Sounds.PlaySound("/multimedia/audios/mouse_on.wav", soundfile);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {e.printStackTrace();}
				API.Images.setImage(setadirdif_4, getClass().getResource("/multimedia/imagens/right_arrow_entered.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				API.Images.setImage(setadirdif_4, getClass().getResource("/multimedia/imagens/right_arrow_exited.png"));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				try {  API.Sounds.PlaySound("/multimedia/audios/mouse_click.wav", soundfile);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {e1.printStackTrace();}
				botconfigint4++;
            	if(botconfigint4 > 3)
            		botconfigint4 = 0;
            	
            	difbot_4.setText(botconfigtxt[botconfigint4]);
				
			}
		});
		setadirdif_4.setBounds(933, 462, 62, 62);
		API.Images.setImage(setadirdif_4, getClass().getResource("/multimedia/imagens/right_arrow_exited.png"));
		contentPane.add(setadirdif_4);
		
		txtJogador_4 = new JTextField("Jogador 4", 10);
		txtJogador_4.setHorizontalAlignment(JTextField.CENTER);
		txtJogador_4.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		txtJogador_4.setOpaque(false);
		txtJogador_4.setForeground(Color.decode("#FF8B3E"));
		txtJogador_4.setFont(new Font("CrackMan", Font.PLAIN, 35));
		txtJogador_4.setBounds(752, 545, 210, 43);
		contentPane.add(txtJogador_4);
		
		placeholder_4 = new JLabel();
		placeholder_4.setBounds(721, 529, 274, 72);
		API.Images.setImage(placeholder_4, getClass().getResource("/multimedia/imagens/placeholder_depth.png"));
		contentPane.add(placeholder_4);
		//------------------------------------------------------------------------------------------------------------
		//------------------------------------------------------------------------------------------------------------
		//------------------------------------------------------------------------------------------------------------
		
		placeholder_lines = new JLabel();
		placeholder_lines.setBounds(41, 138, 274, 83);
		API.Images.setImage(placeholder_lines, getClass().getResource("/multimedia/imagens/placeholder_lines.png"));
		contentPane.add(placeholder_lines);
		
		setaesq_numlines = new JLabel();
		setaesq_numlines.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				try {  API.Sounds.PlaySound("/multimedia/audios/mouse_on.wav", soundfile);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {e.printStackTrace();}
				API.Images.setImage(setaesq_numlines, getClass().getResource("/multimedia/imagens/left_arrow_entered.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				API.Images.setImage(setaesq_numlines, getClass().getResource("/multimedia/imagens/left_arrow_exited.png"));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				try {  API.Sounds.PlaySound("/multimedia/audios/mouse_click.wav", soundfile);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {e1.printStackTrace();}
				numlines--;
        		if(numlines < 1)
        			numlines = 7;
            	
            	numerolines.setText( "" + numlines);
				
			}
		});
		setaesq_numlines.setBounds(41, 221, 62, 62);
		API.Images.setImage(setaesq_numlines, getClass().getResource("/multimedia/imagens/left_arrow_exited.png"));
		contentPane.add(setaesq_numlines);
		
		numerolines = new JLabel("" + numlines, SwingConstants.CENTER);
		numerolines.setForeground(new Color(96, 24, 37));
		numerolines.setFont(new Font("CrackMan", Font.PLAIN, 45));
		numerolines.setBounds(147, 221, 62, 62);
		contentPane.add(numerolines);
		
		setadir_numlines = new JLabel();
		setadir_numlines.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				try {  API.Sounds.PlaySound("/multimedia/audios/mouse_on.wav", soundfile);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {e.printStackTrace();}
				API.Images.setImage(setadir_numlines, getClass().getResource("/multimedia/imagens/right_arrow_entered.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				API.Images.setImage(setadir_numlines, getClass().getResource("/multimedia/imagens/right_arrow_exited.png"));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				try {  API.Sounds.PlaySound("/multimedia/audios/mouse_click.wav", soundfile);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {e1.printStackTrace();}
				numlines++;
            	if(numlines > 7)
            		numlines = 1;
            	
            	numerolines.setText( "" + numlines);
				
			}
		});
		setadir_numlines.setBounds(253, 221, 62, 62);
		API.Images.setImage(setadir_numlines, getClass().getResource("/multimedia/imagens/right_arrow_exited.png"));
		contentPane.add(setadir_numlines);
		
		//-----------------------------------------------------
		placeholder_columns = new JLabel();
		placeholder_columns.setBounds(41, 306, 274, 83);
		API.Images.setImage(placeholder_columns, getClass().getResource("/multimedia/imagens/placeholder_columns.png"));
		contentPane.add(placeholder_columns);
		
		setaesq_numcolumns = new JLabel();
		setaesq_numcolumns.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				try {  API.Sounds.PlaySound("/multimedia/audios/mouse_on.wav", soundfile);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {e.printStackTrace();}
				API.Images.setImage(setaesq_numcolumns, getClass().getResource("/multimedia/imagens/left_arrow_entered.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				API.Images.setImage(setaesq_numcolumns, getClass().getResource("/multimedia/imagens/left_arrow_exited.png"));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				try {  API.Sounds.PlaySound("/multimedia/audios/mouse_click.wav", soundfile);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {e1.printStackTrace();}
				numcolumns--;
        		if(numcolumns < 1)
        			numcolumns = 10;
            	
            	numerocolumns.setText( "" + numcolumns);
				
			}
		});
		setaesq_numcolumns.setBounds(41, 389, 62, 62);
		API.Images.setImage(setaesq_numcolumns, getClass().getResource("/multimedia/imagens/left_arrow_exited.png"));
		contentPane.add(setaesq_numcolumns);
		
		numerocolumns = new JLabel("" + numcolumns, SwingConstants.CENTER);
		numerocolumns.setForeground(new Color(96, 24, 37));
		numerocolumns.setFont(new Font("CrackMan", Font.PLAIN, 45));
		numerocolumns.setBounds(147, 389, 62, 62);
		contentPane.add(numerocolumns);
		
		setadir_numcolumns = new JLabel();
		setadir_numcolumns.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				try {  API.Sounds.PlaySound("/multimedia/audios/mouse_on.wav", soundfile);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {e.printStackTrace();}
				API.Images.setImage(setadir_numcolumns, getClass().getResource("/multimedia/imagens/right_arrow_entered.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				API.Images.setImage(setadir_numcolumns, getClass().getResource("/multimedia/imagens/right_arrow_exited.png"));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				try {  API.Sounds.PlaySound("/multimedia/audios/mouse_click.wav", soundfile);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {e1.printStackTrace();}
				numcolumns++;
            	if(numcolumns > 10)
            		numcolumns = 1;
            	
            	numerocolumns.setText( "" + numcolumns);
				
			}
		});
		setadir_numcolumns.setBounds(253, 389, 62, 62);
		API.Images.setImage(setadir_numcolumns, getClass().getResource("/multimedia/imagens/right_arrow_exited.png"));
		contentPane.add(setadir_numcolumns);
		
		//-----------------------------------------------------
		placeholder_pecheck = new JLabel();
		placeholder_pecheck.setBounds(41, 474, 274, 83);
		API.Images.setImage(placeholder_pecheck, getClass().getResource("/multimedia/imagens/placeholder_pecheck.png"));
		contentPane.add(placeholder_pecheck);
		
		setaesq_numpecheck = new JLabel();
		setaesq_numpecheck.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				try {  API.Sounds.PlaySound("/multimedia/audios/mouse_on.wav", soundfile);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {e.printStackTrace();}
				API.Images.setImage(setaesq_numpecheck, getClass().getResource("/multimedia/imagens/left_arrow_entered.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				API.Images.setImage(setaesq_numpecheck, getClass().getResource("/multimedia/imagens/left_arrow_exited.png"));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				try {  API.Sounds.PlaySound("/multimedia/audios/mouse_click.wav", soundfile);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {e1.printStackTrace();}
				numcheck--;
        		if(numcheck < 1)
        			numcheck = 10;
            	
        		numeropecheck.setText( "" + numcheck);
				
			}
		});
		setaesq_numpecheck.setBounds(41, 557, 62, 62);
		API.Images.setImage(setaesq_numpecheck, getClass().getResource("/multimedia/imagens/left_arrow_exited.png"));
		contentPane.add(setaesq_numpecheck);
		
		numeropecheck = new JLabel("" + numcheck, SwingConstants.CENTER);
		numeropecheck.setForeground(new Color(96, 24, 37));
		numeropecheck.setFont(new Font("CrackMan", Font.PLAIN, 45));
		numeropecheck.setBounds(147, 557, 62, 62);
		contentPane.add(numeropecheck);
		
		setadir_numpecheck = new JLabel();
		setadir_numpecheck.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				try {  API.Sounds.PlaySound("/multimedia/audios/mouse_on.wav", soundfile);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {e.printStackTrace();}
				API.Images.setImage(setadir_numpecheck, getClass().getResource("/multimedia/imagens/right_arrow_entered.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				API.Images.setImage(setadir_numpecheck, getClass().getResource("/multimedia/imagens/right_arrow_exited.png"));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				try {  API.Sounds.PlaySound("/multimedia/audios/mouse_click.wav", soundfile);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {e1.printStackTrace();}
				numcheck++;
            	if(numcheck > 10)
            		numcheck = 1;
            	
            	numeropecheck.setText( "" + numcheck);
				
			}
		});
		setadir_numpecheck.setBounds(253, 557, 62, 62);
		API.Images.setImage(setadir_numpecheck, getClass().getResource("/multimedia/imagens/right_arrow_exited.png"));
		contentPane.add(setadir_numpecheck);
		
		setaesqnumbot = new JLabel();
		setaesqnumbot.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				try {  API.Sounds.PlaySound("/multimedia/audios/mouse_on.wav", soundfile);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {e.printStackTrace();}
				API.Images.setImage(setaesqnumbot, getClass().getResource("/multimedia/imagens/left_arrow_entered.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				API.Images.setImage(setaesqnumbot, getClass().getResource("/multimedia/imagens/left_arrow_exited.png"));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				try {  API.Sounds.PlaySound("/multimedia/audios/mouse_click.wav", soundfile);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {e1.printStackTrace();}
				numbots--;
				if(numbots < 1)
					numbots = 3;
            	
				if(numbots == 2) {
					
					setadir_3.setVisible(true);
					ballimage_3.setVisible(true);
					setaesq_3.setVisible(true);
					setaesqdif_3.setVisible(true);
					difbot_3.setVisible(true);
					setadirdif_3.setVisible(true);
					txtJogador_3.setVisible(true);
					placeholder_3.setVisible(true);

					setadir_4.setVisible(false);
					ballimage_4.setVisible(false);
					setaesq_4.setVisible(false);
					setaesqdif_4.setVisible(false);
					difbot_4.setVisible(false);
					setadirdif_4.setVisible(false);
					txtJogador_4.setVisible(false);
					placeholder_4.setVisible(false);
					
				}else if(numbots == 3) {
					
					setadir_3.setVisible(true);
					ballimage_3.setVisible(true);
					setaesq_3.setVisible(true);
					setaesqdif_3.setVisible(true);
					difbot_3.setVisible(true);
					setadirdif_3.setVisible(true);
					txtJogador_3.setVisible(true);
					placeholder_3.setVisible(true);

					setadir_4.setVisible(true);
					ballimage_4.setVisible(true);
					setaesq_4.setVisible(true);
					setaesqdif_4.setVisible(true);
					difbot_4.setVisible(true);
					setadirdif_4.setVisible(true);
					txtJogador_4.setVisible(true);
					placeholder_4.setVisible(true);
					
				}else {
					
					setadir_3.setVisible(false);
					ballimage_3.setVisible(false);
					setaesq_3.setVisible(false);
					setaesqdif_3.setVisible(false);
					difbot_3.setVisible(false);
					setadirdif_3.setVisible(false);
					txtJogador_3.setVisible(false);
					placeholder_3.setVisible(false);

					setadir_4.setVisible(false);
					ballimage_4.setVisible(false);
					setaesq_4.setVisible(false);
					setaesqdif_4.setVisible(false);
					difbot_4.setVisible(false);
					setadirdif_4.setVisible(false);
					txtJogador_4.setVisible(false);
					placeholder_4.setVisible(false);
					
				}
				
            	numerobot.setText( "" + numbots);
				
			}
		});
		setaesqnumbot.setBounds(409, 157, 62, 62);
		API.Images.setImage(setaesqnumbot, getClass().getResource("/multimedia/imagens/left_arrow_exited.png"));
		contentPane.add(setaesqnumbot);
		
		numerobot = new JLabel("" + numbots, SwingConstants.CENTER);
		numerobot.setForeground(new Color(96, 24, 37));
		numerobot.setFont(new Font("CrackMan", Font.PLAIN, 45));
		numerobot.setBounds(471, 152, 150, 72);
		contentPane.add(numerobot);
		
		setadirnumbot = new JLabel();
		setadirnumbot.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				try {  API.Sounds.PlaySound("/multimedia/audios/mouse_on.wav", soundfile);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {e.printStackTrace();}
				API.Images.setImage(setadirnumbot, getClass().getResource("/multimedia/imagens/right_arrow_entered.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				API.Images.setImage(setadirnumbot, getClass().getResource("/multimedia/imagens/right_arrow_exited.png"));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				try {  API.Sounds.PlaySound("/multimedia/audios/mouse_click.wav", soundfile);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {e1.printStackTrace();}
				numbots++;
            	if(numbots > 3)
            		numbots = 1;
            	
            	if(numbots == 2) {
					
					setadir_3.setVisible(true);
					ballimage_3.setVisible(true);
					setaesq_3.setVisible(true);
					setaesqdif_3.setVisible(true);
					difbot_3.setVisible(true);
					setadirdif_3.setVisible(true);
					txtJogador_3.setVisible(true);
					placeholder_3.setVisible(true);

					setadir_4.setVisible(false);
					ballimage_4.setVisible(false);
					setaesq_4.setVisible(false);
					setaesqdif_4.setVisible(false);
					difbot_4.setVisible(false);
					setadirdif_4.setVisible(false);
					txtJogador_4.setVisible(false);
					placeholder_4.setVisible(false);
					
				}else if(numbots == 3) {
					
					setadir_3.setVisible(true);
					ballimage_3.setVisible(true);
					setaesq_3.setVisible(true);
					setaesqdif_3.setVisible(true);
					difbot_3.setVisible(true);
					setadirdif_3.setVisible(true);
					txtJogador_3.setVisible(true);
					placeholder_3.setVisible(true);

					setadir_4.setVisible(true);
					ballimage_4.setVisible(true);
					setaesq_4.setVisible(true);
					setaesqdif_4.setVisible(true);
					difbot_4.setVisible(true);
					setadirdif_4.setVisible(true);
					txtJogador_4.setVisible(true);
					placeholder_4.setVisible(true);
					
				}else {
					
					setadir_3.setVisible(false);
					ballimage_3.setVisible(false);
					setaesq_3.setVisible(false);
					setaesqdif_3.setVisible(false);
					difbot_3.setVisible(false);
					setadirdif_3.setVisible(false);
					txtJogador_3.setVisible(false);
					placeholder_3.setVisible(false);

					setadir_4.setVisible(false);
					ballimage_4.setVisible(false);
					setaesq_4.setVisible(false);
					setaesqdif_4.setVisible(false);
					difbot_4.setVisible(false);
					setadirdif_4.setVisible(false);
					txtJogador_4.setVisible(false);
					placeholder_4.setVisible(false);
					
				}
            	
            	numerobot.setText( "" + numbots);
				
			}
		});
		setadirnumbot.setBounds(621, 157, 62, 62);
		API.Images.setImage(setadirnumbot, getClass().getResource("/multimedia/imagens/right_arrow_exited.png"));
		contentPane.add(setadirnumbot);
		
		
		setadir_3.setVisible(false);
		ballimage_3.setVisible(false);
		setaesq_3.setVisible(false);
		setaesqdif_3.setVisible(false);
		difbot_3.setVisible(false);
		setadirdif_3.setVisible(false);
		txtJogador_3.setVisible(false);
		placeholder_3.setVisible(false);

		setadir_4.setVisible(false);
		ballimage_4.setVisible(false);
		setaesq_4.setVisible(false);
		setaesqdif_4.setVisible(false);
		difbot_4.setVisible(false);
		setadirdif_4.setVisible(false);
		txtJogador_4.setVisible(false);
		placeholder_4.setVisible(false);
		
		
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
	
	private void begin() {
		try {  API.Sounds.PlaySound("/multimedia/audios/mouse_click.wav", soundfile);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {e1.printStackTrace();}
		setLoca(getLocation());
		opcao = false;
		selected = 0;
		listening = false;
		BeginGameBot.setSinglePlayerOption(true);
		
		BeginGameBot.setX(numlines);
		BeginGameBot.setY(numcolumns);
		BeginGameBot.setLinha(numcheck);
		BeginGameBot.setJogador1nome(txtJogador_1.getText());
		BeginGameBot.setJogador2nome(txtJogador_2.getText());
		BeginGameBot.setJogador3nome(txtJogador_3.getText());
		BeginGameBot.setJogador4nome(txtJogador_4.getText());
		BeginGameBot.setImage1("ball" + ballimagenum1 + ".png");
		BeginGameBot.setImage2("ball" + ballimagenum2 + ".png");
		BeginGameBot.setImage3("ball" + ballimagenum3 + ".png");
		BeginGameBot.setImage4("ball" + ballimagenum4 + ".png");
		
		BeginGameBot.setPlayer1("#");
		if(numbots == 3) {
			BeginGameBot.setPlayer2("@");
			BeginGameBot.setPlayer3("&");
			BeginGameBot.setPlayer4("$");
		}else if(numbots == 2) {
			BeginGameBot.setPlayer2("@");
			BeginGameBot.setPlayer3("&");
			BeginGameBot.setPlayer4("");
		}else {
			BeginGameBot.setPlayer2("@");
			BeginGameBot.setPlayer3("");
			BeginGameBot.setPlayer4("");
		}
		
		if(botconfigint2 == 3) {
			BeginGameBot.setBotfacil2(false);
			BeginGameBot.setBotnormal2(false);
			BeginGameBot.setBotmedio2(false);
			BeginGameBot.setBotdificil2(true);
		}else if(botconfigint2 == 2) {
			BeginGameBot.setBotfacil2(false);
			BeginGameBot.setBotnormal2(false);
			BeginGameBot.setBotmedio2(true);
			BeginGameBot.setBotdificil2(false);
		}else if(botconfigint2 == 1) {
			BeginGameBot.setBotfacil2(false);
			BeginGameBot.setBotnormal2(true);
			BeginGameBot.setBotmedio2(false);
			BeginGameBot.setBotdificil2(false);
		}else {
			BeginGameBot.setBotfacil2(true);
			BeginGameBot.setBotnormal2(false);
			BeginGameBot.setBotmedio2(false);
			BeginGameBot.setBotdificil2(false);
		}
		
		if(botconfigint3 == 3) {
			BeginGameBot.setBotfacil3(false);
			BeginGameBot.setBotnormal3(false);
			BeginGameBot.setBotmedio3(false);
			BeginGameBot.setBotdificil3(true);
		}else if(botconfigint3 == 2) {
			BeginGameBot.setBotfacil3(false);
			BeginGameBot.setBotnormal3(false);
			BeginGameBot.setBotmedio3(true);
			BeginGameBot.setBotdificil3(false);
		}else if(botconfigint3 == 1) {
			BeginGameBot.setBotfacil3(false);
			BeginGameBot.setBotnormal3(true);
			BeginGameBot.setBotmedio3(false);
			BeginGameBot.setBotdificil3(false);
		}else {
			BeginGameBot.setBotfacil3(true);
			BeginGameBot.setBotnormal3(false);
			BeginGameBot.setBotmedio3(false);
			BeginGameBot.setBotdificil3(false);
		}
		
		if(botconfigint4 == 3) {
			BeginGameBot.setBotfacil4(false);
			BeginGameBot.setBotnormal4(false);
			BeginGameBot.setBotmedio4(false);
			BeginGameBot.setBotdificil4(true);
		}else if(botconfigint4 == 2) {
			BeginGameBot.setBotfacil4(false);
			BeginGameBot.setBotnormal4(false);
			BeginGameBot.setBotmedio4(true);
			BeginGameBot.setBotdificil4(false);
		}else if(botconfigint4 == 1) {
			BeginGameBot.setBotfacil4(false);
			BeginGameBot.setBotnormal4(true);
			BeginGameBot.setBotmedio4(false);
			BeginGameBot.setBotdificil4(false);
		}else {
			BeginGameBot.setBotfacil4(true);
			BeginGameBot.setBotnormal4(false);
			BeginGameBot.setBotmedio4(false);
			BeginGameBot.setBotdificil4(false);
		}
		
		clipTimePostion = clip.getMicrosecondPosition();
		clip.stop();
		BeginGameBot fram;
		try {
			fram = new BeginGameBot();
			fram.setVisible(true);
		} catch (FILException e1) {
			e1.printStackTrace();
		}
		
		dispose();
	}
	
	private void back() {
		try {  API.Sounds.PlaySound("/multimedia/audios/mouse_click.wav", soundfile);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {e1.printStackTrace();}
		setLoca(getLocation());
		opcao = false;
		selected = 0;
		listening = false;
		NewGameOptions.setSingleop(true);
		clipTimePostion = clip.getMicrosecondPosition();
		clip.stop();
		frame = new NewGameOptions();
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
	    
	    btnbegin.setBounds(520, (int)(626+((height-800)/1.1)), 296, 112);
		API.Images.setImage(btnbegin, getClass().getResource("/multimedia/imagens/button_begin_exited.png"));
		
		btnback.setBounds(48, (int)(626+((height-800)/1.1)), 296, 112);
		API.Images.setImage(btnback, getClass().getResource("/multimedia/imagens/button_back_exited.png"));
		
		
		
		
		setadir_1.setBounds(621+((width-1024)/3), 63+((height-800)/3), 62, 62);
		API.Images.setImage(setadir_1, getClass().getResource("/multimedia/imagens/right_arrow_exited.png"));
		
		ballimage_1.setBounds(491+((width-1024)/3), 39+((height-800)/3), 110, 110);
		API.Images.setImage(ballimage_1, getClass().getResource("/multimedia/imagens/ball" + ballimagenum1 + ".png"));
		
		setaesq_1.setBounds(409+((width-1024)/3), 63+((height-800)/3), 62, 62);
		API.Images.setImage(setaesq_1, getClass().getResource("/multimedia/imagens/left_arrow_exited.png"));
		
		txtJogador_1.setBounds(440+((width-1024)/3), 237+((height-800)/3), 210, 43);
		
		placeholder_1.setBounds(409+((width-1024)/3), 221+((height-800)/3), 274, 72);
		API.Images.setImage(placeholder_1, getClass().getResource("/multimedia/imagens/placeholder_depth.png"));
		
		
		
		
		setadir_2.setBounds(933+((width-1024)/3), 63+((height-800)/3), 62, 62);
		API.Images.setImage(setadir_2, getClass().getResource("/multimedia/imagens/right_arrow_exited.png"));
		
		ballimage_2.setBounds(803+((width-1024)/3), 39+((height-800)/3), 110, 110);
		API.Images.setImage(ballimage_2, getClass().getResource("/multimedia/imagens/ball" + ballimagenum2 + ".png"));
		
		setaesq_2.setBounds(721+((width-1024)/3), 63+((height-800)/3), 62, 62);
		API.Images.setImage(setaesq_2, getClass().getResource("/multimedia/imagens/left_arrow_exited.png"));
		
		setaesqdif_2.setBounds(721+((width-1024)/3), 154+((height-800)/3), 62, 62);
		API.Images.setImage(setaesqdif_2, getClass().getResource("/multimedia/imagens/left_arrow_exited.png"));
		
		difbot_2.setBounds(783+((width-1024)/3), 149+((height-800)/3), 150, 72);
		
		setadirdif_2.setBounds(933+((width-1024)/3), 154+((height-800)/3), 62, 62);
		API.Images.setImage(setadirdif_2, getClass().getResource("/multimedia/imagens/right_arrow_exited.png"));
		
		txtJogador_2.setBounds(752+((width-1024)/3), 237+((height-800)/3), 210, 43);
		
		placeholder_2.setBounds(721+((width-1024)/3), 221+((height-800)/3), 274, 72);
		API.Images.setImage(placeholder_2, getClass().getResource("/multimedia/imagens/placeholder_depth.png"));
		
		
		
		
		setadir_3.setBounds(621+((width-1024)/3), 371+((height-800)/3), 62, 62);
		API.Images.setImage(setadir_3, getClass().getResource("/multimedia/imagens/right_arrow_exited.png"));
		
		ballimage_3.setBounds(491+((width-1024)/3), 347+((height-800)/3), 110, 110);
		API.Images.setImage(ballimage_3, getClass().getResource("/multimedia/imagens/ball" + ballimagenum3 + ".png"));
		
		setaesq_3.setBounds(409+((width-1024)/3), 371+((height-800)/3), 62, 62);
		API.Images.setImage(setaesq_3, getClass().getResource("/multimedia/imagens/left_arrow_exited.png"));
		
		setaesqdif_3.setBounds(409+((width-1024)/3), 462+((height-800)/3), 62, 62);
		API.Images.setImage(setaesqdif_3, getClass().getResource("/multimedia/imagens/left_arrow_exited.png"));
		
		difbot_3.setBounds(471+((width-1024)/3), 457+((height-800)/3), 150, 72);
		
		setadirdif_3.setBounds(621+((width-1024)/3), 462+((height-800)/3), 62, 62);
		API.Images.setImage(setadirdif_3, getClass().getResource("/multimedia/imagens/right_arrow_exited.png"));
		
		txtJogador_3.setBounds(440+((width-1024)/3), 545+((height-800)/3), 210, 43);
		
		placeholder_3.setBounds(409+((width-1024)/3), 529+((height-800)/3), 274, 72);
		API.Images.setImage(placeholder_3, getClass().getResource("/multimedia/imagens/placeholder_depth.png"));
		
		
		
		
		setadir_4.setBounds(933+((width-1024)/3), 371+((height-800)/3), 62, 62);
		API.Images.setImage(setadir_4, getClass().getResource("/multimedia/imagens/right_arrow_exited.png"));
		
		ballimage_4.setBounds(803+((width-1024)/3), 347+((height-800)/3), 110, 110);
		API.Images.setImage(ballimage_4, getClass().getResource("/multimedia/imagens/ball" + ballimagenum4 + ".png"));
		
		setaesq_4.setBounds(721+((width-1024)/3), 371+((height-800)/3), 62, 62);
		API.Images.setImage(setaesq_4, getClass().getResource("/multimedia/imagens/left_arrow_exited.png"));
		
		setaesqdif_4.setBounds(721+((width-1024)/3), 462+((height-800)/3), 62, 62);
		API.Images.setImage(setaesqdif_4, getClass().getResource("/multimedia/imagens/left_arrow_exited.png"));
		
		difbot_4.setBounds(783+((width-1024)/3), 457+((height-800)/3), 150, 72);
		
		setadirdif_4.setBounds(933+((width-1024)/3), 462+((height-800)/3), 62, 62);
		API.Images.setImage(setadirdif_4, getClass().getResource("/multimedia/imagens/right_arrow_exited.png"));
		
		txtJogador_4.setBounds(752+((width-1024)/3), 545+((height-800)/3), 210, 43);
		
		placeholder_4.setBounds(721+((width-1024)/3), 529+((height-800)/3), 274, 72);
		API.Images.setImage(placeholder_4, getClass().getResource("/multimedia/imagens/placeholder_depth.png"));
		
		
		
		
		placeholder_lines.setBounds(41+((width-1024)/5), 138+((height-800)/3), 274, 83);
		API.Images.setImage(placeholder_lines, getClass().getResource("/multimedia/imagens/placeholder_lines.png"));
		
		setaesq_numlines.setBounds(41+((width-1024)/5), 221+((height-800)/3), 62, 62);
		API.Images.setImage(setaesq_numlines, getClass().getResource("/multimedia/imagens/left_arrow_exited.png"));
		
		numerolines.setBounds(147+((width-1024)/5), 221+((height-800)/3), 62, 62);
		
		setadir_numlines.setBounds(253+((width-1024)/5), 221+((height-800)/3), 62, 62);
		API.Images.setImage(setadir_numlines, getClass().getResource("/multimedia/imagens/right_arrow_exited.png"));
		
		
		
		
		placeholder_columns.setBounds(41+((width-1024)/5), 306+((height-800)/3), 274, 83);
		API.Images.setImage(placeholder_columns, getClass().getResource("/multimedia/imagens/placeholder_columns.png"));
		
		setaesq_numcolumns.setBounds(41+((width-1024)/5), 389+((height-800)/3), 62, 62);
		API.Images.setImage(setaesq_numcolumns, getClass().getResource("/multimedia/imagens/left_arrow_exited.png"));
		
		numerocolumns.setBounds(147+((width-1024)/5), 389+((height-800)/3), 62, 62);
		
		setadir_numcolumns.setBounds(253+((width-1024)/5), 389+((height-800)/3), 62, 62);
		API.Images.setImage(setadir_numcolumns, getClass().getResource("/multimedia/imagens/right_arrow_exited.png"));
		
		
		
		
		placeholder_pecheck.setBounds(41+((width-1024)/5), 474+((height-800)/3), 274, 83);
		API.Images.setImage(placeholder_pecheck, getClass().getResource("/multimedia/imagens/placeholder_pecheck.png"));
		
		setaesq_numpecheck.setBounds(41+((width-1024)/5), 557+((height-800)/3), 62, 62);
		API.Images.setImage(setaesq_numpecheck, getClass().getResource("/multimedia/imagens/left_arrow_exited.png"));
		
		numeropecheck.setBounds(147+((width-1024)/5), 557+((height-800)/3), 62, 62);
		
		setadir_numpecheck.setBounds(253+((width-1024)/5), 557+((height-800)/3), 62, 62);
		API.Images.setImage(setadir_numpecheck, getClass().getResource("/multimedia/imagens/right_arrow_exited.png"));
		
		
		
		
		setaesqnumbot.setBounds(409+((width-1024)/3), 157+((height-800)/3), 62, 62);
		API.Images.setImage(setaesqnumbot, getClass().getResource("/multimedia/imagens/left_arrow_exited.png"));
		
		numerobot.setBounds(471+((width-1024)/3), 152+((height-800)/3), 150, 72);
		
		setadirnumbot.setBounds(621+((width-1024)/3), 157+((height-800)/3), 62, 62);
		API.Images.setImage(setadirnumbot, getClass().getResource("/multimedia/imagens/right_arrow_exited.png"));
		
	}

	@Override
	public void componentShown(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
