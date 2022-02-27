
package pooAjedrez;

public class Tablero {
    
    private Pieza tablero[][];
    
    /**
     * Constructor de Tablero
     */
    public Tablero(){
        tablero = new Pieza[8][8];
        tablero[0][0] = new Torre(false);
        tablero[0][1] = new Caballo(false);
        tablero[0][2] = new Alfil(false);
        tablero[0][3] = new Reina(false);
        tablero[0][4] = new Rey(false);
        tablero[0][5] = new Alfil(false);
        tablero[0][6] = new Caballo(false);
        tablero[0][7] = new Torre(false);
        for (int i = 0; i < 8; i++) {
            tablero[1][i] = new Peon(false);
        }
        
        tablero[7][0] = new Torre(true);
        tablero[7][1] = new Caballo(true);
        tablero[7][2] = new Alfil(true);
        tablero[7][3] = new Reina(true);
        tablero[7][4] = new Rey(true);
        tablero[7][5] = new Alfil(true);
        tablero[7][6] = new Caballo(true);
        tablero[7][7] = new Torre(true);
        for (int i = 0; i < 8; i++) {
            tablero[6][i] = new Peon(true);
        }
    }

    /**
     * Getter del atributo tablero
     * @return 
     */
    public Pieza[][] getTablero() {
        return tablero;
    }
    
    /**
     * Muestra el ajedrez
     */
    public void pintarTablero(){
        for (int i = 0; i < tablero.length; i++){
            System.out.println("");
            System.out.println("---------------------------------------");
                for (int j = 0; j < tablero.length; j++){
                    if(tablero[i][j] != null){
                        System.out.print("| " + tablero[i][j] + " ");
                    }
                    else{
                        System.out.print("| " + "\u2001" + " ");
                    }
                }       
            System.out.print("|");
        }
        System.out.println("");
        System.out.println("---------------------------------------");
    }
    
    /**
     * Este metodo comprueba si hay una pieza en las posiciones dadas
     * @param miFila 
     * @param miColumna
     * @return Comprueba si hay pieza o no
     */
    public boolean hayPieza(int miFila, int miColumna){
        boolean comprobar = false;
        if(tablero[miFila][miColumna] != null){
        comprobar = true;
        }      
        return comprobar;
    }
    
    /**
     * Este metodo comprueba si hay una pieza en las posiciones dadas
     * @param pos El parametro pos nos dice donde esta ubicada la pieza
     * @return Comprueba si hay pieza o no
     */
    public boolean hayPieza(Posicion pos){   
        return hayPieza(pos.getFila(),pos.getColumna());
    }
    
    /**
     * Pone una pieza donde le indiquemos
     * @param miPieza El parametro miPieza recibe la pieza(Peon, Caballo, Torre ,etc)
     * @param fila 
     * @param columna 
     */
    public void ponPieza(Pieza miPieza,int fila, int columna){
           tablero[fila][columna] = miPieza;
    }
    
    /**
     * Pone una pieza donde le indiquemos
     * @param miPieza El parametro miPieza recibe la pieza(Peon, Caballo, Torre ,etc)
     * @param miPosicion El parametro miPosicion recibe las posiciones(fila, columna) donde queremos poner la pieza
     */
    public void ponPieza(Pieza miPieza,Posicion miPosicion){      
           ponPieza(miPieza, miPosicion.getFila(), miPosicion.getColumna());   
    }
    
    /**
     * Quita la pieza de acuerdo a las posiciones(fila ,columna) que les damos
     * @param fila
     * @param columna 
     */
    public void quitarPieza(int fila, int columna){
        tablero[fila][columna] = null;
    }
    
    /**
     * Quita la pieza de acuerdo a las posiciones(fila ,columna) que les damos
     * @param miPos El parametro miPos recibe las posiciones(fila, columna) donde queremos quitar la pieza
     */
    public void quitarPieza(Posicion miPos){
        quitarPieza(miPos.getFila(),miPos.getColumna());
    }
    
    /**
     * Nos devuelve la pieza deacuerdo a las posiciones(fila, columna) que les demos
     * @param fila
     * @param columna
     * @return Nos devuelve una pieza de ajedrez si es que hay algo en la posicion dada
     */
    public Pieza devuelvePieza(int fila, int columna){
        return tablero[fila][columna];
    }
    
