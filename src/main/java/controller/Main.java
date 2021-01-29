package controller;

import Exceptions.Errores;
import Repository.Datos;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        File file = new File("C:\\Users\\zsc27\\IdeaProjects\\RegistroMonedas\\src\\main\\java\\fxml\\sample.fxml");
        FXMLLoader loader = new FXMLLoader(file.toURI().toURL());
        Parent root = loader.load();
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 340, 400));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
        Datos datos = new Datos();
        Usuario usuario = new Usuario("pepe", "1234");
        Registro r = new Registro(usuario,2,1,2,3,4,1,2,3,3);
        Registro r1 = new Registro(usuario,2,1,5,3,7,1,4,2,3);
        try {
            datos.addRegistro(r);
            datos.addRegistro(r1);
        }catch (Errores e){
            e.getMessage();
        }
        System.out.println(r.getTotal());
    }
}
