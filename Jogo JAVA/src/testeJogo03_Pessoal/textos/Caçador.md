# 🤠 Caçador

Neste arquivo será explicado o funcionamento da classe **Caçador**, seus arquétipos, atributos, habilidades e implementação geral em combate.

---

## 📜 Atributos Base

Todos os caçadores, independentemente de sua especialização, começam com os seguintes atributos padrão.

| ⚔️ **Atributo**     | **Valor** |
|---------------------|-----------|
| ❤️ HP              | 40        |
| 🔮 PE              | 20        |
| 🎯 CA              | 16        |
| ⚖️ Vantagem Inicial | `Neutro`  |

---

## 🏹 Regras da Classe

- **Combate à distância**
- **Gestão de munição**
- **Até 6 habilidades por arquétipo**
- **1 habilidade de recuperação**, herdada da classe `Personagem`

A classe foi organizada para ficar fácil de implementar em código: habilidades com custo fixo, dano direto, bônus de acerto e efeitos de controle simples.

---

# 🏹 Arqueiro

O Arqueiro domina o combate com arco, mira e pressão constante de longo alcance.

- **💣 Munição:** 30
- **Habilidade padrão:** `Recarregar`

---

### 🏹 Tiro de Flecha

Disparo básico e preciso, usado como ataque principal do arqueiro.

**Efeitos**

- **Custo:** 1 PE & 1 Flecha
- **Dano:** 1d8

```
// 🏹 Tiro de Flecha (Custo: 1 PE & 1 Flecha | Dano: 1d8 | Efeito: Nenhum | Critério: Nenhum)
```

---

### 🏹 Marca do Caçador

O arqueiro marca um alvo e passa a explorá-lo com mais eficiência.

**Efeitos**

- **Custo:** 8 PE
- **Duração:** 3 turnos
- **Efeito:** o alvo recebe o dobro de dano do arqueiro enquanto estiver marcado.

```
// 🏹 Marca do Caçador (Custo: 8 PE | Dano: Nenhum | Efeito: Inimigo recebe dano dobrado do arqueiro | Critério: gastar o turno marcando o alvo)
```

---

### 🏹 Chuva de Flechas

O arqueiro dispara várias flechas em uma área pequena, pressionando o inimigo com volume de ataque.

**Efeitos**

- **Custo:** 5 PE & 3 Flechas
- **Dano:** 2d6
- **Efeito:** se o alvo estiver marcado, recebe `+1d4` de dano adicional.

```
// 🏹 Chuva de Flechas (Custo: 5 PE & 3 Flechas | Dano: 2d6 | Efeito: +1d4 contra alvo marcado | Critério: precisa de munição suficiente)
```

---

### 🏹 Flecha Perfurante

Uma flecha reforçada atravessa brechas na defesa do oponente.

**Efeitos**

- **Custo:** 4 PE & 1 Flecha
- **Dano:** 2d8
- **Efeito:** ignora `2` pontos de CA do alvo para esta rolagem.

```
// 🏹 Flecha Perfurante (Custo: 4 PE & 1 Flecha | Dano: 2d8 | Efeito: ignora 2 CA | Critério: Nenhum)
```

---

### 🏹 Armadilha de Caça

O arqueiro prepara uma armadilha simples para reduzir a mobilidade do alvo.

**Efeitos**

- **Custo:** 3 PE
- **Duração:** 1 turno
- **Efeito:** o alvo fica em `Desvantagem` no próximo ataque.

```
// 🏹 Armadilha de Caça (Custo: 3 PE | Dano: Nenhum | Efeito: Desvantagem no próximo ataque do alvo | Critério: Nenhum)
```

---

### 🏹 Recuo Ágil

O arqueiro se reposiciona rapidamente para manter distância segura.

**Efeitos**

- **Custo:** 2 PE
- **Efeito:** o arqueiro ganha `+2` de CA até o início do próximo turno.

```
// 🏹 Recuo Ágil (Custo: 2 PE | Dano: Nenhum | Efeito: +2 CA temporária | Critério: Nenhum)
```

