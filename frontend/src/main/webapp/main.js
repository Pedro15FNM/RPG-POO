
/* ======= CRIAÇÃO DO PERSONAGEM ======= */
    // ========== SISTEMA DE PERSONAGEM ========== 
class Personagem {
    constructor(nome, classe, subclasse, escolhas, atributos, habilidades) {
        this.id = Date.now()
        this.nome = nome
        this.classe = classe
        this.subclasse = subclasse
        this.escolhas = escolhas
        this.atributos = atributos
        this.habilidades = habilidades
        this.dataCriacao = new Date().toISOString()
    }
}

class HistoricoPersonagens {
    constructor() {
        this.ultimosPersonagens = this.carregarDoStorage()
    }

    adicionar(personagem) {
        this.ultimosPersonagens.unshift(personagem)
        if (this.ultimosPersonagens.length > 4) {
            this.ultimosPersonagens.pop()
        }
        this.salvarNoStorage()
    }

    salvarNoStorage() {
        localStorage.setItem('ultimosPersonagens', JSON.stringify(this.ultimosPersonagens))
    }

    carregarDoStorage() {
        const dados = localStorage.getItem('ultimosPersonagens')
        return dados ? JSON.parse(dados) : []
    }

    obterUltimos() {
        return this.ultimosPersonagens
    }
}

    // ========== DADOS DAS PERGUNTAS (Fear & Hunger Style) ==========
const perguntas = {
    barbaro: {
        atributos1: {
            texto: "Você é de um povo tribal, guerreiro e indomável. As civilizações ditas avançadas não poderiam possuir pesadelo pior do que serem saqueadas por vocês. Mas, isso realmente te representa?",
            opcoes: [
                { texto: "Sim, minha natureza selvagem anseia por brutalidade e batalhas", efeito: { hp: 10, ca: -2 } },
                { texto: "Não, sou apenas um guerreiro fazendo o meu trabalho", efeito: {} }
            ]
        },
        atributos2: {
            texto: "No início de sua carreira como saqueador, durante o saque de uma cidade, você teve que enfrentar um dilema: um de seus oponentes derrotados clamou para que você não saqueasse, ao menos, o santuário da cidade. O que você fez?",
            opcoes: [
                { texto: "Respeitou o pedido do oponente e deixou o santuário de lado", efeito: { pe: 2 } },
                { texto: "Ignorou o pedido e saqueou tudo que foi capaz", efeito: { hp: 5 } }
            ]
        },
        habilidades1: {
            texto: "Durante suas batalhas, de maneira geral, qual seu estilo de luta?",
            opcoes: [
                { texto: "Agressivo, busco derrubar qualquer tipo de oponente", habilidade: "Ataque" },
                { texto: "Defensivo, busco resistir pelo máximo de tempo possível", habilidade: "Pele de Ferro" }
            ]
        },
        habilidades2: {
            texto: "Sua reação ao ser ferido não é como a de qualquer pessoa, sua razão é deixada de lado e seu instinto de batalha é despertado.",
            opcoes: [
                { texto: "Meu corpo se enche de fúria, me torno mais agressivo e forte", habilidade: "Fúria" },
                { texto: "Sem nem ao menos raciocinar eu contra-ataco, meu instinto age sozinho", habilidade: "Retaliação" }
            ]
        },
        habilidades3: {
            texto: "Durante seus primeiros anos de treinamento você enfrentou sua primeira barreira impenetrável, um oponente extremamente resistente e bem equipado. Como você tentou solucionar essa situação?",
            opcoes: [
                { texto: "Usei tudo que tinha a minha disposição para tentar penetrar sua armadura", habilidade: "Investida Brutal" },
                { texto: "Eu intimidei ele, tirei sua concentração", habilidade: "Grito de Guerra" }
            ]
        }
    },
    cacador: {
        atributos1: {
            texto: "O ofício da pontaria transpassa sua história desde o princípio. Você aprendeu a caçar, escolher seu alvo, estudá-lo e subjulgá-lo. Mas, quem ou o que você caça?",
            opcoes: [
                { texto: "Criaturas", efeito: { hp: 5 } },
                { texto: "Humanos", efeito: { pe: 2 } }
            ]
        },
        atributos2: {
            texto: "Depois de um longo dia, em uma longa viagem, você se sentiu satisfeito. Mas, durante toda essa empreitada, havia algo te observando. Dessa vez você é a caça. Como você reagiu?",
            opcoes: [
                { texto: "Busquei caçá-lo de volta, não aceito ser uma presa", efeito: { hp: -10, ca: 2 } },
                { texto: "Eu fujo do meu caçador, a melhor chance de uma presa é sempre fugir", efeito: {} }
            ]
        }
    },
    mago: {
        atributos1: {
            texto: "Ninguém cruza com o caminho da magia sem motivo. Você estuda a magia para obter poder ou pelo prazer de aprender magia?",
            opcoes: [
                { texto: "Pelo poder", efeito: {} },
                { texto: "Pelo prazer de aprender magia", efeito: { pe: 5, hp: -10 } }
            ]
        },
        atributos2: {
            texto: "Ainda jovem, quando se debruçava em livros, encontrou um livro proibido em uma velha biblioteca. Você sabia que ele continha magias proibidas, porém únicas. O que você fez?",
            opcoes: [
                { texto: "Li o livro inteiro, não podia deixar essa oportunidade de lado", efeito: { ca: 2, pe: -8 } },
                { texto: "Aquele livro é proibido por algum motivo, não li", efeito: {} }
            ]
        }
    }
};

    // Habilidades específicas por subclasse
