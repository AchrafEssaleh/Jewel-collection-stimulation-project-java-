//ELAMOURI Sara 21106775
//ESSALEH Achraf 21118166
public class Joyaux extends Contenu{
    private int prix;
    public Joyaux(String s,int qt){
        super(s, qt);
        prix=(int)(Math.random()*(10000)+1);
    }
    public String toString(){
        return "Joyaux"+super.toString()+"prix"+prix;
    }
    public int getprix(){
        return prix;
    }

}