public class Curas {

    //atributos
    private int cura;
    private float prob_dano;
    private String nombre;

    //constructor
    public Curas(String nombre) {
        this.nombre = nombre;
        cura = 150;
        prob_dano = (float) Math.random();
    }

    //metodo para calcular la vida que da la cura
    public int calcularSanacion() {
        int cura;
        if (prob_dano >= 0.6) {
            cura = this.cura * -1;
        } else {
            cura = (int) (this.cura * (1 - prob_dano));
        }
        return cura;
    }

    public int getCura() {
        return cura;
    }

    public float getProb_dano() {
        return prob_dano;
    }

    public String getNombre() {
        return nombre;
    }
}