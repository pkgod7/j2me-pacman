import javax.microedition.lcdui.Display;
import javax.microedition.midlet.*;
public class MyMidlet extends MIDlet
{
    public CanvasPacman c1;
    public void startApp()
    {
        c1=new CanvasPacman();
        c1.start();
        Display.getDisplay(this).setCurrent(c1);
    }
    public void pauseApp()
    {
    }
    public void destroyApp(boolean unconditional)
    {
    }
}
