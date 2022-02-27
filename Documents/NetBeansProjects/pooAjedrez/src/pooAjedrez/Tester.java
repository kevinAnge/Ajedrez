
package pooAjedrez;

import java.io.IOException;

public class Tester {
    
    public static void main(String[] args) throws IOException {
         Tablero miTablero = new Tablero();
         Juego miJuego = new Juego();
         miTablero.pintarTablero();
         miJuego.bucleDeJuego(miTablero);
    }
}
