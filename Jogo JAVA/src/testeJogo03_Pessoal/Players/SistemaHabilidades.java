package testeJogo03_Pessoal.Players;

import testeJogo03_Pessoal.Players.Classes.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class SistemaHabilidades {

  List<Habilidade> habilidadesDisponiveis = new ArrayList<>();
  public List<Habilidade> habilidadesEscolhidas = new ArrayList<>();

  Scanner sc = new Scanner(System.in);

  public SistemaHabilidades(Personagem personagem, Personagem oponente) {
    this(personagem, oponente, false);
  }

  public SistemaHabilidades(Personagem personagem, Personagem oponente, boolean autoEscolha) {
    inicializarHabilidades(personagem, oponente);

    if (autoEscolha) {
      escolherHabilidadesAleatorias();
    } else {
      escolherHabilidades();
    }
  }

  private void inicializarHabilidades(Personagem personagem, Personagem oponente) {

    ListaHabilidades lista = new ListaHabilidades(personagem, oponente);

    if (personagem instanceof Mago) {

      ListaHabilidades.Mago mago = lista.new Mago();

      if (personagem instanceof Mago.MagoFogo) {

        ListaHabilidades.Mago.Fogo fogo = mago.new Fogo();

        habilidadesDisponiveis.add(new Habilidade("Bola de Fogo",
            "Custo: 4 PE | Dano: 3d6 em um alvo.",
            () -> fogo.bolaDeFogo()));
        habilidadesDisponiveis.add(new Habilidade("Círculo de Incineração",
            "Custo: 8 PE | 1d6 de dano quando o inimigo atacar corpo a corpo por 2 turnos.",
            () -> fogo.circuloDeIncineracao()));
        habilidadesDisponiveis.add(new Habilidade("Fênix",
            "Custo: 10 PE | Dano massivo de 8d6 em um alvo.",
            () -> fogo.fenix()));
        habilidadesDisponiveis.add(new Habilidade("Muralha de Chamas",
            "Custo: 5 PE | Inimigo em Desvantagem ao atacar você por 2 turnos.",
            () -> fogo.muralhaDeChamas()));
        habilidadesDisponiveis.add(new Habilidade("Explosão Flamejante",
            "Custo: 6 PE | 4d6 de dano + queimadura de +1d4 no próximo turno.",
            () -> fogo.explosaoFlamejante()));
        habilidadesDisponiveis.add(new Habilidade("Armadura Ígnea",
            "Custo: 4 PE | Reduz em 2 o dano recebido por golpe durante 2 turnos.",
            () -> fogo.armaduraIgnea()));

      } else if (personagem instanceof Mago.Necromante) {

        ListaHabilidades.Mago.Necromancia necro = mago.new Necromancia();

        habilidadesDisponiveis.add(new Habilidade("Putrefação",
            "Custo: 8 PE | Dano 1d8 e cura 1d8.",
            () -> necro.putrefacao()));
        habilidadesDisponiveis.add(new Habilidade("Erga-se",
            "Custo: 8 PE | Invoca zumbi (até 4) ou ordena ataque em massa dos zumbis.",
            () -> necro.ergaSe()));
        habilidadesDisponiveis.add(new Habilidade("Condenado",
            "Custo: 10 PE | Dano pesado de 3d10 em um alvo.",
            () -> necro.condenado()));
        habilidadesDisponiveis.add(new Habilidade("Sifão de Vida",
            "Custo: 5 PE | 2d6 de dano e cura metade do dano causado.",
            () -> necro.sifaoDeVida()));
        habilidadesDisponiveis.add(new Habilidade("Maldição da Sepultura",
            "Custo: 4 PE | Coloca alvo em Desvantagem e bloqueia cura extra por 2 turnos.",
            () -> necro.maldicaoDaSepultura()));
        habilidadesDisponiveis.add(new Habilidade("Ossos Protetores",
            "Custo: 3 PE | Reduz em 2 o próximo dano recebido.",
            () -> necro.ossosProtetores()));

      } else if (personagem instanceof Mago.MagoGelo) {

        ListaHabilidades.Mago.Gelo gelo = mago.new Gelo();

        habilidadesDisponiveis.add(new Habilidade("Tempestade de Gelo",
            "Custo: 2 PE | Coloca oponente em Desvantagem.",
            () -> gelo.tempestadeDeGelo()));
        habilidadesDisponiveis.add(new Habilidade("Prisão Glacial",
            "Custo: 4 PE | Paralisa oponente (perde próximo turno).",
            () -> gelo.prisaoGlacial()));
        habilidadesDisponiveis.add(new Habilidade("Ice Age",
            "Custo: 10 PE | Dano 4d8 em um alvo.",
            () -> gelo.iceAge()));
        habilidadesDisponiveis.add(new Habilidade("Lâminas de Gelo",
            "Custo: 5 PE | 2d6 de dano (+1d4 se alvo estiver em Desvantagem).",
            () -> gelo.laminasDeGelo()));
        habilidadesDisponiveis.add(new Habilidade("Barreira de Gelo",
            "Custo: 4 PE | Reduz 2 de dano em cada golpe recebido por 2 turnos.",
            () -> gelo.barreiraDeGelo()));
        habilidadesDisponiveis.add(new Habilidade("Congelamento Profundo",
            "Custo: 6 PE | 1d8 de dano e coloca alvo em Desvantagem.",
            () -> gelo.congelamentoProfundo()));

      }

    } else if (personagem instanceof Cacador) {

      ListaHabilidades.SkillsCacador cacador = lista.new SkillsCacador();

      if (personagem instanceof Cacador.Arqueiro) {

        ListaHabilidades.SkillsCacador.SkillsArqueiro arqueiro = cacador.new SkillsArqueiro();

        habilidadesDisponiveis.add(new Habilidade("Tiro de Flecha",
            "Custo: 1 PE & 1 flecha | Dano 1d8.",
            () -> arqueiro.tiroDeFlecha()));
        habilidadesDisponiveis.add(new Habilidade("Marca do Caçador",
            "Custo: 8 PE | Dano do arqueiro contra o alvo é dobrado por 3 turnos.",
            () -> arqueiro.marcaDoCacador()));
        habilidadesDisponiveis.add(new Habilidade("Chuva de Flechas",
            "Custo: 5 PE & 3 flechas | 2d6 de dano (+1d4 se alvo estiver marcado).",
            () -> arqueiro.chuvaDeFlechas()));
        habilidadesDisponiveis.add(new Habilidade("Flecha Perfurante",
            "Custo: 4 PE & 1 flecha | 2d8 de dano ignorando 2 pontos de CA.",
            () -> arqueiro.flechaPerfurante()));
        habilidadesDisponiveis.add(new Habilidade("Armadilha de Caça",
            "Custo: 3 PE | Coloca alvo em Desvantagem na próxima rolagem.",
            () -> arqueiro.armadilhaDeCaca()));
        habilidadesDisponiveis.add(new Habilidade("Recuo Ágil",
            "Custo: 2 PE | +2 de CA até o próximo turno.",
            () -> arqueiro.recuoAgil()));
        habilidadesDisponiveis.add(new Habilidade("Tiro de Precisão",
            "Custo: 6 PE & 1 flecha | 3d6 de dano (+1d6 se alvo estiver marcado).",
            () -> arqueiro.tiroDePrecisao()));

      } else if (personagem instanceof Cacador.Pistoleiro) {

        ListaHabilidades.SkillsCacador.SkillsPistoleiro pistoleiro = cacador.new SkillsPistoleiro();

        habilidadesDisponiveis.add(new Habilidade("Tiro Rápido",
            "Custo: 2 PE & 1 bala | 1d8 de dano e +1 na próxima rolagem de ataque.",
            () -> pistoleiro.tiroRapido()));
        habilidadesDisponiveis.add(new Habilidade("Saque Relâmpago",
            "Custo: 2 PE | Próximo ataque com Vantagem.",
            () -> pistoleiro.saqueRelampago()));
        habilidadesDisponiveis.add(new Habilidade("Bala Ricochete",
            "Custo: 4 PE & 1 bala | 2d6 + 1d4 de dano.",
            () -> pistoleiro.balaRicochete()));
        habilidadesDisponiveis.add(new Habilidade("Tiro de Precisão",
            "Custo: 5 PE & 1 bala | 3d6 de dano e reduz CA do alvo em 1 nesta rolagem.",
            () -> pistoleiro.tiroDePrecisao()));
        habilidadesDisponiveis.add(new Habilidade("Cobertura Tática",
            "Custo: 3 PE | Reduz em 2 o próximo dano recebido.",
            () -> pistoleiro.coberturaTatica()));
        habilidadesDisponiveis.add(new Habilidade("Execução",
            "Custo: 8 PE & 1 bala | 4d6 de dano (+2 se alvo estiver abaixo de 50% de vida).",
            () -> pistoleiro.execucao()));

      }
    } else if (personagem instanceof Barbaro) {

      ListaHabilidades.SkillsBarbaro barbaro = lista.new SkillsBarbaro();

      habilidadesDisponiveis.add(new Habilidade("Fúria",
          "Custo: 4 PE | Dano corpo a corpo +2 e Vantagem em ataques por 2 turnos (até 2 usos).",
          () -> barbaro.furia()));
      habilidadesDisponiveis.add(new Habilidade("Ataque",
          "Sem custo | Ataque simples com dano 1d12.",
          () -> barbaro.ataque()));
      habilidadesDisponiveis.add(new Habilidade("Investida Brutal",
          "Custo: 3 PE | 2d8 de dano (+1d4 se alvo estiver em Desvantagem).",
          () -> barbaro.investidaBrutal()));
      habilidadesDisponiveis.add(new Habilidade("Pele de Ferro",
          "Custo: 4 PE | Reduz pela metade o dano recebido por 2 turnos.",
          () -> barbaro.peleDeFerro()));
      habilidadesDisponiveis.add(new Habilidade("Grito de Guerra",
          "Custo: 2 PE | +2 dano no próximo ataque e inimigo em Desvantagem na próxima rolagem.",
          () -> barbaro.gritoDeGuerra()));
      habilidadesDisponiveis.add(new Habilidade("Retaliação",
          "Custo: 2 PE | 1d8 de dano, só pode ser usado após sofrer dano.",
          () -> barbaro.retaliacao()));

    }
  }

  public void escolherHabilidades() {

    System.out.println("Escolha 3 habilidades (números de 1 a " + habilidadesDisponiveis.size() + "):\n");

    for (int i = 0; i < habilidadesDisponiveis.size(); i++) {
      System.out.println((i + 1) + " — " + habilidadesDisponiveis.get(i).nome);
    }

    for (int i = 0; i < 3; i++) {
      int escolha = sc.nextInt();
      if (escolha < 1 || escolha > habilidadesDisponiveis.size()) {
        System.out.println("Índice inválido. Tente novamente.");
        i--;
        continue;
      }
      habilidadesEscolhidas.add(habilidadesDisponiveis.get(escolha - 1));
    }
  }

  private void escolherHabilidadesAleatorias() {
    List<Habilidade> pool = new ArrayList<>(habilidadesDisponiveis);
    Collections.shuffle(pool, new Random());

    int quantidade = Math.min(3, pool.size());
    for (int i = 0; i < quantidade; i++) {
      habilidadesEscolhidas.add(pool.get(i));
    }
  }

  public void usarHabilidade(int numero) {
    habilidadesEscolhidas.get(numero).acao.run();
  }

  // Usado para oponente escolher aleatoriamente uma habilidade dentre as já selecionadas.
  public void usarHabilidadeAleatoria(Random random) {
    if (habilidadesEscolhidas.isEmpty()) {
      return;
    }
    int indice = random.nextInt(habilidadesEscolhidas.size());
    habilidadesEscolhidas.get(indice).acao.run();
  }

}

