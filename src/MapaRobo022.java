import java.util.Scanner;

public class MapaRobo022 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // São 29 passos corretos, e ele pode errar até 11 passos, então: 29 + 11 = 40
        int bateria = 40000;
        int consumo = 1000;
        int etapa = 1;
        int passosNecessarios = 0;
        String direcaoCorreta = "";
        int passosAcumulados = 0;
        System.out.println("--------------------------");
        System.out.println("Potência da Bateria: " + bateria + "mA");
        System.out.println("Consumo energético por PASSO: 1000mA");
        System.out.println("[AVISO] Os passos são acumulativos por etapa.");
        System.out.println("--------------------------");

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
            System.out.println("[AVISO] Todos os passos digitados gastarão bateria (mesmo que a etapa precise de menos)");
            System.out.println("Etapa " + etapa + " - Bateria: " + bateria + "mA");
            System.out.println("--------------------------");
            System.out.println("(D)ireita | (E)squerda | (F)rente | (T)rás");


            String direcao;
            do {
                System.out.print("Digite a direção: ");
                direcao = sc.next().toLowerCase();
                if (!direcao.equals("d") && !direcao.equals("e") && !direcao.equals("f") && !direcao.equals("t")) {
                    System.out.println("Direção inválida! Tente novamente.\n");
                }
            } while (!direcao.equals("d") && !direcao.equals("e") && !direcao.equals("f") && !direcao.equals("t"));


            int passos;
            do {
                System.out.print("Digite a quantidade de passos: ");
                passos = sc.nextInt();
                if (passos <= 0) {
                    System.out.println("\nO NÚMERO DE PASSOS DEVE SER MAIOR QUE 1\n");
                }
            } while (passos <= 0);

            int passosRealizados = Math.abs(passos);


            if (bateria >= passosRealizados * consumo) {
                bateria -= passosRealizados * consumo;
                System.out.println("--------------------------");
                System.out.println(passosRealizados + " passos dados. Bateria restante: " + bateria + "mA");
                System.out.println("--------------------------");
            } else {
                passosRealizados = bateria / consumo;
                bateria -= passosRealizados * consumo;
                System.out.println("--------------------------");
                System.out.println("Bateria insuficiente! Serão dados apenas " + passosRealizados + " passos.");
                System.out.println(passosRealizados + " passos dados. Bateria restante: " + bateria + "mA");
                System.out.println("--------------------------");
            }


            if (direcao.equals(direcaoCorreta)) {
                passosAcumulados += passosRealizados;
                if (passosAcumulados >= passosNecessarios) {
                    System.out.println("Movimento correto! Etapa " + etapa + " concluída.");
                    System.out.println("--------------------------");
                    etapa++;
                    passosAcumulados = 0;
                } else {
                    System.out.println("--------------------------");
                    System.out.println("Faltam passos para concluir a etapa.");
                    System.out.println("Passos acumulados na etapa atual: " + passosAcumulados);
                    System.out.println("--------------------------");
                }
            } else {

                System.out.println("CAMINHO ERRADO!");
            }
        }

        if (etapa > 5) {
            System.out.println("Parabéns! Você chegou ao fim do caminho.");
        } else {
            System.out.println("O robô ficou sem bateria.");
        }
    }
}