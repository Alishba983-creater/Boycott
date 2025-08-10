package boycott;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class WhyBoycott extends JFrame implements ActionListener {
    private  JButton yesButton;
    private  JButton noButton;
    private  JLabel questionLabel;

    Color colour = new Color(230, 230, 250);

    WhyBoycott() {
        setSize(1400, 750);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setTitle("WHY BOYCOTT?");
        JPanel main = new JPanel();
        main.setLayout(null);
        main.setPreferredSize(new Dimension(1350, 1350)); // Ensure the panel is larger than the frame to enable scrolling
        main.setBackground(new Color(245, 245, 220));
        
        JLabel heading = new JLabel("  How Boycott Can Save Lives of Palestinians");
        heading.setFont(new Font("MV BOLI", Font.BOLD | Font.ITALIC, 40));
        heading.setBounds(300, 20, 1300, 200);
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("SP1.jpg"));
        Image scaledImage = imageIcon.getImage().getScaledInstance(1400, 250, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JLabel imageLabel = new JLabel(scaledIcon);
        imageLabel.setBounds(0, 0, 1400, 250);
        imageLabel.add(heading);
        main.add(imageLabel);

        // Panel for text
        JPanel textArea = new JPanel();
        textArea.setBounds(20, 240, 1400, 850);
        textArea.setOpaque(false);
        textArea.setLayout(new BoxLayout(textArea, BoxLayout.Y_AXIS));

        String[] headings = {
            "Why Boycott Matters",
            "Economic Impact",
            "Moral Stand",
            "How You Can Help",
            "Conclusion"
        };

        String[] texts = {
            "Boycotting Israeli products is a powerful way to stand against oppression and support justice for Palestinians. Every purchase decision can make a significant impact.",
            "The economic influence of boycotting Israeli goods can drive change.\nRedirecting funds to ethical alternatives supports businesses that\nrespect human rights.",
            "Boycotting is a peaceful form of protest, showing solidarity\nwith Palestinians and sending a strong message that human rights\nabuses will\nnot be tolerated.",
            "You can help by educating yourself about the impact of your purchases, spreading awareness, and\nmaking conscious choices that align with your values.",
            "Boycotting Israeli products is not just an act of defiance; it’s a commitment to justice, equality,\nand the preservation of human dignity."
        };

        for (int i = 0; i < headings.length; i++) {
            textArea.add(Box.createVerticalStrut(20));
            JLabel headingLabel = new JLabel(headings[i]);
            headingLabel.setFont(new Font("MONOSPACED", Font.BOLD | Font.ITALIC, 30));
            headingLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
            textArea.add(headingLabel);

            JTextArea text = new JTextArea(texts[i]);
            text.setFont(new Font("MONOSPACED", Font.ITALIC, 21));
            text.setLineWrap(true);
            text.setWrapStyleWord(true);
            text.setEditable(false);
            text.setOpaque(false);
            text.setAlignmentX(Component.LEFT_ALIGNMENT);
            text.setMargin(new Insets(5, 5, 5, 5));
            textArea.add(Box.createVerticalStrut(20));
            textArea.add(text);
        }

        main.add(textArea);

        // Slogan panel
        JPanel sloganPanel = new JPanel();
        sloganPanel.setBounds(220, 1150, 700, 200);
        sloganPanel.setLayout(new BoxLayout(sloganPanel, BoxLayout.Y_AXIS));
        sloganPanel.setOpaque(false);

        String[] slogans = {
            "Stand for Justice, Boycott for Change!",
            "Your Choice, Their Voice!",
            "Boycott Today for a Better Tomorrow!",
            "Support Humanity, Boycott Inhumanity!"
        };

        for (String slogan : slogans) {
            JLabel sloganLabel = new JLabel(slogan);
            sloganLabel.setFont(new Font("MONOSPACED", Font.ITALIC | Font.BOLD, 24));
            sloganLabel.setForeground(new Color(0, 102, 0)); // Dark green color
            sloganLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            sloganPanel.add(sloganLabel);
            sloganPanel.add(Box.createVerticalStrut(10)); // Add space between slogans
        }

        main.add(sloganPanel);

        // Create a JLayeredPane to manage the layering of components.
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(850, 350, 560, 560);

        // Create three colored panels to add to the layered pane.
        JPanel panel1 = createLayeredPanel("2.jpg", 100, 100, 250, 250);
        JPanel panel2 = createLayeredPanel("1.jpg", 200, 200, 260, 260);

        // Add the panels to the layered pane with different layer values.
        // The layers determine the stacking order of the panels.
        layeredPane.add(panel1, Integer.valueOf(0));
        layeredPane.add(panel2, Integer.valueOf(1));
        main.add(layeredPane);

        // Question panel
        JPanel panel = new JPanel();
        panel.setBounds(1030, 1070, 300, 200);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(new LineBorder(Color.BLACK, 5));
        questionLabel = new JLabel("Do you want Pepsi?");
        questionLabel.setFont(new Font("TIMES NEW ROMAN", Font.BOLD, 24));
        questionLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(Box.createVerticalGlue());
        panel.add(questionLabel);
        panel.add(Box.createVerticalStrut(40)); // Add vertical space between label and buttons

        JPanel buttonPanel = new JPanel();
        buttonPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        yesButton = new JButton("Yes");
        yesButton.setBackground(Color.GREEN);
        noButton = new JButton("No");
        noButton.setBackground(Color.RED);
        yesButton.addActionListener((ActionEvent e) -> {
            JOptionPane.showMessageDialog(null, "Congratulations! You have successfully killed 1 child.");
        });

        noButton.addActionListener((ActionEvent e) -> {
            JOptionPane.showMessageDialog(null, "Good.");
        });

        buttonPanel.add(yesButton);
        buttonPanel.add(noButton);
        buttonPanel.setOpaque(false);
        panel.add(buttonPanel);
        panel.setOpaque(false);
        panel.add(Box.createVerticalGlue()); // Add vertical space to center the buttons

        main.add(panel);

//        // Background image
//        ImageIcon I1 = new ImageIcon(getClass().getResource("SP2.jpg"));
//        Image I2 = I1.getImage().getScaledInstance(1400, 1400, Image.SCALE_SMOOTH);
//        ImageIcon I3 = new ImageIcon(I2);
//        JLabel image = new JLabel(I3);
//        image.setBounds(0, 0, 1400, 1400);
//        main.add(image);
        JButton backbtn=new JButton("Back");
        backbtn.setBounds(1230,1280,80,50);
        backbtn.setBackground(Color.black);
        backbtn.setForeground (Color.white);
        backbtn.setFocusPainted(false);
        backbtn.addActionListener(this);
        main.add(backbtn);
        JScrollPane scrollPane = new JScrollPane(main, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        add(scrollPane, BorderLayout.CENTER);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         setVisible(false);
           new Options().setVisible(true);
    }

    private JPanel createLayeredPanel(String imagePath, int x, int y, int width, int height) {
        ImageIcon imageIcon = new ImageIcon(getClass().getResource(imagePath));
        Image scaledImage = imageIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, width, height);
        JLabel imageLabel = new JLabel(scaledIcon);
        imageLabel.setBounds(0, 0, width, height);
        panel.add(imageLabel);
        panel.setBounds(x, y, width, height);
        return panel;
    }
}



