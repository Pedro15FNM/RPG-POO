package testeJogo03_Pessoal.Players;

public class Dado {

    int dado;
    int primeiroDado;

    public int rolarDado(String condicao) {

        if (condicao.equals("Neutro")) {
            for (int i = 0; i < 1; i++) {
                dado = (int) (Math.random() * 21) + 1;
            }
            return dado;

        } else if (condicao.equals("Vantagem")) {
            for (int i = 0; i < 2; i++) {
                dado = (int) (Math.random() * 21) + 1;
                if (i == 0) {
                    primeiroDado = dado;
                }
                if (dado < primeiroDado) {
                    dado = primeiroDado;
                }
            }
            return dado;
        } else if (condicao.equals("Desvantagem")) {
            for (int i = 0; i < 2; i++) {
                dado = (int) (Math.random() * 21) + 1;
                if (i == 0) {
                    primeiroDado = dado;
                } else if (dado > primeiroDado) {
                    dado = primeiroDado;
                }
            }
            return dado;
        } else {
            return 0;
        }
    }
}
