package sparseArray;

/**

 * @Description TODO
 * @Date 3/31/2020 10:07 AM
 * @Created by Administrator
 */
public class SparseArray {
    public static void main(String[] args) {
        //1.定义一个11*11的二维数组棋盘
        int[][] chessArray = new int[11][8];
        //2.0代表空白 1代表黑子 2代表白子
        chessArray[1][2] = 1;
        chessArray[2][3] = 2;

        System.out.println("原二維數組:");
        for (int[] row : chessArray) {
            for (int chess : row) {
                System.out.printf("\t" + chess);
            }
            System.out.println();
        }

        //1.获得稀疏数组列数
        int sum = 0;
        for (int i = 0; i < chessArray.length; i++) {
            for (int j = 0; j < chessArray[0].length; j++) {
                if (chessArray[i][j] != 0) {
                    sum++;
                }
            }
        }
        System.out.println("原數組共有" + sum + "個有效元素");
        //2.初始化稀疏数组
        int[][] sparseArray = new int[sum + 1][3];
        //3.插入稀疏数组的第一行
        sparseArray[0][0] = 0;
        sparseArray[0][1] = chessArray.length;
        sparseArray[0][2] = chessArray[0].length;
        //4.插入稀疏數組數據行
        int count = 0;
        for (int i = 0; i < chessArray.length; i++) {
            for (int j = 0; j < chessArray[0].length; j++) {
                if (chessArray[i][j] != 0) {
                    count++;
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = chessArray[i][j];
                }
            }
        }
        //5.輸出稀疏數組
        System.out.println("稀疏數組：");
        for (int[] row : sparseArray) {
            for (int item : row) {
                System.out.printf("\t" + item);
            }
            System.out.println();
        }
        //6.將稀疏數組轉爲二維數組
        int newChessArr[][] = new int[sparseArray[0][1]][sparseArray[0][2]];

        for (int i = 1; i < sparseArray.length; i++) {
            newChessArr[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }
        //輸出原二位數組
        System.out.println("原二維數組:");
        for (int[] row : newChessArr) {
            for (int chess : row) {
                System.out.printf("\t" + chess);
            }
            System.out.println();
        }
    }

}
