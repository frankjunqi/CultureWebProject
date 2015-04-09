package com.lxy.model;

import java.util.Date;

public class LxyProduct {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column lxy_product.PRODUCT_ID
	 * @mbggenerated  Thu Dec 11 14:28:00 CST 2014
	 */
	private Long productId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column lxy_product.VERSION
	 * @mbggenerated  Thu Dec 11 14:28:00 CST 2014
	 */
	private Integer version;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column lxy_product.UUID
	 * @mbggenerated  Thu Dec 11 14:28:00 CST 2014
	 */
	private String uuid;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column lxy_product.PRODUCT_NAME
	 * @mbggenerated  Thu Dec 11 14:28:00 CST 2014
	 */
	private String productName;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column lxy_product.PRODUCT_VALUE
	 * @mbggenerated  Thu Dec 11 14:28:00 CST 2014
	 */
	private String productValue;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column lxy_product.PRODUCT_DESC
	 * @mbggenerated  Thu Dec 11 14:28:00 CST 2014
	 */
	private String productDesc;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column lxy_product.PRODUCT_DETAIL_ID
	 * @mbggenerated  Thu Dec 11 14:28:00 CST 2014
	 */
	private Long productDetailId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column lxy_product.PRODUCT_TYPE_ID
	 * @mbggenerated  Thu Dec 11 14:28:00 CST 2014
	 */
	private Long productTypeId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column lxy_product.PRODUCT_FROM_ID
	 * @mbggenerated  Thu Dec 11 14:28:00 CST 2014
	 */
	private Long productFromId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column lxy_product.PRODUCT_TO_ID
	 * @mbggenerated  Thu Dec 11 14:28:00 CST 2014
	 */
	private Long productToId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column lxy_product.PRODUCT_PRIORITY
	 * @mbggenerated  Thu Dec 11 14:28:00 CST 2014
	 */
	private String productPriority;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column lxy_product.AMT
	 * @mbggenerated  Thu Dec 11 14:28:00 CST 2014
	 */
	private String amt;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column lxy_product.DELETED_FLAG
	 * @mbggenerated  Thu Dec 11 14:28:00 CST 2014
	 */
	private String deletedFlag;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column lxy_product.PRODUCT_ATTRIBUTE1
	 * @mbggenerated  Thu Dec 11 14:28:00 CST 2014
	 */
	private String productAttribute1;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column lxy_product.PRODUCT_ATTRIBUTE2
	 * @mbggenerated  Thu Dec 11 14:28:00 CST 2014
	 */
	private String productAttribute2;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column lxy_product.PRODUCT_ATTRIBUTE3
	 * @mbggenerated  Thu Dec 11 14:28:00 CST 2014
	 */
	private String productAttribute3;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column lxy_product.PRODUCT_ATTRIBUTE4
	 * @mbggenerated  Thu Dec 11 14:28:00 CST 2014
	 */
	private String productAttribute4;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column lxy_product.PRODUCT_ATTRIBUTE5
	 * @mbggenerated  Thu Dec 11 14:28:00 CST 2014
	 */
	private String productAttribute5;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column lxy_product.PRODUCT_ATTRIBUTE6
	 * @mbggenerated  Thu Dec 11 14:28:00 CST 2014
	 */
	private String productAttribute6;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column lxy_product.PROCESS_STATUS
	 * @mbggenerated  Thu Dec 11 14:28:00 CST 2014
	 */
	private String processStatus;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column lxy_product.MAKER_ON
	 * @mbggenerated  Thu Dec 11 14:28:00 CST 2014
	 */
	private Date makerOn;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column lxy_product.MAKER_BY
	 * @mbggenerated  Thu Dec 11 14:28:00 CST 2014
	 */
	private String makerBy;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column lxy_product.CHECKER_ON
	 * @mbggenerated  Thu Dec 11 14:28:00 CST 2014
	 */
	private Date checkerOn;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column lxy_product.CHECKER_BY
	 * @mbggenerated  Thu Dec 11 14:28:00 CST 2014
	 */
	private String checkerBy;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column lxy_product.CREATE_ON
	 * @mbggenerated  Thu Dec 11 14:28:00 CST 2014
	 */
	private Date createOn;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column lxy_product.CREATE_BY
	 * @mbggenerated  Thu Dec 11 14:28:00 CST 2014
	 */
	private String createBy;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column lxy_product.MODIFY_ON
	 * @mbggenerated  Thu Dec 11 14:28:00 CST 2014
	 */
	private Date modifyOn;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column lxy_product.MODIFY_BY
	 * @mbggenerated  Thu Dec 11 14:28:00 CST 2014
	 */
	private String modifyBy;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column lxy_product.AUTHORIZER_BY
	 * @mbggenerated  Thu Dec 11 14:28:00 CST 2014
	 */
	private String authorizerBy;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column lxy_product.AUTHORIZER_ON
	 * @mbggenerated  Thu Dec 11 14:28:00 CST 2014
	 */
	private Date authorizerOn;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column lxy_product.PRODUCT_ID
	 * @return  the value of lxy_product.PRODUCT_ID
	 * @mbggenerated  Thu Dec 11 14:28:00 CST 2014
	 */
	public Long getProductId() {
		return productId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column lxy_product.PRODUCT_ID
	 * @param productId  the value for lxy_product.PRODUCT_ID
	 * @mbggenerated  Thu Dec 11 14:28:00 CST 2014
	 */
	public void setProductId(Long productId) {
		this.productId = productId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column lxy_product.VERSION
	 * @return  the value of lxy_product.VERSION
	 * @mbggenerated  Thu Dec 11 14:28:00 CST 2014
	 */
	public Integer getVersion() {
		return version;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column lxy_product.VERSION
	 * @param version  the value for lxy_product.VERSION
	 * @mbggenerated  Thu Dec 11 14:28:00 CST 2014
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column lxy_product.UUID
	 * @return  the value of lxy_product.UUID
	 * @mbggenerated  Thu Dec 11 14:28:00 CST 2014
	 */
	public String getUuid() {
		return uuid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column lxy_product.UUID
	 * @param uuid  the value for lxy_product.UUID
	 * @mbggenerated  Thu Dec 11 14:28:00 CST 2014
	 */
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column lxy_product.PRODUCT_NAME
	 * @return  the value of lxy_product.PRODUCT_NAME
	 * @mbggenerated  Thu Dec 11 14:28:00 CST 2014
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column lxy_product.PRODUCT_NAME
	 * @param productName  the value for lxy_product.PRODUCT_NAME
	 * @mbggenerated  Thu Dec 11 14:28:00 CST 2014
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column lxy_product.PRODUCT_VALUE
	 * @return  the value of lxy_product.PRODUCT_VALUE
	 * @mbggenerated  Thu Dec 11 14:28:00 CST 2014
	 */
	public String getProductValue() {
		return productValue;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column lxy_product.PRODUCT_VALUE
	 * @param productValue  the value for lxy_product.PRODUCT_VALUE
	 * @mbggenerated  Thu Dec 11 14:28:00 CST 2014
	 */
	public void setProductValue(String productValue) {
		this.productValue = productValue;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column lxy_product.PRODUCT_DESC
	 * @return  the value of lxy_product.PRODUCT_DESC
	 * @mbggenerated  Thu Dec 11 14:28:00 CST 2014
	 */
	public String getProductDesc() {
		return productDesc;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column lxy_product.PRODUCT_DESC
	 * @param productDesc  the value for lxy_product.PRODUCT_DESC
	 * @mbggenerated  Thu Dec 11 14:28:00 CST 2014
	 */
	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column lxy_product.PRODUCT_DETAIL_ID
	 * @return  the value of lxy_product.PRODUCT_DETAIL_ID
	 * @mbggenerated  Thu Dec 11 14:28:00 CST 2014
	 */
	public Long getProductDetailId() {
		return productDetailId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column lxy_product.PRODUCT_DETAIL_ID
	 * @param productDetailId  the value for lxy_product.PRODUCT_DETAIL_ID
	 * @mbggenerated  Thu Dec 11 14:28:00 CST 2014
	 */
	public void setProductDetailId(Long productDetailId) {
		this.productDetailId = productDetailId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column lxy_product.PRODUCT_TYPE_ID
	 * @return  the value of lxy_product.PRODUCT_TYPE_ID
	 * @mbggenerated  Thu Dec 11 14:28:00 CST 2014
	 */
	public Long getProductTypeId() {
		return productTypeId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column lxy_product.PRODUCT_TYPE_ID
	 * @param productTypeId  the value for lxy_product.PRODUCT_TYPE_ID
	 * @mbggenerated  Thu Dec 11 14:28:00 CST 2014
	 */
	public void setProductTypeId(Long productTypeId) {
		this.productTypeId = productTypeId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column lxy_product.PRODUCT_FROM_ID
	 * @return  the value of lxy_product.PRODUCT_FROM_ID
	 * @mbggenerated  Thu Dec 11 14:28:00 CST 2014
	 */
	public Long getProductFromId() {
		return productFromId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column lxy_product.PRODUCT_FROM_ID
	 * @param productFromId  the value for lxy_product.PRODUCT_FROM_ID
	 * @mbggenerated  Thu Dec 11 14:28:00 CST 2014
	 */
	public void setProductFromId(Long productFromId) {
		this.productFromId = productFromId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column lxy_product.PRODUCT_TO_ID
	 * @return  the value of lxy_product.PRODUCT_TO_ID
	 * @mbggenerated  Thu Dec 11 14:28:00 CST 2014
	 */
	public Long getProductToId() {
		return productToId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column lxy_product.PRODUCT_TO_ID
	 * @param productToId  the value for lxy_product.PRODUCT_TO_ID
	 * @mbggenerated  Thu Dec 11 14:28:00 CST 2014
	 */
	public void setProductToId(Long productToId) {
		this.productToId = productToId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column lxy_product.PRODUCT_PRIORITY
	 * @return  the value of lxy_product.PRODUCT_PRIORITY
	 * @mbggenerated  Thu Dec 11 14:28:00 CST 2014
	 */
	public String getProductPriority() {
		return productPriority;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column lxy_product.PRODUCT_PRIORITY
	 * @param productPriority  the value for lxy_product.PRODUCT_PRIORITY
	 * @mbggenerated  Thu Dec 11 14:28:00 CST 2014
	 */
	public void setProductPriority(String productPriority) {
		this.productPriority = productPriority;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column lxy_product.AMT
	 * @return  the value of lxy_product.AMT
	 * @mbggenerated  Thu Dec 11 14:28:00 CST 2014
	 */
	public String getAmt() {
		return amt;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column lxy_product.AMT
	 * @param amt  the value for lxy_product.AMT
	 * @mbggenerated  Thu Dec 11 14:28:00 CST 2014
	 */
	public void setAmt(String amt) {
		this.amt = amt;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column lxy_product.DELETED_FLAG
	 * @return  the value of lxy_product.DELETED_FLAG
	 * @mbggenerated  Thu Dec 11 14:28:00 CST 2014
	 */
	public String getDeletedFlag() {
		return deletedFlag;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column lxy_product.DELETED_FLAG
	 * @param deletedFlag  the value for lxy_product.DELETED_FLAG
	 * @mbggenerated  Thu Dec 11 14:28:00 CST 2014
	 */
	public void setDeletedFlag(String deletedFlag) {
		this.deletedFlag = deletedFlag;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column lxy_product.PRODUCT_ATTRIBUTE1
	 * @return  the value of lxy_product.PRODUCT_ATTRIBUTE1
	 * @mbggenerated  Thu Dec 11 14:28:00 CST 2014
	 */
	public String getProductAttribute1() {
		return productAttribute1;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column lxy_product.PRODUCT_ATTRIBUTE1
	 * @param productAttribute1  the value for lxy_product.PRODUCT_ATTRIBUTE1
	 * @mbggenerated  Thu Dec 11 14:28:00 CST 2014
	 */
	public void setProductAttribute1(String productAttribute1) {
		this.productAttribute1 = productAttribute1;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column lxy_product.PRODUCT_ATTRIBUTE2
	 * @return  the value of lxy_product.PRODUCT_ATTRIBUTE2
	 * @mbggenerated  Thu Dec 11 14:28:00 CST 2014
	 */
	public String getProductAttribute2() {
		return productAttribute2;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column lxy_product.PRODUCT_ATTRIBUTE2
	 * @param productAttribute2  the value for lxy_product.PRODUCT_ATTRIBUTE2
	 * @mbggenerated  Thu Dec 11 14:28:00 CST 2014
	 */
	public void setProductAttribute2(String productAttribute2) {
		this.productAttribute2 = productAttribute2;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column lxy_product.PRODUCT_ATTRIBUTE3
	 * @return  the value of lxy_product.PRODUCT_ATTRIBUTE3
	 * @mbggenerated  Thu Dec 11 14:28:00 CST 2014
	 */
	public String getProductAttribute3() {
		return productAttribute3;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column lxy_product.PRODUCT_ATTRIBUTE3
	 * @param productAttribute3  the value for lxy_product.PRODUCT_ATTRIBUTE3
	 * @mbggenerated  Thu Dec 11 14:28:00 CST 2014
	 */
	public void setProductAttribute3(String productAttribute3) {
		this.productAttribute3 = productAttribute3;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column lxy_product.PRODUCT_ATTRIBUTE4
	 * @return  the value of lxy_product.PRODUCT_ATTRIBUTE4
	 * @mbggenerated  Thu Dec 11 14:28:00 CST 2014
	 */
	public String getProductAttribute4() {
		return productAttribute4;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column lxy_product.PRODUCT_ATTRIBUTE4
	 * @param productAttribute4  the value for lxy_product.PRODUCT_ATTRIBUTE4
	 * @mbggenerated  Thu Dec 11 14:28:00 CST 2014
	 */
	public void setProductAttribute4(String productAttribute4) {
		this.productAttribute4 = productAttribute4;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column lxy_product.PRODUCT_ATTRIBUTE5
	 * @return  the value of lxy_product.PRODUCT_ATTRIBUTE5
	 * @mbggenerated  Thu Dec 11 14:28:00 CST 2014
	 */
	public String getProductAttribute5() {
		return productAttribute5;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column lxy_product.PRODUCT_ATTRIBUTE5
	 * @param productAttribute5  the value for lxy_product.PRODUCT_ATTRIBUTE5
	 * @mbggenerated  Thu Dec 11 14:28:00 CST 2014
	 */
	public void setProductAttribute5(String productAttribute5) {
		this.productAttribute5 = productAttribute5;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column lxy_product.PRODUCT_ATTRIBUTE6
	 * @return  the value of lxy_product.PRODUCT_ATTRIBUTE6
	 * @mbggenerated  Thu Dec 11 14:28:00 CST 2014
	 */
	public String getProductAttribute6() {
		return productAttribute6;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column lxy_product.PRODUCT_ATTRIBUTE6
	 * @param productAttribute6  the value for lxy_product.PRODUCT_ATTRIBUTE6
	 * @mbggenerated  Thu Dec 11 14:28:00 CST 2014
	 */
	public void setProductAttribute6(String productAttribute6) {
		this.productAttribute6 = productAttribute6;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column lxy_product.PROCESS_STATUS
	 * @return  the value of lxy_product.PROCESS_STATUS
	 * @mbggenerated  Thu Dec 11 14:28:00 CST 2014
	 */
	public String getProcessStatus() {
		return processStatus;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column lxy_product.PROCESS_STATUS
	 * @param processStatus  the value for lxy_product.PROCESS_STATUS
	 * @mbggenerated  Thu Dec 11 14:28:00 CST 2014
	 */
	public void setProcessStatus(String processStatus) {
		this.processStatus = processStatus;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column lxy_product.MAKER_ON
	 * @return  the value of lxy_product.MAKER_ON
	 * @mbggenerated  Thu Dec 11 14:28:00 CST 2014
	 */
	public Date getMakerOn() {
		return makerOn;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column lxy_product.MAKER_ON
	 * @param makerOn  the value for lxy_product.MAKER_ON
	 * @mbggenerated  Thu Dec 11 14:28:00 CST 2014
	 */
	public void setMakerOn(Date makerOn) {
		this.makerOn = makerOn;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column lxy_product.MAKER_BY
	 * @return  the value of lxy_product.MAKER_BY
	 * @mbggenerated  Thu Dec 11 14:28:00 CST 2014
	 */
	public String getMakerBy() {
		return makerBy;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column lxy_product.MAKER_BY
	 * @param makerBy  the value for lxy_product.MAKER_BY
	 * @mbggenerated  Thu Dec 11 14:28:00 CST 2014
	 */
	public void setMakerBy(String makerBy) {
		this.makerBy = makerBy;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column lxy_product.CHECKER_ON
	 * @return  the value of lxy_product.CHECKER_ON
	 * @mbggenerated  Thu Dec 11 14:28:00 CST 2014
	 */
	public Date getCheckerOn() {
		return checkerOn;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column lxy_product.CHECKER_ON
	 * @param checkerOn  the value for lxy_product.CHECKER_ON
	 * @mbggenerated  Thu Dec 11 14:28:00 CST 2014
	 */
	public void setCheckerOn(Date checkerOn) {
		this.checkerOn = checkerOn;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column lxy_product.CHECKER_BY
	 * @return  the value of lxy_product.CHECKER_BY
	 * @mbggenerated  Thu Dec 11 14:28:00 CST 2014
	 */
	public String getCheckerBy() {
		return checkerBy;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column lxy_product.CHECKER_BY
	 * @param checkerBy  the value for lxy_product.CHECKER_BY
	 * @mbggenerated  Thu Dec 11 14:28:00 CST 2014
	 */
	public void setCheckerBy(String checkerBy) {
		this.checkerBy = checkerBy;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column lxy_product.CREATE_ON
	 * @return  the value of lxy_product.CREATE_ON
	 * @mbggenerated  Thu Dec 11 14:28:00 CST 2014
	 */
	public Date getCreateOn() {
		return createOn;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column lxy_product.CREATE_ON
	 * @param createOn  the value for lxy_product.CREATE_ON
	 * @mbggenerated  Thu Dec 11 14:28:00 CST 2014
	 */
	public void setCreateOn(Date createOn) {
		this.createOn = createOn;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column lxy_product.CREATE_BY
	 * @return  the value of lxy_product.CREATE_BY
	 * @mbggenerated  Thu Dec 11 14:28:00 CST 2014
	 */
	public String getCreateBy() {
		return createBy;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column lxy_product.CREATE_BY
	 * @param createBy  the value for lxy_product.CREATE_BY
	 * @mbggenerated  Thu Dec 11 14:28:00 CST 2014
	 */
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column lxy_product.MODIFY_ON
	 * @return  the value of lxy_product.MODIFY_ON
	 * @mbggenerated  Thu Dec 11 14:28:00 CST 2014
	 */
	public Date getModifyOn() {
		return modifyOn;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column lxy_product.MODIFY_ON
	 * @param modifyOn  the value for lxy_product.MODIFY_ON
	 * @mbggenerated  Thu Dec 11 14:28:00 CST 2014
	 */
	public void setModifyOn(Date modifyOn) {
		this.modifyOn = modifyOn;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column lxy_product.MODIFY_BY
	 * @return  the value of lxy_product.MODIFY_BY
	 * @mbggenerated  Thu Dec 11 14:28:00 CST 2014
	 */
	public String getModifyBy() {
		return modifyBy;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column lxy_product.MODIFY_BY
	 * @param modifyBy  the value for lxy_product.MODIFY_BY
	 * @mbggenerated  Thu Dec 11 14:28:00 CST 2014
	 */
	public void setModifyBy(String modifyBy) {
		this.modifyBy = modifyBy;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column lxy_product.AUTHORIZER_BY
	 * @return  the value of lxy_product.AUTHORIZER_BY
	 * @mbggenerated  Thu Dec 11 14:28:00 CST 2014
	 */
	public String getAuthorizerBy() {
		return authorizerBy;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column lxy_product.AUTHORIZER_BY
	 * @param authorizerBy  the value for lxy_product.AUTHORIZER_BY
	 * @mbggenerated  Thu Dec 11 14:28:00 CST 2014
	 */
	public void setAuthorizerBy(String authorizerBy) {
		this.authorizerBy = authorizerBy;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column lxy_product.AUTHORIZER_ON
	 * @return  the value of lxy_product.AUTHORIZER_ON
	 * @mbggenerated  Thu Dec 11 14:28:00 CST 2014
	 */
	public Date getAuthorizerOn() {
		return authorizerOn;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column lxy_product.AUTHORIZER_ON
	 * @param authorizerOn  the value for lxy_product.AUTHORIZER_ON
	 * @mbggenerated  Thu Dec 11 14:28:00 CST 2014
	 */
	public void setAuthorizerOn(Date authorizerOn) {
		this.authorizerOn = authorizerOn;
	}
}