/*
 * Lista de Habilidades
 * =========================================================================
 */

class ListaHabilidades {

  Personagem personagem;
  Personagem oponente;

  Dado dadoClass;

  int dano = 0;
  int dado;

  Scanner sc = new Scanner(System.in);

  public ListaHabilidades(Personagem personagem, Personagem oponente) {
    this.personagem = personagem;
    this.oponente = oponente;
    dadoClass = new Dado();
  }

  static int rolarD(int faces, int quantidade) {
    int total = 0;
    for (int i = 0; i < quantidade; i++) {
      total += (int) (Math.random() * faces) + 1;
    }
    return total;
  }

  /** Rolagem de ataque d20 + modificadores de vantagem. Retorna true se acertou. */
  boolean acertou(Personagem atacante, Personagem defensor, int ignorarCa) {
    String cond = atacante.getVantagem();
    if (atacante.proximaRolagemForcadaDesvantagem) {
      cond = "Desvantagem";
      atacante.proximaRolagemForcadaDesvantagem = false;
    }
    if (atacante instanceof testeJogo03_Pessoal.Players.Classes.Barbaro && atacante.furiaTurnosRestantes > 0) {
      if (!"Desvantagem".equals(cond)) {
        cond = "Vantagem";
      }
    }
    if (atacante.proximaRolagemComVantagemExtra) {
      cond = "Vantagem";
      atacante.proximaRolagemComVantagemExtra = false;
    }
    int rolagem = dadoClass.rolarDado(cond);
    if (atacante.proximoAtaqueBonusNoD20 > 0) {
      rolagem += atacante.proximoAtaqueBonusNoD20;
      atacante.proximoAtaqueBonusNoD20 = 0;
    }
    int caAlvo = defensor.getCaEfetivo() - ignorarCa;
    System.out.println("Rolagem de ataque: " + rolagem + " vs CA " + caAlvo);
    return rolagem > caAlvo;
  }

