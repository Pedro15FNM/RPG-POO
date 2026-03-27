# 🪓 Barbaro

Neste arquivo será explicado o funcionamento da classe **Barbaro**, seus atributos base, habilidades e funcionamento geral dentro do combate.

---

# 📜 Atributos Base

Todos os bárbaros, independentemente de sua especialização, começam com os seguintes atributos padrão.

| ⚔️ **Atributo**     | **Valor** |
|---------------------|-----------|
| ❤️ HP              | 60        |
| 🔮 PE              | 10        |
| 🎯 CA              | 12        |
| ⚖️ Vantagem Inicial | `Neutro`  |

---

## 🔹 Regras da Classe

- **Ataques físicos diretos**
- **Pouca técnica, muito dano**
- **Até 6 habilidades por arquétipo**
- **1 habilidade de recuperação**, herdada da classe `Personagem`

As habilidades abaixo foram escolhidas com foco em mecânicas simples de implementar: dano direto, bônus de turno, redução de dano e controle leve de combate.

---

### 🪓 Fúria

O bárbaro entra em um estado de combate brutal, aumentando sua agressividade e resistência por poucos turnos.

**Efeitos**

- **Custo:** 4 PE
- **Duração:** 2 turnos
- **Limite:** 2 usos por luta
- **Efeito:** ganha `+2` no dano das habilidades corpo a corpo e `+1` de vantagem nas rolagens de ataque durante a Fúria.

```
// 🪓 Fúria (Custo: 4 PE | Dano: Nenhum | Efeito: +Dano corpo a corpo / +Vantagem | Critério: 2 usos por luta, duração total de 2 turnos)
```

---

### 🪓 Ataque

Golpe bruto e direto, usado como a ação padrão do bárbaro.

**Efeitos**

- **Dano:** 1d12

```
// 🪓 Ataque (Custo: Nenhum | Dano: 1d12 | Efeito: Nenhum | Critério: Nenhum)
```

---

### 🪓 Investida Brutal

O bárbaro avança com força total, usando peso e impulso para romper a defesa do alvo.

**Efeitos**

- **Custo:** 3 PE
- **Dano:** 2d8
- **Efeito:** se o alvo estiver sob `Desvantagem`, causa `+1d4` de dano adicional.

```
// 🪓 Investida Brutal (Custo: 3 PE | Dano: 2d8 | Efeito: +1d4 contra alvo em Desvantagem | Critério: O alvo precisa estar visível e em alcance corpo a corpo)
```

---

### 🪓 Pele de Ferro

O corpo do bárbaro endurece como uma fortaleza viva, reduzindo o dano recebido por um curto período.

**Efeitos**

- **Custo:** 4 PE
- **Duração:** 2 turnos
- **Efeito:** reduz em `50%` o próximo dano recebido por turno.

```
// 🪓 Pele de Ferro (Custo: 4 PE | Dano: Nenhum | Efeito: Redução de dano pela metade | Critério: Duração de 2 turnos)
```

---

### 🪓 Grito de Guerra

Um rugido esmagador quebra a concentração do oponente e fortalece o próprio bárbaro.

**Efeitos**

- **Custo:** 2 PE
- **Duração:** 1 turno
- **Efeito:** o próximo ataque do bárbaro recebe `+2` no dano e o inimigo sofre `Desvantagem` na próxima rolagem.

```
// 🪓 Grito de Guerra (Custo: 2 PE | Dano: Nenhum | Efeito: +2 dano no próximo ataque / inimigo em Desvantagem | Critério: Nenhum)
```

---

### 🪓 Retaliação

Quando é ferido, o bárbaro responde com violência imediata.

**Efeitos**

- **Custo:** 2 PE
- **Dano:** 1d8
- **Efeito:** só pode ser usada após receber dano no turno anterior.

```
// 🪓 Retaliação (Custo: 2 PE | Dano: 1d8 | Efeito: Contra-ataque | Critério: Usar somente após sofrer dano)
```

---

## 🪓 Resumo do Arquetipo

O bárbaro foi montado para ser simples de executar no código e forte no combate direto.  
Ele combina dano constante, bônus temporários e mitigação de dano sem exigir mecânicas muito complexas.

