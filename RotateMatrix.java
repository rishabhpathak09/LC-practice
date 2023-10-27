public class RotateMatrix {
    static public void rotate(int[][] matrix) {
        solve(0, matrix.length-1, matrix );
    }

    static void solve(int b, int e, int[][] mat){
        if (e<=b) return;
        solve(b+1,e-1, mat);
        for (int i=0; i<e-b; i++ ){
            int tmp = mat[e-i][b];
            mat[e-i][b] = mat[e][e-i];
            mat[e][e-i] = mat[b+i][e];
            mat[b+i][e] = mat[b][b+i];
            mat[b][b+i] = tmp;
        }
    }
}
