package com.lotto.web.serviceimpls;

import java.util.Random;

import com.lotto.web.daoimpls.LottoDAOImpl;
import com.lotto.web.daos.LottoDAO;
import com.lotto.web.domains.LottoBean;
import com.lotto.web.services.LottoService;

public class LottoServiceImpl implements LottoService {
	private LottoDAO dao;
	private LottoBean lotto;
	Random ran;

	public LottoServiceImpl() {
		lotto = new LottoBean();
		dao = new LottoDAOImpl();
		ran = new Random();
	}

	@Override
	public void createLotto(LottoBean param) {
		param.setBall(createBall()+"");
		param.setLotteryNum(createLotteryNum());
		param.setLottoSeq(createLottoSeq());
		dao.insertLotto(param);
	}

	@Override
	public String createLottoSeq() {
		String seqNum = "";
		seqNum = "NO." + ran.nextInt(9999) + "/";
		lotto.setLottoSeq(String.valueOf(seqNum));
		return seqNum;
	}

	@Override
	public int createBall() {
		return (int) (Math.random() * 45) + 1;
	}

	@Override
	public String createLotteryNum() {
		String result = "";
		int[] arr = new int[6];
		for (int i = 0; i < arr.length; i++) {
			int a = createBall();
			if (!exist(arr, a)) {
				arr[i] = a;
			} else {
				i--;
			}
		}
		arr = bubbleSort(arr, true);
		for (int i = 0; i < arr.length; i++) {
			if(i!=5) {
				result += arr[i] + " , ";
			}else {
				result += arr[i];
			}
		}
		return result;
	}

	@Override
	public boolean exist(int[] arr, int a) {
		boolean b = false;
		for (int i : arr) {
			if (a == i) {
				b = true;
			}
		}
		return b;
	}

	@Override
	public int[] bubbleSort(int[] arr, boolean flag) {
		int t = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length - 1; j++) {
				if (flag) {
					if (arr[j] > arr[j + 1]) {
						t = arr[j];
						arr[j] = arr[j + 1];
						arr[j + 1] = t;
					}
				} else {
					if (arr[j] < arr[j + 1]) {
						t = arr[j];
						arr[j] = arr[j + 1];
						arr[j + 1] = t;
					}
				}
			}
		}
		return arr;
	}

}
