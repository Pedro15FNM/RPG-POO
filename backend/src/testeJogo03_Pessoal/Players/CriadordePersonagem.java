package testeJogo03_Pessoal.Players;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import testeJogo03_Pessoal.Players.Classes.*;

public class CriadordePersonagem {

    Personagem player;
    Personagem oponente;
    Scanner sc = new Scanner(System.in);
    List<String> habilidadesSelecionadas = new ArrayList<>();

    public CriadordePersonagem(Personagem player, Personagem oponente) throws CriadorDePersonagemException {
        this.oponente = oponente;
        this.player = player;

        classeEscolha();
        realizarEscolhas();
        this.player.setHabilidades(new SistemaHabilidades(this.player, oponente, habilidadesSelecionadas));
    }

    void classeEscolha() throws CriadorDePersonagemException {
        System.out.println("Escolha a classe: \n" +
            "1 = Bárbaro \n" +
            "2 = Caçador \n" +
            "3 = Mago "
        );

        int escolhaClasse = lerOpcaoValida(1, 3);

        if (escolhaClasse == 1) {
            this.player = new Barbaro(oponente);

        } else if (escolhaClasse == 2) {
            System.out.println("Escolha o arquétipo do Caçador: \n" +
                "1 = Arqueiro \n" +
                "2 = Pistoleiro "
            );

            int escolhaCacador = lerOpcaoValida(1, 2);

            if (escolhaCacador == 1) {
                this.player = new Cacador.Arqueiro(oponente);
            } else {
                this.player = new Cacador.Pistoleiro(oponente);
            }

        } else if (escolhaClasse == 3) {
            System.out.println("Escolha o Arquetipo: \n" +
                "1 = Mago de Fogo \n" +
                "2 = Necromante \n" +
                "3 = Mago de Gelo"
            );

            int escolhaArquetipo = lerOpcaoValida(1, 3);

            if (escolhaArquetipo == 1) {
                this.player = new Mago.MagoFogo(oponente);
            } else if (escolhaArquetipo == 2) {
                this.player = new Mago.Necromante(oponente);
            } else if (escolhaArquetipo == 3) {
                this.player = new Mago.MagoGelo(oponente);
            }
        }
    }

    void realizarEscolhas() throws CriadorDePersonagemException {
        System.out.println("\n=== Criação de personagem: Fear & Hunger ===\n");

        perguntaAtributos1();
        perguntaAtributos2();
        perguntaHabilidades1();
        perguntaHabilidades2();
        perguntaHabilidades3();

        System.out.println("\nSeu personagem está pronto. A criação agora segue apenas pelas escolhas de atributos e habilidades.");
    }

    private int lerOpcaoValida(int min, int max) throws CriadorDePersonagemException {
        int opcao = 0;
        int tentativas = 0;

        while (opcao < min || opcao > max) {
            if (tentativas >= 5) {
                throw new CriadorDePersonagemException("Muitas tentativas inválidas. Reinicie a criação do personagem.");
            }

            System.out.print("Escolha (" + min + " a " + max + "): ");
            if (!sc.hasNextInt()) {
                sc.next();
                tentativas++;
                System.out.println("Opção inválida. Digite um número entre " + min + " e " + max + ".");
                continue;
            }

            opcao = sc.nextInt();
            if (opcao < min || opcao > max) {
                tentativas++;
                System.out.println("Opção inválida. Digite um número entre " + min + " e " + max + ".");
            }
        }
        return opcao;
    }

    private int lerOpcaoValida() throws CriadorDePersonagemException {
        return lerOpcaoValida(1, 2);
    }

