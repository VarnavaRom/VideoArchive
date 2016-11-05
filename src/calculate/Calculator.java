package calculate;

import java.text.DecimalFormat;

/**
 *
 * @author ivan
 * Class-calculator, it is all counts
 */
public class Calculator {
    
   /* protected int countCamera;

   
    public int getCountCamera() {
        return countCamera;
    }

  
    public void setCountCamera(int countCamera) {
        this.countCamera = countCamera;
    }*/
    
    private static final int FRT = 1;
    private static final String PATTERN = "##0.00";
    
    public String ReturnCalc(int cboHoursPerDay, int frameRate, double size, int numCams, double desiredStorage){
    
    String storage;
    String typeStorate;
    
    double eStorage = ((((size * (frameRate/ FRT) * numCams * 60 * 60 * 24 * desiredStorage) / 1000000) / 24) * cboHoursPerDay) * 3;

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
    
   public String calcCamera(int frameRate, double size, int numCams, double desiredStorage){ 
       
       String tBandType;
       double tBand = (size * 12 * frameRate / FRT * numCams);
       
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
        DecimalFormat decimalFormat = new DecimalFormat(PATTERN);
        String str = decimalFormat.format(x);
        
        return str;
    }
}
