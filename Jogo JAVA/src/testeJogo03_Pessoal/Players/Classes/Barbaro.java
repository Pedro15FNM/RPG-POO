package testeJogo03_Pessoal.Players.Classes;

import javax.swing.*;

public class Barbaro extends Personagem {

    // Construtor ==================================

    public Barbaro(Personagem oponente) {

        super(120, 14, 10, "Neutro");
    }

    @Override
    public void acao() {
        System.out.println("Barbaro ataca!");
        // Implementar lógica de ataque
    }

}