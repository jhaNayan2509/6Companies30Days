class Solution {
    public List<String> invalidTransactions(String[] transactions) {
        List<String> res = new ArrayList<>();
        int n = transactions.length;
        String[] name = new String[n];
        int[] time = new int[n];
        int[] amount = new int[n];
        String[] city = new String[n];
        boolean[] add = new boolean[n];
        for (int i = 0; i < n; i++) {
            String[] t = transactions[i].split(",");
            name[i] = t[0];
            time[i] = Integer.valueOf(t[1]);
            amount[i] = Integer.valueOf(t[2]);
            city[i] = t[3];
            if (amount[i] > 1000) {
                add[i] = true;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (name[i].equals(name[j]) && Math.abs(time[i] - time[j]) <= 60 && !city[i].equals(city[j])) {
                    add[i] = true;
                    add[j] = true;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (add[i]) {
                res.add(transactions[i]);
            }
        }
        return res;
    } 
}