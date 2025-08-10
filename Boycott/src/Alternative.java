package boycott;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class Alternative extends JFrame implements ActionListener {
 private JButton backbtn;
    public Alternative(ArrayList<String> list) {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1400, 750);

        // Create a panel to hold components
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0,0,1400,750);
        panel.setBackground(Color.white);
        
        // Create a label for text
        JLabel textLabel = new JLabel("You Should Try This");
        textLabel.setBounds(500,0,1400,100);
        textLabel.setOpaque(false);
        textLabel.setFont(new Font("MV BOLI", Font.BOLD, 50));
        panel.add(textLabel);
        
        //textarea
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false); // Make the text area read-only
        textArea.setOpaque(false);
        textArea.setBounds(150,150,700,400);
        int padding = 50; 
        textArea.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(Color.BLUE, 5),
                new EmptyBorder(padding, padding, padding, padding)
        ));
        textArea.setFont(new Font("MONOSPACED",Font.ITALIC,20));
        // Convert ArrayList to String
        StringBuilder sb = new StringBuilder();
        for (String item : list) {
            sb.append(item).append("\n");
        }
        String text = sb.toString();

        // Set text in JTextArea
        textArea.setText(text);
        panel.add(textArea);
        
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("Point.jpg"));
        Image scaledImage = imageIcon.getImage().getScaledInstance(500, 600, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JLabel image=new JLabel(scaledIcon);
        image.setBounds(830,50,560,570);
        panel.add(image);
        
        backbtn=new JButton("Back");
        backbtn.setBounds(1220,630,80,50);
        backbtn.setBackground(Color.WHITE);
        backbtn.setForeground (Color.black);
        backbtn.setFocusPainted(false);
        backbtn.addActionListener(this);
        panel.add(backbtn);
        // Add panel to the frame
        add(panel);

        // Center the frame on the screen
        setLocationRelativeTo(null);
        setVisible(true);
    }


//      public static void main(String[] args) {
//        // Invoking the method
//         ArrayList<String> myList = new ArrayList<>();
//
//        // Adding elements to the ArrayList
//        myList.add("Apple");
//        myList.add("Banana");
//        myList.add("Orange");
//        new Alternatives(myList);
//    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
     try {                 
         new Search().setVisible(true);
     } catch (IOException ex) {
         Logger.getLogger(Alternative.class.getName()).log(Level.SEVERE, null, ex);
     }
    }
}


