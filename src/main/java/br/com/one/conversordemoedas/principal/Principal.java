package br.com.one.conversordemoedas.principal;

import br.com.one.conversordemoedas.modelos.Menu;

public class Principal {
    public static void main(String[] args) {
        Menu menu = new Menu();

        try {
            menu.iniciar();
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            System.out.println("Finalizando o sistema...");
            System.out.println("Até mais '-'");
        }
    }
}
