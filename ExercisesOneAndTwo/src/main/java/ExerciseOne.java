import java.util.Arrays;

public class ExerciseOne {
    public static void main(String[] args){
        System.out.println(missingNumber(new int[]{1,3,6,4,1,2}));
    }
    public static int missingNumber(int[] A){
        int num = 1;

        Arrays.sort(A);
        for (int j : A) {
            if (j == num) {
                num++;
            }
        }

        return num;
    }
}
