/**
 * Rey 
 * @autor Kevin Ortiz Cusirramos
 * @version 0.1
 */
package pooAjedrez;

public class Rey extends Pieza{
    
    /**
     * Constructor de Rey
     * @param color El parametro tuColor define el color de la pieza si tuColor es false el color es negro y si es true la pieza es blanca
     */
    public Rey(boolean color){
        super(color);
    }
    
    @Override
    public boolean validoMovimiento(Movimiento mov, Tablero miTablero){
        boolean miMovimiento = false;       
        if(mov.isDiagonal()==true && Math.abs(mov.saltoVertical())==1 && Math.abs(mov.saltoHorizontal()) == 1 || Math.abs(mov.saltoVertical()) + Math.abs(mov.saltoHorizontal()) == 1){
            miMovimiento = true;
        }
        return miMovimiento;
    }
    
    @Override
    public String toString(){
        String tipoColor = "\u265A";
        
        if(super.isColor() == true){
            tipoColor = "\u2654";
        }

        return tipoColor;
    }
}
