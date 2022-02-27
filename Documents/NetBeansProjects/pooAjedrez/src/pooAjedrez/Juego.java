/**
 * Juego 
 * @autor Kevin Ortiz Cusirramos
 * @version 0.1
 */
package pooAjedrez;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Juego {

    private boolean turno;

    /**
     * Constructor
     */
    public Juego() {
 
    }

    /**
     * Getter del atributo turno
     * @return Devuelve el turno del jugador si es falso es 
     * turno del color negro y si es verdadero es el turno del color blancas
     */
    public boolean getTurno() {
        return turno;
    }
    
    /**
     * Setter del atributo turno
     * @param turno Recibe el cambio de turno
     */
    public void setTurno(boolean turno) {
        this.turno = turno;
    }

    /**
     * Valida la jugada para saber si es correcta
     * @param jugada El parametro jugada recibe la jugada que se quiere hacer
     * @param tablero El parametro tablero recibe el tablero del ajedrez
     * @return Devuelve si la jugada es valida
     */
    public Movimiento validarJugada(String jugada, Tablero tablero) {
        Movimiento mov = null;
        int posIni2 = jugada.charAt(0) - 65;
        int posIni = jugada.charAt(1) - 49;
        int posFin = jugada.charAt(3) - 49;
        int posFin2 = jugada.charAt(2) - 65;

        if (jugada.length() == 4) {
            if (turno == tablero.getTablero()[posIni][posIni2].isColor()) {
                if (tablero.getTablero()[posFin][posFin2] != null && turno != tablero.getTablero()[posFin][posFin2].isColor() || tablero.getTablero()[posFin][posFin2] == null) {
                    mov = new Movimiento(new Posicion(posIni, posIni2), new Posicion(posFin, posFin2));
                } else {
                    System.out.println("No puedes comer una pieza de tu mismo color");
                }
            } else {
                System.out.println("La pieza que se quiere mover tiene que ser de tu color");
            }
        } else {
            System.out.println("Solo puedes hacer dos movimientos");
        }

        return mov;
    }

    /**
     * Metodo que sirve para jugar de manera indefinida hasta que un jugador quiera para de jugar
     * @param tuTablero El parametro tuTablero recibe el tablero del ajedrez
     * @throws IOException 
     */
    public void bucleDeJuego(Tablero tuTablero) throws IOException {
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        String salir;
        do{
            String jugada;
            Movimiento mov = null;
            boolean laJugada = false; 
            String colores;
            
            if (turno == false) {
                turno = true;
                colores="Blancas";
            } else {
                turno = false;
                colores="Negras";
            }
            
            do {
                System.out.println("Turno de " + colores + " ingrese una jugada");
                jugada = teclado.readLine();
                mov = validarJugada(jugada.toUpperCase(), tuTablero);
                if (mov != null ) {
                    if (tuTablero.devuelvePieza(mov.getPosInicial()).validoMovimiento(mov,tuTablero)){
                        if(tuTablero.hayPiezasEntre(mov, tuTablero) == true){
                            tuTablero.ponPieza(tuTablero.devuelvePieza(mov.getPosInicial()), mov.getPosFinal());
                            tuTablero.quitarPieza(mov.getPosInicial());
                            laJugada = true;
                            }else{
                                System.out.println("Hay alguna pieza entre las casillas");
                            }
                    }else {
                        System.out.println("Movimiento no valido");
                    }
                }
            } while (mov == null || (laJugada == false));
            
            tuTablero.pintarTablero();
            System.out.print("Quiere salir (S/N): ");
            salir = teclado.readLine();
        }
        while(!(salir.equalsIgnoreCase("S")));
    }
}
