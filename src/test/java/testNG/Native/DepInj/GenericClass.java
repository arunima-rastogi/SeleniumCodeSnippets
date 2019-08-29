package testNG.Native.DepInj;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;

public class GenericClass {
	private HashMap<String, Method> methodMap = new HashMap<String, Method>();

	public Object call(String methodName, Object... args)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Method method = methodMap.get(methodName);
		return method.invoke(null, args);
	}

	public void add(String name, Method method) {
		if (Modifier.isStatic(method.getModifiers()))
			methodMap.put(name, method);
	}

	public static void main(String[] args) {
		try {
			GenericClass task = new GenericClass();
			task.add("Name", Object.class.getMethod("Name", new Class<?>[0]));
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
	}
}