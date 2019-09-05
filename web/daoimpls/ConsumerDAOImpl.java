package com.lotto.web.daoimpls;

import java.io.File;

import com.lotto.web.pool.Constants;
import com.lotto.web.daos.ConsumerDAO;
import com.lotto.web.domains.ConsumerBean;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.io.FileReader;

public class ConsumerDAOImpl implements ConsumerDAO{
	
	@Override
	public void insertConsumer(ConsumerBean param) {
		try {
			File file = new File(Constants.FILE_PATH+"consumer0905.txt");
			@SuppressWarnings("resource")
			BufferedWriter writer = new BufferedWriter(new FileWriter(file,true));
			writer.write(String.format("%s,%s", param.getCid(), param.getPass()));
			writer.newLine();
			writer.flush();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public ConsumerBean login(ConsumerBean param) {
		try {
			File file = new File(Constants.FILE_PATH + "consumer0905.txt");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String msg = reader.readLine();
			reader.close();
			String[] info = new String[2];
			info = msg.split(",");
			param.setCid(info[0]);
			param.setPass(info[1]);
			
			}catch(Exception e) {
				e.printStackTrace();
			}
			return param;
		}

}
