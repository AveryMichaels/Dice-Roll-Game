package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;

import controller.NumberRangeListener;
import controller.OddEvenButtonListener;
import controller.OddEvenComboBoxListener;
import controller.PlayListener;
import controller.QuitListener;
import controller.App;
import controller.NewGameListener;
import controller.NumberRangeComboBoxListener;
import controller.ShowKeyButtonListener;

public class AppWindow extends JFrame{

    public static final String oddButtonAction = "Odd";
    public static final String evenButtonAction = "Even";
    public static final String oneTwoButtonAction = "1-2";
    public static final String threeFourButtonAction = "3-4";
    public static final String fiveSixButtonAction = "5-6";
    public static final String[] qtyList = new String[] {
        "Choose Amount", "$10", "$20", "$30"
    };

    private AppCanvas canvas = new AppCanvas();
    private JRadioButton oddButton;
    private JRadioButton evenButton;
    private JRadioButton oneTwoButton;
    private JRadioButton threeFourButton;
    private JRadioButton fiveSixButton;
    private JButton playButton = new JButton("Play");
    private JButton newGameButton = new JButton("New Game");
    private JButton quitButton = new JButton("Quit");
    private JCheckBox showKeyButton = new JCheckBox("Show Key");
    private JComboBox<String> oddEvenComboBox = new JComboBox<>();
    private JComboBox<String> numberRangeComboBox = new JComboBox<>();
    
    public void init() {
        Container cp = getContentPane();
        cp.add(canvas, BorderLayout.CENTER);

        //oddEvenBetPanel
        JPanel oddEvenBetPanel = new JPanel();
        oddEvenBetPanel.setBorder(new TitledBorder("Bet on Odd/Even (2x winnings)"));
        ButtonGroup oddEvenGroup = new ButtonGroup();
        oddButton = new JRadioButton(oddButtonAction, true);
        evenButton = new JRadioButton(evenButtonAction);
        oddEvenGroup.add(oddButton);
        oddEvenGroup.add(evenButton);
        oddEvenBetPanel.add(oddButton);
        oddEvenBetPanel.add(evenButton);
        OddEvenButtonListener oddEvenListener = new OddEvenButtonListener();
        oddButton.addActionListener(oddEvenListener);
        evenButton.addActionListener(oddEvenListener);

        for(var q : qtyList) {
            oddEvenComboBox.addItem(q);
        }
        oddEvenBetPanel.add(oddEvenComboBox);
        OddEvenComboBoxListener oddEvenComboBoxListener = new OddEvenComboBoxListener();
        oddEvenComboBox.addItemListener(oddEvenComboBoxListener);

        //numberRangeBetPanel
        JPanel numberRangeBetPanel = new JPanel();
        numberRangeBetPanel.setBorder(new TitledBorder("Bet on Number Range (3x winnings)"));
        ButtonGroup numberRangeGroup = new ButtonGroup();
        oneTwoButton = new JRadioButton(oneTwoButtonAction, 
            App.game.getRangeGuess().equals("1-2"));
        threeFourButton = new JRadioButton(threeFourButtonAction, 
            App.game.getRangeGuess().equals("3-4"));
        fiveSixButton = new JRadioButton(fiveSixButtonAction, 
            App.game.getRangeGuess().equals("5-6"));
        numberRangeGroup.add(oneTwoButton);
        numberRangeGroup.add(threeFourButton);
        numberRangeGroup.add(fiveSixButton);
        numberRangeBetPanel.add(oneTwoButton);
        numberRangeBetPanel.add(threeFourButton);
        numberRangeBetPanel.add(fiveSixButton);
        NumberRangeListener numberListener = new NumberRangeListener();
        oneTwoButton.addActionListener(numberListener);
        threeFourButton.addActionListener(numberListener);
        fiveSixButton.addActionListener(numberListener);

        for(var q : qtyList) {
            numberRangeComboBox.addItem(q);
        }
        numberRangeBetPanel.add(numberRangeComboBox);
        NumberRangeComboBoxListener numberRangeComboBoxListener = new NumberRangeComboBoxListener();
        numberRangeComboBox.addItemListener(numberRangeComboBoxListener);

        //playGamePanel
        JPanel playGamePanel = new JPanel();
        playGamePanel.setBorder(new TitledBorder("Play / New Game"));
        playGamePanel.add(playButton);
        playGamePanel.add(newGameButton);
        playGamePanel.add(quitButton);
        NewGameListener newGameListener = new NewGameListener();
        PlayListener playListener = new PlayListener();
        QuitListener quitListener = new QuitListener();

        playButton.addActionListener(playListener);
        newGameButton.addActionListener(newGameListener);
        quitButton.addActionListener(quitListener);

        //showKeyPanel
        JPanel showKeyPanel = new JPanel();
        showKeyPanel.setBorder(new TitledBorder("Show Key"));
        showKeyPanel.add(showKeyButton);
        showKeyButton.addItemListener(new ShowKeyButtonListener());

        //south panel
        JPanel southPanel = new JPanel();
        southPanel.setLayout(new GridLayout(4, 1));
        southPanel.add(oddEvenBetPanel);
        southPanel.add(numberRangeBetPanel);
        southPanel.add(playGamePanel);
        southPanel.add(showKeyPanel);

        cp.add(southPanel, BorderLayout.SOUTH);

        updateWindow();
    }

    public void updateWindow() {
        switch(App.game.getState()) {
            case INIT:
            case OVER:
                newGameButton.setEnabled(true);
                quitButton.setEnabled(true);
                oddButton.setEnabled(false);
                evenButton.setEnabled(false);
                oddEvenComboBox.setEnabled(false);
                oneTwoButton.setEnabled(false);
                threeFourButton.setEnabled(false);
                fiveSixButton.setEnabled(false);
                numberRangeComboBox.setEnabled(false);
                playButton.setEnabled(false);
                showKeyButton.setEnabled(false);
                break;
            case PLAYING:
                newGameButton.setEnabled(false);
                quitButton.setEnabled(true);
                oddButton.setEnabled(true);
                evenButton.setEnabled(true);
                oddEvenComboBox.setEnabled(true);
                oneTwoButton.setEnabled(true);
                threeFourButton.setEnabled(true);
                fiveSixButton.setEnabled(true);
                numberRangeComboBox.setEnabled(true);
                playButton.setEnabled(true);
                showKeyButton.setEnabled(true);
                oddButton.setSelected(true);
                oneTwoButton.setSelected(true);
                oddEvenComboBox.setSelectedIndex(0);
                numberRangeComboBox.setSelectedIndex(0);
                break;
        }
        repaint();
    }

    public void repaintCanvas() {
        canvas.repaint();
    }
}
