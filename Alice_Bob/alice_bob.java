package Alice_Bob;

public class alice_bob {
    public static void main(String[] args) {
        int count = 0;
        int bob_de=0;

        for (int i = 0; i < 4; i++) {
            int alice = (int) (Math.random() * 2);
            int bob = (int) (Math.random() * 2);

            if (bob == 1)
                bob_de = 0;
            else if (bob == 0)
                bob_de = 1;
            if (alice == bob || alice ==bob_de)
                count++;
        }
        System.out.println(count);
    }
}
