import java.util.ArrayList;

/**
 * Created by mario on 21/02/14.
 */
public class Bellman {
    private int[][] pis;
    private int taille;

    public Bellman(int[][] pis,int taille) {
        this.pis = pis;
        this.taille = taille;
    }

    public int[][] algo(){
        for(int k=0; k<taille; k++){
            int[][] pisTemp = new int[this.taille][this.taille];
            for(int i=0; i<taille; i++){
                for(int j=0; j<taille; j++){
                    pisTemp[i][j] = Math.min(pis[i][j], pis[i][k]+pis[k][j]);
                }
            }
            pis=pisTemp;
        }
        return pis;
    }

    public static int[][] resolution(Graphe graphe){
        FormatGraphe formatGraphe = new FormatGraphe(graphe);
        int[][] matrice = formatGraphe.getMatrice();
        //initialisation
        int taillegraphe = graphe.getNbSommets();
        int[][] init = new int[taillegraphe][taillegraphe];
        for(int i=0; i<taillegraphe;i++){
            for(int j=0; j<taillegraphe; j++){
                if(matrice[i][j]!=0){
                    int temp = graphe.getNoeud(i).successeurs.indexOf(graphe.getNoeud(j));
                    init[i][j] = graphe.getNoeud(i).getCapacite(temp);
                }else if(i==j){}
                else{
                    init[i][j] = 20000;
                }
            }
        }
        Bellman bellman = new Bellman(init, taillegraphe);
        return bellman.algo();
    }
}
