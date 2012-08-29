

/**
 *
 * @author tapio eerola
 */
public class Ruudukko {
    
    private int korkeus;
    private int leveys;
    private Solmu[][] solmut;
    private int[] alku;  // Lähtöpisteen koordinaatit.
    private int[] maali; // Maalipisteen koordinaatit.
    
    public Ruudukko(int korkeus, int leveys) {
        this.korkeus = korkeus;
        this.leveys = leveys;
        this.solmut = new Solmu[korkeus][leveys];
        this.alku = new int[] {-1, -1};
        this.maali = new int[] {-1, -1};
    }
    
    public void setAlku(int x, int y) {
        this.alku = new int[]{x, y};
    }
    
    public Solmu getAlku() {
        return getSolmu(alku[0], alku[1]);
    }
    
    public int[] getMaali() {
        return new int[] {maali[0], maali[1]};
    }
    
    public Solmu getSolmu(int x, int y) {
        return solmut[x][y];
    }
    
    public void setLoppu(int x, int y) {
        this.maali = new int[]{x, y};
    }
    
    public void setSolmu(int x, int y, boolean este) {
        this.solmut[x][y] = new Solmu(x, y, este);
    }
    
    public boolean onMaali(Solmu s) {
        if(s.getX()==maali[0] && s.getY()==maali[1]) {
            return true;
        } else {
            return false;
        }
    }
    

   
    public Solmu[] getNaapurit(int x, int y) {
        Solmu s = this.getSolmu(x, y);
        Solmu[] naapurit = new Solmu[4];
        int laskuri = 0;
        
        if(x+1<korkeus && !this.getSolmu(x+1,y).onEste()) {
            naapurit[0] = this.getSolmu(x+1, y);
            
        } else {
            naapurit[0] = null;
            laskuri++;
        }
        if(x-1>=0 && !this.getSolmu(x-1,y).onEste()) {
            naapurit[1] = this.getSolmu(x-1, y);
        } else {
            naapurit[1] = null;
            laskuri++;
        }
        if(y-1>=0 && !this.getSolmu(x,y-1).onEste()) {
            naapurit[2] = this.getSolmu(x, y-1);
        } else {
            naapurit[2] = null;
            laskuri++;
        }
        if(y+1<leveys && !this.getSolmu(x,y+1).onEste()) {
            naapurit[3] = this.getSolmu(x, y+1);
        } else {
            naapurit[3] = null;
            laskuri++;
        }
        
        return naapurit;
        
    }
    
    
            
    
    public void tulosta() {
        
        Solmu s = this.getSolmu(maali[0], maali[1]);
        this.getAlku().setPath(true);
        while(s.getEdeltaja()!=null) {
           s.setPath(true);
           s = s.getEdeltaja();
        }
        for(int i=korkeus-1; i>=0; i--) {
            for(int j=0; j<leveys; j++) {
                if(this.getSolmu(i, j).getPath()) {
                    System.out.print("P");
                } else if(solmut[i][j].onEste()) {
                    System.out.print("X");
                } else {
                    System.out.print(".");
                }
            }
            System.out.println("");
        }
        
    }
    
    public void alusta() {
        for(int i=0; i<korkeus; i++) {
            for(int j=0; j<leveys; j++) {
                this.solmut[i][j] = new Solmu(i,j,false);
            }
        }
    }
    
}
