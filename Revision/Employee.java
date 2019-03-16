class Employee {
	private String name;
	private int id;

	public Employee(int x, String s) {
		id = x;
		name = s;
	}
	public String name() {
		return name;
	}
	public void name(final String s) {
		name = s;
	}
	public int id() {
		return id;
	}
	public void id(final int i) {
		id = i;
	}
	public boolean equals(Employee other) {
		return name.equals(other.name) && id == other.id;
	}
	public static void main(String[] args) {
		Employee e1 = new Employee(123, "abc");
		System.out.println(e1.name + e1.id);
		e1.name = "xyz";
		e1.id = 456;
		System.out.println(e1.name + e1.id);
		Employee e2 = new Employee(456, "abc");
		System.out.println(e1.equals(e2));
	}
}