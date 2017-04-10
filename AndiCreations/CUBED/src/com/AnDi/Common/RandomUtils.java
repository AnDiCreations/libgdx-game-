package com.AnDi.Common;

import java.util.Random;
import com.AnDi.GameActor.BarType;

public class RandomUtils{
   
	public static BarType getRandomBarType(){
		RandomEnum<BarType>randomEnum=new RandomEnum<BarType>(BarType.class);
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
