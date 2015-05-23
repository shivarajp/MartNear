package com.marts.near.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProductDetailsApi {

    @Expose
    private String pname;
    @SerializedName("pselling_desc")
    @Expose
    private String psellingDesc;
    @SerializedName("pactual_price")
    @Expose
    private String pactualPrice;
    @Expose
    private String psellingprice;
    @Expose
    private String pdiscount;
    @Expose
    private String shopname;
    @Expose
    private String purl;
    @Expose
    private String shoplolcation;

    /**
     *
     * @return
     * The pname
     */
    public String getPname() {
        return pname;
    }

    /**
     *
     * @param pname
     * The pname
     */
    public void setPname(String pname) {
        this.pname = pname;
    }

    /**
     *
     * @return
     * The psellingDesc
     */
    public String getPsellingDesc() {
        return psellingDesc;
    }

    /**
     *
     * @param psellingDesc
     * The pselling_desc
     */
    public void setPsellingDesc(String psellingDesc) {
        this.psellingDesc = psellingDesc;
    }

    /**
     *
     * @return
     * The pactualPrice
     */
    public String getPactualPrice() {
        return pactualPrice;
    }

    /**
     *
     * @param pactualPrice
     * The pactual_price
     */
    public void setPactualPrice(String pactualPrice) {
        this.pactualPrice = pactualPrice;
    }

    /**
     *
     * @return
     * The psellingprice
     */
    public String getPsellingprice() {
        return psellingprice;
    }

    /**
     *
     * @param psellingprice
     * The psellingprice
     */
    public void setPsellingprice(String psellingprice) {
        this.psellingprice = psellingprice;
    }

    /**
     *
     * @return
     * The pdiscount
     */
    public String getPdiscount() {
        return pdiscount;
    }

    /**
     *
     * @param pdiscount
     * The pdiscount
     */
    public void setPdiscount(String pdiscount) {
        this.pdiscount = pdiscount;
    }

    /**
     *
     * @return
     * The shopname
     */
    public String getShopname() {
        return shopname;
    }

    /**
     *
     * @param shopname
     * The shopname
     */
    public void setShopname(String shopname) {
        this.shopname = shopname;
    }

    /**
     *
     * @return
     * The purl
     */
    public String getPurl() {
        return purl;
    }

    /**
     *
     * @param purl
     * The purl
     */
    public void setPurl(String purl) {
        this.purl = purl;
    }

    /**
     *
     * @return
     * The shoplolcation
     */
    public String getShoplolcation() {
        return shoplolcation;
    }

    /**
     *
     * @param shoplolcation
     * The shoplolcation
     */
    public void setShoplolcation(String shoplolcation) {
        this.shoplolcation = shoplolcation;
    }

}

