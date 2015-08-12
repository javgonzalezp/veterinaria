package com.clinica.veterinaria.base.vo;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class BaseVO implements Serializable, Cloneable {


	private static final long serialVersionUID = 1L;

	public String toString() {
		return toMap(this).toString();
	}

	public int hashCode() {
		return toMap(this).hashCode();
	}

	public boolean equals(Object anObject) {
		return toString().equals(anObject.toString());
	}
	
	public Object clone() {
		try {			
			ByteArrayOutputStream bs= new ByteArrayOutputStream();
			ObjectOutputStream os = new ObjectOutputStream (bs);
			os.writeObject(this);  // this es de tipo DatoUdp
			os.close();
			byte[] bytes =  bs.toByteArray(); // devuelve byte[]
			
			ByteArrayInputStream bs2= new ByteArrayInputStream(bytes); // bytes es el byte[]
			ObjectInputStream is = new ObjectInputStream(bs2);
			Object clone = is.readObject();
			is.close();

			return clone;
		} catch (Exception ex) {
			throw new RuntimeException("unexpected exception" + ex);
		}
	}

	public Map<String, Object> toMap(Object p_object) {
		SortedMap<String, Object> map = new TreeMap<String, Object>();
		Class<? extends Object> clazz = p_object.getClass();
		Method[] methods = clazz.getMethods();

		for (int i = 0; i < methods.length; i++) {
			// Busca todos los metodos "get" del objeto que no tengan parametros
			// de entrada
			if (methods[i].getName().startsWith("get") && methods[i].getParameterTypes().length == 0
					&& (methods[i].getDeclaringClass() != Object.class)) {
				Object value = null;
				try {

					value = methods[i].invoke(p_object);
					
					//Si el value es un array de objetos se pasa a una lista
					if (methods[i].getReturnType().isArray() && value != null){
						Object[] array = (Object[]) value;
						ArrayList<Object> arrayList = new ArrayList<Object>();
						for (int j = 0; j < array.length; j++) {
							arrayList.add(array[j]);
						}
						value = arrayList;
					}
				} catch (Exception ex) {
					// logger.debug("ERROR invoke method " +
					// methods[i].getName() +
					// " from class " + clazz.getName());
				}
				String name = lower(methods[i].getName().substring(3));
				map.put(name, value);
			}
		}

		return map;
	}

	private String lower(String name) {
		if (name.length() < 1) {
			return name;
		}
		String firstLetter = name.substring(0, 1);
		String rest = name.substring(1);
		return firstLetter.toLowerCase() + rest;
	}

}