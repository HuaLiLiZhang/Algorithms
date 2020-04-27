package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mizhu
 * @date 2020/4/27 18:01
 * 在无限长的数轴（即 x 轴）上，我们根据给定的顺序放置对应的正方形方块。
 *
 * 第 i 个掉落的方块（positions[i] = (left, side_length)）是正方形，其中 left 表示该方块最左边的点位置(positions[i][0])，side_length 表示该方块的边长(positions[i][1])。
 *
 * 每个方块的底部边缘平行于数轴（即 x 轴），并且从一个比目前所有的落地方块更高的高度掉落而下。在上一个方块结束掉落，并保持静止后，才开始掉落新方块。
 *
 * 方块的底边具有非常大的粘性，并将保持固定在它们所接触的任何长度表面上（无论是数轴还是其他方块）。邻接掉落的边不会过早地粘合在一起，因为只有底边才具有粘性。
 *
 *  
 *
 * 返回一个堆叠高度列表 ans 。每一个堆叠高度 ans[i] 表示在通过 positions[0], positions[1], ..., positions[i] 表示的方块掉落结束后，目前所有已经落稳的方块堆叠的最高高度。
 *
 *  
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [[1, 2], [2, 3], [6, 1]]
 * 输出: [2, 5, 5]
 * 解释:
 *
 * 第一个方块 positions[0] = [1, 2] 掉落：
 * _aa
 * _aa
 * -------
 * 方块最大高度为 2 。
 *
 * 第二个方块 positions[1] = [2, 3] 掉落：
 * __aaa
 * __aaa
 * __aaa
 * _aa__
 * _aa__
 * --------------
 * 方块最大高度为5。
 * 大的方块保持在较小的方块的顶部，不论它的重心在哪里，因为方块的底部边缘有非常大的粘性。
 *
 * 第三个方块 positions[1] = [6, 1] 掉落：
 * __aaa
 * __aaa
 * __aaa
 * _aa
 * _aa___a
 * --------------
 * 方块最大高度为5。
 *
 * 因此，我们返回结果[2, 5, 5]。
 *  
 *
 * 示例 2:
 *
 * 输入: [[100, 100], [200, 100]]
 * 输出: [100, 100]
 * 解释: 相邻的方块不会过早地卡住，只有它们的底部边缘才能粘在表面上。
 *  
 *
 * 注意:
 *
 * 1 <= positions.length <= 1000.
 * 1 <= positions[i][0] <= 10^8.
 * 1 <= positions[i][1] <= 10^6.
 *
 */
public class _699FallingSquares {
    public static void main(String[] args) {
        int[] a ={1,2};
        int[] b ={2,3};
        int[] c ={3,7};
        int[][] aa = new int[3][2];
        aa[0] = a;
        aa[1] = b;
        aa[2] = c;
        _699FallingSquares t = new _699FallingSquares();
        System.out.println(t.fallingSquares(aa));
    }

    /**
     * 不要思考“哪个方块影响次此位置的高度？”，应该思考“一个方块影响哪些位置的高度？”。
     */
    public List<Integer> fallingSquares(int[][] positions) {
        if (positions == null || positions.length == 0) {
            return new ArrayList<>();
        }

        int[] high = new int[positions.length];
        for (int i=0;i<positions.length;i++) {
            int iLeft = positions[i][0];
            int iSize = positions[i][1];
            int iRight = iLeft + iSize;
            // 初始化每个位置箱子的高度
            high[i] += iSize;

            for (int j=i+1;j<positions.length;j++) {
                int jLeft = positions[j][0];
                int jSize = positions[j][1];
                int jRight = jLeft + jSize;
                // 如果i，j相交，则更新j处的高度
                // 第i个正方形放下后，如果和第j个正方形交叉，则第j个正方形的位置高度也被更新
                if (jLeft < iRight && iLeft < jRight) {
                    high[j] = Math.max(high[j], high[i]);
                }
            }
        }

        List<Integer> ans = new ArrayList<>();
        int currentHigh = 0;
        for (int h:high) {
            currentHigh = Math.max(h, currentHigh);
            ans.add(currentHigh);
        }

        return ans;

    }
}
