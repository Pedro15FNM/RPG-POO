# 🪓 Bárbaro

Neste arquivo é explicado o funcionamento da classe **Bárbaro**, seus atributos base, habilidades e como ela é construída no jogo.

---

# 📜 Atributos Base

Todos os bárbaros começam com os seguintes valores padrão:

| ⚔️ **Atributo**     | **Valor** |
|---------------------|-----------|
| ❤️ HP              | 60        |
| 🔮 PE              | 10        |
| 🎯 CA              | 12        |
| ⚖️ Vantagem Inicial | `Neutro`  |

---

## 🔹 Regras da Classe

- **Especialista em combate corpo a corpo**
- **Foco em dano bruto e resistência**
- **Até 6 habilidades no conjunto de habilidades disponíveis**
- **1 habilidade de recuperação** herdada da classe `Personagem`

A classe é baseada no código atual de `Barbaro`, que reutiliza o sistema de habilidades comum e usa `SistemaHabilidades` para selecionar as três habilidades de combate ativas.

---

## 🧬 Criação de Personagem

A ficha do Bárbaro não pergunta quais habilidades o jogador quer. Em vez disso, `CriadordePersonagem` aplica o fluxo de escolha do arquivo `Criador_FearHunger.md` e seleciona automaticamente as habilidades com base nas respostas do jogador.

Para garantir consistência, o fluxo de criação também usa `CriadorDePersonagemException` para interromper a criação caso o jogador insira várias opções inválidas.

---

### 🪓 Habilidades Principais

As habilidades do Bárbaro estão implementadas em `ListaHabilidades.SkillsBarbaro` e são expostas ao jogador de acordo com o arquétipo.

#### 🪓 Fúria

O Bárbaro entra em um estado de combate brutal, aumentando sua agressividade e resistência por poucos turnos.

- **Custo:** 4 PE
- **Duração:** 2 turnos
- **Limite:** 2 usos por luta
- **Efeito:** +2 de dano corpo a corpo e vantagem em ataques por 2 turnos.

#### 🪓 Ataque

Golpe direto e confiável, usado como ação básica.

- **Dano:** 1d12

#### 🪓 Investida Brutal

Avança com força total e tenta penetrar a defesa do inimigo.

- **Custo:** 3 PE
- **Dano:** 2d8
- **Efeito:** +1d4 de dano contra alvo sob Desvantagem.

#### 🪓 Pele de Ferro

Endurece o corpo para receber menos dano.

- **Custo:** 4 PE
- **Duração:** 2 turnos
- **Efeito:** reduz pela metade o dano recebido enquanto ativo.

#### 🪓 Grito de Guerra

Ruge para enfraquecer o inimigo e fortalecer o próprio Bárbaro.

- **Custo:** 2 PE
- **Efeito:** próximo ataque recebe +2 de dano e inimigo fica em Desvantagem.

#### 🪓 Retaliação

Responde ao dano recebido com um ataque rápido.

- **Custo:** 2 PE
- **Dano:** 1d8
- **Critério:** só pode ser usada após sofrer dano.

---

## 🪓 Resumo do Arquetipo

O Bárbaro é um personagem direto: ele combina dano consistente, proteção temporária e uso eficiente de recursos. A construção da ficha agora é controlada internamente pelo criador, sem pedir seleção manual de habilidade.

