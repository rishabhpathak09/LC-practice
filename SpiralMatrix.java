import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SpiralMatrix {
    static public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res= solve(matrix, 0, matrix.length, 0, matrix[0].length);

        return res;
    }
    private static List<Integer> solve(int[][] mat, int mi, int mf, int ni, int nf){
        List<Integer> res= new ArrayList<Integer>();
        if (mi>mf || ni>nf){
            return res;
        }
        if (mi==mf && ni==nf){
            res.add(mat[mi][ni]);
            return res;
        }
        if (mi==mf){
            return Arrays.stream(mat[mi]).boxed().collect(Collectors.toList());
        }
        if (ni==nf){
            for (int i = mi; i< mf; i++){
                res.add(mat[i][nf]);
            }
            return res;
        }
        for (int i = ni; i< nf; i++){
            res.add(mat[mi][i]);
        }
        for (int i = mi; i< mf; i++){
            res.add(mat[i][nf]);
        }
        for (int i = nf; i> ni; i--){
            res.add(mat[mf][i]);
        }
        for (int i = mf; i> mi; i--){
            res.add(mat[i][ni]);
        }
        res.addAll(solve(mat, mi+1, mf-1, ni+1, nf-1));
        return res;
    }
}
