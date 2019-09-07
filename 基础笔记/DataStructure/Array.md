# Array


## 重新起步 set sum = 0 in condition
.134. Gas Station

## feature
TOO MANY EDGE CASES. ASK 1. empty array[]. 2. sorted? 3. duplicate? 4. in-place? 5. partial? pedis

.41. First Missing Positive

## Move, Store the need and Leave the left
Use slow and fast point, think of using one array as two 

## 三步反转
这个方法就用于数组平移

```
Let n=7 and k=3

Original List                   : 1 2 3 4 5 6 7
After reversing all numbers     :[7 6 5]4 3 2 1
After reversing first k numbers : 5 6 7[4 3 2 1]
After revering last n-k numbers : 5 6 7 1 2 3 4 --> Result

```
.189. Rotate Array

## 出现数字记数
用 nums[] +- 抵消。为0时即反转

.299. Bulls and Cows
.169. Majority Element

## Slide Window
.219. Contains Duplicate II

## Two pointer
.11. Container With Most Water

## 链表环状题


Suppose the first meet at step `k`, the distance between the start node of list and the start node of cycle is `s`, and the distance between the start node of cycle and the first meeting node is `m`. Then `2k = (s + m + n1r) = 2(s + m + n2r) ==> s + m = nr`. Steps moving from start node to the start of the cycle is just `s`, moving from m by `s` steps would be the start of the cycle, covering `n` cycles. In other words, they meet at the entry of cycle.