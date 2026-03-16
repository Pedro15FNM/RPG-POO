# 🧙‍♂️ Magos

Neste arquivo `README.md` será explicado o funcionamento da classe **Mago**, suas subcategorias, atributos base, habilidades e funcionamento geral dentro do combate.

---

# 📜 Atributos Base

Todos os magos, independentemente de sua especialização, começam com os seguintes atributos padrão.

| ⚔️ **Atributo**  | **Valor** |
|------------------|-----------|
| ❤️ HP  ███       | 30        |
| 🔮 PE  ██████████ | 30        |
| 🎯 CD  ██████    | 10        |
| ⚖️ Vantagem Inicial | `Neutro` |

## 🔹 Métodos

Todos os magos possuem:

- **3 habilidades individuais de combate**
- **1 habilidade de recuperação**, herdada da classe `Personagem`

Essas habilidades representam as técnicas mágicas dominadas pelo mago e são utilizadas durante o combate.

---

# 🔥 Mago de Fogo

O **Mago de Fogo** é uma classe mágica focada em **dano direto**.  
Todas as suas habilidades são voltadas para **ataques ofensivos e destruição**, utilizando o elemento fogo como fonte de poder.

---

## 🔥 Bola de Fogo

No sentido mais literal da palavra, trata-se de **uma bola de fogo lançada pelo mago contra o inimigo**.

**Efeitos**

- **Custo:** 4 PE
- **Dano:** 3d6

---

## 🔥 Círculo de Incineração

O mago é envolvido por **chamas ardentes que circulam seu corpo**, formando uma aura infernal que queima qualquer inimigo que se aproxime.

**Efeitos**

- **Custo:** 8 PE
- **Dano:** 1d6
- **Observação:** Só funciona quando o inimigo realiza um ataque corpo a corpo contra o mago.

---

## 🔥 Ultimate: Fênix

O mago invoca das forças elementais **uma fênix alada**, símbolo da perseverança, resistência e destruição em sua forma mais pura.

**Efeitos**

- **Custo:** 10 PE
- **Dano:** 8d6

---

# 🧟 Necromante
Enquanto outros usam magia para fazer coisas insignificantes como conjurar fogo ou voar, o Necromante é um mestre sobre a própria morte. Eles estudam os segredos profundos e proibidos que ressuscitam os mortos, controlando lacaios em direção a uma variedade de objetivos. Talvez eles busquem o poder que o domínio sobre a morte proporciona. Talvez eles sejam estudiosos sérios e desavergonhados, que rejeitam os limites mesquinhos mantidos por outros. Cada inimigo que eles caem se torna um aliado ávido e descartável, eles se tornam imunes às energias da morte e da decadência e, por fim, controlam a imortalidade e o poder dos mortos-vivos para si mesmos.

---

## 🧟 Putrefação
Você cria uma mão esquelética fantasmagórica no espaço de uma criatura, dentro do alcance. Realize um ataque à distância com magia contra a criatura para afetá-la com o **necrose** roubando a vitalidade que a parte do corpo afetado teria para o seu corpo.

**Efeitos**
- **Custo:**  8 PE
- **Dano:** 1d8
- **Cura:** 1d8

---

## 🧟 Erga-se
Essa magia cria um servo morto-vivo. Sua magia imbui o alvo com uma imitação corrompida de vida, erguendo-o como uma criatura morta-viva.

**Efeitos**
- **Custo:** 8 PE
- **Invocação:** Invoca uma criatura morta viva como aliado.

| ⚔️ **Atributo**   | **Valor** |
|-------------------|-----------|
| ❤️ HP  █          | 4         |
| 🔮 PE   | 0         |
| 🎯 CD  ████     | 8         |
| ⚖️ Vantagem Inicial | `Neutro`  |
| 🚧 Limite         | 4         |

---

## 🧟 Condenado
Você profere uma palavra de poder que pode compelir uma criatura que você possa ver, dentro do alcance, a morrer instantaneamente.

**Efeitos**
- **Custo:** 10 PE
- **Dano:** 3d10

---

# ❄️ Mago de Gelo
## Congele tudo em seu caminho
Enquanto muitos magos sucumbem ao poder barato e simplório do fogo, o mago glacial enxerga a verdade: o frio,conhecido como o elemento verdadeiro, é de onde vem o verdadeiro poder. Somente o poder do frio pode ser eficiente como uma energia que atravessa a matéria, ou sólido como uma muralha de gelo, ou cortante como uma espada, ou cicatrizante como um medicamento.

---

## ❄️ Tempestade de Gelo
O usuário ao apontar o seu cajado para o céu, aglutinan-se uma quantidade de nuvens as quais rapidamente se carregam em uma poderosa tempestade de gelo que atingem uma área de 10 metros de raio em torno do alvo.

**Efeito**
- **Custo:** 2 PE
- **Condição:** `Desvantagem`

---

## ❄️ Prisão glacial
Ao conjurar a magia, uma aura de frio absoluto irrompe de seus dedos. O ar ao redor do seu inimigo congela instantaneamente, formando cristais afiados que se unem em um casulo de gelo negro. O alvo é envolto em uma prisão glacial, incapaz de mover um músculo, enquanto o gelo escuro suga o calor de sua vida, deixando-o visível, porém totalmente indefeso, preso em uma tumba temporária.

**Efeito:**
- **Custo:** 4 PE
- **Condição:** `Paralizado`
