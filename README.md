# 写在最前

生病了几个月, 停止了学校的课程, 也算荒废了半年. 回家后, 家里一切安好. 
于是收拾心情, 又回到美国, 想要做点什么. 如果1月份前找不到fulltime, 就宣布放弃正常计划. 
从零刷题也只是尝试. 至少努力过.

-9.1.2018记


## 双指针 Two Pointer

###适用范围: 

1. 有序数组.
2. 原数组内交换.
3. 两数求和.


# 模板

## Quicksort

````java
public class Solution {
    /**
     * @param A an integer array
     * @return void
     */
    public void sortIntegers2(int[] A) {
        quickSort(A, 0, A.length - 1);
    }
    
    private void quickSort(int[] A, int start, int end) {
        if (start >= end) return;
        
        int left = start, right = end;
        int pivot = A[(start + end) / 2];
        while (left <= right) {
            while (left <= right && A[left] < pivot) {
                left++;
            }
            while (left <= right && A[right] > pivot) {
                right--;
            }
            if (left <= right) {
                int temp = A[left]; A[left] = A[right]; A[right] = temp;
                left++; right--;
            }
        }
        
        quickSort(A, start, right);
        quickSort(A, left, end);
    }
}
````