public class ArrayIII{
	public static void main(String[] args){
		int N = args.length;
		int [] a = new int [N]; //declared and creted array with size N
		boolean result = true;
		for (int i = 0; i < N ; i++){
            //initialised array
  			a[i] = Integer.parseInt(args[i]);
  		}
			for (int i = 0; i < N ; i++){
                for(int j = i + 1; j < N; j++){
                	if (a[i] == a[j])
                	result = false;
                }
            }
            System.out.println(result);    

	}
}

