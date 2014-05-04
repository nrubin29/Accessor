package me.nrubin29.accessor;

public class Example {

	public static void main(String[] args) throws Exception {
        /**
         * Create an {@see Accessor} instance to use static methods in the Math class and pass the parameters 2 and 3.
         */
		Accessor math = new Accessor(Math.class, 2, 3);

        /**
         * Invokes the max and min methods in the Math class with the parameters defined in the {@see Accessor}'s constructor.
         */
		System.out.println(math.access("max"));
		System.out.println(math.access("min"));

        /**
         * Create an {@see Accessor} instance to use static and non-static methods in the new instance of the String class and pass the parameter "o".
         */
		Accessor string = new Accessor("hello", "o");

        /**
         * Invokes the lastIndexOf method in the String class with the parameter defined in the {@see Accessor}'s constructor.
         */
		System.out.println(string.access("lastIndexOf"));
	}
}