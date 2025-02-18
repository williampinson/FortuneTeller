import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Random;
/**
 * This class creates a JFrame that displays a fortune teller program.
 * The program displays a title, an image, a text area for fortunes, and two buttons.
 * The "Tell me my fortune!" button displays a random fortune from an array of fortunes.
 * The "Quit" button closes the program.
 */
public class FortuneTellerFrame extends JFrame
{
    JPanel mainPanel;
    JPanel iconPanel;
    JPanel displayPanel;
    JPanel controlPanel;

    JLabel titleLbl;
    ImageIcon icon;

    JTextArea fortuneTA;
    JScrollPane scroller;
    String[] fortunes = new String[15];
    int fortuneIndex;

    JButton fortuneBtn;
    JButton quitBtn;

    public FortuneTellerFrame() {

        loadFortunes();

        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;

        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        createIconPanel();
        createDisplayPanel();
        createControlPanel();

        add(mainPanel);
        setTitle("Fortune Teller");
        setSize(screenWidth / 2, screenHeight - 100);
        setLocation(screenWidth / 4, screenHeight / 16);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setVisible(true);

    }
    /**
     * Load the fortunes into the array
     */
    private void loadFortunes()
    {
        fortunes[0] = "You will discover that life is not fair.";
        fortunes[1] = "What is today but yesterday's tomorrow?";
        fortunes[2] = "This is a fortune.";
        fortunes[3] = "You will buy a house and it will fall into a sinkhole.";
        fortunes[4] = "Smile :)";
        fortunes[5] = "You will trip over your desk chair at 10:52 am on 2/15/2027.";
        fortunes[6] = "You will never stop stubbing your toe.";
        fortunes[7] = "You will step on a lego in the near future.";
        fortunes[8] = "The best time was yesterday. The second best is when you get to it.";
        fortunes[9] = "I suggest you floss your teeth!";
        fortunes[10] = "Don't forget that thing you forgot!";
        fortunes[11] = "Sleep is good. Not sleep is not good.";
        fortunes[12] = "Don't let it fall to the rock paper scissors of life.";
        fortunes[13] = "You will now be forced to breathe manually.";
        fortunes[14] = "Your jeans will snag on a door handle in the next two days.";
    }
    /**
     * Create the icon panel
     */
    private void createIconPanel()
    {
        iconPanel = new JPanel();
        icon = new ImageIcon("src/fortune.jpg");
        titleLbl = new JLabel(icon);
        titleLbl.setText("FORTUNE TELLER");
        titleLbl.setFont(new Font("Arial", Font.BOLD, 24));
        titleLbl.setVerticalTextPosition(JLabel.BOTTOM);
        titleLbl.setHorizontalTextPosition(JLabel.CENTER);
        iconPanel.add(titleLbl);
        mainPanel.add(iconPanel, BorderLayout.NORTH);
    }
    /**
     * Create the display panel
     */
    private void createDisplayPanel()
    {
        displayPanel = new JPanel();
        fortuneTA = new JTextArea(11,36);
        fortuneTA.setEditable(false);
        fortuneTA.setFont(new Font("Verdana", Font.PLAIN, 12));
        scroller = new JScrollPane(fortuneTA);
        displayPanel.add(scroller);
        mainPanel.add(displayPanel, BorderLayout.CENTER);
    }
    /**
     * Create the control panel
     */
    private void createControlPanel()
    {
        Random rnd = new Random();
        controlPanel = new JPanel();
        controlPanel.setLayout(new GridLayout(1,2));

        fortuneBtn = new JButton("Tell me my fortune!");
        fortuneBtn.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
        fortuneBtn.addActionListener((ActionEvent ae) ->
        {
            int newFortune = fortuneIndex;
            do {
                newFortune = rnd.nextInt(fortunes.length);
            } while (fortuneIndex == newFortune);
            fortuneIndex = newFortune;
            fortuneTA.append(fortunes[newFortune] + "\n");
        });

        quitBtn = new JButton("Quit");
        quitBtn.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
        quitBtn.addActionListener((ActionEvent ae) -> System.exit(0));

        controlPanel.add(fortuneBtn);
        controlPanel.add(quitBtn);
        mainPanel.add(controlPanel, BorderLayout.SOUTH);
    }
}