  void tickDuracoes(Personagem p) {
    if (p.turnosMuralhaChamas > 0) {
      p.turnosMuralhaChamas--;
    }
    if (p.turnosCirculoIncineracao > 0) {
      p.turnosCirculoIncineracao--;
    }
    if (p.turnosMaldicaoSepultura > 0) {
      p.turnosMaldicaoSepultura--;
      if (p.turnosMaldicaoSepultura == 0) {
        p.bloqueioCuraExtra = false;
      }
    }
    if (p.turnosMarcaCacador > 0) {
      p.turnosMarcaCacador--;
      if (p.turnosMarcaCacador == 0) {
        p.marcadoPorArqueiro = false;
      }
    }
    if (p.furiaTurnosRestantes > 0) {
      p.furiaTurnosRestantes--;
    }
    if (p.peleDeFerroTurnosRestantes > 0) {
      p.peleDeFerroTurnosRestantes--;
    }
    if (p.turnosReducaoDanoPorGolpe > 0) {
      p.turnosReducaoDanoPorGolpe--;
      if (p.turnosReducaoDanoPorGolpe == 0) {
        p.valorReducaoDanoPorGolpe = 0;
      }
    }
    if (p.bonusCaTemporario > 0) {
      p.bonusCaTemporario = 0;
    }
  }

