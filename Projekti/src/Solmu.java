
import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author tapio eerola
 */
public class Solmu implements Comparable<Solmu> {
    
    private int id;
    private int dist;
    private Solmu edellinen;
    private List<Kaari> naapurit;

    public Solmu(int id) {
        this.id = id;
        this.naapurit = new ArrayList<Kaari>();
        this.dist = Integer.MAX_VALUE;
        this.edellinen = null;
    }
    
    public int getId() {
        return id;
    }
    
    public void lisaaNaapuri(Kaari e) {
        this.naapurit.add(e);
    }
    
    public int getDist() {
        return dist;
    }
    
    public void setDist(int d) {
        this.dist = d;
    }
    
    public void setEdellinen(Solmu s) {
        this.edellinen = s;
    }
    
    public List<Kaari> getNaapurit() {
        return naapurit;
    }

    @Override
    public int compareTo(Solmu o) {
        return (this.dist - o.dist);
    }
    
    
    
    
    
    
}
