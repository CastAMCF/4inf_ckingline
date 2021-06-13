
package API;

import javax.swing.JLabel;

/**
 * Jogo
 * @author Asus
 */
public final class FILGame {
    /**Criação do Jogador 1*/
	public Piece player1;
    /**Criação do Jogador 2*/
    public Piece player2;
    /**Criação do Jogador 3*/
    public Piece player3;
    /**Criação do Jogador 4*/
    public Piece player4;
    /**Criação do jogador ativo*/
    public Piece activePlayer;
    /**Criação do jogador não ativo*/
    public Piece notactivePlayer;
    /**Criação do de jogo jogo*/
    public Board myBord;
    
    /**
     * Inicializa o jogo com os valores predefenidos se não forem designados valores
     * @throws FILException 
     */
    public FILGame() throws FILException{
    	this(6,7,"0","X","","");
    }
    
    /**
     * Inicializa o jogo com o tamanho do tabuleiro e jogadores designados
     * @param size1
     * @param size2
     * @param txt1
     * @param txt2
     * @param txt3
     * @param txt4
     * @throws FILException 
     */
    public FILGame(int size1, int size2, String txt1, String txt2, String txt3, String txt4) throws FILException{
        this.player1 = new Piece(txt1);
        this.player2  = new Piece(txt2);
        if (!txt3.equals("")) this.player3 = new Piece(txt3);
        if (!txt4.equals("")) this.player4  = new Piece(txt4);
        this.myBord = new Board(size1, size2);
        
        if(!txt4.equals("")) {
        	double rand = Math.random();
        	if(rand < 0.25) {
        		activePlayer = player2;
    			notactivePlayer = player1;
            	return;
            }else {
            	if(rand > 0.25 && rand < 0.5) {
            		activePlayer = player3;
    				notactivePlayer = player1;
    				return;
            	}else {
            		if(rand > 0.5 && rand < 0.75) {
            			activePlayer = player4;
    					notactivePlayer = player1;
    					return;
            		}else {
            			activePlayer = player1;
    					notactivePlayer = player2;
    					return;
            		}
            	}
            }
        }
        
        if(!txt3.equals("")) {
        	double rand = Math.random();
        	if (rand < 0.3) {
    			activePlayer = player2;
    			notactivePlayer = player1;
    			return;
    		}
    		else {
    			if (rand > 0.3 && rand < 0.6) {
    				activePlayer = player3;
    				notactivePlayer = player1;
    				return;
    			}else {
    				activePlayer = player1;
    				notactivePlayer = player2;
    				return;
    			}
    		}
        }
        
        if(Math.random() < 0.5) {
            activePlayer = player1;
            notactivePlayer = player2;
        	return;
        }
        activePlayer = player2;
        notactivePlayer = player1;
    }
    
    /**
     * Mostra o jogo convertido em string na JLabel designada
     * @param texto 
     */
    public final void display(JLabel texto){
        texto.setText("<html><pre>" + myBord.toString() + "</html>");
    }
    
    /**
     * Joga a peça na coluna especificada
     * @param x
     * @throws FILException 
     */
    public final void playPiece(int x) throws FILException{
    	this.myBord.play(activePlayer, x);
    }
    
    /**
     * Reinicia o tabuleiro
     * @throws FILException 
     */
    public void restart() throws FILException {
    	myBord.restart();
    }

}
