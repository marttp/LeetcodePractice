package easy.palindrome_number_9;

/**
 * PalindromeNumber
 */
public class PalindromeNumber {

    public static void main(String[] args) {
        System.out.println(isPalindrome(181));
    }

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        int tmp = x;
        int reversedNumber = 0;
        while (tmp != 0) {
            reversedNumber = (reversedNumber * 10) + (tmp % 10);
            tmp /= 10;
        }

        return reversedNumber == x;
    }
}