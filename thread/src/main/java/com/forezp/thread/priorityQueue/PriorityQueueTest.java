package com.forezp.thread.priorityQueue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
/**
 * @Author 王鑫涛
 * @Description TODO
 * @Date 2023-11-07  21:51
 **/
public class PriorityQueueTest {

    public static void main(String[] args) {
        Comparator<PriorityItem<String>> comparator = Comparator.comparingInt(PriorityItem::getPriority);
        PriorityQueue<String> priorityQueue = new PriorityQueue<>(comparator);

        priorityQueue.enqueue("Item 1", 2);
        priorityQueue.enqueue("Item 2", 1);
        priorityQueue.enqueue("Item 3", 3);

        while (!priorityQueue.isEmpty()) {
            String item = priorityQueue.dequeue();
            System.out.println(item);
        }
    }

    static class PriorityItem<T> {
        private T item;
        private int priority;

        public PriorityItem(T item, int priority) {
            this.item = item;
            this.priority = priority;
        }

        public T getItem() {
            return item;
        }

        public int getPriority() {
            return priority;
        }
    }

    static class PriorityQueue<T> {
        private List<PriorityItem<T>> heap;
        private Comparator<PriorityItem<T>> comparator;

        public PriorityQueue(Comparator<PriorityItem<T>> comparator) {
            this.heap = new ArrayList<>();
            this.comparator = comparator;
        }

        public void enqueue(T item, int priority) {
            PriorityItem<T> newItem = new PriorityItem<>(item, priority);
            heap.add(newItem);
            siftUp(heap.size() - 1);
        }

        public T dequeue() {
            if (isEmpty()) {
                throw new IllegalStateException("PriorityQueueTest is empty");
            }

            PriorityItem<T> root = heap.get(0);
            PriorityItem<T> lastItem = heap.remove(heap.size() - 1);
            if (!isEmpty()) {
                heap.set(0, lastItem);
                siftDown(0);
            }
            return root.getItem();
        }

        public boolean isEmpty() {
            return heap.isEmpty();
        }

        private void siftUp(int index) {
            while (index > 0) {
                int parentIndex = (index - 1) / 2;
                if (comparator.compare(heap.get(index), heap.get(parentIndex)) > 0) {
                    swap(index, parentIndex);
                    index = parentIndex;
                } else {
                    break;
                }
            }
        }

        private void siftDown(int index) {
            int size = heap.size();
            while (index < size) {
                int leftChildIndex = 2 * index + 1;
                int rightChildIndex = 2 * index + 2;
                int maxIndex = index;

                if (leftChildIndex < size && comparator.compare(heap.get(leftChildIndex), heap.get(maxIndex)) > 0) {
                    maxIndex = leftChildIndex;
                }

                if (rightChildIndex < size && comparator.compare(heap.get(rightChildIndex), heap.get(maxIndex)) > 0) {
                    maxIndex = rightChildIndex;
                }

                if (maxIndex != index) {
                    swap(index, maxIndex);
                    index = maxIndex;
                } else {
                    break;
                }
            }
        }

        private void swap(int index1, int index2) {
            PriorityItem<T> temp = heap.get(index1);
            heap.set(index1, heap.get(index2));
            heap.set(index2, temp);
        }
    }

}
