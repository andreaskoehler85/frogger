package sample;

import javafx.scene.image.ImageView;

public class Avatar extends ImageView  {
//    private double startX;  auskom da im Konstruktor
//    private double startY;

    Avatar(String url, double startX, double startY){
        super(url);
        this.setY(startY);
        this.setX(startX);
    }

    void moveUp(){
        System.out.println("Y: "+ this.getY() +"\nX: "+ this.getX());
        if(this.getY()>110){
            this.setY(this.getY()-55);
        }

    }
    void moveDown(){
        System.out.println("Y: "+ this.getY() +"\nX: "+ this.getX());
        if(this.getY()<715) {
            this.setY(this.getY() + 55);
        }
    }
    void moveLeft(){
        System.out.println("Y: "+ this.getY() +"\nX: "+ this.getX());
        if(this.getX()>50) {
            this.setX(this.getX() - 55);
        }
    }
    void moveRight(){
        System.out.println("Right");
        if(this.getX()<715) {

            this.setX(this.getX() + 55);
        }
    }
}