    private void perguntaAtributos1() throws CriadorDePersonagemException {
        System.out.println("Pergunta 1 — Atributos");

        if (player instanceof Barbaro) {
            System.out.println("Você é de um povo tribal, guerreiro e indomável. As civilizações ditas avançadas não poderiam possuir pesadelo pior do que serem saqueadas por vocês. Mas, isso realmente te representa?");
            System.out.println("1 = Sim, minha natureza selvagem anseia por brutalidade e batalhas");
            System.out.println("2 = Não, sou apenas um guerreiro fazendo o meu trabalho");

            if (lerOpcaoValida() == 1) {
                player.alterarVidaMaxima(10);
                player.ca -= 2;
                System.out.println("Resultado: +10 HP, -2 CA.");
            } else {
                System.out.println("Resultado: Nenhuma alteração de status realizada.");
            }

        } else if (player instanceof Cacador.Arqueiro || player instanceof Cacador.Pistoleiro) {
            System.out.println("O ofício da pontaria transpassa sua história desde o princípio. Assim você aprendeu a caçar, escolher seu alvo, estudá-lo e subjulgá-lo. Mas, quem ou o que você caça?");
            System.out.println("1 = Criaturas");
            System.out.println("2 = Humanos");

            if (lerOpcaoValida() == 1) {
                player.alterarVidaMaxima(5);
                System.out.println("Resultado: +5 HP.");
            } else {
                player.alterarPe(2);
                System.out.println("Resultado: +2 PE.");
            }

        } else if (player instanceof Mago.MagoFogo || player instanceof Mago.Necromante || player instanceof Mago.MagoGelo) {
            System.out.println("Ninguém cruza com o caminho da magia sem motivo, todos os magos têm uma boa motivação. Você estuda a magia para obter poder ou pelo prazer de aprender magia?");
            System.out.println("1 = Pelo poder");
            System.out.println("2 = Pelo prazer de aprender magia");

            if (lerOpcaoValida() == 1) {
                System.out.println("Resultado: Nenhuma alteração de status realizada.");
            } else {
                player.alterarPe(5);
                player.alterarVidaMaxima(-10);
                System.out.println("Resultado: +5 PE, -10 HP.");
            }
        }
    }

    private void perguntaAtributos2() throws CriadorDePersonagemException {
        System.out.println("\nPergunta 2 — Atributos");

        if (player instanceof Barbaro) {
            System.out.println("No início de sua carreira como saqueador, durante o saque de uma cidade, você teve que enfrentar um dilema: um de seus oponentes derrotados clamou para que você não saqueasse, ao menos, o santuário da cidade. O que você fez?");
            System.out.println("1 = Respeitou o pedido do oponente e deixou o santuário de lado");
            System.out.println("2 = Ignorou o pedido e saqueou tudo que foi capaz");

            if (lerOpcaoValida() == 1) {
                player.alterarPe(2);
                System.out.println("Resultado: +2 PE.");
            } else {
                player.alterarVidaMaxima(5);
                System.out.println("Resultado: +5 HP.");
            }

        } else if (player instanceof Cacador.Arqueiro || player instanceof Cacador.Pistoleiro) {
            System.out.println("Depois de um longo dia, em uma longa viagem, você se sentiu satisfeito por ter todo seu trabalho completo. Mas, durante toda essa empreitada, havia algo te observando e você apenas percebeu agora. Dessa vez você é a caça. Como você reagiu?");
            System.out.println("1 = Busquei caçá-lo de volta, não aceito ser uma presa");
            System.out.println("2 = Eu fujo do meu caçador, a melhor chance de uma presa é sempre fugir");

            if (lerOpcaoValida() == 1) {
                player.alterarVidaMaxima(-10);
                player.ca += 2;
                System.out.println("Resultado: -10 HP, +2 CA.");
            } else {
                System.out.println("Resultado: Nenhuma alteração de status realizada.");
            }

        } else if (player instanceof Mago.MagoFogo || player instanceof Mago.Necromante || player instanceof Mago.MagoGelo) {
            System.out.println("Ainda jovem, quando se debruçava em livros para criar seu repertório, encontrou um livro proibido em uma velha biblioteca. Você sabia que ele continha magias proibidas, porém únicas. Você deixou o livro de lado ou sua curiosidade foi maior?");
            System.out.println("1 = Li o livro inteiro, não podia deixar essa oportunidade de lado");
            System.out.println("2 = Aquele livro é proibido por algum motivo, não li");

            if (lerOpcaoValida() == 1) {
                player.ca += 2;
                player.alterarPe(-8);
                System.out.println("Resultado: +2 CA, -8 PE.");
            } else {
                System.out.println("Resultado: Nenhuma alteração de status realizada.");
            }
        }
    }

