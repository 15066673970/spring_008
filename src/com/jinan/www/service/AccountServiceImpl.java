package com.jinan.www.service;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.jinan.www.dao.AccountDao;

public class AccountServiceImpl implements AccountService {

	private AccountDao ad;
	private TransactionTemplate tt;
	
	
	@Override
	public void transfer(Integer from, Integer to, Double money) {
		// TODO Auto-generated method stub
		//减钱
		ad.decreaseMoney(from, money);
	
		//模拟异常
		int i=1/0;
		
		//加钱
		ad.increaseMoney(to, money);
	}
	/*
	@Override
	public void transfer(Integer from, Integer to, Double money) {
		
		tt.execute(new TransactionCallbackWithoutResult() {
			
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus arg0) {
				//减钱
				ad.decreaseMoney(from, money);
			
				//模拟异常
//				int i=1/0;
				
				//加钱
				ad.increaseMoney(to, money);
			}
		});
		//1.打开事务
		//2.调用doInTransactionWithoutResult方法
		//3.提交事务
	}*/

	public void setAd(AccountDao ad) {
		this.ad = ad;
	}

	public void setTt(TransactionTemplate tt) {
		this.tt = tt;
	}
	
	

}
