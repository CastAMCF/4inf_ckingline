package GUI;

import java.awt.Color;
import java.awt.Dimension;
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
import java.awt.event.MouseMotionAdapter;
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
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import API.Fichi;

public class Options extends JFrame implements ComponentListener {
	
	private Clip clip;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_1_1;
	private JLabel label_1_2;
	private JLabel label_1_3;
	private JLabel label_1_4;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_6;
	private JLabel label_6_1;
	private JLabel label_6_12;
	private JLabel label_6_13;
	private JPanel contentPane;
	private JLabel text;
	private JLabel text_1;
	private JLabel text_1_1;
	private JLabel text_1_2;
	private JLabel text_2;
	private JLabel imagem;
	private static Menu frame;
	private boolean listleft=false;
	private boolean listright=false;
	private boolean listpecadown=false;
	private boolean stop = false;
	private int width;
	private int height;
	private int widthslider;
	private int heightslider;
	private double dividerslider;
	private String[] resol = {"1024 X 800", "1152 X 960", "1280 X 1024"};
	private int index;
	private int widthfile = 0;
	private int heightfile = 0;
	private int soundfile = 0;
	private int vk1 = 0;
	private int vk2 = 0;
	private int vk3 = 0;
	private boolean listening = true;
	private boolean opcao;
	private int selected;
	private static Point loc;
	private static boolean bool;
	private static long clipTimePostion;
	private static boolean music = false;
	public int count = 0;
	public int count1 = 1;
	private JLabel label_3_2;
	
