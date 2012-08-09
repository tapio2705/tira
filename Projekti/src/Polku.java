
import java.util.PriorityQueue;


/**
 *
 * @author tapio eerola
 */
public class Polku {
    
    public static void etsiPolku(Solmu s, Solmu t) {
        
        PriorityQueue<Solmu> avoin = new PriorityQueue<Solmu>();
        s.setDist(0);
        avoin.add(s);
        
        Solmu seuraava = s;
        
        while(seuraava.getId() != t.getId()) {
            for(Kaari k: seuraava.getNaapurit()) {
                Solmu m = k.getMaali();
                if(seuraava.getDist() + k.getPaino() < m.getDist()) {
                    avoin.remove(m);
                    m.setDist(seuraava.getDist() + k.getPaino());
                    m.setEdellinen(s);
                    avoin.add(m);
                }
            }
        }
        
   }
}
