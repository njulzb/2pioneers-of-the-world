package UI.aaManager;

import UI.mainUI.MainStage;
import UI.marketTemUI.MarketTemMainUI;
import UI.stockUI.StockMessageUI;
import UI.stockUI.StockSelectWindows;
import UI.welcomeUI.WelcomeMainUI;
import com.sun.tools.javac.Main;
import javafx.stage.Stage;
import resultMsg.StockResultMsg;

public class NavigationManager {

    public void callGuide() {
        MainStage.getInstance().changePaneWithNavigation(new WelcomeMainUI());
    }

    public void callMarketView() {

    }

    public void callMarketTem() {
        MainStage.getInstance().changePaneWithNavigation(new MarketTemMainUI(null));
    }

    public void callStockMessage() {
        StockSelectWindows ssw= new StockSelectWindows();
        ssw.showSelector();
        if(ssw.stockResultMsg==null){
            return;
        }

        StockResultMsg smsg=  ssw.stockResultMsg;
        MainStage.getInstance().changePaneWithNavigation(new StockMessageUI(smsg));


    }

}
