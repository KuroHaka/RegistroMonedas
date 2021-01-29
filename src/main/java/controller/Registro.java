package controller;

import java.util.Calendar;
import java.util.Date;

public class Registro {
    private Usuario usuario;
    private int _010;
    private int _020;
    private int _050;
    private int _1;
    private int _2;
    private int _5;
    private int _10;
    private int _20;
    private int _50;
    private float total;
    private Calendar fecha;

    public Registro(Usuario usuario, int _010, int _020, int _050, int _1, int _2, int _5, int _10, int _20, int _50) {
        this.usuario = usuario;
        this._010 = _010;
        this._020 = _020;
        this._050 = _050;
        this._1 = _1;
        this._2 = _2;
        this._5 = _5;
        this._10 = _10;
        this._20 = _20;
        this._50 = _50;
        this.total = 0.00f;
        this.total = (float) (_1+_2*2+_5*5+_10*10+_20*20+_50*50+_010*0.10+_020*0.20+_050*0.5);
        this.fecha = Calendar.getInstance();

    }
    public int getHour(){
        return fecha.get(Calendar.HOUR_OF_DAY);
    }

    public int getMinutes(){
        return fecha.get(Calendar.MINUTE);
    }

    public int getMonth(){
        return fecha.get(Calendar.MONTH)+1;
    }

    public int getDay(){
        return fecha.get(Calendar.DAY_OF_MONTH);
    }

    public int getYear(){
        return fecha.get(Calendar.YEAR);
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public int get_010() {
        return _010;
    }

    public int get_020() {
        return _020;
    }

    public int get_050() {
        return _050;
    }

    public int get_1() {
        return _1;
    }

    public int get_2() {
        return _2;
    }

    public int get_5() {
        return _5;
    }

    public int get_10() {
        return _10;
    }

    public int get_20() {
        return _20;
    }

    public int get_50() {
        return _50;
    }

    public Date getDate(){
        return this.fecha.getTime();
    }

    public float getTotal() {
        return total;
    }
}
