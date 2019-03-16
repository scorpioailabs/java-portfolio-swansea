import java.util.Random;

class Experiment {
  public static final long default_seed = 0;
  private static Random r = new Random(default_seed);
  private static void set_seed(final long seed) {
    r.setSeed(seed);
  }
  private static double random() { return r.nextDouble(); }

  public static final int orig_default_size = 100;
  private static int default_size = orig_default_size;
  public static int get_default_size() {
    return default_size;
  }

  public static int make_positive(final int x) {
    if (x > 0) return x;
    else return default_size;
  }
  public static int min(final int x, final long y) {
    if (y < x) return (int) y; else return x;
  }
  public static void add_to_default(final int x) {
    default_size += x;
    int old_default_size = default_size - x;
    int minval = min(x, default_size);
    if (minval > default_size) default_size = minval;
    if (default_size < 0) default_size = 0;
    else if (default_size < old_default_size) default_size = old_default_size;
  }

  public static AbsorbingCounter[] create_experiment(final long min,
    final long max, final int N) {
    assert(N >= 1);
    final AbsorbingCounter[] exp = new AbsorbingCounter[N];
    for (int i = 0; i < N;  ++i)
      exp[i] = new AbsorbingCounter(min, max);
    return exp;
  }
  
  public static void run_experiment(final AbsorbingCounter[] e,
    final long T) {

    for (long j=0; j<T; ++j){
      int i = (int)random();
      for (long k=0; k<T; ++k)
        if(random()<= 0.5 && ! e[i].reached_max() || e[i].reached_min()) e[i].dec();
        else if(random() <=1.0 && ! e[i].reached_max() || e[i].reached_min()) e[i].inc();

    }

  }
  public static Stats evaluate_experiment(final AbsorbingCounter[] e) {
    Stats s = new Stats(); 
        int countMin = 0;
        int countMax = 0;
        double mean = 0;
        for(int i = 0; i < e.length; i ++){
            mean += e[i].counter;
            if(e[i].reached_min()){
                countMin+=1;
            } else if(e[i].reached_max()){
                countMax+=1;
            }
        }
        mean = mean / e.length;
        s.average = mean;
        s.count_max_reached = countMax;
        s.count_min_reached = countMin;

        return s;
  }

  public static void main(final String[] args ) {
    if (args.length < 3) {
      System.err.print("ERROR[AbsorbingCounters]: ");
      System.err.println("Arguments are\n min max T [N] [seed]");
      System.exit(1);
    }
    final long min = Long.parseLong(args[0]);
    final long max = Long.parseLong(args[1]);
    final long T = Long.parseLong(args[2]);
    final int N;
    {final int temp = (args.length > 3) ? Integer.parseInt(args[3]) : 0;
     N = make_positive(temp);}
    final long seed = (args.length > 4) ?
      Long.parseLong(args[4]) : default_seed;
    set_seed(seed);
    final AbsorbingCounter[] experiment = create_experiment(min, max, N);
    run_experiment(experiment, T);
    System.out.println("min=" + min + ", max=" + max + ", T=" + T +
      ", N=" + experiment.length + ", seed=" + seed);
    System.out.print(evaluate_experiment(experiment));
  }
}