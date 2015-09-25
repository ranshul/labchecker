import java.lang.reflect.*;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class SideEffect { // suitable only for fairly simple methods
	
	private Class c;
	private Method m;
	private Properties mutatedFields_before;
	private Properties mutatedFields_after;
	
	public Class getTargetClass() {
		return c;
	}
	public void setTargetClass(Class c) {
		this.c = c;
	}
	public Method getMethod() {
		return m;
	}
	public void setMethod(Method m) {
		this.m = m;
	}
	public Properties getMutatedFields() {
		return mutatedFields_before;
	}
	public void setMutatedFields(Properties mutatedFields) {
		this.mutatedFields_before.putAll(mutatedFields);
	}
	
	public Properties getMutatedFields_after() {
		return mutatedFields_after;
	}
	public void setMutatedFields_after(Properties mutatedFields_after) {
		this.mutatedFields_after.putAll(mutatedFields_after);
	}
	
	public int[] evaluate(){
		int[] score = {0,0};
		
		List<Method> method_list = Arrays.asList(c.getDeclaredMethods());
		
		// set values of fields before. if field says *, ignore
		
		// run method
		
		// check values of fields after.
		
		return score;
	}	

}
