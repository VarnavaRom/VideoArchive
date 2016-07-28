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
public abstract class VideoFormat {
    
    /**Обязательно используй этот конструктор дабы инициализировать
     * массив разрешений экрана*/
    public VideoFormat(){
    
    }
    
    /**Предопределенные форматы для которых мы должны рассчитывать все*/
    protected final String H264="H.264";
    protected final String MPEG2="MPEG-2";
    protected final String MPEG4="MPEG-4";
    protected final String MJPEG="MJPEG";
    /**Переменная для хранения формата*/
  //  protected String compressionFormat;
    
    //Разрешение экрана
    protected ScreenResolution[] screenResolutions = {
        new ScreenResolution(176, 120),
        new ScreenResolution(352, 240),
        new ScreenResolution(704, 240),
        new ScreenResolution(704, 480),
        new ScreenResolution(1280, 1024),
        new ScreenResolution(1600, 1200),
        new ScreenResolution(2048, 1536)};
    
    protected int quality;//0-low,1-medium,2-high
    
    //Средний размер кадра индивидуален и рассчитывается под влиянием других 
    //параметров
    protected long averageFrameSize;
    
    /**Необходимая общая пропускная способность*/
    protected String[] requiredTotalBandwidth = {"",""};
   
    
    
    
    
    
}
