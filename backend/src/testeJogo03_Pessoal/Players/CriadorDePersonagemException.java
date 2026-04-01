package testeJogo03_Pessoal.Players;

/**
 * Exceção lançada durante a criação do personagem quando a entrada do usuário
 * não atende ao esperado ou a classe/arquetipo não pode ser definido.
 */
public class CriadorDePersonagemException extends Exception {
  public CriadorDePersonagemException(String message) {
    super(message);
  }

  public CriadorDePersonagemException(String message, Throwable cause) {
    super(message, cause);
  }
}
