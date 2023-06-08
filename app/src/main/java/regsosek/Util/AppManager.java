package regsosek.Util;

import regsosek.entity.Ruta;
import regsosek.entity.Penduduk;

public class AppManager {
    ActionHandler actionHandler = new ActionHandler(this);
    UI ui = new UI(this);
    Routing routing = new Routing(this);
    Ruta ruta = new Ruta();
    Penduduk penduduk = new Penduduk();       

    public AppManager(){
        routing.showScreen(0);
    }

    public void setRuta(Ruta ruta){
        this.ruta = ruta;
    }

    public void setPenduduk(Penduduk penduduk){
        this.penduduk = penduduk;
    }

    public void changePenduduk(){
        Penduduk temp = new Penduduk();
        setPenduduk(temp);
    }
}
