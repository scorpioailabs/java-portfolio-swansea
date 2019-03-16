class Gambler {
    public static void main(final String[]args) {
        if (args.length < 2) {
            System.err.println("Three arguments are needed: stake, target and number of trials, N, (with an optional third argument: p)");
        }
        final long stake = Long.parseLong(args[0]);
        if (stake<1) {
            System.err.println("Stake: " + stake + " must be positive");
            return;
        }
        final long target = Long.parseLong(args[1]);
        if (target <= stake) {
            System.err.println("Target: " + target + " is not greater than Stake: " + stake + ".");
        }
        final long N = Long.parseLong(args[2]);
        if (N < 0) {
            System.err.println("Negative number of trials" + N + ".");
            return;
        }
        final double p; //p = probability
        if (args.length ==3) p = 0.5;
        else p = Double.parseDouble(args[3]);
        if (p < 0 || p > 1) {
            System.err.println("Probability p: " + p + " is not between 0 and 1.");
            return;
        }
        long wins = 0, losses = 0;
        long min_steps = 0, max_steps = 0, sum_steps = 0;
        
        for (long i = 0; i < N; ++i) { //++i is better than i++
            long cash = stake;
            long steps = 0;
            
            while (cash > 0 && cash < target) {
                ++ steps;
                if (Math.random() < p) ++cash;
                else --cash;
            }
            assert (cash == 0 || cash == target); /*assert is always used against logical errors and bugs that may occur but not for user input errors. For DEBUG. 
            in run time you can toggle assert bt inserting java -ea (filename) */
            if (cash == 0) ++losses;
            else ++wins;
            if (steps < min_steps) min_steps = steps;
            if (steps > max_steps) max_steps = steps;
            sum_steps += steps;
            
        }
        System.out.println("Stake = " + stake + " , target = " + target + ", trials=" + N + ", p = " + p + ".");
        System.out.println("wins = " + wins);
        System.out.println("losses = " + losses);
        System.out.println("Number of steps for each game:");
        System.out.println("minimum = " + min_steps);
        System.out.println("maximum = " + max_steps);
        System.out.println("average = " + sum_steps/ N);
        
    }
}    
