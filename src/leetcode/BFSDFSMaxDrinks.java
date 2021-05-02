package leetcode;

public class BFSDFSMaxDrinks {
    public int maxDrink(int dollars) {
        int bought = dollars / 2;
        return bought / 2 + exchange(bought, bought);
    }
    public int exchange(int bottle, int cap) {
        if (bottle < 2 && cap <  4) {
            return 0;
        }
        int byBottle = bottle / 2;
        int byCap = cap / 4;
        return byBottle + byCap + exchange(bottle - byBottle + byCap, cap - (byCap * 3) + byBottle);
    }
}
