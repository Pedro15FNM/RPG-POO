package testeJogo03_Pessoal.Players.Classes;


import testeJogo03_Pessoal.Players.SistemaHabilidades;

public class Cacador extends Personagem {

    public Cacador(Personagem oponente) {
        super(40, 16, 20, "Neutro");
    }

    @Override
    public void acao() {
        System.out.println("Subclasse do Caçador deve executar a ação.");
    }

    public static class Arqueiro extends Cacador {

        /** Munição inicial conforme documentação. */
        public int flechas = 30;
        public final int maxFlechas = 30;

        public Arqueiro(Personagem oponente) {
            super(oponente);
        }

        public void acao() {
            SistemaHabilidades h = getHabilidades();

            System.out.println("\n=== Sua ação (Arqueiro) ===");
            System.out.println("Flechas: " + flechas + "/" + maxFlechas);

            if (flechas == 0) {
                System.out.println("Você está sem flechas e recarrega automaticamente, perdendo essa ação.");
                recarregar();
                return;
            }

            System.out.println("1 = " + h.habilidadesEscolhidas.get(0));
            System.out.println("2 = " + h.habilidadesEscolhidas.get(1));
            System.out.println("3 = " + h.habilidadesEscolhidas.get(2));
            System.out.println("4 = Descansar (recuperar PE)");
            System.out.println("5 = Recarregar munição");
            System.out.print("Escolha (1-5): ");

            int escolha = sc.nextInt();

            if (escolha == 4) {
                descansar();
                return;
            }

            if (escolha == 5) {
                recarregar();
                return;
            }

            int indice = escolha - 1;
            if (indice < 0 || indice >= h.habilidadesEscolhidas.size()) {
                System.out.println("Você baixa o arco por um instante e não ataca.");
                return;
            }

            h.usarHabilidade(indice);
        }

        public void recarregar() {
            if (flechas >= maxFlechas) {
                System.out.println("Suas flechas já estão carregadas.");
                return;
            }
            flechas = maxFlechas;
            System.out.println("Você recarrega o arco. Flechas restauradas para " + flechas + ".");
        }

    }
    public static class Pistoleiro extends Cacador {

        public int balas = 6;
        public final int maxBalas = 6;

        public Pistoleiro(Personagem oponente) {
            super(oponente);
        }

        public void acao() {
            SistemaHabilidades h = getHabilidades();

            System.out.println("\n=== Sua ação (Pistoleiro) ===");
            System.out.println("Balas: " + balas + "/" + maxBalas);

            if (balas == 0) {
                System.out.println("Você está sem balas e recarrega automaticamente, perdendo essa ação.");
                recarregar();
                return;
            }

            System.out.println("1 = " + h.habilidadesEscolhidas.get(0));
            System.out.println("2 = " + h.habilidadesEscolhidas.get(1));
            System.out.println("3 = " + h.habilidadesEscolhidas.get(2));
            System.out.println("4 = Descansar (recuperar PE)");
            System.out.println("5 = Recarregar munição");
            System.out.print("Escolha (1-5): ");

            int escolha = sc.nextInt();

            if (escolha == 4) {
                descansar();
                return;
            }

            if (escolha == 5) {
                recarregar();
                return;
            }

            int indice = escolha - 1;
            if (indice < 0 || indice >= h.habilidadesEscolhidas.size()) {
                System.out.println("Você hesita em apertar o gatilho e perde o momento.");
                return;
            }

            h.usarHabilidade(indice);
        }

        public void recarregar() {
            if (balas >= maxBalas) {
                System.out.println("Suas balas já estão carregadas.");
                return;
            }
            balas = maxBalas;
            System.out.println("Você recarrega a arma. Balas restauradas para " + balas + ".");
        }
    }

}
