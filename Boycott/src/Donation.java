
package boycott;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class Donation extends JFrame implements ActionListener {

   
    
    JButton donateNowUBL = new JButton("Donate to UBL");
    JButton donateNowHBL = new JButton("Donate to HBL");
    JButton donateNowMB = new JButton("Donate to MB");
    JButton donateNowABL = new JButton("Donate to ABL");
    JButton easyPaisaRedirect = new JButton("Click to Donate");
    JButton jazzCashRedirect = new JButton("Click to Donate");
    JButton backBtn = new JButton("Back");
    
    JTextArea easyPaisa = new JTextArea();
    JTextArea jazzCash = new JTextArea();
    JTextArea bank1 = new JTextArea();
    JTextArea bank2 = new JTextArea();
    JTextArea bank3 = new JTextArea();
    JTextArea bank4 = new JTextArea();
    
    JPanel easyJazzPanel = new JPanel();
    JPanel bankPanel = new JPanel();
    
    JComboBox<String> bankComboBox = new JComboBox<>();
    
    JLabel bankLabel = new JLabel();
    
    // ImageIcons using the helper method
    ImageIcon easyImg = createImageIcon("easypysa.jpg", 50, 50);
    ImageIcon jazzCashImg = createImageIcon("jazz.png", 50, 50);
    ImageIcon palestineHeader = createImageIcon("palestine.jpg", 1390, 250);
    ImageIcon ublImg = createImageIcon("ublImg.png", 50, 50);
    ImageIcon hblImg = createImageIcon("hblImg.png", 50, 50);
    ImageIcon meezanImg = createImageIcon("meezanImg.jpeg", 50, 50);
    ImageIcon ablImg = createImageIcon("ablImg.jpeg", 50, 50);
    ImageIcon happyIcon = createImageIcon("happy.png", 50, 50);

    
    
    public Donation() {
        // Frame settings
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(980, 1000);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setTitle("DONATION");
        
        bankLabel.setText("Please select a bank");
      
      
        
      // Header panel
        JPanel headerPanel = new JPanel(new BorderLayout());
        JLabel headerLabel = new JLabel("", SwingConstants.CENTER);
        headerLabel.setFont(new Font("Serif", Font.BOLD, 24));
        
        // Header image
        JLabel headerImageLabel = new JLabel(palestineHeader);
        
        headerPanel.add(headerImageLabel, BorderLayout.WEST);
        headerPanel.add(headerLabel, BorderLayout.CENTER);
        // Donate Now buttons
        donateNowUBL.setFont(new Font("Serif", Font.PLAIN, 18));
        donateNowUBL.setIcon(ublImg);
        donateNowUBL.setBackground(Color.black);
        donateNowUBL.setForeground(Color.white);
        donateNowUBL.addActionListener(this);

        donateNowHBL.setFont(new Font("Serif", Font.PLAIN, 18));
        donateNowHBL.setIcon(hblImg);
        donateNowHBL.setBackground(Color.black);
        donateNowHBL.setForeground(Color.white);
        donateNowHBL.addActionListener(this);

        donateNowMB.setFont(new Font("Serif", Font.PLAIN, 18));
        donateNowMB.setIcon(meezanImg);
        donateNowMB.setBackground(Color.black);
        donateNowMB.setForeground(Color.white);
        donateNowMB.addActionListener(this);

        donateNowABL.setFont(new Font("Serif", Font.PLAIN, 18));
        donateNowABL.setIcon(ablImg);
        donateNowABL.setBackground(Color.black);
        donateNowABL.setForeground(Color.white);
        donateNowABL.addActionListener(this);

        // EasyPaisa redirect button
        easyPaisaRedirect.setText("Click to Donate");
        easyPaisaRedirect.setIcon(easyImg);
        easyPaisaRedirect.setBackground(Color.black);
        easyPaisaRedirect.setForeground(Color.white);
        easyPaisaRedirect.setFont(new Font("Serif", Font.PLAIN, 18));
        easyPaisaRedirect.addActionListener(this);

        // JazzCash redirect button
        jazzCashRedirect.setFont(new Font("Serif", Font.PLAIN, 18));
        jazzCashRedirect.setIcon(jazzCashImg);
        jazzCashRedirect.setBackground(Color.black);
        jazzCashRedirect.setForeground(Color.white);
        jazzCashRedirect.addActionListener(this);

        //backBtn
        backBtn.setFont(new Font("Serif", Font.PLAIN, 18));
        backBtn.setBackground(Color.black);
        backBtn.setForeground(Color.white);
        backBtn.addActionListener(this);
        // TextArea for EasyPaisa information
        
        easyPaisa.setText("        EasyPaisa Information\n\nAccount Title: Usman Ali Khan\nAccount Number: 03250077535\n");
        easyPaisa.setBorder(BorderFactory.createLineBorder(Color.black));
        easyPaisa.setFont(new Font("Serif", Font.PLAIN, 18));
        easyPaisa.setOpaque(false);
        easyPaisa.setEditable(false);

        // TextArea for JazzCash information
        jazzCash.setText("        JazzCash Information\n\nAccount Title: Alishba Ali\nAccount Number: 03404879635\n");
        jazzCash.setBorder(BorderFactory.createLineBorder(Color.black));
        jazzCash.setFont(new Font("Serif", Font.PLAIN, 18));
        jazzCash.setOpaque(false);
        jazzCash.setEditable(false);

        // TextAreas for Bank information
        bank1.setText("\nUnited Bank Limited (UBL)\n\nAccount Title: Alishba Ali\n\nAccount Number: 99434923222\n");
        bank1.setBorder(BorderFactory.createLineBorder(Color.black));
        bank1.setFont(new Font("Serif", Font.PLAIN, 18));
        bank1.setOpaque(false);
        bank1.setEditable(false);

        bank2.setText("\nHabib Bank Limited (HBL)\n\nAccount Title: Usman Ali Khan\n\nAccount Number: 99434323212\n");
        bank2.setBorder(BorderFactory.createLineBorder(Color.black));
        bank2.setFont(new Font("Serif", Font.PLAIN, 18));
        bank2.setOpaque(false);
        bank2.setEditable(false);

        bank3.setText("\nMeezan Bank (MB)\n\nAccount Title: AL KHIDMAT FOUNDATION\n\nAccount Number: 99043847384\n");
        bank3.setBorder(BorderFactory.createLineBorder(Color.black));
        bank3.setFont(new Font("Serif", Font.PLAIN, 18));
        bank3.setOpaque(false);
        bank3.setEditable(false);

        bank4.setText("\nAllied Bank Limited (ABL)\n\nAccount Title: AL KHIJRI FOUNDATION\n\nAccount Number: 992344345566\n");
        bank4.setBorder(BorderFactory.createLineBorder(Color.black));
        bank4.setFont(new Font("Serif", Font.PLAIN, 18));
        bank4.setOpaque(false);
        bank4.setEditable(false);

        // ComboBox for selecting banks
        bankComboBox.addItem("United Bank Limited (UBL)");
        bankComboBox.addItem("Habib Bank Limited (HBL)");
        bankComboBox.addItem("Meezan Bank (MB)");
        bankComboBox.addItem("Allied Bank Limited (ABL)");
        bankComboBox.setFont(new Font("Serif", Font.PLAIN, 16));
        bankComboBox.addActionListener(this);

        // Panel for EasyPaisa and JazzCash information and buttons
        easyJazzPanel.setLayout(new GridBagLayout());
        easyJazzPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Donation Information",
                TitledBorder.CENTER, TitledBorder.TOP, new Font("Serif", Font.BOLD, 18), Color.BLACK));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.gridx = 0;
        gbc.gridy = 0;
        easyJazzPanel.add(easyPaisa, gbc);

        gbc.gridy = 1;
        easyJazzPanel.add(easyPaisaRedirect, gbc);

        gbc.gridy = 2;
        easyJazzPanel.add(jazzCash, gbc);

        gbc.gridy = 3;
        easyJazzPanel.add(jazzCashRedirect, gbc);
        
        gbc.insets = new Insets(15, 15, 15, 15);
        gbc.gridy=4;
        gbc.anchor= GridBagConstraints.LAST_LINE_START;
        easyJazzPanel.add(backBtn,gbc);
        
        // Panel for bank information and combo box
        bankPanel.setLayout(new GridBagLayout());
        bankPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Bank Information",
                TitledBorder.CENTER, TitledBorder.TOP, new Font("Serif", Font.BOLD, 18), Color.BLACK));
        
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor= GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 0;
        bankLabel.setFont(new Font("Serif", Font.BOLD, 20));
        bankPanel.add(bankLabel, gbc);

        gbc.gridy = 1;
        bankPanel.add(bankComboBox, gbc);
            
        gbc.gridy = 2;
        bankPanel.add(bank1, gbc);

        gbc.gridy = 3;
        bankPanel.add(bank2, gbc);

        gbc.gridy = 4;
        bankPanel.add(bank3, gbc);

        gbc.gridy = 5;
        bankPanel.add(bank4, gbc);
        
        gbc.gridy=6;
         bankPanel.add(donateNowUBL,gbc);
         bankPanel.add(donateNowHBL, gbc);
         bankPanel.add(donateNowMB, gbc);
         bankPanel.add(donateNowABL, gbc);
        

         donateNowUBL.setVisible(false);
         donateNowHBL.setVisible(false);
         donateNowMB.setVisible(false);
         donateNowABL.setVisible(false);

         
        // Main panel for all components
          JPanel mainPanel = new JPanel(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
       gbc.anchor = GridBagConstraints.CENTER;
        mainPanel.add(headerPanel, gbc);

        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.weightx = 0.5;
        gbc.weighty=0.5;
        gbc.fill = GridBagConstraints.BOTH;
        mainPanel.add(easyJazzPanel, gbc);

        gbc.gridx = 1;
        gbc.gridwidth = 1;
        gbc.weightx = 0.5;
        gbc.weighty=0.5;
        gbc.fill = GridBagConstraints.BOTH;
        mainPanel.add(bankPanel, gbc);

            
       
        // Add the main panel to the frame
        add(mainPanel, BorderLayout.CENTER);

        // Display the frame
        setVisible(true);

        // Initialize the visibility of bank information
        updateBankVisibility();

    }

    private void updateBankVisibility() {
        String selectedBank = (String) bankComboBox.getSelectedItem();
        bank1.setVisible(selectedBank.equals("United Bank Limited (UBL)"));
        bank2.setVisible(selectedBank.equals("Habib Bank Limited (HBL)"));
        bank3.setVisible(selectedBank.equals("Meezan Bank (MB)"));
        bank4.setVisible(selectedBank.equals("Allied Bank Limited (ABL)"));
    }
    public void updateBankVisibilityDonate(){
        String selectedBank = (String)bankComboBox.getSelectedItem();
        donateNowUBL.setVisible(selectedBank.equals("United Bank Limited (UBL)"));
        donateNowHBL.setVisible(selectedBank.equals("Habib Bank Limited (HBL)"));
        donateNowMB.setVisible(selectedBank.equals("Meezan Bank (MB)"));
        donateNowABL.setVisible(selectedBank.equals("Allied Bank Limited (ABL)"));
    }

