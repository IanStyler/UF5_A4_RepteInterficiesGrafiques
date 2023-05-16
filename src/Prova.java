import javax.swing.*;

public class Prova {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Decimal a binari");
        JLabel decLabel = new JLabel("Numero en decimal a resoldre: ");
        JLabel resultatDecimalBinari = new JLabel("RESOLTAT EN BINARI: ");
        JTextField decField = new JTextField(20);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        JLabel numBinariLabel = new JLabel("Numero en binari a resoldre: ");
        JLabel resultatBinariDecimal = new JLabel("RESOLTAT EN DECIMAL: ");
        JTextField binariAdecimal = new JTextField(20);

        decField.setColumns(35);
        binariAdecimal.setColumns(35);

        decField.setMaximumSize(decField.getPreferredSize());
        binariAdecimal.setMaximumSize(binariAdecimal.getPreferredSize());

        panel.add(decLabel);
        panel.add(decField);
        panel.add(resultatDecimalBinari);
        panel.add(numBinariLabel);
        panel.add(binariAdecimal);
        panel.add(resultatBinariDecimal);

        decField.addActionListener(e -> {
            String decStr = decField.getText();
            try {
                int dec = Integer.parseInt(decStr);
                String bin = Integer.toBinaryString(dec);
                resultatDecimalBinari.setText("Numero en binari: " + bin);
            } catch (NumberFormatException ex) {
                resultatDecimalBinari.setText("Numero decimal no vàlid!");
            }
        });

        binariAdecimal.addActionListener(e -> {
            String binStr = binariAdecimal.getText();
            try {
                int dec = Integer.parseInt(binStr, 2);
                resultatBinariDecimal.setText("Numero en decimal: " + dec);
            } catch (NumberFormatException ex) {
                resultatBinariDecimal.setText("Numero binari no vàlid!");
            }
        });

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}
