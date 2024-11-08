import java.util.Scanner;

public class Ac2 {
    
    public static void main(String[] args) {
        
        Scanner scn = new Scanner(System.in);

        double[] pesos = new double[4];

        double pesoTotal = 100.0;

        double pesoRestante = 100.0;

        double somaPesos = 0.0;

        double[] notas = new double[4];

        double notaMinima = 0.0;

        double notaFinal = 0.0;

        char opcao = ' ';

        String menu1 = """
            
            ╔══════════════════════════════╗
            ║                              ║
            ║     Calculadora de Notas     ║
            ║    ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯    ║
            ║  Esta é uma ferramenta para  ║
            ║  auxiliar no cálculo da      ║
            ║  média ponderada das notas   ║
            ║  de avaliação acadêmica.     ║
            ║                              ║
            ║  · Selecione uma opção:      ║
            ║                              ║
            ║  [1] Iniciar Cálculo         ║
            ║  [0] Sair                    ║
            ║                              ║
            ╚══════════════════════════════╝

            =>""" + " ";

        String menu2 = """

            ╔══════════════════════════════╗
            ║                              ║
            ║     Calculadora de Notas     ║
            ║    ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯    ║
            ║  · Selecione uma opção:      ║
            ║                              ║
            ║  [1] Reiniciar Calculadora   ║
            ║  [2] Informar Outras Notas   ║
            ║  [0] Sair                    ║
            ║                              ║
            ╚══════════════════════════════╝

            =>""" + " ";

        while (true) {
            
            System.out.print(menu1);
            opcao = scn.next().charAt(0);

            switch (opcao) {
                case '1':
                    do{
                        System.out.println("\n");
                        System.out.println("╔═════════════════╦════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗");
                        System.out.println("║ Pesos das Notas ║ A seguir informe os pesos das 4 notas com número de '0' a '100', sendo que a soma dos 4 pesos devem resultar em '100'. ║");
                        System.out.println("╚═════════════════╩════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝");
                        System.out.println("\n\n------------------------------------------");

                        pesoRestante = pesoTotal;
                        somaPesos = 0.0;

                        for(int i = 0; i < pesos.length; i++){
                            do {
                                System.out.println("· Peso restante a distribuir: [ " + pesoRestante + " % ]");

                                System.out.println("\nDigite o peso da nota " + (i + 1) +":");
                                System.out.print("=> ");
                                pesos[i] = scn.nextDouble();

                                System.out.println("------------------------------------------");

                                if (pesos[i] < 0.0 || pesos[i] > 100.0) {
                                    System.out.println("\n<{!}>   Entrada inválida! O valor do peso precisa ser um número de '0' a '100'.   <{!}>\n");
                                    System.out.println("------------------------------------------");
                                }             

                            } while (pesos[i] < 0.0 || pesos[i] > 100.0);
                            
                            pesoRestante -= pesos[i];
                            somaPesos += pesos[i];
                        }

                        if (somaPesos != 100.0) {
                            System.out.print("\n\n<{!}>   Entrada inválida! A soma dos pesos precisa ser igual a '100'.   <{!}>");
                        }

                    } while (somaPesos != 100.0);

                    do{
                        System.out.println("\n");
                        System.out.println("╔═════════════╦═══════════════════════════════════════════════════════════════════════════════╗");
                        System.out.println("║ Nota Mínima ║ A seguir informe a nota mínima para aprovação com valor entre '0,0' e '10,0'. ║");
                        System.out.println("╚═════════════╩═══════════════════════════════════════════════════════════════════════════════╝");
                        System.out.println("\n\n------------------------------------------");

                        System.out.println("Digite a nota mínima:");
                        System.out.print("=> ");
                        notaMinima = scn.nextDouble();

                        System.out.println("------------------------------------------");
                        
                        if (notaMinima < 0.0 || notaMinima > 10.0) {
                            System.out.print("\n\n<{!}>   Entrada inválida! O valor da nota mínima precisa ser um número de '0,0' a '10,0'.   <{!}>");
                        }

                    } while (notaMinima < 0.0 || notaMinima > 10.0);

                    do {
                        System.out.println("\n");
                        System.out.println("╔═══════╦══════════════════════════════════════════════════════════╗");
                        System.out.println("║ Notas ║ A seguir informe as 4 notas com valor de '0,0' a '10,0'. ║");
                        System.out.println("╚═══════╩══════════════════════════════════════════════════════════╝");
                        System.out.println("\n\n------------------------------------------");
                        
                        notaFinal = 0.0;

                        for(int i = 0; i < notas.length; i++){
                            do {
                                System.out.println("Digite a nota " + (i + 1) +":");
                                System.out.print("=> ");
                                notas[i] = scn.nextDouble();
                                System.out.println("------------------------------------------");

                                if (notas[i] < 0.0 || notas[i] > 10.0) {
                                    System.out.println("\n<{!}>   Entrada inválida! A nota precisa ser um valor de '0,0' a '10,0'.   <{!}>\n");
                                    System.out.println("------------------------------------------");
                                }

                            } while(notas[i] < 0.0 || notas[i] > 10.0);

                            notaFinal += (notas[i] * (pesos[i] / 100.0));
                        }

                        if(notaFinal >= notaMinima){
                            System.out.println("\n\n");
                            System.out.println("╔════════════════════════════════════╗");
                            System.out.println("║    Parabéns, você foi aprovado!    ║");
                            System.out.println("║   ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯   ║");
                            System.out.println("║  Sua nota final é: " + String.format("%05.2f", notaFinal) + "           ║");
                            System.out.println("╚════════════════════════════════════╝");
                        }
                        else{
                            System.out.println("\n\n");
                            System.out.println("╔════════════════════════════════════╗");
                            System.out.println("║  Sinto muito, você foi reprovado!  ║");
                            System.out.println("║ ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯ ║");
                            System.out.println("║  Sua nota final é: " + String.format("%05.2f", notaFinal) + "           ║");
                            System.out.println("╚════════════════════════════════════╝");
                        }

                        do {
                            System.out.print(menu2);
                            opcao = scn.next().charAt(0);
                    
                            switch (opcao) {
                                case '1':
                                    System.out.println("\nReiniciando...");
                                    break;

                                case '2':
                                    break;

                                case '0':
                                    System.out.println("\nSaindo...");
                                    scn.close();
                                    System.exit(0);
                                    break;

                                default:
                                    System.out.println("\n<{!}>   Opção Inválida.   <{!}>");
                                    break;
                            }
                        } while (opcao != '1' && opcao != '2');

                    } while (opcao == '2');

                    break;

                case '0':
                    System.out.println("\nSaindo...\n");
                    scn.close();
                    System.exit(0);
                    break;
                    
                default:
                    System.out.println("\n<{!}>   Opção Inválida.   <{!}>");
                    break;
            }
        }    
    }
}