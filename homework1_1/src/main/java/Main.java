public class Main {

    public static void main(String[] args) throws InterruptedException {
        int[][] array = initArray();
        int min = array[0][0];
        int max = array [0][0];
        double average = 0.0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (array[i][j] < min) {
                    min=array[i][j];
                }
                if (array[i][j] > max) {
                    max = array[i][j];
                }
                average += array[i][j];
            }
        }
         average = average/100;
    }

    private static int[][] initArray() throws InterruptedException {
        int[][] array = new int[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                array[i][j] = (int) (System.currentTimeMillis() % 100);
                Thread.sleep(array[i][j]+10);
                System.out.println(array[i][j]);
            }
        }
        return array;
    }
}
