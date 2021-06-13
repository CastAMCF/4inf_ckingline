package GUI;

import java.awt.Graphics;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.Point;
import java.awt.SystemColor;
import java.awt.Toolkit;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import API.FILException;

public class BeginGameMulti extends JFrame {
	
	private static BeginGameMulti frame;
	private JPanel contentPane;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_4;
	private boolean listening = true;
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
	private String[] jogadoresnames;
	private static boolean bool;
	private static Point loc;
	private static boolean multiplayeroptiongui;
	private int wit;
	private int hei;

	/**
	 * Create the frame.
	 * @throws FILException 
	 */
	public BeginGameMulti() throws API.FILException {
		
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
	                        	
				        		
	                        	API.Fichi.write("jogo_salvo.ap", "multi\n" + sizet + playert + jogadorsnames + jogadort + game.myBord.toString() + game.activePlayer.getTxt());
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
			
			if(multiplayeroptiongui) {
				while (MultiPlayerOptions.getTimeMusic() > (34360748*count1)) {
					count++;
					count1++;
					count2 = count;
					count3 = count1;
				}
				clip.setMicrosecondPosition(MultiPlayerOptions.getTimeMusic() - (34360748*count));
				multiplayeroptiongui = false;
			}else {
				while (BeginGameMulti.getTimeMusic() > (34360748*count3)) {
					count2++;
					count3++;
					count = count2;
					count1 = count3;
				}
				clip.setMicrosecondPosition(BeginGameMulti.getTimeMusic() - (34360748*count2));
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
		
		boolean multiplatop = MultiPlayerOptions.getBool();
		
		if(multiplatop) {
			Point loc = MultiPlayerOptions.getLoca();
			setBounds(loc.x, loc.y, widthfile, heightfile);
			MultiPlayerOptions.setBool(false);
		}else {
			Point loc = BeginGameMulti.getLoca();
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
		
		switch(this.getWidth()) {
		case 1024:
			hei = 0;
			wit = 0;
			break;
		case 1152:
			hei = 64;
			wit = 64;
			break;
		case 1280:
			hei = 128;
			wit = 128;
			break;
		}
		
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
		label_back.setBounds(744, 661+hei, 236, 92);
		API.Images.setImage(label_back, getClass().getResource("/multimedia/imagens/button_back_exited.png"));
		contentPane.add(label_back);
		
		
		int alt = 0;
		for(int i = 0; i < x; i++) {
			for(int j = 0; j < y; j++) {
				label = new JLabel();
				label.setBounds(260+wit-(40*(y-6)), 180+hei-(35*(x-7)), 80, 70);
				API.Images.setImage(label, getClass().getResource("/multimedia/imagens/space_game.png"));
				contentPane.add(label);
				wit += 80;
			}
			hei += 70;
			alt += 70;
			switch(this.getWidth()) {
			case 1024:
				wit = 0;
				break;
			case 1152:
				wit = 64;
				break;
			case 1280:
				wit = 128;
				break;
			}
		}
		
		switch(this.getWidth()) {
		case 1024:
			hei = 0;
			break;
		case 1152:
			hei = 64;
			break;
		case 1280:
			hei = 128;
			break;
		}
		
		if(game.activePlayer.getTxt().equals("@")) {
			label_1 = new JLabel();
			label_1.setBounds(268+wit-(40*(y-6)), 100+hei-(35*(x-7)), 60, 60);
			API.Images.setImage(label_1, getClass().getResource("/multimedia/imagens/" + image2));
			contentPane.add(label_1);
			
			label_2 = new JLabel();
			label_2.setBounds(268+wit-(40*(y-6)), 100+hei-(35*(x-7)), 60, 60);
			API.Images.setImage(label_2, getClass().getResource("/multimedia/imagens/" + image2));
			contentPane.add(label_2);
			
			jogador =  image2;
        }else if (game.activePlayer.getTxt().equals("&")) {
        	label_1 = new JLabel();
    		label_1.setBounds(268+wit-(40*(y-6)), 100+hei-(35*(x-7)), 60, 60);
    		API.Images.setImage(label_1, getClass().getResource("/multimedia/imagens/" + image3));
    		contentPane.add(label_1);
    		
    		label_2 = new JLabel();
    		label_2.setBounds(268+wit-(40*(y-6)), 100-(35*(x-7)), 60, 60);
    		API.Images.setImage(label_2, getClass().getResource("/multimedia/imagens/" + image3));
    		contentPane.add(label_2);
    		
    		jogador =  image3;
        }else if (game.activePlayer.getTxt().equals("$")) {
        	label_1 = new JLabel();
    		label_1.setBounds(268+wit-(40*(y-6)), 100+hei-(35*(x-7)), 60, 60);
    		API.Images.setImage(label_1, getClass().getResource("/multimedia/imagens/" + image4));
    		contentPane.add(label_1);
    		
    		label_2 = new JLabel();
    		label_2.setBounds(268+wit-(40*(y-6)), 100+hei-(35*(x-7)), 60, 60);
    		API.Images.setImage(label_2, getClass().getResource("/multimedia/imagens/" + image4));
    		contentPane.add(label_2);
    		
    		jogador = image4;
        }else {
        	label_1 = new JLabel();
    		label_1.setBounds(268+wit-(40*(y-6)), 100+hei-(35*(x-7)), 60, 60);
    		API.Images.setImage(label_1, getClass().getResource("/multimedia/imagens/" + image1));
    		contentPane.add(label_1);
    		
    		label_2 = new JLabel();
    		label_2.setBounds(268+wit-(40*(y-6)), 100+hei-(35*(x-7)), 60, 60);
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
			label_4.setBounds(268+wit-(40*(y-6)), 100+hei-(35*(x-7)), 60, 60+alt);
			contentPane.add(label_4);
			
			wit += 80;
		}
		
		switch(this.getWidth()) {
		case 1024:
			wit = 0;
			break;
		case 1152:
			wit = 64;
			break;
		case 1280:
			wit = 128;
			break;
		}
		
	}
	
	private void dropPec(int num) throws API.FILException{
		
		switch (num) {
    	case 0:
    		checktable(pecs0, num, jogador);
			game.playPiece(num);
			pecs0++;
    		break;
    	case 1:
    		checktable(pecs1, num, jogador);
			game.playPiece(num);
			pecs1++;
    		break;
    	case 2:
    		checktable(pecs2, num, jogador);
    		game.playPiece(num);
    		pecs2++;
    		break;
    	case 3:
    		checktable(pecs3, num, jogador);
    		game.playPiece(num);
    		pecs3++;
    		break;
    	case 4:
    		checktable(pecs4, num, jogador);
    		game.playPiece(num);
    		pecs4++;
    		break;
    	case 5:
    		checktable(pecs5, num, jogador);
    		game.playPiece(num);
    		pecs5++;
    		break;
    	case 6:
    		checktable(pecs6, num, jogador);
    		game.playPiece(num);
    		pecs6++;
    		break;
    	case 7:
    		checktable(pecs7, num, jogador);
    		game.playPiece(num);
    		pecs7++;
    		break;
    	case 8:
    		checktable(pecs8, num, jogador);
    		game.playPiece(num);
    		pecs8++;
    		break;
    	case 9:
    		checktable(pecs9, num, jogador);
    		game.playPiece(num);
    		pecs9++;
    		break;
    	}
		
	}
	
	private void updateball() {
		
		contentPane.remove(label_1);
    	label_1 = new JLabel();
		label_1.setBounds(268+wit+(80*countplac)-(40*(y-6)), 100+hei-(35*(x-7)), 60, 60);
		API.Images.setImage(label_1, getClass().getResource("/multimedia/imagens/" + jogador));
		contentPane.add(label_1);
		
		contentPane.remove(label_2);
		label_2 = new JLabel();
		label_2.setBounds(268+wit+(80*countplac)-(40*(y-6)), 100+hei-(35*(x-7)), 60, 60);
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
                            label_1.setBounds(268+wit+(80*lin)-(40*(y-6)), i+hei-(35*(x-7)), 60, 60);
                            
                            if (i == locat) {
                            	
                            	try {  API.Sounds.PlaySound("/multimedia/audios/piece_dropped.wav", soundfile);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {e1.printStackTrace();}
                            	
                            	chekagens();
                            	
                            	label_1 = new JLabel();
	            	    		label_1.setBounds(268+wit-(40*(y-6)), 100+hei-(35*(x-7)), 60, 60);
	            	    		API.Images.setImage(label_1, getClass().getResource("/multimedia/imagens/" + player));
	            	    		contentPane.add(label_1);
	            	    		
	            	    		if (!player4.equals("")) {
	            	            	if (jogador.equals(image1)) {
	            	            		jogador = image2;
	            	        		}
	            	        		else {
	            	        			if (jogador.equals(image2)) {
	            	        				jogador = image3;
	            	        			}else {
	            	        				if (jogador.equals(image3)) {
	            	        					jogador = image4;
	            	        				}else {
	            	        					jogador = image1;
	            	        				}
	            	        			}
	            	        		}
	            	            }else {
	            	            	if (!player3.equals("")) {
	            	            		if (jogador.equals(image1)) {
	            	            			jogador = image2;
	            	            		}
	            	            		else {
	            	            			if (jogador.equals(image2)) {
	            	            				jogador = image3;
	            	            			}else {
	            	            				jogador = image1;
	            	            			}
	            	            		}
	            	            	}else {
	            	            		if (jogador.equals(image1)) {
	            	            			jogador = image2;
	            	            		}
	            	            		else {
	            	            			jogador = image1;
	            	            		}
	            	            	}
	            	            }
	            	    		
	            	    		updateball();
	            	    		
	            	    		//System.out.println(game.myBord.toString());
                            	label_2.setVisible(true);
                            	
                            	listening = true;
                            	listeningmous = true;
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
			
			try {  API.Sounds.PlaySound("/multimedia/audios/win_game.wav", soundfile);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {e1.printStackTrace();}
			
			PopupOneOption dialog = new PopupOneOption(this, "Resultado", jogadore + " Venceu !!!", soundfile, 45);
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
					BeginGameMulti frm = new BeginGameMulti();
					frm.setVisible(true);
					
					dispose();
				} catch (API.FILException e) {
					e.printStackTrace();
				}
			}else {
				setLoca(getLocation());
				listening = false;
				listeningmous = false;
				clipTimePostion = clip.getMicrosecondPosition();
				clip.stop();
				MultiPlayerOptions frm = new MultiPlayerOptions();
				frm.setVisible(true);
				
				dispose();
			}
        }
        if (game.myBord.isFull()) {
        	try {  API.Sounds.PlaySound("/multimedia/audios/lose_game.wav", soundfile);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {e1.printStackTrace();}
        	
        	PopupOneOption dialog = new PopupOneOption(this, "Resultado", "Empate !!!", soundfile, 45);
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
					BeginGameMulti frm = new BeginGameMulti();
					frm.setVisible(true);
					
					dispose();
				} catch (API.FILException e) {
					e.printStackTrace();
				}
			}else {
				setLoca(getLocation());
				listening = false;
				listeningmous = false;
				clipTimePostion = clip.getMicrosecondPosition();
				clip.stop();
				MultiPlayerOptions frm = new MultiPlayerOptions();
				frm.setVisible(true);
				
				dispose();
			}
        }
        
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
			
			setLoca(getLocation());
			listening = false;
			listeningmous = false;
			clipTimePostion = clip.getMicrosecondPosition();
			clip.stop();
			MultiPlayerOptions frm = new MultiPlayerOptions();
			frm.setVisible(true);
			
			dispose();
		}
	}
	
