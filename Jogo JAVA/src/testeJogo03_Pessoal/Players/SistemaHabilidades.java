package testeJogo03_Pessoal.Players;

import testeJogo03_Pessoal.Players.Classes.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemaHabilidades {

    List<Habilidade> habilidadesDisponiveis = new ArrayList<>();
    public List<Habilidade> habilidadesEscolhidas = new ArrayList<>();


    Scanner sc = new Scanner(System.in);

    public SistemaHabilidades(Personagem personagem, Personagem oponente) {

        ListaHabilidades lista = new ListaHabilidades(personagem, oponente);

        // adiciona métodos na lista

        if (personagem instanceof Mago) {

            ListaHabilidades.Mago mago = lista.new Mago();

            if (personagem instanceof Mago.MagoFogo) {

                ListaHabilidades.Mago.Fogo fogo = mago.new Fogo();

                habilidadesDisponiveis.add(new Habilidade("Bola de Fogo", () -> fogo.bolaDeFogo()));
                habilidadesDisponiveis.add(new Habilidade("Habilidade 2", () -> fogo.habilidade2()));
                habilidadesDisponiveis.add(new Habilidade("Habilidade 3", () -> fogo.habilidade3()));
                habilidadesDisponiveis.add(new Habilidade("Habilidade 4", () -> fogo.habilidade4()));
                habilidadesDisponiveis.add(new Habilidade("Habilidade 5", () -> fogo.habilidade5()));

                escolherHabilidades();

            }
            else if (personagem instanceof Mago.Necromante) {

                ListaHabilidades.Mago.Necromancia necro = mago.new Necromancia();

                habilidadesDisponiveis.add(new Habilidade("Invocar Zumbi", () -> necro.invocarZumbi()));
                habilidadesDisponiveis.add(new Habilidade("Habilidade 2", () -> necro.habilidade2()));
                habilidadesDisponiveis.add(new Habilidade("Habilidade 3", () -> necro.habilidade3()));
                habilidadesDisponiveis.add(new Habilidade("Habilidade 4", () -> necro.habilidade4()));
                habilidadesDisponiveis.add(new Habilidade("Habilidade 5", () -> necro.habilidade5()));

                escolherHabilidades();

            }
            else if (personagem instanceof Mago.MagoGelo) {

                ListaHabilidades.Mago.Gelo gelo = mago.new Gelo();

                habilidadesDisponiveis.add(new Habilidade("Tempestade de Gelo", () -> gelo.tempestadeDeGelo(personagem, oponente)));
                habilidadesDisponiveis.add(new Habilidade("Habilidade 2", () -> gelo.habilidade2()));
                habilidadesDisponiveis.add(new Habilidade("Habilidade 3", () -> gelo.habilidade3()));
                habilidadesDisponiveis.add(new Habilidade("Habilidade 4", () -> gelo.habilidade4()));
                habilidadesDisponiveis.add(new Habilidade("Habilidade 5", () -> gelo.habilidade5()));

                escolherHabilidades();

            }

        } 
        else if (personagem instanceof Cacador) {

            ListaHabilidades.Cacador cacador = lista.new Cacador();

            if (personagem instanceof Cacador.Arqueiro ) {

                ListaHabilidades.Cacador.Arqueiro arqueiro = cacador.new Arqueiro();

                habilidadesDisponiveis.add(new Habilidade("Habilidade 1", () -> arqueiro.Habilidade_1()));
                habilidadesDisponiveis.add(new Habilidade("Habilidade 2", () -> arqueiro.Habilidade_2()));
                habilidadesDisponiveis.add(new Habilidade("Habilidade 3", () -> arqueiro.Habilidade_3()));
                habilidadesDisponiveis.add(new Habilidade("Habilidade 4", () -> arqueiro.Habilidade_4()));
                habilidadesDisponiveis.add(new Habilidade("Habilidade 5", () -> arqueiro.Habilidade_5()));
                habilidadesDisponiveis.add(new Habilidade("Habilidade 6", () -> arqueiro.Habilidade_6()));
            }
            else if (personagem instanceof Cacador.Pistoleiro) {
                
                ListaHabilidades.Cacador.Pistoleiro pistoleiro = cacador.new Pistoleiro();

                habilidadesDisponiveis.add(new Habilidade("Habilidade 1", () -> pistoleiro.Habilidade_1()));
                habilidadesDisponiveis.add(new Habilidade("Habilidade 2", () -> pistoleiro.Habilidade_2()));
                habilidadesDisponiveis.add(new Habilidade("Habilidade 3", () -> pistoleiro.Habilidade_3()));
                habilidadesDisponiveis.add(new Habilidade("Habilidade 4", () -> pistoleiro.Habilidade_4()));
                habilidadesDisponiveis.add(new Habilidade("Habilidade 5", () -> pistoleiro.Habilidade_5()));
                habilidadesDisponiveis.add(new Habilidade("Habilidade 6", () -> pistoleiro.Habilidade_6()));

            }
        }
        else if (personagem instanceof Barbaro) {

            ListaHabilidades.Barbaro barbaro = lista.new Barbaro();

            habilidadesDisponiveis.add(new Habilidade("Habilidade 1", () -> barbaro.Habilidade_1()));
            habilidadesDisponiveis.add(new Habilidade("Habilidade 2", () -> barbaro.Habilidade_2()));
            habilidadesDisponiveis.add(new Habilidade("Habilidade 3", () -> barbaro.Habilidade_3()));
            habilidadesDisponiveis.add(new Habilidade("Habilidade 4", () -> barbaro.Habilidade_4()));
            habilidadesDisponiveis.add(new Habilidade("Habilidade 5", () -> barbaro.Habilidade_5()));
            habilidadesDisponiveis.add(new Habilidade("Habilidade 6", () -> barbaro.Habilidade_6()));

            escolherHabilidades();

        }
    }

    public void escolherHabilidades() {
        
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

    Scanner sc = new Scanner(System.in);

    public ListaHabilidades(Personagem personagem, Personagem oponente) {
        this.personagem = personagem;
        this.oponente = oponente;

        dadoClass = new Dado();
        this.dado = dadoClass.rolarDado(this.personagem.getVantagem());
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

            void habilidade2(){
                String nome = "habilidade";
            }
            void habilidade3(){
                String nome = "habilidade";
            }
            void  habilidade4(){
                String nome = "habilidade";
            }
            void habilidade5(){
                String nome = "habilidade";
            }
        }

        public class Gelo { // Mago de gelo

            public void tempestadeDeGelo(Personagem player, Personagem oponente) {

                int dado = dadoClass.rolarDado(player.getVantagem());

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
                int escolha;

                if (zumbis.size() == 0) {

                    System.out.println("Invocando Zumbi!!!");
                
                    zumbis.add(zumbi);

                    personagem.vida += zumbis.get(0).vida;
                    
                    System.out.println("Zumbi 1° invocado!!!");

                    limite = 1;

                } else {

                    System.out.println("Gostaria de: \n" + 
                        "1 = Invocar Zumbi!!!\n" +
                        "2 = Atacar com Zumbi!!!"
                    );

                    escolha = sc.nextInt();

                    if ((limite < 5) && (escolha == 1)) {
                    
                        zumbis.add(zumbi);

                        personagem.vida += zumbis.get(limite).vida;
                    
                        System.out.println("Zumbi " + (limite + 1) + "° invocado!!!");

                        limite++;
                    
                    } else if (limite == 5) {

                        System.out.println("Limite de zumbi atingido!!!");
                    
                    } else { // Realizar ação de atacar do zumbi

                        dado = dadoClass.rolarDado("Neutro");

                        if (dado > oponente.cd) {
                            
                            dano = (int) (Math.random() * 6) + 1; // assumindo d6

                            oponente.vida -= dano;

                            System.out.println("Zumbi acertou o oponente!!!\n" +
                                    "Zumbi jogou " + dado + "\n" +
                                    "Zumbi causou " + dano + " de dano no oponente!!!\n\n" +
                                    "Vida atual do oponente: " + oponente.vida);
                            
                        }

                    }
                }

               
                
            }
            class Zumbi {

                int vida = 4;
                int cd = 8;

                int dadoDano = 4;

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

    }

    public class Barbaro {

        void Habilidade_1() {
            System.out.println("Habilidade (1)");
        }
        
        void Habilidade_2() {
            System.out.println("Habilidade (2)");
        }
        
        void Habilidade_3() {
            System.out.println("Habilidade (3)");
        }

        void Habilidade_4() {
            System.out.println("Habilidade (4)");
        }

        void Habilidade_5() {
            System.out.println("Habilidade (5)");
        }

        void Habilidade_6() {
            System.out.println("Habilidade (6)");
        }

    }

    public class Cacador {
        public class Arqueiro {
            void Habilidade_1() {
                System.out.println("Habilidade (1)");
            }
            void Habilidade_2() {
                System.out.println("Habilidade (2)");
            }
            void Habilidade_3() {
                System.out.println("Habilidade (3)");
            }
            void Habilidade_4() {
                System.out.println("Habilidade (4)");
            }
            void Habilidade_5() {
                System.out.println("Habilidade (5)");
            }
            void Habilidade_6() {
                System.out.println("Habilidade (6)");
            }
        }
        public class Pistoleiro {
            void Habilidade_1() {
                System.out.println("Habilidade (1)");
            }
            void Habilidade_2() {
                System.out.println("Habilidade (2)");
            }
            void Habilidade_3() {
                System.out.println("Habilidade (3)");
            }
            void Habilidade_4() {
                System.out.println("Habilidade (4)");
            }
            void Habilidade_5() {
                System.out.println("Habilidade (5)");
            }
            void Habilidade_6() {
                System.out.println("Habilidade (6)");
            }
        }
    }

}

/*
* Habilidades ==================================================================================
* */

class Habilidade {

    String nome;   
    Runnable acao;   

    public Habilidade(String nome, Runnable acao) {
        this.nome = nome;
        this.acao = acao;
    }

    @Override
    public String toString() {
        return this.nome; 
    }

}
