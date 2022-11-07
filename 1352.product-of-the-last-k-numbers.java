import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=1352 lang=java
 *
 * [1352] Product of the Last K Numbers
 */

// @lc code=start
class ProductOfNumbers {
    private List<Integer> preProduct;

    public ProductOfNumbers() {
        preProduct = new ArrayList<>();
        preProduct.add(1);
    }
    
    public void add(int num) {
        if(num == 0) {
            preProduct.clear();
            preProduct.add(1);
            return;
        }
        int n = preProduct.size();
        preProduct.add(num * preProduct.get(n-1));
    }
    
    public int getProduct(int k) {
        int n = preProduct.size();
        if(k > n - 1) return 0;
        return preProduct.get(n - 1) / preProduct.get(n - k - 1);
        
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */
// @lc code=end

