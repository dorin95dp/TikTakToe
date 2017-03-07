package sample;

import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

    static Square[][] board = new Square[3][3];
    static List<WinCase> winCases = new ArrayList<>();
    static Pane root = new Pane();

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Tik Tak Toe by Dorin");
        primaryStage.setScene(new Scene(createAppContent()));
        primaryStage.show();
    }

    private Parent createAppContent() {
        root.setPrefSize(600, 600);
        setRootSquares();
        fillWinCases();

        return root;
    }

    private void setRootSquares() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Square square = new Square();
                square.setTranslateX(j * 200);
                square.setTranslateY(i * 200);

                root.getChildren().add(square);

                board[j][i] = square;
            }
        }
    }

    private void fillWinCases() {
        // horizontal
        for (int y = 0; y < 3; y++) {
            winCases.add(new WinCase(board[0][y], board[1][y], board[2][y]));
        }

        // vertical
        for (int x = 0; x < 3; x++) {
            winCases.add(new WinCase(board[x][0], board[x][1], board[x][2]));
        }

        // diagonals
        winCases.add(new WinCase(board[0][0], board[1][1], board[2][2]));
        winCases.add(new WinCase(board[2][0], board[1][1], board[0][2]));
    }

    public static void main(String[] args) {

        launch(args);
    }
}