package leetcode;

public class ArrayFreshPromotion {
    public int winner(String[][] codes, String[] shoppingCart){
        StringBuilder regex = new StringBuilder(".*");

        for(String[] code : codes){
            for(String str : code){
                regex.append(str.equals("anything") ? ".+" : str);
            }
            regex.append(".*");
        }

        StringBuilder cart = new StringBuilder();

        for(String str : shoppingCart){
            cart.append(str);
        }

        return cart.toString().matches(regex.toString()) ? 1 : 0;
    }

    public int isWinner(String[][] codeList, String[] shoppingCart) {
        int listIdx = 0;
        int itemIdx = 0;
        while (itemIdx < shoppingCart.length && listIdx < codeList.length) {
            int nextItemIdx = matchList(codeList, shoppingCart, itemIdx, listIdx);
            if (nextItemIdx != -1) {
                itemIdx = nextItemIdx;
                listIdx ++;
            } else {
                itemIdx ++;
            }
        }
        return listIdx == codeList.length ? 1 : 0;
    }
    public int matchList(String[][] codeList, String[] shoppingCart, int itemBeginInx, int listInx) {
        int codeInx = 0;
        while (codeInx < codeList[listInx].length
                && itemBeginInx < shoppingCart.length
                && matchString(codeList[listInx][codeInx], shoppingCart[itemBeginInx])) {
            codeInx ++;
            itemBeginInx ++;
            if (codeInx == codeList[listInx].length) {
                return itemBeginInx;
            }
        }
        return -1;
    }
    private static boolean matchString(String source, String target) {
        return "anything".equals(target) || target.equals(source);
    }
}
