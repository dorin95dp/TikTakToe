package sample;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.shape.Line;
import javafx.util.Duration;

class WinCase {
    private Square[] squares;

    public WinCase(Square... squares) {
        this.squares = squares;
    }

    public boolean hasOccurred() {
        if (squares[0].getValue().isEmpty())
            return false;

        return squares[0].getValue().equals(squares[1].getValue())
                && squares[0].getValue().equals(squares[2].getValue());
    }

    static void playWinAnimation(WinCase winCase) {
        Line line = new Line();
        line.setStartX(winCase.squares[0].getCenterX());
        line.setStartY(winCase.squares[0].getCenterY());
        line.setEndX(winCase.squares[0].getCenterX());
        line.setEndY(winCase.squares[0].getCenterY());

        Main.root.getChildren().add(line);

        Timeline timeline = new Timeline();
        timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(1),
                new KeyValue(line.endXProperty(), winCase.squares[2].getCenterX()),
                new KeyValue(line.endYProperty(), winCase.squares[2].getCenterY())));
        timeline.play();
    }
}
