package UI.aaManager;

import UI.littleUI.QiPaoUI;
import UI.mainUI.MainStage;
import UI.stockUI.StockMessageUI;
import UI.stockUI.StockSelectUI;
import UI.uiHelper.DateHelper;
import keyForSearch.KeyForSearchStock;
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
    private StockSelectUI ui;

    public StockSelectManager(StockSelectUI ui) {
        this.ui = ui;
    }

    public void selectOneStock(StockVO vo) {
        MainStage.getInstance().changePaneWithNavigation(new StockMessageUI(vo));
    }

    public ArrayList<StockVO> searchStock(String input, LocalDate sDate, LocalDate eDate) {
        ArrayList<StockVO> out = new ArrayList<StockVO>();

        if (sDate == null || eDate == null) {
            try {
                System.out.print("错误！请确认起止日期完整");
                QiPaoUI.showTip(ui, "错误！请确认起止日期完整");
            } catch (Exception e) {

            }
            return out;
        }


        if (eDate.isBefore(sDate)) {
            try {
                System.out.print("错误！结束日期不能早于开始日期");
                QiPaoUI.showTip(ui, "错误！结束日期不能早于开始日期");
            } catch (Exception e) {

            }
            return out;

        }



        Date start = DateHelper.LocalDateToDate(sDate);
        Date end = DateHelper.LocalDateToDate(eDate);
        StockResultMsg srm = null;


        System.out.println("startdate="+start.toString());
        MainStage.getInstance().changePaneWithNavigation(new StockMessageUI(null));

//        try {
//            srm = ClientRunner.getInstance().getStockQueryBLService()
//                    .queryStockByCodeAndDate(input, start, end);
//
//
//        } catch (RemoteException e) {
//            e.printStackTrace();
//        } catch (NotBoundException e) {
//            e.printStackTrace();
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
//
//        if (srm == null) {
//            QiPaoUI.showTip("searchResultMessage = null");
//            return out;
//        } else if (!srm.isSuccessful()) {
//            QiPaoUI.showTip(srm.getErrorMsg());
//            return out;
//        } else {
//            MainStage.getInstance().changePaneWithNavigation(new StockMessageUI(srm.getStockVO()));
//
//        }


        //添加rmi相关部分f
        return out;

    }

}
