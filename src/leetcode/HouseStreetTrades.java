package leetcode;

import java.util.*;

public class HouseStreetTrades {
    /*
    https://leetcode.com/discuss/interview-question/882324/robinhood-phone-screen

    第四轮
    A trade is defined as a string containing the 4 properties given below separated by commas:

    Symbol (4 alphabetical characters, left-padded by spaces)
    Side (either "B" or "S" for buy or sell)
    Quantity (4 digits, left-padded by zeros)
    ID (6 alphanumeric characters)
    e.g.
    "AAPL,B,0100,ABC123"

    which represents a trade of a buy of 100 shares of AAPL with ID "ABC123"

    Given two lists of trades - called "house" and "street" trades, write code to create groups of matches between trades and return a list of unmatched house and street trades sorted alphabetically. Without any matching, the output list would contain all elements of both house and street trades. There are many ways to match trades, the first and most important way is an exact match:

    An exact match is a pair of trades containing exactly one house trade and exactly one street trade with identical symbol, side, quantity, and ID
    Note: Trades are distinct but not unique

    For example, given the following input:
    house_trades:
    [ "AAPL,B,0100,ABC123", "AAPL,B,0100,ABC123", "GOOG,S,0050,CDC333" ]
    street_trades:
    [ " FB,B,0100,GBGGGG", "AAPL,B,0100,ABC123" ]
    We would expect the following output:
    [ " FB,B,0100,GBGGGG", "AAPL,B,0100,ABC123", "GOOG,S,0050,CDC333" ]

    Because the first (or second) house trade and second street trade form an exact match, leaving behind three unmatched trades.

    Bonus 1 (Test 4 and 5): An attribute match is a match containing exactly one house trade and exactly one street trade with identical symbol, side, and quantity ignoring ID. Prioritize exact matches over attribute matches. Prioritize matching the earliest lexicographical house trade with the earliest lexicographical street trade in case of ties.

    Bonus 2: (Test 6) An offsetting match is a match containing exactly two house trades or exactly two street trades where the symbol and quantity of both trades are the same, but the side is different (one is a buy and one is a sell). Prioritize exact and attribute matches over offsetting matches. Prioritize matching the earliest lexicographical buy with the earliest lexicographical sell.

    */

    // find unmatched trades by doing exact match
    // symobl,side,quantity,id
    // " FB,B,0100,GBGGGG"
    public static List<String> getUnMatchOrders(String[] houseTrades, String[] streetTrades) {
        List<String> res = new ArrayList<>();
        List<String> house = Arrays.asList(houseTrades);
        List<String> street = Arrays.asList(streetTrades);
        Collections.sort(house);
        Collections.sort(street);
        Set<Integer> houseMatchesIndexes = new HashSet<>();
        Set<Integer> streetMatchesIndexes = new HashSet<>();
        //exact match
        findMatchesIndexes(house, street, houseMatchesIndexes, streetMatchesIndexes, 0);
        //attribute match
        findMatchesIndexes(house, street, houseMatchesIndexes, streetMatchesIndexes, 1);
        //offset match
        findMatchesIndexes(house, street, houseMatchesIndexes, streetMatchesIndexes, 2);

        addUnmatched(res, house, houseMatchesIndexes);
        addUnmatched(res, street, streetMatchesIndexes);
        return res;
    }

    private static void addUnmatched(List<String> res, List<String> list, Set<Integer> matchesIndexes) {
        for (int index = 0; index < list.size(); index++) {
            if (!matchesIndexes.contains(index)) {
                res.add(list.get(index));
            }
        }
    }

    private static void findMatchesIndexes(List<String> house, List<String> street, Set<Integer> hIndex, Set<Integer> sIndex, int matchCode) {
        for (int i = 0; i < house.size(); i ++) {
            if (!hIndex.contains(i)) {
                String[] houseArr = house.get(i).split(",");
                for (int j = 0; j < street.size(); j ++) {
                    String[] streetArr = street.get(j).split(",");
                    if (!sIndex.contains(j)) {
                        if ((matchCode == 0 && house.get(i).equals(street.get(j)))
                            || (matchCode == 1 && houseArr[0].equals(streetArr[0]) && houseArr[1].equals(streetArr[1]) && houseArr[2].equals(streetArr[2]))
                            || (matchCode == 2 && houseArr[0].equals(streetArr[0]) && !houseArr[1].equals(streetArr[1]) && houseArr[2].equals(streetArr[2]))) {
                            hIndex.add(i);
                            sIndex.add(j);
                            break;
                        }
                    }
                }
            }
        }
    }

