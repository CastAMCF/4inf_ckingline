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

import API.FILException;

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
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JSlider;

public class BeginGameBot extends JFrame implements ComponentListener {
	
	protected static BeginGameBot frame;
	protected JPanel contentPane;
	protected JLabel label;
	protected JLabel label_1;
	protected JLabel label_2;
	protected JLabel label_3;
	protected JLabel label_4;
	protected boolean listening = true;
	private boolean listeningmous = true;
	private API.FILGame game;
	private int pecs0 = 0;
	private int pecs1 = 0;
	private int pecs2 = 0;
	private int pecs3 = 0;
	private int pecs4 = 0;
	private int pecs5 = 0;
	private int pecs6 = 0;
	private int pecs7 = 0;
	private int pecs8 = 0;
	private int pecs9 = 0;
	private static int x = 6;
	private static int y = 7;
	private int countplac = 0;
	private int temp = -1;
	private static int linha;
	private String jogador;
	private static String player1;
	private static String player2;
	private static String player3;
	private static String player4;
	private static String jogador1nome;
	private static String jogador2nome;
	private static String jogador3nome;
	private static String jogador4nome;
	private static String image1;
	private static String image2;
	private static String image3;
	private static String image4;
	private String[] jogadores;
	private String[] players;
	private int widthfile = 0;
	private int heightfile = 0;
	private int soundfile = 0;
	private int vk1 = 0;
	private int vk2 = 0;
	private int vk3 = 0;
	private Clip clip;
	private int count = 0;
	private int count1 = 1;
	private int count2 = 0;
	private int count3 = 1;
	private static long clipTimePostion;
	private static boolean botfacil2;
	private static boolean botnormal2;
	private static boolean botmedio2;
	private static boolean botdificil2;
	private static boolean botfacil3;
	private static boolean botnormal3;
	private static boolean botmedio3;
	private static boolean botdificil3;
	private static boolean botfacil4;
	private static boolean botnormal4;
	private static boolean botmedio4;
	private static boolean botdificil4;
	private String[] jogadoresnames;
	private static boolean bool;
	private static Point loc;
	private static boolean singleplayeroptiongui;

