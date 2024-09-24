package br.com.one.conversordemoedas.modelos;

import java.util.HashMap;

public class GerenciaComandos {
    private final HashMap<Integer, String> comandos;

    public GerenciaComandos() {
        this.comandos = new HashMap<>();
        this.adicionarComandos();
    }

    private void adicionarComandos() {
        comandos.put(1, "USD,BRL");
        comandos.put(2, "JPY,USD");
        comandos.put(3, "CNY,BRL");
        comandos.put(4, "BRL,JPY");
        comandos.put(5, "EUR,USD");
        comandos.put(6, "BRL,USD");
        comandos.put(7, "GBP,USD");
        comandos.put(8, "BRL,ARS");
        comandos.put(9, "UYU,USD");
        comandos.put(10, "BRL,EUR");
    }

    public String[] getMoedas(int comando) {
        return this.comandos.get(comando).split(",");
    }

    public void printaComandos() {
        System.out.print("""
                ******************************************************************
                
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
                
                ******************************************************************
                """);
    }
}
