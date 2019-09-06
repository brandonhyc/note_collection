# Array

## feature
TOO MANY EDGE CASES. ASK 1. empty array[]. 2. sorted? 3. duplicate? 4. in-place? 5. partial? pedis

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