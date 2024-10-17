import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PasswordGeneratorGui extends JFrame {
    private PasswordGenerator passwordGenerator;

    public PasswordGeneratorGui() {
        super("Password Generator");

        setSize(540, 570);
        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        passwordGenerator = new PasswordGenerator();
        addGuicomponents();
    }

    private void addGuicomponents() {
        JLabel titlelabel = new JLabel("Password Generator");
        titlelabel.setFont(new Font("Dialog", Font.BOLD, 32));
        titlelabel.setHorizontalAlignment(SwingConstants.CENTER);
        titlelabel.setBounds(0, 10, 540, 39);
        add(titlelabel);

        JTextArea outputarea = new JTextArea();
        outputarea.setEditable(false);
        outputarea.setFont(new Font("Dialog", Font.BOLD, 32));

        JScrollPane outputareapane = new JScrollPane(outputarea);
        outputareapane.setBounds(25, 97, 479, 70);
        outputareapane.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(outputareapane);

        JLabel passwordLengthLabel = new JLabel("Password Length: ");
        passwordLengthLabel.setFont(new Font("Dialog", Font.PLAIN, 32));
        passwordLengthLabel.setBounds(25, 200, 272, 39);
        add(passwordLengthLabel);

        JTextArea passwordlengthInput = new JTextArea();
        passwordlengthInput.setFont(new Font("Dialog", Font.BOLD, 32));
        passwordlengthInput.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        passwordlengthInput.setBounds(310, 215, 192, 39);
        add(passwordlengthInput);

        JToggleButton uppercaseToggle = new JToggleButton("UpperCase");
        uppercaseToggle.setBounds(25, 275, 225, 56);
        add(uppercaseToggle);

        JToggleButton lowercaseToggle = new JToggleButton("Lowercase");
        lowercaseToggle.setBounds(282, 275, 225, 56);
        add(lowercaseToggle);

        JToggleButton numbersToggle = new JToggleButton("Numbers");
        numbersToggle.setBounds(25, 350, 225, 56);
        add(numbersToggle);

        JToggleButton symbolsToggle = new JToggleButton("Symbols");
        symbolsToggle.setBounds(282, 350, 225, 56);
        add(symbolsToggle);

        JButton generateButton = new JButton("Generate");
        generateButton.setBounds(155, 477, 222, 41);
        generateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (passwordlengthInput.getText().length() <= 0) return;

                boolean anyToggleSelected = lowercaseToggle.isSelected() ||
                                            uppercaseToggle.isSelected() ||
                                            numbersToggle.isSelected() ||
                                            symbolsToggle.isSelected();

                int passwordlength = Integer.parseInt(passwordlengthInput.getText());

                if (anyToggleSelected) {
                    String generatedPassword = passwordGenerator.generatePassword(
                            passwordlength,
                            uppercaseToggle.isSelected(),
                            lowercaseToggle.isSelected(),
                            numbersToggle.isSelected(),
                            symbolsToggle.isSelected()
                    );
                    outputarea.setText(generatedPassword);
                }
            }
        });
        add(generateButton);
    }
}
