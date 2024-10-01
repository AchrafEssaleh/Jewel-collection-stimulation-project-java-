//ELAMOURI Sara 21106775
//ESSALEH Achraf 21118166
import java.util.ArrayList;
public class Agent10{
    private int ligne;
    private int colonne;
    private Grille g;
    private ArrayList<Joyaux> j=new ArrayList<Joyaux>();
    public Agent10(int ligne,int colonne,Grille g){
        this.ligne=ligne;
        this.colonne=colonne;
        this.g=g;
    }
    public void seDeplacer(int xnew, int ynew) throws DeplacementIncorrectException, CoordonneesIncorrectesException, CaseNonPleineException {
		if (xnew > g.nbLignes || ynew > g.nbColonnes || xnew < 0 || ynew < 0) {
			throw new DeplacementIncorrectException("deplacement incorrect");
		} else {
			ligne = xnew;
			colonne = ynew;
			if (!g.caseEstVide(xnew, ynew)) {
				if (g.getCase(xnew, ynew) instanceof Joyaux) {
					j.add((Joyaux) (g.videCase(xnew, ynew)));

				} else if (g.getCase(xnew, ynew) instanceof Gardien) {
					j.clear();
				}

			}
		}
	}
    public void seDeplacer(int xnew, int ynew,int f) throws DeplacementIncorrectException, CoordonneesIncorrectesException, CaseNonPleineException {
		if (xnew > g.nbLignes || ynew > g.nbColonnes || xnew < 0 || ynew < 0) {
			throw new DeplacementIncorrectException("deplacement incorrect");
		} else {
			ligne = xnew;
			colonne = ynew;
			if (!g.caseEstVide(xnew, ynew)) {
				if (g.getCase(xnew, ynew) instanceof Joyaux) {
					j.add((Joyaux) (g.videCase(xnew, ynew)));
            }else if (g.getCase(xnew, ynew) instanceof Gardien) {
                Contenu c = g.getCase(xnew, ynew);
                if (((Gardien) (c)).getnv() <= f) {
                    g.videCase(xnew, ynew);
                } else {
                    j.clear();
                    ((Gardien) (g.getCase(xnew, ynew))).modifier(f);
                }
            }
        }
    }}
    public int fortune(){
        int s=0;
        for(int i=0;i<j.size();i++){
            s+=j.get(i).getprix();
        }
        return s;
    }
    public void contenuSac(){
        for(int i=0;i<j.size();i++){
                System.out.println(j.get(i).toString());
    }

}
public int getPositionL(){
    return ligne;
}
public int getPositionC(){
    return colonne;
}
public String getPosition(){
    return "("+ligne+","+colonne+")";
}}