
import java.util.Scanner;

public class Main {

    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        int korkeus = -1;
        int leveys = -1;

        System.out.println("Anna ruudukon korkeus:");
        korkeus = Integer.parseInt(input.nextLine());
        System.out.println("Anna ruudukon leveys: ");
        leveys = Integer.parseInt(input.nextLine());
        Ruudukko rm = new Ruudukko(korkeus, leveys);
        Ruudukko rd = new Ruudukko(korkeus, leveys);

        ruudukko:
        while (true) {
            System.out.println("Anna ruudukko: ");

            int i = korkeus - 1;

            while (input.hasNextLine()) {
                String rivi = input.nextLine();
                if (rivi.length() != leveys) {
                    System.out.println("Annoit väärän kokoisen rivin");
                    break;
                }
                for (int j = 0; j < leveys; j++) {
                    if (rivi.charAt(j) == 'A') {
                        rm.setAlku(i, j);
                        rm.setSolmu(i, j, false);
                        rm.getAlku().setDist(0);
                        rd.setAlku(i, j);
                        rd.setSolmu(i, j, false);
                        rd.getAlku().setDist(0);
                    } else if (rivi.charAt(j) == 'L') {
                        rm.setLoppu(i, j);
                        rm.setSolmu(i, j, false);
                        rd.setLoppu(i, j);
                        rd.setSolmu(i, j, false);                       
                    } else if (rivi.charAt(j) == 'X') {
                        rm.setSolmu(i, j, true);
                        rd.setSolmu(i, j, true);
                    } else if (rivi.charAt(j) =='.') {
                        rm.setSolmu(i, j, false);
                        rd.setSolmu(i, j, false);
                    } else {
                        System.out.println("Annoit virheellisen merkin");
                        break;
                    }
                }
                i--;
                if (i < 0) {
                    break ruudukko;
                }
            }

        }
        
        System.out.print("\n\n");
        
        Astar pathFinder = new Astar();
        boolean pathFound = pathFinder.etsiPolku(rd, new Dijkstra());
        
        if(pathFound) {
            System.out.println("Dijkstran algoritmilla polkua haettaessa tutkittiin solmuja yhteensä "+pathFinder.getCount());
            pathFinder.etsiPolku(rm, new Manhattan());
            System.out.println("A* algoritmilla polkua haettaessa tutkittiin solmuja yhteensä "+pathFinder.getCount());
            System.out.println("");
            rm.tulosta();
        } else {
            System.out.println("Polkua ei löydy");
        }
        
    }
}