  void aplicarDanoMagico(Personagem alvo, int danoBruto, Personagem atacanteArqueiro) {
    int d = danoBruto;
    if (alvo.burnExtraProximoTurno) {
      int extra = rolarD(4, 1);
      d += extra;
      System.out.println("Queimadura (Explosão Flamejante): +1d4 = " + extra);
      alvo.burnExtraProximoTurno = false;
    }
    if (atacanteArqueiro instanceof testeJogo03_Pessoal.Players.Classes.Cacador.Arqueiro && alvo.marcadoPorArqueiro && alvo.turnosMarcaCacador > 0) {
      d *= 2;
      System.out.println("Marca do Caçador dobra o dano (total " + d + ").");
    }
    alvo.receberDano(d);
    System.out.println("Dano aplicado: " + d + " | Vida do alvo: " + alvo.vida);
  }

  public class Mago {

    public class Fogo {

      void bolaDeFogo() {
        if (!personagem.tentarGastarPe(4)) {
          return;
        }
        if (!acertou(personagem, oponente, 0)) {
          System.out.println("Bola de Fogo errou.");
          tickDuracoes(personagem);
          return;
        }
        dano = rolarD(6, 3);
        aplicarDanoMagico(oponente, dano, null);
        System.out.println("Bola de Fogo — 3d6 = " + dano);
        tickDuracoes(personagem);
      }

      void circuloDeIncineracao() {
        if (!personagem.tentarGastarPe(8)) {
          return;
        }
        personagem.turnosCirculoIncineracao = 2;
        System.out.println("Círculo de Incineração ativo por 2 turnos (1d6 ao contato corpo a corpo do inimigo).");
        tickDuracoes(personagem);
      }

      void fenix() {
        if (!personagem.tentarGastarPe(10)) {
          return;
        }
        if (!acertou(personagem, oponente, 0)) {
          System.out.println("Fênix não acertou.");
          tickDuracoes(personagem);
          return;
        }
        dano = rolarD(6, 8);
        aplicarDanoMagico(oponente, dano, null);
        System.out.println("Fênix — 8d6 = " + dano);
        tickDuracoes(personagem);
      }

      void muralhaDeChamas() {
        if (!personagem.tentarGastarPe(5)) {
          return;
        }
        personagem.turnosMuralhaChamas = 2;
        oponente.setVantagem("Desvantagem");
        System.out.println("Muralha de Chamas: inimigo em Desvantagem ao atacar o mago por 2 turnos (aproximação).");
        tickDuracoes(personagem);
      }

      void explosaoFlamejante() {
        if (!personagem.tentarGastarPe(6)) {
          return;
        }
        if (!acertou(personagem, oponente, 0)) {
          System.out.println("Explosão Flamejante errou.");
          tickDuracoes(personagem);
          return;
        }
        dano = rolarD(6, 4);
        aplicarDanoMagico(oponente, dano, null);
        oponente.burnExtraProximoTurno = true;
        System.out.println("Explosão Flamejante — 4d6 = " + dano + " | Queimadura: +1d4 no próximo turno.");
        tickDuracoes(personagem);
      }

      void armaduraIgnea() {
        if (!personagem.tentarGastarPe(4)) {
          return;
        }
        personagem.turnosReducaoDanoPorGolpe = 2;
        personagem.valorReducaoDanoPorGolpe = 2;
        System.out.println("Armadura Ígnea: -2 em cada dano recebido por 2 turnos.");
        tickDuracoes(personagem);
      }
    }

    public class Gelo {

      public void tempestadeDeGelo() {
        if (!personagem.tentarGastarPe(2)) {
          return;
        }
        oponente.setVantagem("Desvantagem");
        System.out.println("Tempestade de Gelo: oponente em Desvantagem.");
        tickDuracoes(personagem);
      }