const habilidadesPorSubclasse = {
    Arqueiro: ["Chuva de Flechas", "Tiro de Precisão", "Marca do Caçador", "Armadilha de Caça", "Recuo Ágil", "Flecha Perfurante"],
    Pistoleiro: ["Saque Relâmpago", "Tiro Rápido", "Bala Ricochete", "Execução", "Cobertura Tática", "Tiro de Precisão"],
    MagoFogo: ["Bola de Fogo", "Círculo de Incineração", "Fênix", "Muralha de Chamas", "Explosão Flamejante", "Armadura Ígnea"],
    Necromante: ["Putrefação", "Erga-se", "Condenado", "Sifão de Vida", "Maldição da Sepultura", "Ossos Protetores"],
    MagoGelo: ["Tempestade de Gelo", "Prisão Glacial", "Ice Age", "Lâminas de Gelo", "Barreira de Gelo", "Congelamento Profundo"],
    Barbaro: ["Ataque", "Fúria", "Investida Brutal", "Pele de Ferro", "Grito de Guerra", "Retaliação"]
};

    // Estado da criação
let estadoCriacao = {
    classe: null,
    subclasse: null,
    nome: null,
    atributos: { hp: 100, pe: 20, ca: 10 },
    habilidadesSelecionadas: [],
    respostas: []
};

let perguntaAtual = 0;
let perguntasDaClasse = [];

    // ========== FUNÇÃO DE TEXTO DATILOGRAFADO ==========
async function typeWriter(element, text, speed = 30) {
    element.innerHTML = '';
    for (let i = 0; i < text.length; i++) {
        element.innerHTML += text[i];
        await new Promise(resolve => setTimeout(resolve, speed));
    }
}

    // ========== ANIMAÇÃO DE OPÇÕES ==========
async function animateOptions(container) {
    const options = container.querySelectorAll('.option-btn');
    for (let option of options) {
        option.classList.add('highlight');
        await new Promise(resolve => setTimeout(resolve, 150));
    }
    await new Promise(resolve => setTimeout(resolve, 300));
    for (let option of options) {
        option.classList.remove('highlight');
    }
}

    // ========== CARREGAR PERGUNTAS ==========
