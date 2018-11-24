/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurantejavafx;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author IFSP
 */
public class TelaPrincipalController implements Initializable {

    @FXML
    TableView tabela;
    private Stage stage;
    
    @FXML
    Button CadProduto;
    private Stage oldStage;
    
    @FXML
    Button CadFunc;
    
    @FXML
    Button CadMesa;
    
    @FXML
    Button ExibeProd;
    /**
     * Initializes the controller class.
     */
    
    @FXML
    protected void CadProduto(ActionEvent event) throws IOException{

        FXMLLoader loader = new FXMLLoader(getClass().getResource("TelaCadastroProduto.fxml"));
        Stage stage = new Stage();
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setTitle("Cadastrar produto");
        stage.setScene(scene);
        stage.show();
        TelaCadastroProdutoController controller = loader.getController();
        controller.setStage(stage);
        Screen screen = Screen.getPrimary();
        javafx.geometry.Rectangle2D bounds = screen.getVisualBounds();    
    }
    
        @FXML
    protected void CadFunc(ActionEvent event) throws IOException{

        FXMLLoader loader = new FXMLLoader(getClass().getResource("TelaCadastroFuncionario.fxml"));
        Stage stage = new Stage();
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setTitle("Cadastrar funcionário");
        stage.setScene(scene);
        stage.show();
        Screen screen = Screen.getPrimary();
        javafx.geometry.Rectangle2D bounds = screen.getVisualBounds();
    
    }
    
    @FXML
    protected void ExibeProd(ActionEvent event) throws IOException{

        FXMLLoader loader = new FXMLLoader(getClass().getResource("TelaExibirProdutos.fxml"));
        Stage stage = new Stage();
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setTitle("Produtos");
        stage.setScene(scene);
        stage.show();
        Screen screen = Screen.getPrimary();
        javafx.geometry.Rectangle2D bounds = screen.getVisualBounds();
    
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    } 
    
    public void setStage(Stage stage){
        this.stage = stage;
        tabela.setMinHeight((stage.getHeight()/5) * 4);
        tabela.setMinWidth((stage.getWidth()/5) * 4);
        
    }
    
}

