package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.sound.sampled.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.awt.SystemColor;
import javax.swing.event.ChangeListener;

import API.Fichi;

import javax.swing.event.ChangeEvent;
import java.awt.Font;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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
	private boolean listright=false;
	private boolean listleft=false;
	private boolean listpecadown=false;
	private boolean stop = false;
	private int width;
	private int height;
	private int widthslider;
	private int heightslider;
	private double dividerslider;
	private String[] resol = {"1024 X 800", "1152 X 960", "1280 X 1024"};
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
	
	public Options() {
		bool = true;
		
		KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {

            @Override
            public boolean dispatchKeyEvent(KeyEvent ke) {
            		if(listening) {
            			switch (ke.getID()) {
	                    case KeyEvent.KEY_PRESSED:
	                        
	                        if(listright) {
	                        	text_1.setText(""+ke.getKeyChar());
	                        	vk1 = ke.getKeyCode();
	                        	listright=false;
	                        	break;
	                        }
	                        
	                        if(listleft) {
	                        	text_1_1.setText(""+ke.getKeyChar());
	                        	vk2 = ke.getKeyCode();
	                        	listleft=false;
	                        	break;
	                        }
	                        
	                        if(listpecadown) {
	                        	text_1_2.setText(""+ke.getKeyChar());
	                        	vk3 = ke.getKeyCode();
	                        	listpecadown=false;
	                        	break;
	                        }
	                        
	                        if (ke.getKeyCode() == KeyEvent.VK_RIGHT) {
			        			
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
		                  			System.out.println("Monday2");
		                  		    break;
		                  		  case 2:
		                  			System.out.println("Tuesday2");
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
		
		
		try {
			
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(getClass().getResource("/multimedia/audios/music.wav").getFile()));
			clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
			gainControl.setValue((float)(soundfile-84));
			
			if (Menu.getTimeMusic() > (34360748*count1)) {
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
	    	break;
	    	
	    case 1152:
	    	dividerslider = 2.34;
	    	break;
	    	
		case 1280:
			dividerslider = 2.68;
			break;
		}
		
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/multimedia/imagens/logo.png")));
		setTitle("Quatro em Linha");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
				
				setLoca(getLocation());
				opcao = false;
				selected = 0;
				listening = false;
				Menu.setMusic(true);
				clipTimePostion = clip.getMicrosecondPosition();
				clip.stop();
				frame = new Menu();
				frame.setVisible(true);
				
				dispose();
				
			}
		});
		label_2.setBounds(48, 626, 296, 112);
		API.Images.setImage(label_2, getClass().getResource("/multimedia/imagens/button_back_exited.png"));
		contentPane.add(label_2);
		
		label_3 = new JLabel();
		label_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
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
				
				boolean bool = true;
				String str = text.getText();
			    String[] arrOfStr = str.split(" X ");
			  	
			    List<Integer> myList = new ArrayList<Integer>();
			    
			    for (String a1 : arrOfStr) {
			    	myList.add(Integer.parseInt(a1));
			    }
			    
			    for (int e1 : myList) {
			    	if(bool)
			    		width = e1;
			    	
			    	height = e1;
			    	bool = false;
			    }
				
			    Fichi.writePrefs("preferencias.ap", width, height, soundfile, vk1, vk2, vk3);
			    
			    setPreferredSize(new Dimension(width, height));
			    pack();
			    Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
			    setBounds((int)(size.getWidth()/2)-(width/2), (int)(size.getHeight()/2)-(height/2), width, height);
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
				API.Images.setImage(label_4, getClass().getResource("/multimedia/imagens/left_arrow_entered.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				API.Images.setImage(label_4, getClass().getResource("/multimedia/imagens/left_arrow_exited.png"));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = findIndex(resol, text.getText());
				try {
					text.setText(resol[index-1]);
				}catch(ArrayIndexOutOfBoundsException e1){
					text.setText(resol[resol.length-1]);
				}
			}
		});
		label_4.setBounds(536, 171, 62, 62);
		API.Images.setImage(label_4, getClass().getResource("/multimedia/imagens/left_arrow_exited.png"));
		contentPane.add(label_4);
		
		label_5 = new JLabel();
		label_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				API.Images.setImage(label_5, getClass().getResource("/multimedia/imagens/right_arrow_entered.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				API.Images.setImage(label_5, getClass().getResource("/multimedia/imagens/right_arrow_exited.png"));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = findIndex(resol, text.getText());
				try {
					text.setText(resol[index+1]);
				}catch(ArrayIndexOutOfBoundsException e1){
					text.setText(resol[index-index]);
				}
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
				API.Images.setImage(imagem, getClass().getResource("/multimedia/imagens/slider_point_entered.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				API.Images.setImage(imagem, getClass().getResource("/multimedia/imagens/slider_point_exited.png"));
			}
		});
		imagem.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent evt) {
				
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
		});
		imagem.setBounds(635+(int)(soundfile*dividerslider), 270, 60, 50);
		API.Images.setImage(imagem, getClass().getResource("/multimedia/imagens/slider_point_exited.png"));
		contentPane.add(imagem);
		
		label_6 = new JLabel();
		label_6.setBounds(620, 256, 286, 72);
		API.Images.setImage(label_6, getClass().getResource("/multimedia/imagens/slider.png"));
		contentPane.add(label_6);
		
		text_1 = new JLabel(""+(char)vk1, SwingConstants.CENTER);
		text_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				text_1.setText("Escutando");
				listright = true;
			}
		});
		text_1.setForeground(Color.decode("#FF8B3E"));
		text_1.setFont(new Font("CrackMan", Font.PLAIN, 35));
		text_1.setBounds(613, 348, 296, 72);
		contentPane.add(text_1);
		
		text_1_1 = new JLabel(""+(char)vk2, SwingConstants.CENTER);
		text_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				text_1_1.setText("Escutando");
				listleft = true;
			}
		});
		text_1_1.setForeground(new Color(255, 139, 62));
		text_1_1.setFont(new Font("CrackMan", Font.PLAIN, 35));
		text_1_1.setBounds(613, 438, 296, 72);
		contentPane.add(text_1_1);
		
		text_1_2 = new JLabel(""+(char)vk3, SwingConstants.CENTER);
		text_1_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
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
	
	private int findIndex(String arr[], String t)
    {
		int len = arr.length;
        int i = 0;

        while (i < len) {

            if (arr[i].equals(t)) {
                return i;
            }
            else {
                i = i + 1;
            }
        }
        return -1;
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