function carregarPerguntasParaClasse(classe, subclasse) {
    const perguntasClasse = [];
    
    // Adiciona perguntas de atributos
    if (perguntas[classe] && perguntas[classe].atributos1) {
        perguntasClasse.push({ ...perguntas[classe].atributos1, tipo: 'atributo' });
    }
    if (perguntas[classe] && perguntas[classe].atributos2) {
        perguntasClasse.push({ ...perguntas[classe].atributos2, tipo: 'atributo' });
    }
    
    // Adiciona perguntas de habilidades específicas da subclasse
    if (subclasse === 'Arqueiro' || subclasse === 'Pistoleiro') {
        perguntasClasse.push({
            texto: "Durante sua caça, você prefere disparar muitas flechas fracas ou apenas um poderoso disparo?",
            opcoes: [
                { texto: "Muitas flechas", habilidade: subclasse === 'Arqueiro' ? "Chuva de Flechas" : "Tiro Rápido" },
                { texto: "Um poderoso disparo", habilidade: "Tiro de Precisão" }
            ],
            tipo: 'habilidade'
        });
        perguntasClasse.push({
            texto: "Em certos momentos você precisa ser covarde. Como você prefere fazê-lo?",
            opcoes: [
                { texto: "Começar o combate com um disparo inesperado", habilidade: subclasse === 'Arqueiro' ? "Marca do Caçador" : "Saque Relâmpago" },
                { texto: "Enganar meu oponente durante o combate", habilidade: subclasse === 'Arqueiro' ? "Armadilha de Caça" : "Bala Ricochete" }
            ],
            tipo: 'habilidade'
        });
        perguntasClasse.push({
            texto: subclasse === 'Arqueiro' 
                ? "Você nunca caçou alguém como você. De que característica sua você teria mais medo?"
                : "VOCÊ FOI BALEADO! O que você faz?",
            opcoes: subclasse === 'Arqueiro'
                ? [
                    { texto: "Minhas Flechas", habilidade: "Flecha Perfurante" },
                    { texto: "Minha Perspicácia", habilidade: "Recuo Ágil" }
                ]
                : [
                    { texto: "Continuo atirando, vou finalizar isso", habilidade: "Execução" },
                    { texto: "Recuo pegando cobertura", habilidade: "Cobertura Tática" }
                ],
            tipo: 'habilidade'
        });
    } else if (subclasse.includes('Mago')) {
        const tipoMago = subclasse.replace('Mago', '');
        perguntasClasse.push({
            texto: tipoMago === 'Fogo' 
                ? "O fogo te fascina. Esse fogo deve queimar sob sua ordem ou sozinho?"
                : tipoMago === 'Gelo'
                ? "O frio pode ser belo ou nefasto. Qual sua preferência?"
                : "A necromancia te fascina. A morte deve ser espalhada ou revertida?",
            opcoes: tipoMago === 'Fogo'
                ? [
                    { texto: "Sob minha ordem", habilidade: "Bola de Fogo" },
                    { texto: "Sozinho", habilidade: "Círculo de Incineração" }
                ]
                : tipoMago === 'Gelo'
                ? [
                    { texto: "Sólido e organizado", habilidade: "Prisão Glacial" },
                    { texto: "Disperso e caótico", habilidade: "Tempestade de Gelo" }
                ]
                : [
                    { texto: "Espalhada", habilidade: "Putrefação" },
                    { texto: "Revertida", habilidade: "Erga-se" }
                ],
            tipo: 'habilidade'
        });
        perguntasClasse.push({
            texto: "O que mais te interessa no seu tipo de magia?",
            opcoes: [
                { texto: "Flexibilidade", habilidade: tipoMago === 'Fogo' ? "Muralha de Chamas" : tipoMago === 'Gelo' ? "Lâminas de Gelo" : "Sifão de Vida" },
                { texto: "Poder bruto", habilidade: tipoMago === 'Fogo' ? "Fênix" : tipoMago === 'Gelo' ? "Ice Age" : "Condenado" }
            ],
            tipo: 'habilidade'
        });
        perguntasClasse.push({
            texto: "A opinião de um mago sobre um bom vinho é sempre algo de qualidade. Qual seu sabor favorito?",
            opcoes: [
                { texto: "Doce com um toque amadeirado", habilidade: tipoMago === 'Fogo' ? "Explosão Flamejante" : tipoMago === 'Gelo' ? "Barreira de Gelo" : "Maldição da Sepultura" },
                { texto: "Não gosto de vinho!", habilidade: tipoMago === 'Fogo' ? "Armadura Ígnea" : tipoMago === 'Gelo' ? "Congelamento Profundo" : "Ossos Protetores" }
            ],
            tipo: 'habilidade'
        });
    } else if (classe === 'barbaro') {
        perguntasClasse.push(perguntas.barbaro.habilidades1);
        perguntasClasse.push(perguntas.barbaro.habilidades2);
        perguntasClasse.push(perguntas.barbaro.habilidades3);
    }
    
    return perguntasClasse;
}

    // ========== EXIBIR PERGUNTA COM DATILOGRAFIA ==========
