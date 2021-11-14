package sample;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {
    Car car;
    int velX = 10;
    int velY = 0;

    @Override
    public void start(Stage stage) {
        Image image= new Image("file:///C:\\Users\\Nursultan\\Downloads\\car5.png");
        Group root = new Group();
        Scene scene = new Scene(root, Color.rgb(22,232,150));
        root.setLayoutX(0);
        root.setLayoutY(0);
        stage.setWidth(1100);
        stage.setHeight(950);
        stage.setScene(scene);
        stage.setTitle("Car");
        car = new Car(image,-200,-100);
        car.draw(root);
        stage.show();
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.05),e-> checkBorders()));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();

    }
    void checkBorders() {
        int x = (int) car.imageView.getX();
        int y = (int) car.imageView.getY();
        if (x < 700 && y == -100){
            velX = 10;
            velY = 0;
            car.imageView.setRotate(0);
        }else if(y < 700 && x == 700){
            velX = 0;
            velY = 10;
            car.imageView.setRotate(90);
        }else if(y == 700 && x > -200){
            velX = -10;
            velY = 0;
            car.imageView.setRotate(180);
        }else if(x == -200 && y > -100){
            velX = 0;
            velY = -10;
            car.imageView.setRotate(270);
        }
        move();
    }
    void move() {
        car.imageView.setX(car.imageView.getX() + velX);
        car.imageView.setY(car.imageView.getY() + velY);
    }

    public static void main(String[] args) {
        launch(args);
    }

}
