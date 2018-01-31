package GameApplet;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GamePanel extends GameApplet implements ActionListener {
    private static final long serialVersionUID = 1L;
    
    int randomNumber = new Random().nextInt(10) + 1;
    int numPalpites = 0;
    
    JTextField textField = new JTextField(5);
    JButton button = new JButton("Adivinhe");
    JLabel label = new JLabel(numPalpites + " palpites");
    
    GamePanel() {
        setBackground(Color.white);
        add(textField);
        add(button);
        add(label);
        button.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e) {
        String textFieldText = textField.getText();
        
        if(Integer.parseInt(textFieldText) == randomNumber)
        {
            button.setEnabled(false);
            textField.setText(textField.getText() + " Sim !");
            textField.setEnabled(false);
        } else {
            textField.setText("");
            textField.requestFocus();
        }
        
        numPalpites++;
        String palavraPalpite = (numPalpites == 1) ? "palpite" : "palpites";
        label.setText(numPalpites + palavraPalpite);
    }
}