	/**
	 * Create the frame.
	 * @throws FILException 
	 */
	public BeginGameBot() throws API.FILException {
		
		bool = true;
		
		if(game == null)
			game = new API.FILGame(x, y, player1, player2, player3, player4);
		
		String[] str1 = API.Fichi.readPrefs("preferencias.ap").split("\n");
		widthfile = Integer.parseInt(str1[0].replaceAll("\\D+",""));
		heightfile = Integer.parseInt(str1[1].replaceAll("\\D+",""));
		soundfile = Integer.parseInt(str1[2].replaceAll("\\D+",""));
		vk1 = Integer.parseInt(str1[3].replaceAll("\\D+",""));
		vk2 = Integer.parseInt(str1[4].replaceAll("\\D+",""));
		vk3 = Integer.parseInt(str1[5].replaceAll("\\D+",""));
		
		KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {

			@Override
            public boolean dispatchKeyEvent(KeyEvent ke) { 
            		if (listening) {
	                    switch (ke.getID()) {
	                    case KeyEvent.KEY_PRESSED:
	                    	if (ke.getKeyCode() == vk2) {
		                    	
		                    	countplac++;
		                    	if(countplac > y-1)
		                    		countplac = 0;
				        		
		                    	updateball();
		                    	
				        	}else if (ke.getKeyCode() == vk1) {
				        		
				        		countplac--;
				        		if(countplac < 0)
		                    		countplac = y-1;
				        		
				        		updateball();
				        		
				        	}else if (ke.getKeyCode() == vk3) {
	                        	
				        		try {
									dropPec(countplac);
								} catch (API.FILException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
				        		
	                        }else if (ke.getKeyCode() == KeyEvent.VK_G) {
	                        	
	                        	String playert = "";
	                        	String jogadort = "";
	                        	String jogadorsnames = "";
	                        	
	                        	String sizet = x + "," + y + "\n";
	                        	
	                        	for(int i = 0; i < players.length; i++) {
	                        		
	                        		playert += players[i];
	                        		playert += ",";
	                        		
	                        	}
	                        	playert += "\n";
	                        	
	                        	for(int i = 0; i < jogadores.length; i++) {
	                        		
		                        	jogadort += jogadores[i];
		                        	jogadort += ",";
	                        		
	                        	}
	                        	jogadort += "\n";
	                        	
	                        	for(int i = 0; i < jogadoresnames.length; i++) {
	                        		
	                        		jogadorsnames += jogadoresnames[i];
	                        		jogadorsnames += ",";
	                        		
	                        	}
	                        	jogadorsnames += "\n";
	                        	
	                        	String botdifi = "";
	                        	
	                        	if (!player4.equals("")) {
	                        		if(botfacil4) {
		                        		botdifi += "botfacil4,";
		                			}else if(botnormal4) {
		                				botdifi += "botnormal4,";
		                			}else if(botmedio4) {
		                				botdifi += "botmedio4,";
		                			}else if(botdificil4) {
		                				botdifi += "botdificil4,";
		                			}
	                        		
	                        		if(botfacil3) {
		                        		botdifi += "botfacil3,";
		                			}else if(botnormal3) {
		                				botdifi += "botnormal3,";
		                			}else if(botmedio3) {
		                				botdifi += "botmedio3,";
		                			}else if(botdificil3) {
		                				botdifi += "botdificil3,";
		                			}
	                        		
	                        		if(botfacil2) {
		                        		botdifi += "botfacil2,\n";
		                			}else if(botnormal2) {
		                				botdifi += "botnormal2,\n";
		                			}else if(botmedio2) {
		                				botdifi += "botmedio2,\n";
		                			}else if(botdificil2) {
		                				botdifi += "botdificil2,\n";
		                			}
	                        	}else {
	                        		if (!player3.equals("")) {
	                        			if(botfacil3) {
			                        		botdifi += "botfacil3,";
			                			}else if(botnormal3) {
			                				botdifi += "botnormal3,";
			                			}else if(botmedio3) {
			                				botdifi += "botmedio3,";
			                			}else if(botdificil3) {
			                				botdifi += "botdificil3,";
			                			}
		                        		
	                        			if(botfacil2) {
			                        		botdifi += "botfacil2,\n";
			                			}else if(botnormal2) {
			                				botdifi += "botnormal2,\n";
			                			}else if(botmedio2) {
			                				botdifi += "botmedio2,\n";
			                			}else if(botdificil2) {
			                				botdifi += "botdificil2,\n";
			                			}
	                        		}else {
	                        			if(botfacil2) {
			                        		botdifi += "botfacil2,\n";
			                			}else if(botnormal2) {
			                				botdifi += "botnormal2,\n";
			                			}else if(botmedio2) {
			                				botdifi += "botmedio2,\n";
			                			}else if(botdificil2) {
			                				botdifi += "botdificil2,\n";
			                			}
	                        		}
	                        	}
				        		
	                        	API.Fichi.write("jogo_salvo.ap", botdifi + sizet + playert + jogadorsnames + jogadort + game.myBord.toString() + game.activePlayer.getTxt());
	                        }
	                        break;
	                    }
            		}
                    return false;
                }
            
        });
		
		
		try {
			InputStream in = getClass().getResourceAsStream("/multimedia/audios/music.wav");
			InputStream bufferedIn = new BufferedInputStream(in);
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(bufferedIn);
			clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
			gainControl.setValue((float)(soundfile-84));
			
			if(singleplayeroptiongui) {
				while (SinglePlayerOptions.getTimeMusic() > (34360748*count1)) {
					count++;
					count1++;
					count2 = count;
					count3 = count1;
				}
				clip.setMicrosecondPosition(SinglePlayerOptions.getTimeMusic() - (34360748*count));
				singleplayeroptiongui = false;
			}else {
				while (BeginGameBot.getTimeMusic() > (34360748*count3)) {
					count2++;
					count3++;
					count = count2;
					count1 = count3;
				}
				clip.setMicrosecondPosition(BeginGameBot.getTimeMusic() - (34360748*count2));
			}
			
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
		
		boolean singleplatop = SinglePlayerOptions.getBool();
		
		if(singleplatop) {
			Point loc = SinglePlayerOptions.getLoca();
			setBounds(loc.x, loc.y, widthfile, heightfile);
			SinglePlayerOptions.setBool(false);
		}else {
			Point loc = BeginGameBot.getLoca();
			setBounds(loc.x, loc.y, widthfile, heightfile);
		}
		
		
		
		setResizable(false);
		
		contentPane = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
            	super.paintComponent(g);
                ImageIcon img = new ImageIcon(getClass().getResource("/multimedia/imagens/background_game.png"));
                g.drawImage(img.getImage(), 0, 0, this.getWidth(), this.getHeight(), null);
            }
		};
		contentPane.setBackground(SystemColor.control);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label_back = new JLabel();
		label_back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				try {  API.Sounds.PlaySound("/multimedia/audios/mouse_on.wav", soundfile);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {e.printStackTrace();}
				API.Images.setImage(label_back, getClass().getResource("/multimedia/imagens/button_back_entered.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				API.Images.setImage(label_back, getClass().getResource("/multimedia/imagens/button_back_exited.png"));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				try {  API.Sounds.PlaySound("/multimedia/audios/mouse_click.wav", soundfile);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {e1.printStackTrace();}
				back();
			}
		});
		label_back.setBounds(744, 661, 236, 92);
		API.Images.setImage(label_back, getClass().getResource("/multimedia/imagens/button_back_exited.png"));
		contentPane.add(label_back);
		
