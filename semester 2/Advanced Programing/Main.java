
import java.util.ArrayList;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {


        class Player {
            String name;
            long price;
            long speed;
            long finishing;
            long defence;
            boolean isInTeam = false;

            public Player(String name, long... details) {
                this.name = name;
                price = details[0];
                speed = details[1];
                finishing = details[2];
                defence = details[3];
            }
        }

        class Team {
            String name;
            long money;
            ArrayList<Player> teamPlayers;
            long wins = 0;
            long draws = 0;
            long looses = 0;

            public Team(String name, long money) {
                this.name = name;
                this.money = money;
                this.teamPlayers = new ArrayList<>();
            }
        }

        class EasyLeage {
            String[] inputs;
            Scanner in = new Scanner(System.in);
            String whatToDo;
            ArrayList<Player> players = new ArrayList<>();
            ArrayList<Team> teams = new ArrayList<>();

            public void main(String[] args) {
                boolean end = false;
                while (!end) {
                    readInputs();
                    if (inputs.equals(null))
                        continue;
                    switch (whatToDo) {
                        case "new":
                            if (inputs[1].equals("player"))
                                players.add(new Player(inputs[2], Long.parseLong(inputs[3]), Long.parseLong(inputs[4]),
                                        Long.parseLong(inputs[5]), Long.parseLong(inputs[6])));
                            else
                                teams.add(new Team(inputs[2], Long.parseLong(inputs[3])));
                            break;
                        case "buy":
                            buyPlayer();
                            break;
                        case "sell":
                            sellPlayer();
                            break;
                        case "match":
                            match();
                            break;
                        case "rank":
                            rank();
                            break;
                        case "end":
                            end = true;
                            break;
                        default:
                            continue;
                    }
                }
            }

            private void readInputs() {
                inputs = in.nextLine().split(" ");
                whatToDo = inputs[0];
            }

            private void buyPlayer() {
                int playerId = Integer.parseInt(inputs[1]);
                playerId--;
                int teamId = Integer.parseInt(inputs[2]);
                teamId--;
                if (playerId < 0 || playerId > players.size() - 1) {
                    String r = "player with the id ";
                    System.out.print(r);
                    System.out.print((playerId + 1));
                    String r1 = " doesnt exist";
                    System.out.println(r1);
                    return;
                }
                if (teamId < 0 || teamId > players.size() - 1) {
                    String e1 = "team with the id";
                    String e2 = " doesnt exist";
                    System.out.print(e1);
                    System.out.print((teamId + 1));
                    System.out.println(e2);
                    return;
                }
                if (teams.get(teamId).money < players.get(playerId).price) {
                    String w = "the team cant afford to buy this player";
                    System.out.println(w);
                    return;
                }
                if (players.get(playerId).isInTeam) {
                    String q = "player already has a team";
                    System.out.println(q);
                    return;
                }
                teams.get(teamId).teamPlayers.add(players.get(playerId));
                players.get(playerId).isInTeam = true;
                teams.get(teamId).money -= players.get(playerId).price;
                String g = "player added to the team succesfully";
                System.out.println(g);
            }

            private void sellPlayer() {
                int playerId = Integer.parseInt(inputs[1]);
                playerId--;
                int teamId = Integer.parseInt(inputs[2]);
                teamId--;
                if (teamId < 0 || teamId > players.size() - 1) {
                    System.out.println("team doesnt exist");
                    return;
                }
                boolean check = false;
                for (Player player : teams.get(teamId).teamPlayers)
                    if (players.indexOf(player) == playerId) {
                        check = true;
                        break;
                    }

                if (!check) {
                    System.out.println("team doesnt have this player");
                    return;
                }
                teams.get(teamId).teamPlayers.remove(players.get(playerId));
                teams.get(teamId).money += players.get(playerId).price;
                players.get(playerId).isInTeam = false;
                System.out.println("player sold succesfully");
            }

            void match() {
                int team1Id = Integer.parseInt(inputs[1]);
                team1Id--;
                int team2Id = Integer.parseInt(inputs[2]);
                team2Id--;
                if (team1Id < 0 || team1Id > players.size() - 1
                        ||
                        team2Id < 0 || team2Id > players.size() - 1) {
                    System.out.println("team doesnt exist");
                    return;
                }
                if (teams.get(team1Id).teamPlayers.size() <= 10
                        ||
                        teams.get(team2Id).teamPlayers.size() <= 10) {
                    System.out.println("the game can not be held due to loss of the players");
                    return;
                }
                long team1Power = 0;
                for (int i = 0; i <= 10; i++) {
                    team1Power += teams.get(team1Id).teamPlayers.get(i).speed;
                    team1Power += teams.get(team1Id).teamPlayers.get(i).finishing;
                }
                long team2Power = 0;
                for (int i = 0; i <= 10; i++) {
                    team2Power += teams.get(team2Id).teamPlayers.get(i).speed;
                    team2Power += teams.get(team2Id).teamPlayers.get(i).defence;
                }
                if (team1Power > team2Power) {
                    teams.get(team1Id).money += 1000;
                    teams.get(team1Id).wins += 1;

                    teams.get(team2Id).looses += 1;
                } else if (team1Power < team2Power) {
                    teams.get(team2Id).money += 1000;
                    teams.get(team2Id).wins += 1;

                    teams.get(team1Id).looses += 1;
                } else {
                    teams.get(team1Id).draws += 1;
                    teams.get(team2Id).draws += 1;
                }
            }

            private void rank() {
                Team[] leaderborads = teams.toArray(new Team[0]);
                Team holdToSwap;
                int h1 = leaderborads.length;
                for (int i = 0; i < h1; i++) {
                    int h3 = leaderborads.length;
                    for (int j = i + 1; j < h3; j++) {
                        if (leaderborads[j].wins > leaderborads[i].wins) {
                            holdToSwap = leaderborads[i];
                            leaderborads[i] = leaderborads[j];
                            leaderborads[j] = holdToSwap;
                        } else if (leaderborads[j].looses < leaderborads[i].looses) {
                            holdToSwap = leaderborads[j];
                            leaderborads[j] = leaderborads[i];
                            leaderborads[i] = holdToSwap;
                        } else if (teams.indexOf(leaderborads[j]) < teams.indexOf(leaderborads[i])) {
                            holdToSwap = leaderborads[i];
                            leaderborads[i] = leaderborads[j];
                            leaderborads[j] = holdToSwap;
                        }
                    }
                }
                int h2 = leaderborads.length;
                for (int i = 0; i < h2; i++)
                    System.out.println((i + 1) + ". " + leaderborads[i].name);
            }
        }


    }
}