async function exibirPergunta(index) {
    const questionContainer = document.getElementById('step-questions');
    const questionText = document.getElementById('question-text');
    const optionsContainer = document.getElementById('options-container');
    
    if (index >= perguntasDaClasse.length) {
        finalizarPersonagem();
        return;
    }
    
    const pergunta = perguntasDaClasse[index];
    
    // Atualizar progresso
    const progress = ((index) / perguntasDaClasse.length) * 100;
    document.getElementById('progress-fill').style.width = `${progress}%`;
    
    // Texto datilografado
    await typeWriter(questionText, pergunta.texto, 25);
    
    // Criar botões de opção
    optionsContainer.innerHTML = '';
    pergunta.opcoes.forEach((opcao, idx) => {
        const btn = document.createElement('button');
        btn.className = 'option-btn';
        btn.textContent = opcao.texto;
        btn.onclick = async () => {
            // Animação de clique
            btn.style.transform = 'scale(0.95)';
            setTimeout(() => btn.style.transform = '', 150);
            
            // Registrar escolha
            estadoCriacao.respostas.push({
                pergunta: pergunta.texto,
                escolha: opcao.texto,
                efeito: opcao.efeito || null,
                habilidade: opcao.habilidade || null
            });
            
            // Aplicar efeitos
            if (opcao.efeito) {
                if (opcao.efeito.hp) estadoCriacao.atributos.hp += opcao.efeito.hp;
                if (opcao.efeito.pe) estadoCriacao.atributos.pe += opcao.efeito.pe;
                if (opcao.efeito.ca) estadoCriacao.atributos.ca += opcao.efeito.ca;
            }
            
            if (opcao.habilidade && !estadoCriacao.habilidadesSelecionadas.includes(opcao.habilidade)) {
                estadoCriacao.habilidadesSelecionadas.push(opcao.habilidade);
            }
            
            // Animar opções antes de avançar
            await animateOptions(optionsContainer);
            
            // Avançar para próxima pergunta
            perguntaAtual++;
            exibirPergunta(perguntaAtual);
        };
        optionsContainer.appendChild(btn);
    });
    
    // Animação de entrada das opções
    const btns = optionsContainer.querySelectorAll('.option-btn');
    btns.forEach((btn, i) => {
        btn.style.opacity = '0';
        btn.style.transform = 'translateY(20px)';
        setTimeout(() => {
            btn.style.transition = 'all 0.3s ease';
            btn.style.opacity = '1';
            btn.style.transform = 'translateY(0)';
        }, i * 100);
    });
}

    // ========== FINALIZAR PERSONAGEM ==========
function finalizarPersonagem() {
    // Garantir 3 habilidades (completar se necessário)
    const habilidadesBase = habilidadesPorSubclasse[estadoCriacao.subclasse] || 
                           habilidadesPorSubclasse[estadoCriacao.classe] || [];
    
    const todasHabilidades = [...new Set([...estadoCriacao.habilidadesSelecionadas, ...habilidadesBase.slice(0, 3)])];
    const habilidadesFinais = todasHabilidades.slice(0, 3);
    
    // Criar objeto do personagem
    const personagem = new Personagem(
        estadoCriacao.nome,
        estadoCriacao.classe,
        estadoCriacao.subclasse,
        estadoCriacao.respostas,
        estadoCriacao.atributos,
        habilidadesFinais
    );
    
    // Salvar no histórico
    const historico = new HistoricoPersonagens();
    historico.adicionar(personagem);
    
    // Redirecionar para página de personagens salvos
    window.location.href = 'personagens-salvos.html';
}

    // ========== GERENCIADOR DE FLUXO ==========
