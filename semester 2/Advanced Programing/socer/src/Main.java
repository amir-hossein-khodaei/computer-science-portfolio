import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        List<player> players = new ArrayList<>();
        List<team> teams = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        repeat:
        while (true) {

            String[] input = scanner.nextLine().split("\\s+");

            sweech:
            switch (input[0]) {

                case null:
                case "\n", " ", "": {
                    continue;
                }

                case "new": {
                    switch (input[1]) {
                        case "player": {
                            players.add(new player(input[3], input[4], input[5], input[6]));
                            break sweech;
                        }
                        case "team": {
                            teams.add(new team(input[2], input[3]));
                            break sweech;
                        }
                        default: {
                            System.out.println("not valid 1");
                            break sweech;
                        }
                    }
                }

                case "buy": {
                    if (players.size() < Integer.parseInt(input[1])) {
                        System.out.println("player with the id playerID doesnt exist");
                        break;
                    } else if (teams.size() < Integer.parseInt((input[2]))) {
                        System.out.println("team with the id teamID doesnt exist");
                        break;
                    } else if (!(teams.get(Integer.parseInt(input[2]) - 1).can_effort(players.get(Integer.parseInt(input[1]) - 1)))) {
                        System.out.println("the team cant afford to buy this player ");
                        break;
                    } else if (!(players.get(Integer.parseInt(input[1]) - 1).isFree())) {
                        System.out.println("player already has a team");
                        break;
                    } else {
                        teams.get(Integer.parseInt(input[2]) - 1).remove_money(players.get(Integer.parseInt(input[1]) - 1));
                        teams.get(Integer.parseInt(input[2]) - 1).setPlayers(players.get(Integer.parseInt(input[1]) - 1));
                        players.get(Integer.parseInt(input[1]) - 1).buy();
                        System.out.println("player added to the team succesfully");
                        break;
                    }
                }

                case "sell": {
                    if (teams.size() < Integer.parseInt((input[2]))) {
                        System.out.println("team with the id teamID doesnt exist");
                        break;
                    } else if (!((teams.get(Integer.parseInt(input[2]) - 1).containplayer(players.get(Integer.parseInt(input[1]) - 1))))) {
                        System.out.println("team doesnt have this player");
                        break;
                    } else {
                        teams.get(Integer.parseInt(input[2]) - 1).add_money(players.get(Integer.parseInt(input[1]) - 1));
                        teams.get(Integer.parseInt(input[2]) - 1).removePlayers(players.get(Integer.parseInt(input[1]) - 1));
                        players.get(Integer.parseInt(input[1]) - 1).sell();
                        break;
                    }
                }

                case "match": {
                    if (((teams.size() > Integer.parseInt(input[1])) && (teams.size() > Integer.parseInt(input[2])))) {
                        System.out.println("team doesnt exist");
                        break;
                    } else if (!(teams.get(Integer.parseInt(input[1]) - 1).is_verified() && teams.get(Integer.parseInt(input[2]) - 1).is_verified())) {
                        System.out.println("the game can not be held due to loss of the players");
                        break;
                    } else {
                        if (teams.get(Integer.parseInt(input[1]) - 1).count_power() > teams.get(Integer.parseInt(input[2]) - 1).count_defence()) {
                            teams.get(Integer.parseInt(input[1]) - 1).winer();
                            teams.get(Integer.parseInt(input[2]) - 1).losser();
                            break;
                        } else if (teams.get(Integer.parseInt(input[1]) - 1).count_power() > teams.get(Integer.parseInt(input[2]) - 1).count_defence()) {
                            teams.get(Integer.parseInt(input[2]) - 1).winer();
                            teams.get(Integer.parseInt(input[1]) - 1).losser();
                            break;
                        }
                    }


                    break;
                }

                case "rank": {
                    List<team> sorted_team = sorter(teams);
                    int j = 0;
                    for (team k : sorted_team) {
                        j++;
                        System.out.println(j + ". " + k.getName());
                    }
                    break;
                }

                case "end": {
                    break repeat;
                }

                default: {
                    System.out.println("not valid 2 ");
                    break;
                }

            }
        }
    }

    public static List<team> sorter(List<team> teams) {
        List<team> all_teams = teams;
        int n = all_teams.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (all_teams.get(j).getWin() < all_teams.get(j + 1).getWin()) {


                    team temp = all_teams.get(j);
                    all_teams.set(j, all_teams.get(j + 1));
                    all_teams.set(j + 1, temp);

                } else if (all_teams.get(j).getWin() == all_teams.get(j + 1).getWin()) {

                    if (all_teams.get(j).getLose() > all_teams.get(j + 1).getLose()) {


                        team temp = all_teams.get(j);
                        all_teams.set(j, all_teams.get(j + 1));
                        all_teams.set(j + 1, temp);

                    }
                }
            }
        }
        return all_teams;
    }
}