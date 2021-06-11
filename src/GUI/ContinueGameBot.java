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
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JSlider;

public class ContinueGameBot extends JFrame {
	
	protected static ContinueGameBot frame;
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
	private int x;
	private int y;
	private int countplac = 0;
	private String jogador;
	private String player1;
	private String player2;
	private String player3;
	private String player4;
	private String[] jogadores;
	private String[] players;
	private String image1;
	private String image2;
	private String image3;
	private String image4;
	private static Point loc;
	private static boolean bool;
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
	private static boolean playoptiongui;
	private static long clipTimePostion;
	private static boolean playop;
	private static boolean continuegame;
	private int numlinha = 4;
	private int temp = -1;
	private static boolean botfacil2 = false;
	private static boolean botnormal2 = false;
	private static boolean botmedio2 = false;
	private static boolean botdificil2 = false;
	private static boolean botfacil3 = false;
	private static boolean botnormal3 = false;
	private static boolean botmedio3 = false;
	private static boolean botdificil3 = false;
	private static boolean botfacil4 = false;
	private static boolean botnormal4 = false;
	private static boolean botmedio4 = false;
	private static boolean botdificil4 = false;
	private String[] jogadoresnames;
	private int change;

	/**
	 * Create the frame.
	 * @throws API.FILException 
	 */
	public ContinueGameBot() throws API.FILException {
		
		bool = true;
		
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
		                    	
		                    	try {  API.Sounds.PlaySound("/multimedia/audios/piece_change.wav", soundfile);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {e1.printStackTrace();}
		                    	
				        	}else if (ke.getKeyCode() == vk1) {
				        		
				        		countplac--;
				        		if(countplac < 0)
		                    		countplac = y-1;
				        		
				        		updateball();
				        		
				        		try {  API.Sounds.PlaySound("/multimedia/audios/piece_change.wav", soundfile);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {e1.printStackTrace();}
				        		
				        	}else if (ke.getKeyCode() == vk3) {
	                        	
				        		try {
									dropPec(countplac);
								} catch (FILException e) {
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
			
			if(playoptiongui) {
				while (PlayOption.getTimeMusic() > (34360748*count1)) {
					count++;
					count1++;
					count2 = count;
					count3 = count1;
				}
				clip.setMicrosecondPosition(PlayOption.getTimeMusic() - (34360748*count));
			}else {
				while (ContinueGameBot.getTimeMusic() > (34360748*count3)) {
					count2++;
					count3++;
					count = count2;
					count1 = count3;
				}
				clip.setMicrosecondPosition(ContinueGameBot.getTimeMusic() - (34360748*count2));
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
		
		if(playoptiongui) {
			Point loc1 = PlayOption.getLoca();
			setBounds(loc1.x, loc1.y, widthfile, heightfile);
			setPlayOption(false);
		}else {
			Point loc2 = ContinueGameBot.getLoca();
			setBounds(loc2.x, loc2.y, widthfile, heightfile);
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
		
		String[] str = new String[] {};
		try {
			str = API.Fichi.read("jogo_salvo.ap").split("\n");
		}catch(IOException e){
			JOptionPane.showMessageDialog(this, "Não existe um jogo salvo.");
			dispose();
		}
		String[] size = str[1].split(",");
		String[] playermatr = str[2].split(",");
		jogadoresnames = str[3].split(",");
		String[] ball = str[4].split(",");
		
		
		try {
			player1 = playermatr[0];
			player2 = playermatr[1];
			player3 = playermatr[2];
			player4 = playermatr[3];
		}catch (ArrayIndexOutOfBoundsException e){
			try {
				player1 = playermatr[0];
				player2 = playermatr[1];
				player3 = playermatr[2];
				player4 = "";
			}catch (ArrayIndexOutOfBoundsException e1){
				player1 = playermatr[0];
				player2 = playermatr[1];
				player3 = "";
				player4 = "";
			}
		}
		
		
		if (!player4.equals("")) {
			
			jogadores = new String[4];
    		jogadores[0] = ball[0];
    		jogadores[1] = ball[1];
    		jogadores[2] = ball[2];
    		jogadores[3] = ball[3];
    		
    		players = new String[4];
    		players[0] = player1;
    		players[1] = player2;
    		players[2] = player3;
    		players[3] = player4;
    		
        }else {
        	if (!player3.equals("")) {
        		
        		jogadores = new String[3];
        		jogadores[0] = ball[0];
        		jogadores[1] = ball[1];
        		jogadores[2] = ball[2];
        		
        		players = new String[3];
        		players[0] = player1;
        		players[1] = player2;
        		players[2] = player3;
        		
        	}else {
        		jogadores = new String[2];
        		jogadores[0] = ball[0];
        		jogadores[1] = ball[1];
        		
        		players = new String[2];
        		players[0] = player1;
        		players[1] = player2;
        	}
        }
		
		
		try {
			image1 = ball[0];
			image2 = ball[1];
			image3 = ball[2];
			image4 = ball[3];
		}catch (ArrayIndexOutOfBoundsException e){
			try {
				image1 = ball[0];
				image2 = ball[1];
				image3 = ball[2];
			}catch (ArrayIndexOutOfBoundsException e1){
				image1 = ball[0];
				image2 = ball[1];
			}
		}
		
		x = Integer.parseInt(size[0]);
		y = Integer.parseInt(size[1]);
		
		if(game == null)
			game = new API.FILGame(x, y, player1, player2, player3, player4);
		
		//cria table
		int hei = 0;
		int wit = 0;
		for(int i = 0; i < x; i++) {
			for(int j = 0; j < y; j++) {

				label = new JLabel();
				label.setBounds(260+wit-(40*(y-6)), 180+hei-(35*(x-7)), 80, 70);
				API.Images.setImage(label, getClass().getResource("/multimedia/imagens/space_game.png"));
				contentPane.add(label);
				
				String[] chklin = str[5+i].split(" ");
				if(chklin[j].equals("#")) {
					label_3 = new JLabel();
					label_3.setBounds(268+wit-(40*(y-6)), 190+hei-(35*(x-7)), 60, 60);
					API.Images.setImage(label_3, getClass().getResource("/multimedia/imagens/" + image1));
					contentPane.add(label_3);
					
					if (!game.activePlayer.getTxt().equals("#")) {
						API.Piece pic = new API.Piece("#");
						game.activePlayer = pic;
					}
					
					validation(j);
					
				}else if(chklin[j].equals("@")) {
					label_3 = new JLabel();
					label_3.setBounds(268+wit-(40*(y-6)), 190+hei-(35*(x-7)), 60, 60);
					API.Images.setImage(label_3, getClass().getResource("/multimedia/imagens/" + image2));
					contentPane.add(label_3);
					
					if (!game.activePlayer.getTxt().equals("@")) {
						API.Piece pic = new API.Piece("@");
						game.activePlayer = pic;
					}
					
					validation(j);
					
				}else if(chklin[j].equals("&")) {
					label_3 = new JLabel();
					label_3.setBounds(268+wit-(40*(y-6)), 190+hei-(35*(x-7)), 60, 60);
					API.Images.setImage(label_3, getClass().getResource("/multimedia/imagens/" + image3));
					contentPane.add(label_3);
					
					if (!game.activePlayer.getTxt().equals("&")) {
						API.Piece pic = new API.Piece("&");
						game.activePlayer = pic;
					}
					
					validation(j);
					
				}else if(chklin[j].equals("$")) {
					label_3 = new JLabel();
					label_3.setBounds(268+wit-(40*(y-6)), 190+hei-(35*(x-7)), 60, 60);
					API.Images.setImage(label_3, getClass().getResource("/multimedia/imagens/" + image4));
					contentPane.add(label_3);
					
					if (!game.activePlayer.getTxt().equals("$")) {
						API.Piece pic = new API.Piece("$");
						game.activePlayer = pic;
					}
					
					validation(j);
					
				}
				
				wit += 80;
			}
			hei += 70;
			wit = 0;
		}
		
		//ler do ficheiro
		for(int i = x; i > 0; i--) {
			for(int j = 0; j < y; j++) {
				
				String[] chklin = str[4+i].split(" ");
				if(chklin[j].equals("#")) {
					
					if (!game.activePlayer.getTxt().equals("#")) {
						API.Piece pic = new API.Piece("#");
						game.activePlayer = pic;
					}
					
					game.playPiece(j);
					chekagens();
				}else if(chklin[j].equals("@")) {
					
					if (!game.activePlayer.getTxt().equals("@")) {
						API.Piece pic = new API.Piece("@");
						game.activePlayer = pic;
					}
					
					game.playPiece(j);
					chekagens();
				}else if(chklin[j].equals("&")) {
					
					if (!game.activePlayer.getTxt().equals("&")) {
						API.Piece pic = new API.Piece("&");
						game.activePlayer = pic;
					}
					
					game.playPiece(j);
					chekagens();
				}else if(chklin[j].equals("$")) {
					
					if (!game.activePlayer.getTxt().equals("$")) {
						API.Piece pic = new API.Piece("$");
						game.activePlayer = pic;
					}
					
					game.playPiece(j);
					chekagens();
				}
			}
		}
		
		game.activePlayer = new API.Piece(str[11]);
		
		if(game.activePlayer.getTxt().equals("@")) {
			label_1 = new JLabel();
			label_1.setBounds(268-(40*(y-6)), 100-(35*(x-7)), 60, 60);
			API.Images.setImage(label_1, getClass().getResource("/multimedia/imagens/" + image2));
			contentPane.add(label_1);
			
			label_2 = new JLabel();
			label_2.setBounds(268-(40*(y-6)), 100-(35*(x-7)), 60, 60);
			API.Images.setImage(label_2, getClass().getResource("/multimedia/imagens/" + image2));
			contentPane.add(label_2);
			
			jogador = image2;
			
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
    		
    		jogador = image3;
    		
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
						try {
							if(listeningmous) {
								dropPec(i);
								listeningmous = false;
							}
						} catch (FILException e1) {
							listeningmous = true;
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
			} catch (FILException e) {
				e.printStackTrace();
				continue;
			}
		}
	}
	
	public void botnormal() {
		int block = game.myBord.chekagembotnormal(game.notactivePlayer, game.activePlayer, numlinha-1, temp);
		//System.out.println(block);
		if(block >= 0) {
			temp = block;
			try {
				dropPec(block);
			} catch (FILException e) {
				e.printStackTrace();
				int j = 0;
				while(true) {
					try {
						dropPec(j);
						break;
					} catch (FILException e1) {
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
				} catch (FILException e) {
					e.printStackTrace();
					continue;
				}
			}
		}
	}
	
	public void botmedio() {
		int block = game.myBord.chekagembotmedio(game.notactivePlayer, game.activePlayer, numlinha-1, temp);
		//System.out.println(block);
		if(block >= 0) {
			temp = block;
			try {
				dropPec(block);
			} catch (FILException e) {
				e.printStackTrace();
				int j = 0;
				while(true) {
					try {
						dropPec(j);
						break;
					} catch (FILException e1) {
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
				} catch (FILException e) {
					e.printStackTrace();
					continue;
				}
			}
		}
	}
	
	public void bothard() {
		int block = game.myBord.chekagembothard(game.notactivePlayer, game.activePlayer, numlinha-1, temp);
		//System.out.println(block);
		if(block >= 0) {
			temp = block;
			try {
				dropPec(block);
			} catch (FILException e) {
				e.printStackTrace();
				int j = 0;
				while(true) {
					try {
						dropPec(j);
						break;
					} catch (FILException e1) {
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
				} catch (FILException e) {
					e.printStackTrace();
					continue;
				}
			}
		}
	}
	
	private void dropPec(int num) throws API.FILException {
		
		switch (num) {
    	case 0:
    		checktable(pecs0, num, jogador);
			game.playPiece(num);
    		break;
    	case 1:
    		checktable(pecs1, num, jogador);
    		game.playPiece(num);
    		break;
    	case 2:
    		checktable(pecs2, num, jogador);
			game.playPiece(num);
    		break;
    	case 3:
    		checktable(pecs3, num, jogador);
			game.playPiece(num);
    		break;
    	case 4:
    		checktable(pecs4, num, jogador);
			game.playPiece(num);
    		break;
    	case 5:
    		checktable(pecs5, num, jogador);
			game.playPiece(num);
    		break;
    	case 6:
    		checktable(pecs6, num, jogador);
			game.playPiece(num);
    		break;
    	case 7:
    		checktable(pecs7, num, jogador);
			game.playPiece(num);
    		break;
    	case 8:
    		checktable(pecs8, num, jogador);
			game.playPiece(num);
    		break;
    	case 9:
    		checktable(pecs9, num, jogador);
			game.playPiece(num);
    		break;
    	}
		
	}
	
	private void validation(int inte) {
		switch (inte) {
    	case 0:
    		pecs0++;
    		break;
    	case 1:
    		pecs1++;
    		break;
    	case 2:
    		pecs2++;
    		break;
    	case 3:
    		pecs3++;
    		break;
    	case 4:
    		pecs4++;
    		break;
    	case 5:
    		pecs5++;
    		break;
    	case 6:
    		pecs6++;
    		break;
    	case 7:
    		pecs7++;
    		break;
    	case 8:
    		pecs8++;
    		break;
    	case 9:
    		pecs9++;
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
                            	
                            	validation(lin);
                            	chekagens();
                            	
                            	if(change == 0) {
                                	changePl();
                                	change = 1;
                            	}else {
                            		changePl();
                            	}
                            	
                            	label_1 = new JLabel();
	            	    		label_1.setBounds(268-(40*(y-6)), 100-(35*(x-7)), 60, 60);
	            	    		API.Images.setImage(label_1, getClass().getResource("/multimedia/imagens/" + player));
	            	    		contentPane.add(label_1);
	            	    		
	            	    		
	            	    		if (!player4.equals("")) {
	            	            	if (jogador.equals(image1)) {
	            	            		jogador = image2;

		            	            	updateball();
		            	            	
		            	            	if(change == 1) {
		            	            		changePl();
		            	            		change = 2;
		            	            	}
		            	            	
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

	    	            	            	if(change == 1) {
			            	            		changePl();
			            	            		change = 2;
			            	            	}
			            	            	
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

		    	            	            	if(change == 1) {
				            	            		changePl();
				            	            		change = 2;
				            	            	}
				            	            	
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

	    	            	            	if(change == 1) {
			            	            		changePl();
			            	            		change = 2;
			            	            	}
			            	            	
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

		    	            	            	if(change == 1) {
				            	            		changePl();
				            	            		change = 2;
				            	            	}
				            	            	
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
	    	            	            	
	    	            	            	if(change == 1) {
			            	            		changePl();
			            	            		change = 2;
			            	            	}
			            	            	
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
		if (game.myBord.isWinner(game.activePlayer, numlinha)) {
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
			
			JOptionPane.showMessageDialog(this, jogadore + " Wins !!!");
			
			
			Popup fram = new Popup(this, "Quer voltar a jogar a partir do último jogo salvo?", soundfile);
			
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
					setPlayOption(false);
					ContinueGameBot frm = new ContinueGameBot();
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
				setPlayOption(false);
				PlayOption frm = new PlayOption();
				frm.setVisible(true);
				
				dispose();
			}
			
        }
		
        if (game.myBord.isFull()) {
        	JOptionPane.showMessageDialog(this, "Tie Game !!!");
        	
        	Popup fram = new Popup(this, "Quer voltar a jogar a partir do último jogo salvo?", soundfile);
			
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
					setPlayOption(false);
					ContinueGameBot frm = new ContinueGameBot();
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
				setPlayOption(false);
				PlayOption frm = new PlayOption();
				frm.setVisible(true);
				
				dispose();
			}
        	
        }
        
	}
	
	private void exit() {
		listening = false;
		listeningmous = false;
		Popup fram = new Popup(this, "Tem a certeza que pretende sair ?", soundfile);
		
		if(fram.run(widthfile, heightfile)) {
			System.exit(0);
		}
		listening = true;
		listeningmous = true;
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
	
	public static void setPlayop(boolean playop1) {
		playop = playop1;
	}
	
	public static void setNewGame(boolean continuegame1) {
		continuegame = continuegame1;
	}
	
	public static void setPlayOption(boolean playoptiongui1) {
		playoptiongui = playoptiongui1;
	}
	
	public static void setBotfacil2(boolean botfacil2) {
		ContinueGameBot.botfacil2 = botfacil2;
	}

	public static void setBotnormal2(boolean botnormal2) {
		ContinueGameBot.botnormal2 = botnormal2;
	}

	public static void setBotmedio2(boolean botmedio2) {
		ContinueGameBot.botmedio2 = botmedio2;
	}

	public static void setBotdificil2(boolean botdificil2) {
		ContinueGameBot.botdificil2 = botdificil2;
	}
	
	public static void setBotfacil3(boolean botfacil3) {
		ContinueGameBot.botfacil3 = botfacil3;
	}

	public static void setBotnormal3(boolean botnormal3) {
		ContinueGameBot.botnormal3 = botnormal3;
	}

	public static void setBotmedio3(boolean botmedio3) {
		ContinueGameBot.botmedio3 = botmedio3;
	}

	public static void setBotdificil3(boolean botdificil3) {
		ContinueGameBot.botdificil3 = botdificil3;
	}
	
	public static void setBotfacil4(boolean botfacil4) {
		ContinueGameBot.botfacil4 = botfacil4;
	}

	public static void setBotnormal4(boolean botnormal4) {
		ContinueGameBot.botnormal4 = botnormal4;
	}

	public static void setBotmedio4(boolean botmedio4) {
		ContinueGameBot.botmedio4 = botmedio4;
	}

	public static void setBotdificil4(boolean botdificil4) {
		ContinueGameBot.botdificil4 = botdificil4;
	}
	
}
