package com.pd.domain;

public class LxxnjcReport {
	private Sample sample;
	private String kljyjyxsscz;// 抗裂检验检验系数实测值
	private String kljywjzhgzb;// 抗裂检验弯矩值合格指标
	private String kljywjzscz;// 抗裂检验弯矩值实测值

	private String czljyjyxsscz;// 承载力检验检验系数实测值
	private String czljywjzhgzb;// 承载力检验弯矩值合格指标
	private String czljywjzscz;// 承载力检验弯矩值实测值

	private String ndkljywjhgzb;// 挠度开裂检验弯矩合格指标
	private String ndkljywjscz;// 挠度开裂检验弯矩实测值

	private String ndczljywjhgzb;// 挠度承载力检验弯矩合格指标
	private String ndczljywjscz;// 挠度承载力检验弯矩实测值

	private String lfkdkljywjhgzb;// 裂缝宽度开裂检验弯矩合格指标
	private String lfkdkljywjscz;// 裂缝宽度开裂检验弯矩实测值

	private String lfkdczljywjhgzb;// 裂缝宽度承载力检验弯矩合格指标
	private String lfkdczljywjscz;// 裂缝宽度承载力检验弯矩实测值

	private String lfkddycxzhhgzb;// 裂缝宽度第一次卸载后合格指标
	private String lfkddycxzhscz;// 裂缝宽度第一次卸载后实测值

	private String lfkdbfzbshgzb;// 裂缝宽度80%开裂检验弯矩合格指标
	private String lfkdbfzbsscz;// 裂缝宽度80%开裂检验弯矩实测值

	private String zdlfkd;// 最大裂缝宽度
	private String gdnd;// 干顶挠度

	private Rule rule;// 力学性能检测相关的值

	private boolean kljyIsqualified;// 某个样品开裂检验是否合格
	private boolean czljyIsqualified;// 某个样品承载力检验是否合格
	private boolean ndIsqualified;// 某个样品挠度是否合格
	private boolean lfkdIsqualified;// 某个样品裂缝宽度是否合格
	private boolean isqualified;// 某个样品最终是否合格

	private String kljyStr;
	private String czljyFirstStr;
	private String czljySecondStr;
	private String czljyThiredStr;
	private String dxpd;

	public String getLfkdbfzbshgzb() {
		return lfkdbfzbshgzb;
	}

	public void setLfkdbfzbshgzb(String lfkdbfzbshgzb) {
		this.lfkdbfzbshgzb = lfkdbfzbshgzb;
	}

	public String getLfkdbfzbsscz() {
		return lfkdbfzbsscz;
	}

	public void setLfkdbfzbsscz(String lfkdbfzbsscz) {
		this.lfkdbfzbsscz = lfkdbfzbsscz;
	}

	public Sample getSample() {
		return sample;
	}

	public void setSample(Sample sample) {
		this.sample = sample;
	}

	public String getKljyjyxsscz() {
		return kljyjyxsscz;
	}

	public void setKljyjyxsscz(String kljyjyxsscz) {
		this.kljyjyxsscz = kljyjyxsscz;
	}

	public String getKljywjzhgzb() {
		return kljywjzhgzb;
	}

	public void setKljywjzhgzb(String kljywjzhgzb) {
		this.kljywjzhgzb = kljywjzhgzb;
	}

	public String getKljywjzscz() {
		return kljywjzscz;
	}

	public void setKljywjzscz(String kljywjzscz) {
		this.kljywjzscz = kljywjzscz;
	}

	public String getCzljyjyxsscz() {
		return czljyjyxsscz;
	}

	public void setCzljyjyxsscz(String czljyjyxsscz) {
		this.czljyjyxsscz = czljyjyxsscz;
	}

	public String getCzljywjzhgzb() {
		return czljywjzhgzb;
	}

	public void setCzljywjzhgzb(String czljywjzhgzb) {
		this.czljywjzhgzb = czljywjzhgzb;
	}

	public String getCzljywjzscz() {
		return czljywjzscz;
	}

	public void setCzljywjzscz(String czljywjzscz) {
		this.czljywjzscz = czljywjzscz;
	}

	public String getNdkljywjhgzb() {
		return ndkljywjhgzb;
	}

	public void setNdkljywjhgzb(String ndkljywjhgzb) {
		this.ndkljywjhgzb = ndkljywjhgzb;
	}

	public String getNdkljywjscz() {
		return ndkljywjscz;
	}

