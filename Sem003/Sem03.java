package semwork.sem03;

import javafx.animation.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Alert;
import javafx.scene.effect.Lighting;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import sample.MyApplication1;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Юра on 15.05.2016.
 */
public class Sem03 extends Application {
    private final int WINDOW_WIDTH = 600;
    private final int WINDOW_HEIGHT = 600;
    private Node enemy;
    private double enemyX;
    private double enemyY;
    private int enemyR = 10;
    private Node player;
    private double playerX;
    private double playerY;
    private double playerR = 15;
    private AnimationTimer results;
    Random random;   // ссылка на объект, который будем перетаскивать
    private Text textResults;


    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("SemWork03");
        primaryStage.setScene(createScene());
        primaryStage.show();
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Кликай по окну, чтобы догнать зеленый кружок.");
                alert.showAndWait();
            }
        });
    }

    private Scene createScene() {
        random = new Random();
        Group group = new Group();
        Canvas canvas = createCanvas();
        group.getChildren().add(canvas);
        Circle enemy = createEnemy();
        StackPane enemyPane = createStackPane(enemy, "X", enemyX, enemyY, Color.BLUE);
        this.enemy = enemyPane;
        group.getChildren().add(enemyPane);
        Circle player = createPlayerCircle();
        StackPane stack = createStackPane(player, "You", playerX, playerY, Color.BLACK);
        group.getChildren().add(stack);
        this.player = stack;
        results = createResulter();
        return new Scene(group, WINDOW_WIDTH, WINDOW_HEIGHT);
    }

    private StackPane createStackPane(Circle circle, String text, double x, double y, Color color) {
        StackPane stack = new StackPane();
        textResults = new Text(text);
        textResults.setStroke(color);
        stack.getChildren().addAll(circle, textResults);
        stack.setLayoutX(x);
        stack.setLayoutY(y);
        return stack;
    }

    private Circle createEnemy() {
        Circle enemy = new Circle(enemyR, Color.rgb(0, 255, 0));
        enemyX = random.nextInt(WINDOW_WIDTH - 40) + 20;
        enemyY = random.nextInt(WINDOW_HEIGHT / 2 - 40) + 20 + WINDOW_HEIGHT / 2;
        enemy.setLayoutX(enemyX);
        enemy.setLayoutY(enemyY);
        enemy.setEffect(new Lighting());
        return enemy;
    }

    private void generateEnemyLayout() {
        enemyX = random.nextInt(WINDOW_WIDTH - 40) + 20;
        enemyY = random.nextInt(WINDOW_HEIGHT - 40) + 20;
    }

    private Circle createPlayerCircle() {
        Circle circle = new Circle(playerR, Color.rgb(156, 216, 255));
        playerX = random.nextInt(WINDOW_WIDTH - 40) + 20;
        playerY = random.nextInt(WINDOW_HEIGHT / 2 - 40) + 20;
        circle.setLayoutX(playerX);
        circle.setLayoutY(playerY);
        circle.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
            }
        });
        circle.setEffect(new Lighting());
        return circle;
    }

    int i = 0;

    private AnimationTimer createResulter() {
        return new AnimationTimer() {
            @Override
            public void handle(long l) {
                i++;
                textResults.setText(count + "");

                if (count >= 40 && i >70) {
                    i = 0;
                    timerTask();
                } else {
                    if (count >= 30 && i> 150) {
                        i = 0;
                        timerTask();
                    } else {
                        if (count >= 20 && i > 230) {
                            i = 0;
                            timerTask();
                        } else {
                            if (count >= 10 && i > 300) {
                                i = 0;
                                timerTask();
                            }
                        }
                    }
                }
            }

        };
    }

    public void timerTask() {
        FadeTransition transition = new FadeTransition(Duration.millis(100), enemy);
        transition.setFromValue(1);
        transition.setToValue(0);
        transition.setAutoReverse(false);
        transition.play();
        generateEnemyLayout();
        transition.stop();
        enemy.setLayoutX(enemyX);
        enemy.setLayoutY(enemyY);
        transition.setFromValue(0);
        transition.setToValue(1);
        transition.play();
    }

    private int count = 0;

    private Canvas createCanvas() {
        Canvas canvas = new Canvas(WINDOW_WIDTH, WINDOW_HEIGHT);
        canvas.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (count == 0) {
                    results.start();
                }else{
                    if (count == 50){
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Ты выиграл.");
                                alert.showAndWait();
                                try {
                                    Sem03.this.stop();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                    }
                }
                Timeline timeline = new Timeline();
                timeline.setAutoReverse(true);
                timeline.setDelay(Duration.millis(10));
                playerX = player.getLayoutX() + (mouseEvent.getSceneX() - player.getLayoutX()) * 0.4;
                KeyValue kv = new KeyValue(player.layoutXProperty(), playerX);
                playerY = player.getLayoutY() + (mouseEvent.getSceneY() - player.getLayoutY()) * 0.4;
                KeyValue kv1 = new KeyValue(player.layoutYProperty(), playerY);

                KeyFrame kf = new KeyFrame(Duration.millis(200), kv);
                KeyFrame kf1 = new KeyFrame(Duration.millis(200), kv1);

                timeline.getKeyFrames().add(kf);
                timeline.getKeyFrames().add(kf1);
                double d = Math.sqrt(Math.pow(playerX + playerR / 2 - enemyX, 2) + Math.pow(playerY + playerR / 2 - enemyY, 2));
                if (d < enemyR + playerR) {
                    Timeline timeline1 = new Timeline();
                    timeline1.setAutoReverse(true);
                    timeline1.setDelay(Duration.millis(100));
                    generateEnemyLayout();
                    KeyValue kv11 = new KeyValue(enemy.layoutXProperty(), enemyX);
                    KeyValue kv12 = new KeyValue(enemy.layoutYProperty(), enemyY);
                    timeline1.getKeyFrames().add(new KeyFrame(Duration.millis(1), kv11));
                    timeline1.getKeyFrames().add(new KeyFrame(Duration.millis(1), kv12));
                    SequentialTransition transition = new SequentialTransition(getScale(), timeline, timeline1, getFade());
                    transition.play();
                    count++;

                } else {
                    timeline.play();
                }
            }
        });
        return canvas;
    }

    private ScaleTransition getScale() {
        ScaleTransition scale = new ScaleTransition(Duration.ZERO, player);
        scale.setAutoReverse(true);
        scale.setByX(0.05);
        scale.setByY(0.05);
        playerR *= 1.05;
        System.out.println(playerR);
        return scale;
    }

    private FadeTransition getFade() {
        FadeTransition fade2 = new FadeTransition(Duration.millis(1000), enemy);
        fade2.setAutoReverse(false);
        fade2.setFromValue(0);
        fade2.setToValue(1);
        return fade2;
    }

    public static void main(String[] args) {
        launch(args);
    }

}
