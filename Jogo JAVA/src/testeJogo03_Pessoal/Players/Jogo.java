package testeJogo03_Pessoal.Players;

import java.util.Scanner;

public class Jogo {

    public static void main(String[] args) {

        Personagem oponente = new Personagem(10, 10, 10, "Neutro");
        Personagem player;

        player = new MagoFogo(oponente);

        player.acao();

        System.out.println("\nVida do oponente: " + oponente.vida);

    }

}
