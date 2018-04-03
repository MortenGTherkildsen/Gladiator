public class HexField {

    //Adresse på sig selv
    private int x;
    private int y;
    private boolean isOnArena;
    //Adresseholdere til nabo-hexer. Bliver sat af initializeArena()
    private HexField upperRight, right, lowerRight, lowerLeft, left, upperLeft;
    //Hexfelternes mulige indhold:
    // Beings: Gladiatorer og dyr
    // Thing Udlagte fælder(net), tabte våben, afhukkede lemmer(?), alt som en gladiator kan samle op og putte i sit inventory;
    Being being;
    Thing thing;

    public HexField(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean isHexEmpty(){
        if(being==null && thing==null)
            return false;

        return true;
    }

    public boolean getIsOnArena() {
        return isOnArena;
    }

    public void setIsOnArena(boolean isOnArena) {
        this.isOnArena = isOnArena;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public HexField getUpperRight() {
        return upperRight;
    }

    public void setUpperRight(HexField upperRight) {
        this.upperRight = upperRight;
    }

    public HexField getRight() {
        return right;
    }

    public void setRight(HexField right) {
        this.right = right;
    }

    public HexField getLowerRight() {
        return lowerRight;
    }

    public void setLowerRight(HexField lowerRight) {
        this.lowerRight = lowerRight;
    }

    public HexField getLowerLeft() {
        return lowerLeft;
    }

    public void setLowerLeft(HexField lowerLeft) {
        this.lowerLeft = lowerLeft;
    }

    public HexField getLeft() {
        return left;
    }

    public void setLeft(HexField left) {
        this.left = left;
    }

    public HexField getUpperLeft() {
        return upperLeft;
    }

    public void setUpperLeft(HexField upperLeft) {
        this.upperLeft = upperLeft;
    }
}
