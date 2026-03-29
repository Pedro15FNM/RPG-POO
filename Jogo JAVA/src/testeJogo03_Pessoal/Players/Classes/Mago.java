package testeJogo03_Pessoal.Players.Classes;

/* ============================================================================================================= //
    MAGO
*/

import testeJogo03_Pessoal.Players.SistemaHabilidades;

public class Mago extends Personagem {

  protected Personagem oponente;

  public Mago(Personagem oponente) {

    super(60, 10, 30, "Neutro");

    this.oponente = oponente;

  }

  public static class MagoFogo extends Mago {

    public MagoFogo(Personagem oponente) {
      super(oponente);
    }

    public void acao() {

      SistemaHabilidades h = getHabilidades();

      System.out.println("\n=== Sua ação (Mago de Fogo) ===");
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
        System.out.println("Você hesita e perde o momento de agir...");
        return;
      }

      h.usarHabilidade(indice);

    }

    @Override
    public String toString() {
      return super.toString();
    }

  }

  public static class MagoGelo extends Mago {

    public MagoGelo(Personagem oponente) {

      super(oponente);

    }

    public void acao() {

      SistemaHabilidades h = getHabilidades();

      System.out.println("\n=== Sua ação (Mago de Gelo) ===");
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
        System.out.println("Você hesita e o frio paira no ar...");
        return;
      }

      h.usarHabilidade(indice);

    }

    @Override
    public String toString() {
      return super.toString();
    }

  }

  public static class Necromante extends Mago {

    public Necromante(Personagem oponente) {

      super(oponente);

    }

    @Override
    public void acao() {
      SistemaHabilidades h = getHabilidades();

      System.out.println("\n=== Sua ação (Necromante) ===");
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
        System.out.println("Os mortos aguardam… mas nada acontece.");
        return;
      }

      h.usarHabilidade(indice);
    }

    @Override
    public String toString() {
      return super.toString();
    }

  }
}
