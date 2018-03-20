import java.util.ArrayList;

public class Arena {


    private int size;
    private ArrayList<HexField> hexArray = new ArrayList<>();

    public Arena(int size) {
        this.size = size;
        initializeArena(size);
    }

    public HexField getHex(int x, int y) {
        for (HexField iterator : hexArray) {
            if (iterator.getX() == x && iterator.getY() == y) {
                return iterator;
            }
        }
        return null;
    }

    public boolean isXYonArena(int x, int y) {
        boolean answer = false;
        for (HexField iterator : hexArray) {
            if (iterator.getX() == x && iterator.getY() == y)
                answer = true;
        }
        return answer;
    }

    public void addToArena(HexField hexField) {
        if (hexField.getIsOnArena() == false) {
            hexArray.add(hexField);
            hexField.setIsOnArena(true);
        }
    }

    public void initializeArena(int size) {
        int count = 0;
        //Add (size) layers to arena
        for (int y = (1 - size); y < size; y++)
            for (int x = (1 - size); x < size; x++)
                if (this.isXYonArena(x, y) == false) {
                    addToArena(new HexField(x, y));
                    count++;
                    System.out.println("(" + x + "," + y + ") added to arena");
                }

        System.out.println(count + " hexes added to arena");
        updateHexNeighbors();
    }

    public void updateHexNeighbors() {

        for (HexField iterator : hexArray) {
            int x = iterator.getX();
            int y = iterator.getY();

            //upperRight
            if (isXYonArena(x, y + 1)) {
                iterator.setUpperRight(getHex(x, y + 1));
            } else iterator.setUpperRight(new HexField(x, y + 1));

            //right
            if (isXYonArena(x + 1, 0)) {
                iterator.setRight(getHex(x + 1, 0));
            } else iterator.setRight(new HexField(x + 1, 0));

            //lowerRight
            if (isXYonArena(x, -y)) {
                iterator.setLowerRight(getHex(x, -y));
            } else iterator.setLowerRight(new HexField(x, -y));

            //lowerLeft
            if (isXYonArena(0, -y)) {
                iterator.setLowerLeft(getHex(0, -y));
            } else iterator.setLowerLeft(new HexField(0, -y));

            //left
            if (isXYonArena(-x, 0)) {
                iterator.setLeft(getHex(-x, 0));
            } else iterator.setLeft(new HexField(-x, 0));

            //upperLeft
            if (isXYonArena(-x, y)) {
                iterator.setUpperLeft(getHex(-x, y));
            } else iterator.setUpperLeft(new HexField(-x, y));
        }

    }
}
