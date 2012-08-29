/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tapio
 */
public class AstarTest {
    
    @Test
    public void testaaPienia() {
        Astar pathFinder = new Astar();
        Ruudukko  r = new Ruudukko(2,2);
        r.alusta();
        r.setAlku(0, 0);
        r.setLoppu(1, 1);
        assertEquals(pathFinder.etsiPolku(r, new Dijkstra()), true);
        
        Ruudukko s = new Ruudukko(3, 3);
        s.alusta();
        s.setAlku(0, 0);
        s.setLoppu(2, 2);
        for(int i=0; i<3; i++) {
            s.setSolmu(1, i, true);
        }
        assertEquals(pathFinder.etsiPolku(s, new Dijkstra()), false);
    }
     

}
