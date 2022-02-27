/**
 * Alfil 
 * @autor Kevin Ortiz Cusirramos
 * @version 0.1
 */
package pooAjedrez;

public class Alfil extends Pieza{
    
    /**
     * Constructor de Alfil
     * @param color El parametro tuColor define el color de la pieza si tuColor es false el color es negro y si es true la pieza es blanca
     */
    public Alfil(boolean color){
        super(color);
    }
    
    public boolean validoMovimiento(Movimiento mov, Tablero miTablero){
        boolean miMovimiento = false;       
        if(mov.isDiagonal()==true){
            miMovimiento = true;
        }
        return miMovimiento;
    }
    
    @Override
    public String toString(){
        String tipoColor = "\u265D";
        
        if(super.isColor() == true){
            tipoColor = "\u2657";
        }

        return tipoColor;
    }
}
