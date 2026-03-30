# 🧾 Classe Pai — Personagem

A classe `Personagem` é a base de todas as entidades jogáveis no jogo. Ela define os atributos comuns, o sistema de energia e defesa, além de fornecer métodos de ação e recuperação que são herdados por Bárbaro, Caçador e Mago.

---

## 📦 Atributos principais

| Atributo | Tipo | Descrição |
|---|---|---|
| `vida` | `int` | Pontos de vida atuais do personagem. |
| `vidaMaxima` | `int` | Vida máxima do personagem. |
| `ca` | `int` | Classe de armadura do personagem. |
| `pe` | `int` | Pontos de energia atuais. |
| `peMaxima` | `int` | Pontos de energia máximos. |
| `vantagem` | `String` | Estado inicial de vantagem/desvantagem. |
| `bonusCaTemporario` | `int` | Aumento temporário de CA. |
| `mitigacaoProximoGolpe` | `int` | Redução do próximo dano recebido. |
| `paralizado` | `boolean` | Indica se o personagem perde o próximo turno. |
| `turnosMuralhaChamas` | `int` | Contador para a habilidade Muralha de Chamas. |
| `turnosCirculoIncineracao` | `int` | Contador para a habilidade Círculo de Incineração. |
| `turnosMaldicaoSepultura` | `int` | Contador para a habilidade Maldição da Sepultura. |
| `turnosMarcaCacador` | `int` | Contador da marca aplicada pelo Arqueiro. |
| `marcadoPorArqueiro` | `boolean` | Indica se o alvo está marcado. |
| `burnExtraProximoTurno` | `boolean` | Marca dano extra de queimadura no próximo turno. |
| `furiaTurnosRestantes` | `int` | Contador de duração da Fúria do Bárbaro. |
| `furiaUsosRestantes` | `int` | Usos restantes de Fúria por combate. |
| `peleDeFerroTurnosRestantes` | `int` | Contador de duraçao da habilidade Pele de Ferro. |
| `peRecuperadoPorDescanso` | `int` | Quantidade de PE recuperada ao descansar. |
| `zumbisInvocados` | `int` | Número de zumbis ativos do Necromante. |
| `recebeuDanoNesteCombate` | `boolean` | Indica se o personagem sofreu dano no turno. |
| `proximaRolagemForcadaDesvantagem` | `boolean` | Marca se o próximo ataque do oponente usa desvantagem. |
| `proximaRolagemComVantagemExtra` | `boolean` | Marca vantagem extra no próximo ataque do personagem. |

---

## 🛠 Métodos principais

- `Personagem(int vida, int ca, int pe, String vantagem)`
  - Construtor base que define os atributos iniciais do personagem.
- `descansar()`
  - Recupera PE até o limite de `peMaxima`.
- `tentarGastarPe(int custo)`
  - Verifica se há energia suficiente e reduz `pe` quando a habilidade é usada.
- `receberDano(int danoBruto)`
  - Calcula dano final considerando proteções como Pele de Ferro, mitigação e barreiras.
- `alterarPe(int delta)`
  - Ajusta `pe` e `peMaxima` com base nas escolhas de criação.
- `alterarVidaMaxima(int delta)`
  - Ajusta `vidaMaxima` e a vida atual do personagem.
- `getCaEfetivo()`
  - Retorna `ca` somado ao bônus temporário de CA.
- `setHabilidades(SistemaHabilidades habilidades)`
  - Associa as habilidades escolhidas ao personagem.
- `getHabilidades()`
  - Retorna o sistema de habilidades configurado.
- `acao()`
  - Método sobrescrito pelas subclasses para apresentar as opções de combate.

---

## 🧬 Herança

A classe `Personagem` é estendida por:

- `Barbaro`
- `Cacador`
  - `Cacador.Arqueiro`
  - `Cacador.Pistoleiro`
- `Mago`
  - `Mago.MagoFogo`
  - `Mago.MagoGelo`
  - `Mago.Necromante`

---

## ⚠️ Nota de implementação

A criação de personagem agora segue o fluxo do arquivo `Criador_FearHunger.md` dentro de `CriadordePersonagem`. Entradas inválidas repetidas são tratadas com a exceção `CriadorDePersonagemException`, garantindo que o jogo só prossiga com uma ficha válida.
