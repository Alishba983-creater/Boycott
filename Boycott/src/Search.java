package boycott;

import java.io.IOException;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.JOptionPane.CANCEL_OPTION;
import static javax.swing.JOptionPane.OK_OPTION;

public class Search extends JFrame implements ActionListener{
    private JPanel currentPanel;
    private JButton b1,b2,b3,backbtn;
    private JTextField input1,input2,input3;
    ProductManager drinksManager,snackManager,detergentManager;
     Search() throws IOException{
        setSize(1400, 750); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("SEARCH");
        
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("B.jpg"));
        Image scaledImage = imageIcon.getImage().getScaledInstance(1300, 700, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JLabel image=new JLabel(scaledIcon);
        image.setBounds(0, 0, 1300, 700);
        
        backbtn=new JButton("Back");
        backbtn.setBounds(1060,640,80,50);
        backbtn.setBackground(Color.black);
        backbtn.setForeground (Color.white);
        backbtn.setFocusPainted(false);
        backbtn.addActionListener(this);
        
        JPanel panel1 = new JPanel();
        {
            panel1.setLayout(null);
            panel1.add(backbtn);
            panel1.add(image);
            
        }
        JPanel panel2 = new JPanel();
        {
            drinksManager = new ProductManager("C:\\Users\\Family\\Documents\\NetBeansProjects\\Boycott\\src\\boycott\\Israeli drinks.txt");     
            panel2.setLayout(null);
            JLabel text=new JLabel("Enter Drink: ");
            text.setBounds(300,220,500,200);
            text.setFont(new Font("MONOSPACED",Font.BOLD,24));
            input1=new JTextField();
            input1.setBounds(500,300,250,50);
            input1.setFont(new Font("MONOSPACED",Font.PLAIN,24));
            b1=new JButton("Enter");
            b1.setBounds(580,380,100,35);
            b1.setBackground(Color.WHITE);
            b1.setForeground(Color.black);
            b1.setFocusPainted(false);
            b1.addActionListener(this);
            panel2.add(text);
            panel2.add(input1);
            panel2.add(b1);
           
            panel2.setBackground(new Color(245, 245, 220)); 
        }
        
        JPanel panel3 = new JPanel();
        {
           snackManager = new ProductManager("C:\\Users\\Family\\Documents\\NetBeansProjects\\Boycott\\src\\boycott\\Israeli snacks.txt");     
            panel3.setLayout(null);
            JLabel text=new JLabel("Enter Snack: ");
            text.setBounds(300,220,500,200);
            text.setFont(new Font("MONOSPACED",Font.BOLD,24));
            input2=new JTextField();
            input2.setBounds(500,300,250,50);
            input2.setFont(new Font("MONOSPACED",Font.PLAIN,24));
            b2=new JButton("Enter");
            b2.setBounds(580,380,100,35);
            b2.setBackground(Color.WHITE);
            b2.setForeground(Color.black);
            b2.setFocusPainted(false);
            b2.addActionListener(this);
            panel3.add(text);
            panel3.add(input2);
            panel3.add(b2);
           
            panel3.setBackground(new Color(245, 245, 220));
        }
        JPanel panel4 = new JPanel();
        {
            detergentManager = new ProductManager("C:\\Users\\Family\\Documents\\NetBeansProjects\\Boycott\\src\\boycott\\Israeli Dtergents.txt");     
            panel4.setLayout(null); 
            JLabel text=new JLabel("Enter Detergent: ");
            text.setBounds(270,220,500,200);
            text.setFont(new Font("MONOSPACED",Font.BOLD,24));
            input3=new JTextField();
            input3.setBounds(500,300,250,50);
            input3.setFont(new Font("MONOSPACED",Font.PLAIN,24));
            b3=new JButton("Enter");
            b3.setBounds(580,380,100,35);
            b3.setBackground(Color.WHITE);
            b3.setForeground(Color.black);
            b3.setFocusPainted(false);
            b3.addActionListener(this);
            panel4.add(text);
            panel4.add(input3);
            panel4.add(b3);
            
            panel4.setBackground(new Color(245, 245, 220));
        }
        showPanel(panel1);
              // Create buttons to switch between panels
        JButton btnPanel1 = createStyledButton("Home", panel1);
        JButton btnPanel2 = createStyledButton("Drinks", panel2);
        JButton btnPanel3 = createStyledButton("Snacks", panel3);
        JButton btnPanel4 = createStyledButton("Detergent", panel4);
        // Create a panel for buttons on the east side
        JPanel buttonPanel = new JPanel(new GridLayout(4, 1, 5, 5)); // GridLayout for vertical alignment
        buttonPanel.add(btnPanel1);
        buttonPanel.add(btnPanel2);
        buttonPanel.add(btnPanel3);
        buttonPanel.add(btnPanel4);

        // Add button panels to the frame
        add(buttonPanel, BorderLayout.WEST);

        setVisible(true);
        } 

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==b1)
            {
                
                String[] flavors = {"Cola flavored", "Apple Flavored", "Citrus", "Pomegranate", 
                "Guava", "Peach", "Strawberry", "Mixed Fruit/Cocktail", 
                "Energy Drinks", "Unique/Miscellaneous Flavors"};
               String  inputProduct=input1.getText();
               String product = ProductManager.normalizeInput(inputProduct);
                try {
                    processCategory(drinksManager,product,flavors,"Select a Category","C:\\Users\\Family\\Documents\\NetBeansProjects\\Boycott\\src\\boycott\\Non-Israeli drinks.txt");
                } catch (IOException ex) {
                    Logger.getLogger(Search.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(e.getSource()==b2)
            {   String[] flavors = {"Spicy and Tangy",
                                  "Classic and Savory"};
               String  inputProduct=input2.getText();
               String product = ProductManager.normalizeInput(inputProduct);
                try {
                    processCategory(snackManager,product,flavors,"Choose the Category","C:\\Users\\Family\\Documents\\NetBeansProjects\\Boycott\\src\\boycott\\Non-Israeli snacks.txt");
                } catch (IOException ex) {
                    Logger.getLogger(Search.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else if(e.getSource()==b3)
            {
                String[] uses = {"Laundry Products","Dishwashing Products",
                                  "All-Purpose Cleaner"};
               String  inputProduct=input3.getText();
               String product = ProductManager.normalizeInput(inputProduct);
                try {
                    processCategory(detergentManager,product,uses,"Choose the Category","C:\\Users\\Family\\Documents\\NetBeansProjects\\Boycott\\src\\boycott\\Non-israeli detergents.txt");
                } catch (IOException ex) {
                    Logger.getLogger(Search.class.getName()).log(Level.SEVERE, null, ex);
                }
                        }
            else if(e.getSource()==backbtn)
            {
                setVisible(false);
           new Options().setVisible(true);
            }
        }
    

    private void processCategory(ProductManager manager, String product,String[] choices,String question,String filePath) throws IOException {
        // Check if the product exists
        if (!manager.containsProduct(product)) {
            JOptionPane.showMessageDialog(null, "Congratulations, this product is not Israeli", "Product Check", JOptionPane.INFORMATION_MESSAGE);
            System.out.println("Perfect, " + product + " is not in the list.");
        } else {
       int result = JOptionPane.showOptionDialog(
                null,
                "This product might be from an Israeli company. Would you like to find alternatives?",
                "Warning",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE,
                null,
                new String[]{"Find Alternatives", "Cancel"},
                "Find Alternatives");

        // Process the result
        if (result == JOptionPane.YES_OPTION) {
                    // Create a combo box
        JComboBox<String> ComboBox = new JComboBox<>(choices);

        // Create a dialog box
        int option = JOptionPane.showConfirmDialog(null, ComboBox, question, JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
            
           if(option==OK_OPTION)
           {            
            String optionn = (String) ComboBox.getSelectedItem();

            ArrayList<String> recommendations = manager.getRecommendations(optionn,filePath);
            setVisible(false);
            new Alternative(recommendations).setVisible(true);
           }
           else if(option==CANCEL_OPTION)
           {
               JOptionPane.showMessageDialog(this, "Action canceled.");
           }
               
        }
        else if(result==JOptionPane.NO_OPTION)
        {
             
                JOptionPane.showMessageDialog(this, "Action canceled.");
        }
}
    }
      private void showPanel(JPanel panel) {
          if (currentPanel != null) {
           remove(currentPanel);
        }
        currentPanel = panel;
        add(currentPanel, BorderLayout.CENTER);
        revalidate();
         repaint();
    }  

       private JButton createStyledButton(String text, JPanel targetPanel) {
        JButton button = new JButton(text);
        button.setPreferredSize(new Dimension(200, 50));

        // Set button colors and font
        Color buttonColor = new Color(0, 128, 128);
        
        Color textColor = new Color(245, 245, 220);
        Font buttonFont = new Font("Arial", Font.BOLD, 16);

        button.setBackground(buttonColor);
        button.setForeground(textColor);
        button.setFont(buttonFont);
        button.setFocusPainted(false);
        // Add action listener to switch to the target panel
        button.addActionListener(e -> showPanel(targetPanel));

        return button;
    }
}

