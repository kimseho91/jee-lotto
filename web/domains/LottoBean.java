package com.lotto.web.domains;

import java.io.Serializable;

public class LottoBean implements Serializable{
	private String lottoSeq, ball, lotteryNum;

public String getLottoSeq() {
		return lottoSeq;
	}

	public void setLottoSeq(String lottoSeq) {
		this.lottoSeq = lottoSeq;
	}

	public String getBall() {
		return ball;
	}

	public void setBall(String ball) {
		this.ball = ball;
	}

	public String getLotteryNum() {
		return lotteryNum;
	}

	public void setLotteryNum(String lotteryNum) {
		this.lotteryNum = lotteryNum;
	}

@Override
public String toString() {
	return String.format("로또 정보"
			+ "[일련번호 : %s\n"
			+ "볼 번호 : %s\n"
			+ "추첨번호 : %s", lottoSeq, ball, lotteryNum);
}
}
