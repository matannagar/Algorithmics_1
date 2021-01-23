package Three_Way_Battle;

import java.util.ArrayList;

public class three_way_battle {


        public static void main(String[] args) {
            ArrayList<Integer> arr;
            //player0 = A = 100%, player1 = B = 80%, player2 = C = 50%
            int place;
            double prob;
            int[] winners  = new int[3];
            int player;
            for (int i = 0; i < 1000000; i++)
            {
                arr = CreateRandomQueue();
                player = 0;
                while(arr.size() == 3)
                {
                    switch(arr.get((player)%3))
                    {
                        case 0:
                            place = GetIndexOfPlayer(arr, 1);
                            arr.remove(place);//Kill player2;
                            place = GetIndexOfPlayer(arr, 0);
                            if (player != place)
                                winners[Two_battle(arr, player)]++;
                            else
                                winners[Two_battle(arr, player+1)]++;
                            break;
                        case 1:
                            place = GetIndexOfPlayer(arr, 0);
                            prob = Math.random();
                            if (prob <= 0.8) {
                                arr.remove(place);//Kill player1;
                                winners[Two_battle(arr, player+1)]++;
                            }
                            break;
                        case 2:
                            //do Nothing
                            break;
                    }
                    player++;
                }
            }
            System.out.println("A : " + winners[0]/10000.0 + "%, B : " + winners[1]/10000.0 + "%, C : " + winners[2]/10000.0 + "%");
        }

        private static int Two_battle(ArrayList<Integer> arr, int turn) {
            turn = turn % 2;

            switch (arr.get(turn))
            {
                case 0: return 0;
                case 1: if (Math.random() <= 0.8)
                    return 1;
                    break;
                case 2: if (Math.random() <= 0.5)
                    return 2;
                    break;
            }
            return Two_battle (arr, turn+1);
        }
        private static int GetIndexOfPlayer(ArrayList<Integer> arr, int player) {
            for (int i = 0; i < arr.size(); i++) {
                if (arr.get(i) == player)
                    return i;
            }
            return -1;
        }

        private static ArrayList<Integer> CreateRandomQueue() {
            ArrayList<Integer> arr = new ArrayList<Integer>();
            arr.add(0);
            arr.add(1);
            arr.add(2);

            ArrayList<Integer> ans = new ArrayList<Integer>();

            //choose first player
            int num = (int)(Math.random() * 3);
            ans.add(arr.get(num));
            arr.remove(num);

            //choose second player
            num = (int)(Math.random() * 2);
            ans.add(arr.get(num));
            arr.remove(num);

            //choose last player
            ans.add(arr.get(0));

            return ans;
        }

    }
