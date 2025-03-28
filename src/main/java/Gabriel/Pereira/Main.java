package Gabriel.Pereira;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;
        boolean arquivoBaixado = false;

        while (continuar) {
            System.out.println("=== Menu de Opções ===");
            System.out.println("1. Fazer Download");
            System.out.println("2. Compactar Arquivos");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    try {

                        Download.main();
                        arquivoBaixado = true;

                    } catch (Exception e) {
                        System.err.println("Ocorreu um erro ao realizar o download: " + e.getMessage());
                    }
                    break;

                case 2:
                    try {
                        if (arquivoBaixado) {CriaZipPdf.main(new String[0]);}
                    } catch (Exception e) {
                        System.err.println("Ocorreu um erro ao compactar os arquivos: " + e.getMessage());
                    }
                    break;

                case 3:
                    System.out.println("Saindo do programa...");
                    continuar = false;
                    break;

                default:
                    System.out.println("Opção invalida! Tente novamente.");
            }
            System.out.println();
        }

        scanner.close();


    }









}

