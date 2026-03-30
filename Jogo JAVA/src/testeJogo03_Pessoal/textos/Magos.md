# 🧙‍♂️ Magos

Este arquivo descreve a classe **Mago**, seus arquétipos e como cada conjunto de habilidades é estruturado no código.

---

## 📜 Atributos Base

Todos os magos começam com os seguintes valores base:

| ⚔️ **Atributo**     | **Valor** |
|---------------------|-----------|
| ❤️ HP              | 60        |
| 🔮 PE              | 30        |
| 🎯 CA              | 10        |
| ⚖️ Vantagem Inicial | `Neutro`  |

---

## 🔹 Regras da Classe

- **Múltiplos arquétipos com perfil mágico distinto**
- **Até 6 habilidades disponíveis por arquétipo**
- **1 habilidade de recuperação** herdada da classe `Personagem`
- **Seleção automática de habilidades ativas** em `CriadordePersonagem`

A criação de personagem pergunta apenas as preferências de história. A escolha de habilidades não é manual: o sistema determina quais habilidades ficam ativas com base nas respostas do jogador.

---

# 🔥 Mago de Fogo

O Mago de Fogo é focado em dano direto e pressão constante, usando chamas para punir o inimigo.

### 🔥 Bola de Fogo

- **Custo:** 4 PE
- **Dano:** 3d6

### 🔥 Círculo de Incineração

- **Custo:** 8 PE
- **Duração:** 2 turnos
- **Efeito:** causa dano quando o inimigo ataca corpo a corpo.

### 🔥 Fênix

- **Custo:** 10 PE
- **Dano:** 8d6

### 🔥 Muralha de Chamas

- **Custo:** 5 PE
- **Duração:** 2 turnos
- **Efeito:** inimigo sofre Desvantagem para atacar o mago.

### 🔥 Explosão Flamejante

- **Custo:** 6 PE
- **Dano:** 4d6
- **Efeito:** queimadura causa +1d4 no próximo turno.

### 🔥 Armadura Ígnea

- **Custo:** 4 PE
- **Duração:** 2 turnos
- **Efeito:** reduz em 2 o próximo dano recebido.

---

# 🧟 Necromante

O Necromante domina a morte e transforma o inimigo em recurso.

### 🧟 Putrefação

- **Custo:** 8 PE
- **Dano:** 1d8
- **Efeito:** cura 1d8.

### 🧟 Erga-se

- **Custo:** 8 PE
- **Efeito:** invoca até 4 zumbis aliados.

### 🧟 Condenado

- **Custo:** 10 PE
- **Dano:** 3d10

### 🧟 Sifão de Vida

- **Custo:** 5 PE
- **Dano:** 2d6
- **Efeito:** cura metade do dano causado.

### 🧟 Maldição da Sepultura

- **Custo:** 4 PE
- **Duração:** 2 turnos
- **Efeito:** alvo fica em Desvantagem e não pode receber cura extra no mesmo turno.

### 🧟 Ossos Protetores

- **Custo:** 3 PE
- **Duração:** 1 turno
- **Efeito:** reduz em 2 o próximo dano recebido.

---

# ❄️ Mago de Gelo

O Mago de Gelo controla o campo de batalha com controle e defesa.

### ❄️ Tempestade de Gelo

- **Custo:** 2 PE
- **Efeito:** aplica Desvantagem ao oponente.

### ❄️ Prisão Glacial

- **Custo:** 4 PE
- **Efeito:** paralisa o oponente, fazendo-o perder o próximo turno.

### ❄️ Ice Age

- **Custo:** 10 PE
- **Dano:** 4d8

### ❄️ Lâminas de Gelo

- **Custo:** 5 PE
- **Dano:** 2d6
- **Efeito:** +1d4 contra alvo em Desvantagem.

### ❄️ Barreira de Gelo

- **Custo:** 4 PE
- **Duração:** 2 turnos
- **Efeito:** reduz em 2 o próximo dano recebido.

### ❄️ Congelamento Profundo

- **Custo:** 6 PE
- **Dano:** 1d8
- **Efeito:** alvo fica em Desvantagem no próximo ataque.

---

## 🧠 Resumo dos Arquétipos

- **Fogo:** dano alto e pressão contínua.
- **Necromante:** drenagem, invocação e maldições.
- **Gelo:** controle, defesa e punição por aproximação.
