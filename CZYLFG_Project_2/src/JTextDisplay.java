
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;


/*
 * @author "Connor Stewart 17982915"
 */
public class JTextDisplay extends JFrame {

    public JTextArea jtArea;
    public JFrame frame;
    public JFileChooser fc;
    public Toolkit tk;
    public JButton readButton;
    public File file;
    public BufferedReader selectedFileToRead;
    public JScrollPane scrollPane;

    public JTextDisplay() {

        frame = new JFrame();
        this.pack();
        fc = new JFileChooser();
        tk = Toolkit.getDefaultToolkit();

        Dimension screenSize = tk.getScreenSize();
        int userScreenWidth = screenSize.width / 2;
        int userScreenHeight = screenSize.height / 2;
        jtArea = new JTextArea(userScreenWidth, userScreenHeight);
        scrollPane = new JScrollPane(jtArea);
        scrollPane.setBounds(30, 40, 100, 100);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        readButton = new JButton("OPEN FILE");
        readButton.addActionListener(ev -> {
            int returnValue = fc.showOpenDialog(frame);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                file = fc.getSelectedFile();
                try {
                    selectedFileToRead = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
                    jtArea.read(selectedFileToRead, "Reading file");
                } catch (IOException e) {
                    System.out.println("IOException");
                }
            } else {
                System.out.println("Failed");
            }
        });

        this.getContentPane().add(jtArea, BorderLayout.CENTER);
        this.getContentPane().add(readButton, BorderLayout.PAGE_END);
        this.setSize(userScreenWidth, userScreenHeight);
        this.getContentPane().add(scrollPane);
        scrollPane.setViewportView(jtArea);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        JTextDisplay f = new JTextDisplay();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

}
