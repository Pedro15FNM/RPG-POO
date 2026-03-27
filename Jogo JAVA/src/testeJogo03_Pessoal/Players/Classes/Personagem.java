package testeJogo03_Pessoal.Players.Classes;

import testeJogo03_Pessoal.Players.SistemaHabilidades;

import javax.swing.*;
import java.util.Scanner;

public class Personagem {

  Scanner sc = new Scanner(System.in);

  public int vida;
  public int ca;
  protected int pe;

  SistemaHabilidades habilidades;

  public String vantagem;

  public Personagem(int vida, int ca, int pe, String vantagem) {
    this.vida = vida;
    this.ca = ca;
    this.pe = pe;
    this.vantagem = vantagem;
  }

  protected int Escolha() {
    return Integer.parseInt(JOptionPane.showInputDialog("Realize a sua escolha: "));
  }

  protected void Recuperacao() {
    pe += 4;
  }

  public void acao() {
  }

  public String getVantagem() {
    return vantagem;
  }

  public void setHabilidades(SistemaHabilidades habilidades) {
    this.habilidades = habilidades;
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
