package mychess.domen;

import mychess.service.GameMaster;

public class Elephant extends GameObject {

    private GameMaster gameMaster;

    public Elephant(int locationX, int locationY, int side, String imagePath) {
        super(locationX, locationY, imagePath);
        this.side = side;
    }

    @Override
    public void move() {
        this.gameMaster = GameMaster.getInstance();
        boolean needBreak = false;
        int j = 1;
        for(int i = locationX; i < 8; i++){
            if(needBreak){
                needBreak = false;
                break;
            }
            GameObject gameObject = gameMaster.findGameObject(i + 1, locationY - j);
            if(gameObject != null) needBreak = true;
            if(locationY != 1 && locationX != 8 && locationY - j >= 1) {
                moves.put((float) (locationY - j + 0.1), i + 1);
                j++;
            }
        }

        j = 1;
        for(int i = locationX; i > 1; i--){
            if(needBreak){
                needBreak = false;
                break;
            }
            GameObject gameObject = gameMaster.findGameObject(i - 1, locationY - j);
            if(gameObject != null) needBreak = true;
            if(locationY != 1 && locationX != 1 && locationY - j >= 1) {
                moves.put((float) (locationY - j + 0.2), i - 1);
                j++;
            }
        }

        j = 1;
        System.out.println("перед циклом");
        for(int i = locationX; i > 1; i--){
            System.out.println("зашел в цикл в " + j + " раз");
            if(needBreak){
                needBreak = false;
                break;
            }
            GameObject gameObject = gameMaster.findGameObject(i - 1, locationY + j);
            if(gameObject != null) needBreak = true;
            if(locationY != 8 && locationX != 1 && locationY + j <= 8) {
                moves.put((float) (locationY + j + 0.3), i - 1);
                System.out.println("положил координаты в " + j + " раз");
                j++;
            }
        }

        j = 1;
        for(int i = locationX; i < 8; i++){
            if(needBreak) break;
            GameObject gameObject = gameMaster.findGameObject(i + 1, locationY + j);
            if(gameObject != null) needBreak = true;
            if(locationY != 8 && locationX != 8 && locationY + j <= 8) {
                moves.put((float) (locationY + j + 0.4), i + 1);
                j++;
            }
        }
    }

}