@Override
public void actionPerformed(ActionEvent e) {
    try {
        
        if (e.getSource() == donateNowUBL) {
            // Handle donateNowUBL button action
            int ans = JOptionPane.showConfirmDialog(null, "You will be redirected to UBL Website.\nDo You Agree?", "UBL Redirection", JOptionPane.YES_NO_OPTION);
            if (ans == JOptionPane.YES_OPTION) {
                Desktop.getDesktop().browse(new URL("https://www.ubldigital.com/Donate-today-with-UBL").toURI());
                JOptionPane.showMessageDialog(null, "Thank You For Donation.\nYou Just Saved A Child.", "Appreciation",JOptionPane.INFORMATION_MESSAGE, happyIcon);
            }
            else{
                JOptionPane.showMessageDialog(null,"You Cancelled Donation");
            }
        } 
        else if (e.getSource() == donateNowHBL) {
            // Handle donateNowHBL button action
            int anss = JOptionPane.showConfirmDialog(null, "You will be redirected to HBL Website.\nDo You Agree?", "HBL Redirection", JOptionPane.YES_NO_OPTION);
            if (anss == JOptionPane.YES_OPTION) {
                Desktop.getDesktop().browse(new URL("https://www.hbl.com/ebanc-roshan-digital-account/ebanc-roshan-digital-account/hbl-roshan-samaji-khidmat").toURI());
                JOptionPane.showMessageDialog(null, "Thank You For Donation.\nYou Just Saved A Child.", "Appreciation",JOptionPane.INFORMATION_MESSAGE, happyIcon);

            }else{
                JOptionPane.showMessageDialog(null,"You Cancelled Donation");
            }
        } 
        else if (e.getSource() == donateNowMB) {
            // Handle donateNowNOP button action
            int answer = JOptionPane.showConfirmDialog(null, "You will be redirected to Meezan Bank Website.\nDo You Agree?", "Meezan Bank Redirection", JOptionPane.YES_NO_OPTION);
            if (answer == JOptionPane.YES_OPTION) {
                Desktop.getDesktop().browse(new URL("https://alkhidmat.org/appeal/emergency-appeal-palestine-save-lives-in-gaza-today").toURI());
                JOptionPane.showMessageDialog(null, "Thank You For Donation.\nYou Just Saved A Child.", "Appreciation",JOptionPane.INFORMATION_MESSAGE, happyIcon);

            }
            else{
                JOptionPane.showMessageDialog(null,"You Cancelled Donation");
            }
        } 
        else if (e.getSource() == donateNowABL) {
            // Handle donateNowABL button action
            int ans_wer = JOptionPane.showConfirmDialog(null, "You will be redirected to ABL Website.\nDo You Agree?", "ABL Redirection", JOptionPane.YES_NO_OPTION);
            if (ans_wer == JOptionPane.YES_OPTION) {
                Desktop.getDesktop().browse(new URL("https://www.abl.com/personal/roshan-digital-services/roshan-samaaji-khidmat/").toURI());
                JOptionPane.showMessageDialog(null, "Thank You For Donation.\nYou Just Saved A Child.", "Appreciation",JOptionPane.INFORMATION_MESSAGE, happyIcon);

            }
            else{
                JOptionPane.showMessageDialog(null,"You Cancelled Donation");
            }
        } 
        else if (e.getSource() == easyPaisaRedirect) {
            // Handle easyPaisaRedirect button action
            int ans_wer = JOptionPane.showConfirmDialog(null, "You will be redirected to EasyPaisa Website.\nDo You Agree?", "EasyPaisa Redirection", JOptionPane.YES_NO_OPTION);
            if (ans_wer == JOptionPane.YES_OPTION) {
                Desktop.getDesktop().browse(new URL("https://easypaisa.com.pk/donations/").toURI());
                JOptionPane.showMessageDialog(null, "Thank You For Donation.\nYou Just Saved A Child.", "Appreciation",JOptionPane.INFORMATION_MESSAGE, happyIcon);

            }else{
                JOptionPane.showMessageDialog(null,"You Cancelled Donation");
            }
        } 
        else if (e.getSource() == jazzCashRedirect) {
            // Handle jazzCashRedirect button action
            int ans_wer = JOptionPane.showConfirmDialog(null, "You will be redirected to JazzCash Website.\nDo You Agree?", "JazzCash Redirection", JOptionPane.YES_NO_OPTION);
            if (ans_wer == JOptionPane.YES_OPTION) {
                Desktop.getDesktop().browse(new URL("https://www.jazzcash.com.pk/digital-payments/online-payments/").toURI());
                JOptionPane.showMessageDialog(null, "Thank You For Donation.\nYou Just Saved A Child.", "Appreciation",JOptionPane.INFORMATION_MESSAGE, happyIcon);
            }
            else{
                JOptionPane.showMessageDialog(null,"You Cancelled Donation");
            }
        } 
        else if (e.getSource() == bankComboBox) {
            // Handle bankComboBox selection
            updateBankVisibility();
            updateBankVisibilityDonate();
        }
        
        else if(e.getSource()==backBtn){
                        dispose();
                        new Options().setVisible(true);
        }
    }
    catch (Exception ee) {
       JOptionPane.showMessageDialog(null, "Error while communicating with website", "Error 404", 0);
    }
}
    
  private ImageIcon createImageIcon(String path, int width, int height) {
        ImageIcon icon = new ImageIcon(getClass().getResource(path));
        Image scaledImage = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(scaledImage);
    }

    public static void main(String[] args) {
        new Donation();
    }

   
}





