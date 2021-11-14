package sample;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Car{
    ImageView imageView;
    int posX;
    int posY;
    Car(Image image,int posX,int posY) {
        this.imageView = new ImageView(image);
        this.posX = posX;
        this.posY = posY;
    }
    void draw(Group root) {
        root.getChildren().add(imageView);
        imageView.setX(posX);
        imageView.setY(posY);
        imageView.setScaleX(0.2);
        imageView.setScaleY(0.2);
    }
}
