package main.video;

import java.text.DecimalFormat;

/**
 *  Класс представляет собой воплощение видеоформата
 * @author ivan
 */
public class VideoFormat{
   
    private static final String pattern = "##0.00";
    
    /**Переменная для хранения формата*/
    private String compressionFormat = "";  
    /**Разрешение экрана*/
    private int ScreenResolution = 0;
    /**Качество видео*/
    private int quality = 0;//0-low,1-medium,2-high
    
    /**Средний размер кадра индивидуален и рассчитывается под влиянием других 
    параметров*/
    private float averageFrameSize;
   
    //Время работы камер
    private int cboHoursPerDay;
    
    //Пропускная способность 1 камеры
    private String[] camBandwidth = {
			"0",
                        "кб/c"
			};
    
    public VideoFormat(){
       compressionFormat = "H.264";
       ScreenResolution = 4;
       quality = 3;
       cboHoursPerDay = 1;
       imageSize();       
    } 
    
    //Обновляем значение compressionFormat
    public void setCompressionFormat(String compressionFormat)
    {
      this.compressionFormat = compressionFormat;  
    }
    
    //Обновляем значение ScreenResolution
    public void setScreenResolution(int ScreenResolution)
    {
      this.ScreenResolution = ScreenResolution;  
    }
    
    //Обновляем значение ScreenResolution
    public void setQuality(int quality)
    {
      this.quality = quality;  
    }
    
  private void imageSize(){
    switch(ScreenResolution){
        case 1:
            switch(quality){
                case 1:
                    this.averageFrameSize = 7;
                    break;
                case 2:
                    this.averageFrameSize = 5;
                    break;
                case 3:
                    this.averageFrameSize = 3;
                    break;
            }
            break;
        case 2:
            switch(quality){
                case 1:
                    this.averageFrameSize = 21;
                    break;
                case 2:
                    this.averageFrameSize = 13;
                    break;
                case 3:
                    this.averageFrameSize = 8;
                    break;
            }
            break;
        case 3:
            switch(quality){
                case 1:
                    this.averageFrameSize = 60;
                    break;
                case 2:
                    this.averageFrameSize = 40;
                    break;
                case 3:
                    this.averageFrameSize = 23;
                    break;
            }
            break;
        case 4:
            switch(quality){
                case 1:
                    this.averageFrameSize = 195;
                    break;
                case 2:
                    this.averageFrameSize = 130;
                    break;
                case 3:
                    this.averageFrameSize = 75;
                    break;
            }
            break;
        case 5:
            switch(quality){
                case 1:
                    this.averageFrameSize = 288;
                    break;
                case 2:
                    this.averageFrameSize = 192;
                    break;
                case 3:
                    this.averageFrameSize = 110;
                    break;
            }
            break;
        case 6:
            switch(quality){
                case 1:
                    this.averageFrameSize = 472;
                    break;
                case 2:
                    this.averageFrameSize = 315;
                    break;
                case 3:
                    this.averageFrameSize = 182;
                    break;
            }
            break;
           case 7:
            switch(quality){
                case 1:
                    this.averageFrameSize = 40;
                    break;
                case 2:
                    this.averageFrameSize = 25;
                    break;
                case 3:
                    this.averageFrameSize = 15;
                    break;
            }
            break;
    }
    imageStream();
}
  
 //Вычесляем как влияет формат видео на средний размер кадра
    private void imageStream(){

    switch(compressionFormat){
        case "MJPEG":
            break;
        case "MPEG-4":
            this.averageFrameSize = this.averageFrameSize / 5;
            break;
        case "MPEG-2":
            this.averageFrameSize = this.averageFrameSize / 9;
            break;
        case "H.264":
            this.averageFrameSize = this.averageFrameSize / 14;
            break;
    }
}
    //Возвращаем средний размер кадра
    public float getSize()
    {
        imageSize();
        return this.averageFrameSize;
    }    
      
    //Изменяем значение cboHoursPerDay
    public void setCboHoursPerDay(int cboHoursPerDay){
        this.cboHoursPerDay = cboHoursPerDay;
    }
    
    //Рассчитывем необходимую общую пропускную способность для 1 камеры
    private void calcBandwidth(){
        
    int frt = 1;

    float tCam = averageFrameSize * 12 * cboHoursPerDay / frt;
    if(tCam > 999){
        this.camBandwidth[0] = conversion(tCam / 1000);
        this.camBandwidth[1] = "Мб/с";
    }
    else{
        this.camBandwidth[0] = conversion(tCam);
        this.camBandwidth[1] = "Кб/с";
    }
}
    //Возврощаем значение пропускной способности камеры
    public String[] getBandwidth(){
        calcBandwidth();
        return this.camBandwidth;
    }
    
    //Обрезаем число чтоб получить два знака после запятой
    private String conversion(float x) 
    { 
        DecimalFormat decimalFormat = new DecimalFormat(pattern);
        String str = decimalFormat.format(x);
        
        return str;
    }

}
