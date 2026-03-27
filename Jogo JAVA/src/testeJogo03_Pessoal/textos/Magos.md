# 🧙‍♂️ Magos

Neste arquivo será explicado o funcionamento da classe **Mago**, seus arquétipos, atributos base, habilidades e funcionamento geral dentro do combate.

---

# 📜 Atributos Base

Todos os magos, independentemente de sua especialização, começam com os seguintes atributos padrão.

| ⚔️ **Atributo**     | **Valor** |
|---------------------|-----------|
| ❤️ HP              | 60        |
| 🔮 PE              | 30        |
| 🎯 CA              | 10        |
| ⚖️ Vantagem Inicial | `Neutro`  |

---

## 🔹 Regras da Classe

- **3 habilidades já definidas**
- **até 6 habilidades por arquétipo**
- **1 habilidade de recuperação**, herdada da classe `Personagem`

As habilidades abaixo foram escolhidas para serem fáceis de aplicar no código: dano, buff, debuff, escudo, invocação e efeitos de turno.

---

# 🔥 Mago de Fogo

O **Mago de Fogo** é focado em dano direto e pressão constante, usando chamas para punir o inimigo.

---

## 🔥 Bola de Fogo

Uma esfera de fogo arremessada contra o alvo.

**Efeitos**

- **Custo:** 4 PE
- **Dano:** 3d6

```
// 🔥 Bola de Fogo (Custo: 4 PE | Dano: 3d6 | Efeito: Nenhum | Critério: Nenhum)
```

---

## 🔥 Círculo de Incineração

Chamas orbitam o corpo do mago e queimam quem tentar atacá-lo de perto.

**Efeitos**

- **Custo:** 8 PE
- **Duração:** 2 turnos
- **Dano:** 1d6
- **Critério:** só ativa quando o inimigo faz ataque corpo a corpo.

```
// 🔥 Círculo de Incineração (Custo: 8 PE | Dano: 1d6 | Efeito: dano ao contato | Critério: ataque corpo a corpo do inimigo)
```

---

## 🔥 Ultimate: Fênix

O mago invoca uma fênix ardente que explode em um golpe devastador.

**Efeitos**

- **Custo:** 10 PE
- **Dano:** 8d6

```
// 🔥 Fênix (Custo: 10 PE | Dano: 8d6 | Efeito: Nenhum | Critério: Nenhum)
```

---

## 🔥 Muralha de Chamas

Uma parede de fogo separa o mago do inimigo e dificulta a aproximação.

**Efeitos**

- **Custo:** 5 PE
- **Duração:** 2 turnos
- **Efeito:** o inimigo sofre `Desvantagem` para atacar o mago enquanto a muralha existir.

```
// 🔥 Muralha de Chamas (Custo: 5 PE | Dano: Nenhum | Efeito: Desvantagem no inimigo | Critério: Nenhum)
```

---

## 🔥 Explosão Flamejante

Uma explosão curta e violenta de fogo atinge o alvo com força concentrada.

**Efeitos**

- **Custo:** 6 PE
- **Dano:** 4d6
- **Efeito:** o alvo recebe `+1d4` de dano no próximo turno por queimadura.

```
// 🔥 Explosão Flamejante (Custo: 6 PE | Dano: 4d6 | Efeito: Queimadura de +1d4 no próximo turno | Critério: Nenhum)
```

---

## 🔥 Armadura Ígnea

As chamas envolvem o corpo do mago e funcionam como proteção.

**Efeitos**

- **Custo:** 4 PE
- **Duração:** 2 turnos
- **Efeito:** reduz em `2` o próximo dano recebido por turno.

```
// 🔥 Armadura Ígnea (Custo: 4 PE | Dano: Nenhum | Efeito: -2 dano recebido | Critério: Nenhum)
```

---

# 🧟 Necromante

Enquanto outros usam magia para fazer coisas insignificantes como conjurar fogo, o Necromante domina a morte e transforma o inimigo em recurso.

---

## 🧟 Putrefação

Uma mão espectral drena a vitalidade do alvo.

**Efeitos**
- **Custo:** 8 PE
- **Dano:** 1d8
- **Cura:** 1d8

```
// 🧟 Putrefação (Custo: 8 PE | Dano: 1d8 | Efeito: cura o usuário em 1d8 | Critério: Toque deve ser realizado)
```

---

## 🧟 Erga-se

O necromante levanta um servo morto-vivo para lutar ao seu lado.

**Efeitos**
- **Custo:** 8 PE
- **Invocação:** cria um zumbi aliado.

| ⚔️ **Atributo**     | **Valor** |
|---------------------|-----------|
| ❤️ HP              | 4         |
| 🔮 PE              | 0         |
| 🎯 CA              | 8         |
| ⚖️ Vantagem Inicial | `Neutro`  |
| 🚧 Limite           | 4         |

