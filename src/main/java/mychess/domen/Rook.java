package mychess.domen;

import mychess.service.GameMaster;

public class Rook extends GameObject {

    private GameMaster gameMaster;

    public Rook(int locationX, int locationY, int side, String imagePath) {
        super(locationX, locationY, imagePath);
        this.side = side;
    }

    @Override
    public void move() {
        this.gameMaster = GameMaster.getInstance();
        boolean needBreak = false;
        float j = (float) 0.1;
        for(int i = locationX; i < 9; i++){
            if(needBreak) break;
            GameObject gameObject = gameMaster.findGameObject(i + 1, locationY);
            if(gameObject != null) needBreak = true;
            if(locationX != 8){
                moves.put((float) locationY + j, i);
                j = (float) (j + 0.1);
            }
        }

        needBreak = false;
        j = (float) 0.1;
        for(int i = locationX; i > 0; i--){
            if(needBreak) break;
            GameObject gameObject = gameMaster.findGameObject(i - 1, locationY);
            if(gameObject != null) needBreak = true;
            if(locationX != 1){
                moves.put((float) locationY + j, i);
                j = (float) (j + 0.1);
            }
        }

        needBreak = false;
        for(int i = locationY; i < 9; i++){
            if(needBreak) break;
            GameObject gameObject = gameMaster.findGameObject(locationX, i);
            if(gameObject != null) needBreak = true;
            if(locationY != 8){
                moves.put((float) i, locationX);
            }
        }

        needBreak = false;
        for(int i = locationY; i > 0; i--){
            if(needBreak) break;
            GameObject gameObject = gameMaster.findGameObject(locationX, i);
            if(gameObject != null) needBreak = true;
            if(locationY != 1){
                moves.put((float) i, locationX);
            }
        }
    }
}
