package me.nrubin29.accessor;

/**
 * Class used to access other classes and automatically fill in parameters.
 */
public class Accessor {

	private Object operator;
	private Object[] vars;

    /**
     * Construct an accessor.
     * @param operator The object on which to operate. If this is a class, only static methods will be used. If this is an object, accessed methods will be applied to it.
     * @param params Parameters to automatically pass.
     */
	public Accessor(Object operator, Object... params) {
		this.operator = operator;
		this.vars = params;
	}

    /**
     * Access a method with the predefined parameters.
     * @param method The name of the method to use.
     * @param <T> The return type of the method you are trying to access.
     * @return The result of the method call casted to T.
     * @throws Exception If something goes wrong in the reflection, that exception would be thrown.
     */
	public <T> T access(String method) throws Exception {
		Class<?> operatorClass;
		
		if (operator instanceof Class) operatorClass = (Class<?>) operator;
		else operatorClass = operator.getClass();
		
		Class<?>[] classes = new Class<?>[vars.length];
		for (int i = 0; i < vars.length; i++) {
			Class<?> clazz = vars[i].getClass();
			
			if (clazz.equals(Integer.class)) clazz = Integer.TYPE;
			else if (clazz.equals(Double.class)) clazz = Double.TYPE;
			
			classes[i] = clazz;
		}
		
		return (T) operatorClass.getMethod(method, classes).invoke(operator instanceof Class ? null : operator, vars);
	}
}