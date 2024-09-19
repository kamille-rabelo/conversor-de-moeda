package br.com.one.conversordemoedas.modelos;

import java.util.Scanner;

public class Menu {
    private final Scanner leitura;

    public Menu() {
        this.leitura = new Scanner(System.in);
    }

    public void iniciar() {
        System.out.println("\nBEM VINDO AO CONVERSOR DE MOEDAS :)");

        while(true) {
            printaComandos();
            var comando = getComando();

            if (comando == 11) break;

        }
    }

    private int getComando() {
        int comando;

        while (true) {
            var entrada = leitura.nextLine().trim();

            if (validaInt(entrada)) {
                comando = Integer.parseInt(entrada);
                if ((comando > 0) && (comando < 12)) {
                    break;
                }
            }
            System.out.println("Comando invalido! Tente novamente:");
        }
        return comando;
    }

    private boolean validaInt(String entrada) {
        return entrada.matches("\\d+");
    }



    private static void printaComandos() {
        System.out.println("""
                **************************************************
                
                1) Dólar => Real Brasileiro
                2) Iene => Dólar
                3) Yuan Chinês => Dólar
                4) Real Brasileiro => Iene
                5) Euro => Dólar
                6) Real Brasileiro => Dólar
                7) Libra Esterlina => Dólar
                8) Real Brasileiro => Peso Argentino
                9) Peso Uruguaio => Dólar
                10) Real Brasileiro => Euro
                11) Sair
                
                Escolha uma opção válida:
                
                **************************************************
                """);
    }
}
