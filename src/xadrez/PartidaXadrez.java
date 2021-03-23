package xadrez;

import jogo_tabuleiro.Peca;
import jogo_tabuleiro.Posicao;
import jogo_tabuleiro.Tabuleiro;
import xadrez.pecas.Rei;
import xadrez.pecas.Torre;

public class PartidaXadrez {
	
	private Tabuleiro tabuleiro;
	
	public PartidaXadrez() {
		tabuleiro = new Tabuleiro(8, 8);
		setupInicial();
	}
	
	public PecaXadrez[][] getPecas(){
		PecaXadrez[][] mat = new PecaXadrez[tabuleiro.getLinhas()][tabuleiro.getColunas()];
		for(int i=0; i<tabuleiro.getLinhas(); i++) {
			for(int j=0; j<tabuleiro.getColunas(); j++) {
				mat[i][j] = (PecaXadrez) tabuleiro.peca(i, j);
			}
		}
		return mat;
	}
	
	public PecaXadrez fazerMovimentoXadrez(PosicaoXadrez posicaoInicial, PosicaoXadrez posicaoFinal) {
		Posicao pinicial = posicaoInicial.toPosicao();
		Posicao pfinal = posicaoFinal.toPosicao();
		validarPosicaoInicial(pinicial);
		Peca pecaCapturada = fazerMovimento(pinicial, pfinal);
		return (PecaXadrez)pecaCapturada;
	}
	
	private Peca fazerMovimento(Posicao posicaoInicial, Posicao posicaoFinal) {
		Peca p = tabuleiro.removerPeca(posicaoInicial);
		Peca pecaCapturada = tabuleiro.removerPeca(posicaoFinal);
		tabuleiro.posicionarPeca(p, posicaoFinal);
		return pecaCapturada;
	}
	
	private void validarPosicaoInicial(Posicao posicao) {
		if(!tabuleiro.temPeca(posicao)) {
			throw new ExcecaoXadrez("Não existe peça na posição inicial");
		}
	}
	
	private void posicionarPecaNova(char coluna, int linha, PecaXadrez peca) {
		tabuleiro.posicionarPeca(peca, new PosicaoXadrez(coluna, linha).toPosicao());
	}
	
	private void setupInicial() {
		posicionarPecaNova('c', 1, new Torre(tabuleiro, Cor.BRANCO));
		posicionarPecaNova('c', 2, new Torre(tabuleiro, Cor.BRANCO));
		posicionarPecaNova('d', 2, new Torre(tabuleiro, Cor.BRANCO));
		posicionarPecaNova('e', 2, new Torre(tabuleiro, Cor.BRANCO));
		posicionarPecaNova('e', 1, new Torre(tabuleiro, Cor.BRANCO));
		posicionarPecaNova('d', 1, new Rei(tabuleiro, Cor.BRANCO));

		posicionarPecaNova('c', 7, new Torre(tabuleiro, Cor.PRETO));
		posicionarPecaNova('c', 8, new Torre(tabuleiro, Cor.PRETO));
		posicionarPecaNova('d', 7, new Torre(tabuleiro, Cor.PRETO));
		posicionarPecaNova('e', 7, new Torre(tabuleiro, Cor.PRETO));
		posicionarPecaNova('e', 8, new Torre(tabuleiro, Cor.PRETO));
		posicionarPecaNova('d', 8, new Rei(tabuleiro, Cor.PRETO));
	}
}
