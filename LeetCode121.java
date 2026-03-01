class Solution {
    public static int calculate_profit(int buy_price, int sell_price){
        return sell_price - buy_price;
    }

    public static int max_profit_brute(int [] prices){
        int max_profit = 0;
        for(int i = 0; i < prices.length; i++){
            for(int j = i + 1; j < prices.length; j++){
                int profit = calculate_profit(prices[i], prices[j]);
                if(profit > max_profit){
                    max_profit = profit;
                }
            }
        }
        return max_profit;
    }

    public static int update_min_price(int current_min, int today_price){
        return Math.min(current_min, today_price);
    }

    public static int update_max_profit(int current_max, int potential_profit){
        return Math.max(current_max, potential_profit);
    }

    public static int maxProfit(int[] prices) {
        return max_profit_optimal(prices);
    }

    public static int max_profit_optimal(int [] prices){
        if((prices == null) || (prices.length == 0)){
            return 0;
        }
        int max_profit = 0;
        int min_prices = prices[0];

        for(int i = 1; i < prices.length; i++){
            min_prices = update_min_price(min_prices, prices[i]);
            int profit = calculate_profit(min_prices, prices[i]);
            max_profit = update_max_profit(max_profit, profit);
        }
        return max_profit;
    }

    public static void main(String [] args){
        //Test calculate_profit
        System.out.println("Testing calculate_profit:");
        System.out.println(calculate_profit(1, 6)); // 5
        System.out.println(calculate_profit(7, 1)); // -6

        //Test max_profit_brute
        System.out.println("\nTesting max_profit_brute:");
        System.out.println(max_profit_brute(new int[]{7, 1, 5, 3, 6, 4})); // 5
        System.out.println(max_profit_brute(new int[]{7, 6, 4, 3, 1})); // 0

        //Test update_min_price
        System.out.println("\nTesting update_min_price:");
        System.out.println(update_min_price(7, 1)); // 1
        System.out.println(update_min_price(1, 5)); // 1

        //Test update_max_profit
        System.out.println("\nTesting update_max_profit:");
        System.out.println(update_max_profit(0, 5)); // 5
        System.out.println(update_max_profit(5, 3)); // 5

        //Test max_profit_optimal
        System.out.println("\nTesting max_profit_optimal:");
        System.out.println(max_profit_optimal(new int[]{7, 1, 5, 3, 6, 4})); //5
        System.out.println(max_profit_optimal(new int[]{7, 6, 4, 3, 1})); // 0

        // Test final solution
        System.out.println("\nTesting maxProfit:");
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4})); // 5
        System.out.println(maxProfit(new int[]{7, 6, 4, 3, 1})); // 0
        System.out.println(maxProfit(new int[]{1, 2}));// 1
        System.out.println(maxProfit(new int[]{}));// 0
    }
}
