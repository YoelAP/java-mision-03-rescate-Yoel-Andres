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

        char meta = 'F';
        estacion[9][9] = meta;

        int frandom;
        int crandom;

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

        for (int f = 0; f < 10; f++) {
            for (int c = 0; c < 10; c++) {
                System.out.print(estacion[f][c] + " ");
            }
            System.out.println();
        }

        int frobot = 0;
        int crobot = 0;
        int vidas = 10;
        do {
            System.out.print("Dime a donde quieres desplazarte (W/A/S/D): ");
            char mover = sc.next().charAt(0);

            if (mover == 'D') {
                if (crobot == 9) {
                    System.out.println("Estas en el limite, no puedes avanzar");
                } else {
                    if (estacion[frobot][crobot + 1] == 'X') {
                        System.out.println("Movimiento bloqueado");
                    } else if (estacion[frobot][crobot + 1] == 'B') {
                        vidas = vidas + 2;
                        estacion[frobot][crobot] = '*';
                        crobot = crobot + 1;
                        estacion[frobot][crobot] = robot;
                        System.out.println("Tienes dos vidas mas");
                    } else if (estacion[frobot][crobot + 1] == meta) {
                        estacion[frobot][crobot] = '*';
                        crobot = crobot + 1;
                        estacion[frobot][crobot] = robot;
                        System.out.println("Rescate completado");
                    } else if (estacion[frobot][crobot + 1] == '*') {
                        estacion[frobot][crobot] = '*';
                        crobot = crobot + 1;
                        estacion[frobot][crobot] = robot;
                    }
                }
            }

            if (mover == 'A') {
                if (crobot == 0) {
                    System.out.println("Estas en el limite, no puedes avanzar");
                } else {
                    if (estacion[frobot][crobot - 1] == 'X') {
                        System.out.println("Movimiento bloqueado");
                    } else if (estacion[frobot][crobot - 1] == 'B') {
                        vidas = vidas + 2;
                        estacion[frobot][crobot] = '*';
                        crobot = crobot - 1;
                        estacion[frobot][crobot] = robot;
                        System.out.println("Tienes dos vidas mas");
                    } else if (estacion[frobot][crobot - 1] == meta) {
                        estacion[frobot][crobot] = '*';
                        crobot = crobot - 1;
                        estacion[frobot][crobot] = robot;
                        System.out.println("Rescate completado");
                    } else if (estacion[frobot][crobot - 1] == '*') {
                        estacion[frobot][crobot] = '*';
                        crobot = crobot - 1;
                        estacion[frobot][crobot] = robot;
                    }
                }
            }

            if (mover == 'W') {
                if (frobot == 0) {
                    System.out.println("Estas en el limite, no puedes avanzar");
                } else {
                    if (estacion[frobot - 1][crobot] == 'X') {
                        System.out.println("Movimiento bloqueado");
                    } else if (estacion[frobot - 1][crobot] == 'B') {
                        vidas = vidas + 2;
                        estacion[frobot][crobot] = '*';
                        frobot = frobot - 1;
                        estacion[frobot][crobot] = robot;
                        System.out.println("Tienes dos vidas mas");
                    } else if (estacion[frobot - 1][crobot] == meta) {
                        estacion[frobot][crobot] = '*';
                        frobot = frobot - 1;
                        estacion[frobot][crobot] = robot;
                        System.out.println("Rescate completado");
                    } else if (estacion[frobot - 1][crobot] == '*') {
                        estacion[frobot][crobot] = '*';
                        frobot = frobot - 1;
                        estacion[frobot][crobot] = robot;
                    }
                }
            }

            if (mover == 'S') {
                if (frobot == 9) {
                    System.out.println("Estas en el limite, no puedes avanzar");
                } else {
                    if (estacion[frobot + 1][crobot] == 'X') {
                        System.out.println("Movimiento bloqueado");
                    } else if (estacion[frobot + 1][crobot] == 'B') {
                        vidas = vidas + 2;
                        estacion[frobot][crobot] = '*';
                        frobot = frobot + 1;
                        estacion[frobot][crobot] = robot;
                        System.out.println("Tienes dos vidas mas");
                    } else if (estacion[frobot + 1][crobot] == meta) {
                        estacion[frobot][crobot] = '*';
                        frobot = frobot + 1;
                        estacion[frobot][crobot] = robot;
                        System.out.println("Rescate completado");
                        break;
                    } else if (estacion[frobot + 1][crobot] == '*') {
                        estacion[frobot][crobot] = '*';
                        frobot = frobot + 1;
                        estacion[frobot][crobot] = robot;
                    }
                }
            }

            if (mover != 'W' && mover != 'A' && mover != 'S' && mover != 'D') {
                System.out.println("Ese no es un caracter valido.");
            }

            for (int f = 0; f < 10; f++) {
                for (int c = 0; c < 10; c++) {
                    System.out.print(estacion[f][c] + " ");
                }
                System.out.println();
            }
            System.out.println("Vidas: " + vidas);
        } while (estacion[frobot][crobot] != meta);
    }
}