package com.lotto.web.services;

import com.lotto.web.domains.LottoBean;

public interface LottoService {
	public void createLotto(LottoBean param);
	public String createLottoSeq(String param);
	public String createBall(String param);
	public String createLotteryNum(String param);
	public boolean duplicaterPrevention(int[] arr);
	public String ascendingSort(int[] arr);
}
