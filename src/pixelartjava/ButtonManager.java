/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pixelartjava;

import pixelartjava.buttons.ProjectButton;
import pixelartjava.buttons.CreateProjectButton;
import pixelartjava.buttons.Button;
import java.util.ArrayList;
import pixelartjava.buttons.OpenProjectButton;
import processing.core.PApplet;

/**
 *
 * @author Nick
 */
public class ButtonManager {

    private PApplet sketch;

    private ArrayList<Button> buttons;
    private ArrayList<Button> liveButtons;

    private ProjectButton projectButton;

    private boolean button_selected;
    private Button performingButton, squareButton, videoButton, landscapeButton, portraitButton, storyButton;

    private CreateProjectButton createProjectButton;
    private OpenProjectButton openProjectButton;

    ButtonManager(PApplet sketch) {
        this.buttons = new ArrayList<Button>();
        this.liveButtons = new ArrayList<Button>();
        this.sketch = sketch;
    }

    public void createStartingButtons() {
        this.projectButton = new ProjectButton(this.sketch, this, (this.sketch.width * 0.65f), (this.sketch.height * 0.25f), (this.sketch.height * 0.05f), (this.sketch.height * 0.05f));

        this.buttons.add(projectButton);
        this.liveButtons.add(projectButton);

        this.button_selected = false;
    }

    public void run() {

        for (Button b : this.liveButtons) {
            b.display();
            b.listen();

            if (b.pressed == true) {
                this.button_selected = true;
                this.performingButton = b;
            }

        }

        //select button in loop, perform action after so not to delete while in loop
        //This setup gives flexibity, but may be too complicated.  Button can either be a subclass of Button and performAction(), or have a title whih can be checked in case switch
        if (this.button_selected) {
            System.out.println("performing action");
            this.performingButton.performAction();

            switch (this.performingButton.type) {
                case "DIMENSION":
                    this.createCanvas(this.performingButton.label);

            }

            this.button_selected = false;
        }

    }

    //Could put these functions in PerformAction of the button class, very easy to do but I like it like this for now
    //give options "create new project" and "open project"
    public void openCreateOrOpen() {
        this.liveButtons.remove(this.projectButton);

        this.createProjectButton = new CreateProjectButton(this.sketch, this, this.sketch.width / 2, (this.sketch.height * 0.25f), 120, 40);
        this.liveButtons.add(this.createProjectButton);

        this.openProjectButton = new OpenProjectButton(this.sketch, this, this.sketch.width / 2 + 200, (this.sketch.height * 0.25f), 120, 40);
        this.liveButtons.add(this.openProjectButton);

    }

    //give dimension options after "Create new Project is selected"
    public void openDimensionButtons() {
        this.liveButtons.remove(this.createProjectButton);
        this.liveButtons.remove(this.openProjectButton);

        float orginX = sketch.width * 0.45f;
        float orginY = sketch.height * 0.25f;
        float w = 70;
        float dist = 20;
        float h = 40;

        this.squareButton = new Button(this.sketch, this, "DIMENSION", orginX, orginY, w, h, true, 200, 200, 200, "square\n1:1", false, true);
        this.videoButton = new Button(this.sketch, this, "DIMENSION", orginX + (w + dist), orginY, w, h, true, 200, 200, 200, "video\n19:6", false, true);
        this.landscapeButton = new Button(this.sketch, this, "DIMENSION", orginX + (w + dist) * 2, orginY, w, h, true, 200, 200, 200, "landscape\n1.91:1", false, true);
        this.portraitButton = new Button(this.sketch, this, "DIMENSION", orginX + (w + dist) * 3, orginY, w, h, true, 200, 200, 200, "portrait\n4:5", false, true);
        this.storyButton = new Button(this.sketch, this, "DIMENSION", orginX + (w + dist) * 4, orginY, w, h, true, 200, 200, 200, "story\n9:16", false, true);

        this.liveButtons.add(this.squareButton);
        this.liveButtons.add(this.videoButton);
        this.liveButtons.add(this.landscapeButton);
        this.liveButtons.add(this.portraitButton);
        this.liveButtons.add(this.storyButton);
    }

    public void createNewCanvas(int x, int y, int w, int h) {

    }

    private void createCanvas(String buttonLabel) {

    }

}
