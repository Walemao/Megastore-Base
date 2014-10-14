package com.walemao.megastore.domain.Enum;

public enum EnumOrder {
	全部状态("全部状态", -1), 等待付款("等待付款", 0), 等待收货("等待收货", 1), 已完成("已完成", 2), 已取消(
			"已取消", 3);
	private int key;

	public void setKey(int key) {
		this.key = key;
	}

	private String name;

	private EnumOrder(String name, int key) {
		this.name = name;
		this.key = key;
	}

	public static String getName(int key) {
		for (EnumOrder e : EnumOrder.values()) {
			if (e.getKey() == key)
				return e.name;
		}
		return null;
	}

	public int getKey() {
		return key;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
