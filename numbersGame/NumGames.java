package numbersGame;

import java.util.Scanner;

class NumGames {

    public static void main(String[] args) {
        EvenOddAlgorithm();
    }

    public static void EvenOddAlgorithm() {
        Scanner in = new Scanner(System.in);
        String x ;
        //= in.nextLine();
        //System.out.println("you choose " + x);

        int[] Game = new int[10];
        int sumEven=0, sumOdd=0;
        // generate array and print it
        System.out.println("The game is : ");
        for (int i = 0; i < Game.length; i++) {
            Game[i] = (int)(Math.random()*50 + 1);
        }
        int start = 0, end = Game.length-1;
        print(Game, start, end);

        //calculate sum
        for (int i = 0; i < Game.length; i++) {
            if (i%2 == 0)
                sumEven += Game[i];
            else
                sumOdd += Game[i];
        }
        //choose the first move

        String compPath = "", playerPath="";

        int winner = 0, loser = 0;
        if (sumEven > sumOdd)
        {
            winner = sumEven;
            loser = sumOdd;
            compPath += Game[start]+", ";
            System.out.println("Computer = " + compPath);
            start++;
        }
        else
        {
            winner = sumOdd;
            loser = sumEven;
            compPath += Game[end]+", ";
            System.out.println("Computer = " + compPath);
            end--;
        }

        //other moves until the last move
        while (end-start>1)
        {
            print(Game, start, end);
            System.out.print("Choose l or r: ");
            x = in.nextLine();
            switch(x)
            {
                case "r":{
                    playerPath+=Game[end]+", ";
                    System.out.println("You = " + playerPath);
                    end--;
                    print(Game, start, end);
                    System.out.println("Computer choose: " + Game[end]);
                    compPath += Game[end]+", ";
                    end--;
                    break;
                }
                case "l":
                {
                    playerPath+=Game[start]+", ";
                    System.out.println("You = " + playerPath);
                    start++;
                    print(Game, start, end);
                    System.out.println("Computer choose: " + Game[start]);
                    compPath += Game[start]+", ";
                    start++;
                    break;
                }
            }


        }
        //last move
        System.out.println("You do not have a choise, you take the last number.");
        playerPath+=Game[end]+", ";
        System.out.println("You = " + playerPath);



        System.out.println("\n\n----------------------------------------");
        System.out.println("Computer sum: " + compPath + " = "+ winner);
        System.out.println("Your sum: " + playerPath + " = " +loser);
        System.out.println("----------------------------------------");
    }

    private static void print(int[] game, int start, int end) {
        System.out.print("\t\t\t\t");
        for (int i = start ; i <= end; i++) {
            System.out.print(game[i]+" ");
        }
        System.out.println();

    }

}