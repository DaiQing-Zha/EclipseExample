package com.jxsd.zdq;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainClass {

	public static void main(String[] args) {
		
		List<Integer> useCases = new ArrayList<Integer>();
	    Collections.addAll(useCases, 40, 41, 42, 43);
	    trackUseCase(useCases, PasswordUtils.class);
	}
	
	public static void trackUseCase(List<Integer> lst,Class<?> cl) {
		for(Method m:cl.getMethods()) {
			UseCase uc = m.getAnnotation(UseCase.class);
			if(uc != null) {
				System.out.println("method = " + m.getName() + "id = " + uc.id() + " description = " + uc.description());
				lst.remove(new Integer(uc.id()));
			}
		}
		for(int i:lst) {
			System.out.println("Warning: Missing use case-" + i);
		}
	}

}
