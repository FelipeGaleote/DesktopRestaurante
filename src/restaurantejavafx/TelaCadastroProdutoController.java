/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurantejavafx;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import restaurantejavafx.models.Produto;
import restaurantejavafx.repository.ProdutoRepository;

/**
 * FXML Controller class
 *
 * @author Mokoo
 */
public class TelaCadastroProdutoController implements Initializable {
    
    @FXML
    TextField nomeInput;
    @FXML
    TextField precoInput;
    @FXML
    TextField tipoInput;
    @FXML
    TextField linkInput;
    @FXML
    TextArea descricaoInput;
    
    private ProdutoRepository repository;
    private Stage stage;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        repository = new ProdutoRepository();
    }    

    void setStage(Stage stage) {
        this.stage = stage;
    }
    
    @FXML
    void criar(){
        Produto produto = new Produto();
        produto.setNome(nomeInput.getText());
        double valor = precoInput.getText().isEmpty()? 0 : Double.valueOf(precoInput.getText());
        produto.setValor(valor);
        produto.setTipo(tipoInput.getText());
        produto.setUrlFoto(linkInput.getText());
        produto.setDescricao(descricaoInput.getText());
        repository.createProduct(produto, new ProdutoRepository.CreateProductListener (){
            @Override
            public void onProductCreated(long id) {
                Platform.runLater(() -> {
                    ButtonType ok = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
                    Alert alert = new Alert(AlertType.NONE, "Produto cadastrado com sucesso! Id do produto: " + id, ok);
                    alert.setTitle("Sucesso!");
                    Optional<ButtonType> result = alert.showAndWait();
                    stage.close();
                });
            }

            @Override
            public void onFailed() {
                Platform.runLater(() -> {
                    ButtonType ok = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
                    Alert alert = new Alert(AlertType.NONE, "Falha ao cadastrar o produto", ok);
                    alert.setTitle("Falha!");
                    Optional<ButtonType> result = alert.showAndWait();
                    stage.close();
                });
            }
        });
    }
    
}
