import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

class SubsekvensRegister {

    private static Object s; 

    ArrayList<HashMap<String, Subsekvens>> hashbeholder = new ArrayList<>();  // lager en liste med hashmaper

    public void settin(HashMap<String, Subsekvens> map) { // setter inn metoden som legger den til arraylisten 
        hashbeholder.add(map);

    }

    public HashMap<String, Subsekvens> taUt() {
        return hashbeholder.remove(0); // tar ut et vilkålig hashmap 
    }

    public int antall() {
        return hashbeholder.size();  // sier noe om antalel på hashmappen 

    }

    

    public static HashMap<String, Subsekvens> lesfil(String filnavn) {  // leser inn filen 
        HashMap<String, Subsekvens> map = new HashMap <> ();  

        Scanner fil = null; // lager en scanner 

        
        try { // lager en try catch 
            fil = new Scanner( new File(filnavn));  // lese inn filen 
        } catch (FileNotFoundException e) {
            
            System.out.println("Fant ikke en fil");
        }

        while (fil.hasNextLine()){
            String linje = fil.nextLine();
             for( int  i = 0; i < linje.length()-2 ;i ++ ){ // bruker -2 for at man skal kunne få tre 
                String sekvens=  linje.substring( i ,i+3);
                if( ! map.containsKey(sekvens)){ // hvis den ikek finnes 
                    Subsekvens subsekvens = new Subsekvens (sekvens,1);
                    map.put( sekvens, subsekvens); // legges den til i mappen 

                }
                

             }
          
        }
        return map;


    }

    public static HashMap<String, Subsekvens> slaasammen ( HashMap<String, Subsekvens> map1,HashMap<String, Subsekvens> map2 ){
// lag ny hash map,  se om den finens alredde og den andre finnes,  ikek de er like sammen slå. 
        HashMap<String, Subsekvens> map3 = new HashMap<String, Subsekvens> ();
        
           for (String s: map1.keySet()){  // ieterer over map1 
                if( !map3.containsKey(s)){ // hvis den ikek finnes 
                    Subsekvens q = map1.get(s); 
                    map3.put(s,q); // legges den til 
                    

                } else {
                    Subsekvens q = map3.get(s); // men hvis den finnes 
                    q.endre(q.hent()+map1.get(s).hent()); // endres måte forkomsten og antall for å slaasmmane 
                }


            }
           for( String l: map2.keySet()) { // gjør akkuarat det samme for map 2 

            if(!map3.containsKey(l)){
                Subsekvens m= map2.get(l);
                map3.put(l,m);

            } else {
                Subsekvens m = map3.get(l);
                m.endre(m.hent()+map2.get(l).hent());
            }

        

        }
       
        return map3; // retunen den slaasammeingen 

    }  

    

}