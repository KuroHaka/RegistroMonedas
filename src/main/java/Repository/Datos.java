package Repository;

import Exceptions.ErrorCode;
import Exceptions.Errores;
import controller.Registro;
import controller.Usuario;

import java.io.File;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


public class Datos {
    private int year;
    private int month;
    private int day;
    ArrayList<Usuario> usuarios;
    ArrayList<Registro> registros;

    public Datos(){
        year = 0;
        month = 0;
        day = 0;
        usuarios = new ArrayList<>();
        registros = new ArrayList<>();
    }

    public void addUsuario(Usuario newUsuario) throws Errores {
        if(usuarios.contains(newUsuario)){
            throw new Errores(ErrorCode.UsuarioExistente);
        }
        else{
            usuarios.add(newUsuario);
        }
    }

    public void addRegistro(Registro r) throws Errores {
        if(isSameDay(r.getYear(), r.getMonth(), r.getDay())){
            registros.add(r);
        }
        else {
            actualizeDay(r.getYear(), r.getMonth(), r.getDay());
            registros.clear();
            registros.add(r);
        }
        generateJsonLog();
    }

    private boolean isSameDay(int year, int month, int day){
        return this.year == year && this.month == month && this.day == day;
    }

    private void actualizeDay(int year, int month, int day) throws Errores {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    private void generateJsonLog() throws Errores {
        JSONObject obj = new JSONObject();
        obj.put("dia", day);
        obj.put("mes", month);
        obj.put("anio", year);
        int i = 0;
        for (Registro r:registros) {
            JSONArray list = new JSONArray();
            list.add(r.getUsuario());
            list.add(r.getMinutes());
            list.add(r.getHour());
            list.add(r.get_010());
            list.add(r.get_020());
            list.add(r.get_050());
            list.add(r.get_1());
            list.add(r.get_2());
            list.add(r.get_5());
            list.add(r.get_10());
            list.add(r.get_20());
            list.add(r.get_50());
            obj.put("Registro"+i, list);
            i++;
        }

        try  {
            File myObj = new File(year+"-"+month+"-"+day+".json");
            myObj.createNewFile();
            FileWriter file = new FileWriter(year+"-"+month+"-"+day+".json");
            file.write(obj.toJSONString());
            file.close();
        } catch (IOException e) {
            throw new Errores(ErrorCode.FicheroNoEscrito);
        }
        System.out.print(obj);
    }
}
