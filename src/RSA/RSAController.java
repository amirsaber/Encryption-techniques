package RSA;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class RSAController {
    public TextField messageTextField;
    public Button encryptButton;
    public Button decryptButton;
    public Label headerLabel;
    public Label encryptedLabel;

    private RSACipher rsaCipher;

    public RSAController() {
        rsaCipher = new RSACipher();
    }

    @FXML
    private void initialize() {
        encryptButton.setOnMouseClicked(mouseEvent -> handleEncryptButton());
        decryptButton.setOnMouseClicked(mouseEvent -> handleDecryptedButton());
    }

    private void handleEncryptButton() {
        String message = messageTextField.getText();
        String encryptedMessage;
        encryptedMessage = rsaCipher.encrypt(message);
        showEncryptedMessage(encryptedMessage);
    }

    private void handleDecryptedButton() {
        String encryptedMessage = encryptedLabel.getText();
        String decryptedMessage;
        decryptedMessage = rsaCipher.decrypt(encryptedMessage);
        showDecryptedMessage(decryptedMessage);
    }

    private void showEncryptedMessage(String encryptedMessage) {
        headerLabel.setVisible(true);
        encryptedLabel.setText(encryptedMessage);
        messageTextField.clear();
    }

    private void showDecryptedMessage(String decryptedMessage) {
        headerLabel.setVisible(false);
        messageTextField.setText(decryptedMessage);
        encryptedLabel.setText("");
    }

}
