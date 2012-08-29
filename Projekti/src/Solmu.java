/**
 *
 * @author tapio eerola
 */
public class Solmu {
    
    private final int x;
    private final int y;
    private boolean este;
    private int g; //Arvio lyhimmästä polusta lähtöpisteeseen.
    private int h; // Heuristiikan antama arvio matkasta maalipisteeseen.
    private Solmu edeltaja; // Solmun edeltäjä lyhimmällä polulla.
    private boolean path; //Kuuluuko solmu lyhimpään polkuun.
    private int indeksi;
    
    public Solmu(int x, int y, boolean este) {
        this.x = x;
        this.y = y;
        this.este = este;
        this.g = Integer.MAX_VALUE;
        this.h = Integer.MAX_VALUE;
        this.edeltaja = null;
        this.path = false;
    }
    
    public Solmu(int d) {
        this.x = 0;
        this.y = 0;
        this.g = d;
        this.edeltaja = null;
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    public int getDist() {
        return g;
    }
    
    public void setDist(int d) {
        this.g = d;
    }
    
    public Solmu getEdeltaja(){
        return edeltaja;
    }
    
    public void setEdeltaja(Solmu e) {
        this.edeltaja = e;
    }
    
    public boolean onEste() {
        return este;
    }
    
    public void setPath(boolean path) {
        this.path = path;
    }
    
    public boolean getPath() {
        return this.path;
    }
    
    public void setEstimate(int h) {
        this.h = h;
    }
    
    public int getEstimate() {
        return h;
    }

}
