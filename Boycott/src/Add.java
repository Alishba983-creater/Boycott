package boycott;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.URL;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class Add extends JFrame implements ActionListener {

    // ComboBox
    JComboBox<String> categoryBox;

    // Labels
    JLabel label = new JLabel("Product Name : ");
// In your constructor or initialization block
ImageIcon headerPalestineImg = createScaledImageIcon("palestineImg.jpg", 1390, 250);
ImageIcon cancelIcon = createScaledImageIcon("cancel.png", 50, 50);
ImageIcon fileMissingIcon = createScaledImageIcon("filemissing.png", 50, 50);
    // Buttons
    JButton addButton = new JButton("Add Product");
    JButton verifyButton = new JButton("Verify Product");
    JButton checkAddedProducts = new JButton("Check Added Products");
    JButton backBtn = new JButton("Back");

    // Panel
    JPanel addProductPanel = new JPanel();

    // Variables
    String ans;
    String productName;
    
    // TextFields
    JTextField tf1 = new JTextField(20); // Adjust size

    // Text area
    JTextArea productDisplayArea = new JTextArea(); 
    
    // Constructor
    Add() {
        // Frame setup
        setTitle("ADD");
        setSize(1400, 750);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        // Header Panel
        JPanel headerPanel = new JPanel(null);
        headerPanel.setBounds(0, 0, 1400, 220);
        JLabel headerLabel = new JLabel(headerPalestineImg);
        headerLabel.setBounds(0, 0, 1400, 220);
        headerPanel.add(headerLabel);

        // Buttons setup
        addButton.setBounds(600, 150, 150, 40);
        addButton.setForeground(Color.white);
        addButton.setFocusable(false);
        addButton.setFont(new Font("Serif", Font.PLAIN, 17));
        addButton.setBackground(Color.black);
        addButton.addActionListener(this);
        addButton.setVisible(false);

        backBtn.setBounds(1250, 400, 80, 50);
        backBtn.setForeground(Color.WHITE);
        backBtn.setFocusable(false);
        backBtn.setBackground(Color.BLACK);
        backBtn.setFont(new Font("Serif", Font.PLAIN, 17));
        backBtn.addActionListener(this);

        tf1.setBounds(600, 100, 200, 30);
        tf1.setFont(new Font("Serif", Font.PLAIN, 19));
        tf1.setVisible(false);

        verifyButton.setBounds(580, 100, 180, 60);
        verifyButton.setForeground(Color.WHITE);
        verifyButton.setFocusable(false);
        verifyButton.setBackground(Color.black);
        verifyButton.setFont(new Font("Serif", Font.PLAIN, 17));
        verifyButton.addActionListener(this);

        checkAddedProducts.setBounds(550, 200, 260, 50);
        checkAddedProducts.setForeground(Color.WHITE);
        checkAddedProducts.setFocusable(false);
        checkAddedProducts.setBackground(Color.DARK_GRAY);
        checkAddedProducts.setFont(new Font("Serif", Font.PLAIN, 20));
        checkAddedProducts.addActionListener(this);

        // ComboBox setup
        String[] categories = { "Drinks", "Snacks", "Detergents"};
        categoryBox = new JComboBox<>(categories);
        categoryBox.addActionListener(this);
        categoryBox.setBounds(300, 340, 200, 30);

        // GridBagLayout for addProductPanel
        addProductPanel.setLayout(null);
        addProductPanel.setBounds(0, 220, 800, 500);
        addProductPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Add Israeli Product",
                TitledBorder.CENTER, TitledBorder.TOP,
                new Font("Serif", Font.BOLD, 24), Color.RED));

        productDisplayArea.setBounds(430,270,500,170);
        productDisplayArea.setEditable(false);
        addProductPanel.add(label);
        addProductPanel.setBounds(0,220,1400,530);
        label.setBounds(500, 100, 200, 30);
        label.setVisible(false);
        addProductPanel.add(tf1);
        addProductPanel.add(addButton);
        addProductPanel.add(verifyButton);
        addProductPanel.add(checkAddedProducts);
        addProductPanel.add(productDisplayArea);
        addProductPanel.add(backBtn);
        // Add panels to the frame
        add(headerPanel);
        add(addProductPanel);


        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int comboIndex = 3;

        // addButton Action Listener
        if (e.getSource() == addButton) {
            try {
                int answer = JOptionPane.showConfirmDialog(null, "Is The Product Israeli?", "Product Verification",
                        JOptionPane.YES_NO_OPTION, 0);

if (answer == JOptionPane.YES_OPTION) {
    int indexResult = JOptionPane.showConfirmDialog(null, categoryBox, "Please Select Category",
            JOptionPane.OK_CANCEL_OPTION);

    if (indexResult == JOptionPane.OK_OPTION) {
        comboIndex = categoryBox.getSelectedIndex();

       
        String filePath = switch (comboIndex) {
            case 0 -> "C:\\Users\\Family\\Documents\\NetBeansProjects\\Boycott\\src\\boycott\\Israeli drinks.txt";
            case 1 -> "C:\\Users\\Family\\Documents\\NetBeansProjects\\Boycott\\src\\boycott\\Israeli snacks.txt";
            case 2 -> "C:\\Users\\Family\\Documents\\NetBeansProjects\\Boycott\\src\\boycott\\Israeli Detergents.txt";
            default -> throw new IllegalStateException("Unexpected value: " + comboIndex);
        };

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            productName = tf1.getText().trim();
            String line;
            boolean found = false;

            while ((line = reader.readLine()) != null) {
                if (line.equalsIgnoreCase(productName.toLowerCase())) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
                    writer.write(productName.toLowerCase());
                    writer.newLine();
                    JOptionPane.showMessageDialog(null, "Product Added Successfully.\nThank You");
                } catch (Exception eee) {
                    JOptionPane.showMessageDialog(null, "File Not Found", "File Unknown",
                            JOptionPane.ERROR_MESSAGE, fileMissingIcon);
                }
                
                 try (BufferedWriter br = new BufferedWriter(
                new FileWriter("C:\\Users\\Family\\Documents\\NetBeansProjects\\Boycott\\src\\boycott\\Added products.txt", true))) {
            productName = tf1.getText().trim();
            br.write(productName);
            br.newLine();
            } catch (Exception eeee) {
            JOptionPane.showMessageDialog(null, "File1 Not Found", "File Unknown",
                    JOptionPane.ERROR_MESSAGE, fileMissingIcon);
            }

                 
            } else {
                JOptionPane.showMessageDialog(null, "Product already exists.", "Duplicate Product",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception eee) {
            JOptionPane.showMessageDialog(null, "File Not Found", "File Unknown",
                    JOptionPane.ERROR_MESSAGE, fileMissingIcon);
        }

        verifyButton.setVisible(true);
        addButton.setVisible(false);
        tf1.setVisible(false);
        label.setVisible(false);
        tf1.setText("");
    } else if (indexResult == JOptionPane.CANCEL_OPTION) {
        JOptionPane.showMessageDialog(null, "You Cancelled Product Addition", "Addition Cancelled",
                JOptionPane.ERROR_MESSAGE, cancelIcon);
    }
}

            } catch (Exception ee) {
                JOptionPane.showMessageDialog(null, "Error 404", "Product Verification Failed.",
                        JOptionPane.ERROR_MESSAGE);
            }
        }

        // VerifyProduct Button Action Listener
        else if (e.getSource() == verifyButton) {
            try {
                int ans = JOptionPane.showConfirmDialog(null,
                        "Do You Want To Be Redirected To Website And Verify Product?", "Product Verification",
                        JOptionPane.YES_NO_OPTION);

                if (ans == JOptionPane.YES_OPTION) {
                    Desktop.getDesktop().browse(new URL("https://bdnaash.com/").toURI());
                    addButton.setVisible(true);
                    verifyButton.setVisible(false);
                    tf1.setVisible(true);
                    label.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "You Cancelled Product Addition.");
                }
            } catch (Exception e1) {
                JOptionPane.showMessageDialog(null, "You Cancelled Product Addition.");
            }
        }

        // checkAddedProducts Button Action Listener
        else if (e.getSource() == checkAddedProducts) {
            try (BufferedReader br = new BufferedReader(
                    new FileReader("C:\\Users\\Family\\Documents\\NetBeansProjects\\Boycott\\src\\boycott\\Added products.txt"))) {
                String str;
                productDisplayArea.setText("");
                while ((str = br.readLine()) != null) {
                    productDisplayArea.append(str + "\n");
                }
            } catch (Exception eeee) {
                JOptionPane.showMessageDialog(null, "File Not Found!", "Error 404", 0);
            }
        }

        // backBtn Action Listener
        else if (e.getSource() == backBtn) {
            dispose();
            new Options().setVisible(true);
        }
    }
 private ImageIcon createScaledImageIcon(String path, int width, int height) {
    ImageIcon imageIcon = new ImageIcon(getClass().getResource(path));
    Image scaledImage = imageIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
    return new ImageIcon(scaledImage);
}
    public static void main(String[] args) {
        new Add();
    }
}


