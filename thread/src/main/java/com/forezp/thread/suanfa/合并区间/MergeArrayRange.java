package com.forezp.thread.suanfa.合并区间;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Author 王鑫涛
 * @Description 合并区间
 * @Date 2023-11-16  15:01
 **/
public class MergeArrayRange {


    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 1) {
            return intervals;
        }

        Arrays.sort(intervals, Comparator.comparingInt(x -> x[0]));

        List<int[]> res = new ArrayList<>();
        //五种情况：
        // 1. 存在交集：将res的最后一个元素的右边界A更新为 intervals的右边界和A的最大值
        // 2. 全包含：跳过，也可同第一种情况
        // 3. 不存在交集：intervals[i]放入res
        // 4. res最后一个元素的右边界A与intervals的左边界B相等：同第一种情况
        // 5. res最后一个元素的左边界A与intervals的左边界B相等 && res最后一个元素的右边界C小于intervals的右边界D：同第一种情况
        // ========>  最终就有两种情况
        // 1. 直接放入intervals[i]
        // 2. 更新右边界
        for (int i = 0; i < intervals.length; i++) {
            //intervals数组的第i个元素的左边界
            int inter_left = intervals[i][0];
            int inter_right = intervals[i][1];
            //如果right < left,说明最后可以直接放进来（已经排好序了）
            if (i == 0 || res.get(res.size() - 1)[1] < inter_left) {
                //说明无交集
                res.add(intervals[i]);
            } else {
                res.get(res.size() - 1)[1] = Math.max(res.get(res.size() - 1)[1], inter_right);
            }
        }
        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        MergeArrayRange m = new MergeArrayRange();
        int[][] range = new int[4][];
        range[0] = new int[]{1,3};
        range[1] = new int[]{2,6};
        range[2] = new int[]{8,10};
        range[3] = new int[]{15,18};
        int[][] merge = m.merge(range);
        System.out.println(Arrays.toString(merge));
    }

}
