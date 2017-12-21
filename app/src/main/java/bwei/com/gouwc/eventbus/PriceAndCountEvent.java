package bwei.com.gouwc.eventbus;

/**
 * Created by DangByMySide on 2017/12/19.
 */

public class PriceAndCountEvent {
    private int price;
    private int count;



    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
