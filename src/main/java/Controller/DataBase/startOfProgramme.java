package Controller.DataBase;

import java.io.IOException;

public class startOfProgramme extends DataBase {

    public void update() {
        try {
            makeDirectories();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void startProgramme() throws IOException, ClassNotFoundException {
        makeDirectories();
        updateBosses();
        updateBuyLogs();
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
    void updateCustomers() {

    }

    @Override
    protected void updateBosses() {

    }

    @Override
    protected void updateSalesmen() {

    }

    @Override
    public void updateCategories() {

    }

    @Override
    void updateBuyLogs() {

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
    protected void updatePoints() throws IOException, ClassNotFoundException {

    }

}

