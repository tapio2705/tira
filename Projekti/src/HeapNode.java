/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tapio eerola
 */
public class HeapNode {
    private final int x;
    private final int y;
    private int dist;
     
    public HeapNode(int x, int y, int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
    
    public HeapNode(int dist) {
        this.x = 0;
        this.y = 0;
        this.dist = dist;
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    public int getDist() {
        return dist;
    }
    
    public int setDist() {
        return dist;
    }
    
   
}
