import java.io.Serializable;

public class Personaje implements Serializable {

    //atributos
    protected float vida;
    protected float vida_maxima;
    protected float ataque;
    protected float suerte;

    //metodo curar personaje
    public void curar(int cura) {
        if ((this.vida + cura) >= this.vida_maxima) {
            this.vida = this.vida_maxima;
        } else {
            this.vida += cura;
        }
    }

    //metodo atacar enemigo
    public float atacar() {
        float suerte;
        float ataque;

        suerte = (float) Math.random() + this.suerte;
        if (suerte >= 0.7) {
            ataque = this.ataque * suerte;
        } else {
            ataque = 0;
        }
        return ataque;
    }

    public float getVida() {
        return vida;
    }

    public float getAtaque() {
        return ataque;
    }

    public float getSuerte() {
        return suerte;
    }

    public void setVida(float vida) {
        this.vida = vida;
    }

    public void setVida_maxima(float vida_maxima) {
        this.vida_maxima = vida_maxima;
    }
}
