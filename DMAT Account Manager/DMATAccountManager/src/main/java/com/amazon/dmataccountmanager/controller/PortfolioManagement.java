package com.amazon.dmataccountmanager.controller;

import java.util.List;
import java.util.Scanner;

import com.amazon.dmataccountmanager.userSession;
import com.amazon.dmataccountmanager.db.PortfolioDAO;
import com.amazon.dmataccountmanager.model.Portfolios;

public class PortfolioManagement {
	
	Scanner scanner = new Scanner(System.in);
	Portfolios portfolio = new Portfolios();
	PortfolioDAO portfoliodao = new PortfolioDAO();
	
	private static PortfolioManagement managePortfolios = new PortfolioManagement();
	
	public static PortfolioManagement getInstance() {
		return managePortfolios;
	}
	
	private PortfolioManagement() {
	}
	
	public void displayPortfolio() {
        String sql = "SELECT * FROM Portfolios WHERE userID= '"+userSession.user.userID+"'";
        List <Portfolios> portfolios = portfoliodao.retrieve(sql);

        //display the details
        for(Portfolios portfolioDetails: portfolios) {
            portfolio.prettyPrint(portfolioDetails);
        }
    }
	
	public boolean updatePortfolio(Portfolios portfolios) {
		
		return false;
	}

}
