import java.io.File;
import java.io.IOException;

/**
 * Created by mario on 21/02/14.
 */
public class Main {
    public static void main(String[] args) throws IOException{
        Generator generator = new Generator("doc/test.dot",5);
        generator.generate();
        File fichier = new File("doc/nomFichier.dot");
        FormatGraphe formatGraphe = new FormatGraphe(fichier);
        for(Noeud noeud : formatGraphe.graphe.listeNoeuds){
            for(int i=0; i<noeud.getNbSucc(); i++){
                noeud.capacites.set(i,(int) (Math.random()*10));
            }
        }
        formatGraphe.ecrireGraphe("doc/nomFichier.dot");
        int[][] pi = Bellman.resolution(formatGraphe.graphe);
        for(int i=0;i<pi.length;i++){
            for(int j=0; j<pi.length; j++){
                if(pi[i][j]>19999){
                    System.out.print("NOP    ");
                }else{
                    System.out.print(pi[i][j]+"      ");
                }
            }
            System.out.println();
        }
    }
}
