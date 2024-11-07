public class Enemigo {

    //atributos
    private String tipoEnemigo;
    private int ataque_minimo = 30;
    private int ataque_maximo = 50;
    private float vida;

    //constructor
    public Enemigo() {
        this.tipoEnemigo = "Necrofago";
        this.ataque_minimo = 30;
        this.ataque_maximo = 50;
        this.vida = GenerarVida();
    }

    //metodo ataque del enemigo
    public float atacar() {
        return (float) (Math.random() * (ataque_maximo - ataque_minimo + 1) + ataque_minimo);
    }

    //metodo vida del enemigo
    public float GenerarVida() {
        return (float) (Math.random() * (100 - 50 + 1) + 100);
    }


    public String getTipoEnemigo() {
        return tipoEnemigo;
    }

    public float getVida() {
        return vida;
    }

    public void setVida(float vida) {
        this.vida = vida;
    }
}
