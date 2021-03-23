package xadrez;

import jogo_tabuleiro.ExcecaoTabuleiro;

public class ExcecaoXadrez extends ExcecaoTabuleiro{

	private static final long serialVersionUID = 1L;

	public ExcecaoXadrez(String mensagem) {
		super(mensagem);
	}
}
