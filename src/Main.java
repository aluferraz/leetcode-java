import leetcode.editor.en.Q715.RangeModule;
import leetcode.editor.en.Q901.OnlineStockSpan;

public class Main {
    public static void main(String[] args) {
//        RangeModule rangeModule = new RangeModule();
//        rangeModule.addRange(10, 20);
//        rangeModule.removeRange(14, 16);
//        rangeModule.queryRange(10, 14); // return True,(Every number in [10, 14) is being tracked)
//        rangeModule.queryRange(13, 15); // return False,(Numbers like 14, 14.03, 14.17 in [13, 15) are not being tracked)
//        rangeModule.queryRange(16, 17); // return True, (The number 16 in [16, 17) is still being tracked, despite the remove operation)
        OnlineStockSpan stockSpanner = new OnlineStockSpan();
//        stockSpanner.next(100); // return 1
//        stockSpanner.next(80);  // return 1
//        stockSpanner.next(60);  // return 1
//        stockSpanner.next(70);  // return 2
//        stockSpanner.next(60);  // return 1
//        stockSpanner.next(75);  // return 4, because the last 4 prices (including today's price of 75) were less than or equal to today's price.
//        stockSpanner.next(85);  // return 6
        stockSpanner.next(32);
        stockSpanner.next(82);
        stockSpanner.next(73);
        stockSpanner.next(99);
        stockSpanner.next(91);
    }
}
