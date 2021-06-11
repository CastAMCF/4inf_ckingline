
package API;

public final class Piece {
    private static final String EMPTY = ".";
    private String txt;
    
    public Piece(String txt){
        this.txt = txt;
    }
    
    public Piece(){
        this(EMPTY);
    }
    
    public Piece(Piece p){
        this(p.txt);
    }

    public final String getTxt() {
        return txt;
    }

    public final boolean isEmpty(){
        return txt.equals(EMPTY);
    }
    
    public final boolean equals(Object obj){
        return obj instanceof Piece && ((Piece)obj).txt.equals(this.txt);
    }
    
}
