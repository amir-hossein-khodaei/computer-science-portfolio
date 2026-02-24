public class player {
    private final int price;
    private final int speed;
    private final int finishing;
    private final int defence;
    private boolean free;


    public player(String s, String s1, String s2, String s3) {
        this.price = Integer.parseInt(s);
        this.speed = Integer.parseInt(s1);
        this.defence = Integer.parseInt(s3);
        this.finishing = Integer.parseInt(s2);
        this.free = true;
    }

    public int getSpeed() {
        return speed;
    }

    public int getFinishing() {
        return finishing;
    }

    public int getDefence() {
        return defence;
    }

    public boolean isFree() {
        return this.free;
    }

    public void buy() {
        this.free = false;
    }

    public void sell() {
        this.free = true;
    }

    public int getPrice() {
        return this.price;
    }

}