    /**
     * Nos devuelve la pieza deacuerdo a las posiciones(fila, columna) que les demos
     * @param tuPos El parametro tuPos recibe las posiciones(fila, columna) y nos muestra que hay en esa casilla
     * @return Nos devuelve una pieza de ajedrez si es que hay algo en la posicion dada 
     */
    public Pieza devuelvePieza(Posicion tuPos){
        return devuelvePieza(tuPos.getFila(),tuPos.getColumna());
    }
    
    /**
     * Comprueba si hay alguna pieza de ajedrez en interrumpiendo la jugada que queramos hacer
     * @param mov El parametro mov comprueba que tipo de movimiento queremos hacer
     * @param miTablero El parametro miTablero nos ayuda a saber si hay alguna pieza en medio de la jugada
     * @return Devuelve verdadero si no hay alguna pieza en medio de la jugada en caso contrario nos devuelve falso
     */
    public boolean hayPiezasEntre(Movimiento mov, Tablero miTablero){
        boolean tienesPieza=true;     
        if(mov.isVertical()==true){
            if(mov.getPosInicial().getFila() < mov.getPosFinal().getFila()){
                for (int i = mov.getPosInicial().getFila()+1; i < mov.getPosFinal().getFila() && tienesPieza==true; i++) {
                if(miTablero.getTablero()[i][mov.getPosInicial().getColumna()] != null){
                    tienesPieza=false;
                    }
                }
            }
            else{
                for (int f = mov.getPosInicial().getFila()-1; f > mov.getPosFinal().getFila() && tienesPieza==true; f--) {
                if(miTablero.getTablero()[f][mov.getPosInicial().getColumna()] != null){
                    tienesPieza=false;
                    }
                }
            }
        }
        else if(mov.isHorizontal() == true){
            if(mov.getPosInicial().getColumna() < mov.getPosFinal().getColumna()){
                for (int t = mov.getPosInicial().getColumna()+1; t < mov.getPosFinal().getColumna() && tienesPieza==true; t++) {
                if(miTablero.getTablero()[mov.getPosInicial().getFila()][t] != null){
                    tienesPieza=false;
                    
                    }
                }
            }
            else{
                for (int g = mov.getPosInicial().getColumna()-1; g > mov.getPosFinal().getColumna() && tienesPieza==true; g--) {
                if(miTablero.getTablero()[mov.getPosInicial().getFila()][g] != null){
                    tienesPieza=false;
                    }
                }
            }
        }
        else if(mov.isDiagonal()==true){
            if(mov.getPosInicial().getColumna() < mov.getPosFinal().getColumna() && mov.getPosInicial().getFila() < mov.getPosFinal().getFila()){
                for (int i = mov.getPosInicial().getColumna()+1, u=mov.getPosInicial().getFila()+1; u < mov.getPosFinal().getFila() && i < mov.getPosFinal().getColumna() && tienesPieza==true; u++,i++) {
                if(miTablero.getTablero()[u][i] != null){
                    tienesPieza=false;
                    }
                }
            }
            else if(mov.getPosInicial().getColumna() < mov.getPosFinal().getColumna() && mov.getPosInicial().getFila() > mov.getPosFinal().getFila()){
                    for (int b = mov.getPosInicial().getColumna()+1, c=mov.getPosInicial().getFila()-1; c > mov.getPosFinal().getFila() && b < mov.getPosFinal().getColumna() && tienesPieza==true; c--,b++) {
                    if(miTablero.getTablero()[c][b] != null){
                        tienesPieza=false;
                    }
                }
            }
            else if(mov.getPosInicial().getColumna() > mov.getPosFinal().getColumna() && mov.getPosInicial().getFila() > mov.getPosFinal().getFila()){
                    for (int b = mov.getPosInicial().getColumna()-1, c=mov.getPosInicial().getFila()-1; c > mov.getPosFinal().getFila() && b > mov.getPosFinal().getColumna() && tienesPieza==true; c--,b--) {
                        if(miTablero.getTablero()[c][b] != null){
                            tienesPieza=false;
                        }
                    }
            }
            else{
                for (int b = mov.getPosInicial().getColumna()-1, c=mov.getPosInicial().getFila()+1; c < mov.getPosFinal().getFila() && b > mov.getPosFinal().getColumna() && tienesPieza==true; c++,b--) {
                        if(miTablero.getTablero()[c][b] != null){
                            tienesPieza=false;
                        }
                    }
            }
        }
        else{
             tienesPieza = true;
        }
        return tienesPieza;
    }
}