      void prisaoGlacial() {
        if (!personagem.tentarGastarPe(4)) {
          return;
        }
        oponente.paralizado = true;
        System.out.println("Prisão Glacial: oponente Paralizado (perde o próximo turno).");
        tickDuracoes(personagem);
      }

      void iceAge() {
        if (!personagem.tentarGastarPe(10)) {
          return;
        }
        if (!acertou(personagem, oponente, 0)) {
          System.out.println("Ice Age errou.");
          tickDuracoes(personagem);
          return;
        }
        dano = rolarD(8, 4);
        aplicarDanoMagico(oponente, dano, null);
        System.out.println("Ice Age — 4d8 = " + dano);
        tickDuracoes(personagem);
      }

      void laminasDeGelo() {
        if (!personagem.tentarGastarPe(5)) {
          return;
        }
        if (!acertou(personagem, oponente, 0)) {
          System.out.println("Lâminas de Gelo erraram.");
          tickDuracoes(personagem);
          return;
        }
        dano = rolarD(6, 2);
        if ("Desvantagem".equals(oponente.getVantagem())) {
          dano += rolarD(4, 1);
          System.out.println("Bônus +1d4 por alvo em Desvantagem.");
        }
        aplicarDanoMagico(oponente, dano, null);
        System.out.println("Lâminas de Gelo — dano total: " + dano);
        tickDuracoes(personagem);
      }

      void barreiraDeGelo() {
        if (!personagem.tentarGastarPe(4)) {
          return;
        }
        personagem.turnosReducaoDanoPorGolpe = 2;
        personagem.valorReducaoDanoPorGolpe = 2;
        System.out.println("Barreira de Gelo: -2 em cada dano recebido por 2 turnos.");
        tickDuracoes(personagem);
      }

      void congelamentoProfundo() {
        if (!personagem.tentarGastarPe(6)) {
          return;
        }
        if (!acertou(personagem, oponente, 0)) {
          System.out.println("Congelamento Profundo errou.");
          tickDuracoes(personagem);
          return;
        }
        dano = rolarD(8, 1);
        aplicarDanoMagico(oponente, dano, null);
        oponente.setVantagem("Desvantagem");
        System.out.println("Congelamento Profundo — 1d8 + Desvantagem no próximo ataque do alvo.");
        tickDuracoes(personagem);
      }
    }

    public class Necromancia {

      public void putrefacao() {
        if (!personagem.tentarGastarPe(8)) {
          return;
        }
        if (!acertou(personagem, oponente, 0)) {
          System.out.println("Putrefação: toque falhou.");
          tickDuracoes(personagem);
          return;
        }
        int d = rolarD(8, 1);
        int cura = rolarD(8, 1);
        aplicarDanoMagico(oponente, d, null);
        personagem.vida += cura;
        if (personagem.vida > personagem.vidaMaxima) {
          personagem.vida = personagem.vidaMaxima;
        }
        System.out.println("Cura: " + cura + " | Vida: " + personagem.vida);
        System.out.println("Putrefação — dano 1d8 = " + d);
        tickDuracoes(personagem);
      }

      public void ergaSe() {
        if (!personagem.tentarGastarPe(8)) {
          return;
        }

        System.out.println("\nErga-se:");
        System.out.println("1 = Invocar um zumbi (até 4)");
        System.out.println("2 = Ordenar ataque de todos os zumbis");
        System.out.print("Escolha (1-2): ");

        int escolhaModo = sc.nextInt();

        if (escolhaModo == 1) {

          if (personagem.zumbisInvocados >= 4) {
            System.out.println("Você já controla o máximo de 4 zumbis.");
            tickDuracoes(personagem);
            return;
          }

          personagem.zumbisInvocados++;
          personagem.vida += 4;
          if (personagem.vida > personagem.vidaMaxima) {
            personagem.vida = personagem.vidaMaxima;
          }

          System.out.println("Um novo zumbi se ergue das sombras! (" + personagem.zumbisInvocados + "/4)");
          System.out.println("Sua vida aumenta graças ao escudo dos mortos. Vida atual: " + personagem.vida);

        } else if (escolhaModo == 2) {

          if (personagem.zumbisInvocados <= 0) {
            System.out.println("Nenhum zumbi está de pé para atacar. Primeiro invoque com Erga-se.");
            tickDuracoes(personagem);
            return;
          }

          int danoTotal = 0;

          System.out.println("\nOs zumbis avançam contra o inimigo!");

          for (int i = 1; i <= personagem.zumbisInvocados; i++) {
            int rolagem = dadoClass.rolarDado("Neutro");
            if (rolagem > oponente.getCaEfetivo()) {
              int danoZumbi = rolarD(4, 1);
              danoTotal += danoZumbi;
              System.out.println("Zumbi " + i + " acerta! Dado: " + rolagem + " | Dano: " + danoZumbi);
            } else {
              System.out.println("Zumbi " + i + " erra o ataque. Dado: " + rolagem);
            }
          }

          if (danoTotal > 0) {
            aplicarDanoMagico(oponente, danoTotal, null);
            System.out.println("Dano total causado pelos zumbis: " + danoTotal);
          } else {
            System.out.println("Os mortos avançam, mas nenhum golpe encontra o alvo.");
          }

        } else {
          System.out.println("O Necromante hesita e a magia falha.");
        }

        tickDuracoes(personagem);
      }

