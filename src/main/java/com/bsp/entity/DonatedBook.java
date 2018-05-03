package com.bsp.entity;

import org.apache.ibatis.type.Alias;

@Alias("DonatedBook")
public class DonatedBook extends BaseEntity {
	private static final long serialVersionUID = 1L;

	// 捐赠的图书标识，数字自增值
    private Integer dobId;

    // 捐赠的图书名称
    private String dobName;

    // 捐赠的图书ISBN号
    private String isbn;

    // 捐赠的图书数量
    private Integer number;

    // 捐赠图书所属的二级分类
    private SecondaryClassification secondaryClassification;

    // 捐赠人
    private User user;

    /**
     * 捐赠的图书标识，数字自增值
     */
    public Integer getDobId() {
        return dobId;
    }

    /**
     * @param dobId 捐赠的图书标识，数字自增值
     */
    public void setDobId(Integer dobId) {
        this.dobId = dobId;
    }

    /**
     * 捐赠的图书名称
     */
    public String getDobName() {
        return dobName;
    }

    /**
     * @param dobName 捐赠的图书名称
     */
    public void setDobName(String dobName) {
        this.dobName = dobName == null ? null : dobName.trim();
    }

    /**
     * 捐赠的图书ISBN号
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * @param isbn 捐赠的图书ISBN号
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn == null ? null : isbn.trim();
    }

    /**
     * 捐赠的图书数量
     */
    public Integer getNumber() {
        return number;
    }

    /**
     * @param number 捐赠的图书数量
     */
    public void setNumber(Integer number) {
        this.number = number;
    }

    /**
     * 捐赠图书所属的二级分类
     */
    public SecondaryClassification getSecondaryClassification() {
        return secondaryClassification;
    }

    /**
     * @param secondaryClassification 捐赠图书所属的二级分类
     */
    public void setSecondaryClassification(SecondaryClassification secondaryClassification) {
        this.secondaryClassification = secondaryClassification;
    }

    /**
     * 捐赠人
     */
    public User getUser() {
        return user;
    }

    /**
     * @param uuid 捐赠人
     */
    public void setUser(User user) {
        this.user = user;
    }
}