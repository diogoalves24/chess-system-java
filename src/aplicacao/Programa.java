package aplicacao;

import java.util.Scanner;

import xadrez.PartidaXadrez;
import xadrez.PecaXadrez;
import xadrez.PosicaoXadrez;

public class Programa {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PartidaXadrez partidaXadrez = new PartidaXadrez();
		
		while(true) {
			UI.printTabuleiro(partidaXadrez.getPecas());
			System.out.println();
			System.out.println("Posicao Inicial: ");
			PosicaoXadrez pinicial = UI.lerPosicaoXadrez(sc);
			
			System.out.println();
			System.out.println("Posicao Final: ");
			PosicaoXadrez pfinal = UI.lerPosicaoXadrez(sc);
			
			PecaXadrez pecaCapturada = partidaXadrez.fazerMovimentoXadrez(pinicial, pfinal);
		}	
	}
}
