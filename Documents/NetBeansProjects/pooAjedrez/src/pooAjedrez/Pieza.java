/**
 * Pieza nombre general que se le da a las piezas del ajedrez
 * @autor Kevin Ortiz Cusirramos
 * @version 0.1
 */
package pooAjedrez;

public abstract class Pieza {
    
   private boolean color;
    
   /**
     * Constructor de Pieza
     * @param color El parametro tuColor define el color de la pieza si tuColor es false el color es negro y si es true la pieza es blanca
     */
    public Pieza(boolean color){
        this.color = color;
    }
    
    /**
     * Getter del atributo color
     * @return El color de la pieza
     */
    public boolean isColor() {
        return color;
    }
    
    /**
     * Metodo que comprueba si el movimiento que se ha echo es valido
     * @param mov El parametro mov recibe el movimiento que has hecho
     * @param miTablero El parametro miTablero recibe el tablero
     * @return Devuelve el movimiento si es valido o no
     */
    public abstract boolean validoMovimiento(Movimiento mov, Tablero miTablero); 
    
    /**
     * Metodo que te nos muestra todos los atributos de la clase
     * @return Devuelve el color si es falso la pieza es negra y si es verdadero la pieza es blanca
     */
    public  abstract String toString();
}
