package UI.aaManager;

import UI.mainUI.MainStage;
import UI.marketTemUI.MarketTemMainUI;
import UI.stockUI.StockMessageUI;
import UI.stockUI.StockSelectWindows;
import UI.welcomeUI.WelcomeMainUI;
import javafx.stage.Stage;
import resultMsg.StockResultMsg;

public class WelcomeManager {
    private WelcomeMainUI ui ;

    public WelcomeManager( WelcomeMainUI ui ) {
        this.ui=ui;
    }



    public void callFunction_stockMessage(){
        StockSelectWindows ssw= new StockSelectWindows();
        ssw.showSelector();
        if(ssw.stockResultMsg==null){
            return;
        }
        StockResultMsg smsg=  ssw.stockResultMsg;
        MainStage.getInstance().changePaneWithNavigation(new StockMessageUI(smsg));

    }
    public void callFunction_marketThermometer(){

        MainStage.getInstance().changePaneWithNavigation(new MarketTemMainUI(null));

    }

}
