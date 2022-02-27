/**
 * Reina 
 * @autor Kevin Ortiz Cusirramos
 * @version 0.1
 */
package pooAjedrez;

public class Reina extends Pieza{
    
    /**
     * Constructor de Reina
     * @param color El parametro tuColor define el color de la pieza si tuColor es false el color es negro y si es true la pieza es blanca
     */
    public Reina(boolean color){
        super(color);
    }
    
    @Override
    public boolean validoMovimiento(Movimiento mov, Tablero miTablero){
        boolean miMovimiento = false;       
        if(mov.isHorizontal()==true && mov.isVertical()==false || mov.isHorizontal()==false && mov.isVertical()==true
                || mov.isDiagonal()==true){
            miMovimiento = true;
        }
        return miMovimiento;
    }
    
    @Override
    public String toString(){
        String tipoColor = "\u265B";
        
        if(super.isColor() == true){
            tipoColor = "\u2655";
        }

        return tipoColor;
    }
}
