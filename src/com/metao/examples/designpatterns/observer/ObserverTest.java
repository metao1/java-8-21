package com.metao.examples.designpatterns.observer;

import com.metao.examples.designpatterns.dp.observer.Internet;
import com.metao.examples.designpatterns.dp.observer.Loan;
import com.metao.examples.designpatterns.dp.observer.Newspaper;

public class ObserverTest {

    public static void main(String[] args) {
        // this will maintain all loans information
        com.metao.examples.designpatterns.dp.observer.Newspaper printMedia = new com.metao.examples.designpatterns.dp.observer.Newspaper();
        com.metao.examples.designpatterns.dp.observer.Internet onlineMedia = new com.metao.examples.designpatterns.dp.observer.Internet();

        com.metao.examples.designpatterns.dp.observer.Loan personalLoan = new com.metao.examples.designpatterns.dp.observer.Loan("Personal Loan", 12.5f,
                "Standard Charterd");
        personalLoan.registerObserver(printMedia);
        personalLoan.registerObserver(onlineMedia);
        personalLoan.setInterest(3.5f);

    }
}