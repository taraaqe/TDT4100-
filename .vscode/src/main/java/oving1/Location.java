package oving1;

public class Location {
    private int x = 0;
    private int y = 0;

    //Metoder
    public void up() {
        y--;
    }

    public void down() {
        y++;
    }

    public void left() {
        x--;
    }

    public void right() {
        x++;
    }

    public int getX () {
        return x;
    }

    public int getY() {
        return y;
    }

    // toString
    public String toString() {
        return "(" + x + "," + y + ")";
    }

    // Main

    public static void main(String[] args) {
        Location location = new Location();

        location.up();
        location.up();
        location.right();
        location.right();
        location.right();
        location.left();
        location.down();

        System.out.println(location);
    }
}
