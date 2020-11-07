package ba.unsa.etf.rpr.tutorijal02;

public class Interval {
    private double prvaVrijednost, drugaVrijednost;
    boolean prvaUkljucena, drugaUkljucena;
    public Interval(){
        prvaVrijednost = 0; drugaVrijednost=0;
        prvaUkljucena = false; drugaUkljucena=false;
    }
    public Interval(double x, double y, boolean b1, boolean b2){
        if(x > y) throw new IllegalArgumentException();
        prvaVrijednost = x; drugaVrijednost = y;
        prvaUkljucena = b1; drugaUkljucena = b2;
    }

    public boolean isIn(double v) {
        if(v > prvaVrijednost && v < drugaVrijednost) return true;
        if(v >= prvaVrijednost && v < drugaVrijednost && prvaUkljucena) return true;
        if(v > prvaVrijednost && v <= drugaVrijednost && drugaUkljucena) return true;
        if(v >= prvaVrijednost && v <= drugaVrijednost && prvaUkljucena && drugaUkljucena) return true;
        return false;
    }

    public boolean isNull() {
        if(prvaVrijednost==0 && drugaVrijednost==0 && !prvaUkljucena && !drugaUkljucena) return true;
        return false;
    }

    public Interval intersect(Interval interval) {
        if(drugaVrijednost < interval.prvaVrijednost) return new Interval();
        if(interval.drugaVrijednost < prvaVrijednost) return new Interval();
        double novaPrvaVrijednost=0, novaDrugaVrijednost=0;
        boolean novaPrvaUkljucena=false, novaDrugaUkljucena=false;
        if(prvaVrijednost > interval.prvaVrijednost){
            novaPrvaVrijednost = prvaVrijednost;
            novaPrvaUkljucena = prvaUkljucena;
        }
        else{
            novaPrvaVrijednost = interval.prvaVrijednost;
            novaPrvaUkljucena = interval.prvaUkljucena;
        }
        if(drugaVrijednost < interval.drugaVrijednost){
            novaDrugaVrijednost = drugaVrijednost;
            novaDrugaUkljucena = drugaUkljucena;
        }
        else{
            novaDrugaVrijednost = interval.drugaVrijednost;
            novaDrugaUkljucena = interval.drugaUkljucena;
        }
        return new Interval(novaPrvaVrijednost, novaDrugaVrijednost, novaPrvaUkljucena, novaDrugaUkljucena);
    }
    public static Interval intersect(Interval interval1, Interval interval2){
        if(interval1.drugaVrijednost < interval2.prvaVrijednost) return new Interval();
        if(interval2.drugaVrijednost < interval1.prvaVrijednost) return new Interval();
        double novaPrvaVrijednost=0, novaDrugaVrijednost=0;
        boolean novaPrvaUkljucena=false, novaDrugaUkljucena=false;
        if(interval1.prvaVrijednost > interval2.prvaVrijednost){
            novaPrvaVrijednost = interval1.prvaVrijednost;
            novaPrvaUkljucena = interval1.prvaUkljucena;
        }
        else{
            novaPrvaVrijednost = interval2.prvaVrijednost;
            novaPrvaUkljucena = interval2.prvaUkljucena;
        }
        if(interval1.drugaVrijednost < interval2.drugaVrijednost){
            novaDrugaVrijednost = interval1.drugaVrijednost;
            novaDrugaUkljucena = interval1.drugaUkljucena;
        }
        else{
            novaDrugaVrijednost = interval2.drugaVrijednost;
            novaDrugaUkljucena = interval2.drugaUkljucena;
        }
        return new Interval(novaPrvaVrijednost, novaDrugaVrijednost, novaPrvaUkljucena, novaDrugaUkljucena);
    }
    public String toString(){
        String s = "";
        if(this.isNull()) return "()";
        if(prvaUkljucena) s=s+"[";
        else s=s+"(";
        s = s + prvaVrijednost + "," + drugaVrijednost;
        if(drugaUkljucena) s=s+"]";
        else s=s+")";
        return s;
    }
    public boolean equals(Object o){
        Interval interval = (Interval)o;
        if(prvaVrijednost == interval.prvaVrijednost && drugaVrijednost == interval.drugaVrijednost && prvaUkljucena==interval.prvaUkljucena && drugaUkljucena==interval.drugaUkljucena) return true;
        return false;
    }
}
