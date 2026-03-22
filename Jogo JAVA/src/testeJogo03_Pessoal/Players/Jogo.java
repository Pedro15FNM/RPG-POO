package testeJogo03_Pessoal.Players;

import java.util.Scanner;
import testeJogo03_Pessoal.Players.Classes.*;

public class Jogo {

  public static void main(String[] args) {

    Personagem oponente = new Personagem(10, 10, 10, "Neutro");
    Personagem player = null;

    CriadordePersonagem criador = new CriadordePersonagem(player, oponente);

    player = criador.player;

    player.acao();

    System.out.println("\n" + oponente.toString());
    System.out.println(player.toString());

  }

}
