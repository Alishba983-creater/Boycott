package boycott;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class Options extends JFrame implements ActionListener {
    
    Color colour =new Color(245, 245, 220);
    JButton b1,b2,b3,b4;    
    public Options() {
        setSize(1400, 750); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("MENU");
        // Create a JPanel with GridLayout for organizing buttons
        JPanel panel = new JPanel(new GridLayout(2, 2, 100, 50)); // 2x2 grid with gaps
        panel.setBackground(colour); // Set background color for a JPanel named 'panel'
        panel.setBorder(new EmptyBorder(40, 70, 40, 70)); // top, left, bottom, right padding
        
        // Add buttons with icons
        b1=addButton(panel, "BOYCOTT.jpg", "SEARCH");
        b1.addActionListener(this);
        b2=addButton(panel, "ADD.png", "ADD");
        b2.addActionListener(this);
        b3=addButton(panel, "DONATE.jpg", "DONATE");
        b3.addActionListener(this);
        b4=addButton(panel, "MAP.jpg", "WHY BOYCOTT?");
        b4.addActionListener(this);
        
        // Add panel to JFrame
        
        add(panel);
        setVisible(true);
    }
    
    private JButton addButton(JPanel panel, String imagePath, String buttonText) {
       JPanel buttonLabelPanel = new JPanel();
       buttonLabelPanel.setLayout(new BoxLayout(buttonLabelPanel, BoxLayout.Y_AXIS));
        
        // Load and scale image
        ImageIcon imageIcon = new ImageIcon(getClass().getResource(imagePath));
        Image scaledImage = imageIcon.getImage().getScaledInstance(600, 210, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        
        // Create button with icon and tooltip
        JButton button = new JButton(scaledIcon);
        button.setBorder(new LineBorder(Color.BLACK, 5));
        // Add button to buttonLabelPanel
        buttonLabelPanel.add(button);
        
        // Create label and add to buttonLabelPanel
        JLabel label = new JLabel(buttonText, JLabel.CENTER);
        label.setFont(new Font("TIMES NEW ROMAN", Font.BOLD|Font.ITALIC, 40));
        label.setOpaque(false);
        buttonLabelPanel.add(label);
        buttonLabelPanel.setBackground(colour); 
        
        // Add buttonLabelPanel to main panel
        panel.add(buttonLabelPanel);
        return  button; 
       
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1)
        {
             setVisible(false);
            try {
                new Search().setVisible(true);
            } catch (IOException ex) {
                Logger.getLogger(Options.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(e.getSource()==b2)
        {
            setVisible(false);
           new Add().setVisible(true);            
        }
        else if(e.getSource()==b3)
        {
            setVisible(false);
           new Donation().setVisible(true);
        }
        else if(e.getSource()==b4)
       {
           setVisible(false);
           new WhyBoycott().setVisible(true);
       }
        
    }
    
}


