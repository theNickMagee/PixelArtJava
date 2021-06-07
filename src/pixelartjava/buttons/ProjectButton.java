/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pixelartjava.buttons;

import java.util.ArrayList;
import pixelartjava.ButtonManager;
import processing.core.PApplet;

/**
 *
 * @author Nick
 */
public class ProjectButton extends Button {

    //click and will open up: Open Project, Create New Project
    //whenever project is created or opened, stop listening and displaying
    boolean projectOpen, offeringOptions;

//    CreateProjectButton createProjectButton;
//    OpenProjectButton openProjectButton;
//    DimensionButtons dimensionButtons;
    public ProjectButton(PApplet sketch, ButtonManager manager, float x, float y, float w, float h) {
        super(sketch, manager, x, y, w, h, true, 200, 200, 200, "C:\\Users\\Nick\\Desktop\\Code_Current\\PixelArtJava\\src\\pixelartjava\\data\\plus-sign.png", true, true);

        this.projectOpen = false;
        this.offeringOptions = false;

    }

//    @Override
//    boolean wasClicked() {
//        if (super.wasClicked()) {
//            System.out.println("project button was clicked");
//
//            this.offeringOptions = true;
//            super.listening = false;
//
////            this.createProjectButton = new CreateProjectButton(sketch, this, buttonList, this.x - sketch.width / 7, this.y, this.w * 4, this.h);
////            buttonList.add(this.createProjectButton);
////
////            this.openProjectButton = new OpenProjectButton(sketch, this, buttonList, this.x + sketch.width / 10, this.y, this.w * 4, this.h);
////            buttonList.add(this.openProjectButton);
//            return true;
//        }
//        return false;
//    }
    @Override
    public void display() {
        if (this.projectOpen) {
            //do nothing
        } else if (this.offeringOptions) {
            //this.createProjectButton.display();
            //this.createProjectButton.listening = true;

            //this.openProjectButton.display();
            //this.openProjectButton.listening = true;
        } else {
            super.display();
        }
    }

    @Override
    public void performAction() {
        this.manager.openCreateOrOpen();

    }

}
