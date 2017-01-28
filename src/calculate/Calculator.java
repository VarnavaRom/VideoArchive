/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculate;

import java.text.DecimalFormat;
import main.video.VideoFormat;

/**
 *
 * @author ivan
 * Класс-калькулятор, на нем лежит все подсчеты
 */
public class Calculator {
    
    private static final int frt = 1;
    private static final String pattern = "##0.00";
    
    //Рассчитываем необходимый обьем памяти для одной камеры
    public String ReturnCalc(int cboHoursPerDay, int frameRate, double size, int numCams, double desiredStorage){
    
    String storage;
    String typeStorate;
    
    double eStorage = ((((size * (frameRate/ frt) * numCams * 60 * 60 * 24 * desiredStorage) / 1000000) / 24) * cboHoursPerDay) * 3;

    if(eStorage > 999)
    {
        storage = conversion(eStorage / 1000);
        typeStorate = " ТБ";
    }
    else
    {
        storage = conversion(eStorage);
        typeStorate = " ГБ";
    } 
        return storage + typeStorate;
    }
   
   //Рассчитываем необходимый обьем памяти для всех камер
   public String calcCamera(int frameRate, double size, int numCams, double desiredStorage){ 
       
       String tBandType;
       double tBand = (size * 12 * frameRate / frt * numCams);
       
    if(tBand > 999999)
    {
        tBand = (tBand / 1000000);
        tBandType = " Гб/с";
    }
    else if(tBand > 999)
    {
        tBand = (tBand / 1000);
        tBandType = " Мб/с";
    }
    else
    {
        tBandType = " Кб/с";
    }
                

    return conversion(tBand) + tBandType;
   }
    
   
   //Обрезаем число чтоб получить два знака после запятой
    private String conversion(double x) 
    { 
        DecimalFormat decimalFormat = new DecimalFormat(pattern);
        String str = decimalFormat.format(x);
        
        return str;
    }
}
