/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author t
 */
public class Kaari {
    
    
    private Solmu maali;
    private int paino;
    
    public Kaari(Solmu alku, Solmu maali, int paino) {
        this.maali = maali;
        this.paino = paino;
    }
    
    public Solmu getMaali() {
        return maali;
    }
    
    public int getPaino() {
        return paino;
    }

}
