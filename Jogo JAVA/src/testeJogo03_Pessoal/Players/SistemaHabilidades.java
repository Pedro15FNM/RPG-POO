package testeJogo03_Pessoal.Players;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemaHabilidades {

    List<Habilidade> habilidadesDisponiveis = new ArrayList<>();
    List<Habilidade> habilidadesEscolhidas = new ArrayList<>();


    Scanner sc = new Scanner(System.in);

    public SistemaHabilidades(Personagem personagem, Personagem oponente) {

        ListaHabilidades lista = new ListaHabilidades(personagem, oponente);

        // adiciona métodos na lista

        if (personagem instanceof Mago) {

            ListaHabilidades.Mago mago = lista.new Mago();

            if (personagem instanceof MagoFogo) {

                ListaHabilidades.Mago.Fogo fogo = mago.new Fogo();

                habilidadesDisponiveis.add(new Habilidade("Bola de Fogo", () -> fogo.bolaDeFogo()));
                habilidadesDisponiveis.add(new Habilidade("Habilidade 2", () -> fogo.habilidade2(personagem)));
                habilidadesDisponiveis.add(new Habilidade("Habilidade 3", () -> fogo.habilidade3(personagem)));
                habilidadesDisponiveis.add(new Habilidade("Habilidade 4", () -> fogo.habilidade4(personagem)));
                habilidadesDisponiveis.add(new Habilidade("Habilidade 5", () -> fogo.habilidade5(personagem)));

                escolherHabilidades(mago);

            }
            else if (personagem instanceof  Necromante) {

                ListaHabilidades.Mago.Necromancia necro = mago.new Necromancia();

                habilidadesDisponiveis.add(new Habilidade("Bola de Fogo", () -> necro.invocarZumbi()));
                habilidadesDisponiveis.add(new Habilidade("Habilidade 2", () -> necro.habilidade2()));
                habilidadesDisponiveis.add(new Habilidade("Habilidade 3", () -> necro.habilidade3()));
                habilidadesDisponiveis.add(new Habilidade("Habilidade 4", () -> necro.habilidade4()));
                habilidadesDisponiveis.add(new Habilidade("Habilidade 5", () -> necro.habilidade5()));

                escolherHabilidades(mago);

            }
            else if (personagem instanceof MagoGelo) {

                ListaHabilidades.Mago.Gelo gelo = mago.new Gelo();

                habilidadesDisponiveis.add(new Habilidade("Bola de Fogo", () -> gelo.tempestadeDeGelo(personagem, oponente)));
                habilidadesDisponiveis.add(new Habilidade("Habilidade 2", () -> gelo.habilidade2()));
                habilidadesDisponiveis.add(new Habilidade("Habilidade 3", () -> gelo.habilidade3()));
                habilidadesDisponiveis.add(new Habilidade("Habilidade 4", () -> gelo.habilidade4()));
                habilidadesDisponiveis.add(new Habilidade("Habilidade 5", () -> gelo.habilidade5()));

                escolherHabilidades(mago);

            }

        }

    }

    public void escolherHabilidades(ListaHabilidades.Mago mago) {

        System.out.println("Escolha 3 habilidades:\n");

        for (int i = 0; i < habilidadesDisponiveis.size(); i++) {
            System.out.println("Habilidade - " + (i + 1));
            System.out.println(habilidadesDisponiveis.get(i).nome + "\n");
        }

        for (int i = 0; i < 3; i++) {

            int escolha = sc.nextInt();

            habilidadesEscolhidas.add(habilidadesDisponiveis.get(escolha - 1));

        }

    }

    public void usarHabilidade(int numero) {

        habilidadesEscolhidas.get(numero).acao.run();

    }

}

/*
* Lista de Habilidades =========================================================================
* */

class ListaHabilidades {

    Personagem personagem;
    Personagem oponente;

    Dado dadoClass;

    int dano = 0;
    int dado;

    public ListaHabilidades(Personagem personagem, Personagem oponente) {
        this.personagem = personagem;
        this.oponente = oponente;

        dadoClass = new Dado();
        this.dado = dadoClass.rolarDado(this.personagem.vantagem);
    }

    public class Mago {

        public class Fogo {

            void bolaDeFogo() { // Bola de Fogo (Custo: 3 PE | Dano: 3d6)

                ArrayList<Integer> dadoDano = new ArrayList<>();

                if(dado > oponente.cd) {

                    for (int i = 0; i < 3; i++) {
                        int roll = (int) (Math.random() * 6) + 1;
                        dano += roll;
                        dadoDano.add(roll);
                    }

                    oponente.vida -= dano;

                    System.out.println(
                            "Mago lança BOLA DE FOGO!!!!!" + "\n" +
                                    "- Jogada de Dado: " + dado
                    );
                    for (int i = 0; i < dadoDano.size(); i++) {
                        System.out.println( (i+1) +"° Dano: "  + dadoDano.get(i));
                    }
                    System.out.println("- Dano total: " + dano);

                } else {
                    System.out.println(
                            "❌ o mago errou..." + "\n" +
                                    "- Jogada de Dado: " + dado
                    );
                }


            }

            void habilidade2(Personagem player){
                String nome = "habilidade";
            }
            void habilidade3(Personagem player){
                String nome = "habilidade";
            }
            void  habilidade4(Personagem player){
                String nome = "habilidade";
            }
            void habilidade5(Personagem player){
                String nome = "habilidade";
            }
        }

        public class Gelo { // Mago de gelo

            public void tempestadeDeGelo(Personagem player,  Personagem oponente) {

                int dado = dadoClass.rolarDado(player.vantagem);

                if (dado >  oponente.cd) {

                    oponente.vantagem = "Desvantagem";

                    System.out.println("jogador usou Tempestade de Gelo\n" +
                        "Dado: " + dado + "\n" +
                        "Opoenente: " + oponente.vantagem
                    );

                } else {
                    System.out.println("Jogador falhou a Tempestade de gelo\n " +
                        "Dado: " + dado
                    );
                }

            }

            void habilidade2(){
                System.out.println("Habilidade 2");
            }
            void habilidade3(){
                System.out.println("Habilidade 3");
            }
            void  habilidade4(){
                System.out.println("Habilidade 4");
            }
            void habilidade5(){
                System.out.println("Habilidade 5");
            }
        }

        public class Necromancia { // Necromante
            
            public void invocarZumbi() {
                System.out.println("💀 Um zumbi foi invocado!");

                Zumbi zumbi = new Zumbi();
                List<Zumbi> zumbis = new ArrayList<>();

                int limite = 0;
                
                if (limite < 4) {

                    zumbis.add(zumbi);
                    
                    personagem.vida += 4;

                    System.out.println("Zumbi " + limite + "° invocado!!!");
                } else {
                    System.out.println("Limite de zumbi atingido!!!");
                }

               
                
            }
            void habilidade2(){
                System.out.println("Habilidade 2");
            }
            void habilidade3(){
                System.out.println("Habilidade 3");
            }
            void  habilidade4(){
                System.out.println("Habilidade 4");
            }
            void habilidade5(){
                System.out.println("Habilidade 5");
            }

            class Zumbi {

                int vida = 4;
                int cd = 8;

                int dadoDano = 4;

            }

        }
    }

}

class Habilidade {

    String nome;      // O atributo que você quer printar
    Runnable acao;    // O código que você quer salvar

    public Habilidade(String nome, Runnable acao) {
        this.nome = nome;
        this.acao = acao;
    }

    @Override
    public String toString() {
        return this.nome; // Isso faz o System.out.println funcionar!
    }

}