document.addEventListener('DOMContentLoaded', () => {
    const steps = document.querySelectorAll('.creation-step');
    let currentStep = 0;
    
    function showStep(stepIndex) {
        steps.forEach((step, i) => {
            step.classList.toggle('active', i === stepIndex);
        });
    }
    
        // ========== FUNÇÃO PARA CRIAR OPÇÕES DE SUBCLASSE DINAMICAMENTE ==========
    function mostrarSubclasses(classe) {
        const subclassTitle = document.getElementById('subclass-title');
        const subclassOptions = document.getElementById('subclass-options');
        
        if (classe === 'barbaro') {
            subclassTitle.textContent = 'Bárbaro não possui especializações. Confirme para continuar:';
            subclassOptions.innerHTML = `
                <div class="subclass-card" data-subclass="Barbaro">
                    <h3> Bárbaro</h3>
                    <p>Força bruta e resistência incomparável. Seu corpo é sua arma mais poderosa.</p>
                </div>
            `;
        } else if (classe === 'cacador') {
            subclassTitle.textContent = 'Escolha sua especialização de Caçador:';
            subclassOptions.innerHTML = `
                <div class="subclass-card" data-subclass="Arqueiro">
                    <h3> Arqueiro</h3>
                    <p>Precisão e agilidade para disparos certeiros à longa distância.</p>
                </div>
                <div class="subclass-card" data-subclass="Pistoleiro">
                    <h3> Pistoleiro</h3>
                    <p>Armas de fogo e reflexos rápidos para confrontos intensos.</p>
                </div>
            `;
        } else if (classe === 'mago') {
            subclassTitle.textContent = 'Escolha sua escola de magia:';
            subclassOptions.innerHTML = `
                <div class="subclass-card" data-subclass="MagoFogo">
                    <h3> Mago de Fogo</h3>
                    <p>Domine chamas destruidoras que queimam tudo em seu caminho.</p>
                </div>
                <div class="subclass-card" data-subclass="MagoGelo">
                    <h3> Mago de Gelo</h3>
                    <p>Crie barreiras congelantes e paralise seus inimigos.</p>
                </div>
                <div class="subclass-card" data-subclass="Necromante">
                    <h3> Necromante</h3>
                    <p>Controle os mortos e manipule a própria morte.</p>
                </div>
            `;
        }
        
        // Adicionar evento de clique para cada subclasse
        document.querySelectorAll('.subclass-card').forEach(sub => {
            sub.addEventListener('click', () => {
                document.querySelectorAll('.subclass-card').forEach(s => s.classList.remove('selected'));
                sub.classList.add('selected');
                estadoCriacao.subclasse = sub.getAttribute('data-subclass');
                
                // Avançar para step de nome
                currentStep = 2;
                showStep(currentStep);
            });
        });
    }
    
        // ========== SELEÇÃO DE CLASSE ==========
    document.querySelectorAll('.class-card').forEach(card => {
        card.addEventListener('click', () => {
            // Remove seleção anterior
            document.querySelectorAll('.class-card').forEach(c => c.classList.remove('selected'));
            card.classList.add('selected');
            
            // Guarda a classe escolhida
            estadoCriacao.classe = card.getAttribute('data-class');
            
            // Mostra as subclasses DINAMICAMENTE baseado na classe escolhida
            mostrarSubclasses(estadoCriacao.classe);
            
            // Avança para o step de subclasse
            currentStep = 1;
            showStep(currentStep);
        });
    });
    
        // ========== BOTÕES VOLTAR ==========
    document.getElementById('back-to-class')?.addEventListener('click', () => {
        currentStep = 0;
        showStep(currentStep);
    });
    
    document.getElementById('back-to-subclass')?.addEventListener('click', () => {
        currentStep = 1;
        showStep(currentStep);
    });
    
    document.getElementById('back-to-name')?.addEventListener('click', () => {
        currentStep = 2;
        showStep(currentStep);
    });
    
        // ========== CONFIRMAÇÃO DE NOME ==========
    document.getElementById('confirm-name')?.addEventListener('click', () => {
        const nome = document.getElementById('player-name').value.trim();
        if (!nome) {
            alert('Dê um nome ao seu personagem!');
            return;
        }
        estadoCriacao.nome = nome;
        
        // Carregar perguntas baseadas na classe/subclasse
        perguntasDaClasse = carregarPerguntasParaClasse(estadoCriacao.classe, estadoCriacao.subclasse);
        perguntaAtual = 0;
        
        // Resetar atributos base
        estadoCriacao.atributos = { hp: 100, pe: 20, ca: 10 };
        estadoCriacao.habilidadesSelecionadas = [];
        estadoCriacao.respostas = [];
        
        // Ir para step de perguntas
        currentStep = 3;
        showStep(currentStep);
        
        // Iniciar perguntas
        exibirPergunta(0);
    });
    
    // Iniciar no passo 0 (classe)
    showStep(0);
});
/* ======= FIM CRIAÇÃO DO PERSONAGEM ======= */



