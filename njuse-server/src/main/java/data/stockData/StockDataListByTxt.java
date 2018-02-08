package data.stockData;



import po.stock.StockPO;
import utility.poResultMsg.StockPOResultMsg;
import vo.StockItem;

import java.io.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * 数据文件第一行为标题行，随后的数据每行代表某只股票一天的涨跌数据，
 * 从前往后依次为：
 * 记录编号  日期（月/日/年） 开盘指数  最高指数  最低指数  收盘指数 
 * 成交量  复权后的收盘指数  股票代码  股票名称  市场名称。
 * 各变量之间 用 tab 分隔  数据文件使用 UTF8 编码，换行符为 CR 
 *
 *  0.serial  1.date 2.open 3.high 4.low 5.close
 *  6.volume 7.adj_close 8.code 9.name 10.market
 *
 */
public class StockDataListByTxt {
    private static StockDataListByTxt instance = new StockDataListByTxt();

    public static StockDataListByTxt getInstance() {
        return instance;
    }

    private ArrayList<String> stockInfoList = new ArrayList<String>();

    private StockDataListByTxt(){
        String filePath = this.getClass().getClassLoader().getResource("data.csv").getPath();
        File file = new File(filePath);
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line ;
            while ((line = bufferedReader.readLine())!=null){
                this.stockInfoList.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public StockPOResultMsg searchStockByCode(String code){
        StockPOResultMsg resultMsg = null;
        StockPO stockPO = null;
        String name =null, market =null;
        ArrayList<StockItem> itemArrayList = new ArrayList<StockItem>();

        //遍历整张表
        for (String eLine:this.stockInfoList){
            String[] array = eLine.split("\t");

            if (code.equals(array[8])){//code 相等
                if (stockPO==null){//检索到的第一条记录
                    name = array[9];
                    market = array[10];
                    stockPO = new StockPO(code,name,market,itemArrayList);
                }

//                拼装item
                StockItem stockItem = new StockItem(eLine);
                itemArrayList.add(stockItem);//添加item
            }

        }//遍历结束

        if (stockPO==null){//搜索不存在
            resultMsg = new StockPOResultMsg(false,"there is no stock with that code",null);
        }else{//搜索完成
            resultMsg = new StockPOResultMsg(true,"successful",stockPO);
        }

        return resultMsg;
    }

    public StockPOResultMsg searchStockByName(String name){
        StockPOResultMsg resultMsg = null;
        StockPO stockPO = null;
        String code =null, market =null;
        ArrayList<StockItem> itemArrayList = new ArrayList<StockItem>();

        //遍历整张表
        for (String eLine:this.stockInfoList){
            String[] array = eLine.split("\t");

            if (name.equals(array[9])){//name 相等
                if (stockPO==null){//检索到的第一条记录
                    code = array[8];
                    market = array[10];
                    stockPO = new StockPO(code,name,market,itemArrayList);
                }

//                拼装item
                StockItem stockItem = new StockItem(eLine);
                itemArrayList.add(stockItem);//添加item
            }

        }//遍历结束

        if (stockPO==null){//搜索不存在
            resultMsg = new StockPOResultMsg(false,"there is no stock with that code",null);
        }else{//搜索完成
            resultMsg = new StockPOResultMsg(true,"successful",stockPO);
        }

        return resultMsg;
    }

    public StockPOResultMsg searchStockByMarket(String market){
        StockPOResultMsg resultMsg = null;
        StockPO stockPO = null;
        String code =null, name =null;
        ArrayList<StockItem> itemArrayList = new ArrayList<StockItem>();

        //遍历整张表
        for (String eLine:this.stockInfoList){
            String[] array = eLine.split("\t");

            if (market.equals(array[10])){//market 相等
                if (stockPO==null){//检索到的第一条记录
                    code = array[8];
                    name = array[9];
                    stockPO = new StockPO(code,name,market,itemArrayList);
                }

//                拼装item
                StockItem stockItem = new StockItem(eLine);
                itemArrayList.add(stockItem);//添加item
            }

        }//遍历结束

        if (stockPO==null){//搜索不存在
            resultMsg = new StockPOResultMsg(false,"there is no stock with that market",null);
        }else{//搜索完成
            resultMsg = new StockPOResultMsg(true,"successful",stockPO);
        }

        return resultMsg;
    }

    public StockPOResultMsg searchStockByCodeAndDate(String code , Date begin ,Date end){
        StockPOResultMsg poResultMsg = this.searchStockByCode(code);
        if (poResultMsg.isSuccessful()==false){
            return poResultMsg;
        }
//        get rid of the items not between the begin and end
        ArrayList<StockItem> itemArrayList = poResultMsg.getStockPO().getStockItemArrayList();
        ArrayList<StockItem> newList = new ArrayList<>();
        for (StockItem eItem : itemArrayList){
            boolean betweenFlag = eItem.getDate().before(end) && eItem.getDate().after(begin);
            boolean pointFlag = eItem.getDate().equals(begin) || eItem.getDate().equals(end);

            if (betweenFlag || pointFlag){
                newList.add(eItem);
            }
        }
        poResultMsg.getStockPO().setStockItemArrayList(newList);
        return poResultMsg;
    }

    public StockPOResultMsg searchStockByPredicate(Predicate condition){



        List<String> list = this.stockInfoList.stream().filter(x->condition.test(x)).collect(Collectors.toList());
        if (list==null || list.size()==0){
            return new StockPOResultMsg(false,"no found",null);
        }

        ArrayList<StockItem> itemArrayList = new ArrayList<StockItem>();
        list.forEach(x->itemArrayList.add(new StockItem(x)));

        String line = list.get(0);
        String[] array = line.split("\t");
        String code = array[8],
                name = array[9],
                market = array[10];

        StockPO stockPO = new StockPO(code,name,market,itemArrayList);
        StockPOResultMsg resultMsg = new StockPOResultMsg(true,"successful",stockPO);


        return resultMsg;
    }

    public StockPOResultMsg searchStockByNameAndDate(String name,Date begin,Date end){
        PredicateFactory factory = new PredicateFactory();
        Predicate predicate = factory.byNameAndDate(name,begin,end);
        return this.searchStockByPredicate(predicate);
    }
}
