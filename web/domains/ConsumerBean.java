package com.lotto.web.domains;

import java.io.Serializable;

public class ConsumerBean implements Serializable {
	private String cid, pass, lottoSeq, prizeMoney; 
	
	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getLottoSeq() {
		return lottoSeq;
	}

	public void setLottoSeq(String lottoSeq) {
		this.lottoSeq = lottoSeq;
	}

	public String getPrizeMoney() {
		return prizeMoney;
	}

	public void setPrizeMoney(String prizeMoney) {
		this.prizeMoney = prizeMoney;
	}

	@Override
	public String toString() {
		return String.format("구매자 정보"
				+ "[아이디 : %s\n"
				+ "비밀번호 : %s\n"
				+ "일련번호 : %s\n"
				+ "당첨금 : %s", cid, pass, lottoSeq, prizeMoney);
	}
}
