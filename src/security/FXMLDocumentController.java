/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package security;

import DES.NewJFrame;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.UnaryOperator;
import java.util.regex.Pattern;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.stage.Stage;

/**
 *
 * @author amir
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private TextArea MessageTextArea;
    @FXML
    private TextArea ResultTextArea;
    @FXML
    private TextField key;

    PlayfairCipher playfair = new PlayfairCipher();
    CaserCipher Caser = new CaserCipher();
    VigenereCipher vigener = new VigenereCipher();
    

    @FXML
    private void PFEncryption() {
        if (MessageTextArea.getText().isEmpty() || key.getText().isEmpty()) {
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setHeaderText(null);
            a.setContentText("Please enter message and key");
            a.show();
        } else {
            playfair.setKey(key.getText().toLowerCase());

            playfair.KeyGen();
            String s = playfair.encryptMessage(MessageTextArea.getText().toLowerCase());

            ResultTextArea.setText(s.toUpperCase());
        }
    }

    @FXML
    private void PFDecryption() {
        if (MessageTextArea.getText().isEmpty() || key.getText().isEmpty()) {
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setHeaderText(null);
            a.setContentText("Please enter message and key");
            a.show();
        } else {
            playfair.setKey(key.getText().toLowerCase());

            playfair.KeyGen();
            String s = playfair.decryptMessage(MessageTextArea.getText().toLowerCase());

            ResultTextArea.setText(s.toUpperCase());
        }
    }

    @FXML
    private void CSEncrypt() {
        if (MessageTextArea.getText().isEmpty() || key.getText().isEmpty()) {
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setHeaderText(null);
            a.setContentText("Please enter message and key");
            a.show();
        } else {
            String message = MessageTextArea.getText().toLowerCase();

            String EncryptedMessage = Caser.cipherEncrypt(message, Integer.parseInt(key.getText()));

            ResultTextArea.setText(EncryptedMessage.toUpperCase());
        }
    }

    @FXML
    private void CSDecrypt() {

        if (MessageTextArea.getText().isEmpty() || key.getText().isEmpty()) {
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setHeaderText(null);
            a.setContentText("Please enter message and key");
            a.show();
        } else {
            ResultTextArea.setText(Caser.cipherDecypt(MessageTextArea.getText().toLowerCase(), Integer.parseInt(key.getText())).toUpperCase());
        }
    }

    @FXML
    private void VCEncrypt() {
        if (MessageTextArea.getText().isEmpty() || key.getText().isEmpty()) {
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setHeaderText(null);
            a.setContentText("Please enter message and key");
            a.show();
        } else {
            String message = MessageTextArea.getText().toUpperCase();

            String EncryptedMessage = VigenereCipher.encrypt(message, key.getText());

            ResultTextArea.setText(EncryptedMessage.toUpperCase());
        }
    }

    @FXML
    private void VCDecrypt() {

        if (MessageTextArea.getText().isEmpty() || key.getText().isEmpty()) {
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setHeaderText(null);
            a.setContentText("Please enter message and key");
            a.show();
        } else {
            String message = MessageTextArea.getText().toUpperCase();

            String EncryptedMessage = VigenereCipher.decrypt(message, key.getText());

            ResultTextArea.setText(EncryptedMessage.toUpperCase());
        }
    }
    @FXML
    private void OpenFestiel() throws IOException {
        Stage primaryStage = new Stage();
   Parent root = FXMLLoader.load(getClass().getResource("/FeistelCipher/FeistelFXML.fxml"));
        primaryStage.setTitle("Feistel Cipher");
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.show();
    }
    @FXML
    private void OpenRC4() throws IOException {
        Stage primaryStage = new Stage();
   Parent root = FXMLLoader.load(getClass().getResource("/Rc4/RC4FXML.fxml"));
        primaryStage.setTitle("RC4 Cipher");
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.show();
    }
    @FXML
    private void OpenRSA() throws IOException {
        Stage primaryStage = new Stage();
   Parent root = FXMLLoader.load(getClass().getResource("/RSA/RSAFXML.fxml"));
        primaryStage.setTitle("RSA Cipher");
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.show();
    }
    @FXML
    private void OpenDes() throws IOException {
        //Stage primaryStage = new Stage();
   //Parent root = FXMLLoader.load(getClass().getResource("/RSA/RSAFXML.fxml"));
     //   primaryStage.setTitle("RSA Cipher");
       // primaryStage.setScene(new Scene(root));
        //p/rimaryStage.setResizable(false);
        //primaryStage.show();
        NewJFrame f = new NewJFrame();
        String[] args = null;
        f.main(args);
    }

 

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Pattern pattern = Pattern.compile("[a-zA-Z]*");
        UnaryOperator<TextFormatter.Change> filter = c -> {
            if (pattern.matcher(c.getControlNewText()).matches()) {
                return c;
            } else {
                return null;
            }
        };
        TextFormatter<String> formatter = new TextFormatter<>(filter);
        MessageTextArea.setTextFormatter(formatter);

    }

}
