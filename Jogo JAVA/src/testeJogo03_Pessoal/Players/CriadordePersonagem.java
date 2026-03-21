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

            this.player = new Cacador(oponente);

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
    
        // Escolha (1) =========================================================================================

        System.out.println("Insira Texto");

        escolha = sc.nextInt();

        if (escolha == 1 ) {

            // Consequência (1)
            System.out.println("Consequência (1)");

        } else if ( escolha == 2 ) {

            // Consequência (2)
            System.out.println("Consequência (2)");
            
        }
        System.out.println();
        // Escolha (2) =========================================================================================

        System.out.println("Insira Texto");

        escolha = sc.nextInt();

        if (escolha == 1 ) {

            // Consequência (1)
            System.out.println("Consequência");

        } else if ( escolha == 2 ) {

            // Consequência (2)
            System.out.println("Consequência");

        }
        System.out.println();
        // Escolha (3) =========================================================================================

        System.out.println("Insira Texto");

        escolha = sc.nextInt();

        if (escolha == 1 ) {

            // Consequência (1)
            System.out.println("Consequência");

        } else if ( escolha == 2 ) {

            // Consequência (2)
            System.out.println("Consequência");

        }
        System.out.println();
        // Escolha (4) =========================================================================================

        System.out.println("Insira Texto");

        escolha = sc.nextInt();

        if (escolha == 1 ) {

            // Consequência (1)
            System.out.println("Consequência");

        } else if ( escolha == 2 ) {

            // Consequência (2)
            System.out.println("Consequência");

        }
        System.out.println();
        // Escolha (5) =========================================================================================

        System.out.println("Insira Texto");

        escolha = sc.nextInt();

        if (escolha == 1 ) {

            // Consequência (1)
            System.out.println("Consequência");

        } else if ( escolha == 2 ) {

            // Consequência (2)
            System.out.println("Consequência");

        }
        System.out.println();
    }
}


