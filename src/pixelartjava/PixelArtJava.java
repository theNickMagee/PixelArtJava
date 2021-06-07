/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pixelartjava;

import pixelartjava.buttons.ProjectButton;
import pixelartjava.buttons.Button;
import java.util.ArrayList;
import processing.core.PApplet;

/**
 *
 * help for processing library in java:
 * https://happycoding.io/tutorials/java/processing-in-java
 *
 */
public class PixelArtJava extends PApplet {

    public static void main(String[] args) {
        String[] processingArgs = {"PixelArtJava"};
        PixelArtJava pixelArt = new PixelArtJava();
        PApplet.runSketch(processingArgs, pixelArt);
    }

    private ButtonManager buttonManager;

    //private boolean darkMode = false;
    //ArrayList<Canvas> canvasList;
    //Canvas workingCanvas;
    int canvas_x, canvas_y, canvas_w, canvas_h;

    boolean canvasCreated;

    //ArrayList<Key> listeningKeys;
    int colSel_x = 550;
    int colSel_y = 550;
    int colSel_w = 400;
    int colSel_h = 240;

    //ColorSelector colorSelector;
    public void settings() {
        size(1000, 800);

        buttonManager = new ButtonManager(this);

        buttonManager.createStartingButtons();

//
//        canvasList = new ArrayList<Canvas>();
//
//        canvas_x = 200;
//        canvas_y = 20;
//        canvas_w = 700;
//        canvas_h = 500;
        canvasCreated = false;

//        listeningKeys = new ArrayList<Key>();
//
//        colorSelector = new ColorSelector(700, 550, 200, 200);
    }

    public void draw() {

        background(255);

        buttonManager.run();

        //colorSelector.display();
//          for (Button b : buttonList){
//            b.display();
//          }
//
//          if (canvasCreated){
//            workingCanvas.display();
//          }
    }

    public void mouseClicked() {
//        for (Button b : buttonList) {
//            b.wasClicked();
//        }
    }

    public void mouseReleased() {
//          if (canvasCreated){
//            workingCanvas.handleRelease();
//          }
    }

    public void keyReleased() {
        String c = "";

        if (key == CODED) {
            if (keyCode == UP) {
                c = "UP";
            }
            if (keyCode == DOWN) {
                c = "DOWN";
            }
            if (keyCode == LEFT) {
                c = "LEFT";
            }
            if (keyCode == RIGHT) {
                c = "RIGHT";
            }
            if (keyCode == SHIFT) {
                c = "SHIFT";
            }
        } else {
            c = str(key);
        }
//            for (Key k : listeningKeys){
//              if (k.modes.contains("RELEASED")){
//               k.checkRelease(c);
//              }
//            }
    }

    public void keyPressed() {
        String c = "";

        if (key == CODED) {
            if (keyCode == UP) {
                c = "UP";
            }
            if (keyCode == DOWN) {
                c = "DOWN";
            }
            if (keyCode == LEFT) {
                c = "LEFT";
            }
            if (keyCode == RIGHT) {
                c = "RIGHT";
            }
            if (keyCode == SHIFT) {
                c = "SHIFT";
            }
        } else {
            c = str(key);
        }

//            for (Key k : listeningKeys){
//               k.checkPress(c);
//            }
    }
}
