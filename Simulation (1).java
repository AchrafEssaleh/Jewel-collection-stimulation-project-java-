//ELAMOURI Sara 21106775
//ESSALEH Achraf 21118166
public class Simulation{
    private Agent10 agent;
    private Grille grille;
    private Contenu[] tabContenu;
    public Simulation(Agent10 agent, Grille grille, Contenu[] tabContenu, int m) throws CoordonneesIncorrectesException, CaseNonPleineException {
       this.agent = agent;
       this.grille = grille;
       this.tabContenu = tabContenu;
       for (int i = 0; i < m; i++) {
          int x = (int) (Math.random() * grille.nbLignes);
          int y = (int) (Math.random() * grille.nbColonnes);
          int index = (int) (Math.random() * tabContenu.length);// prends aleatoirement un contenu du tableau et le  place dans la grille
            grille.setCase(x, y, tabContenu[index]);
}}
    @Override
    public String toString(){
    String res="--------------------------------------\nInformations sur la grille:\n";
        for(Contenu contenu:tabContenu){
            res+=contenu.toString() +"\n";
        }
        res="-------------------------------------\nAgent :"+agent;
        return res;
    }
    public void lance(int nbEtapes) throws CaseNonPleineException, DeplacementIncorrectException, CoordonneesIncorrectesException {
        // int xnew,ynew;
        int x = agent.getPositionL();
        int y = agent.getPositionC();
        System.out.println("l'agent est a la position initiale (" + x + "," + y + ")");
        String deplacementEffectue = " ";

        for (int i = 0; i < nbEtapes; i++) {
            do {
                x = agent.getPositionL();
                y = agent.getPositionC();
                if (Math.random() < 0.5) {
                    if (Math.random() < 0.5) {
                        // xnew=x;
                        // ynew=y+1;
                        y += 1;
                        deplacementEffectue = " 1 case a droite";
                    } else {
                        // xnew=x;
                        // ynew=y-1;
                        y -= 1;
                        deplacementEffectue = "1 case a gauche";
                    }
                } else {
                    if (Math.random() < 0.5) {
                        // xnew=x+1;
                        // ynew=y;
                        x += 1;
                        deplacementEffectue = "1 case en haut";
                    } else {
                        // xnew=x-1;
                        // ynew=y;
                        x -= 1;
                        deplacementEffectue = "1 case en bas";
                    }
                }
            } while (!grille.sontValides(x, y));

            if (Math.random() < 0.3) {
                int f = (int) (Math.random() * 90 + 10);
                System.out.println("----------------------------------------");
                System.out.println("L'agent se deplace avec force " + deplacementEffectue + " de " + agent.getPosition()
                        + " a (" + x + "," + y + ") , sa force est egale a " + f + " et sa fortune est egale a "
                        + agent.fortune());
                agent.seDeplacer(x, y, f);
            } else {
                System.out.println("----------------------------------------");
                System.out.println("L'agent se deplace sans force " + deplacementEffectue + " de " + agent.getPosition()
                        + " a (" + x + "," + y + ") , sa fortune est egale a " + agent.fortune());
                agent.seDeplacer(x, y);
            }

        }
    }
        

}