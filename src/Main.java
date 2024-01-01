import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        startGame();
        Scanner scanner = new Scanner(System.in);
        char[][] board = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};

        while (true) {
            printBoard(board);
            playerTurn(scanner, board);

            if (isGameOver(board)) {
                break;
            }

            printBoard(board);
            computerTurn(board);

            if (isGameOver(board)) {
                break;
            }
        }
    }

    private static void startGame() {
        System.out.println("""
                |||||||||||||||||	|||     |||||||||||||   
                       |||			|||	    |||             
                       |||			|||	    |||             
                       |||			|||	    |||             
                       |||			|||	    |||||||||||||   
                                
                |||||||||||||||||	    |||||||		|||||||||||||
                       |||			   |||   |||	|||
                       |||			  |||	  |||   |||
                       |||			 ||| ||||| ||| 	|||
                       |||			|||		    ||| |||||||||||||
                                
                |||||||||||||||||   ||||||||||||	|||||||||||||
                       |||			|||      |||	|||
                       |||			|||      |||	|||||||||||||
                       |||			|||      |||	|||
                       |||			||||||||||||	|||||||||||||
                """);
        System.out.println("Welcome to Tic Tac Toe!");
        System.out.println("You are X, computer is 0");

    }

    private static boolean isGameOver(char[][] board) {
        if (hasWon(board, 'X')) {
            printBoard(board);
            System.out.println(" ");
            System.out.println("You won!");
            return true;
        }

        if (hasWon(board, '0')) {
            printBoard(board);
            System.out.println(" ");
            System.out.println("Computer won!");
            return true;
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        printBoard(board);
        System.out.println("Game is over!");
        return true;
    }

    private static boolean hasWon(char[][] board, char symbol) {
        if (board[0][0] == symbol && board[0][1] == symbol && board[0][2] == symbol ||
                board[1][0] == symbol && board[1][1] == symbol && board[1][2] == symbol ||
                board[2][0] == symbol && board[2][1] == symbol && board[2][2] != symbol ||

                board[0][0] == symbol && board[1][0] == symbol && board[2][0] == symbol ||
                board[0][1] == symbol && board[1][1] == symbol && board[2][1] == symbol ||
                board[0][2] == symbol && board[1][2] == symbol && board[2][2] == symbol ||

                board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol ||
                board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol) {
            return true;
        }
        return false;
    }

    private static boolean isPositionAvailable(char[][] board, int position) {
        switch (position) {
            case 1:
                return (board[0][0] == ' ');
            case 2:
                return (board[0][1] == ' ');
            case 3:
                return (board[0][2] == ' ');
            case 4:
                return (board[1][0] == ' ');
            case 5:
                return (board[1][1] == ' ');
            case 6:
                return (board[1][2] == ' ');
            case 7:
                return (board[2][0] == ' ');
            case 8:
                return (board[2][1] == ' ');
            case 9:
                return (board[2][2] == ' ');
            default:
                return false;
        }
    }

    private static void computerTurn(char[][] board) {
        Random random = new Random();
        int i;
        while (true) {
            i = random.nextInt(9) + 1;
            if (isPositionAvailable(board, i)) {
                System.out.println("Computer's move: " + i);
                switch (i) {
                    case 1:
                        board[0][0] = 'O';
                        break;
                    case 2:
                        board[0][1] = '0';
                        break;
                    case 3:
                        board[0][2] = '0';
                        break;
                    case 4:
                        board[1][0] = '0';
                        break;
                    case 5:
                        board[1][1] = '0';
                        break;
                    case 6:
                        board[1][2] = '0';
                        break;
                    case 7:
                        board[2][0] = '0';
                        break;
                    case 8:
                        board[2][1] = '0';
                        break;
                    case 9:
                        board[2][2] = '0';
                        break;
                    default:
                        System.out.println(":(");
                }
                break;
            }
        }
    }

    private static void playerTurn(Scanner scanner, char[][] board) {
        System.out.println("Make your move (1-9): ");
        String input = scanner.next();
        if (isPositionAvailable(board, Integer.parseInt(input))) {
            switch (input) {
                case "1":
                    board[0][0] = 'X';
                    break;
                case "2":
                    board[0][1] = 'X';
                    break;
                case "3":
                    board[0][2] = 'X';
                    break;
                case "4":
                    board[1][0] = 'X';
                    break;
                case "5":
                    board[1][1] = 'X';
                    break;
                case "6":
                    board[1][2] = 'X';
                    break;
                case "7":
                    board[2][0] = 'X';
                    break;
                case "8":
                    board[2][1] = 'X';
                    break;
                case "9":
                    board[2][2] = 'X';
                    break;
                default:
                    System.out.println(":(");
            }
        } else {
            System.out.println("Position not available, choose another one: ");
            playerTurn(scanner, board);
        }
    }

    private static void printBoard(char[][] board) {
        System.out.println(board[0][0] + "|" + board[0][1] + "|" + board[0][2]);
        System.out.println("-+-+-");
        System.out.println(board[1][0] + "|" + board[1][1] + "|" + board[1][2]);
        System.out.println("-+-+-");
        System.out.println(board[2][0] + "|" + board[2][1] + "|" + board[2][2]);
    }
}