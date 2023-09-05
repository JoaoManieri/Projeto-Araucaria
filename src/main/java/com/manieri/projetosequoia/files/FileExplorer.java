package com.manieri.projetosequoia.files;

import javafx.application.Application;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class FileExplorer extends Application {

    private String hint;
    private final FileType type ;

    FileExplorer(String hint, FileType type){
        this.hint = hint;
        this.type = type;
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        String filePath = null;

        // Criar um seletor de arquivo
        FileChooser fileChooser = new FileChooser();

        // Definir o título da janela de diálogo
        fileChooser.setTitle("Salvar Orcamento");

        // Definir o filtro de extensão do arquivo (opcional)
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(hint, type.getExtension());
        fileChooser.getExtensionFilters().add(extFilter);

        // Exibir o diálogo de seleção de arquivo
        java.io.File selectedFile = fileChooser.showSaveDialog(primaryStage);

        if (selectedFile != null) {
            // Obter o caminho selecionado pelo usuário
            filePath = selectedFile.getAbsolutePath();
            System.out.println("Caminho selecionado: " + filePath);

            // Use o caminho do arquivo para salvar o PDF
            // ...
        } else {
            System.out.println("Seleção de arquivo cancelada pelo usuário");
        }


    }
}
