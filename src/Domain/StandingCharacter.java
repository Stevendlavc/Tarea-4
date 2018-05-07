package Domain;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.Image;

public class StandingCharacter extends Character {

    public StandingCharacter(int x, int y, int imgNum) throws FileNotFoundException {
        super(x, y, imgNum);
        setSprite();
    }

    public void setSprite() throws FileNotFoundException {
        ArrayList<Image> sprite = super.getSprite();
        for (int i = 0; i < 4; i++) {
            sprite.add(new Image(new FileInputStream("src/Assets/Standing" + i + ".png")));
        }
        super.setSprite(sprite);
    }

    @Override
    public void run() {
        ArrayList<Image> sprite = super.getSprite();
        for (int i = 0; ; i++) {
            if(i==4){
                i=0;
            }
            super.setImage(sprite.get(i));
            try {
                Thread.sleep(300);
            } catch (InterruptedException ex) {
                Logger.getLogger(StandingCharacter.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
