

/**
 *
 * @author tapio eerola
 */
public class Kaari {
    
    private Solmu alku;
    private Solmu maali;
    private int paino;
    
    @SuppressWarnings("LeakingThisInConstructor")
    public Kaari(Solmu alku, Solmu maali, int paino) {
        this.alku = alku;
        this.maali = maali;
        this.paino = paino;
        
        alku.lisaaNaapuri(this);
    }
    
    public Solmu getAlku() {
        return alku;
    }
    
    public Solmu getMaali() {
        return maali;
    }
    
    public int getPaino() {
        return paino;
    }

}
