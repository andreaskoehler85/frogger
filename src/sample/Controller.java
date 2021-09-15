package sample;

import javafx.animation.PathTransition;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class Controller {
    // Objekt kommt aus der fxml-Datei
    @FXML
    private Pane game;

    private Avatar frog;
    private ImageView car1;
    private ImageView tree;

    private Rectangle dangerzone;

    private static PathTransition t;
    private static PathTransition t2;
    private Line line = new Line(850, 690, -100, 690);
    private Line line2 = new Line(850, 350, -100, 350);
    //Color c = Color.BLUE;

    Color c = Color.web("0x0000FF",0.0);


    @FXML
    private void initialize(){
        car1 = new ImageView("image/car_red_40.png");
        tree = new ImageView("image/car_green_40_r.png");
        frog = new Avatar("image/frog_50_38_lila.png", 0.0, 720.0);
        dangerzone = new Rectangle(0,115,800,260);
//        dangerzone.setX(0);
//        dangerzone.setY(115);
//        dangerzone.setWidth(800);
//        dangerzone.setHeight(260);
        dangerzone.setFill(c);
        game.getChildren().add(dangerzone);
        game.getChildren().add(frog);
        game.getChildren().add(car1);
        game.getChildren().add(tree);
        frog.setFocusTraversable(true);

        // Transition
        t = new PathTransition();
        t.setDuration(Duration.millis(5000));
        t.setNode(car1);
        t.setPath(line);
        t.setCycleCount(PathTransition.INDEFINITE);
        t.play();
        t2 = new PathTransition();
        t2.setDuration(Duration.millis(10000));
        t2.setNode(tree);
        t2.setPath(line2);
        t2.setCycleCount(PathTransition.INDEFINITE);
        t2.play();

        // Eventhandler
        frog.addEventHandler(KeyEvent.KEY_PRESSED,
                keyEvent -> {
                    switch (keyEvent.getCode()){
                        case UP:
                            frog.moveUp();
                            if(frog.intersects(car1.getBoundsInParent()) ||
                                    frog.intersects(dangerzone.getBoundsInParent()) ) {
                                collision();
                            }
                            break;
                        case DOWN:
                            frog.moveDown();
                            if(frog.intersects(car1.getBoundsInParent()) ||
                                    frog.intersects(dangerzone.getBoundsInParent())) {
                                collision();
                            }
                            break;
                        case LEFT:
                            frog.moveLeft();
                            if(frog.intersects(car1.getBoundsInParent()) ) {
                                collision();
                            }
                            break;
                        case RIGHT:
                            frog.moveRight();
                            if(frog.intersects(car1.getBoundsInParent()) ) {
                                collision();
                            }
                            break;
                    }

                } );

        // ChangeListener
        car1.translateXProperty().addListener(
                (observableValue, oldValue, newValue) -> {
                    collision2(frog,car1);
                }

        );
    }

    public static void ausgabe(){
        System.out.println("Funktioniert");
    }

    public static boolean collision(){
        System.out.println("getroffen");
        t.pause();
        return false;
    }

    public static void collision2(Avatar frog, ImageView car1){
        if(frog.intersects(car1.getBoundsInParent()) ) {
            t.pause();
        }



    }

}
