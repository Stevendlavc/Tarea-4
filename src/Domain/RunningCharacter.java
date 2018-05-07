package Domain;

import Utility.Variables;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.Image;

public class RunningCharacter extends Character {

    public RunningCharacter(int x, int y, int imgNum) throws FileNotFoundException {
        super(x, y, imgNum);
        setSprite();
    }

    public void setSprite() throws FileNotFoundException {
        ArrayList<Image> sprite = super.getSprite();
        for (int i = 0; i < 8; i++) {
            sprite.add(new Image(new FileInputStream("src/Assets/Running" + i + ".png")));
        }
        super.setSprite(sprite);
    }

    @Override
    public void run() {
        ArrayList<Image> sprite = super.getSprite();
        int j = 0;
        for (int i = 0;; i++) {
            if (i == 8) {
                i = 0;
            }
            super.setImage(sprite.get(i));
            super.setX(j * 20);
            j++;
            try {
                Thread.sleep(80);
            } catch (InterruptedException ex) {
                Logger.getLogger(RunningCharacter.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (j * 20 > Variables.WIDTH) {
                j = 0;
            }
        }
    }
}