      void condenado() {
        if (!personagem.tentarGastarPe(10)) {
          return;
        }
        if (!acertou(personagem, oponente, 0)) {
          System.out.println("Condenado errou.");
          tickDuracoes(personagem);
          return;
        }
        dano = rolarD(10, 3);
        aplicarDanoMagico(oponente, dano, null);
        System.out.println("Condenado — 3d10 = " + dano);
        tickDuracoes(personagem);
      }

      void sifaoDeVida() {
        if (!personagem.tentarGastarPe(5)) {
          return;
        }
        if (!acertou(personagem, oponente, 0)) {
          System.out.println("Sifão de Vida errou.");
          tickDuracoes(personagem);
          return;
        }
        dano = rolarD(6, 2);
        aplicarDanoMagico(oponente, dano, null);
        int cura = dano / 2;
        if (cura > 0) {
          personagem.vida += cura;
          if (personagem.vida > personagem.vidaMaxima) {
            personagem.vida = personagem.vidaMaxima;
          }
          System.out.println("Sifão cura metade do dano (" + cura + "). Vida: " + personagem.vida);
        }
        tickDuracoes(personagem);
      }

      void maldicaoDaSepultura() {
        if (!personagem.tentarGastarPe(4)) {
          return;
        }
        oponente.setVantagem("Desvantagem");
        oponente.turnosMaldicaoSepultura = 2;
        oponente.bloqueioCuraExtra = true;
        System.out.println("Maldição da Sepultura: Desvantagem e bloqueio de cura extra por 2 turnos.");
        tickDuracoes(personagem);
      }

      void ossosProtetores() {
        if (!personagem.tentarGastarPe(3)) {
          return;
        }
        personagem.mitigacaoProximoGolpe += 2;
        System.out.println("Ossos Protetores: -2 no próximo dano recebido.");
        tickDuracoes(personagem);
      }
    }

  }

  public class SkillsBarbaro {

    void furia() {
      if (personagem.furiaUsosRestantes <= 0) {
        System.out.println("Fúria sem usos restantes nesta luta.");
        return;
      }
      if (!personagem.tentarGastarPe(4)) {
        return;
      }
      personagem.furiaUsosRestantes--;
      personagem.furiaTurnosRestantes = 2;
      System.out.println("Fúria ativa por 2 turnos (+2 dano corpo a corpo, rolagens com Vantagem). Usos restantes: "
          + personagem.furiaUsosRestantes);
      tickDuracoes(personagem);
    }

    void ataque() {
      if (!acertou(personagem, oponente, 0)) {
        System.out.println("Ataque errou.");
        tickDuracoes(personagem);
        return;
      }
      dano = rolarD(12, 1);
      if (personagem.furiaTurnosRestantes > 0) {
        dano += 2;
      }
      dano += personagem.proximoAtaqueBonusDano;
      personagem.proximoAtaqueBonusDano = 0;
      aplicarDanoMagico(oponente, dano, null);
      System.out.println("Ataque — 1d12" + (personagem.furiaTurnosRestantes > 0 ? " +2 Fúria" : "") + " = " + dano);
      tickDuracoes(personagem);
    }

    void investidaBrutal() {
      if (!personagem.tentarGastarPe(3)) {
        return;
      }
      if (!acertou(personagem, oponente, 0)) {
        System.out.println("Investida Brutal errou.");
        tickDuracoes(personagem);
        return;
      }
      dano = rolarD(8, 2);
      if ("Desvantagem".equals(oponente.getVantagem())) {
        dano += rolarD(4, 1);
        System.out.println("+1d4 por alvo em Desvantagem.");
      }
      if (personagem.furiaTurnosRestantes > 0) {
        dano += 2;
      }
      aplicarDanoMagico(oponente, dano, null);
      System.out.println("Investida Brutal — dano total: " + dano);
      tickDuracoes(personagem);
    }

