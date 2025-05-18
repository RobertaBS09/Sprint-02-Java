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
        int passosAcumulados = 0; // soma dos passos certos
        System.out.println("Potência da Bateria: " + bateria + "mA");
        System.out.println("Consumo energético por PASSO: 1000mA\n");
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
            System.out.println("Etapa " + etapa + " - Bateria: " + bateria + "mA");
            System.out.println("  ");
            System.out.println("(D)ireita");
            System.out.println("(E)squerda");
            System.out.println("(F)rente");
            System.out.println("(T)rás");
            System.out.print("Digite a direção: ");
            String direcao = sc.next().toLowerCase();
            System.out.print("Digite a quantidade de passos: ");
            int passos = sc.nextInt();
            // transforma passo negativo em positivo
            int passosRealizados = Math.abs(passos);
            // verifica se tem energia suficiente para os passos
            if (bateria >= passosRealizados * consumo) {
                bateria -= passosRealizados * consumo;
                System.out.println("\n--------------------------");
                System.out.println(passosRealizados + " passos dados. Bateria restante: " + bateria + "mA");
                System.out.println("--------------------------\n");
            } else {
                System.out.println("Bateria insuficiente para realizar " + passosRealizados + " passos.");
                bateria = 0;
                break;
            }
            //se a direção estiver correta, acumula os passos
            if (direcao.equals(direcaoCorreta)) {
                passosAcumulados += passos;
                if (passosAcumulados >= passosNecessarios) {
                    System.out.println("Movimento correto! Etapa " + etapa + " concluída.\n");
                    etapa++;
                    passosAcumulados = 0; // zera para próxima etapa
                } else {

                    System.out.println("Faltam passos para concluir a etapa.\n");
                }
            } else {
                // direção errada gasta bateria, mas não acumula passos
                System.out.println("Está indo pelo caminho errado!\n");
            }
        }
        if (etapa > 5) {
            System.out.println("Parabéns! Você chegou ao fim do caminho.");
        } else {
            System.out.println("O robô ficou sem bateria.");
        }
    }
}
