package br.df.dmbarros.servicos;

import java.util.Calendar;

import br.df.dmbarros.entidades.Filme;
import br.df.dmbarros.entidades.NotaAluguel;
import br.df.dmbarros.entidades.TipoAluguel;
import br.df.dmbarros.utils.DateUtils;

public class AluguelService {
	
//	public NotaAluguel alugar(Filme filme, String tipo) {
	public NotaAluguel alugar(Filme filme, TipoAluguel tipo) {
		if(filme.getEstoque() == 0)
			throw new RuntimeException("Filme sem estoque.");
		
		NotaAluguel nota = new NotaAluguel();
		switch (tipo) {
			case COMUM: 
				nota.setPreco(filme.getAluguel());
				nota.setDataEntrega(DateUtils.obterDataDiferencaDias(1));
				nota.setPontuacao(1);
			break;
			case EXTENDIDO: 
				nota.setPreco(filme.getAluguel() * 2);
				nota.setDataEntrega(DateUtils.obterDataDiferencaDias(3));
				nota.setPontuacao(2);
			break;
			case SEMANAL: 
				nota.setPreco(filme.getAluguel() * 3);
				nota.setDataEntrega(DateUtils.obterDataDiferencaDias(7));
				nota.setPontuacao(3);
			break;
		}
//		if("extendido".equals(tipo)) {
//			nota.setPreco(filme.getAluguel() * 2);
//			nota.setDataEntrega(DateUtils.obterDataDiferencaDias(3));
//			nota.setPontuacao(2);
//		} else if("semanal".equals(tipo)) {
//			nota.setPreco(filme.getAluguel() * 3);
//			nota.setDataEntrega(DateUtils.obterDataDiferencaDias(7));
//			nota.setPontuacao(3);
//		} else {
//			nota.setPreco(filme.getAluguel());
//			nota.setDataEntrega(DateUtils.obterDataDiferencaDias(1));
//			nota.setPontuacao(1);
//		}
//		Calendar cal = Calendar.getInstance();
//		cal.add(Calendar.DAY_OF_MONTH, 1);
//		nota.setDataEntrega(cal.getTime());
//		nota.setDataEntrega(DateUtils.obterDataDiferencaDias(1));
		filme.setEstoque(filme.getEstoque() - 1);
		return nota;
	}

}
