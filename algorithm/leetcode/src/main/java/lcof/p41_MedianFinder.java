package lcof;

import java.util.PriorityQueue;

public class p41_MedianFinder {
    // java 默认小顶堆， 小顶堆存大的那部分数据，大顶堆存小的那部分数据
    PriorityQueue<Integer> maxQueue;
    PriorityQueue<Integer> minQueue;

    p41_MedianFinder() {
        minQueue = new PriorityQueue();
        maxQueue = new PriorityQueue<>((x, y) -> y - x);
    }

    public void addNum(int num) {
        maxQueue.offer(num);
        if ((maxQueue.size() - minQueue.size()) > 1) {
            minQueue.offer(maxQueue.poll());
        }
        if(minQueue.size() > 0 && maxQueue.peek() > minQueue.peek()) {
           minQueue.offer(maxQueue.poll());
           maxQueue.offer(minQueue.poll());
        }

    }

    public double findMedian() {
        int rs = (maxQueue.size() + minQueue.size()) % 2;
        if (rs == 0) {
            return (maxQueue.peek() + minQueue.peek()) / 2d;
        } else {
            return maxQueue.peek();
        }
    }

    public static void main(String[] args) {
        p41_MedianFinder finder = new p41_MedianFinder();
        finder.addNum(1);
        System.out.println(finder.findMedian());
        finder.addNum(2);
        System.out.println(finder.findMedian());
        finder.addNum(3);
        System.out.println(finder.findMedian());
        finder.addNum(-4);
        System.out.println(finder.findMedian());
        finder.addNum(-5);
        System.out.println(finder.findMedian());

    }

    ///
    // ["MedianFinder","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian"]
    //[[],[-1],[],[-2],[],[-3],[],[-4],[],[-5],[]]
}
