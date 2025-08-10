package boycott;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



public class Intro extends JFrame implements ActionListener{
JButton button;
JCheckBox check;
    public Intro() {
         setTitle("Boycott");
        setSize(1400, 750);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Setting panel
        JPanel p = new JPanel();
        p.setLayout(null);
        p.setBounds(0, 0, 1400, 750);

        // Setting image
        ImageIcon image = new ImageIcon(getClass().getResource("SP.jpg"));
        Image I2 = image.getImage().getScaledInstance(1400, 750, Image.SCALE_SMOOTH);
        ImageIcon I3 = new ImageIcon(I2);

        // Image label
        JLabel imageLabel = new JLabel(I3);
        imageLabel.setBounds(0, 0, 1400, 750);

        // Text label
        JLabel label = new JLabel("Boycott");
        label.setForeground(Color.WHITE);
        label.setFont(new Font("MV Boli", Font.PLAIN, 100));
        label.setBounds(500, 20, 500, 500);

        // Button
        button = new JButton();
        button.setBounds(600, 400, 150, 50);
        button.setText("Start");
        button.setFocusPainted(false);
        button.setBackground(Color.WHITE);
        button.addActionListener(this);

        // Check box
        check = new JCheckBox("I am not an Israeli supporter");
        check.setBounds(560, 340, 250, 50);
        check.setFont(new Font("TIMES NEW ROMAN", Font.BOLD, 18)); 
        check.setForeground(Color.BLACK);
        check.setOpaque(false); 
        check.setFocusPainted(false); // Remove focus line
        check.setBorderPainted(false); // Remove border
        check.setContentAreaFilled(false); // Remove default background
      

        p.add(check);
        p.add(label);
        p.add(button);
        p.add(imageLabel);

        add(p);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         if(e.getSource()==button)
        {
            if(check.isSelected()){
          this.dispose();
          new Options().setVisible(true);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "You are not worthy of entering this app.", "Access Denied", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
}


