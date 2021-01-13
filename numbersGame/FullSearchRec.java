package numbersGame;

public class FullSearchRec {

    public static void main(String[] args) {
        int[] input = {5,7,4,6};

        Node[] Game = new Node[input.length];
        for (int i = 0; i < Game.length; i++) {
            Game[i] = new Node(input[i],"");
        }
        Node ans = recursive(Game, 0, Game.length-1);
        System.out.println("value = " +  ans.num+"\npath = "+ans.path);

    }

    static Node recursive(Node[] game, int start, int end) {
        // TODO Auto-generated method stub

        if (start != end)
        {
            Node left = recursive(game, start, end-1);
            Node right = recursive(game, start+1, end);
            if (game[start].num-right.num >= game[end].num-left.num){
                return new Node((game[start].num-right.num), (start+"->"+right.path));
            }
            else
                return new Node(game[end].num-left.num, end + "->" + left.path);

        }
        game[start].path = start+"";
        return game[start];
    }

    static class Node
    {
        public int num;
        public String path;

        public Node(int num, String path)
        {
            this.num = num;
            this.path="";
            if (path != "")
                this.path = path;
        }
    }
}
