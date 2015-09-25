import java.util.List;
import java.util.Properties;

public class InheritanceList {
	
	@SuppressWarnings("rawtypes")
	private Class c;
	private Properties methodModifiers;
	private Properties fieldModifiers;
	private String classModifier;
	private List<InheritanceList> parents;
	
	/*
	 * Add a static int[] score for aggregated evaluation 
	 */
	
	@SuppressWarnings("rawtypes")
	public InheritanceList(Class c, Properties methodModifiers, Properties fieldModifiers, String classModifier,
			List<InheritanceList> parents) {
		super();
		this.c = c;
		this.methodModifiers.putAll(methodModifiers);
		this.fieldModifiers.putAll(fieldModifiers);
		this.classModifier = classModifier;
		this.parents.addAll(parents);
	}
	
	public void addParent(@SuppressWarnings("rawtypes") Class c, Properties methodModifiers, Properties fieldModifiers, String classModifier, List<InheritanceList> parents){
		InheritanceList item = new InheritanceList(c, methodModifiers, fieldModifiers, classModifier, parents);
		this.parents.add(item);
	}
	
	public void addParent(InheritanceList parent){
		this.parents.add(parent);
	}
	
	@SuppressWarnings("rawtypes")
	public Class getTargetClass() {
		return c;
	}
	@SuppressWarnings("rawtypes")
	public void setTargetClass(Class c) {
		this.c = c;
	}
	public List<InheritanceList> getParents() {
		return parents;
	}
	public void setParents(List<InheritanceList> parents) {
		this.parents = parents;
	}
	public Properties getMethodModifiers() {
		return methodModifiers;
	}
	public void setMethodModifiers(Properties methodModifiers) {
		this.methodModifiers.putAll(methodModifiers);
	}
	public Properties getFieldModifiers() {
		return fieldModifiers;
	}
	public void setFieldModifiers(Properties fieldModifiers) {
		this.fieldModifiers.putAll(fieldModifiers);
	}
	public String getClassModifier() {
		return classModifier;
	}
	public void setClassModifier(String classModifier) {
		this.classModifier = classModifier;
	}
	
	
}
