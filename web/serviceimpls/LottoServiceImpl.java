package com.lotto.web.serviceimpls;

import java.util.Random;

import com.lotto.web.daoimpls.LottoDAOImpl;
import com.lotto.web.daos.LottoDAO;
import com.lotto.web.domains.LottoBean;
import com.lotto.web.services.LottoService;

public class LottoServiceImpl implements LottoService{
	private LottoDAO dao;
	public LottoServiceImpl() {
		dao = new LottoDAOImpl();
	}

	@Override
	public void createLotto(LottoBean param) {
		String seqNum = "";
		String lottoNum = "";
		Random ran = new Random();
		for (int i = 0; i < 3; i++) {
			if (i == 0) {
				seqNum += "N";
			}
			else if (i == 1) {
				seqNum += "O.";
			} else {
				seqNum += ran.nextInt(9999) + "/";
				param.setLottoSeq(String.valueOf(seqNum));
			}
		}for (int j = 0; j < 6; j++) {
			if (j != 5) {
				lottoNum += ran.nextInt(45)+1+ ",";
			} else {
				lottoNum += ran.nextInt(45)+1;
			}
			param.setLotteryNum(String.valueOf(lottoNum));
		}
		System.out.println(param.getLottoSeq()+param.getLotteryNum());
		dao.insertLotto(param);
	}

	@Override
	public String createLottoSeq(String param) {
		String seqNum = "";
		return seqNum;
	}

	@Override
	public String createBall(String param) {
		String ballNum = "";
		return ballNum;
	}

	@Override
	public String createLotteryNum(String param) {
		String lotteryNum = "";
		return lotteryNum;
	}

	@Override
	public boolean duplicaterPrevention(int[] arr) {
		
		return false;
	}

	@Override
	public String ascendingSort(int[] arr) {
		
		return null;
	}


}
