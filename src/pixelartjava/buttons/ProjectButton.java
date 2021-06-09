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
    public ProjectButton(PApplet sketch, ButtonManager manager, float x, float y, float w, float h) {
        super(sketch, manager, "MAIN_PROJECT", x, y, w, h, true, 200, 200, 200, "C:\\Users\\Nick\\Desktop\\Code_Current\\PixelArtJava\\src\\pixelartjava\\data\\plus-sign.png", true, true);

    }

    @Override
    public void performAction() {
        this.manager.openCreateOrOpen();

    }

}
