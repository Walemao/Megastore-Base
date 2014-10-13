package com.walemao.megastore.domain.Enum;

public enum EnumOrder {
	全部状态(-1), 等待付款(0), 等待收货(1), 已完成(2), 已取消(3);
	private final int key;

	private EnumOrder(int key) {
		this.key = key;
	}

	public int getKey() {
		return key;
	}

}
