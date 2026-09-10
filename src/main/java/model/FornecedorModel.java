/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import entity.FornecedorEntity;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author u11249767105
 */
public class FornecedorModel extends AbstractTableModel {

    private List<FornecedorEntity> lista;

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        FornecedorEntity forn = lista.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> forn.getId();
            case 1 -> forn.getRazaoSocial();
            case 2 -> forn.getNomeFantasia();
            case 3 -> forn.getCnpj();
            case 4 -> forn.getTelefone();
            case 5 -> forn.getEmail();
            case 6 -> forn.getCidade();
            default -> "";
        };
    }

    @Override
    public String getColumnName(int column) {
        return switch (column) {
            case 0 -> "Cód.";
            case 1 -> "Razão Social";
            case 2 -> "Nome Fantasia";
            case 3 -> "CNPJ";
            case 4 -> "Telefone";
            case 5 -> "Email";
            case 6 -> "Cidade";
            default -> "";
        };
    }

    /**
     * @return the lista
     */
    public List<FornecedorEntity> getLista() {
        return lista;
    }

    /**
     * @param lista the lista to set
     */
    public void setLista(List<FornecedorEntity> lista) {
        this.lista = lista;
        fireTableDataChanged();
    }
}