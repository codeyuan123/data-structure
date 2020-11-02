package com.colbert.array;

/**
 * @Description 将一般的数组转换为稀疏数组
 * @Date 2020/10/27 18:44
 * @Author Colbert
 */
public class Demo {
    public static void main(String[] args) {
        int[][] array = new int[10][11];
        array[0][5] = 1;
        array[4][2] = 3;
        array[9][4] = 6;
        System.out.println("转换前------------------------");
        for (int[] ints : array) {
            for (int anInt : ints) {
                System.out.print(anInt + "\t");
            }
            System.out.println();

        }
        int[][] ints = toSparseArray(array);
        System.out.println("转换后------------------------");
        for (int[] anInt : ints) {
            for (int i : anInt) {
                System.out.print(i+"\t");
            }
            System.out.println();
        }
        int[][] nums = toArray(ints);
        for (int[] num : nums) {
            for (int i : num) {
                System.out.print(i+"\t");
            }
            System.out.println();
        }
    }

    /**
     * 传入一个二维数组，将其转换为一个稀疏数组后返回
     * @param arr 一般数组
     * @return 稀疏数组
     */
    public static int[][] toSparseArray(int[][] arr) {
        // 设置一个计数器
        int count = 0;

        // 一次遍历得到所有的不为0的数据个数
        for (int[] ints : arr) {
            for (int num : ints) {
                if (num != 0) {
                    count++;
                }
            }
        }

        int[][] sparseArray = new int[count + 1][3];
        int row = arr.length;
        int col = arr[0].length;
        sparseArray[0][0] = row;
        sparseArray[0][1] = col;
        sparseArray[0][2] = count;

        // 设置一个标记，指向当前行
        int currentRow = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j <arr[i].length; j++) {
                if (arr[i][j] != 0) {
                    currentRow++;
                    sparseArray[currentRow][0] = i;
                    sparseArray[currentRow][1] = j;
                    sparseArray[currentRow][2] = arr[i][j];
                }
            }
        }
        return sparseArray;

    }

    /**
     * 将稀疏数组转换为一般数组后返回
     * @param sparseArray
     * @return 一般数组
     */
    public static int[][] toArray(int[][] sparseArray) {
        int row = sparseArray[0][0];
        int col = sparseArray[0][1];

        int[][] array = new int[row][col];
        for (int i = 1; i < sparseArray.length; i++) {
            int j = sparseArray[i][0];
            int k = sparseArray[i][1];
            int num = sparseArray[i][2];
            array[j][k] = num;
        }
        return array;
    }


}
