import java.lang.reflect.*;
import java.util.*;

public class Checker {
	
	/*
	 * Leniency for typos can be added by implementing case sensitivity, Levenshtein distance and so on as metrics for comparison.
	 */
	
	public static int[] checkFieldModifiers(@SuppressWarnings("rawtypes") Class c, Properties fieldList){
		int[] score = {0,0}; // {correct,total}
		
		if (fieldList.isEmpty()) return score;
		
		for(Field f: c.getDeclaredFields()){
			String field_name = f.getName();
			if(fieldList.containsKey(field_name)){
				if (fieldList.getProperty(field_name).equals(Modifier.toString(f.getModifiers())))
					score[0] += 1;
				else
					System.out.println(field_name + " does not meet requirements.");
				score[1] += 1;
			}
		}
		
		return score;
	}
	
	public static int[] checkMethodModifiers(@SuppressWarnings("rawtypes") Class c, Properties methodList){
		int[] score = {0,0}; // {correct,total}
		
		if(methodList.isEmpty()) return score;
		
		for(Method m: c.getDeclaredMethods()){
			String method_name = m.getName();
			if(methodList.containsKey(method_name)){
				if (methodList.getProperty(method_name).equals(Modifier.toString(m.getModifiers())))
					score[0] += 1; // score[0] += weight_for_testcase. Increment score[1] by same amount.
				else
					System.out.println(method_name + " does not meet requirements.");
				score[1] += 1;
			}
		}
		
		return score;
	}
	
	// check if score is passed by reference
	public static int[] checkOnHierarchy(InheritanceList root, int[] score){
		//static int[] score = {0,0}; // {correct,total}
		
		while(!root.getParents().isEmpty()){
			int[] tmp = {0,0};
			
			tmp = checkFieldModifiers(root.getTargetClass(), root.getFieldModifiers());
			score[0] += tmp[0];
			score[1] += tmp[1];
			
			tmp = checkMethodModifiers(root.getTargetClass(), root.getMethodModifiers());
			score[0] += tmp[0];
			score[1] += tmp[1];
			
			if(root.getClassModifier().equals(Modifier.toString(root.getTargetClass().getModifiers())))
				score[0] += 1;
			score[1] += 1;
			
			for(InheritanceList parent: root.getParents())
				checkOnHierarchy(parent,score);
		}
		
		//topmost class.
		
		int[] tmp = {0,0};
		
		tmp = checkFieldModifiers(root.getTargetClass(), root.getFieldModifiers());
		score[0] += tmp[0];
		score[1] += tmp[1];
		
		tmp = checkMethodModifiers(root.getTargetClass(), root.getMethodModifiers());
		score[0] += tmp[0];
		score[1] += tmp[1];
		
		if(root.getClassModifier().equals(Modifier.toString(root.getTargetClass().getModifiers())))
			score[0] += 1;
		score[1] += 1;
		
		return score;
	}
	
	
}
	