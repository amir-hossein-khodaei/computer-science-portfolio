import java.util.ArrayList;
import java.util.List;

public class team {
    private static int counter = 0;
    private final String name;
    private final int ID;
    List<player> players = new ArrayList<>();
    private int money;
    private int win;
    private int loss;

    public team(String name, String money) {
        this.money = Integer.parseInt(money);
        this.name = name;
        this.win = 0;
        this.loss = 0;
        this.ID = ++counter;
    }

    public String getName() {
        return name;
    }

    public int getID() {
        return ID;
    }

    public boolean can_effort(player player) {
        return (this.money > player.getPrice());
    }

    public void add_money(player player) {
        this.money = this.money + player.getPrice();
    }

    public void remove_money(player player) {
        this.money = this.money - player.getPrice();
    }

    public int return_money() {
        return this.money;
    }

    public List<player> getPlayers() {
        return players;
    }

    public void setPlayers(player players) {
        this.players.add(players);
    }

    public void removePlayers(player players) {
        this.players.remove(players);
    }

    public boolean containplayer(player player) {
        return players.contains(player);
    }

    public boolean is_verified() {
        return (this.players.size() >= 10);
    }

    public void winer() {
        this.win++;
        this.money = this.money + 1000;
    }

    public void losser() {
        this.loss++;
    }

    public int getWin() {
        return win;
    }

    public void setWin(int win) {
        this.win = win;
    }

    public int getLose() {
        return loss;
    }

    public int count_power() {
        int powers = 0;
        for (int i = 0; i < 11; i++) {
            powers += (players.get(i).getSpeed() + players.get(i).getFinishing());
        }
        return powers;
    }

    public int count_defence() {
        int powers = 0;
        for (int i = 0; i < 11; i++) {
            powers += (players.get(i).getSpeed() + players.get(i).getDefence());
        }
        return powers;
    }

}
