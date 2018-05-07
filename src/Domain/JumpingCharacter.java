package Domain;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.Image;

public class JumpingCharacter extends Character {

    public JumpingCharacter(int x, int y, int imgNum) throws FileNotFoundException {
        super(x, y, imgNum);
        setSprite();
    }

    public void setSprite() throws FileNotFoundException {
        ArrayList<Image> sprite = super.getSprite();
        for (int i = 0; i < 3; i++) {
            sprite.add(new Image(new FileInputStream("src/Assets/Jumping" + i + ".png")));
        }
    }

    @Override
    public void run() {
        ArrayList<Image> sprite = super.getSprite();
        int j = 370;
        this.setY(j);
        while (true) {
            while (j > 270) {
                if (j == 370) {
                    super.setImage(sprite.get(2));
                    try {
                        Thread.sleep(400);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(JumpingCharacter.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    super.setImage(sprite.get(0));
                }
                this.setY(j - 15);
                try {
                    Thread.sleep(70);
                } catch (InterruptedException ex) {
                    Logger.getLogger(JumpingCharacter.class.getName()).log(Level.SEVERE, null, ex);
                }
                j = j - 15;
            }

            while (j < 370) {
                super.setImage(sprite.get(1));
                this.setY(j + 15);
                try {
                    Thread.sleep(70);
                } catch (InterruptedException ex) {
                    Logger.getLogger(JumpingCharacter.class.getName()).log(Level.SEVERE, null, ex);
                }
                j = j + 15;
            }
        }
    }
}
