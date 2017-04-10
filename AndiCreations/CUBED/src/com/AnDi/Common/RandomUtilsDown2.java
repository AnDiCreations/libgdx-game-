package com.AnDi.Common;

import java.util.Random;

import com.AnDi.GameActor.Bar7Type;

public class RandomUtilsDown2 {
        
	public static Bar7Type getRandomBarType(){
		RandomEnum<Bar7Type>randomEnum=new RandomEnum<Bar7Type>(Bar7Type.class);
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
