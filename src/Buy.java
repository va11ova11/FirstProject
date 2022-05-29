
public class Buy
{
    public static void main(String[] args) {
        Buy2 buy2 = new Buy2();
        buy2.Buy2(10.2,22,13);
        System.out.println("Объём равен: " + buy2.GetS());


    }

}

class Buy2{
    double visota;
    double dlina;
    double shirina;


    void Buy2(double visota, double dlina, double shirina){
        this.visota = visota;
        this.dlina = dlina;
        this.shirina = shirina;
    }

    double GetS(){
        double S = visota * dlina * shirina;
        return S;
    }




}