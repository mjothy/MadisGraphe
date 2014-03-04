import java.util.Vector;

/**
 * Cette classe fournit une repr�sentation objet d'un graphe.
 * <P>Elle contient la liste listeNoeuds des noeuds du graphe
 *  et un bool�en oriente qui indique si le graphe est orient� ou non.
 *  <BR>Elle poss�de plusieurs m�thodes qui permettent de r�cup�rer des
 *  informations sur le graphe.
 *
 */
public class Graphe {
	protected Vector<Noeud> listeNoeuds;
	protected boolean oriente; // Orient� (true) ou non-orient� (false)
	
	public Graphe(boolean oriente){
		this.oriente = oriente;
		listeNoeuds = new Vector<Noeud>();
	}
	
	public Noeud getNoeud(int index){
		return listeNoeuds.get(index);
	}
	
	public Noeud getNoeud(String nom){
		Noeud recherche = null;
		for (int i = 0; i < listeNoeuds.size() && recherche == null; i++) {
			if(listeNoeuds.get(i).getNom().equals(nom)){
				recherche = listeNoeuds.get(i);
			}
		}
		return recherche;
	}
	
	public void addNoeud(Noeud nd){
		listeNoeuds.add(nd);
	}
	
	public int getNbSommets(){
		return listeNoeuds.size();
	}
	
	public int indexOf(Noeud nd){
		return listeNoeuds.indexOf(nd);
	}
	
	public String[] getListesommets(){
		String[] liste = new String[listeNoeuds.size()];
		for (int i = 0; i < listeNoeuds.size(); i++) {
			liste[i] = listeNoeuds.get(i).getNom();
		}
		return liste;
	}
	
	public boolean isOriente(){
		return oriente;
	}
}
