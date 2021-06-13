
package API;

/**
 * Peças para o jogo
 * @author Asus
 */
public final class Piece {
    private static final String EMPTY = ".";
    private String txt;
    
    public Piece(String txt){
        this.txt = txt;
    }
    
    /**
     * Criação da peça predefenida
     */
    public Piece(){
        this(EMPTY);
    }
    
    /**
     * Criação da peça designada
     * @param p 
     */
    public Piece(Piece p){
        this(p.txt);
    }
    
    /**
     * Converte a peça para texto
     * @return 
     */
    public final String getTxt() {
        return txt;
    }
    
    /**
     * Verifica se existe alguma peça
     * @return 
     */
    public final boolean isEmpty(){
        return txt.equals(EMPTY);
    }
    
    /**
     * Verifica se a peça é igual à peça designada
     * @param obj
     * @return 
     */
    public final boolean equals(Object obj){
        return obj instanceof Piece && ((Piece)obj).txt.equals(this.txt);
    }
    
}
