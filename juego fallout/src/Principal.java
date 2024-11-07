import java.io.Serializable;
import java.util.Random;
import java.util.Scanner;

public class Principal extends Personaje{
    //atributos
    private String nombre;
    private int edad;
    private static final int vida_min_init = 100;
    private static int vida_max_init = 500;
    private static final int ataque_max = 100;

    //constructor
    public Principal() {
        Scanner scanner = new Scanner(System.in);
        vida = (float) (Math.random() * (vida_max_init - vida_min_init + 1) + vida_min_init);
        vida_maxima = vida;
        ataque = (float) (Math.random() * (ataque_max + 10));
        suerte = (float) (Math.random() * 0.75);

        System.out.println("Bienvenido al yermo superviviente");
        System.out.println("¿Cuál es tu nombre?");
        nombre = scanner.nextLine();
        System.out.println("¿Cuál es tu edad?");
        edad = scanner.nextInt();
        System.out.println("Tus stats son:");
        System.out.println("Vida = " + vida);
        System.out.println("Ataque = " + ataque);
        System.out.println("Suerte = " + suerte);
    }

    //metodo para verificar si hay batalla
    public static int checkBatalla(int prob) {
        Random random = new Random();
        if (random.nextInt(prob) + 1 >= 5) {
            return 1;
        } else {
            return 0;
        }
    }

    //metodo movimiento jugador
    public int mover() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("¿Hacia dónde quieres ir?:");
        System.out.println("1. Norte");
        System.out.println("2. Sur(Alerta por Jefe Supermutante)");
        System.out.println("3. Este");
        System.out.println("4. Oeste");
        int opcion = scanner.nextInt();
        int batalla = 0;
        switch (opcion) {
            case 1:
                System.out.println("Te has movido hacia el Norte.");
                batalla = 1;
                break;
            case 2:
                System.out.println("Te has movido hacia el Sur.");
                System.out.println("No hay vida humana en esta direccion, pero supermutantes si");
                Main.PeleaJefe(this,scanner);
                break;
            case 3:
                System.out.println("Te has movido hacia el Este.");
                batalla = checkBatalla(5);{
                    Main.pelea(this,scanner);
                };
                break;
            case 4:
                System.out.println("Te has movido hacia el Oeste.");
                batalla = checkBatalla(10);{
                    Main.pelea(this,scanner);
            }
                break;

        }
        if (batalla == 1) {
            System.out.println("Has encontrado enemigos");

        }
        return opcion;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }
}
