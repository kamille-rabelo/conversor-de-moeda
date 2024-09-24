package br.com.one.conversordemoedas.modelos;

import java.util.Scanner;

import static br.com.one.conversordemoedas.modelos.ConsultaConversao.buscaConversao;

public class Menu {
    private final Scanner leitura;
    private final GerenciaComandos gerenciaComandos;

    public Menu() {
        this.leitura = new Scanner(System.in);
        this.gerenciaComandos = new GerenciaComandos();
    }

    public void iniciar() throws InterruptedException {
        System.out.println("\nBEM VINDO AO CONVERSOR DE MOEDAS :)");

        while(true) {
            Thread.sleep(1100);
            gerenciaComandos.printaComandos();
            var comando = getComando();

            if (comando == 11) {
                Thread.sleep(1300);
                System.out.println("Finalizando o sistema...");
                Thread.sleep(1300);
                System.out.println("Até mais '-'");
                break;
            }

            double valor = getValor();
            this.executaConversao(comando, valor);
        }
    }

    private double getValor() {
        double valor;
        System.out.println("Digite o valor que deseja converter:");

        while (true) {
            var entrada = leitura.nextLine().trim();

            if (validaDigito(entrada)) {
                valor = Double.parseDouble(entrada);
                break;
            }
            System.out.println("Valor invalido! Tente novamente:");
        }
        return valor;
    }

    private void executaConversao(int comando, double valor) {
        var moedas = gerenciaComandos.getMoedas(comando);
        buscaConversao(moedas[0], moedas[1], valor);
    }

    private int getComando() {
        int comando;

        while (true) {
            var entrada = leitura.nextLine().trim();

            if (validaDigito(entrada)) {
                comando = Integer.parseInt(entrada);
                if ((comando > 0) && (comando < 12)) {
                    break;
                }
            }
            System.out.println("Comando invalido! Tente novamente:");
        }
        return comando;
    }

    private boolean validaDigito(String entrada) {return entrada.matches("\\d+");}
}
