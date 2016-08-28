/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.video;

/**
 *  Класс представляет собой воплощение видеоформата
 * @author ivan
 */
public class VideoFormat{
   
    /**Переменная для хранения формата*/
    private String compressionFormat = "";  
    /**Разрешение экрана*/
    private int ScreenResolution = 0;
    /**Качество видео*/
    private int quality = 0;//0-low,1-medium,2-high
    
    /**Средний размер кадра индивидуален и рассчитывается под влиянием других 
    параметров*/
    private float averageFrameSize;
    
    /**Необходимая пропускная способность для 1 камеры*/
    private String requiredSingleBandwidth = "";
    
    //Время работы камер
    private int cboHoursPerDay;
    
    //Пропускная способность 1 камеры
    private String[] camBandwidth = {
			"0",
                        "кб/c"
			};
    
    
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
    public void setquality(int quality)
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
        camBandwidth[0] = Float.toString(tCam / 1000);
        camBandwidth[1] = "Мб/с";
    }
    else{
        camBandwidth[0] = Float.toString(tCam);
        camBandwidth[1] = "Кб/с";
    }
}
    //Возврощаем значение пропускной способности камеры
    public String[] getBandwidth(){
        calcBandwidth();
        camBandwidth[0].format("%.2f\n", Float.parseFloat(camBandwidth[0]));
        return camBandwidth;
    }

}
