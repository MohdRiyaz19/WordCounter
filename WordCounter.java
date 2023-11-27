import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class WordCounterApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Word Counter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JTextArea textArea = new JTextArea(10, 40);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        JLabel wordLabel = new JLabel("Words: 0");
        JLabel charLabel = new JLabel("Characters: 0");
        JLabel paraLabel = new JLabel("Paragraphs: 0");

        JButton countButton = new JButton("Count");

        countButton.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                String text = textArea.getText();
                int wordCount = countWords(text);
                int charCount = text.length();
                int paraCount = countParagraphs(text);

                wordLabel.setText("Words: " + wordCount);
                charLabel.setText("Characters: " + charCount);
                paraLabel.setText("Paragraphs: " + paraCount);
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        panel.add(textArea);
        panel.add(countButton);
        panel.add(wordLabel);
        panel.add(charLabel);
        panel.add(paraLabel);

        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }

    public static int countWords(String text) {
        String[] words = text.split("\\s+");
        return words.length;
    }

    public static int countParagraphs(String text) {
        String[] paragraphs = text.split("\n\n");
        return paragraphs.length;
    }
}
