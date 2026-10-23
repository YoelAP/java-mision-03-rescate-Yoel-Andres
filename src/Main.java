import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner sc = new Scanner(System.in);
        char[][] estacion = new char[10][10];

        for (int f = 0; f < estacion.length; f++) {
            for (int c = 0; c < estacion.length; c++) {
                estacion[f][c] = '*';
            }
        }

        char robot = 'R';
        estacion[0][0] = robot;

        char meta = 'M';
        estacion[9][9] = meta;

        int vida = 10;

        int frandom = random.nextInt(10);
        int crandom = random.nextInt(10);


        for (int i = 0; i < 5; i++) {
            do {
                frandom = random.nextInt(10);
                crandom = random.nextInt(10);
            } while (estacion[frandom][crandom] != '*');
            estacion[frandom][crandom] = 'X';
        }

        do {
            frandom = random.nextInt(10);
            crandom = random.nextInt(10);
        } while (estacion[frandom][crandom] != '*');
        estacion[frandom][crandom] = 'B';


        int frobot = 0;
        int crobot = 0;


        do {
            for (int f = 0; f < 10; f++) {
                for (int c = 0; c < 10; c++) {
                    System.out.print(estacion[f][c] + " ");
                }
                System.out.println(" ");
            }

            System.out.print("Dime a donde quieres desplazarte: ");
            char mover = Character.toUpperCase(sc.next().charAt(0));

            if (mover == 'D') {
                if (crobot == 9) {
                    System.out.println("Estas en el limite, no puedes avanzar");
                }else{
                    if (estacion[frobot][crobot + 1] == 'X') {
                        System.out.println("Movimiento bloqueado");
                    }
                    else if (estacion[frobot][crobot + 1] == 'B') {
                        vida = vida + 2;
                        estacion[frobot][crobot] = '*';
                        crobot = crobot + 1;
                        estacion[frobot][crobot] = robot;
                        System.out.println("Tienes dos vidas mas: " + vida + " vidas");
                    }
                    else if (estacion[frobot][crobot + 1] == 'M') {
                        estacion[frobot][crobot] = '*';
                        crobot = crobot + 1;
                        estacion[frobot][crobot] = robot;
                        System.out.println("Rescate completado");

                        break;
                    }
                    else if(estacion[frobot][crobot + 1] == '*') {
                        estacion[frobot][crobot] = '*';
                        crobot = crobot + 1;
                        vida --;
                        estacion[frobot][crobot] = robot;
                        System.out.println("Te quedan: " + vida + " vida. Fin del juego.");
                    }
                }
            }

            if (mover == 'A') {
                if (crobot == 0) {
                    System.out.println("Estas en el limite, no puedes avanzar");
                }else{
                    if (estacion[frobot][crobot - 1] == 'X') {
                        System.out.println("Movimiento bloqueado");
                    }
                    else if (estacion[frobot][crobot - 1] == 'B') {
                        vida = vida + 2;
                        estacion[frobot][crobot] = '*';
                        crobot = crobot - 1;
                        estacion[frobot][crobot] = robot;
                        System.out.println("Tienes dos vidas mas: " + vida + " vidas");
                    }
                    else if (estacion[frobot][crobot - 1] == 'M') {
                        estacion[frobot][crobot] = '*';
                        crobot = crobot - 1;
                        estacion[frobot][crobot] = robot;
                        System.out.println("Rescate completado");

                        break;
                    }
                    else if(estacion[frobot][crobot - 1] == '*') {
                        estacion[frobot][crobot] = '*';
                        crobot = crobot - 1;
                        vida --;
                        estacion[frobot][crobot] = robot;
                        System.out.println("Te quedan: " + vida + " vida. Fin del juego.");
                    }
                }
            }

            if (mover == 'W') {
                if (frobot == 0) {
                    System.out.println("Estas en el limite, no puedes avanzar");
                }else{
                    if (estacion[frobot - 1][crobot] == 'X') {
                        System.out.println("Movimiento bloqueado");
                    }
                    else if (estacion[frobot - 1][crobot] == 'B') {
                        vida = vida + 2;
                        estacion[frobot][crobot] = '*';
                        frobot = frobot - 1;
                        estacion[frobot][crobot] = robot;
                        System.out.println("Tienes dos vidas mas: " + vida + " vidas. ");
                    }
                    else if (estacion[frobot - 1][crobot] == 'M') {
                        estacion[frobot][crobot] = '*';
                        frobot = frobot - 1;
                        estacion[frobot][crobot] = robot;
                        System.out.println("Rescate completado");

                        break;
                    }
                    else if(estacion[frobot - 1][crobot] == '*') {
                        estacion[frobot][crobot] = '*';
                        frobot = frobot - 1;
                        vida --;
                        estacion[frobot][crobot] = robot;
                        System.out.println("Te quedan: " + vida + " vida. Fin del juego.");
                    }
                }
            }

            if (mover == 'S') {
                if (frobot == 9) {
                    System.out.println("Estas en el limite, no puedes avanzar");
                }
                else{
                    if (estacion[frobot + 1][crobot] == 'X') {
                        System.out.println("Movimiento bloqueado");
                    }
                    else if (estacion[frobot + 1][crobot] == 'B') {
                        vida = vida + 2;
                        estacion[frobot][crobot] = '*';
                        frobot = frobot + 1;
                        estacion[frobot][crobot] = robot;
                        System.out.println("Tienes dos vidas mas: " + vida + " vidas");
                    }
                    else if (estacion[frobot + 1][crobot] == 'M') {
                        estacion[frobot][crobot] = '*';
                        frobot = frobot + 1;
                        estacion[frobot][crobot] = robot;
                        System.out.println("Rescate completado");

                        break;
                    }
                    else if(estacion[frobot + 1][crobot] == '*') {
                        estacion[frobot][crobot] = '*';
                        frobot = frobot + 1;
                        vida --;
                        estacion[frobot][crobot] = robot;
                        System.out.println("Te quedan: " + vida + " vida. Fin del juego.");
                    }
                }
            }
        } while (vida != 0);

    }
}

