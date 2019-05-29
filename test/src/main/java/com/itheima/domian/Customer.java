package com.itheima.domian;

import java.io.Serializable;
/**
 * 客户的实体类
 * @author zhy
 *
 */
public class Customer implements Serializable {
	

	private Long 	custId;
	private String  custName;
	private String  custIndustry;
	private String  custAddress;
	private String  custPhone;
	private String  custLevel;
	private String  custSource;

	public Long getCustId() {
		return custId;
	}

	public void setCustId(Long custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCustIndustry() {
		return custIndustry;
	}

	public void setCustIndustry(String custIndustry) {
		this.custIndustry = custIndustry;
	}

	public String getCustAddress() {
		return custAddress;
	}

	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}

	public String getCustPhone() {
		return custPhone;
	}

	public void setCustPhone(String custPhone) {
		this.custPhone = custPhone;
	}

	public String getCustLevel() {
		return custLevel;
	}

	public void setCustLevel(String custLevel) {
		this.custLevel = custLevel;
	}

	public String getCustSource() {
		return custSource;
	}

	public void setCustSource(String custSource) {
		this.custSource = custSource;
	}

	@Override
	public String toString() {
		return "Customer{" +
				"custId=" + custId +
				", custName='" + custName + '\'' +
				", custIndustry='" + custIndustry + '\'' +
				", custAddress='" + custAddress + '\'' +
				", custPhone='" + custPhone + '\'' +
				", custLevel='" + custLevel + '\'' +
				", custSource='" + custSource + '\'' +
				'}';
	}
}
