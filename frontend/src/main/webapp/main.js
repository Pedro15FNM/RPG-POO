document.addEventListener("DOMContentLoaded", () => {
  const cards = Array.from(document.querySelectorAll(".class-card"));
  const hint = document.querySelector(".class-hint");

  function resetClasses() {
    cards.forEach((card) => {
      card.classList.remove("active", "dimmed");
    });
    if (hint) {
      hint.textContent = "Passe o cursor sobre uma classe para ver seus detalhes e subclasses.";
    }
  }

  function setActive(activeCard) {
    cards.forEach((card) => {
      if (card === activeCard) {
        card.classList.add("active");
        card.classList.remove("dimmed");
      } else {
        card.classList.add("dimmed");
        card.classList.remove("active");
      }
    });

    if (!hint) return;

    const className = activeCard.getAttribute("data-class") || "";
    const messages = {
      cacador: "Caçadores dominam a distância e sobrevivência. Escolha sua especialização.",
      mago: "Magos controlam elementos e magias arcanas para mudar o rumo da batalha.",
      barbaro: "Bárbaros são força bruta e resistência, prontos para encarar qualquer desafio.",
    };

    hint.textContent = messages[className] || "Passe o cursor sobre uma classe para ver seus detalhes e subclasses.";
  }

  cards.forEach((card) => {
    card.addEventListener("mouseenter", () => setActive(card));
  });

  const container = document.querySelector(".character-selection");
  if (container) {
    container.addEventListener("mouseleave", resetClasses);
  }
});
