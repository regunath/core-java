package com.ragu.core;

public class EnumApp {

	public enum ScoreCalculationType {
		BEST("BEST"), LAST("LAST"), AVERAGE("AVERAGE"), DEFAULT("BEST");

		private final String value;

		private ScoreCalculationType(String attemptType) {
			value = attemptType;
		}

		public String getValue() {
			return value;
		}

		@Override
		public String toString() {
			return this.getValue();
		}

	}

	ScoreCalculationType type;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EnumApp type = new EnumApp();

		System.out.println(type.type.BEST);
		
		System.out.println(ScoreCalculationType.valueOf("BEST1"));
	}

}
