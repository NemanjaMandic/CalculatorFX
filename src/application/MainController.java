/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 *
 * @author nemus
 */
public class MainController implements Initializable {
    
    @FXML
    private Label result;
    private long num1 = 0;
    private String operator = "";
    private boolean start = true;
    private Model model = new Model();
    
    @FXML
    private void processNumbers(ActionEvent event) {
       if(start){
           result.setText("");
           start = false;
       }
       String value = ((Button)event.getSource()).getText();
       result.setText(result.getText() + value);
    }
    @FXML
    public void processOperators(ActionEvent event){
        String value = ((Button)event.getSource()).getText();
        if(!value.equals("=")){
            if(!operator.isEmpty())
                return;
            operator = value;
            num1 = Long.parseLong(result.getText());
            result.setText("");
        }else{
              if(operator.isEmpty())
                  return;
                          long num2 = Long.parseLong(result.getText());
                         float output = model.calculate(num1, num2, operator);
                         result.setText(String.valueOf(output));
                         operator = "";
                         start = true;
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
