import java.util.Scanner;
public class Battleship {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        final String PLAYER_1 = "PLAYER 1";
        final String PLAYER_2 = "PLAYER 2";

        System.out.println("Welcome to Battleship!\n");

        char[][] playerOneBoard = getPlayerBoard(PLAYER_1, scan);
        printBattleShip(playerOneBoard);

        // clear terminal to prevent other player from seeing the previous coordinates
        for (int i = 0; i < 99; i++) {
            System.out.println("");
        }

        char[][] playerTwoBoard = getPlayerBoard(PLAYER_2, scan);
        printBattleShip(playerTwoBoard);

        // clear terminal to prevent other player from seeing the previous coordinates
        for (int i = 0; i < 99; i++) {
            System.out.println("");
        }

        char[][] playerOneTargetHistoryBoard = new char[5][5];
        char[][] playerTwoTargetHistoryBoard = new char[5][5];
        fillBoard(playerOneTargetHistoryBoard);
        fillBoard(playerTwoTargetHistoryBoard);

        // number of sunken ships owned by player
        int playerOneShipsSunk = 0;
        int playerTwoShipsSunk = 0;

        // game loop
        do {
            // player 1 actions
            Boolean wasShipHit = fireShot(scan, playerTwoBoard, playerOneTargetHistoryBoard, PLAYER_1);
            if (wasShipHit) playerTwoShipsSunk++;
            printBattleShip(playerOneTargetHistoryBoard);

            // player one has won, no need to continue
            if (playerTwoShipsSunk == 5) {
                break;
            }
            // empty line for spacing
            System.out.println("");

            // player 2 actions
            wasShipHit = fireShot(scan, playerOneBoard, playerTwoTargetHistoryBoard, PLAYER_2);
            if (wasShipHit) playerOneShipsSunk++;
            printBattleShip(playerTwoTargetHistoryBoard);
            // empty line for spacing
            System.out.println("");
        } while (playerOneShipsSunk < 5 && playerTwoShipsSunk < 5);

        // exit conditions
        String winner = playerTwoShipsSunk == 5 ? PLAYER_1 : PLAYER_2;
        System.out.printf("%s WINS! YOU SUNK ALL OF YOUR OPPONENT’S SHIPS!\n", winner);
        System.out.println("");
        System.out.println("Final boards:");
        System.out.println("");

        printBattleShip(playerOneBoard);
        System.out.println("");
        printBattleShip(playerTwoBoard);
    }

    public static char[][] getPlayerBoard(String playerName, Scanner scan) {
        System.out.printf("%s, ENTER YOUR SHIPS' COORDINATES.\n", playerName);
        char[][] board = new char[5][5];

        for (int i = 0; i < board.length; i++) {
            Boolean receivedValidCoords = false;
            do {
                System.out.printf("Enter ship %d location: \n", i + 1);
                int[] coords = getInput(scan);
                int x = coords[0];
                int y = coords[1];
                if (
                    (coords[0] < 0 || coords[0] > 4) ||
                    (coords[1] < 0 || coords[1] > 4)
                ) {
                    System.out.println("Invalid coordinates. Choose different coordinates.");
                    continue;
                } else if (
                    board[x][y] != 0
                ) {
                    System.out.println("You already have a ship there. Choose different coordinates.");
                    continue;
                } else {
                    board[x][y] = '@';
                    receivedValidCoords = true;
                }
            } while (!receivedValidCoords);
        }

        fillBoard(board);
        return board;
    }

    public static void fillBoard(char[][] board) {
        for (char[] row: board) {
            for (int i = 0; i < row.length; i++) {
                if (row[i] != '@') {
                    row[i] = '-';
                }
            }
        }
    }

    public static int[] getInput(Scanner scan) {
        int[] input = new int[2];
        input[0] = scan.nextInt();
        input[1] = scan.nextInt();

        return input;
    }

    public static Boolean fireShot(
        Scanner scan,
        char[][] opposingBoard,
        char[][] trackingBoard,
        String player
    ) {
        Boolean wasShipHit = false;
        Boolean receivedValidCoords = false;
        String opposingPlayer = player.charAt(player.length() - 1) == '1' ?
            "PLAYER 2" :
            "PLAYER 1";

        // needed because, for some inexplicable reason, the string below needs to be capital case
        // as opposed to every other occurrence, which is all caps
        String capitalCasePlayer = player
            .toLowerCase()
            .substring(0, 1).toUpperCase() + player.toLowerCase().substring(1);
        do {
            System.out.printf("%s, enter hit row/column:\n", capitalCasePlayer);
            int[] coords = getInput(scan);
            int x = coords[0];
            int y = coords[1];
            if ((x < 0 || x > 4) || (y < 0 || y > 4)) {
                System.out.println("Invalid coordinates. Choose different coordinates.");
                continue;
            }

            char hitPos = opposingBoard[x][y];
            if (
                hitPos == 'X' || hitPos == '0'
            ) {
                System.out.println("You already fired on this spot. Choose different coordinates.");
                continue;
            } else if (hitPos == '-') {
                System.out.printf("%s MISSED!\n", player);
                opposingBoard[x][y] = 'O';
                trackingBoard[x][y] = 'O';
                receivedValidCoords = true;
            } else if (hitPos == '@') {
                System.out.printf("%s HIT %s's SHIP!\n", player, opposingPlayer);
                wasShipHit = true;
                opposingBoard[x][y] = 'X';
                trackingBoard[x][y] = 'X';
                receivedValidCoords = true;
            }
        } while (!receivedValidCoords);

        return wasShipHit;
    }

    // Use this method to print game boards to the console.
    private static void printBattleShip(char[][] player) {
        System.out.print("  ");
        for (int row = -1; row < 5; row++) {
            if (row > -1) {
                System.out.print(row + " ");
            }
            for (int column = 0; column < 5; column++) {
                if (row == -1) {
                    System.out.print(column + " ");
                } else {
                    System.out.print(player[row][column] + " ");
                }
            }
            System.out.println("");
        }
    }
}