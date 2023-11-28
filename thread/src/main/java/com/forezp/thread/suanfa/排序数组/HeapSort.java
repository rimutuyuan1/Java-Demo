package com.forezp.thread.suanfa.排序数组;

/**
 * @Author 王鑫涛
 * @Description TODO
 * @Date 2023-11-26  18:58
 **/
public class HeapSort {

    public int[] heapSort(int[] nums) {
        if (nums.length <= 1) return nums;
        int  n = nums.length;
        //通过大根堆的规则重新排列数组，保证数组严格按照大根堆的方式排序
        for (int i = 0; i < n; i++) {
            heapInsert(nums, i);
        }
        //此时数组顺序仅为基于大顶堆的规则排好的，但还不是一个有序数组（但数组第一个元素为数组最大元素）
        // 需要通过将最大元素q和数组最后一个元素p交换，把最大元素取出
        // 然后元素p此时已被置换到数组的第一个位置，所以仍然通过向下调整大根堆的方式构造出除q以外的大根堆
        // 然后继续同数据的最后一个位置交换，不断while循环把数组排好
        // 总结：一个无序数组通过构建大根堆的方式排好，然后不断通过交换并重构大根堆的方式把数组排好
        int size = n;
        while (size > 1) {
            // 交换第一个位置（数最大）和最后一个位置的值
            swap(nums, 0, --size);
            // 然后将数组第一个位置的值下沉比较，放入数组合适的位置
            heapify(nums, 0, size);
        }
        return nums;
    }

    /**
     * 向下调整大根堆
     */
    public void heapify(int[] nums, int i, int size) {
        int left = 2 * i + 1;
        while (left < size) {
            // 此时有左孩子
            // 需要比较左孩子和右孩子哪个更棒（更大），然后下标i位置的值和更棒的孩子交换
            int right = left + 1;
            int best = right < size && nums[left] > nums[right] ? left : right;
            // 此时左右孩子之间的pk已经落下帷幕，需要判断下标i位置的值和best位置的值再比较
            best = nums[best] > nums[i] ? best : i;
            if (best == i) {
                break;
            }
            // 交换best和i位置的值
            swap(nums, best, i);
            // 继续下沉比较
            i = best;
            left = 2 * i + 1;
        }
    }

    /**
     * 构建大顶堆
     * i位置的数
     */
    public void heapInsert(int[] nums, int i) {
        //父节点的位置
        int j = (i - 1) / 2;
        //如果下标i位置的值大于下标j（父节点）的值，需要父子节点位置的值交换，直到父节点位置的值大于等于子节点位置的值
        while (nums[i] > nums[j]) {
            swap(nums, i, j);
            i = j;
        }
    }

    /**
     * 交换下标i和下标j的位置
     */
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
