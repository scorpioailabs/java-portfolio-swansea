/**
 * StringToInteger
 */
public class StringToInteger {
    public int myAtoi(String str) {
        int i = 0, sign =1, res =0;
        str = str.trim();
        if(str.length() ==0) return 0;
        if(str.charAt(i)=='-' || str.charAt(i) == '+') {
            sign = str.charAt(i) == '-' ? -1 : 1;
            i++;
        }
        for (; i < str.length(); i++) {
            int temp = str.charAt(i) - '0';
            if(temp< 0 || temp > 9) break;
            int old = res;
            res = res * 10 + temp;  
            if(res /10 != old){
                return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }       
        }
        return res * sign;   
    }   

    public int somethingDifferent(String str) {
        int i = 0, sign = 1, res = 0;
        str = str.trim();
        if (str.length() == 0)  return 0;
        if (str.charAt(i) == '-' || str.charAt(i) == '+') {
            sign = str.charAt(i)== '-' ? -1 : 1;
            i++;
        }
        while(i < str.length() && str.charAt(i)>= '0' && str.charAt(i) <= '9'){
            if(res > Integer.MAX_VALUE/10 || (res == Integer.MAX_VALUE/10 && str.charAt(i) - '0' > 7))
            {
                return (sign==1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + (str.charAt(i++) - '0');
        }
        return res * sign;
    }
    public static void main(String[] args) {
        StringToInteger si = new StringToInteger();
        String str = "42";
        si.myAtoi(str);
    }     
}