		int hei = 0;
		int wit = 0;
		for(int i = 0; i < x; i++) {
			for(int j = 0; j < y; j++) {
				label = new JLabel();
				label.setBounds(260+wit-(40*(y-6)), 180+hei-(35*(x-7)), 80, 70);
				API.Images.setImage(label, getClass().getResource("/multimedia/imagens/space_game.png"));
				contentPane.add(label);
				wit += 80;
			}
			hei += 70;
			wit = 0;
		}
		
		
		if(game.activePlayer.getTxt().equals("@")) {
			label_1 = new JLabel();
			label_1.setBounds(268-(40*(y-6)), 100-(35*(x-7)), 60, 60);
			API.Images.setImage(label_1, getClass().getResource("/multimedia/imagens/" + image2));
			contentPane.add(label_1);
			
			label_2 = new JLabel();
			label_2.setBounds(268-(40*(y-6)), 100-(35*(x-7)), 60, 60);
			API.Images.setImage(label_2, getClass().getResource("/multimedia/imagens/" + image2));
			contentPane.add(label_2);
			
			jogador =  image2;
			
			listening = false;
        	listeningmous = false;
        	if(botfacil2) {
				botestupido();
			}else if(botnormal2) {
				botnormal();
			}else if(botmedio2) {
				botmedio();
			}else if(botdificil2) {
				bothard();
			}
        }else if (game.activePlayer.getTxt().equals("&")) {
        	label_1 = new JLabel();
    		label_1.setBounds(268-(40*(y-6)), 100-(35*(x-7)), 60, 60);
    		API.Images.setImage(label_1, getClass().getResource("/multimedia/imagens/" + image3));
    		contentPane.add(label_1);
    		
    		label_2 = new JLabel();
    		label_2.setBounds(268-(40*(y-6)), 100-(35*(x-7)), 60, 60);
    		API.Images.setImage(label_2, getClass().getResource("/multimedia/imagens/" + image3));
    		contentPane.add(label_2);
    		
    		jogador =  image3;
    		
    		listening = false;
        	listeningmous = false;
        	if(botfacil3) {
				botestupido();
			}else if(botnormal3) {
				botnormal();
			}else if(botmedio3) {
				botmedio();
			}else if(botdificil3) {
				bothard();
			}
        }else if (game.activePlayer.getTxt().equals("$")) {
        	label_1 = new JLabel();
    		label_1.setBounds(268-(40*(y-6)), 100-(35*(x-7)), 60, 60);
    		API.Images.setImage(label_1, getClass().getResource("/multimedia/imagens/" + image4));
    		contentPane.add(label_1);
    		
    		label_2 = new JLabel();
    		label_2.setBounds(268-(40*(y-6)), 100-(35*(x-7)), 60, 60);
    		API.Images.setImage(label_2, getClass().getResource("/multimedia/imagens/" + image4));
    		contentPane.add(label_2);
    		
    		jogador = image4;
    		
    		listening = false;
        	listeningmous = false;
        	if(botfacil4) {
				botestupido();
			}else if(botnormal4) {
				botnormal();
			}else if(botmedio4) {
				botmedio();
			}else if(botdificil4) {
				bothard();
			}
        }else {
        	label_1 = new JLabel();
    		label_1.setBounds(268-(40*(y-6)), 100-(35*(x-7)), 60, 60);
    		API.Images.setImage(label_1, getClass().getResource("/multimedia/imagens/" + image1));
    		contentPane.add(label_1);
    		
    		label_2 = new JLabel();
    		label_2.setBounds(268-(40*(y-6)), 100-(35*(x-7)), 60, 60);
    		API.Images.setImage(label_2, getClass().getResource("/multimedia/imagens/" + image1));
    		contentPane.add(label_2);
    		
    		jogador = image1;
        }
		
		
		if (!player4.equals("")) {
			
			jogadores = new String[4];
    		jogadores[0] = image1;
    		jogadores[1] = image2;
    		jogadores[2] = image3;
    		jogadores[3] = image4;
    		
    		jogadoresnames = new String[4];
    		jogadoresnames[0] = jogador1nome;
    		jogadoresnames[1] = jogador2nome;
    		jogadoresnames[2] = jogador3nome;
    		jogadoresnames[3] = jogador4nome;
    		
    		players = new String[4];
    		players[0] = player1;
    		players[1] = player2;
    		players[2] = player3;
    		players[3] = player4;
    		
        }else {
        	if (!player3.equals("")) {
        		
        		jogadores = new String[3];
        		jogadores[0] = image1;
        		jogadores[1] = image2;
        		jogadores[2] = image3;
        		
        		jogadoresnames = new String[3];
        		jogadoresnames[0] = jogador1nome;
        		jogadoresnames[1] = jogador2nome;
        		jogadoresnames[2] = jogador3nome;
        		
        		players = new String[3];
        		players[0] = player1;
        		players[1] = player2;
        		players[2] = player3;
        		
        	}else {
        		jogadores = new String[2];
        		jogadores[0] = image1;
        		jogadores[1] = image2;
        		
        		jogadoresnames = new String[2];
        		jogadoresnames[0] = jogador1nome;
        		jogadoresnames[1] = jogador2nome;
        		
        		players = new String[2];
        		players[0] = player1;
        		players[1] = player2;
        	}
        }
		
		
		for(int j = 0; j < y; j++) {
			int i = j;
			label_4 = new JLabel();
			label_4.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent arg0) {
					countplac = i;
					if(listeningmous) {
						updateball();
					}
				}
				@Override
				public void mouseClicked(MouseEvent e) {
					if(listeningmous ) {
						try {
							dropPec(i);
						} catch (API.FILException e1) {
							e1.printStackTrace();
						}
						listeningmous = false;
					}
				}
			});
			label_4.setBounds(268+wit-(40*(y-6)), 100-(35*(x-7)), 60, 60+hei);
			contentPane.add(label_4);
			
			wit += 80;
		}
		
	}
	
	public void botestupido() {
		while(true) {
			int rand = (int)(Math.random() * y);
			try {
				dropPec(rand);
				break;
			} catch (API.FILException e) {
				e.printStackTrace();
				continue;
			}
		}
	}
	
	public void botnormal() {
		int block = game.myBord.chekagembotnormal(game.notactivePlayer, game.activePlayer, linha-1, temp);
		//System.out.println(block);
		if(block >= 0) {
			temp = block;
			try {
				dropPec(block);
			} catch (API.FILException e) {
				e.printStackTrace();
				int j = 0;
				while(true) {
					try {
						dropPec(j);
						break;
					} catch (API.FILException e1) {
						e1.printStackTrace();
						j++;
						continue;
					}
				}
			}
		}else {
			while(true) {
				int rand = (int)(Math.random() * y);
				try {
					dropPec(rand);
					break;
				} catch (API.FILException e) {
					e.printStackTrace();
					continue;
				}
			}
		}
	}
	
	public void botmedio() {
		int block = game.myBord.chekagembotmedio(game.notactivePlayer, game.activePlayer, linha-1, temp);
		//System.out.println(block);
		if(block >= 0) {
			temp = block;
			try {
				dropPec(block);
			} catch (API.FILException e) {
				e.printStackTrace();
				int j = 0;
				while(true) {
					try {
						dropPec(j);
						break;
					} catch (API.FILException e1) {
						e1.printStackTrace();
						j++;
						continue;
					}
				}
			}
		}else {
			while(true) {
				int rand = (int)(Math.random() * y);
				try {
					dropPec(rand);
					break;
				} catch (API.FILException e) {
					e.printStackTrace();
					continue;
				}
			}
		}
	}
	
	public void bothard() {
		int block = game.myBord.chekagembothard(game.notactivePlayer, game.activePlayer, linha-1, temp);
		//System.out.println(block);
		if(block >= 0) {
			temp = block;
			try {
				dropPec(block);
			} catch (API.FILException e) {
				e.printStackTrace();
				int j = 0;
				while(true) {
					try {
						dropPec(j);
						break;
					} catch (API.FILException e1) {
						e1.printStackTrace();
						j++;
						continue;
					}
				}
			}
		}else {
			while(true) {
				int rand = (int)(Math.random() * y);
				try {
					dropPec(rand);
					break;
				} catch (API.FILException e) {
					e.printStackTrace();
					continue;
				}
			}
		}
	}
	
	private void dropPec(int num) throws API.FILException{
		
		switch (num) {
    	case 0:
    		checktable(pecs0, num, jogador);
    		pecs0++;
			game.playPiece(num);
    		break;
    	case 1:
    		checktable(pecs1, num, jogador);
    		pecs1++;
			game.playPiece(num);
    		break;
    	case 2:
    		checktable(pecs2, num, jogador);
    		pecs2++;
    		game.playPiece(num);
    		break;
    	case 3:
    		checktable(pecs3, num, jogador);
    		pecs3++;
    		game.playPiece(num);
    		break;
    	case 4:
    		checktable(pecs4, num, jogador);
    		pecs4++;
    		game.playPiece(num);
    		break;
    	case 5:
    		checktable(pecs5, num, jogador);
    		pecs5++;
    		game.playPiece(num);
    		break;
    	case 6:
    		checktable(pecs6, num, jogador);
    		pecs6++;
    		game.playPiece(num);
    		break;
    	case 7:
    		checktable(pecs7, num, jogador);
    		pecs7++;
    		game.playPiece(num);
    		break;
    	case 8:
    		checktable(pecs8, num, jogador);
    		pecs8++;
    		game.playPiece(num);
    		break;
    	case 9:
    		checktable(pecs9, num, jogador);
    		pecs9++;
    		game.playPiece(num);
    		break;
    	}
		
	}
	
	private void updateball() {
		
		contentPane.remove(label_1);
    	label_1 = new JLabel();
		label_1.setBounds(268+(80*countplac)-(40*(y-6)), 100-(35*(x-7)), 60, 60);
		API.Images.setImage(label_1, getClass().getResource("/multimedia/imagens/" + jogador));
		contentPane.add(label_1);
		
		contentPane.remove(label_2);
		label_2 = new JLabel();
		label_2.setBounds(268+(80*countplac)-(40*(y-6)), 100-(35*(x-7)), 60, 60);
		API.Images.setImage(label_2, getClass().getResource("/multimedia/imagens/" + jogador));
		contentPane.add(label_2);
		
		repaint();
		
	}
	
	private void checktable(int pecas, int lin, String player) {
		
		if (pecas < x) {
    		int locat = 610-(70*pecas)-(35*((x-7)*-2));
    		label_2.setVisible(false);
    		
        	Thread th = new Thread() {
                @Override
                public void run(){
                    try {
                        
                        for ( int i = 100; i <= locat; i++){
                            Thread.sleep(1);
                            label_1.setBounds(268+(80*lin)-(40*(y-6)), i-(35*(x-7)), 60, 60);
                            
                            if (i == locat) {
                            	
                            	try {  API.Sounds.PlaySound("/multimedia/audios/piece_dropped.wav", soundfile);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {e1.printStackTrace();}
                            	
                            	chekagens();
                            	changePl();
                            	
                            	label_1 = new JLabel();
	            	    		label_1.setBounds(268-(40*(y-6)), 100-(35*(x-7)), 60, 60);
	            	    		API.Images.setImage(label_1, getClass().getResource("/multimedia/imagens/" + player));
	            	    		contentPane.add(label_1);
	            	    		
	            	    		
	            	    		if (!player4.equals("")) {
	            	            	if (jogador.equals(image1)) {
	            	            		jogador = image2;

		            	            	updateball();

		            	            	if(botfacil2) {
		            	    				botestupido();
		            	    			}else if(botnormal2) {
		            	    				botnormal();
		            	    			}else if(botmedio2) {
		            	    				botmedio();
		            	    			}else if(botdificil2) {
		            	    				bothard();
		            	    			}
		            	            	
	            	            		label_2.setVisible(false);
		            	            	listening = false;
		                            	listeningmous = false;
	            	        		}
	            	        		else {
	            	        			if (jogador.equals(image2)) {
	            	        				jogador = image3;

	    	            	            	updateball();

	    	            	            	if(botfacil3) {
	    	            	    				botestupido();
	    	            	    			}else if(botnormal3) {
	    	            	    				botnormal();
	    	            	    			}else if(botmedio3) {
	    	            	    				botmedio();
	    	            	    			}else if(botdificil3) {
	    	            	    				bothard();
	    	            	    			}
	    	            	            	
	            	        				label_2.setVisible(false);
	    	            	            	listening = false;
	    	                            	listeningmous = false;
	            	        			}else {
	            	        				if (jogador.equals(image3)) {
	            	        					jogador = image4;

	        	            	            	updateball();

	        	            	            	if(botfacil4) {
	        	            	    				botestupido();
	        	            	    			}else if(botnormal4) {
	        	            	    				botnormal();
	        	            	    			}else if(botmedio4) {
	        	            	    				botmedio();
	        	            	    			}else if(botdificil4) {
	        	            	    				bothard();
	        	            	    			}
	        	            	            	
	            	        					label_2.setVisible(false);
	        	            	            	listening = false;
	        	                            	listeningmous = false;
	            	        				}else {
	            	        					jogador = image1;
	            	        					
	            	        					updateball();
	        	            	            	
	        	            	            	label_2.setVisible(true);
	        	            	            	listening = true;
	        	                            	listeningmous = true;
	            	        				}
	            	        			}
	            	        		}
	            	            }else {
	            	            	if (!player3.equals("")) {
	            	            		if (jogador.equals(image1)) {
	            	            			jogador = image2;

	    	            	            	updateball();

	    	            	            	if(botfacil2) {
	    	            	    				botestupido();
	    	            	    			}else if(botnormal2) {
	    	            	    				botnormal();
	    	            	    			}else if(botmedio2) {
	    	            	    				botmedio();
	    	            	    			}else if(botdificil2) {
	    	            	    				bothard();
	    	            	    			}
	    	            	            	
	            	            			label_2.setVisible(false);
	    	            	            	listening = false;
	    	                            	listeningmous = false;
	            	            		}
	            	            		else {
	            	            			if (jogador.equals(image2)) {
	            	            				jogador = image3;

	        	            	            	updateball();

	        	            	            	if(botfacil3) {
	        	            	    				botestupido();
	        	            	    			}else if(botnormal3) {
	        	            	    				botnormal();
	        	            	    			}else if(botmedio3) {
	        	            	    				botmedio();
	        	            	    			}else if(botdificil3) {
	        	            	    				bothard();
	        	            	    			}
	        	            	            	
	            	            				label_2.setVisible(false);
	        	            	            	listening = false;
	        	                            	listeningmous = false;
	            	            			}else {
	            	            				jogador = image1;
	            	            				
	            	            				updateball();
	        	            	            	
	        	            	            	label_2.setVisible(true);
	        	            	            	listening = true;
	        	                            	listeningmous = true;
	            	            			}
	            	            		}
	            	            	}else {
	            	            		if (jogador.equals(image1)) {
	            	            			jogador = image2;

	    	            	            	updateball();

	    	            	            	if(botfacil2) {
	    	            	    				botestupido();
	    	            	    			}else if(botnormal2) {
	    	            	    				botnormal();
	    	            	    			}else if(botmedio2) {
	    	            	    				botmedio();
	    	            	    			}else if(botdificil2) {
	    	            	    				bothard();
	    	            	    			}
	    	            	            	
	            	            			label_2.setVisible(false);
	    	            	            	listening = false;
	    	                            	listeningmous = false;
	            	            		}
	            	            		else {
	            	            			jogador = image1;
	            	            			
	            	            			updateball();
	    	            	            	
	    	            	            	label_2.setVisible(true);
	    	            	            	listening = true;
	    	                            	listeningmous = true;
	            	            		}
	            	            	}
	            	            }
	            	    		
	            	    		//System.out.println(game.myBord.toString());
                            }
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e);
                    }
                }
            };th.start();
            
            listening = false;
            listeningmous = false;
    	}
		
	}
	
	public void changePl() {
		if (!player4.equals("")) {
        	if (game.activePlayer == game.player1) {
    			game.activePlayer = game.player2;
    			game.notactivePlayer = game.player1;
    		}
    		else {
    			if (game.activePlayer == game.player2) {
    				game.activePlayer = game.player3;
    				game.notactivePlayer = game.player1;
    			}else {
    				if (game.activePlayer == game.player3) {
    					game.activePlayer = game.player4;
    					game.notactivePlayer = game.player1;
    				}else {
    					game.activePlayer = game.player1;
    					game.notactivePlayer = game.player2;
    				}
    			}
    		}
        }else {
        	if (!player3.equals("")) {
        		if (game.activePlayer == game.player1) {
        			game.activePlayer = game.player2;
        			game.notactivePlayer = game.player1;
        		}
        		else {
        			if (game.activePlayer == game.player2) {
        				game.activePlayer = game.player3;
        				game.notactivePlayer = game.player1;
        			}else {
        				game.activePlayer = game.player1;
        				game.notactivePlayer = game.player2;
        			}
        		}
        	}else {
        		if (game.activePlayer == game.player1) {
        			game.activePlayer = game.player2;
        			game.notactivePlayer = game.player1;
        		}
        		else {
        			game.activePlayer = game.player1;
        			game.notactivePlayer = game.player2;
        		}
        	}
        }
	}
	
	public void chekagens() {
		if (game.myBord.isWinner(game.activePlayer, linha)) {
			String jogadore = "";
			
			if(game.activePlayer.getTxt().equals("#")) {
				jogadore = jogadoresnames[0];
			}else {
				if(game.activePlayer.getTxt().equals("@")) {
					jogadore = jogadoresnames[1];
				}else {
					if(game.activePlayer.getTxt().equals("&")) {
						jogadore = jogadoresnames[2];
					}else {
						jogadore = jogadoresnames[3];
					}
				}
			}
			
			if (jogadore == jogadoresnames[0]) {
				try {  API.Sounds.PlaySound("/multimedia/audios/win_game.wav", soundfile);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {e1.printStackTrace();}
			}else {
				try {  API.Sounds.PlaySound("/multimedia/audios/lose_game.wav", soundfile);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {e1.printStackTrace();}
			}
			
			PopupOneOption dialog = new PopupOneOption(this, jogadore + " Venceu !!!", soundfile);
    		dialog.run(widthfile, heightfile);
			
			
			PopupTwoOptions fram = new PopupTwoOptions(this, "Quer voltar a jogar com as mesmas opções?", soundfile);
        	
        	try {
				game.restart();
			} catch (FILException e1) {e1.printStackTrace();}
        	
			if(fram.run(widthfile, heightfile)) {
				try {
					setLoca(getLocation());
					listening = false;
					listeningmous = false;
					clipTimePostion = clip.getMicrosecondPosition();
					clip.stop();
					BeginGameBot frm = new BeginGameBot();
					frm.setVisible(true);
					
					dispose();
				} catch (API.FILException e) {
					e.printStackTrace();
				}
			}else {
				botfacil2 = false;
	        	botnormal2 = false;
	        	botmedio2 = false;
	        	botdificil2 = false;
	        	botfacil3 = false;
	        	botnormal3 = false;
	        	botmedio3 = false;
	        	botdificil3 = false;
	        	botfacil4 = false;
	        	botnormal4 = false;
	        	botmedio4 = false;
	        	botdificil4 = false;
				
				setLoca(getLocation());
				listening = false;
				listeningmous = false;
				clipTimePostion = clip.getMicrosecondPosition();
				clip.stop();
				SinglePlayerOptions frm = new SinglePlayerOptions();
				frm.setVisible(true);
				
				dispose();
			}
        }
        if (game.myBord.isFull()) {
        	try {  API.Sounds.PlaySound("/multimedia/audios/lose_game.wav", soundfile);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {e1.printStackTrace();}
        	
        	PopupOneOption dialog = new PopupOneOption(this, "Empate !!!", soundfile);
    		dialog.run(widthfile, heightfile);
        	
        	
        	PopupTwoOptions fram = new PopupTwoOptions(this, "Quer voltar a jogar com as mesmas opções?", soundfile);
			
        	try {
				game.restart();
			} catch (FILException e1) {e1.printStackTrace();}
			
			if(fram.run(widthfile, heightfile)) {
				try {
					setLoca(getLocation());
					listening = false;
					listeningmous = false;
					clipTimePostion = clip.getMicrosecondPosition();
					clip.stop();
					BeginGameBot frm = new BeginGameBot();
					frm.setVisible(true);
					
					dispose();
				} catch (API.FILException e) {
					e.printStackTrace();
				}
			}else {
				botfacil2 = false;
	        	botnormal2 = false;
	        	botmedio2 = false;
	        	botdificil2 = false;
	        	botfacil3 = false;
	        	botnormal3 = false;
	        	botmedio3 = false;
	        	botdificil3 = false;
	        	botfacil4 = false;
	        	botnormal4 = false;
	        	botmedio4 = false;
	        	botdificil4 = false;
				
				setLoca(getLocation());
				listening = false;
				listeningmous = false;
				clipTimePostion = clip.getMicrosecondPosition();
				clip.stop();
				SinglePlayerOptions frm = new SinglePlayerOptions();
				frm.setVisible(true);
				
				dispose();
			}
        }
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
	
	private void exit() {
		listening = false;
		listeningmous = false;
		PopupTwoOptions fram = new PopupTwoOptions(this, "Tem a certeza que pretende sair ?", soundfile);
		
		if(fram.run(widthfile, heightfile)) {
			System.exit(0);
		}
		listening = true;
		listeningmous = true;
    }
	
	private void back() {
		PopupTwoOptions fram = new PopupTwoOptions(this, "Deseja sair do jogo atual ?", soundfile);
    	
		
		if(fram.run(widthfile, heightfile)) {
			try {
				game.restart();
			} catch (FILException e1) {e1.printStackTrace();}
			
			botfacil2 = false;
        	botnormal2 = false;
        	botmedio2 = false;
        	botdificil2 = false;
        	botfacil3 = false;
        	botnormal3 = false;
        	botmedio3 = false;
        	botdificil3 = false;
        	botfacil4 = false;
        	botnormal4 = false;
        	botmedio4 = false;
        	botdificil4 = false;
			
			setLoca(getLocation());
			listening = false;
			listeningmous = false;
			clipTimePostion = clip.getMicrosecondPosition();
			clip.stop();
			SinglePlayerOptions frm = new SinglePlayerOptions();
			frm.setVisible(true);
			
			dispose();
		}
	}
	
	public static void setSinglePlayerOption(boolean singleplayeroptiongui1) {
		singleplayeroptiongui = singleplayeroptiongui1;
	}
	
	public static void setBotfacil2(boolean botfacil2) {
		BeginGameBot.botfacil2 = botfacil2;
	}

	public static void setBotnormal2(boolean botnormal2) {
		BeginGameBot.botnormal2 = botnormal2;
	}

	public static void setBotmedio2(boolean botmedio2) {
		BeginGameBot.botmedio2 = botmedio2;
	}

	public static void setBotdificil2(boolean botdificil2) {
		BeginGameBot.botdificil2 = botdificil2;
	}
	
	public static void setBotfacil3(boolean botfacil3) {
		BeginGameBot.botfacil3 = botfacil3;
	}

	public static void setBotnormal3(boolean botnormal3) {
		BeginGameBot.botnormal3 = botnormal3;
	}

	public static void setBotmedio3(boolean botmedio3) {
		BeginGameBot.botmedio3 = botmedio3;
	}

	public static void setBotdificil3(boolean botdificil3) {
		BeginGameBot.botdificil3 = botdificil3;
	}
	
	public static void setBotfacil4(boolean botfacil4) {
		BeginGameBot.botfacil4 = botfacil4;
	}

	public static void setBotnormal4(boolean botnormal4) {
		BeginGameBot.botnormal4 = botnormal4;
	}

	public static void setBotmedio4(boolean botmedio4) {
		BeginGameBot.botmedio4 = botmedio4;
	}

	public static void setBotdificil4(boolean botdificil4) {
		BeginGameBot.botdificil4 = botdificil4;
	}

	public static void setX(int x) {
		BeginGameBot.x = x;
	}

	public static void setY(int y) {
		BeginGameBot.y = y;
	}

	public static void setLinha(int linha) {
		BeginGameBot.linha = linha;
	}

	public static void setPlayer1(String player1) {
		BeginGameBot.player1 = player1;
	}

	public static void setPlayer2(String player2) {
		BeginGameBot.player2 = player2;
	}

	public static void setPlayer3(String player3) {
		BeginGameBot.player3 = player3;
	}

	public static void setPlayer4(String player4) {
		BeginGameBot.player4 = player4;
	}
	
	public static void setJogador1nome(String jogador1nome) {
		BeginGameBot.jogador1nome = jogador1nome;
	}

	public static void setJogador2nome(String jogador2nome) {
		BeginGameBot.jogador2nome = jogador2nome;
	}

	public static void setJogador3nome(String jogador3nome) {
		BeginGameBot.jogador3nome = jogador3nome;
	}

	public static void setJogador4nome(String jogador4nome) {
		BeginGameBot.jogador4nome = jogador4nome;
	}
	
	public static void setImage1(String image1) {
		BeginGameBot.image1 = image1;
	}

	public static void setImage2(String image2) {
		BeginGameBot.image2 = image2;
	}

	public static void setImage3(String image3) {
		BeginGameBot.image3 = image3;
	}

	public static void setImage4(String image4) {
		BeginGameBot.image4 = image4;
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
	    
	    
	}

	@Override
	public void componentShown(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