    private void perguntaHabilidades1() throws CriadorDePersonagemException {
        System.out.println("\nPergunta 3 — Habilidades");

        if (player instanceof Barbaro) {
            System.out.println("Durante suas batalhas, de maneira geral, qual seu estilo de luta?");
            System.out.println("1 = Agressivo, busco derrubar qualquer tipo de oponente");
            System.out.println("2 = Defensivo, busco resistir pelo máximo de tempo possível");

            if (lerOpcaoValida() == 1) {
                adicionarHabilidadeSelecionada("Ataque");
                System.out.println("Escolha: Ataque.");
            } else {
                adicionarHabilidadeSelecionada("Pele de Ferro");
                System.out.println("Escolha: Pele de Ferro.");
            }

        } else if (player instanceof Cacador.Arqueiro) {
            System.out.println("Durante sua caça, você prefere disparar muitas flechas fracas ou apenas um poderoso disparo?");
            System.out.println("1 = Muitas flechas");
            System.out.println("2 = Um poderoso disparo");

            if (lerOpcaoValida() == 1) {
                adicionarHabilidadeSelecionada("Chuva de Flechas");
                System.out.println("Escolha: Chuva de Flechas.");
            } else {
                adicionarHabilidadeSelecionada("Tiro de Precisão");
                System.out.println("Escolha: Tiro de Precisão.");
            }

        } else if (player instanceof Cacador.Pistoleiro) {
            System.out.println("Todo caçador possui o empenho entre caçar por esporte ou caçar por dinheiro. Você prefere caçar alvos fracos ou alvos fortes?");
            System.out.println("1 = Fracos, dinheiro é muito bom.");
            System.out.println("2 = Sou");

            if (lerOpcaoValida() == 1) {
                adicionarHabilidadeSelecionada("Execução");
                System.out.println("Escolha: Execução.");
            } else {
                adicionarHabilidadeSelecionada("Tiro de Precisão");
                System.out.println("Escolha: Tiro de Precisão.");
            }

        } else if (player instanceof Mago.MagoFogo) {
            System.out.println("O fogo te fascina. Seu respiro brilhante te fascina, ele é vivo. Esse fogo deve queimar sob sua ordem ou sozinho?");
            System.out.println("1 = Sob minha ordem");
            System.out.println("2 = Sozinho");

            if (lerOpcaoValida() == 1) {
                adicionarHabilidadeSelecionada("Bola de Fogo");
                System.out.println("Escolha: Bola de Fogo.");
            } else {
                adicionarHabilidadeSelecionada("Círculo de Incineração");
                System.out.println("Escolha: Círculo de Incineração.");
            }

        } else if (player instanceof Mago.Necromante) {
            System.out.println("A necromancia te fascina. Sua capacidade de manipular a morte é inigualável entre as magias. Para você, a morte deve ser espalhada ou revertida?");
            System.out.println("1 = Espalhada");
            System.out.println("2 = Revertida");

            if (lerOpcaoValida() == 1) {
                adicionarHabilidadeSelecionada("Putrefação");
                System.out.println("Escolha: Putrefação.");
            } else {
                adicionarHabilidadeSelecionada("Erga-se");
                System.out.println("Escolha: Erga-se.");
            }

        } else if (player instanceof Mago.MagoGelo) {
            System.out.println("O frio é, sem dúvidas, belo, calmo e talvez nefasto. Sólido e organizado ele pode ser belo, mas disperso e caótico pode ser nefasto. Qual é sua preferência?");
            System.out.println("1 = Sólido");
            System.out.println("2 = Caótico");

            if (lerOpcaoValida() == 1) {
                adicionarHabilidadeSelecionada("Prisão Glacial");
                System.out.println("Escolha: Prisão Glacial.");
            } else {
                adicionarHabilidadeSelecionada("Tempestade de Gelo");
                System.out.println("Escolha: Tempestade de Gelo.");
            }
        }
    }

