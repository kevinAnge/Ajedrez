/**
 * Pon 
 * @autor Kevin Ortiz Cusirramos
 * @version 0.1
 */
package pooAjedrez;

public class Peon extends Pieza{
    
    /**
     * Constructor de Peon
     * @param color El parametro tuColor define el color de la pieza si tuColor es false el color es negro y si es true la pieza es blanca
     */
    public Peon(boolean color){
        super(color);
    }
    
    @Override
    public boolean validoMovimiento(Movimiento mov, Tablero miTablero){
        boolean miMovimiento = false;  
        if(mov.getPosInicial().getFila()==1 && miTablero.getTablero()[1][mov.getPosInicial().getColumna()] != null && (mov.saltoVertical()==1 || mov.saltoVertical()==2) && mov.isVertical() == true){
            miMovimiento=true;
        }
            else if(mov.getPosInicial().getFila()==6 && miTablero.getTablero()[6][mov.getPosInicial().getColumna()] != null && (mov.saltoVertical()==-1 || mov.saltoVertical()==-2) && mov.isVertical() == true){
                 miMovimiento=true;
            }
                else if(miTablero.getTablero()[mov.getPosFinal().getFila()][mov.getPosFinal().getColumna()] != null && mov.isDiagonal()==true){
                    miMovimiento=true;
                }
                    else if(mov.saltoVertical()==-1 && mov.isVertical() == true && miTablero.getTablero()[mov.getPosFinal().getFila()][mov.getPosFinal().getColumna()] == null && super.isColor() == true){
                        miMovimiento=true;
                    }
                        else if(mov.saltoVertical()==1 && mov.isVertical() == true && miTablero.getTablero()[mov.getPosFinal().getFila()][mov.getPosFinal().getColumna()] == null && super.isColor() == false){
                            miMovimiento=true;
                        }
                
        return miMovimiento;
    }
    
    @Override
    public String toString(){
        String tipoColor = "\u265F";
        
        if(super.isColor() == true){
            tipoColor = "\u2659";
        }

        return tipoColor;
    }
}
