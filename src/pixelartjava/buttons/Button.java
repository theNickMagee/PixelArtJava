/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pixelartjava.buttons;

import java.util.ArrayList;
import pixelartjava.ButtonManager;
import processing.core.PApplet;
import static processing.core.PConstants.CENTER;
import static processing.core.PConstants.CORNER;
import processing.core.PImage;

//parent button just allows to click inside and is clicked
//can either be clicked and stay in that mode,
//or be clicked and something be activated
public class Button {

    PApplet sketch;
    ButtonManager manager;

    float x, y, w, h;
    public boolean singlePress, pressed, listening, iconMode;
    int r, g, b;
    PImage icon;
    public String label, type;
    int loopCount;

    public Button(PApplet sketch, ButtonManager buttonManager, String type, float x, float y, float w, float h, boolean singlePressMode, int r, int g, int b, String text, boolean iconMode, boolean listening) {
        this.sketch = sketch;
        this.manager = buttonManager;
        this.type = type;
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.singlePress = singlePressMode;
        this.pressed = false;
        this.r = r;
        this.g = g;
        this.b = b;
        this.iconMode = iconMode;
        if (iconMode) {
            this.icon = sketch.loadImage(text);
        } else {
            this.label = text;
        }
        this.listening = listening;
        this.loopCount = 0;
    }

    public boolean listen() {
        this.loopCount++;
        if (this.sketch.mousePressed && this.sketch.mouseX > this.x && sketch.mouseX < this.x + this.w
                && sketch.mouseY > this.y && sketch.mouseY < this.y + this.w && this.listening && this.loopCount > 20) {

            if (this.singlePress) {
                this.loopCount = 0;
            }
            this.pressed = true;

            // System.out.println("button clicked");
            return true;
        }
        this.pressed = false;
        //System.out.println("returning false");
        return false;
    }

    public void display() {
        if (this.listening) {
            this.sketch.strokeWeight(1);
            this.sketch.stroke(0);
            this.sketch.fill(this.r, this.g, this.b);

            this.sketch.rectMode(CORNER);
            this.sketch.rect(this.x, this.y, this.w, this.h);

            if (this.iconMode) {
                this.sketch.imageMode(CORNER);
                this.sketch.image(this.icon, this.x, this.y, this.w, this.h);
            } else {
                this.sketch.fill(0);
                this.sketch.textAlign(CENTER);
                this.sketch.textSize(12);
                this.sketch.text(this.label, this.x + this.w / 2, this.y + this.h / 2);
            }
        }
    }

    public void performAction() {
    }

}

//class OpenProjectButton extends Button {
//
//    ProjectButton projectButton;
//
//    OpenProjectButton(PApplet sketch, ProjectButton parent, ArrayList<Button> buttonList, float x, float y, float w, float h) {
//        super(sketch, buttonList, x, y, w, h, true, 200, 200, 200, "Open Project", false, false);
//        projectButton = parent;
//    }
//
//    @Override
//    boolean wasClicked() {
//        if (super.wasClicked()) {
//            System.out.println("OpenProject button was clicked");
//
//            projectButton.offeringOptions = false;
//            this.hide();
//            projectButton.openProjectButton.hide();
//            projectButton.projectOpen = true;
//
//            return true;
//        }
//        return false;
//    }
//
//    void hide() {
//        super.listening = false;
//    }
//
//}
//
//class DimensionButtons extends Button {
//
//    float x, y, buttonW, buttonH, dist;
//    Button squareButton, videoButton, landscapeButton, portraitButton, storyButton; //1:1, 19:6, 1.91:1, 4:5, 9:16
//    ArrayList<Button> buttons;
//    Button parent;
//
//    DimensionButtons(PApplet sketch, Button parent, ArrayList<Button> buttonList, float x, float y, float buttonW, float buttonH, float dist) {
//        super(sketch, buttonList, x, y, (buttonW + dist) * 5, buttonH, true, 0, 0, 0, "", false, false);
//        this.x = x;
//        this.y = y;
//        this.buttonW = buttonW;
//        this.buttonH = buttonH;
//        this.dist = dist;
//
//        this.squareButton = new Button(sketch, buttonList, this.x, this.y, this.buttonW, this.buttonH, true, 200, 200, 200, "square\n1:1", false, false);
//        this.videoButton = new Button(sketch, buttonList, this.x + (this.buttonW + dist), this.y, this.buttonW, this.buttonH, true, 200, 200, 200, "video\n19:6", false, false);
//        this.landscapeButton = new Button(sketch, buttonList, this.x + (this.buttonW + dist) * 2, this.y, this.buttonW, this.buttonH, true, 200, 200, 200, "landscape\n1.91:1", false, false);
//        this.portraitButton = new Button(sketch, buttonList, this.x + (this.buttonW + dist) * 3, this.y, this.buttonW, this.buttonH, true, 200, 200, 200, "portrait\n4:5", false, false);
//        this.storyButton = new Button(sketch, buttonList, this.x + (this.buttonW + dist) * 4, this.y, this.buttonW, this.buttonH, true, 200, 200, 200, "story\n9:16", false, false);
//
//        this.buttons = new ArrayList<Button>();
//        this.buttons.add(squareButton);
//        this.buttons.add(videoButton);
//        this.buttons.add(landscapeButton);
//        this.buttons.add(portraitButton);
//        this.buttons.add(storyButton);
//
//        buttonList.add(this);
//        for (Button b : this.buttons) {
//            buttonList.add(b);
//        }
//    }
//
//    @Override
//    void display() {
//        for (Button b : this.buttons) {
//            b.display();
//        }
//    }
//
//    void turnOnButtons() {
//        this.listening = true;
//        for (Button b : this.buttons) {
//            b.listening = true;
//        }
//    }
//
//    void turnOffButtons() {
//        this.listening = false;
//        for (Button b : this.buttons) {
//            b.listening = false;
//        }
//    }
//
//    void createCanvas() {
////        Canvas newCanvas = new Canvas(300, 100, 600, 400);
////        canvasList.add(newCanvas);
////        workingCanvas = newCanvas;
//    }
//
//    void hide() {
//        for (Button b : this.buttons) {
//            b.listening = false;
//        }
//    }
//
//    @Override
//    boolean wasClicked() {
//        if (super.wasClicked()) {
//            System.out.println("A dimension button was clicked");
//
//            //canvasCreated = true;
//            //1:1, 19:6, 1.91:1, 4:5, 9:16
//            if (squareButton.wasClicked()) {
//                System.out.println("square button was clicked");
//
////                canvas_w = 500;
////                canvas_h = 500;
//            }
//            if (videoButton.wasClicked()) {
//                System.out.println("video button was clicked");
//
////                canvas_w = 700;
////                canvas_h = 221;
//            }
//            if (landscapeButton.wasClicked()) {
//                System.out.println("landscape button was clicked");
////
////                canvas_w = 700;
////                canvas_h = 366;
//            }
//            if (portraitButton.wasClicked()) {
//                System.out.println("portrait button was clicked");
////
////                canvas_w = 400;
////                canvas_h = 500;
//            }
//            if (storyButton.wasClicked()) {
//                System.out.println("story button was clicked");
//
////                canvas_w = 281;
////                canvas_h = 500;
//            }
////
////            workingCanvas = new GridCanvas(canvas_x, canvas_y, canvas_w, canvas_h);
////
////            canvasList.add(workingCanvas);
//
//            this.turnOffButtons();
//
//            return true;
//        }
//        return false;
//    }
//
//}
