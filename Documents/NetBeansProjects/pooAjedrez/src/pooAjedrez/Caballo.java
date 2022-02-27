/**
 * Caballo 
 * @autor Kevin Ortiz Cusirramos
 * @version 0.1
 */     
package pooAjedrez;

public class Caballo extends Pieza{
    
    /**
     * Constructor de CAballo
     * @param color El parametro tuColor define el color de la pieza si tuColor es false el color es negro y si es true la pieza es blanca
     */
    public Caballo(boolean color){
        super(color);
    }
    
    @Override
    public boolean validoMovimiento(Movimiento mov, Tablero miTablero){
        boolean miMovimiento = false;
        if(Math.abs(mov.saltoVertical())+Math.abs(mov.saltoHorizontal()) == 3){
            miMovimiento = true;
        }
        return miMovimiento;
    }
    
    public String toString(){
        String tipoColor = "\u265E";
        
        if(super.isColor() == true){
            tipoColor = "\u2658";
        }

        return tipoColor;
    }
}
