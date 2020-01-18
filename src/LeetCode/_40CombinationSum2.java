package LeetCode;

import java.util.*;

/**
 * Created by mizhu on 19-7-21 下午3:39
 */
public class _40CombinationSum2 {

    public static void main(String[] args) {
        int[] candidates = {1,1,1,2,2};
        System.out.println(combinationSum2(candidates, 4));
    }
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return res;
        }

        Arrays.sort(candidates);

        Set<List<Integer>> reSet = new HashSet<>();
        doCombination(0, candidates, reSet, target, new ArrayList<>());

        res.addAll(reSet);
        return res;
    }

    public static void doCombination(int start, int[] candidates, Set<List<Integer>> res,
                              int target, List<Integer> curList) {
        if (target == 0) {
            res.add(new ArrayList<>(curList));
        } else if (target < 0) {
            return;
        } else {
            for (int i = start; i < candidates.length; i++) {
                if (candidates[i] > target) {
                    return;
                }
                /*
                每个值有且仅有一次被加入队列的机会，就是递归至此值为start的时候
                avoid duplicate combinations. Consider following example:
                Search in [1, 1, 1, 2, 2] for target 4, without the expression, you will get three identical combinations:
                [1, 1, 2, 2] from index [0, 1, 3, 4] of the candidates;
                [1, 1, 2, 2] from index [0, 2, 3, 4] of the candidates;
                [1, 1, 2, 2] from index [1, 2, 3, 4] of the candidates.
                 */
                if (i > start && candidates[i] == candidates[i-1]){
                    continue;
                }
                curList.add(candidates[i]);
                doCombination(i + 1, candidates, res, target - candidates[i], curList);
                curList.remove(curList.size() - 1);
            }
        }
    }
}
