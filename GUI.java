import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Color.*;
import javax.swing.Timer;


/**
 *  Main Class
 * @author Chris Mailloux
 */
class Simon
{


    public static void main (String[] args)
    {

        window.setBackground(Color.BLACK); 
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // Static object creations.
    public static GameWindow window = new GameWindow();

    // Variable declarations.
    public static final String[] colors = {"Green", "Red", "Yellow", "Blue"};
    public static ArrayList<String> pattern = new ArrayList<String>();
    public static int currentScore = 0;
    public static int iterator = 0;
    public static boolean isPlayerTurn = false;
    public static int highScore = 0; // TEMPORARY
}

/**
 * Class for main game window.
 * @author Chris
 */
class GameWindow extends JFrame
{
    GameWindow()
    {
        // Set basic properties of frame.
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setTitle("Simon");
        setResizable(true);
        setLocation(DEFAULT_HORIZONTAL_LOCATION, DEFAULT_VERTICAL_LOCATION);
        // PLACEHOLDER FOR IMAGE ICON

        // Adding Border layout helper panel.
        BorderPanel borderPanel = new BorderPanel();
        add(borderPanel);
    }

    // Declaring window positioning constants.
    public static final int DEFAULT_WIDTH = 800;
    public static final int DEFAULT_HEIGHT = 800;

    // TEMPORARY PLACEHOLDER FOR SCREENSIZE CALCULATIONS
    public static final int DEFAULT_HORIZONTAL_LOCATION = 0;
    public static final int DEFAULT_VERTICAL_LOCATION = 0;
}

/**
 * Class to hold the buttonsPanel
 * @author Chris
 */
class ButtonsPanel extends JPanel
{

    // Creating JButtons for gameplay.
    public static JButton greenButton = new JButton();
    public static JButton redButton = new JButton();
    public static JButton yellowButton = new JButton();
    public static JButton blueButton = new JButton();

    ButtonsPanel()
    {

       setBackground(Color.BLACK); 

       // Setting grid layout (with spaces)
       setLayout(new GridLayout(2, 2, 20, 20)); 

       // Setting background color of buttons.
       greenButton.setBackground(Color.GREEN);  // NEED COLOR CONSTANTS
       redButton.setBackground(Color.RED);  
       yellowButton.setBackground(Color.YELLOW);    
       blueButton.setBackground(Color.BLUE);

       // Add buttons to panel. (In order)
        add(greenButton);
        add(redButton);
        add(yellowButton);
        add(blueButton);

       // Creating ActionListeners for 4 main buttons.
        ActionListener greenAction = new ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
                greenClicked();
            }
        };

        ActionListener redAction = new ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
                redClicked();
            }
        };

        ActionListener yellowAction = new ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
                yellowClicked();
            }
        };

        ActionListener blueAction = new ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
                blueClicked();
            }
        };

            // Associate actions with buttons.
        greenButton.addActionListener(greenAction);
        redButton.addActionListener(redAction);
        yellowButton.addActionListener(yellowAction);
        blueButton.addActionListener(blueAction);
    }

        public static final int delay = 400;

        // Handling button activations.
        public static void greenClicked()
        {
            // Handling button Coloring/timing.
            greenButton.setBackground(Color.WHITE);
            greenButton.repaint();

            ActionListener taskPerformer = new ActionListener() 
            {
                public void actionPerformed(ActionEvent evt) 
                {
                greenButton.setBackground(Color.GREEN);
                }
            };

            Timer timer = new Timer(delay, taskPerformer);
            timer.setRepeats(false);
            timer.start();

            // Handling button Action
            if(Game.isPlayerTurn == true)
            {
                Game.check("Green");
            }
        }

        public static void redClicked()
        {
            // Handling button color and timing.
            redButton.setBackground(Color.WHITE);
            redButton.repaint();

            ActionListener taskPerformer = new ActionListener() 
            {
                public void actionPerformed(ActionEvent evt) 
                {
                    redButton.setBackground(Color.RED);
                }
            };

            Timer timer = new Timer(delay, taskPerformer);
            timer.setRepeats(false);
            timer.start();

            // Handling button actions.
            if(Game.isPlayerTurn == true)
            {
                Game.check("Red");
            }
        }

        public static void yellowClicked()
        {

            // Handling button color and timing.
            yellowButton.setBackground(Color.WHITE);
            yellowButton.repaint();

            ActionListener taskPerformer = new ActionListener() 
            {
                public void actionPerformed(ActionEvent evt) 
                {
                    yellowButton.setBackground(Color.YELLOW);
                }
            };

            Timer timer = new Timer(delay, taskPerformer);
            timer.setRepeats(false);
            timer.start();

            // Handling button actions.
            if(Game.isPlayerTurn == true)
            {
                Game.check("Yellow");
            }
        }

        public static void blueClicked()
        { 
            // Handling button color and timing.
            blueButton.setBackground(Color.WHITE);
            blueButton.repaint();

            ActionListener taskPerformer = new ActionListener() 
            {
                public void actionPerformed(ActionEvent evt) 
                {
                    blueButton.setBackground(Color.BLUE);
                }
            };

            Timer timer = new Timer(delay, taskPerformer);
            timer.setRepeats(false);
            timer.start();

            // Handling button actions.
            if(Game.isPlayerTurn == true)
            {
                Game.check("Blue");  
            }
        }

}
/**
 * Menu buttons panel.
 * @author Chris Mailloux
 */
