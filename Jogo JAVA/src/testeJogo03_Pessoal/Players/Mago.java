package testeJogo03_Pessoal.Players;

import javax.swing.*;

import java.util.ArrayList;

/* ============================================================================================================= //
    MAGO
*/

public class Mago extends Personagem {

    protected Personagem oponente;

    public Mago(Personagem oponente) {

        super(30,10,30,"Neutro");

        this.oponente = oponente;

    }

    public Personagem getOponente() {
        return oponente;
    }
}

/* ============================================================================================================= //
    Mago de Fogo
*/

class MagoFogo extends Mago {

    SistemaHabilidades habilidadesFogo;

    public MagoFogo(Personagem oponente) {
        super(oponente);

        habilidadesFogo = new SistemaHabilidades(this, oponente);
    }

    public void acao() {

        System.out.println( "Escolha uma entre as suas Habilidades" + "\n" +
                "1 = " + habilidadesFogo.habilidadesEscolhidas.get(0) + "\n" +
                        "2 = " + habilidadesFogo.habilidadesEscolhidas.get(1) + "\n" +
                        "3 = " + habilidadesFogo.habilidadesEscolhidas.get(2) + "\n"
        );

        int acao = sc.nextInt() - 1;

        habilidadesFogo.usarHabilidade(acao);

    }

}

/* ============================================================================================================= //
    Necromante
*/

class Necromante extends Mago {

    SistemaHabilidades habilidadesNecromante;

    public Necromante(Personagem oponente) {

        super(oponente);
        habilidadesNecromante = new SistemaHabilidades(this, oponente);
    }

    @Override
    protected void acao() {

        System.out.println( "Escolha uma entre as suas Habilidades" + "\n" +
                "1 = " + habilidadesNecromante.habilidadesEscolhidas.get(0) + "\n" +
                "2 = " + habilidadesNecromante.habilidadesEscolhidas.get(1) + "\n" +
                "3 = " + habilidadesNecromante.habilidadesEscolhidas.get(2) + "\n"
        );

        int acao = sc.nextInt() - 1;

        habilidadesNecromante.usarHabilidade(acao);

    }
}

/* ============================================================================================================= //
    Mago de Gelo
*/

class MagoGelo extends Mago {

    SistemaHabilidades habilidadesGelo;

    public MagoGelo(Personagem oponente) {

        super(oponente);
        habilidadesGelo = new SistemaHabilidades(this, oponente);

    }

    public void acao() {

        System.out.println( "Escolha uma entre as suas Habilidades" + "\n" +
                "1 = " + habilidadesGelo.habilidadesEscolhidas.get(0) + "\n" +
                "2 = " + habilidadesGelo.habilidadesEscolhidas.get(1) + "\n" +
                "3 = " + habilidadesGelo.habilidadesEscolhidas.get(2) + "\n"
        );

        int acao = sc.nextInt() - 1;

        habilidadesGelo.usarHabilidade(acao);

    }
}

