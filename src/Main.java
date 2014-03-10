import java.io.File;
import java.io.IOException;

/**
 * Created by mario on 21/02/14.
 */
public class Main {
    public static void main(String[] args) throws IOException{
        //génération du fichier dot
        Generator generator = new Generator("doc/test.dot",5);

        //application de l'algo
        int[][] pi = Bellman.resolution(generator.formatGraphe.graphe);

        //print pi
        for(int i=0;i<pi.length;i++){
            for(int j=0; j<pi.length; j++){
                if(pi[i][j]>19999){
                    System.out.print("NOP\t");
                }else{
                    System.out.print(pi[i][j]+"\t");
                }
            }
            System.out.println();
        }
    }
}