        public static void main(String[] args) {
            System.out.println("Hello World!");

            String[] houseTrades = {
                    "AAPL,B,0100,ABC123", "AAPL,B,0100,ABC123", "GOOG,S,0050,CDC333"
            };
            String[] streetTrades = {
                    " FB,B,0100,GBGGGG", "AAPL,B,0100,ABC123"
            };
            System.out.println("Test case 0: " + getUnMatchOrders(houseTrades, streetTrades));

            houseTrades = new String[] {
                    "AAPL,B,0100,ABC123",
                    "GOOG,S,0050,CDC333"
            };
            streetTrades = new String[] {
                    "  FB,B,0100,GBGGGG",
                    "AAPL,B,0100,ABC123"
            };
            System.out.println("Test case 1: " + getUnMatchOrders(houseTrades, streetTrades));

            houseTrades = new String[] {
                    "AAPL,S,0010,ZYX444",
                    "AAPL,S,0010,ZYX444",
                    "AAPL,B,0010,ABC123",
                    "GOOG,S,0050,GHG545"
            };
            streetTrades = new String[] {
                    "GOOG,S,0050,GHG545",
                    "AAPL,S,0010,ZYX444",
                    "AAPL,B,0010,TTT222"
            };
            System.out.println("Test case 2: " + getUnMatchOrders(houseTrades, streetTrades));

            houseTrades = new String[] {
                    "AAPL,B,0010,ABC123",
                    "AAPL,S,0015,ZYX444",
                    "AAPL,S,0015,ZYX444",
                    "GOOG,S,0050,GHG545"
            };
            streetTrades = new String[] {
                    "GOOG,S,0050,GHG545",
                    "AAPL,S,0015,ZYX444",
                    "AAPL,B,0500,TTT222"
            };
            System.out.println("Test case 3: " + getUnMatchOrders(houseTrades, streetTrades));

            houseTrades = new String[] {
                    "AAPL,B,0100,ABC123",
                    "AAPL,B,0100,ABC123",
                    "AAPL,B,0100,ABC123",
                    "GOOG,S,0050,CDC333"
            };
            streetTrades = new String[] {
                    "  FB,B,0100,GBGGGG",
                    "AAPL,B,0100,ABC123",
                    "AAPL,B,0100,ABC123",
                    "GOOG,S,0050,CDC333",
            };
            System.out.println("Test case 4: " + getUnMatchOrders(houseTrades, streetTrades));

            houseTrades = new String[] {
                    "AAPL,B,0100,ABC123",
                    "AAPL,B,0100,ABC123",
                    "AAPL,B,0100,ABC123",
                    "GOOG,S,0050,CDC333"
            };
            streetTrades = new String[] {
                    "  FB,B,0100,GBGGGG",
                    "AAPL,B,0100,ABC123",
                    "AAPL,B,0100,ABC123",
                    "GOOG,S,0050,CDC333",
                    "AAPL,S,0100,ABC124"
            };
            // with offset pair
            System.out.println("Test case 5: " + getUnMatchOrders(houseTrades, streetTrades));

            houseTrades = new String[] {
                    "AAPL,B,0010,ABC123",
                    "AAPL,S,0015,ZYX444",
                    "AAPL,S,0015,ZYX444",
                    "AAPL,S,0015,ZYX444",
                    "AAPL,S,0015,ZYX444",
                    "AAPL,S,0015,ZYX444",
                    "GOOG,S,0050,GHG545"
            };
            streetTrades = new String[] {
                    "GOOG,S,0050,GHG545",
                    "AAPL,S,0015,ZYX444",
                    "AAPL,S,0015,ZYX444",
                    "AAPL,S,0015,ZYX444",
                    "AAPL,S,0015,ZYX444",
                    "AAPL,B,0500,TTT222"
            };
            System.out.println("Test case 6 (leetcode discuss): " + getUnMatchOrders(houseTrades, streetTrades));
        }
}
