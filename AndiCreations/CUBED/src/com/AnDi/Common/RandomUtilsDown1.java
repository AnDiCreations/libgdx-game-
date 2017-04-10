package com.AnDi.Common;

import java.util.Random;

import com.AnDi.GameActor.Bar6Type;

public class RandomUtilsDown1 {
     
	public static Bar6Type getRandomBarType(){
		RandomEnum<Bar6Type>randomEnum=new RandomEnum<Bar6Type>(Bar6Type.class);
		return randomEnum.random();
	}
	
	@SuppressWarnings("rawtypes")
	private static class RandomEnum<E extends Enum>{
		
		private static final Random RND=new Random();
		private final E[]values;
		
		public RandomEnum(Class<E>token){
			values=token.getEnumConstants();
		}
		public E random(){
			return values[RND.nextInt(values.length)];
		}
		
	}
}