	public Options() {
		bool = true;
		
		KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {

            @Override
            public boolean dispatchKeyEvent(KeyEvent ke) {
            		if(listening) {
            			switch (ke.getID()) {
	                    case KeyEvent.KEY_PRESSED:
	                        
	                        if(listleft) {
	                        	if(ke.getKeyCode() == 37) {
	                        		text_1.setText("<");
	                        	}else if(ke.getKeyCode() == 38) {
	                        		text_1.setText("^");
	                        	}else if(ke.getKeyCode() == 39) {
	                        		text_1.setText(">");
	                        	}else if(ke.getKeyCode() == 40) {
	                        		text_1.setText("\\/");
	                        	}else if(ke.getKeyCode() == 10) {
	                        		text_1.setText("Enter");
	                        	}else if(ke.getKeyCode() == 8) {
	                        		text_1.setText("BackSpace");
	                        	}else {
	                        		text_1.setText(""+ke.getKeyChar());
	                        	}
	                        	
	                        	vk1 = ke.getKeyCode();
	                        	listleft=false;
	                        	try {  API.Sounds.PlaySound("/multimedia/audios/mouse_click.wav", soundfile);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {e.printStackTrace();}
	                        	break;
	                        }
	                        
	                        if(listright) {
	                        	if(ke.getKeyCode() == 37) {
	                        		text_1_1.setText("<");
	                        	}else if(ke.getKeyCode() == 38) {
	                        		text_1_1.setText("^");
	                        	}else if(ke.getKeyCode() == 39) {
	                        		text_1_1.setText(">");
	                        	}else if(ke.getKeyCode() == 40) {
	                        		text_1_1.setText("\\/");
	                        	}else if(ke.getKeyCode() == 10) {
	                        		text_1_1.setText("Enter");
	                        	}else if(ke.getKeyCode() == 8) {
	                        		text_1_1.setText("BackSpace");
	                        	}else {
	                        		text_1_1.setText(""+ke.getKeyChar());
	                        	}
	                        	
	                        	vk2 = ke.getKeyCode();
	                        	listright=false;
	                        	try {  API.Sounds.PlaySound("/multimedia/audios/mouse_click.wav", soundfile);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {e.printStackTrace();}
	                        	break;
	                        }
	                        
	                        if(listpecadown) {
	                        	if(ke.getKeyCode() == 37) {
	                        		text_1_2.setText("<");
	                        	}else if(ke.getKeyCode() == 38) {
	                        		text_1_2.setText("^");
	                        	}else if(ke.getKeyCode() == 39) {
	                        		text_1_2.setText(">");
	                        	}else if(ke.getKeyCode() == 10) {
	                        		text_1_2.setText("Enter");
	                        	}else if(ke.getKeyCode() == 8) {
	                        		text_1_2.setText("BackSpace");
	                        	}else if(ke.getKeyCode() == 40) {
	                        		text_1_2.setText("\\/");
	                        	}else {
	                        		text_1_2.setText(""+ke.getKeyChar());
	                        	}
	                        	
	                        	vk3 = ke.getKeyCode();
	                        	listpecadown=false;
	                        	try {  API.Sounds.PlaySound("/multimedia/audios/mouse_click.wav", soundfile);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {e.printStackTrace();}
	                        	break;
	                        }
	                        
	                        if (ke.getKeyCode() == KeyEvent.VK_RIGHT) {
	                        	try {  API.Sounds.PlaySound("/multimedia/audios/mouse_on.wav", soundfile);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {e.printStackTrace();}
			        			if(opcao) {
			        				API.Images.setImage(label_3, getClass().getResource("/multimedia/imagens/button_applied_exited.png"));
			        				API.Images.setImage(label_2, getClass().getResource("/multimedia/imagens/button_back_entered.png"));
				        			opcao = false;
				        			selected = 2;
			        			}else {
			        				API.Images.setImage(label_3, getClass().getResource("/multimedia/imagens/button_applied_entered.png"));
				        			API.Images.setImage(label_2, getClass().getResource("/multimedia/imagens/button_back_exited.png"));
				        			opcao = true;
				        			selected = 1;
			        			}
			        			
			        		}else if (ke.getKeyCode() == KeyEvent.VK_LEFT) {
			        			try {  API.Sounds.PlaySound("/multimedia/audios/mouse_on.wav", soundfile);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {e.printStackTrace();}
			        			if(opcao) {
			        				API.Images.setImage(label_3, getClass().getResource("/multimedia/imagens/button_applied_exited.png"));
			        				API.Images.setImage(label_2, getClass().getResource("/multimedia/imagens/button_back_entered.png"));
				        			opcao = false;
				        			selected = 2;
			        			}else {
			        				API.Images.setImage(label_3, getClass().getResource("/multimedia/imagens/button_applied_entered.png"));
				        			API.Images.setImage(label_2, getClass().getResource("/multimedia/imagens/button_back_exited.png"));
				        			opcao = true;
				        			selected = 1;
			        			}
			        			
			        		}else if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
			        			
	                    		switch (selected) {
		                  		  case 1:
		                  			try {  API.Sounds.PlaySound("/multimedia/audios/mouse_click.wav", soundfile);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {e.printStackTrace();}
		                  			aplicar();
		                  		    break;
		                  		  case 2:
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
		vk1 = Integer.parseInt(str[3].replaceAll("\\D+",""));
		vk2 = Integer.parseInt(str[4].replaceAll("\\D+",""));
		vk3 = Integer.parseInt(str[5].replaceAll("\\D+",""));
		
		String teclaesq = "";
		String tecladir = "";
		String teclabai = "";
		
		if(vk1 == 37) {
			teclaesq = "<";
    	}else if(vk1 == 38) {
    		teclaesq = "^";
    	}else if(vk1 == 39) {
    		teclaesq = ">";
    	}else if(vk1 == 10) {
    		teclaesq = "Enter";
    	}else if(vk1 == 8) {
    		teclaesq = "BackSpace";
    	}else if(vk1 == 40) {
    		teclaesq = "\\/";
    	}else {
    		teclaesq = ""+(char)vk1;
    	}
		
		if(vk2 == 37) {
			tecladir = "<";
    	}else if(vk2 == 38) {
    		tecladir = "^";
    	}else if(vk2 == 39) {
    		tecladir = ">";
    	}else if(vk2 == 10) {
    		tecladir = "Enter";
    	}else if(vk2 == 8) {
    		tecladir = "BackSpace";
    	}else if(vk2 == 40) {
    		tecladir = "\\/";
    	}else {
    		tecladir = ""+(char)vk2;
    	}
		
		if(vk3 == 37) {
			teclabai = "<";
    	}else if(vk3 == 38) {
    		teclabai = "^";
    	}else if(vk3 == 39) {
    		teclabai = ">";
    	}else if(vk3 == 10) {
    		teclabai = "Enter";
    	}else if(vk3 == 8) {
    		teclabai = "BackSpace";
    	}else if(vk3 == 40) {
    		teclabai = "\\/";
    	}else {
    		teclabai = ""+(char)vk3;
    	}
		
		try {
			
			InputStream in = getClass().getResourceAsStream("/multimedia/audios/music.wav");
			InputStream bufferedIn = new BufferedInputStream(in);
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(bufferedIn);
			clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
			gainControl.setValue((float)(soundfile-84));
			
			while (Menu.getTimeMusic() > (34360748*count1)) {
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
		
		
		switch(widthfile) {
	    case 1024:
	    	dividerslider = 2;
	    	index = 0;
	    	break;
	    	
	    case 1152:
	    	dividerslider = 2.34;
	    	index = 1;
	    	break;
	    	
		case 1280:
			dividerslider = 2.68;
			index = 2;
			break;
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
		
		
		Point loc = Menu.getLoca();
		setBounds(loc.x, loc.y, widthfile, heightfile);
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
				API.Images.setImage(label_2, getClass().getResource("/multimedia/imagens/button_back_exited.png"));
				API.Images.setImage(label_3, getClass().getResource("/multimedia/imagens/button_applied_exited.png"));
        		opcao = false;
        		selected = 0;
			}
		});
		contentPane.setBackground(SystemColor.control);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		label = new JLabel();
		label.setBounds(364, 12, 296, 112);
		API.Images.setImage(label, getClass().getResource("/multimedia/imagens/options_grand_placeholder.png"));
		contentPane.add(label);
		
		label_2 = new JLabel();
		label_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				try {  API.Sounds.PlaySound("/multimedia/audios/mouse_on.wav", soundfile);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {e.printStackTrace();}
				API.Images.setImage(label_2, getClass().getResource("/multimedia/imagens/button_back_entered.png"));
				API.Images.setImage(label_3, getClass().getResource("/multimedia/imagens/button_applied_exited.png"));
				selected = 1;
			}
			@Override
			public void mouseExited(MouseEvent e) {
				API.Images.setImage(label_2, getClass().getResource("/multimedia/imagens/button_back_exited.png"));
				selected = 0;
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				back();
			}
		});
		label_2.setBounds(48, 626, 296, 112);
		API.Images.setImage(label_2, getClass().getResource("/multimedia/imagens/button_back_exited.png"));
		contentPane.add(label_2);
		
		label_3 = new JLabel();
		label_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				try {  API.Sounds.PlaySound("/multimedia/audios/mouse_on.wav", soundfile);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {e.printStackTrace();}
				API.Images.setImage(label_3, getClass().getResource("/multimedia/imagens/button_applied_entered.png"));
				API.Images.setImage(label_2, getClass().getResource("/multimedia/imagens/button_back_exited.png"));
				selected = 2;
			}
			@Override
			public void mouseExited(MouseEvent e) {
				API.Images.setImage(label_3, getClass().getResource("/multimedia/imagens/button_applied_exited.png"));
				selected = 0;
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				aplicar();
			}
		});
		label_3.setBounds(520, 626, 296, 112);
		API.Images.setImage(label_3, getClass().getResource("/multimedia/imagens/button_applied_exited.png"));
		contentPane.add(label_3);
		
		label_1 = new JLabel();
		label_1.setBounds(48, 166, 246, 72);
		API.Images.setImage(label_1, getClass().getResource("/multimedia/imagens/placeholder_resolution.png"));
		contentPane.add(label_1);
		
		label_1_1 = new JLabel();
		label_1_1.setBounds(48, 256, 246, 72);
		API.Images.setImage(label_1_1, getClass().getResource("/multimedia/imagens/placeholder_sounds.png"));
		contentPane.add(label_1_1);
		
		label_1_2 = new JLabel();
		label_1_2.setBounds(48, 346, 246, 72);
		API.Images.setImage(label_1_2, getClass().getResource("/multimedia/imagens/placeholder_left.png"));
		contentPane.add(label_1_2);
		
		label_1_3 = new JLabel();
		label_1_3.setBounds(48, 436, 246, 72);
		API.Images.setImage(label_1_3, getClass().getResource("/multimedia/imagens/placeholder_right.png"));
		contentPane.add(label_1_3);
		
		label_1_4 = new JLabel();
		label_1_4.setBounds(48, 526, 246, 72);
		API.Images.setImage(label_1_4, getClass().getResource("/multimedia/imagens/placeholder_drop.png"));
		contentPane.add(label_1_4);
		
		text = new JLabel(widthfile + " X " + heightfile, SwingConstants.CENTER);
		text.setBounds(610, 166, 296, 72);
		text.setFont(Fonts.Crackman.Normal(45));
		text.setForeground(Color.decode("#601825"));
		contentPane.add(text);
		
		label_4 = new JLabel();
		label_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				try {  API.Sounds.PlaySound("/multimedia/audios/mouse_on.wav", soundfile);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {e.printStackTrace();}
				API.Images.setImage(label_4, getClass().getResource("/multimedia/imagens/left_arrow_entered.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				API.Images.setImage(label_4, getClass().getResource("/multimedia/imagens/left_arrow_exited.png"));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				try {  API.Sounds.PlaySound("/multimedia/audios/mouse_click.wav", soundfile);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {e1.printStackTrace();}
				index--;
            	if(index < 0)
            		index = 2;
            	
            	text.setText(resol[index]);
			}
		});
		label_4.setBounds(536, 171, 62, 62);
		API.Images.setImage(label_4, getClass().getResource("/multimedia/imagens/left_arrow_exited.png"));
		contentPane.add(label_4);
		
		label_5 = new JLabel();
		label_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				try {  API.Sounds.PlaySound("/multimedia/audios/mouse_on.wav", soundfile);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {e.printStackTrace();}
				API.Images.setImage(label_5, getClass().getResource("/multimedia/imagens/right_arrow_entered.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				API.Images.setImage(label_5, getClass().getResource("/multimedia/imagens/right_arrow_exited.png"));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				try {  API.Sounds.PlaySound("/multimedia/audios/mouse_click.wav", soundfile);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {e1.printStackTrace();}
				index++;
            	if(index > 2)
            		index = 0;
            	
            	text.setText(resol[index]);
			}
		});
		label_5.setBounds(918, 171, 62, 62);
		API.Images.setImage(label_5, getClass().getResource("/multimedia/imagens/right_arrow_exited.png"));
		contentPane.add(label_5);
		
		text_2 = new JLabel(soundfile + " %", SwingConstants.CENTER);
		text_2.setForeground(new Color(96, 24, 37));
		text_2.setFont(new Font("CrackMan", Font.PLAIN, 45));
		text_2.setBounds(405, 256, 296, 72);
		contentPane.add(text_2);
		
		imagem = new JLabel();
		imagem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				try {  API.Sounds.PlaySound("/multimedia/audios/mouse_on.wav", soundfile);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {e.printStackTrace();}
				API.Images.setImage(imagem, getClass().getResource("/multimedia/imagens/slider_point_entered.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				try {  API.Sounds.PlaySound("/multimedia/audios/mouse_click.wav", soundfile);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {e1.printStackTrace();}
				API.Images.setImage(imagem, getClass().getResource("/multimedia/imagens/slider_point_exited.png"));
			}
		});
		imagem.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent evt) {
				
				Thread th = new Thread() {
	                @Override
	                public void run(){
						imagem.setLocation(imagem.getLocation().x + evt.getX() - imagem.getWidth() / 2, imagem.getLocation().y + evt.getY() - imagem.getHeight() / 2);
						
						if(imagem.getLocation().y != 270+((heightslider-800)/4)) {
							imagem.setLocation(imagem.getLocation().x, 270+((heightslider-800)/4));
						}
						
						if(imagem.getLocation().x <= 635+((widthslider-1024)/2)) {
							imagem.setLocation(635+((widthslider-1024)/2), imagem.getLocation().y);
						}
						
						if(imagem.getLocation().x >= (int)(835+((widthslider-1024)/1.3))) {
							imagem.setLocation((int)(835+((widthslider-1024)/1.3)), imagem.getLocation().y);
						}
						
						text_2.setText((int)((imagem.getLocation().x-(635+((widthslider-1024)/2)))/dividerslider)+" %");
						soundfile = (int)((imagem.getLocation().x-(635+((widthslider-1024)/2)))/dividerslider);
						
						if(soundfile < 4) {
							soundfile = 4;
						}else if(soundfile > 90) {
							soundfile = 90;
						}
						
						if((int)((imagem.getLocation().x-(635+((widthslider-1024)/2)))/dividerslider) == 0) {
							clip.stop();
							stop = true;
						}else {
							if(stop) {
								clip.start();
								stop = false;
							}
							FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
							gainControl.setValue((float)(soundfile-84));
						}
	                }
	            };th.start();
				
			}
		});
		imagem.setBounds(635+(int)(soundfile*dividerslider), 270, 60, 50);
		API.Images.setImage(imagem, getClass().getResource("/multimedia/imagens/slider_point_exited.png"));
		contentPane.add(imagem);
		
		label_6 = new JLabel();
		label_6.setBounds(620, 256, 286, 72);
		API.Images.setImage(label_6, getClass().getResource("/multimedia/imagens/slider.png"));
		contentPane.add(label_6);
		
		text_1 = new JLabel(teclaesq, SwingConstants.CENTER);
		text_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {  API.Sounds.PlaySound("/multimedia/audios/mouse_on.wav", soundfile);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {e.printStackTrace();}
				text_1.setText("Escutando");
				listleft = true;
			}
		});
		text_1.setForeground(Color.decode("#FF8B3E"));
		text_1.setFont(new Font("CrackMan", Font.PLAIN, 35));
		text_1.setBounds(613, 348, 296, 72);
		contentPane.add(text_1);
		
		text_1_1 = new JLabel(tecladir, SwingConstants.CENTER);
		text_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {  API.Sounds.PlaySound("/multimedia/audios/mouse_on.wav", soundfile);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {e.printStackTrace();}
				text_1_1.setText("Escutando");
				listright = true;
			}
		});
		text_1_1.setForeground(new Color(255, 139, 62));
		text_1_1.setFont(new Font("CrackMan", Font.PLAIN, 35));
		text_1_1.setBounds(613, 438, 296, 72);
		contentPane.add(text_1_1);
		
		text_1_2 = new JLabel(teclabai, SwingConstants.CENTER);
		text_1_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {  API.Sounds.PlaySound("/multimedia/audios/mouse_on.wav", soundfile);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {e.printStackTrace();}
				text_1_2.setText("Escutando");
				listpecadown = true;
			}
		});
		text_1_2.setForeground(new Color(255, 139, 62));
		text_1_2.setFont(new Font("CrackMan", Font.PLAIN, 35));
		text_1_2.setBounds(613, 530, 296, 72);
		contentPane.add(text_1_2);
		
		label_6_1 = new JLabel();
		label_6_1.setBounds(620, 528, 286, 72);
		API.Images.setImage(label_6_1, getClass().getResource("/multimedia/imagens/placeholder_depth.png"));
		contentPane.add(label_6_1);
		
		label_6_12 = new JLabel();
		label_6_12.setBounds(620, 436, 286, 72);
		API.Images.setImage(label_6_12, getClass().getResource("/multimedia/imagens/placeholder_depth.png"));
		contentPane.add(label_6_12);
		
		label_6_13 = new JLabel();
		label_6_13.setBounds(620, 346, 286, 72);
		API.Images.setImage(label_6_13, getClass().getResource("/multimedia/imagens/placeholder_depth.png"));
		contentPane.add(label_6_13);
		
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
	
	private void back() {
		try {  API.Sounds.PlaySound("/multimedia/audios/mouse_click.wav", soundfile);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {e1.printStackTrace();}
		setLoca(getLocation());
		opcao = false;
		selected = 0;
		listening = false;
		Menu.setOption(true);
		clipTimePostion = clip.getMicrosecondPosition();
		clip.stop();
		frame = new Menu();
		frame.setVisible(true);
		
		dispose();
	}
	
	private void aplicar() {
		try {  API.Sounds.PlaySound("/multimedia/audios/mouse_click.wav", soundfile);  } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {e1.printStackTrace();}
		String str = text.getText();
	    String[] arrOfStr = str.split(" X ");
	    
	    width = Integer.parseInt(arrOfStr[0]);
	    height = Integer.parseInt(arrOfStr[1]);
		
	    Fichi.writePrefs("preferencias.ap", width, height, soundfile, vk1, vk2, vk3);
	    
	    setPreferredSize(new Dimension(width, height));
	    pack();
	    Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
	    setBounds((int)(size.getWidth()/2)-(width/2), (int)(size.getHeight()/2)-(height/2), width, height);
	}
	
	private void exit() {
		listening = false;
		PopupTwoOptions fram = new PopupTwoOptions(this, "Tem a certeza que pretende sair ?", soundfile);
		
		String str = text.getText();
	    String[] arrOfStr = str.split(" X ");
	    int width1 = Integer.parseInt(arrOfStr[0]);
	    int height1 = Integer.parseInt(arrOfStr[1]);
		
		if(fram.run(width1, height1)) {
			System.exit(0);
		}
		listening = true;
    }

	@Override
	public void componentHidden(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentMoved(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentResized(ComponentEvent e) {
		int height = this.getHeight();
	    int width = this.getWidth();
	    heightslider = height;
	    widthslider = width;
	    
	    switch(width) {
		    case 1024:
		    	dividerslider = 2;
		    	break;
		    	
		    case 1152:
		    	dividerslider = 2.34;
		    	break;
		    	
			case 1280:
				dividerslider = 2.68;
				break;
	    }
	    
	    
	    label.setBounds(364+((width-1024)/4), 12, 296+((width-1024)/2), 112+((height-800)/6));
		API.Images.setImage(label, getClass().getResource("/multimedia/imagens/options_grand_placeholder.png"));
	    label_3.setBounds(520+((width-1024)/2), (int)(626+((height-800)/1.4)), 296+((width-1024)/2), 112+((height-800)/4));
	    API.Images.setImage(label_3, getClass().getResource("/multimedia/imagens/button_applied_exited.png"));
	    label_2.setBounds(48, (int)(626+((height-800)/1.4)), 296+((width-1024)/2), 112+((height-800)/4));
	    API.Images.setImage(label_2, getClass().getResource("/multimedia/imagens/button_back_exited.png"));
	    label_1.setBounds(48, (int)(166+((height-800)/6)), 246+((width-1024)/2), 72+((height-800)/10));
		API.Images.setImage(label_1, getClass().getResource("/multimedia/imagens/placeholder_resolution.png"));
		label_1_1.setBounds(48, (int)(256+((height-800)/4)), 246+((width-1024)/2), 72+((height-800)/10));
		API.Images.setImage(label_1_1, getClass().getResource("/multimedia/imagens/placeholder_sounds.png"));
		label_1_2.setBounds(48, (int)(346+((height-800)/3)), 246+((width-1024)/2), 72+((height-800)/10));
		API.Images.setImage(label_1_2, getClass().getResource("/multimedia/imagens/placeholder_left.png"));
		label_1_3.setBounds(48, (int)(436+((height-800)/2.5)), 246+((width-1024)/2), 72+((height-800)/10));
		API.Images.setImage(label_1_3, getClass().getResource("/multimedia/imagens/placeholder_right.png"));
		label_1_4.setBounds(48, (int)(526+((height-800)/2)), 246+((width-1024)/2), 72+((height-800)/10));
		API.Images.setImage(label_1_4, getClass().getResource("/multimedia/imagens/placeholder_drop.png"));
		
		
		label_6_1.setBounds(620+((width-1024)/2), (int)(528+((height-800)/2)), (int)(286+((width-1024)/2)), 72+((height-800)/10));
		API.Images.setImage(label_6_1, getClass().getResource("/multimedia/imagens/placeholder_depth.png"));
		text_1_2.setBounds(613+((width-1024)/2), (int)(530+((height-800)/2)), (int)(296+((width-1024)/2)), 72+((height-800)/10));
		
		label_6_12.setBounds(620+((width-1024)/2), (int)(436+((height-800)/2.5)), (int)(286+((width-1024)/2)), 72+((height-800)/10));
		API.Images.setImage(label_6_12, getClass().getResource("/multimedia/imagens/placeholder_depth.png"));
		text_1_1.setBounds(613+((width-1024)/2), (int)(438+((height-800)/2.5)), (int)(296+((width-1024)/2)), 72+((height-800)/10));
		
		label_6_13.setBounds(620+((width-1024)/2), (int)(346+((height-800)/3)), (int)(286+((width-1024)/2)), 72+((height-800)/10));
		API.Images.setImage(label_6_13, getClass().getResource("/multimedia/imagens/placeholder_depth.png"));
		text_1.setBounds(613+((width-1024)/2), (int)(348+((height-800)/3)), (int)(296+((width-1024)/2)), 72+((height-800)/10));
		
		
		text_2.setBounds(405+((width-1024)/4), (int)(256+((width-1024)/(dividerslider+dividerslider-1))), (int)(296+((width-1024)/2)), 72+((height-800)/10));
		label_6.setBounds(620+((width-1024)/2), (int)(256+((height-800)/4)), 286+((width-1024)/2), 72+((height-800)/10));
		API.Images.setImage(label_6, getClass().getResource("/multimedia/imagens/slider.png"));
		imagem.setBounds(635+(int)(soundfile*dividerslider)+((width-1024)/2), (int)(270+((height-800)/4)), 60+((width-1024)/6), 50+((height-800)/10));
		API.Images.setImage(imagem, getClass().getResource("/multimedia/imagens/slider_point_exited.png"));
		text.setBounds(610+((width-1024)/2), (int)(166+((height-800)/6)), 296+((width-1024)/2), 72+((height-800)/10));
		
		
		label_4.setBounds((int)(536+((width-1024)/1.5)), 171+((height-800)/6), 62+((height-800)/10), 62+((height-800)/10));
		API.Images.setImage(label_4, getClass().getResource("/multimedia/imagens/left_arrow_exited.png"));
		label_5.setBounds((int)(918+((width-1024)/1.3)), 171+((height-800)/6), 62+((height-800)/10), 62+((height-800)/10));
		API.Images.setImage(label_5, getClass().getResource("/multimedia/imagens/right_arrow_exited.png"));
		
	}

	@Override
	public void componentShown(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}
}
