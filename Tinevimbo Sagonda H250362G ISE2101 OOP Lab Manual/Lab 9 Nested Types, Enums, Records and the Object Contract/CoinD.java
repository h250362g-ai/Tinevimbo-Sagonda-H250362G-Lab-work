import java.util.ArrayList;
import java.util.List;

enum Coin {
    PENNY(1),
    NICKEL(5),
    DIME(10),
    QUARTER(25);

    private final int value;

    Coin(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static List<Coin> fewestCoins(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException(
                    "Amount cannot be negative.");
        }

        List<Coin> result = new ArrayList<>();

        Coin[] coins = Coin.values();

        // Start with the largest coin.
        for (int i = coins.length - 1; i >= 0; i--) {
            Coin coin = coins[i];

            while (amount >= coin.getValue()) {
                result.add(coin);
                amount -= coin.getValue();
            }
        }

        return result;
    }
}

public class CoinD {
    public static void main(String[] args) {
        int amount = 87;

        List<Coin> coins = Coin.fewestCoins(amount);

        System.out.println("Amount: " + amount + " cents");
        System.out.println("Coins used: " + coins);
        System.out.println("Number of coins: " + coins.size());
    }
}