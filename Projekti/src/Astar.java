/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tapio eerola
 */
public class Astar {
    
        private int counter;
        
        public Astar() {
            this.counter = 0;
        }
    
        public boolean etsiPolku(Ruudukko r, Heuristic h) {
            
            counter = 0;
            Keko avoin = new Keko();
            Solmu alku = r.getAlku();
            int x = alku.getX();
            int y = alku.getY();
            alku.setDist(0);
            int d = h.getEstimate(r, x, y);
            avoin.insert(new HeapNode(x, y, d));
            boolean pathFound = false;
            int[] maali = r.getMaali();
            
            
            
            while(!avoin.isEmpty() && !pathFound) {
                
                HeapNode current = avoin.kekoMin();
                counter++;
                x = current.getX();
                y = current.getY();
                d = h.getEstimate(r, x, y); // Arvioidaan pisteen (x, y) etäisyys maalista
                                            // heuristiikalla h.

                if(x==maali[0] && y==maali[1]) {
                    pathFound = true;
                } else {
                    
                    if(current.getDist()<=r.getSolmu(x, y).getDist()+d) {
                        
                        for(Solmu s: r.getNaapurit(x, y)) {
                            if(s==null) {
                                continue;
                            }
                            
                            int u = s.getX();
                            int v = s.getY();
                            int e = h.getEstimate(r, u, v);
                            int f = r.getSolmu(x, y).getDist()+1+e;
            
                            if(f<(s.getDist()+e) || s.getDist()==Integer.MAX_VALUE) {
                                
                                s.setEdeltaja(r.getSolmu(x, y));
                                s.setDist(r.getSolmu(x, y).getDist()+1);
                                avoin.insert(new HeapNode(s.getX(), s.getY(), f));
                            }
                        }
                    }
                }
                
            }
        return pathFound;
        }
        
        public int getCount() {
            return counter;
        }

        

}
