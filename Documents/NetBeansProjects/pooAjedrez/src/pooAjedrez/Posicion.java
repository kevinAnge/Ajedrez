
package pooAjedrez;

public class Posicion {
    
    private int fila;
    private int columna;
    
    /**
     * Constructor de Posicion
     * @param fila 
     * @param columna 
     */
    public Posicion(int fila, int columna){
        this.fila = fila;
        this.columna = columna;
    }
    
    /**
     * Setter del atributo fila
     * @param miFila 
     */
    public void setFila(int miFila){
        fila = miFila;
    }
    
    /**
     * Setter del atributo columna
     * @param miColumna 
     */
    public void setColumna(int miColumna){
        columna = miColumna;
    }
    
    /**
     * Getter del atributo fila
     * @return Devuelve la fila
     */
    public int getFila(){
        return fila;
    }
    
    /**
     * Getter del atributo columna
     * @return Devuelve la columna
     */
    public int getColumna(){
        return columna;
    }
    
}
