package testeJogo03_Pessoal.Players.Classes;


import testeJogo03_Pessoal.Players.SistemaHabilidades;

public class Cacador extends Personagem {
    
    public Cacador(Personagem oponente) {
        super(25, 16, 15, "Neutro");
    }

    @Override
    public void acao() {
        System.out.println("Cacador ataca!");
    }

    public static class Arqueiro extends Cacador {

        SistemaHabilidades habilidades;

        public Arqueiro(Personagem oponente) {

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

    }
    public static class Pistoleiro extends Cacador {
        SistemaHabilidades habilidades;

        public Pistoleiro(Personagem oponente) {

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
    }

}
