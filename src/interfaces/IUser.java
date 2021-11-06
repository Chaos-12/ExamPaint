package src.interfaces;

public interface IUser {
    public void clickOn(int x, int y);

    public void dragMouse(int xFrom, int yFrom, int xTo, int yTo);

    public void chooseShape(int sNumber);

    public void chooseExtColor(int cNumber);

    public void chooseIntColor(int cNumber);

    public void trashIcon();
}
