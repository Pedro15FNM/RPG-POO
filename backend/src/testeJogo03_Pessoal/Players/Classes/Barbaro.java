package testeJogo03_Pessoal.Players.Classes;

import testeJogo03_Pessoal.Players.SistemaHabilidades;

public class Barbaro extends Personagem {

    public Barbaro(Personagem oponente) {

        super(60, 12, 10, "Neutro");
    }

    @Override
    public void acao() {
        SistemaHabilidades h = getHabilidades();

        System.out.println("\n=== Sua ação (Bárbaro) ===");
        System.out.println("1 = " + h.habilidadesEscolhidas.get(0));
        System.out.println("2 = " + h.habilidadesEscolhidas.get(1));
        System.out.println("3 = " + h.habilidadesEscolhidas.get(2));
        System.out.println("4 = Descansar (recuperar PE)");
        System.out.print("Escolha (1-4): ");

        int escolha = sc.nextInt();

        if (escolha == 4) {
            descansar();
            return;
        }

        int indice = escolha - 1;
        if (indice < 0 || indice >= h.habilidadesEscolhidas.size()) {
            System.out.println("Você perde o ímpeto e não faz nada neste turno.");
            return;
        }

        h.usarHabilidade(indice);
    }

}
