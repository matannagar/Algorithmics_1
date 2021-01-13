package numbersGame;

public class FullSearchIterative {

    public static void main(String[] args) {
        int[] input = {1,3,6,1,3,6};

        Iterative(input);

    }
    public static void Iterative(int[] input) {
        Node[] game = new Node[(int)Math.pow(2, input.length)-1];
        game[0] = new Node(0, input.length-1);

        //create tree of indexes
        for (int i = 0; i < game.length/2; i++) {
            game[2*i+1] = new Node(game[i].leftIndex+1, game[i].rightIndex);
            game[2*i+2] = new Node(game[i].leftIndex, game[i].rightIndex-1);
        }

        //set value and path of leaves
        for (int i = game.length/2; i < game.length; i++)
        {
            game[i].value = input[game[i].leftIndex]; // game[i].leftIndex == game[i].rightIndex
            game[i].path =  game[i].rightIndex + "";
        }

        //set value and path of inner verteces
        for (int i = game.length/2 - 1; i >= 0; i--) {
            if (input[game[i].leftIndex] - game[2*i+1].value >= input[game[i].rightIndex] - game[2*i+2].value)
            {
                game[i].value = input[game[i].leftIndex] - game[2*i+1].value;
                game[i].path = game[i].leftIndex + "->" + game[2*i+1].path;
            }
            else
            {
                game[i].value = input[game[i].rightIndex] - game[2*i+2].value;
                game[i].path = game[i].rightIndex + "->" + game[2*i+2].path;
            }
        }

        System.out.println("value = " + game[0].value);
        System.out.println("path = " + game[0].path);
    }
    static class Node{
        public int leftIndex;
        public int rightIndex;
        public int value;
        public String path;

        public Node(int left, int right)
        {
            leftIndex = left;
            rightIndex = right;
            value = 0;
            path = "";
        }
    }
}