package easy.roman_to_integer_13;

import java.util.Map;
import java.util.HashMap;

/**
 * RomanToInteger
 */
public class RomanToInteger {

    public static void main(String[] args) {
        System.out.println(romanToInt("LVIII"));
        // System.out.println(romanToIntRefactor("LVIII"));
    }

    private static int romanToInt(String s) {
        if (s == null || s.isEmpty()) return 0;
        
        Map<Character, Integer> mapRomans = generateRomansHashMap();
        char[] charList = s.toCharArray();
        int sum = 0;
        for(int i = charList.length - 1; i >= 0; i--) {
            char charUpperCase = Character.toUpperCase(charList[i]);
            switch(charUpperCase) {
                case 'I': 
                    sum += calculateDecision(sum, 5, mapRomans.get(charUpperCase));
                    break;
                case 'V': 
                    sum += calculateDecision(sum, 10, mapRomans.get(charUpperCase));
                    break;
                case 'X': 
                    sum += calculateDecision(sum, 50, mapRomans.get(charUpperCase));
                    break;
                case 'L': 
                    sum += calculateDecision(sum, 100, mapRomans.get(charUpperCase));
                    break;
                case 'C': 
                    sum += calculateDecision(sum, 500, mapRomans.get(charUpperCase));
                    break;
                case 'D': 
                    sum += calculateDecision(sum, 1000, mapRomans.get(charUpperCase));
                    break;
                case 'M': 
                    sum += calculateDecision(sum, 5000, mapRomans.get(charUpperCase));
                    break;
            }
            
        }
        return sum;
    }
    
    private static  Map<Character, Integer> generateRomansHashMap() {
        Map<Character, Integer> mapRomans = new HashMap<>();
        mapRomans.put('I', 1);
        mapRomans.put('V', 5);
        mapRomans.put('X', 10);
        mapRomans.put('L', 50);
        mapRomans.put('C', 100);
        mapRomans.put('D', 500);
        mapRomans.put('M', 1000);
        return mapRomans;
    }
    
    private static  int calculateDecision(int sum, int target, int num) {
        return sum < target ? num : num * -1;
    }
    
    private static int romanToIntRefactor(String s) {
        if (s == null || s.isEmpty()) return 0;
        
        char[] charList = s.toCharArray();
        int sum = 0;
        
        for(int i = charList.length - 1; i >= 0; i--) {
            switch(Character.toUpperCase(charList[i])) {
                case 'I': 
                    sum += sum < 5 ? 1 : -1;
                    break;
                case 'V': 
                    sum += sum < 10 ? 5 : -5;
                    break;
                case 'X': 
                    sum += sum < 50 ? 10 : -10;
                    break;
                case 'L': 
                    sum += sum < 100 ? 50 : -50;
                    break;
                case 'C': 
                    sum += sum < 500 ? 100 : -100;
                    break;
                case 'D': 
                    sum += sum < 1000 ? 500 : -500;
                    break;
                case 'M': 
                    sum += sum < 5000 ? 1000 : -1000;
                    break;
            }
        }
        return sum;
    }
}