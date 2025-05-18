import java.util.Scanner;

public class MapaRobo02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int bateria = 8000;
        int consumo = 1000;
        int etapa = 1;
        int passosNecessarios = 0;
        String direcaoCorreta ="";

        System.out.println("Potência da Bateria: 8000mA");
        System.out.println("Consumo energético por tentativa: 1000mA");
        System.out.println();

        while (bateria >= consumo && etapa <= 5) {

            switch (etapa) {
                case 1:
                    direcaoCorreta = "d";
                    passosNecessarios = 5;
                    break;
                case 2:
                    direcaoCorreta = "t";
                    passosNecessarios = 4;
                    break;
                case 3:
                    direcaoCorreta = "d";
                    passosNecessarios = 5;
                    break;
                case 4:
                    direcaoCorreta = "f";
                    passosNecessarios = 6;
                    break;
                case 5:
                    direcaoCorreta = "e";
                    passosNecessarios = 9;
                    break;
            }

            System.out.println("\n--------------------------");
            System.out.println("Etapa " + etapa + " - Bateria: " + bateria + "mA");
            System.out.println("--------------------------");

            System.out.println("  ");
            System.out.println("(D)ireita");
            System.out.println("(E)squerda");
            System.out.println("(F)rente");
            System.out.println("(T)rás");

            System.out.print("Digite a direção: ");
            String direcao = sc.next().toLowerCase();

            System.out.print("Digite a quantidade de passos: ");
            int passos = sc.nextInt();

            bateria -= consumo;

            System.out.println("\n--------------------------");

            if (direcao.equals(direcaoCorreta) && passos >= passosNecessarios) {
                System.out.println("Movimento correto! Etapa " + etapa + " concluída.");
                etapa++;
            } else {
                System.out.println("Está indo pelo caminho errado! (-1000mAh de bateria)");
            }

            System.out.println("Bateria restante: " + bateria + "mA");
            System.out.println("--------------------------");
        }

        if (etapa > 5) {
            System.out.println("Parabéns! Você chegou ao fim do caminho.");
        } else {
            System.out.println("O robô ficou sem bateria.");
        }
    }
}
