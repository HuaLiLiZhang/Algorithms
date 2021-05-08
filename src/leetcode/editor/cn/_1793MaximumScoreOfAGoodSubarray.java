package leetcode.editor.cn;

//给你一个整数数组 nums （下标从 0 开始）和一个整数 k 。 
//
// 一个子数组 (i, j) 的 分数 定义为 min(nums[i], nums[i+1], ..., nums[j]) * (j - i + 1) 。一个
// 好 子数组的两个端点下标需要满足 i <= k <= j 。 
//
// 请你返回 好 子数组的最大可能 分数 。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [1,4,3,7,4,5], k = 3
//输出：15
//解释：最优子数组的左右端点下标是 (1, 5) ，分数为 min(4,3,7,4,5) * (5-1+1) = 3 * 5 = 15 。
// 
//
// 示例 2： 
//
// 输入：nums = [5,5,4,5,4,1,1,1], k = 0
//输出：20
//解释：最优子数组的左右端点下标是 (0, 4) ，分数为 min(5,5,4,5,4) * (4-0+1) = 4 * 5 = 20 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 105 
// 1 <= nums[i] <= 2 * 104 
// 0 <= k < nums.length 
// 
// Related Topics 贪心算法 
// 👍 35 👎 0


public class _1793MaximumScoreOfAGoodSubarray {
    public static void main(String[] args) {
        Solution t = new _1793MaximumScoreOfAGoodSubarray().new Solution();
        int[] nums = {1, 4, 3, 7, 4, 5};
        int k = 3;
        System.out.println(t.maximumScore(nums, k));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * https://leetcode-cn.com/problems/maximum-score-of-a-good-subarray/solution/c-shuang-zhi-zhen-tan-xin-zui-jian-ji-zu-b3vf/
         * 双指针 + 贪心，从k开始向左向右寻找以 nums[k] 为最小值的好子数组
         * 随后更新nums[k] 为左右边界中的较大者，继续寻找以 nums[k] 为最小值的好子数组
         * 若一边已更新完，直接更新为另一边的边界值即可
         */
        public int maximumScore(int[] nums, int k) {
            int left = k, right = k;
            int min = nums[k];
            int answer = 0;
            while (true) {
                while (right < nums.length && nums[right] >= min) {
                    right++;
                }
                while (left >= 0 && nums[left] >= min) {
                    left--;
                }
                answer = Math.max(answer, (right - left - 1) * min);
                if (left < 0 && right == nums.length) {
                    break;
                }

                if (left >= 0 && right < nums.length) {
                    min = Math.max(nums[left], nums[right]);
                } else if (left < 0) {
                    min = nums[right];
                } else {
                    min = nums[left];
                }
            }
            return answer;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}