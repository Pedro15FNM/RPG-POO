package testeJogo03_Pessoal.Players.Classes;

/* ============================================================================================================= //
    MAGO
*/

import testeJogo03_Pessoal.Players.SistemaHabilidades;

public class Mago extends Personagem {

    protected Personagem oponente;

    public Mago(Personagem oponente) {

        super(30,10,30,"Neutro");

        this.oponente = oponente;

    }

    public static class MagoFogo extends Mago {

        public MagoFogo(Personagem oponente) {
            super(oponente);
        }

        public void acao() {

            System.out.println( "Escolha uma entre as suas Habilidades" + "\n" +
                    "1 = " + habilidades.habilidadesEscolhidas.get(0) + "\n" +
                    "2 = " + habilidades.habilidadesEscolhidas.get(1) + "\n" +
                    "3 = " + habilidades.habilidadesEscolhidas.get(2) + "\n"
            );

            int acao = sc.nextInt() - 1;

            habilidades.usarHabilidade(acao);

        }

        @Override
        public String toString() {
            return super.toString();
        }

    }

    public static class MagoGelo extends Mago {

        SistemaHabilidades habilidadesGelo;

        public MagoGelo(Personagem oponente) {

            super(oponente);

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

        @Override
        public String toString() {
            return super.toString();
        }

    }

    public static class Necromante extends Mago {

        SistemaHabilidades habilidades;

        public Necromante(Personagem oponente) {

            super(oponente);

        }

        @Override
        public void acao() {

            System.out.println( "Escolha uma entre as suas Habilidades" + "\n" +
                    "1 = " + habilidades.habilidadesEscolhidas.get(0) + "\n" +
                    "2 = " + habilidades.habilidadesEscolhidas.get(1) + "\n" +
                    "3 = " + habilidades.habilidadesEscolhidas.get(2) + "\n"
            );

            int acao = sc.nextInt() - 1;

        }

        @Override
        public String toString() {
            return super.toString();
        }

    }
}

