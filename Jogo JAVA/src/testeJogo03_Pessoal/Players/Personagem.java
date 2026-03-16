package testeJogo03_Pessoal.Players;

import javax.swing.*;
import java.util.Scanner;

public class Personagem {

    Scanner sc = new Scanner(System.in);

    protected int vida;
    protected int cd;
    protected int pe;

    protected String vantagem;

    public Personagem(int vida, int cd, int pe, String vantagem) {
        this.vida = vida;
        this.cd = cd;
        this.pe = pe;
        this.vantagem = vantagem;
    }

    protected int Escolha(){
        return Integer.parseInt(JOptionPane.showInputDialog("Realize a sua escolha: "));
    }

    protected void Recuperacao() {
        pe += 4;
    }

    protected void acao(){}

    public String getVantagem() {
        return vantagem;
    }
}