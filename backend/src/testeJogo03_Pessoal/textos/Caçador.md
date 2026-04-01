# 🤠 Caçador

Este arquivo descreve a classe **Caçador**, seus arquétipos, atributos e como o código estrutura o combate à distância.

---

## 📜 Atributos Base

Todos os caçadores começam com os seguintes valores base:

| ⚔️ **Atributo**     | **Valor** |
|---------------------|-----------|
| ❤️ HP              | 40        |
| 🔮 PE              | 20        |
| 🎯 CA              | 16        |
| ⚖️ Vantagem Inicial | `Neutro`  |

---

## 🏹 Regras da Classe

- **Combate à distância e gestão de munição**
- **Até 6 habilidades disponíveis por arquétipo**
- **1 habilidade de recuperação** herdada da classe `Personagem`
- **Habilidades oponentes são selecionadas automaticamente** pelo `SistemaHabilidades`

No fluxo de criação, o jogador escolhe apenas classe e arquétipo. As habilidades ativas são definidas automativamente por `CriadordePersonagem` a partir das opções do `Criador_FearHunger.md`.

---

# 🏹 Arqueiro

O Arqueiro domina o combate com arco, mira e pressão constante de longo alcance.

- **💣 Munição inicial:** 30 flechas
- **Habilidade de suporte:** `Recarregar`

### 🏹 Tiro de Flecha

Disparo básico e preciso, usado como ataque principal.

- **Custo:** 1 PE & 1 Flecha
- **Dano:** 1d8

### 🏹 Marca do Caçador

Marca um alvo para aumentar o dano infligido por ataques subsequentes.

- **Custo:** 8 PE
- **Duração:** 3 turnos
- **Efeito:** alvo marcado recebe dano extra do Arqueiro.

### 🏹 Chuva de Flechas

Pressiona o inimigo com várias flechas ao mesmo tempo.

- **Custo:** 5 PE & 3 Flechas
- **Dano:** 2d6
- **Efeito:** +1d4 contra alvo marcado.

### 🏹 Flecha Perfurante

Tiro focado que atravessa a defesa do inimigo.

- **Custo:** 4 PE & 1 Flecha
- **Dano:** 2d8
- **Efeito:** ignora 2 pontos de CA.

### 🏹 Armadilha de Caça

Prepara uma armadilha para reduzir a mobilidade do alvo.

- **Custo:** 3 PE
- **Efeito:** alvo entra em Desvantagem no próximo ataque.

### 🏹 Recuo Ágil

Recuo rápido para ganhar melhor posicionamento defensivo.

- **Custo:** 2 PE
- **Efeito:** +2 de CA até o próximo turno.

### 🏹 Tiro de Precisão

Disparo calculado para causar dano mais alto.

- **Custo:** 6 PE & 1 Flecha
- **Dano:** 3d6
- **Efeito:** +1d6 se o alvo estiver marcado.

---

# 🔫 Pistoleiro

O Pistoleiro usa revólveres e explosões rápidas de dano.

- **💣 Munição inicial:** 6 balas
- **Habilidade de suporte:** `Recarregar`

### 🔫 Tiro Rápido

Disparo veloz que prepara o próximo ataque.

- **Custo:** 2 PE & 1 Bala
- **Dano:** 1d8
- **Efeito:** próximo ataque recebe +1.

### 🔫 Saque Relâmpago

Saque instantâneo que proporciona vantagem no ataque seguinte.

- **Custo:** 2 PE
- **Efeito:** vantagem no próximo ataque.

### 🔫 Bala Ricochete

Disparo que ricocheteia e causa dano adicional.

- **Custo:** 4 PE & 1 Bala
- **Dano:** 2d6
- **Efeito:** +1d4 de dano extra no acerto.

### 🔫 Tiro de Precisão

Disparo focado que reduz a defesa do inimigo.

- **Custo:** 5 PE & 1 Bala
- **Dano:** 3d6
- **Efeito:** reduz 1 ponto de CA no alvo para esta rolagem.

### 🔫 Cobertura Tática

Defesa rápida que reduz o dano do próximo golpe.

- **Custo:** 3 PE
- **Efeito:** -2 no próximo dano recebido.

### 🔫 Execução

Tiro finalizador para alvos enfraquecidos.

- **Custo:** 8 PE & 1 Bala
- **Dano:** 4d6
- **Efeito:** +2 de dano se o alvo estiver abaixo de 50% de vida.

---

## 🏹🔫 Resumo dos Arquétipos

- **Arqueiro:** combate à distância, marcação e dano consistente.
- **Pistoleiro:** tiros rápidos, reposicionamento e finalizações.

O fluxo de criação agora determina as habilidades do Caçador automaticamente, sem escolher manualmente cada uma durante a criação.

