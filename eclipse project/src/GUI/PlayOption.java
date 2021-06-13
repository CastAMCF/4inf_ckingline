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
import java.io.File;
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

import API.FILException;
import API.Fichi;

public class PlayOption extends JFrame implements ComponentListener {
	
	private PlayOption mainframe;
	private Clip clip;
	private Menu frame;
	private NewGameOptions frame1;
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
	public int count2 = 0;
	public int count3 = 1;
	public int count4 = 0;
	public int count5 = 1;
	public int count6 = 0;
	public int count7 = 1;
	private static boolean menu = false;
	private static boolean newgame = false;
	private static boolean continuegamemult = false;
	private boolean newgameoptionsgui = false;
	private boolean continuegamegui = false;
	private boolean continuegamebotgui = false;

	public PlayOption() {
		bool = true;
		
		KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {

			@Override
	        public boolean dispatchKeyEvent(KeyEvent ke) { 
	        	if(listening) {
		        	switch (ke.getID()) {
		        	case KeyEvent.KEY_PRESSED:
		        		if (ke.getKeyCode() == KeyEvent.VK_RIGHT) {
		        			try {  API.Sounds.PlaySound("/multimedia/audios/mouse_on.wav", soundfile);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {e1.printStackTrace();}
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
		        			try {  API.Sounds.PlaySound("/multimedia/audios/mouse_on.wav", soundfile);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {e1.printStackTrace();}
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
		        			try {  API.Sounds.PlaySound("/multimedia/audios/mouse_on.wav", soundfile);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {e1.printStackTrace();}
		        			API.Images.setImage(btnnewgame, getClass().getResource("/multimedia/imagens/button_newgame_exited.png"));
		    				API.Images.setImage(btncontinue, getClass().getResource("/multimedia/imagens/button_continue_exited.png"));
		    				API.Images.setImage(btnback, getClass().getResource("/multimedia/imagens/button_back_entered.png"));
		    				opcao = false;
		    				selected = 3;
		        			
		        		}else if (ke.getKeyCode() == KeyEvent.VK_DOWN) {
		        			try {  API.Sounds.PlaySound("/multimedia/audios/mouse_on.wav", soundfile);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {e1.printStackTrace();}
		        			API.Images.setImage(btnnewgame, getClass().getResource("/multimedia/imagens/button_newgame_exited.png"));
		    				API.Images.setImage(btncontinue, getClass().getResource("/multimedia/imagens/button_continue_exited.png"));
		    				API.Images.setImage(btnback, getClass().getResource("/multimedia/imagens/button_back_entered.png"));
		    				opcao = false;
		    				selected = 3;
		        			
		        		}else if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
		        			
                    		switch (selected) {
	                  		  case 1:
	                  			try {  API.Sounds.PlaySound("/multimedia/audios/mouse_click.wav", soundfile);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {e.printStackTrace();}
	                  			newgameopgui();
	                  		    break;
	                  		  case 2:
	                  			try {  API.Sounds.PlaySound("/multimedia/audios/mouse_click.wav", soundfile);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {e.printStackTrace();}
	                  			continuegamegui();
	                  		    break;
	                  		  case 3:
	                  			try {  API.Sounds.PlaySound("/multimedia/audios/mouse_click.wav", soundfile);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {e.printStackTrace();}
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
			
			if(menu) {
				while (Menu.getTimeMusic() > (34360748*count1)) {
					count++;
					count1++;
					count2 = count;
					count3 = count1;
					count4 = count;
					count5 = count1;
					count6 = count;
					count7 = count1;
				}
				clip.setMicrosecondPosition(Menu.getTimeMusic() - (34360748*count));
				setMenu(false);
			} else if(newgame) {
				while (NewGameOptions.getTimeMusic() > (34360748*count3)) {
					count2++;
					count3++;
					count = count2;
					count1 = count3;
					count4 = count;
					count5 = count1;
					count6 = count;
					count7 = count1;
				}
				clip.setMicrosecondPosition(NewGameOptions.getTimeMusic() - (34360748*count2));
				setNewGame(false);
			} else if(continuegamemult) {
				while (ContinueGameMulti.getTimeMusic() > (34360748*count5)) {
					count4++;
					count5++;
					count = count2;
					count1 = count3;
					count2 = count;
					count3 = count1;
					count6 = count;
					count7 = count1;
				}
				clip.setMicrosecondPosition(ContinueGameMulti.getTimeMusic() - (34360748*count4));
				setContinueGameMulti(false);
			} else {
				while (ContinueGameBot.getTimeMusic() > (34360748*count7)) {
					count6++;
					count7++;
					count = count2;
					count1 = count3;
					count2 = count;
					count3 = count1;
					count4 = count;
					count5 = count1;
				}
				clip.setMicrosecondPosition(ContinueGameBot.getTimeMusic() - (34360748*count6));
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
		
		newgameoptionsgui = NewGameOptions.getBool();
		continuegamegui = ContinueGameMulti.getBool();
		continuegamebotgui = ContinueGameBot.getBool();
		
		if(newgameoptionsgui) {
			Point loc = NewGameOptions.getLoca();
			setBounds(loc.x, loc.y, widthfile, heightfile);
			NewGameOptions.setBool(false);
		}else if(continuegamegui) {
			Point loc2 = ContinueGameMulti.getLoca();
			setBounds(loc2.x, loc2.y, widthfile, heightfile);
			ContinueGameMulti.setBool(false);
		}else if(continuegamebotgui) {
			Point loc2 = ContinueGameBot.getLoca();
			setBounds(loc2.x, loc2.y, widthfile, heightfile);
			ContinueGameBot.setBool(false);
		}else{
			Point loc1 = Menu.getLoca();
			setBounds(loc1.x, loc1.y, widthfile, heightfile);
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
				try {  API.Sounds.PlaySound("/multimedia/audios/mouse_on.wav", soundfile);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {e1.printStackTrace();}
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
				newgameopgui();
			}
		});
		btnnewgame.setBounds(164, 310, 296, 112);
		API.Images.setImage(btnnewgame, getClass().getResource("/multimedia/imagens/button_newgame_exited.png"));
		playoptionPanel.add(btnnewgame);
		
		btncontinue = new JLabel();
		btncontinue.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				try {  API.Sounds.PlaySound("/multimedia/audios/mouse_on.wav", soundfile);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {e1.printStackTrace();}
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
				continuegamegui();
			}
		});
		btncontinue.setBounds(556, 307, 296, 112);
		API.Images.setImage(btncontinue, getClass().getResource("/multimedia/imagens/button_continue_exited.png"));
		playoptionPanel.add(btncontinue);
		
		btnback = new JLabel();
		btnback.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				try {  API.Sounds.PlaySound("/multimedia/audios/mouse_on.wav", soundfile);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {e1.printStackTrace();}
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
	
	public static void setMenu(boolean menu1) {
		menu = menu1;
	}
	
	public static void setNewGame(boolean newgame1) {
		newgame = newgame1;
	}
	
	public static void setContinueGameMulti(boolean continuegamemult1) {
		continuegamemult = continuegamemult1;
	}
	
	private void newgameopgui() {
		try {  API.Sounds.PlaySound("/multimedia/audios/mouse_click.wav", soundfile);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {e1.printStackTrace();}
		
		setLoca(getLocation());
		opcao = false;
		selected = 0;
		listening = false;
		NewGameOptions.setPlayop(true);
		clipTimePostion = clip.getMicrosecondPosition();
		clip.stop();
		frame1 = new NewGameOptions();
		frame1.setVisible(true);
		
		dispose();
	}
	
	private void continuegamegui() {
		try {  API.Sounds.PlaySound("/multimedia/audios/mouse_click.wav", soundfile);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {e1.printStackTrace();}
		
		File file = new File("jogo_salvo.ap");
		if(file.exists()) {
			
			String[] fline = new String[] {};
			try {
				fline = API.Fichi.read("jogo_salvo.ap").split("\n");
			}catch(IOException e1){}
			
			
			if(fline[0].contains("multi")) {
				
				setLoca(getLocation());
				opcao = false;
				selected = 0;
				listening = false;
				ContinueGameMulti.setPlayOption(true);
				clipTimePostion = clip.getMicrosecondPosition();
				clip.stop();
				ContinueGameMulti fram;
				try {
					fram = new ContinueGameMulti();
					fram.setVisible(true);
				} catch (FILException e1) {e1.printStackTrace();}
				dispose();
				
			}else {
				try {
					if(fline[0].split(",")[0].contains("botfacil4")) {
			    		ContinueGameBot.setBotfacil4(true);
					}else if(fline[0].split(",")[0].contains("botnormal4")) {
						ContinueGameBot.setBotnormal4(true);
					}else if(fline[0].split(",")[0].contains("botmedio4")) {
						ContinueGameBot.setBotmedio4(true);
					}else if(fline[0].split(",")[0].contains("botdificil4")) {
						ContinueGameBot.setBotdificil4(true);
					}else {
						if(fline[0].split(",")[0].contains("botfacil3")) {
				    		ContinueGameBot.setBotfacil3(true);
						}else if(fline[0].split(",")[0].contains("botnormal3")) {
							ContinueGameBot.setBotnormal3(true);
						}else if(fline[0].split(",")[0].contains("botmedio3")) {
							ContinueGameBot.setBotmedio3(true);
						}else if(fline[0].split(",")[0].contains("botdificil3")) {
							ContinueGameBot.setBotdificil3(true);
						}else {
							if(fline[0].split(",")[0].contains("botfacil2")) {
					    		ContinueGameBot.setBotfacil2(true);
							}else if(fline[0].split(",")[0].contains("botnormal2")) {
								ContinueGameBot.setBotnormal2(true);
							}else if(fline[0].split(",")[0].contains("botmedio2")) {
								ContinueGameBot.setBotmedio2(true);
							}else if(fline[0].split(",")[0].contains("botdificil2")) {
								ContinueGameBot.setBotdificil2(true);
							}
						}
					}
				}catch(ArrayIndexOutOfBoundsException e1) {}
				
				try {
					if(fline[0].split(",")[1].contains("botfacil3")) {
			    		ContinueGameBot.setBotfacil3(true);
					}else if(fline[0].split(",")[1].contains("botnormal3")) {
						ContinueGameBot.setBotnormal3(true);
					}else if(fline[0].split(",")[1].contains("botmedio3")) {
						ContinueGameBot.setBotmedio3(true);
					}else if(fline[0].split(",")[1].contains("botdificil3")) {
						ContinueGameBot.setBotdificil3(true);
					}else {
						if(fline[0].split(",")[1].contains("botfacil2")) {
				    		ContinueGameBot.setBotfacil2(true);
						}else if(fline[0].split(",")[1].contains("botnormal2")) {
							ContinueGameBot.setBotnormal2(true);
						}else if(fline[0].split(",")[1].contains("botmedio2")) {
							ContinueGameBot.setBotmedio2(true);
						}else if(fline[0].split(",")[1].contains("botdificil2")) {
							ContinueGameBot.setBotdificil2(true);
						}
					}
				}catch(ArrayIndexOutOfBoundsException e1) {}
				
				try {
					if(fline[0].split(",")[2].contains("botfacil2")) {
			    		ContinueGameBot.setBotfacil2(true);
					}else if(fline[0].split(",")[2].contains("botnormal2")) {
						ContinueGameBot.setBotnormal2(true);
					}else if(fline[0].split(",")[2].contains("botmedio2")) {
						ContinueGameBot.setBotmedio2(true);
					}else if(fline[0].split(",")[2].contains("botdificil2")) {
						ContinueGameBot.setBotdificil2(true);
					}
				}catch(ArrayIndexOutOfBoundsException e1) {}
				
				setLoca(getLocation());
				opcao = false;
				selected = 0;
				listening = false;
				ContinueGameBot.setPlayOption(true);
				clipTimePostion = clip.getMicrosecondPosition();
				clip.stop();
				ContinueGameBot fram;
				try {
					fram = new ContinueGameBot();
					fram.setVisible(true);
				} catch (FILException e1) {e1.printStackTrace();}
				dispose();
				
			}
			
		}else {
			listening = false;
			PopupOneOption dialog = new PopupOneOption(this, "Erro", "Não existe um jogo salvo", soundfile, 35);
    		dialog.run(widthfile, heightfile);
			listening = true;
		}
	}
	
	private void back() {
		try {  API.Sounds.PlaySound("/multimedia/audios/mouse_click.wav", soundfile);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {e1.printStackTrace();}
		
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