```
// 🧟 Erga-se (Custo: 8 PE | Dano: Nenhum | Efeito: invoca Zumbi aliado | Critério: limite de 4 zumbis)
```

---

## 🧟 Condenado

Uma maldição de morte que pune o alvo com dano pesado.

**Efeitos**
- **Custo:** 10 PE
- **Dano:** 3d10

```
// 🧟 Condenado (Custo: 10 PE | Dano: 3d10 | Efeito: Nenhum | Critério: Nenhum)
```

---

## 🧟 Sifão de Vida

O necromante rouba vida do oponente e se sustenta em combate.

**Efeitos**

- **Custo:** 5 PE
- **Dano:** 2d6
- **Cura:** metade do dano causado, arredondado para baixo.

```
// 🧟 Sifão de Vida (Custo: 5 PE | Dano: 2d6 | Efeito: cura metade do dano | Critério: Nenhum)
```

---

## 🧟 Maldição da Sepultura

Uma maldição enfraquece o alvo e atrapalha sua recuperação.

**Efeitos**

- **Custo:** 4 PE
- **Duração:** 2 turnos
- **Efeito:** o alvo fica em `Desvantagem` e não pode receber cura adicional no mesmo turno.

```
// 🧟 Maldição da Sepultura (Custo: 4 PE | Dano: Nenhum | Efeito: Desvantagem + bloqueio de cura extra | Critério: Nenhum)
```

---

## 🧟 Ossos Protetores

O necromante ergue ossos ao redor do próprio corpo como defesa temporária.

**Efeitos**

- **Custo:** 3 PE
- **Duração:** 1 turno
- **Efeito:** reduz em `2` o próximo dano recebido.

```
// 🧟 Ossos Protetores (Custo: 3 PE | Dano: Nenhum | Efeito: -2 dano recebido | Critério: Nenhum)
```

---

# ❄️ Mago de Gelo

O mago de gelo controla o campo de batalha com lentidão, aprisionamento e dano consistente.

---

## ❄️ Tempestade de Gelo

Uma chuva de gelo cai sobre a área e desequilibra o inimigo.

**Efeito**
- **Custo:** 2 PE
- **Efeito:** aplica `Desvantagem` ao oponente.

```
// ❄️ Tempestade de Gelo (Custo: 2 PE | Dano: Nenhum | Efeito: Desvantagem | Critério: Nenhum)
```

---

## ❄️ Prisão Glacial

Cristais de gelo prendem o alvo e impedem sua reação.

**Efeito:**
- **Custo:** 4 PE
- **Efeito:** aplica `Paralizado` no oponente.

```
// ❄️ Prisão Glacial (Custo: 4 PE | Dano: Nenhum | Efeito: Paralizado | Critério: oponente perde o próximo turno)
```

---

## ❄️ Ice Age

Uma onda de frio extremo atravessa o campo e causa dano pesado.

```
// ❄️ Ice Age (Custo: 10 PE | Dano: 4d8 | Efeito: Nenhum | Critério: Nenhum)
```

---

## ❄️ Lâminas de Gelo

Estilhaços cortantes são lançados contra o inimigo.

**Efeitos**

- **Custo:** 5 PE
- **Dano:** 2d6
- **Efeito:** se o alvo estiver em `Desvantagem`, recebe `+1d4` de dano.

```
// ❄️ Lâminas de Gelo (Custo: 5 PE | Dano: 2d6 | Efeito: +1d4 contra alvo em Desvantagem | Critério: Nenhum)
```

---

## ❄️ Barreira de Gelo

Uma parede de gelo protege o mago de ataques diretos.

**Efeitos**

- **Custo:** 4 PE
- **Duração:** 2 turnos
- **Efeito:** reduz em `2` o próximo dano recebido por turno.

```
// ❄️ Barreira de Gelo (Custo: 4 PE | Dano: Nenhum | Efeito: -2 dano recebido | Critério: Nenhum)
```

---

## ❄️ Congelamento Profundo

O frio atravessa o corpo do inimigo e reduz sua capacidade de agir.

**Efeitos**

- **Custo:** 6 PE
- **Dano:** 1d8
- **Efeito:** o alvo fica em `Desvantagem` na próxima rolagem.

```
// ❄️ Congelamento Profundo (Custo: 6 PE | Dano: 1d8 | Efeito: Desvantagem no próximo ataque do alvo | Critério: Nenhum)
```

---

## ❄️ Resumo dos Arquétipos

- **Fogo:** dano alto e pressão contínua.
- **Necromante:** drenagem, invocação e maldições.
- **Gelo:** controle, defesa e punição por aproximação.

