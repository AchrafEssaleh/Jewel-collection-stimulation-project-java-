
public class TestSimulation{
    public static void main (String [] args ){
        Grille grille = new Grille(5,5);
        GardienTeleportable gardienT = new GardienTeleportable("GarTel",2);
        Contenu[] tabContenu={new Gardien("gardien",1),new Joyaux("diamant",5),new Gardien("gardien",2),new Joyaux("rubis",4),new Joyaux("rubis",5),new Joyaux("opale",4),new Gardien("gardien",3), new Joyaux("opale",7),gardienT};
        System.out.println("gardienT au debut ("+gardienT.getX()+","+gardienT.getY()+")");
        try{
            Agent10 agent = new Agent10(0,0,grille);
            Simulation simulation= new Simulation(agent,grille,tabContenu,9);
            System.out.println("Etat initial de la simulation : \n"+simulation.toString());
            grille.affiche(10);
            simulation.lance(10);
            System.out.println("________________________________debut de telportation ___________________________________________");
            gardienT.seTeleporter(grille);
            System.out.println("_________________________________fin de telportation ____________________________________________'\n'");
            grille.affiche(10);
            System.out.println("\nEtat final de la simulation : \n"+simulation.toString());
        }catch(DeplacementIncorrectException e){
            System.out.println(e.toString());
        }catch(CaseNonPleineException e){
            System.out.println(e.toString());
        }catch(CoordonneesIncorrectesException e){
            System.out.println(e.toString());
        }
    }
}
