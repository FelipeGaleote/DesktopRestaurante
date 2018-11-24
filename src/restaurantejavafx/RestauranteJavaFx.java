/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurantejavafx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author IFSP
 */
public class RestauranteJavaFx extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
            Pane tela = loader.load();
            StackPane root = new StackPane();
            root.getChildren().add(tela);
            Scene scene = new Scene(root);     
            primaryStage.setTitle("SincPedidos");
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.show();
            LoginController controller = loader.getController();
            controller.setStage(primaryStage);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
     
}
