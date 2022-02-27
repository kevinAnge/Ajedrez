/**
 * Torre 
 * @autor Kevin Ortiz Cusirramos
 * @version 0.1
 */
package pooAjedrez;

public class Torre extends Pieza{
    
    /**
     * Constructor de Torre
     * @param color El parametro tuColor define el color de la pieza si tuColor es false el color es negro y si es true la pieza es blanca
     */
    public Torre(boolean color){
        super(color);
    }
    
    @Override
    public boolean validoMovimiento(Movimiento mov, Tablero miTablero){
        boolean miMovimiento = false;
        
        if(mov.isHorizontal()==true && mov.isVertical()==false || mov.isHorizontal()==false && mov.isVertical()==true){
            miMovimiento = true;
        }
        return miMovimiento;
    }
    
    @Override
    public String toString(){
        String miColor = "\u265C";
        
       if(super.isColor() == true){
           miColor = "\u2656";
       }
       
       return miColor;
    }
}
