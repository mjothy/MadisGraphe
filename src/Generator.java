import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by mario on 21/02/14.
 * This class creates a simple .dot file readable by Graphviz and the API
 * The file will be created with nbNoeud nodes and a random number of links per node is between 0 and nbNode+2
 * There will be random capacities for each links from 1 to 11
 */
public class Generator {
    public String name;
    public int nbNoeuds;
    public int borneLink;

    public FormatGraphe formatGraphe;

    public Generator(String name, int nbNoeuds) {
        this.name = name;
        this.nbNoeuds = nbNoeuds;
        this.borneLink = ((int) (Math.random()*nbNoeuds))+2;
        //generating the dot
        generate();
        File file = new File(name);
        try {
            this.formatGraphe = new FormatGraphe(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Sorting the file
        formatGraphe.ecrireGraphe("doc/nomFichier.dot");
    }

    private void generate(){
        File fichier = new File(name);
        try{
            FileWriter out = new FileWriter(fichier);
            out.write("digraph G {\n");
            for (int i = 0; i < nbNoeuds; i++) {
                //Array which contains the nodes who will be linked with i
                ArrayList<Integer> traites = new ArrayList<Integer>();
                //Filling the arraylist
                for(int k = 0; k<borneLink; k++){
                    //randomizing the destination node
                    int alea = (int) (Math.random()*(nbNoeuds-1))+1;
                    //if there is already the node in the arraylist, skip
                    if(traites.contains(alea)){
                        continue;
                    //if the alea is not the node
                    }else if(alea!=i){
                        traites.add(alea);
                    //if the alea is the node in the first iteration, break (to get some i;)
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
                        //randomizing capacity
                        int capacite = (int)((Math.random()*10)+1);
                        out.write("\t"+i+" -> " +alea+" [label = \"1["+capacite+"]\"]"+";\n");
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
