
/**
 *
 * @author tapio eerola
 * 
 */

public class Keko {
    
    private HeapNode[] heap;
    private int size; // Ensimmäinen indeksi, jossa ei ole kekoon kuuluvaa alkiota (= keon alkioiden lukumäärä).
     
    public Keko() {
        this.heap = new HeapNode[10];
        this.size = 0;
    }
    
    public int getSize() {
        return size;
    }
    
    public boolean isEmpty() {
        if(size==0) {
            return true;
        }
        return false;
    }
    
    public int vanhempi(int i) {
        return (i-1)/2;
    }
    
    public int vasen(int i) {
        return (2*i + 1);
    }
    
    public int oikea(int i) {
        return (2*i + 2);
    }
    
    public void heapify(int i) {
        int v = vasen(i);
        int o = oikea(i);
        int pienin = -1;
        
        if(o < size) {
            if(heap[v].getDist() < heap[o].getDist()) {
                pienin = v;
            } else {
                pienin = o;
            }
            if(heap[i].getDist() > heap[pienin].getDist()) {
                HeapNode apu = heap[i];
                heap[i] = heap[pienin];
                heap[pienin] = apu;
            }
            heapify(pienin);
        } else if(v == size-1 && heap[i].getDist() > heap[v].getDist()){
                HeapNode apu = heap[i];
                heap[i] = heap[v];
                heap[v] = apu;
        }
    }
    
    public HeapNode kekoMin() {
        if(size==0) {
            return null;
        }
        HeapNode min = heap[0];
        heap[0] = heap[size-1];
        size = size-1;
        heapify(0);
        return min;
    }
    
    public void insert(HeapNode s) {
        if(size == 0) {
            heap[0] = s;
            size++;
            return;
        }
        
        int i = size;
        while(i>0 && heap[vanhempi(i)].getDist()>s.getDist()) {
            heap[i] = heap[vanhempi(i)];
            i = vanhempi(i);
        }
        heap[i] = s;
        size++;
        
        // Jos keossa ei tilaa enää uusille alkioille, kaksinkertaistetaan koko.
        if(size == heap.length) {
            HeapNode[] newheap = new HeapNode[2*heap.length];
            for(int j=0; j<heap.length; j++) {
                newheap[j] = heap[j];
            }
            this.heap = newheap;
        }
    }
    
    
    
    
}