/* ======= PERSONAGENS SALVOS ======= */
    // ========== EXIBIR PERSONAGENS SALVOS COM IMAGEM ==========
function exibirPersonagensSalvos() {
    const container = document.getElementById('lista-personagens');
    if (!container) return;
    
    const historico = new HistoricoPersonagens();
    const personagens = historico.obterUltimos();
    
    if (personagens.length === 0) {
        container.innerHTML = '<div class="empty-message">Nenhum personagem criado ainda. Crie o primeiro!</div>';
        return;
    }
    
    // Exibir do mais antigo para o mais recente
    const personagensOrdenados = [...personagens].reverse();
    
    container.innerHTML = personagensOrdenados.map(p => {
        // Define a imagem baseada na classe do personagem
        let imagemPersonagem = getImagemPorClasse(p.classe, p.subclasse);
        
        return `
            <div class="saved-card">
                <div class="character-avatar">
                    <img src="${imagemPersonagem}" alt="${escapeHtml(p.nome)}" onerror="this.src='imagens/padrao.png'">
                </div>
                <div class="character-info">
                    <h3> ${escapeHtml(p.nome)}</h3>
                    <div class="class-badge">${escapeHtml(p.classe)} ${p.subclasse ? `› ${escapeHtml(p.subclasse)}` : ''}</div>
                    
                    <div class="stats-vertical">
                        <div class="stat-row">
                            <span class="stat-icon">❤️</span>
                            <span class="stat-label">HP</span>
                            <span class="stat-value">${p.atributos?.hp || 100}</span>
                        </div>
                        <div class="stat-row">
                            <span class="stat-icon">✨</span>
                            <span class="stat-label">PE</span>
                            <span class="stat-value">${p.atributos?.pe || 20}</span>
                        </div>
                        <div class="stat-row">
                            <span class="stat-icon">🛡️</span>
                            <span class="stat-label">CA</span>
                            <span class="stat-value">${p.atributos?.ca || 10}</span>
                        </div>
                    </div>
                    
                    <div class="abilities-list">
                        <h4> Habilidades</h4>
                        <ul>
                            ${(p.habilidades || []).map(h => `<li>${escapeHtml(h)}</li>`).join('')}
                        </ul>
                    </div>
                    
                    <div class="date">
                        Criado em: ${new Date(p.dataCriacao).toLocaleString()}
                    </div>
                </div>
            </div>
        `;
    }).join('');
}

    // ========== FUNÇÃO PARA RETORNAR A IMAGEM CORRETA ==========
function getImagemPorClasse(classe, subclasse) {
    // Define o caminho base da pasta de imagens
    const basePath = 'imagens-de-fundo/';
    
    // Mapeamento de classes para imagens específicas
    const imagens = {
        // Bárbaro
        barbaro: `${basePath}barbaro-masc-rosto.png`,
        
        // Caçadores
        cacador_Arqueiro: `${basePath}cacador-arqueiro-fem-rosto.png`,
        cacador_Pistoleiro: `${basePath}cacador-pist-fem-rosto.png`,
        
        // Magos
        mago_MagoFogo: `${basePath}mago-fogo-masc-rosto.png`,
        mago_MagoGelo: `${basePath}mago-gelo-masc-rosto.png`,
        mago_Necromante: `${basePath}mago-necrom-fem-rosto.png`,
        
        // Fallback padrão
        padrao: `${basePath}barbaro-masc-rosto.png`
    };
    
    // Verifica se tem subclasse específica
    if (subclasse) {
        const chave = `${classe}_${subclasse}`;
        if (imagens[chave]) return imagens[chave];
    }
    
    // Se não, usa imagem da classe principal
    if (imagens[classe]) return imagens[classe];
    
    // Fallback
    return imagens.padrao;
}

// Função auxiliar para evitar XSS
function escapeHtml(texto) {
    if (!texto) return '';
    return texto
        .replace(/&/g, '&amp;')
        .replace(/</g, '&lt;')
        .replace(/>/g, '&gt;')
        .replace(/"/g, '&quot;')
        .replace(/'/g, '&#39;');
}

// Executar ao carregar a página de personagens salvos
if (document.getElementById('lista-personagens')) {
    document.addEventListener('DOMContentLoaded', exibirPersonagensSalvos);
}
/* ======= FIM PERSONAGENS SALVOS ======= */