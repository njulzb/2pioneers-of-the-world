package UI.aaManager;

import UI.littleUI.QiPaoUI;
import UI.mainUI.MainStage;
import UI.stockUI.StockMessageUI;
import UI.stockUI.StockSelectUI;
import keyForSearch.KeyForSearchStock;
import rmi.ClientRunner;
import vo.StockVO;

import java.time.LocalDate;
import java.util.ArrayList;

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



        selectOneStock(null);


        //添加rmi相关部分f
        return out;

    }

}