	public void setNdkljywjscz(String ndkljywjscz) {
		this.ndkljywjscz = ndkljywjscz;
	}

	public String getNdczljywjhgzb() {
		return ndczljywjhgzb;
	}

	public void setNdczljywjhgzb(String ndczljywjhgzb) {
		this.ndczljywjhgzb = ndczljywjhgzb;
	}

	public String getNdczljywjscz() {
		return ndczljywjscz;
	}

	public void setNdczljywjscz(String ndczljywjscz) {
		this.ndczljywjscz = ndczljywjscz;
	}

	public String getLfkdkljywjhgzb() {
		return lfkdkljywjhgzb;
	}

	public void setLfkdkljywjhgzb(String lfkdkljywjhgzb) {
		this.lfkdkljywjhgzb = lfkdkljywjhgzb;
	}

	public String getLfkdkljywjscz() {
		return lfkdkljywjscz;
	}

	public void setLfkdkljywjscz(String lfkdkljywjscz) {
		this.lfkdkljywjscz = lfkdkljywjscz;
	}

	public String getLfkdczljywjhgzb() {
		return lfkdczljywjhgzb;
	}

	public void setLfkdczljywjhgzb(String lfkdczljywjhgzb) {
		this.lfkdczljywjhgzb = lfkdczljywjhgzb;
	}

	public String getLfkdczljywjscz() {
		return lfkdczljywjscz;
	}

	public void setLfkdczljywjscz(String lfkdczljywjscz) {
		this.lfkdczljywjscz = lfkdczljywjscz;
	}

	public String getLfkddycxzhhgzb() {
		return lfkddycxzhhgzb;
	}

	public void setLfkddycxzhhgzb(String lfkddycxzhhgzb) {
		this.lfkddycxzhhgzb = lfkddycxzhhgzb;
	}

	public String getLfkddycxzhscz() {
		return lfkddycxzhscz;
	}

	public void setLfkddycxzhscz(String lfkddycxzhscz) {
		this.lfkddycxzhscz = lfkddycxzhscz;
	}

	public String getZdlfkd() {
		return zdlfkd;
	}

	public void setZdlfkd(String zdlfkd) {
		this.zdlfkd = zdlfkd;
	}

	public String getGdnd() {
		return gdnd;
	}

	public void setGdnd(String gdnd) {
		this.gdnd = gdnd;
	}

	public boolean isIsqualified() {
		return isqualified;
	}

	public void setIsqualified(boolean isqualified) {
		this.isqualified = isqualified;
	}

	public boolean isKljyIsqualified() {
		return kljyIsqualified;
	}

	public void setKljyIsqualified(boolean kljyIsqualified) {
		this.kljyIsqualified = kljyIsqualified;
	}

	public boolean isCzljyIsqualified() {
		return czljyIsqualified;
	}

	public void setCzljyIsqualified(boolean czljyIsqualified) {
		this.czljyIsqualified = czljyIsqualified;
	}

	public boolean isNdIsqualified() {
		return ndIsqualified;
	}

	public void setNdIsqualified(boolean ndIsqualified) {
		this.ndIsqualified = ndIsqualified;
	}

	public boolean isLfkdIsqualified() {
		return lfkdIsqualified;
	}

	public void setLfkdIsqualified(boolean lfkdIsqualified) {
		this.lfkdIsqualified = lfkdIsqualified;
	}

	public String getKljyStr() {
		return kljyStr;
	}

	public void setKljyStr(String kljyStr) {
		this.kljyStr = kljyStr;
	}

	public String getCzljyFirstStr() {
		return czljyFirstStr;
	}

	public void setCzljyFirstStr(String czljyFirstStr) {
		this.czljyFirstStr = czljyFirstStr;
	}

	public String getCzljySecondStr() {
		return czljySecondStr;
	}

	public void setCzljySecondStr(String czljySecondStr) {
		this.czljySecondStr = czljySecondStr;
	}

	public String getCzljyThiredStr() {
		return czljyThiredStr;
	}

	public void setCzljyThiredStr(String czljyThiredStr) {
		this.czljyThiredStr = czljyThiredStr;
	}

	public String getDxpd() {
		return dxpd;
	}

	public void setDxpd(String dxpd) {
		this.dxpd = dxpd;
	}

	public Rule getRule() {
		return rule;
	}

	public void setRule(Rule rule) {
		this.rule = rule;
	}
}
