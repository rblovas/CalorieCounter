package program.service;

public class ResultService {

    private static int sum;

    public static void setSum(int sum) {
        ResultService.sum = sum;
    }

    public static int getSum() {
        return ResultService.sum;
    }
}
