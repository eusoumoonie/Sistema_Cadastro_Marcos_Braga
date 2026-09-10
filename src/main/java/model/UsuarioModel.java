/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import entity.CadastroEntity;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author u11249767105
 */
public class UsuarioModel extends AbstractTableModel {

    private List<CadastroEntity> lista;

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        CadastroEntity user = lista.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> user.getId();
            case 1 -> user.getNome();
            case 2 -> user.getEmail();
            case 3 -> user.getFuncao();
            case 4 -> user.isAtivo() ? "Ativo" : "Inativo";
            default -> "";
        };
    }

    @Override
    public String getColumnName(int column) {
        return switch (column) {
            case 0 -> "Cód.";
            case 1 -> "Nome";
            case 2 -> "Email";
            case 3 -> "Função";
            case 4 -> "Status";
            default -> "";
        };
    }

    /**
     * @return the lista
     */
    public List<CadastroEntity> getLista() {
        return lista;
    }

    /**
     * @param lista the lista to set
     */
    public void setLista(List<CadastroEntity> lista) {
        this.lista = lista;
        fireTableDataChanged();
    }
}
