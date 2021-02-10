package leetcode.editor.cn;

//实现 int sqrt(int x) 函数。 
//
// 计算并返回 x 的平方根，其中 x 是非负整数。 
//
// 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。 
//
// 示例 1: 
//
// 输入: 4
//输出: 2
// 
//
// 示例 2: 
//
// 输入: 8
//输出: 2
//说明: 8 的平方根是 2.82842..., 
//     由于返回类型是整数，小数部分将被舍去。
// 
// Related Topics 数学 二分查找 
// 👍 589 👎 0


public class _69Sqrtx{
    public static void main(String[] args) {
        Solution t = new _69Sqrtx().new Solution();
        int sqrt = t.mySqrt(2147395599);
        System.out.println(sqrt);
    }
  
    /**
    
    */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int mySqrt(int x) {
        int low = 0, high = x, answer = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if ((long) mid * mid > x) {
                high = mid - 1;
            } else {
                // 求值为小于等于x的平方根
                // 因此只有小于等于的值才可能是候选
                answer = mid;
                low = mid + 1;
            }
        }
        return answer;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}