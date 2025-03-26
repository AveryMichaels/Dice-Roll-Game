package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import javax.swing.JPanel;

import controller.App;
import model.DiceRollGame;
import model.WinState;

public class AppCanvas extends JPanel {
    public static int WIDTH = 300;
    public static int HEIGHT = 300;

    public AppCanvas() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        switch(App.game.getState()) {
            case INIT:
                drawInitCanvas(g2);
                break;
            case PLAYING:
                drawPlayingCanvas(g2);
                break;
            case OVER:
                drawOverCanvas(g2);
                break;
        }
    }
    private void drawInitCanvas(Graphics2D g2) {
        g2.setFont(new Font("Courier New", Font.BOLD, 16));
        g2.setColor(Color.BLUE);
        var message1 = "Welcome to Dice Roll Game";
        var message2 = "Press <New Game> to start";
        g2.drawString(message1, 20, 100);
        g2.drawString(message2, 20, 140);
        g2.setColor(Color.BLACK);
        var balanceMessage = String.format("Balance: %d", 
            App.game.getBalance());
        g2.drawString(balanceMessage, 160, 20);
    }
    private void drawPlayingCanvas(Graphics2D g2) {
        g2.setFont(new Font("Courier New", Font.BOLD, 16));
        DiceRollGame game = App.game;

        if(game.isShowKeyOn()) {
            var keyString = String.format("Key: %d",
                game.getKey());
            g2.drawString(keyString, 20, 20);
        }

        var balanceMessage = String.format("Balance: %d", 
            App.game.getBalance());
        g2.drawString(balanceMessage, 160, 20);

        Ellipse2D.Double circle = new Ellipse2D.Double(60, 60, 180, 180);
        g2.setColor(Color.YELLOW);
        g2.fill(circle);

        g2.setFont(new Font("Courier New", Font.BOLD, 120));
        g2.setColor(Color.BLACK);
        var questionMark = "?";
        g2.drawString(questionMark, 115, 180);
    }
    private void drawOverCanvas(Graphics2D g2) {
        g2.setFont(new Font("Courier New", Font.BOLD, 16));
        DiceRollGame game = App.game;

        Ellipse2D.Double circle = new Ellipse2D.Double(60, 60, 180, 180);
        g2.setColor(Color.YELLOW);
        g2.fill(circle);

        g2.setColor(Color.RED);
        String message1 = "";
        String message2 = "";
        
        game.playOddEven();
        game.playRange();
        if(game.getWinOddEven() == WinState.WIN) {
            message1 = String.format("Won on %s: +$%d", 
                game.isOdd()? AppWindow.oddButtonAction : AppWindow.evenButtonAction, game.getAmountBetOddEven());
        } else if(game.getWinOddEven() == WinState.LOSE) {
            message1 = String.format("Lost on Odd/Even: -$%d",
                game.getAmountBetOddEven());
        } else if (game.getWinOddEven() == WinState.NA) {
            message1 = "No Bet on Odd/Even";
        }
        if(game.getWinRange() == WinState.WIN) {
            message2 = String.format("Won on Range: +$%d",
                game.getAmountBetRange());
        } else if(game.getWinRange() == WinState.LOSE) {
            message2 = String.format("Lost on Range -$%d", 
                game.getAmountBetRange());
        } else if (game.getWinRange() == WinState.NA) {
            message2 = "No Bet on Range";
        }
        g2.setColor(Color.RED);
        g2.drawString(message1, 20, 200);
        g2.drawString(message2, 20, 225);


        g2.setColor(Color.BLACK);
        if(game.isShowKeyOn()) {
            var keyString = String.format("Key: %d",
                game.getKey());
            g2.drawString(keyString, 20, 20);
        }

        var balanceMessage = String.format("Balance: %d", 
            App.game.getBalance());
        g2.drawString(balanceMessage, 160, 20);

        g2.setFont(new Font("Courier New", Font.BOLD, 120));
        g2.setColor(Color.BLACK);
        var key = String.format("%d", game.getKey());
        g2.drawString(key, 115, 180);
    }
}