    private void perguntaHabilidades2() throws CriadorDePersonagemException {
        System.out.println("\nPergunta 4 — Habilidades");

        if (player instanceof Barbaro) {
            System.out.println("Sua reação ao ser ferido não é como a de qualquer pessoa, sua razão é deixada de lado e seu instinto de batalha é despertado.");
            System.out.println("1 = Meu corpo se enche de fúria, me torno mais agressivo e forte");
            System.out.println("2 = Sem nem ao menos raciocinar eu contra-ataco, meu instinto age sozinho");

            if (lerOpcaoValida() == 1) {
                adicionarHabilidadeSelecionada("Fúria");
                System.out.println("Escolha: Fúria.");
            } else {
                adicionarHabilidadeSelecionada("Retaliação");
                System.out.println("Escolha: Retaliação.");
            }

        } else if (player instanceof Cacador.Arqueiro) {
            System.out.println("Durante uma difícil caça você teve de enfrentar um inimigo de maneira furtiva, qual foi sua abordagem?");
            System.out.println("1 = Construí armadilhas para que pegassem ele desprevenido");
            System.out.println("2 = Marquei ele em minha mira e esperei o momento certo");

            if (lerOpcaoValida() == 1) {
                adicionarHabilidadeSelecionada("Armadilha de Caça");
                System.out.println("Escolha: Armadilha de Caça.");
            } else {
                adicionarHabilidadeSelecionada("Marca do Caçador");
                System.out.println("Escolha: Marca do Caçador.");
            }

        } else if (player instanceof Cacador.Pistoleiro) {
            System.out.println("Em certos momentos você precisa ser covarde, é normal, faz parte da vida de todo pistoleiro. Como você prefere fazê-lo?");
            System.out.println("1 = Começar o combate com um disparo inesperado, veloz demais para o oponente reagir");
            System.out.println("2 = Enganar meu oponente durante o combate");

            if (lerOpcaoValida() == 1) {
                adicionarHabilidadeSelecionada("Saque Relâmpago");
                System.out.println("Escolha: Saque Relâmpago.");
            } else {
                adicionarHabilidadeSelecionada("Bala Ricochete");
                System.out.println("Escolha: Bala Ricochete.");
            }

        } else if (player instanceof Mago.MagoFogo) {
            System.out.println("O que mais te interessa no seu tipo de magia? sua flexibilidade ou seu poder bruto?");
            System.out.println("1 = Flexibilidade");
            System.out.println("2 = Poder bruto");

            if (lerOpcaoValida() == 1) {
                adicionarHabilidadeSelecionada("Muralha de Chamas");
                System.out.println("Escolha: Muralha de Chamas.");
            } else {
                adicionarHabilidadeSelecionada("Fênix");
                System.out.println("Escolha: Fênix.");
            }

        } else if (player instanceof Mago.Necromante) {
            System.out.println("O que mais te interessa no seu tipo de magia? sua flexibilidade ou seu poder bruto?");
            System.out.println("1 = Flexibilidade");
            System.out.println("2 = Poder bruto");

            if (lerOpcaoValida() == 1) {
                adicionarHabilidadeSelecionada("Sifão de Vida");
                System.out.println("Escolha: Sifão de Vida.");
            } else {
                adicionarHabilidadeSelecionada("Condenado");
                System.out.println("Escolha: Condenado.");
            }

        } else if (player instanceof Mago.MagoGelo) {
            System.out.println("O que mais te interessa no seu tipo de magia? sua flexibilidade ou seu poder bruto?");
            System.out.println("1 = Flexibilidade");
            System.out.println("2 = Poder bruto");

            if (lerOpcaoValida() == 1) {
                adicionarHabilidadeSelecionada("Lâminas de Gelo");
                System.out.println("Escolha: Lâminas de Gelo.");
            } else {
                adicionarHabilidadeSelecionada("Ice Age");
                System.out.println("Escolha: Ice Age.");
            }
        }
    }