	public static void setSinglePlayerOption(boolean multiplayeroptiongui1) {
		multiplayeroptiongui = multiplayeroptiongui1;
	}

	public static void setX(int x) {
		BeginGameMulti.x = x;
	}

	public static void setY(int y) {
		BeginGameMulti.y = y;
	}

	public static void setLinha(int linha) {
		BeginGameMulti.linha = linha;
	}

	public static void setPlayer1(String player1) {
		BeginGameMulti.player1 = player1;
	}

	public static void setPlayer2(String player2) {
		BeginGameMulti.player2 = player2;
	}

	public static void setPlayer3(String player3) {
		BeginGameMulti.player3 = player3;
	}

	public static void setPlayer4(String player4) {
		BeginGameMulti.player4 = player4;
	}
	
	public static void setJogador1nome(String jogador1nome) {
		BeginGameMulti.jogador1nome = jogador1nome;
	}

	public static void setJogador2nome(String jogador2nome) {
		BeginGameMulti.jogador2nome = jogador2nome;
	}

	public static void setJogador3nome(String jogador3nome) {
		BeginGameMulti.jogador3nome = jogador3nome;
	}

	public static void setJogador4nome(String jogador4nome) {
		BeginGameMulti.jogador4nome = jogador4nome;
	}
	
	public static void setImage1(String image1) {
		BeginGameMulti.image1 = image1;
	}

	public static void setImage2(String image2) {
		BeginGameMulti.image2 = image2;
	}

	public static void setImage3(String image3) {
		BeginGameMulti.image3 = image3;
	}

	public static void setImage4(String image4) {
		BeginGameMulti.image4 = image4;
	}
	
}
