public class HelloWorld{

     public static void main(String []args){
        int[][] matrix =  { {1,2,3,4},
                            {5,6,7,8},
                            {9,10,11,12},
                            {13,14,15,16}};
        int[][] test = 
        rotateMatrix(matrix);
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
     }
     
     public static void rotateMatrix(int[][] matrix){
        int n=matrix.length;
        for(int i=0;i<n/2;i++){
            int last = n-1-i;
            for(int j=i;j<last;j++){
                int offset = j - i;
                int temp = matrix[i][j]; // save top
                // left -> top
                matrix[i][j] = matrix[last-offset][i];
                //bottom -> left 
                matrix[last-j][i] = matrix[last][last-offset];
                // right ->bottom
                matrix[last][last-offset] = matrix[j][last];
                //top ->right
                matrix[j][last] = temp;
            }
        } 
     }
}