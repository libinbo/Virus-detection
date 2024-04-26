import java.util.HashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


class Monitor1 { 
    SubsekvensRegister sr= null ;
    public static Lock laas = new ReentrantLock ();

    public Monitor1( SubsekvensRegister sr){

        this.sr=sr;

    }
    


    public void settin ( HashMap <String, Subsekvens> hash){

        laas.lock();

        try {

         
            sr.settin(hash);


         

           
        } finally {

            laas.unlock();

        }

        
    
    



    }
    
    public HashMap<String, Subsekvens> taUt (){

        laas.lock();

        try {

         
            return sr.taUt();


         

           
        } finally {

            laas.unlock();

        }
        



    }
    

    public int antall(){

        return sr.antall(); 



    }


    public static HashMap < String, Subsekvens> lesfil( String filnavn){
        HashMap<String, Subsekvens> map = new HashMap <> ();

        laas.lock();

        try {
            return SubsekvensRegister.lesfil(filnavn);

         

           
        } finally {

            laas.unlock();

        }



    }

    public static HashMap<String, Subsekvens> slaasammen ( HashMap<String, Subsekvens> map1,HashMap<String, Subsekvens> map2 ){

        HashMap<String, Subsekvens> map3 = new HashMap<String, Subsekvens> ();

        laas.lock();

        try {
            return SubsekvensRegister.slaasammen(map1, map2);

         

           
        } finally {

            laas.unlock();

        }
    }



    
    


    



}