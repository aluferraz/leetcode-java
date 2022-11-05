


import leetcode.editor.en.Q2034.StockPriceFluctuation;

public class Main {
    public static void main(String[] args) {
        StockPriceFluctuation st = new StockPriceFluctuation();
        st.update(1, 10);
        st.update(2, 5);
        System.out.println(st.current());
        System.out.println(st.maximum());
        st.update(1, 3);
        System.out.println(st.maximum());
        st.update(4, 2);
        System.out.println(st.minimum());
    }
}