public class GardienTeleportable extends Gardien implements Teleportable{
    public GardienTeleportable(String type, int id){
        super(type,id);
    }
    public void seTeleporter(Grille grille) throws CoordonneesIncorrectesException,CaseNonPleineException{
        int x=super.getX();
        int y=super.getY();
        System.out.println("Le gardien est a la position initiale ("+x+","+y+")");
        if(Math.random()<0.9){
            int xnew, ynew;
            do {
                xnew=(int)(Math.random()*grille.nbLignes);
                ynew=(int)(Math.random()*grille.nbColonnes);
            }while(!grille.sontValides(xnew,ynew));
            this.setPosition(xnew,ynew);
            //System.out.println("position du gardien apres teleportation ("+xnew+","+ynew+")");
            grille.setCase(xnew,ynew,grille.videCase(x,y));
            System.out.println("Le gardien s'est teleporte dans la position ("+xnew+","+ynew+")");            
        }else{
            System.out.println("Pas de teleportation du gardien");
        }  
    }
    public String toString(){
        return super.toString()+" (Gardien teleportable)";
    }

}