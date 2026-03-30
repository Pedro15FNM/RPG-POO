package testeJogo03_Pessoal.Players;

import java.util.Random;

import testeJogo03_Pessoal.Players.Classes.*;

public class Jogo {
  /**
   * Cria um oponente aleatório para o combate.
   * O "oponente" aqui ainda não recebe habilidades até o jogador existir.
   */
  private static Personagem criarOponenteAleatorio(Random random) {
    Personagem dummy = null;

    switch (random.nextInt(6)) {
      case 0:
        return new Barbaro(dummy);
      case 1:
        return new Cacador.Arqueiro(dummy);
      case 2:
        return new Cacador.Pistoleiro(dummy);
      case 3:
        return new Mago.MagoFogo(dummy);
      case 4:
        return new Mago.Necromante(dummy);
      default:
        return new Mago.MagoGelo(dummy);
    }
  }

  private static void imprimirStatus(int turno, Personagem player, Personagem oponente) {
    System.out.println("\n====================");
    System.out.println("Turno " + turno);
    System.out.println("====================");

    System.out.println("Jogador  : HP " + player.vida + "/" + player.vidaMaxima + " | PE " + player.getPe() + "\n"
        + "Oponente  : HP " + oponente.vida + "/" + oponente.vidaMaxima + " | PE " + oponente.getPe());
  }

  public static void main(String[] args) {

    Random random = new Random();

    // O jogador é escolhido pelo usuário; o oponente é gerado aleatoriamente.
    Personagem oponente = criarOponenteAleatorio(random);
    Personagem player = null;

    System.out.println("=== Batalha de RPG (demonstração) ===");
    System.out.println("O inimigo já surgiu. Prepare-se...");

    CriadordePersonagem criador;
    try {
      criador = new CriadordePersonagem(player, oponente);
      player = criador.player;
    } catch (CriadorDePersonagemException e) {
      System.out.println("Erro ao criar personagem: " + e.getMessage());
      System.out.println("A execução do jogo foi interrompida para evitar uma ficha inválida.");
      return;
    }

    // Agora que o jogador existe, conseguimos configurar o "SistemaHabilidades" do oponente
    // com seleção automática pelo próprio sistema.
    oponente.setHabilidades(new SistemaHabilidades(oponente, player, true));

    System.out.println("\nSua ficha foi criada. Começa agora!\n");

    int turno = 1;
    while (player.vida > 0 && oponente.vida > 0) {
      imprimirStatus(turno, player, oponente);

      System.out.println("\nSua vez.");
      // Jogador escolhe uma das 3 habilidades configuradas pela ficha.
      player.acao();

      // Depois da sua ação, o flag de Retaliação "já foi consumido".
      player.recebeuDanoNesteCombate = false;

      if (oponente.vida > 0) {
        System.out.println("\nA vez do oponente...");

        if (oponente.paralizado) {
          System.out.println("Oponente está PARALIZADO e perde o turno!");
          oponente.paralizado = false;
        } else {
          // O oponente escolhe automaticamente uma das 3 habilidades selecionadas no "SistemaHabilidades".
          oponente.getHabilidades().usarHabilidadeAleatoria(random);
        }

        // Depois da ação do oponente, Retaliação do oponente fica "limpa" para a rodada seguinte.
        oponente.recebeuDanoNesteCombate = false;
      }

      System.out.println("\nResumo do turno:");
      System.out.println("Jogador : " + player.toString());
      System.out.println("Oponente: " + oponente.toString());

      turno++;
    }

    System.out.println("\n=== Fim do combate ===");
    if (player.vida > 0) {
      System.out.println("Você venceu o combate. O inimigo caiu!");
    } else {
      System.out.println("Você foi derrotado. A batalha termina aqui...");
    }

    System.out.println("\n" + oponente.toString());
    System.out.println(player.toString());

  }

}
