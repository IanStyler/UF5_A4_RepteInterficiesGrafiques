import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Prova {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Decimal a binari");
        JLabel decLabel = new JLabel("Numero en decimal a resoldre: ");
        JLabel resultatDecimalBinari = new JLabel("RESULTAT EN BINARI: ");
        JLabel resultatDecimalHexadecimal = new JLabel("RESULTAT EN HEXADECIMAL: ");
        JTextField decField = new JTextField(20);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        JLabel numBinariLabel = new JLabel("Numero en binari a resoldre: ");
        JLabel resultatBinariDecimal = new JLabel("RESULTAT EN DECIMAL: ");
        JLabel resultatBinariHexadecimal = new JLabel("RESULTAT EN HEXADECIMAL: ");
        JTextField binariAdecimal = new JTextField(20);
        JButton limpiarButton = new JButton("Neteja");

        decField.setColumns(35);
        binariAdecimal.setColumns(35);

        decField.setMaximumSize(decField.getPreferredSize());
        binariAdecimal.setMaximumSize(binariAdecimal.getPreferredSize());

        panel.add(decLabel);
        panel.add(decField);
        panel.add(resultatDecimalBinari);
        panel.add(resultatDecimalHexadecimal);
        panel.add(numBinariLabel);
        panel.add(binariAdecimal);
        panel.add(resultatBinariDecimal);
        panel.add(resultatBinariHexadecimal);
        panel.add(limpiarButton);

        decField.addActionListener(e -> {
            String decStr = decField.getText();
            try {
                int dec = Integer.parseInt(decStr);
                String bin = Integer.toBinaryString(dec);
                String hex = Integer.toHexString(dec);
                resultatDecimalBinari.setText("Numero en binari: " + bin);
                resultatDecimalHexadecimal.setText("Numero en hexadecimal: " + hex.toUpperCase());
            } catch (NumberFormatException ex) {
                resultatDecimalBinari.setText("Numero decimal no vàlid!");
                resultatDecimalHexadecimal.setText("");
            }
        });

        binariAdecimal.addActionListener(e -> {
            String binStr = binariAdecimal.getText();
            try {
                int dec = Integer.parseInt(binStr, 2);
                String hex = Integer.toHexString(dec);
                resultatBinariDecimal.setText("Numero en decimal: " + dec);
                resultatBinariHexadecimal.setText("Numero en hexadecimal: " + hex.toUpperCase());
            } catch (NumberFormatException ex) {
                resultatBinariDecimal.setText("Numero binari no vàlid!");
                resultatBinariHexadecimal.setText("");
            }
        });

        limpiarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                decField.setText("");
                binariAdecimal.setText("");
                resultatDecimalBinari.setText("RESULTAT EN BINARI: ");
                resultatDecimalHexadecimal.setText("RESULTAT EN HEXADECIMAL: ");
                resultatBinariDecimal.setText("RESULTAT EN DECIMAL: ");
                resultatBinariHexadecimal.setText("RESULTAT EN HEXADECIMAL: ");
            }
        });

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}