    private void perguntaHabilidades3() throws CriadorDePersonagemException {
        System.out.println("\nPergunta 5 — Habilidades");

        if (player instanceof Barbaro) {
            System.out.println("Durante seus primeiros anos de treinamento você enfrentou sua primeira barreira impenetrável, um oponente extremamente resistente e bem equipado. Como você tentou solucionar essa situação?");
            System.out.println("1 = Usei tudo que tinha a minha disposição para tentar penetrar sua armadura com meus ataques");
            System.out.println("2 = Eu intimidei ele, tirei sua concentração");

            if (lerOpcaoValida() == 1) {
                adicionarHabilidadeSelecionada("Investida Brutal");
                System.out.println("Escolha: Investida Brutal.");
            } else {
                adicionarHabilidadeSelecionada("Grito de Guerra");
                System.out.println("Escolha: Grito de Guerra.");
            }

        } else if (player instanceof Cacador.Arqueiro) {
            System.out.println("Você nunca caçou alguém como você, caso isso ocorresse, de que característica sua você teria mais medo?");
            System.out.println("1 = Minhas Flechas");
            System.out.println("2 = Minha Perspicácia");

            if (lerOpcaoValida() == 1) {
                adicionarHabilidadeSelecionada("Tiro de Flecha");
                System.out.println("Escolha: Tiro de Flecha.");
            } else {
                adicionarHabilidadeSelecionada("Recuo Ágil");
                System.out.println("Escolha: Recuo Ágil.");
            }

        } else if (player instanceof Cacador.Pistoleiro) {
            System.out.println("VOCÊ FOI BALEADO!");
            System.out.println("1 = Continuo atirando, minha pistola irá finalizar esse conflito antes que eu seja baleado de novo");
            System.out.println("2 = Recuo pegando cobertura, minha pistola pode esperar");

            if (lerOpcaoValida() == 1) {
                adicionarHabilidadeSelecionada("Tiro Rápido");
                System.out.println("Escolha: Tiro Rápido.");
            } else {
                adicionarHabilidadeSelecionada("Cobertura Tática");
                System.out.println("Escolha: Cobertura Tática.");
            }

        } else if (player instanceof Mago.MagoFogo) {
            System.out.println("A opinião de um mago sobre um bom vinho é sempre algo de qualidade. Qual seu sabor de vinho favorito?");
            System.out.println("1 = Doce com um toque amadeirado");
            System.out.println("2 = Não gosto de vinho!");

            if (lerOpcaoValida() == 1) {
                adicionarHabilidadeSelecionada("Explosão Flamejante");
                System.out.println("Escolha: Explosão Flamejante.");
            } else {
                adicionarHabilidadeSelecionada("Armadura Ígnea");
                System.out.println("Escolha: Armadura Ígnea.");
            }

        } else if (player instanceof Mago.Necromante) {
            System.out.println("A opinião de um mago sobre um bom vinho é sempre algo de qualidade. Qual seu sabor de vinho favorito?");
            System.out.println("1 = Doce com um toque amadeirado");
            System.out.println("2 = Não gosto de vinho!");

            if (lerOpcaoValida() == 1) {
                adicionarHabilidadeSelecionada("Maldição da Sepultura");
                System.out.println("Escolha: Maldição da Sepultura.");
            } else {
                adicionarHabilidadeSelecionada("Ossos Protetores");
                System.out.println("Escolha: Ossos Protetores.");
            }

        } else if (player instanceof Mago.MagoGelo) {
            System.out.println("A opinião de um mago sobre um bom vinho é sempre algo de qualidade. Qual seu sabor de vinho favorito?");
            System.out.println("1 = Doce com um toque amadeirado");
            System.out.println("2 = Não gosto de vinho!");

            if (lerOpcaoValida() == 1) {
                adicionarHabilidadeSelecionada("Barreira de Gelo");
                System.out.println("Escolha: Barreira de Gelo.");
            } else {
                adicionarHabilidadeSelecionada("Congelamento Profundo");
                System.out.println("Escolha: Congelamento Profundo.");
            }
        }
    }

    private void adicionarHabilidadeSelecionada(String nome) {
        if (!habilidadesSelecionadas.contains(nome)) {
            habilidadesSelecionadas.add(nome);
        }
    }
}
