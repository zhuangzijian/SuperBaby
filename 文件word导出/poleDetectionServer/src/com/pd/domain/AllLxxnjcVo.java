package com.pd.domain;

import java.util.List;

public class AllLxxnjcVo {

	private Sample sample;
	private List<LxxnjcLoadingFrist> lxxnjcFristList;// 第一次加载
	private List<LxxnjcLoadingSecond> lxxnjcSecondList;// 第二次加载
	private LxxnjcOffloading lxxnjcOff;// 卸载
	private Rule rule;//力学性能检测相关的值

	public List<LxxnjcLoadingFrist> getLxxnjcFristList() {
		return lxxnjcFristList;
	}

	public void setLxxnjcFristList(List<LxxnjcLoadingFrist> lxxnjcFristList) {
		this.lxxnjcFristList = lxxnjcFristList;
	}

	public List<LxxnjcLoadingSecond> getLxxnjcSecondList() {
		return lxxnjcSecondList;
	}

	public void setLxxnjcSecondList(List<LxxnjcLoadingSecond> lxxnjcSecondList) {
		this.lxxnjcSecondList = lxxnjcSecondList;
	}

	public LxxnjcOffloading getLxxnjcOff() {
		return lxxnjcOff;
	}

	public void setLxxnjcOff(LxxnjcOffloading lxxnjcOff) {
		this.lxxnjcOff = lxxnjcOff;
	}

	public Sample getSample() {
		return sample;
	}

	public void setSample(Sample sample) {
		this.sample = sample;
	}

	public Rule getRule() {
		return rule;
	}

	public void setRule(Rule rule) {
		this.rule = rule;
	}
}
