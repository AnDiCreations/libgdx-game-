package com.AnDi.Common;

import java.util.Random;

import com.AnDi.GameActor.Bar2Type;


public class RandomUtils2 {
           
	public static Bar2Type getRandomBarType(){
		RandomEnum<Bar2Type>randomEnum=new RandomEnum<Bar2Type>(Bar2Type.class);
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
