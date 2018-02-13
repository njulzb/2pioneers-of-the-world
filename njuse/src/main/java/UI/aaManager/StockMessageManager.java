package UI.aaManager;

import UI.littleUI.QiPaoUI;
import UI.mainUI.MainStage;
import UI.stockUI.StockCompareUI;
import UI.stockUI.StockMessageUI;
import UI.stockUI.StockSelectWindows;
import UI.uiHelper.DateHelper;
import resultMsg.StockResultMsg;
import rmi.ClientRunner;
import vo.StockVO;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class StockMessageManager {
    private StockMessageUI ui;

    public StockMessageManager(StockMessageUI ui) {
        this.ui = ui;
    }

    public void compare() {
        StockSelectWindows ssw = new StockSelectWindows();
        ssw.showSelector();
        if (ssw.stockResultMsg == null) {
            return;
        } else {

            if(ssw.stockResultMsg.getStockVO().getCode()==ui.smsg.getStockVO().getCode()){
                QiPaoUI.showTip("不能与自己比较！");
            }
            else{
                ArrayList<StockResultMsg> lit=new ArrayList<StockResultMsg>();
                lit.add(ssw.stockResultMsg);
                lit.add(ui.smsg);
                MainStage.getInstance().changePaneWithNavigation(new StockCompareUI(lit));
            }


        }


    }

    public void reSearch(LocalDate startDate, LocalDate endDate, String code) {
        Date sD = DateHelper.LocalDateToDate(startDate);
        Date eD = DateHelper.LocalDateToDate(endDate);


        StockResultMsg srm = null;


        try {
            srm = ClientRunner.getInstance().getStockQueryBLService()
                    .queryStockByCodeAndDate(code, sD, eD);

        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        if (srm == null) {
            QiPaoUI.showTip("searchResultMessage = null");
            return;
        } else if (!srm.isSuccessful()) {
            QiPaoUI.showTip(srm.getErrorMsg());
            return;
        } else {

            MainStage.getInstance().changePaneWithNavigation(new StockMessageUI(srm));

        }
    }


}
