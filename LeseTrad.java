
import java.util.HashMap;

class LeseTrad implements Runnable{ // tar inn runnabel 

    private String filnavn = null; // tar inn filnavn 
    private Monitor1 m = null; // monitor 


    public LeseTrad(String filnavn,Monitor1 m){ // lager denen konstruktør 
        this.filnavn= filnavn; // med instansvaribalene 
        this.m= m;
    }

   
   
    @Override
    public void run(){ // oversiker run 

        HashMap <String , Subsekvens > map = SubsekvensRegister.lesfil(filnavn);

        m.settin(map); // legger hashmaen inn i moitoren 
        


    }

}

