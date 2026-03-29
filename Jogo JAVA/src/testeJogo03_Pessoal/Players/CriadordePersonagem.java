package testeJogo03_Pessoal.Players;

import java.util.Scanner;
import testeJogo03_Pessoal.Players.Classes.*;

public class CriadordePersonagem {

    Personagem player;
    Personagem oponente;
    SistemaHabilidades habilidades;

    Scanner sc = new Scanner(System.in);


    public CriadordePersonagem (Personagem player, Personagem oponente) {

        this.oponente = oponente;
        this.player = player;

        classeEscolha();

        this.player.setHabilidades( new SistemaHabilidades(this.player, oponente) );

        Escolhas(this.player);

    }

    int escolha;

    void classeEscolha () {

        System.out.println("Escolha a classe: \n" +
            "1 = Barbaro \n" +
            "2 = Caçador \n" +
            "3 = Mago "
        );

        int escolhaClasse = sc.nextInt();

        if (escolhaClasse == 1 ) {

            this.player = new Barbaro(oponente);

        } else if ( escolhaClasse == 2 ) {

            System.out.println("Escolha o arquétipo do Caçador: \n" +
                "1 = Arqueiro \n" +
                "2 = Pistoleiro "
            );

            int escolhaCacador = sc.nextInt();

            if (escolhaCacador == 1) {
                this.player = new Cacador.Arqueiro(oponente);
            } else {
                this.player = new Cacador.Pistoleiro(oponente);
            }

        } else if ( escolhaClasse == 3 ) {

            System.out.println("Escolha o Arquetipo: \n" +
                "1 = Mago de Fogo \n" +
                "2 = Necromante \n" +
                "3 = Mago de Gelo"
            );

            int escolhaArquetipo = sc.nextInt();

            if (escolhaArquetipo == 1) {

                this.player = new Mago.MagoFogo(oponente);

            } else if (escolhaArquetipo == 2) {

                this.player = new Mago.Necromante(oponente);

            } else if (escolhaArquetipo == 3) {

                this.player = new Mago.MagoGelo(oponente);

            }

        }

    }
    void Escolhas ( Personagem player ) {

        // Mantido simples de propósito: você pode substituir estes textos
        // pela narrativa de Fear & Hunger quando definir as consequências.

        for (int pergunta = 1; pergunta <= 5; pergunta++) {
            System.out.println();
            System.out.println("Escolha " + pergunta + " (placeholder).");
            System.out.println("1 = Opção 1");
            System.out.println("2 = Opção 2");
            System.out.print("Escolha (1 ou 2): ");

            escolha = sc.nextInt();

            if (escolha == 1) {
                System.out.println("Consequência (1) ainda não implementada.");
            } else if (escolha == 2) {
                System.out.println("Consequência (2) ainda não implementada.");
            } else {
                System.out.println("Escolha inválida. Nenhuma consequência aplicada.");
            }
        }
    }
}
