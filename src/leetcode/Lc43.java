package leetcode;

public class Lc43 {
    public static void main(String[] args) {
        String str1 = "456";
        String str2 = "123";
        System.out.println(new Solution43_2().multiply(str1, str2));
    }
}

class Solution43_1 {
    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        if (num1.length() < num2.length()) {
            String temp = num1;
            num1 = num2;
            num2 = temp;
        }
        char[] arr1 = num1.toCharArray();
        char[] arr2 = num2.toCharArray();
        String preRes = "0";
        for (int i = arr2.length - 1; i >= 0; i--) {
            StringBuffer sb = new StringBuffer();
            for (int j = i; j < arr2.length - 1; j++) {
                sb.append("0");
            }
            int carry = 0;
            for (int j = arr1.length - 1; j >= 0; j--) {
                // 乘积
                int product = (arr2[i] - '0') * (arr1[j] - '0') + carry;
                sb.insert(0, product % 10);
                // 进位
                carry = product / 10;
            }
            if (carry > 0) {
                sb.insert(0, carry);
            }
            preRes = add(sb.toString(), preRes);
        }
        return preRes;
    }

    private String add(String str1, String str2) {
        int i = str1.length() - 1;
        int j = str2.length() - 1;
        StringBuffer sb = new StringBuffer();
        int carry = 0;
        while (i >= 0 && j >= 0) {
            int sum = (str1.charAt(i) - '0') + (str2.charAt(j) - '0') + carry;
            sb.insert(0, sum % 10);
            carry = sum / 10;
            i--;
            j--;
        }
        while (i >= 0) {
            int sum = (str1.charAt(i) - '0') + carry;
            sb.insert(0, sum % 10);
            carry = sum / 10;
            i--;
        }
        while (j >= 0) {
            int sum = (str2.charAt(j) - '0') + carry;
            sb.insert(0, sum % 10);
            carry = sum / 10;
            j--;
        }
        if (carry != 0) {
            sb.insert(0, carry);
        }
        return sb.toString();
    }
}

class Solution43_2 {
    public String multiply(String num1, String num2) {
        if("0".equals(num1) || "0".equals(num2)){
            return "0";
        }
        int len1 = num1.length();
        int len2 = num2.length();
        int[] arr = new int[len1 + len2];
        for(int i = len2 - 1; i >= 0; i--){
            int x = num2.charAt(i) - '0';
            for(int j = len1 - 1; j >= 0; j--){
                int y = num1.charAt(j) - '0';
                arr[i + j + 1] += x * y;
            }
        }
        int carry = 0;
        StringBuffer res = new StringBuffer();
        for(int i = len1 + len2 - 1; i >= 0; i--){
            int currCarry = (arr[i] + carry) / 10;
            arr[i] = (arr[i] + carry) % 10;
            carry = currCarry;
            res.insert(0, arr[i]);
        }
        if(res.charAt(0) == '0'){
            res.delete(0,1);
        }
        return res.toString();
    }
}
