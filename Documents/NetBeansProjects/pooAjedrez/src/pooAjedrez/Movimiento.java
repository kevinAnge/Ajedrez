
package pooAjedrez;

public class Movimiento {
    
    private Posicion posInicial;
    private Posicion posFinal;
    
    /**
     * Constructor
     * @param posInicial El parametro posInicial recibe la poscion inicial de la pieza
     * @param posFinal El parametro posFinal recibe la poscion final de la pieza
     */
    public Movimiento(Posicion posInicial, Posicion posFinal){
        this.posInicial = posInicial;
        this.posFinal = posFinal;
    }

    /**
     * Getter del atributo posInicial
     * @return Devuelve la posicion inicial del la pieza que se quiere mover
     */
    public Posicion getPosInicial() {
        return posInicial;
    }

    /**
     * Getter del atributo posFinal
     * @return Devuelve la posicion a la que se quiere llegar
     */
    public Posicion getPosFinal() {
        return posFinal;
    }  
    
    /**
     * Metodo que comprueba si la pieza puede moverse en vertical
     * @return Comprueba si la pieza puede moverse verticalmente
     */
    public boolean isVertical(){
        boolean comprobar = false;
        if(posInicial.getColumna() == posFinal.getColumna()){
            comprobar = true;
        }
        return comprobar;
    }
    
    /**
     * Metodo que comprueba si la pieza puede moverse en horizontal
     * @return Comprueba si la pieza puede moverse horizontalmente
     */
    public boolean isHorizontal(){
        boolean comprobar = false;        
        if(posInicial.getFila() == posFinal.getFila()){
            comprobar = true;
        }
        return comprobar;
    }
    
    /**
     * Metodo que comprueba si la pieza puede moverse en diagonal
     * @return Comprueba si la pieza puede moverse diagonalmente
     */
    public boolean isDiagonal(){
        boolean comprobar = false;        
        if(Math.abs(saltoVertical()) == Math.abs(saltoHorizontal())){
            comprobar = true;
        }
        return comprobar;
    }
    
    /**
     * Metodo que cuenta la cantidad de movientos horizontales
     * @return Delvuelve la cantidad de movimientos en horizontal que se han hecho en el tablero
     */
    public int saltoHorizontal(){        
        return posFinal.getColumna() - posInicial.getColumna();
    }
    
    /**
     * Metodo que cuenta la cantidad de movientos verticales
     * @return Delvuelve la cantidad de movimientos en vertical que se han hecho en el tablero
     */
    public int saltoVertical(){
        return posFinal.getFila() - posInicial.getFila();
    }
}