---

### 🏹 Tiro de Precisão

Um disparo lento, calculado e muito mais mortal que um tiro comum.

**Efeitos**

- **Custo:** 6 PE & 1 Flecha
- **Dano:** 3d6
- **Efeito:** se o alvo estiver marcado, este ataque recebe `+1d6` de dano.

```
// 🏹 Tiro de Precisão (Custo: 6 PE & 1 Flecha | Dano: 3d6 | Efeito: +1d6 contra alvo marcado | Critério: Nenhum)
```

---

# 🔫 Pistoleiro

O Pistoleiro usa revólveres, tiros curtos e explosões rápidas de dano.

- **💣 Munição:** 6
- **Habilidade padrão:** `Recarregar`

---

### 🔫 Tiro Rápido

Um disparo acelerado para pressionar o inimigo sem dar tempo de reação.

**Efeitos**

- **Custo:** 2 PE & 1 Bala
- **Dano:** 1d8
- **Efeito:** o próximo ataque do pistoleiro recebe `+1` na rolagem.

```
// 🔫 Tiro Rápido (Custo: 2 PE & 1 Bala | Dano: 1d8 | Efeito: +1 na próxima rolagem de ataque | Critério: Nenhum)
```

---

### 🔫 Saque Relâmpago

O pistoleiro saca e mira em um único movimento, ganhando vantagem no início da troca.

**Efeitos**

- **Custo:** 2 PE
- **Efeito:** ganha `Vantagem` na próxima rolagem de ataque.

```
// 🔫 Saque Relâmpago (Custo: 2 PE | Dano: Nenhum | Efeito: Vantagem na próxima rolagem | Critério: Nenhum)
```

---

### 🔫 Bala Ricochete

A bala rebate em superfícies e atinge o alvo com ângulo imprevisível.

**Efeitos**

- **Custo:** 4 PE & 1 Bala
- **Dano:** 2d6
- **Efeito:** se a rolagem acertar, causa `+1d4` de dano adicional.

```
// 🔫 Bala Ricochete (Custo: 4 PE & 1 Bala | Dano: 2d6 | Efeito: +1d4 extra no acerto | Critério: Nenhum)
```

---

### 🔫 Tiro de Precisão

Disparo focado para maximizar a chance de dano alto.

**Efeitos**

- **Custo:** 5 PE & 1 Bala
- **Dano:** 3d6
- **Efeito:** reduz em `1` a CA do alvo apenas para esta rolagem.

```
// 🔫 Tiro de Precisão (Custo: 5 PE & 1 Bala | Dano: 3d6 | Efeito: reduz 1 CA temporariamente | Critério: Nenhum)
```

---

### 🔫 Cobertura Tática

O pistoleiro se protege atrás de cobertura e se prepara para a troca seguinte.

**Efeitos**

- **Custo:** 3 PE
- **Duração:** 1 turno
- **Efeito:** reduz em `2` o próximo dano recebido.

```
// 🔫 Cobertura Tática (Custo: 3 PE | Dano: Nenhum | Efeito: -2 dano no próximo golpe recebido | Critério: Nenhum)
```

---

### 🔫 Execução

O pistoleiro finaliza alvos já enfraquecidos com um disparo mortal.

**Efeitos**

- **Custo:** 8 PE & 1 Bala
- **Dano:** 4d6
- **Efeito:** causa `+2` de dano se o alvo estiver com menos da metade da vida.

```
// 🔫 Execução (Custo: 8 PE & 1 Bala | Dano: 4d6 | Efeito: +2 dano em alvo abaixo de 50% HP | Critério: Nenhum)
```

---

## 🏹🔫 Resumo dos Arquétipos

Os dois arquétipos do Caçador foram pensados para facilitar a implementação no combate:

- **Arqueiro:** foco em marcação, dano consistente e controle de distância.
- **Pistoleiro:** foco em tiros rápidos, reposicionamento e finalização.

