package testeJogo03_Pessoal.Players.Classes;

import testeJogo03_Pessoal.Players.SistemaHabilidades;

import javax.swing.*;
import java.util.Scanner;

public class Personagem {

  Scanner sc = new Scanner(System.in);

  public int vida;
  public int vidaMaxima;
  public int ca;
  protected int pe;
  public int peMaxima;

  SistemaHabilidades habilidades;

  public String vantagem;

  /** Bônus temporário de CA (ex.: Recuo Ágil). */
  public int bonusCaTemporario;

  /** Reduz o próximo dano recebido (Ossos Protetores, Cobertura Tática). */
  public int mitigacaoProximoGolpe;

  /** Turnos restantes de redução fixa por golpe (Armadura Ígnea, Barreira de Gelo: -2 por turno). */
  public int turnosReducaoDanoPorGolpe;
  public int valorReducaoDanoPorGolpe;

  public int turnosMuralhaChamas;
  public int turnosCirculoIncineracao;
  public int turnosMaldicaoSepultura;
  public int turnosMarcaCacador;
  public boolean marcadoPorArqueiro;

  /** Próximo dano extra por queimadura (Explosão Flamejante): rolar 1d4. */
  public boolean burnExtraProximoTurno;

  public int furiaTurnosRestantes;
  public int furiaUsosRestantes;

  public int peleDeFerroTurnosRestantes;

  /** Quantidade de PE recuperada ao usar a habilidade "Descanso". */
  public int peRecuperadoPorDescanso;

  public int proximoAtaqueBonusDano;
  public int proximoAtaqueBonusNoD20;
  public boolean proximaRolagemComBonusAtaque;

  public boolean paralizado;

  public boolean bloqueioCuraExtra;

  public int zumbisInvocados;

  public boolean recebeuDanoNesteCombate;

  /** Próxima rolagem deste personagem força Desvantagem (efeitos do oponente). */
  public boolean proximaRolagemForcadaDesvantagem;

  /** Próxima rolagem de ataque com Vantagem extra (Saque Relâmpago). */
  public boolean proximaRolagemComVantagemExtra;

  public Personagem(int vida, int ca, int pe, String vantagem) {
    this.vida = vida;
    this.vidaMaxima = vida;
    this.ca = ca;
    this.pe = pe;
    this.peMaxima = pe;
    this.vantagem = vantagem;
    this.furiaUsosRestantes = 2;

    // Descanso simples por "perfil" (inferido pelo PE base do arquétipo).
    if (this.peMaxima <= 10) {
      this.peRecuperadoPorDescanso = 4;
    } else if (this.peMaxima <= 20) {
      this.peRecuperadoPorDescanso = 6;
    } else {
      this.peRecuperadoPorDescanso = 10;
    }
  }

  protected int Escolha() {
    return Integer.parseInt(JOptionPane.showInputDialog("Realize a sua escolha: "));
  }

  protected void Recuperacao() {
    pe += 4;
    System.out.println("Recuperação: +4 PE (PE atual: " + pe + ")");
  }

  /**
   * Habilidade herdada da superclasse.
   * Recupera PE sem custo e até o limite de {@link #peMaxima}.
   */
  public void descansar() {
    if (peRecuperadoPorDescanso <= 0) {
      System.out.println("Você tenta descansar, mas nada parece mudar.");
      return;
    }
    int antes = pe;
    pe = Math.min(peMaxima, pe + peRecuperadoPorDescanso);
    int recuperado = pe - antes;
    if (recuperado <= 0) {
      System.out.println("Você descansa... mas seus recursos já estão no limite.");
    } else {
      System.out.println("Você descansa com firmeza: +" + recuperado + " PE (PE atual: " + pe + ").");
    }
  }

  public void acao() {
  }

  public String getVantagem() {
    return vantagem;
  }

  public void setVantagem(String vantagem) {
    this.vantagem = vantagem;
  }

  public int getPe() {
    return pe;
  }

  public int getCaEfetivo() {
    return ca + bonusCaTemporario;
  }

  /** Tenta gastar PE; retorna false se não houver PE suficiente. */
  public boolean tentarGastarPe(int custo) {
    if (custo <= 0) {
      return true;
    }
    if (pe < custo) {
      System.out.println("PE insuficiente (necessário " + custo + ", atual " + pe + ").");
      return false;
    }
    pe -= custo;
    return true;
  }

  public void setHabilidades(SistemaHabilidades habilidades) {
    this.habilidades = habilidades;
  }

  public SistemaHabilidades getHabilidades() {
    return habilidades;
  }

  /** Aplica dano bruto considerando mitigações comuns. */
  public void receberDano(int danoBruto) {
    int d = danoBruto;

    if (peleDeFerroTurnosRestantes > 0) {
      d = d / 2;
      System.out.println("Pele de Ferro reduz o dano pela metade (restante: " + d + ").");
    }

    if (mitigacaoProximoGolpe > 0) {
      int usar = Math.min(d, mitigacaoProximoGolpe);
      d -= usar;
      mitigacaoProximoGolpe -= usar;
      System.out.println("Mitigação absorve " + usar + " (dano restante: " + d + ").");
    }

    if (turnosReducaoDanoPorGolpe > 0 && valorReducaoDanoPorGolpe > 0) {
      int usar = Math.min(d, valorReducaoDanoPorGolpe);
      d -= usar;
      System.out.println("Armadura/Barreira reduz " + usar + " (dano restante: " + d + ").");
    }

    // Escudo de zumbis para o Necromante: cada zumbi possui 4 HP.
    if (this instanceof testeJogo03_Pessoal.Players.Classes.Mago.Necromante && zumbisInvocados > 0 && d > 0) {
      int vidaTotalZumbis = zumbisInvocados * 4;
      int usadoNosZumbis = Math.min(vidaTotalZumbis, d);
      int mortos = usadoNosZumbis / 4;

      if (mortos > 0) {
        zumbisInvocados -= mortos;
        System.out.println("Os zumbis absorvem " + usadoNosZumbis + " de dano e " + mortos + " deles caem.");
      }

      d -= usadoNosZumbis;
    }

    if (d > 0) {
      vida -= d;
      recebeuDanoNesteCombate = true;
    }
    if (vida < 0) {
      vida = 0;
    }
  }

  @Override
  public String toString() {
    return "Personagem{" +
        "vida=" + vida +
        ", ca=" + ca +
        ", pe=" + pe +
        ", vantagem='" + vantagem + '\'' +
        '}';
  }

}
