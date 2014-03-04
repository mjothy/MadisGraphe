import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by mario on 21/02/14.
 */
public class Generator {
    public String name;
    public int nbNoeuds;
    public int borneLink;

    public Generator(String name, int nbNoeuds) {
        this.name = name;
        this.nbNoeuds = nbNoeuds;
        this.borneLink = ((int) (Math.random()*nbNoeuds))+2;
    }

    public void generate(){
        File fichier = new File(name);
        try{
            FileWriter out = new FileWriter(fichier);
            out.write("digraph G {\n");
            for (int i = 0; i < nbNoeuds; i++) {
                //Array which contains the nodes who will be linked with i
                ArrayList<Integer> traites = new ArrayList<Integer>();
                //Filling the arraylist
                for(int k = 0; k<borneLink; k++){
                    int alea = (int) (Math.random()*(nbNoeuds-1))+1;
                    //if there is already the node in the arraylist, skip
                    if(traites.contains(alea)){
                        continue;
                    //if the number is not the actual node
                    }else if(alea!=i){
                        traites.add(alea);
                    //if the number is the node in the first iteration, break (to get some i;)
                    }else if(k==0){
                        break;
                    }
                }
                if(traites.isEmpty()){
                    out.write("\t"+i+";\n");
                }else{
                    //sort the array
                    Collections.sort(traites);
                    //write the data
                    for(int alea : traites){
                        out.write("\t"+i+" -> " +alea+" [label = \"1[0]\"]"+";\n");
                    }
                }
            }
            out.write("}");
            out.close();
        }catch(Exception e){
            System.err.println("Erreur d'ecriture");
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
