package UI.aaManager;

import UI.littleUI.QiPaoUI;
import UI.mainUI.MainStage;
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

public class StockSelectManager {
    private StockSelectWindows ui;

    public StockSelectManager(StockSelectWindows ui) {
        this.ui = ui;
    }

    public void selectOneStock(StockResultMsg srm) {

        MainStage.getInstance().changePaneWithNavigation(new StockMessageUI(srm));
    }

    public StockResultMsg searchStock(String input, LocalDate sDate, LocalDate eDate) {
        ArrayList<StockVO> out = new ArrayList<StockVO>();

        if (sDate == null || eDate == null) {
            try {
                System.out.print("错误！请确认起止日期完整");
                QiPaoUI.showTip(ui.root, "错误！请确认起止日期完整");
            } catch (Exception e) {

            }
            return null;
        }


        if (eDate.isBefore(sDate)) {
            try {
                System.out.print("错误！结束日期不能早于开始日期");
                QiPaoUI.showTip(ui.root, "错误！结束日期不能早于开始日期");
            } catch (Exception e) {

            }
            return null;

        }


        Date start = DateHelper.LocalDateToDate(sDate);
        Date end = DateHelper.LocalDateToDate(eDate);
        StockResultMsg srm = null;


        try {
            srm = ClientRunner.getInstance().getStockQueryBLService()
                    .queryStockByCodeAndDate(input, start, end);


        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        if (srm == null) {
            try {
                QiPaoUI.showTip(ui.root, "searchResultMessage = null");
                ;
            } catch (Exception e) {

            }

            return null;
        } else if (!srm.isSuccessful()) {
            try {
                QiPaoUI.showTip(ui.root, srm.getErrorMsg());
                ;
            } catch (Exception e) {

            }

            return null;
        } else {
            return srm;

        }
    }

}
