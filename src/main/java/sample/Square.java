package sample;

import javafx.geometry.Pos;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

class Square extends StackPane {
    private Text text = new Text();
    private static boolean playable = true;
    private static boolean turnX = true;
    private boolean isSquareSelected = false;

    public Square() {
        Rectangle border = new Rectangle(200, 200);
        border.setFill(null);
        border.setStroke(Color.BLACK);
        text.setFont(Font.font(72));
        setAlignment(Pos.CENTER);
        getChildren().addAll(border, text);


        setOnMouseClicked(event -> {
            if (!playable)
                return;
            if (event.getButton() == MouseButton.PRIMARY) {
                if (!turnX || isSquareSelected)
                    return;
                drawX();
                turnX = false;
                checkState();
                setSquareSelected();
            } else if (event.getButton() == MouseButton.SECONDARY) {
                if (turnX || isSquareSelected)
                    return;
                drawO();
                turnX = true;
                checkState();
                setSquareSelected();
            }
        });
    }

    private void setSquareSelected () {
        isSquareSelected = true;
    }

    public double getCenterX() {
        return getTranslateX() + 100;
    }

    public double getCenterY() {
        return getTranslateY() + 100;
    }

    public String getValue() {
        return text.getText();
    }

    private void drawX() {
        text.setText("X");
    }

    private void drawO() {
        text.setText("O");
    }

    private void checkState() {
        for (WinCase winCase : Main.winCases) {
            if (winCase.hasOccurred()) {
                System.out.println("You won");
                playable = false;
                WinCase.playWinAnimation(winCase);
                break;
            }
        }
    }
}
