package com.AnDi.Common;

import java.util.Random;

import com.AnDi.GameActor.Bar3Type;

public class RandomUtils3 {
         
	public static Bar3Type getRandomBarType(){
		RandomEnum<Bar3Type>randomEnum=new RandomEnum<Bar3Type>(Bar3Type.class);
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