class MenuPanel extends JPanel    
{    

    static JButton startButton;
    static JButton scoreDisplay;
    static JButton highScoreDisplay;

    public MenuPanel()
    {
        setBackground(Color.BLACK);

        // Menu panel buttons.
        startButton = new JButton("Start");
        scoreDisplay = new JButton(String.valueOf(Simon.currentScore));
        highScoreDisplay = new JButton(String.valueOf(Simon.highScore));

        // Adding Buttons
        add(startButton);
        add(scoreDisplay);
        add(highScoreDisplay);

        // Setting background colors
        scoreDisplay.setBackground(Color.BLACK);
        highScoreDisplay.setBackground(Color.BLACK);
        startButton.setBackground(Color.BLUE);

        // Disabling displays
        scoreDisplay.setEnabled(false);
        highScoreDisplay.setEnabled(false);

        // ActionListeners for menu buttons.
        ActionListener startButtonAction = new ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
                Game.startGame();
            }
        };
        startButton.addActionListener(startButtonAction);

        startButton.setFocusable(false);
    }
 }

/**
 * Border Panel support class.
 * @author Chris Mailloux
 */
class BorderPanel extends JPanel
{

    BorderPanel()
    {
        setLayout(new BorderLayout());
        add(new MenuPanel(), BorderLayout.NORTH);
        add(new ButtonsPanel(), BorderLayout.CENTER);

    }
}
/**
* Main game logic class.
* @author Chris
*/
class Game extends Simon
{   

// Resets variables for new game.
public static void startGame()
{
    isPlayerTurn = false;
    pattern.clear();
    currentScore = 0;
    iterator = 0;

    gamePlay(); // Should Start game
}

public static void gamePlay()
{
    if (isPlayerTurn == false)
    {
        computerTurn();
    }
    else
    {
        playerTurn();
    }
}

public static void computerTurn()
{
    // Isn't working.
    ButtonsPanel.greenButton.setEnabled(false);
    ButtonsPanel.redButton.setEnabled(false);
    ButtonsPanel.yellowButton.setEnabled(false);
    ButtonsPanel.blueButton.setEnabled(false);

    iterator = 0; // So CPU can use iterator to show pattern.
    Random generator = new Random();
    int randInt = generator.nextInt(4);
    String randColor = colors[randInt];
    System.out.println(randColor); // For testing.
    pattern.add(new String(randColor));
    showPattern();
}

public static void playerTurn()
{
    iterator = 0;
    ButtonsPanel.greenButton.setEnabled(true);
    ButtonsPanel.redButton.setEnabled(true);
    ButtonsPanel.yellowButton.setEnabled(true);
    ButtonsPanel.blueButton.setEnabled(true);
}

/**
 * Handles scoring and checks inputs for correctness.
 * @author Chris Mailloux
 */
public static void check(String lastInput)
{
    if (lastInput.equals(pattern.get(iterator)))
    {
        iterator++;
        if(iterator > currentScore)
        {
            currentScore++;
            MenuPanel.scoreDisplay.repaint();
            if(currentScore > highScore)
            {
                highScore++;
                // PLACEHOLDER TO WRITE HIGHSCORE TO FILE.
            }
        }
        if (iterator == pattern.size());
        {
            isPlayerTurn = false;
            computerTurn();
        }
    }
    else
    {
        gameOver();
    }
}

public static void showPattern()
{
    int j = 0;
    while (j < pattern.size())
    {
        String showerHelper = pattern.get(j); // Helper variable.
        switch (showerHelper)
        {
            case "Green" : ButtonsPanel.greenClicked();
            case "Red" : ButtonsPanel.redClicked();
            case "Yellow" : ButtonsPanel.yellowClicked();
            case "Blue" : ButtonsPanel.blueClicked();
            break; // Fallthrough handler.
            default: System.out.println("Error: Invalid value for pattern"
                    + " ArrayList, or improper storage of variable in the"
                    + " showerHelper variable.");
        }
        j++;
    }
    isPlayerTurn = true;
    gamePlay();
}

public static void gameOver()
{
    System.out.println("YOU LOSE!");
    // PLACEHOLDER TO PLAY GAMEOVER SOUND
}

} // End of game class.
