package model;

import java.util.Random;

public class DiceRollGame {
    public static final int MAX_KEY = 6;
    public static final int MIN_KEY = 1;

    private GameState state;
    private int balance;
    private int key;
    private boolean showKeyOn;
    private int amountBetOddEven;
    private int amountBetRange;
    private String rangeGuess;
    private boolean odd;
    private WinState winOddEven;
    private WinState winRange;

    public DiceRollGame() {
        key = -1;
        showKeyOn = false;
        state = GameState.INIT;
        balance = 100;
        amountBetOddEven = 0;
        amountBetRange = 0;
        odd = true;
        rangeGuess = "1-2";
        winOddEven = WinState.NA;
        winRange = WinState.NA;
    }

    public void start() {
        key = generateNewKey();
        odd = true;
        rangeGuess = "1-2";
    }

    private int generateNewKey() {
        Random r = new Random();
        int newKey;
        do {
            newKey = r.nextInt(MIN_KEY, MAX_KEY + 1);
        } while (newKey == key);

        return newKey;
    }

    public void playOddEven() {
        if (amountBetOddEven == 0) {
            winOddEven = WinState.NA;
        } else {
            if (odd == true) {
                switch (key) {
                    case 1:
                        balance = balance + (amountBetOddEven * 2);
                        winOddEven = WinState.WIN;
                        break;
                    case 2:
                        balance = balance - amountBetOddEven;
                        winOddEven = WinState.LOSE;
                        break;
                    case 3:
                        balance = balance + (amountBetOddEven * 2);
                        winOddEven = WinState.WIN;
                        break;
                    case 4:
                        balance = balance - amountBetOddEven;
                        winOddEven = WinState.LOSE;
                        break;
                    case 5:
                        balance = balance + (amountBetOddEven * 2);
                        winOddEven = WinState.WIN;
                        break;
                    case 6:
                        balance = balance - amountBetOddEven;
                        winOddEven = WinState.LOSE;
                        break;
                }
            } else {
                switch (key) {
                    case 1:
                        balance = balance - amountBetOddEven;
                        winOddEven = WinState.LOSE;
                        break;
                    case 2:
                        balance = balance + (amountBetOddEven * 2);
                        winOddEven = WinState.WIN;
                        break;
                    case 3:
                        balance = balance - amountBetOddEven;
                        winOddEven = WinState.LOSE;
                        break;
                    case 4:
                        balance = balance + (amountBetOddEven * 2);
                        winOddEven = WinState.WIN;
                        break;
                    case 5:
                        balance = balance - amountBetOddEven;
                        winOddEven = WinState.LOSE;
                        break;
                    case 6:
                        balance = balance + (amountBetOddEven * 2);
                        winOddEven = WinState.WIN;
                        break;
                }
            }
        }
    }

    public void playRange() {
        if (amountBetRange == 0) {
            winRange = WinState.NA;
        } else {
            if (rangeGuess.equals("1-2")) {
                if (key == 1 || key == 2) {
                    balance = balance + (amountBetRange * 3);
                    winRange = WinState.WIN;
                } else {
                    balance = balance - amountBetRange;
                    winRange = WinState.LOSE;
                }
            } else if (rangeGuess.equals("3-4")) {
                if (key == 3 || key == 4) {
                    balance = balance + (amountBetRange * 3);
                    winRange = WinState.WIN;
                } else {
                    balance = balance - amountBetRange;
                    winRange = WinState.LOSE;
                }
            } else if (rangeGuess.equals("5-6")) {
                if (key == 5 || key == 6) {
                    balance = balance + (amountBetRange * 3);
                    winRange = WinState.WIN;
                } else {
                    balance = balance - amountBetRange;
                    winRange = WinState.LOSE;
                }
            }
        }

    }

    public void setRangeGuess(String rangeGuess) {
        this.rangeGuess = rangeGuess;
    }

    public void setState(GameState state) {
        this.state = state;
    }

    public GameState getState() {
        return state;
    }

    public void setShowKeyOn(boolean showKeyOn) {
        this.showKeyOn = showKeyOn;
    }

    public boolean isShowKeyOn() {
        return showKeyOn;
    }

    public int getBalance() {
        return balance;
    }

    public int getKey() {
        return key;
    }

    public boolean isOdd() {
        return odd;
    }

    public void setOdd(boolean odd) {
        this.odd = odd;
    }

    public void setAmountBetOddEven(int amountBetOddEven) {
        this.amountBetOddEven = amountBetOddEven;
    }

    public void setAmountBetRange(int amountBetRange) {
        this.amountBetRange = amountBetRange;
    }
    public WinState getWinOddEven() {
        return winOddEven;
    }
    public WinState getWinRange() {
        return winRange;
    }
    public int getAmountBetOddEven() {
        return amountBetOddEven;
    }
    public int getAmountBetRange() {
        return amountBetRange;
    }
    public String getRangeGuess() {
        return rangeGuess;
    }
}
