public class Jefe {

    //atributos
    private int ataque_minimo;
    private int ataque_maximo;
    private float vida;

    //constructor
    public Jefe() {
        this.ataque_minimo = 30;
        this.ataque_maximo = 50;
        this.vida = GenerarVida();
    }
    //metodo curar jefe
    public void curar(int cura) {
        if ((this.vida + cura) >= this.vida) {
            this.vida = GenerarVida();
        } else {
            this.vida += cura;
        }
    }

    //metodo ataque del jefe
    public float atacar() {
        return (float) (Math.random() * (ataque_maximo - ataque_minimo + 1) + ataque_minimo);
    }

    //metodo vida del jefe
    public float GenerarVida() {
        return (float) (Math.random() * (300 - 75 + 1) + 100);
    }
    public float getVida() {
        return vida;
    }

    public void setVida(float vida) {
        this.vida = vida;
    }

}
