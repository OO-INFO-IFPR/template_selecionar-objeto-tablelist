package com.example.controllers;

import com.example.model.Item;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class JanelaController {

    // Referências para os elementos da View
    @FXML
    private TableView<Item> tabelaOrigem;
    @FXML
    private TableColumn<Item, String> colunaOrigem;

    @FXML
    private TableView<Item> tabelaDestino;
    @FXML
    private TableColumn<Item, String> colunaDestino;

    // Listas observáveis para as tabelas
    private ObservableList<Item> listaOrigem;
    private ObservableList<Item> listaDestino;

    @FXML
    public void initialize() {
        // Inicializar as listas
        listaOrigem = FXCollections.observableArrayList(
                new Item("Item 1"),
                new Item("Item 2"),
                new Item("Item 3"));
        listaDestino = FXCollections.observableArrayList();

        // Configurar as colunas
        colunaOrigem.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colunaDestino.setCellValueFactory(new PropertyValueFactory<>("nome"));

        // Associar as listas às tabelas
        tabelaOrigem.setItems(listaOrigem);
        tabelaDestino.setItems(listaDestino);
    }

    @FXML
    private void moverParaDestino() {
        Item selecionado = tabelaOrigem.getSelectionModel().getSelectedItem();
        if (selecionado != null) {
            listaOrigem.remove(selecionado);
            listaDestino.add(selecionado);
        }
    }

    @FXML
    private void moverParaOrigem() {
        Item selecionado = tabelaDestino.getSelectionModel().getSelectedItem();
        if (selecionado != null) {
            listaDestino.remove(selecionado);
            listaOrigem.add(selecionado);
        }
    }
}