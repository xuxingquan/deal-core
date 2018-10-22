package com.bill99.base.account.common.enumeration;

public enum DealDirectionEnum {
	//
	DECREASE(-1, "付款方"),
	//
	INCREASE(1, "收款方"), ;

	private DealDirectionEnum(Integer value, String message) {
		this.value = value;
		this.message = message;
	}

	private Integer value;

	private String message;

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public static boolean isIncrease(Integer direction){
		return INCREASE.getValue().equals(direction);
	}
	
	public static boolean isDecrease(Integer direction){
		return DECREASE.getValue().equals(direction);
	}
	
	public static DealDirectionEnum convert2ReverseDirection(Integer direction){
		if (isIncrease(direction)) {
			return DECREASE;
		}
		if(isDecrease(direction)){
			return INCREASE;
		}
		return null;
	}
	
	

	public static DealDirectionEnum getDealDirection(Integer value) {
		DealDirectionEnum[] enums = DealDirectionEnum.values();
		for (DealDirectionEnum enu : enums) {
			if (enu.getValue().equals(value)) {
				return enu;
			}
		}
		return null;
	}
	
	public static boolean isValidDirection(String direction){
		for (DealDirectionEnum directionEnum : DealDirectionEnum.values()) {
			if (directionEnum.getValue().toString().equals(direction)) {
				return true;
			}
		}
		return false;
	}
}