    void peleDeFerro() {
      if (!personagem.tentarGastarPe(4)) {
        return;
      }
      personagem.peleDeFerroTurnosRestantes = 2;
      System.out.println("Pele de Ferro: reduz pela metade o dano recebido por 2 turnos.");
      tickDuracoes(personagem);
    }

    void gritoDeGuerra() {
      if (!personagem.tentarGastarPe(2)) {
        return;
      }
      personagem.proximoAtaqueBonusDano += 2;
      oponente.proximaRolagemForcadaDesvantagem = true;
      System.out.println("Grito de Guerra: +2 no próximo ataque seu; inimigo com Desvantagem na próxima rolagem.");
      tickDuracoes(personagem);
    }

    void retaliacao() {
      if (!personagem.recebeuDanoNesteCombate) {
        System.out.println("Retaliação só após sofrer dano.");
        return;
      }
      if (!personagem.tentarGastarPe(2)) {
        return;
      }
      if (!acertou(personagem, oponente, 0)) {
        System.out.println("Retaliação errou.");
        tickDuracoes(personagem);
        return;
      }
      dano = rolarD(8, 1);
      if (personagem.furiaTurnosRestantes > 0) {
        dano += 2;
      }
      aplicarDanoMagico(oponente, dano, null);
      System.out.println("Retaliação — 1d8 = " + dano);
      tickDuracoes(personagem);
    }
  }

  public class SkillsCacador {

    public class SkillsArqueiro {

      boolean gastarFlecha(int n) {
        testeJogo03_Pessoal.Players.Classes.Cacador.Arqueiro arq =
            (testeJogo03_Pessoal.Players.Classes.Cacador.Arqueiro) personagem;
        if (arq.flechas < n) {
          System.out.println("Flechas insuficientes (precisa " + n + ", tem " + arq.flechas + ").");
          return false;
        }
        arq.flechas -= n;
        return true;
      }

      void tiroDeFlecha() {
        if (!personagem.tentarGastarPe(1) || !gastarFlecha(1)) {
          return;
        }
        if (!acertou(personagem, oponente, 0)) {
          System.out.println("Tiro de Flecha errou.");
          tickDuracoes(personagem);
          return;
        }
        dano = rolarD(8, 1);
        aplicarDanoMagico(oponente, dano, (testeJogo03_Pessoal.Players.Classes.Cacador.Arqueiro) personagem);
        System.out.println("Tiro de Flecha — 1d8 = " + dano + " | Flechas: "
            + ((testeJogo03_Pessoal.Players.Classes.Cacador.Arqueiro) personagem).flechas);
        tickDuracoes(personagem);
      }

      void marcaDoCacador() {
        if (!personagem.tentarGastarPe(8)) {
          return;
        }
        oponente.marcadoPorArqueiro = true;
        oponente.turnosMarcaCacador = 3;
        System.out.println("Marca do Caçador: dano dobrado do arqueiro por 3 turnos.");
        tickDuracoes(personagem);
      }

      void chuvaDeFlechas() {
        if (!personagem.tentarGastarPe(5) || !gastarFlecha(3)) {
          return;
        }
        if (!acertou(personagem, oponente, 0)) {
          System.out.println("Chuva de Flechas errou.");
          tickDuracoes(personagem);
          return;
        }
        dano = rolarD(6, 2);
        if (oponente.marcadoPorArqueiro && oponente.turnosMarcaCacador > 0) {
          dano += rolarD(4, 1);
          System.out.println("+1d4 por alvo marcado.");
        }
        aplicarDanoMagico(oponente, dano, (testeJogo03_Pessoal.Players.Classes.Cacador.Arqueiro) personagem);
        System.out.println("Chuva de Flechas — dano: " + dano);
        tickDuracoes(personagem);
      }

      void flechaPerfurante() {
        if (!personagem.tentarGastarPe(4) || !gastarFlecha(1)) {
          return;
        }
        if (!acertou(personagem, oponente, 2)) {
          System.out.println("Flecha Perfurante errou.");
          tickDuracoes(personagem);
          return;
        }
        dano = rolarD(8, 2);
        aplicarDanoMagico(oponente, dano, (testeJogo03_Pessoal.Players.Classes.Cacador.Arqueiro) personagem);
        System.out.println("Flecha Perfurante — 2d8 (ignora 2 CA) = " + dano);
        tickDuracoes(personagem);
      }

      void armadilhaDeCaca() {
        if (!personagem.tentarGastarPe(3)) {
          return;
        }
        oponente.proximaRolagemForcadaDesvantagem = true;
        System.out.println("Armadilha de Caça: inimigo com Desvantagem na próxima rolagem.");
        tickDuracoes(personagem);
      }

