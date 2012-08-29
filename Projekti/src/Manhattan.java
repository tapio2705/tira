/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tapio eerola
 */
public class Manhattan extends Heuristic {

    @Override
    public int getEstimate(Ruudukko r, int x, int y) {
            int[] maali = r.getMaali();
            return Math.abs(x-maali[0])+Math.abs(y-maali[1]);
    }
    
}
