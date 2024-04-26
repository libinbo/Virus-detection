import java.io.File;
import java.util.Scanner;

import java.io.FileNotFoundException;
import java.util.*;

class Oblig5del2A{


 public static void main (String [] args ) {

    SubsekvensRegister reg = new SubsekvensRegister (); // tar in en subsekevs reg og en moitor og en liste med tprden 
    Monitor1 monitor = new Monitor1(reg);
    ArrayList <Thread> traad = new ArrayList<>();

    if (args.length < 1) {
        System.out.println(" finner ikke filen");
        System.exit(-1); // går ut av systmet 
    }



    try { 
// leser filen 
        File f = new File(args[0] + "\\metadata.csv");
        String s = args[0];
        Scanner fil =  new Scanner(f);
        while(fil.hasNextLine()){
            
            String [] linjer = fil.nextLine().split(",");
            
            
            traad.add( new Thread ( new LeseTrad(s+"\\" + linjer[0],monitor))); // legger den til listen, og den tar inn filen og mointoren 

            

            
        }

        for (Thread t: traad){ // starter om hver traad
            t.start(); 

        }

        for (Thread ta: traad){ // og joiner den 
            ta.join();
        }



        while(monitor.antall() >1){  // hvis den er mer en skal vi kunne sammen slaa den og legge til moitoren 

            HashMap<String, Subsekvens> en = monitor.taUt();
                HashMap<String, Subsekvens> to = monitor.taUt();
                HashMap<String, Subsekvens> sammen =  Monitor1.slaasammen(en, to);
                monitor.settin(sammen);
            


        }


        
        int teller = 0;

        Subsekvens flest= null;

        for( HashMap<String, Subsekvens> map: monitor.sr.hashbeholder ){
            for (String string : map.keySet()){ // går gjennom nøkkelen 
                Subsekvens sek = map.get(string); // så går gjennom value, 

                
                if(sek.hent() > teller ){ // Sammenligner forkomsten 
                    teller = sek.hent(); //   holder på den med mest forekomst 

                    flest = sek;



                }


            }


        }

        System.out.println(flest);


    } catch (FileNotFoundException e){
        System.out.println(" fant ikke filen");

    }  catch (InterruptedException i){
        System.out.println("Ble avbutt");
    }


    
 

}   
}
