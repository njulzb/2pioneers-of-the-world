package UI.aaManager;

import UI.mainUI.MainStage;
import UI.stockUI.StockMessageUI;
import UI.stockUI.StockSelectUI;
import UI.welcomeUI.WelcomeMainUI;

public class NavigationManager {

    public void callGuide(){
        MainStage.getInstance().changePaneWithNavigation(new WelcomeMainUI());
    }
    public void callMarketView() {

    }

    public void callMarketTem() {

    }

    public void callStockMessage() {

        MainStage.getInstance().changePaneWithNavigation(new StockSelectUI());
    }

}
