package model;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
public class ModeloTabela extends AbstractTableModel{
	private static final String[] colunas = {
			"Nome", "Ano lan\u00E7amento", "Genero", "Desenvolvedora", "Review", "Nota"
		};
	private ArrayList<Jogos> jogos;
	
	@Override
	public int getRowCount() {
		return jogos.size();
	}

	@Override
	public int getColumnCount() {
		return colunas.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		Jogos jogo = jogos.get(rowIndex);
		if (columnIndex == 0) {
			return jogo.getNome();
		} else if (columnIndex == 1) {
			return jogo.getAno_lancamento();
		} else if (columnIndex == 2) {
			return jogo.getGenero();
		} else if (columnIndex == 3) {
			return jogo.getDesenvolvedora();
		} else if (columnIndex == 4) {
			return jogo.getReview();
		} else if (columnIndex == 5) {
			return jogo.getNota();
		} else {
			return null;
		}
	}

	public ModeloTabela(ArrayList<Jogos> jogos) {
		super();
		this.jogos = jogos;
	}
@Override
public String getColumnName(int column) {
	return colunas[column];
}
}
