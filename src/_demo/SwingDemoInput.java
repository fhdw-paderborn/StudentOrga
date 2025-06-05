package _demo;

import javax.swing.*;

public class SwingDemoInput {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Name Alert");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        JTextField firstName = new JTextField(8);
        JTextField lastName = new JTextField(8);
        JButton button = new JButton("Anzeigen");

        panel.add(new JLabel("Vorname:"));
        panel.add(firstName);
        panel.add(new JLabel("Nachname:"));     
        panel.add(lastName);
        panel.add(button);

        button.addActionListener(e -> JOptionPane.showMessageDialog(frame,
                "Vorname: " + firstName.getText() + "\nNachname: " + lastName.getText(),
                "Eingaben", JOptionPane.INFORMATION_MESSAGE));

        frame.add(panel);
        frame.pack();
        
        frame.setLocationRelativeTo(null); // Fenster zentrieren

        frame.setVisible(true);
    }
}
