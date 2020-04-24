package Controller.DataBase;

public class EndOfProgramme extends DataBase implements Runnable{

    public void update(){
        makeDirectories();
    }

    public void updateFiles(){
        updateBosses();
        updateBuyLog();
        updateCategories();
        updateComments();
        updateCustomers();
        updateOffCodes();
        updatePoints();
        updateProducts();
        updateSales();
        updateSalesmen();
        updateSpecialOffCodes();
    }

    @Override
    protected void updateCustomers() {

    }

    @Override
    protected void updateBosses() {

    }

    @Override
    protected void updateSalesmen() {

    }

    @Override
    protected void updateCategories() {

    }

    @Override
    protected void updateBuyLog() {

    }

    @Override
    protected void updateSales() {

    }

    @Override
    protected void updateOffCodes() {

    }

    @Override
    protected void updateSpecialOffCodes() {

    }

    @Override
    protected void updateProducts() {

    }

    @Override
    protected void updateComments() {

    }

    @Override
    protected void updatePoints() {

    }

    @Override
    public void run() {

    }
}
