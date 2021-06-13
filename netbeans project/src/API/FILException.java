
package API;

/**
 * Faz o tratamento das exceções
 * @author Asus
 */
public final class FILException extends Exception {
    
    /**
    * Recebe a exceção e define-a como FILException
    */
    public FILException (String message){
    	super(message);
    }
}
