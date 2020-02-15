package easy.reverse_integer_7;

/**
 * ReverseInteger
 */
public class ReverseInteger {

    public static void main(String[] args) {
        System.out.println(reverse(1234));
    }

    public static int reverse(int x) {
        long tmpNumber = 0;
        int holdNumber = x;
        while (holdNumber != 0) {
            int tmp = (holdNumber % 10) < 0 ? (holdNumber % 10) * -1 : holdNumber % 10;
            tmpNumber = (tmpNumber * 10) + tmp;
            holdNumber /= 10;
        }
        return tmpNumber < Integer.MIN_VALUE || tmpNumber > Integer.MAX_VALUE ? 0
                : x < 0 ? (int) tmpNumber * -1 : (int) tmpNumber;
    }
}