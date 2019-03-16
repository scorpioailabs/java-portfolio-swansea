public class Exercise3 {
	public static void main(String[]args) {
		int a = 2147483647; //Note: This is an integer's MAX VALUE, use long if you'd like to surpass this number,
		System.out.println(a);	// 2147483647
		System.out.println(a+1); // -2147483648 the max value for an integer is 2^31 - 1 therefore any higher number results in system 
		System.out.println(2-a); /* - 2147483645 this is a simple subtraction, taking int(max_value) away from 2, note the MIN VALUE 
										of an int is -2146483648 or -2^31 */
		System.out.println(-2-a); // 2147483647 numeric overflow due to MIN VALUE being reached results in value changing to positive sign 
		System.out.println(2*a); //  -2 max value reached, the result simply cuts of all bits that don't fit into 32 bits leaving -2
		System.out.println(4*a); //  -4 max value reacched, the result simply cuts of all bits that don't fit into 32 bits leaving -2

	}
}
