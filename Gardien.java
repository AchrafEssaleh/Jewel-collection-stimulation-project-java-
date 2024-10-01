//ELAMOURI Sara 21106775
//ESSALEH Achraf 21118166
public class Gardien extends Contenu{
    private int nv;
    public Gardien(String s,int qt){
        super(s,qt);
        nv=(int)(Math.random()*(201));
    }
    public String toString(){
        return "Gardien"+super.toString()+" point de vie"+nv;
    }
    public void modifier(int r){
        nv= nv-r;
    }
    public int getnv(){
        return nv;
    }
}