/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package janech.wof.jadro;

/**
 *
 * @author janik
 */
public class SmrtException extends RuntimeException {

    /**
     * Creates a new instance of
     * <code>SmrtException</code> without detail message.
     */
    public SmrtException() {
    }

    /**
     * Constructs an instance of
     * <code>SmrtException</code> with the specified detail message.
     *
     * @param msg the detail message.
     */
    public SmrtException(String msg) {
        super(msg);
    }
}
