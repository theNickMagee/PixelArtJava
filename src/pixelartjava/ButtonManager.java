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
 * @author Nick
 */
public class ButtonManager {

    private PApplet sketch;

    private ArrayList<Button> buttons;
    private ArrayList<Button> liveButtons;

    private ProjectButton projectButton;

    private boolean button_selected;
    private Button performingButton;

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
        if (this.button_selected) {
            this.performingButton.performAction();
        }

    }

    public void openCreateOrOpen() {
        this.liveButtons.remove(this.projectButton);
    }

}
