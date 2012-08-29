

import java.util.Arrays;
import java.util.Random;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tapio eerola
 */
public class KekoTest {
    
    
    @Test
    public void testaaPientaKekoa() {
        Keko k = new Keko();
        assertEquals(k.getSize(), 0);
        k.insert(new HeapNode(3));
        k.insert(new HeapNode(7));
        k.insert(new HeapNode(5));
        k.insert(new HeapNode(3));
        k.insert(new HeapNode(9));
        assertEquals(k.getSize(), 5);
        assertEquals(k.kekoMin().getDist(), 3);
        assertEquals(k.getSize(), 4);
        assertEquals(k.kekoMin().getDist(), 3);
        assertEquals(k.kekoMin().getDist(), 5);
        assertEquals(k.getSize(), 2);
   }
    
   @Test
   public void testaaIsompaaKekoa() {
       Keko k = new Keko();
       for(int i=0; i<500; i++) {
           k.insert(new HeapNode(500-i));
       }
       for(int i=0; i<500; i++) {
           assertEquals(k.kekoMin().getDist(), i+1);
       }
       for(int i=0; i<500; i++) {
           k.insert(new HeapNode(500-i));
       }
   }
    
   @Test
   public void testaaKekoaSatunnaisesti() {
       Random r = new Random();
       for(int i=0; i<100; i++) {
           Keko k = new Keko();
           int l = r.nextInt(1000);
           int[] luvut = new int[l];
           for(int j=0; j<l; j++) {
               int t = r.nextInt(1000);
               luvut[j] = t;
               k.insert(new HeapNode(t));
               assertEquals(k.getSize(), j+1);
           }
           Arrays.sort(luvut);
           for(int j=0; j<l; j++) {
               assertEquals(k.kekoMin().getDist(), luvut[j]);
           }
       }
   }
}