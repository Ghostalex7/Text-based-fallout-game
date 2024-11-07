import java.util.Random;
import java.util.Scanner;

public class Main {
    // Método objeto aleatorio
    public static String nombreObjeto() {
        String nombre = "";
        Random random = new Random();
        int tipo_objeto = random.nextInt(3) + 1;
        switch (tipo_objeto) {
            case 1:
                nombre = "estimulante";
                break;
            case 2:
                nombre = "carne perro";
                break;
            case 3:
                nombre = "carne mutaracha";
                break;
        }
        return nombre;
    }

    // Método pelea entre jugador y enemigos
    public static Principal pelea(Principal noname, Scanner scanner) {
        //inicio  pelea
        System.out.println("Hay pelea");
        Random random = new Random();
        int numEnemigos = random.nextInt(3) + 1;
        Enemigo[] necrofago = new Enemigo[numEnemigos];

        //generación y configuración de los enemigos
        System.out.println("Tienes " + numEnemigos + " enemigos");
        float vida_enemigo = 0;
        for (int i = 0; i < numEnemigos; i++) {
            necrofago[i] = new Enemigo();
            if (necrofago[i].GenerarVida() >= 0) {
                vida_enemigo += necrofago[i].GenerarVida();
            }
        }

        //bucle pelea
        int que_hacer = 0;
        while (noname.getVida() > 0 && vida_enemigo > 0) {
            System.out.println("1. Nuestros stats");
            System.out.println("2. Stats del enemigo");
            System.out.println("3. Atacar");
            System.out.println("4. Curar");

            que_hacer = scanner.nextInt();

            switch (que_hacer) {
                case 1:
                    //stats personaje
                    System.out.println("Vida = " + noname.getVida());
                    System.out.println("Ataque = " + noname.getAtaque());
                    System.out.println("Suerte = " + noname.getSuerte());
                    break;
                case 2:
                    //stats enemigo
                    for (int i = 0; i < numEnemigos; i++) {
                        if (necrofago[i].getVida() >= 0) {
                            System.out.println("El enemigo " + (i + 1) + " tiene " + necrofago[i].getVida() + " de vida y " + necrofago[i].atacar() + " de ataque");
                        }
                    }
                    break;
                case 3:
                    // atacar
                    System.out.println("Elige el enemigo a atacar:");
                    for (int i = 0; i < numEnemigos; i++) {
                        if (necrofago[i].getVida() > 0) {
                            System.out.println((i + 1) + ". El enemigo " + (i + 1));
                        }
                    }
                    int select_enemigo = scanner.nextInt();
                    if (necrofago[select_enemigo - 1].getVida() > 0) {
                        float ataqueJugador = noname.atacar();
                        float ataqueEnemigo = necrofago[select_enemigo - 1].atacar();
                        necrofago[select_enemigo - 1].setVida(necrofago[select_enemigo - 1].getVida() - ataqueJugador);
                        System.out.println("Has hecho un ataque de " + ataqueJugador + " al enemigo.");
                    }
                    break;
                case 4:
                    //curar
                    noname.curar(100);
                    System.out.println("Te has curado 100 de vida.");
                    break;
            }
            //ataque enemigos
            if (que_hacer == 3||que_hacer == 4) {
                for (int i = 0; i < numEnemigos; i++) {
                    if (necrofago[i].getVida() > 0) {
                        float ataqueEnemigo = necrofago[i].atacar();
                        noname.setVida(noname.getVida() - ataqueEnemigo);
                        System.out.println("El enemigo "+ (i + 1) + "te ha quitado " + ataqueEnemigo + "de vida");
                    }
                }
            }

            //actualizar vida  enemigos
            vida_enemigo = 0;
            for (int i = 0; i < numEnemigos; i++) {
                if (necrofago[i].getVida() > 0) {
                    vida_enemigo += necrofago[i].getVida();
                }
            }
        }
        //final pelea enemigos
        if (vida_enemigo <= 0) {
            System.out.println("Has derrotado a todos los enemigos");
        }
        return noname;
    }

    //metodo pelea jugador jefe
    public static Principal PeleaJefe(Principal noname, Scanner scanner) {
        //inicio pelea
        System.out.println("Te has encontrado con un lider supermutante, estas en el final del camino ");
        Jefe jefe = new Jefe();
        System.out.println("El jefe tiene " + jefe.getVida() + " de vida y " + jefe.atacar() + " de ataque ");

        //bucle pelea
        int opcion;
        while (noname.getVida() > 0 && jefe.getVida() > 0) {
            System.out.println("1. Nuestros stats");
            System.out.println("2. Stats del jefe");
            System.out.println("3. Atacar");
            System.out.println("4. Curarse");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    //stats jugador
                    System.out.println("Vida = " + noname.getVida());
                    System.out.println("Ataque = " + noname.getAtaque());
                    System.out.println("Suerte = " + noname.getSuerte());
                    break;
                case 2:
                    //stats del jefe
                    System.out.println("Vida del Jefe = " + jefe.getVida());
                    System.out.println("Ataque del Jefe = " + jefe.atacar());
                    break;

                case 3:
                    //atacar
                    float ataqueJugador = noname.atacar();
                    jefe.setVida(jefe.getVida() - ataqueJugador);
                    System.out.println("Has hecho un ataque de " + ataqueJugador);
                    break;
                case 4:
                    //curar
                    noname.curar(100);
                    System.out.println("Te has curado 100 de vida");
                    break;

            }
            //curar jefe
            if (jefe.getVida() < 150) {
                if (Math.random() < 0.25) {
                    jefe.curar(100);
                    System.out.println("El Jefe supermutante se ha curado.");
                }
            }
            //ataque jefe al jugador
            if (opcion == 3||opcion == 4) {
                float ataqueJefe = jefe.atacar();
                noname.setVida(noname.getVida() - ataqueJefe);
                System.out.println("El jefe te ha atacado y te ha quitado " + ataqueJefe);
            }
        }
        return noname;
    }

    //metodo principal
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Principal noname = new Principal();

        Curas curas = new Curas(nombreObjeto());
        System.out.println("Has encontrado " + curas.getNombre());
        System.out.println("Tiene una cura de " + curas.getCura() + " y una probabilidad de daño de " + curas.getProb_dano());
        System.out.println("¿Quieres tomarlo? (1 si / 0 no)");
        int tomar = scanner.nextInt();
        if (tomar == 1) {
            noname.curar(curas.calcularSanacion());
        } else {
            System.out.println("No tomas nada");
        }

        Enemigo enemigo = new Enemigo();
        float ataqueEnemigo = enemigo.atacar();
        System.out.println("Te has encontrado un " + enemigo.getTipoEnemigo());
        System.out.println("El enemigo ha realizado un ataque de " + ataqueEnemigo + " puntos.");
        noname.curar((int)-ataqueEnemigo);

        System.out.println("Tus stats son:");
        System.out.println("Vida = " + noname.getVida());
        System.out.println("Ataque = " + noname.getAtaque());
        System.out.println("Suerte = " + noname.getSuerte());

        // Bucle principal del juego
        while (noname.getVida() > 0) {
            int movimiento = noname.mover();
            if (movimiento == 1) {
                noname = pelea(noname, scanner);
                if (noname.getVida() <= 0) {
                    System.out.println("Has muerto.");
                    break; // Muerte por vida
                }
            } else if (movimiento == 2 || movimiento == 0) {
                System.out.println("Has terminado el juego.");
                break; // Fin del juego
            }
        }



    }

}