      void recuoAgil() {
        if (!personagem.tentarGastarPe(2)) {
          return;
        }
        personagem.bonusCaTemporario = 2;
        System.out.println("Recuo Ágil: +2 CA até o próximo turno.");
        tickDuracoes(personagem);
      }

      void tiroDePrecisao() {
        if (!personagem.tentarGastarPe(6) || !gastarFlecha(1)) {
          return;
        }
        if (!acertou(personagem, oponente, 0)) {
          System.out.println("Tiro de Precisão errou.");
          tickDuracoes(personagem);
          return;
        }
        dano = rolarD(6, 3);
        if (oponente.marcadoPorArqueiro && oponente.turnosMarcaCacador > 0) {
          dano += rolarD(6, 1);
          System.out.println("+1d6 por alvo marcado.");
        }
        aplicarDanoMagico(oponente, dano, (testeJogo03_Pessoal.Players.Classes.Cacador.Arqueiro) personagem);
        System.out.println("Tiro de Precisão — dano: " + dano);
        tickDuracoes(personagem);
      }
    }

    public class SkillsPistoleiro {

      boolean gastarBala(int n) {
        testeJogo03_Pessoal.Players.Classes.Cacador.Pistoleiro p =
            (testeJogo03_Pessoal.Players.Classes.Cacador.Pistoleiro) personagem;
        if (p.balas < n) {
          System.out.println("Balas insuficientes (precisa " + n + ", tem " + p.balas + ").");
          return false;
        }
        p.balas -= n;
        return true;
      }

      void tiroRapido() {
        if (!personagem.tentarGastarPe(2) || !gastarBala(1)) {
          return;
        }
        if (!acertou(personagem, oponente, 0)) {
          System.out.println("Tiro Rápido errou.");
          tickDuracoes(personagem);
          return;
        }
        dano = rolarD(8, 1);
        personagem.proximoAtaqueBonusNoD20 += 1;
        aplicarDanoMagico(oponente, dano, null);
        System.out.println("Tiro Rápido — 1d8 = " + dano + " | +1 na próxima rolagem.");
        tickDuracoes(personagem);
      }

      void saqueRelampago() {
        if (!personagem.tentarGastarPe(2)) {
          return;
        }
        personagem.proximaRolagemComVantagemExtra = true;
        System.out.println("Saque Relâmpago: Vantagem na próxima rolagem de ataque.");
        tickDuracoes(personagem);
      }

      void balaRicochete() {
        if (!personagem.tentarGastarPe(4) || !gastarBala(1)) {
          return;
        }
        if (!acertou(personagem, oponente, 0)) {
          System.out.println("Bala Ricochete errou.");
          tickDuracoes(personagem);
          return;
        }
        dano = rolarD(6, 2);
        dano += rolarD(4, 1);
        aplicarDanoMagico(oponente, dano, null);
        System.out.println("Bala Ricochete — 2d6 + 1d4 = " + dano);
        tickDuracoes(personagem);
      }

      void tiroDePrecisao() {
        if (!personagem.tentarGastarPe(5) || !gastarBala(1)) {
          return;
        }
        if (!acertou(personagem, oponente, 1)) {
          System.out.println("Tiro de Precisão errou.");
          tickDuracoes(personagem);
          return;
        }
        dano = rolarD(6, 3);
        aplicarDanoMagico(oponente, dano, null);
        System.out.println("Tiro de Precisão — 3d6 (CA -1 nesta rolagem) = " + dano);
        tickDuracoes(personagem);
      }

      void coberturaTatica() {
        if (!personagem.tentarGastarPe(3)) {
          return;
        }
        personagem.mitigacaoProximoGolpe += 2;
        System.out.println("Cobertura Tática: -2 no próximo dano recebido.");
        tickDuracoes(personagem);
      }

      void execucao() {
        if (!personagem.tentarGastarPe(8) || !gastarBala(1)) {
          return;
        }
        if (!acertou(personagem, oponente, 0)) {
          System.out.println("Execução errou.");
          tickDuracoes(personagem);
          return;
        }
        dano = rolarD(6, 4);
        if (oponente.vida * 2 < oponente.vidaMaxima) {
          dano += 2;
          System.out.println("+2 por alvo com menos da metade da vida.");
        }
        aplicarDanoMagico(oponente, dano, null);
        System.out.println("Execução — dano: " + dano);
        tickDuracoes(personagem);
      }
    }
  }

}

/*
 * Habilidades
 * =============================================================================
 * =====
 */

class Habilidade {

  String nome;
  String descricao;
  Runnable acao;

  public Habilidade(String nome, String descricao, Runnable acao) {
    this.nome = nome;
    this.descricao = descricao;
    this.acao = acao;
  }

  @Override
  public String toString() {
    return this.nome + " (" + this.descricao + ")";
  }

}
