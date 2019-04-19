/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bnff;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;



/**  *  *   
 * <p>  
 * BNF gramer işlem formatı
 * </p>  */ 
public class bnff {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       
        try{
            FileReader fr=new FileReader("BNF.txt");//Dosyada okuma işlemleri gerçekleştirildi.
            BufferedReader br=new BufferedReader(fr);            
            String sira;
            char bnf='g';//baslangic durumunu atar.
            List<String> tr = new ArrayList<String>();//Elamanların eklencegi liste olusturuldu
            while((sira=br.readLine())!=null)//dosya sonuna kadar okuma yaptırılır.
            {
                for(int x=0;x<sira.length();x++)//sira sonu boyunca ilerler.
                {
                    char kar2=sira.charAt(x);//indeksteki karakteri getirir.
                
                if(bnf=='g')//durum g ise icine girer.
                {
                    if((kar2==('[')))//'[' görürse durumu n yapar.
                    {
                    bnf='n';
                    }
                    else if((kar2==('|')))//degilse eger durumu g yapar.
                    {
                    bnf='g';
                    }
                    else//degilse durumu t yapar.
                    { 
                        bnf='t'; 
                        
                    }
                }
                if(bnf=='n')//durum n ise icine girer.
                {
                    if((kar2==(']')))//bunu gorurse durumu g yapar.
                    {
                        bnf='g';
                    }
                }
                if(bnf=='t')//durum t ise icine girer.
                {
                    if((kar2==(':')) ||(kar2==('='))||(kar2==(' '))) //eger bunları gorurse durumu g yapar.
                    {                        
                        bnf='g';                       
                    }   
                    else //degılse char ı stringe cevirir ve indexteki elemanı listeye ekler.
                    {
                      String kar3= String.valueOf(kar2);
                        tr.add(kar3);
                        
                    }
                }
                }
            }
            System.out.print("Toplam terminal:");//liste uzunlugunu ekrana yazdırır.
             System.out.println(tr.size());
            
            System.out.println("Terminaller:");//liste uzunlugunca indexteki elemanları yazdırır.
            for(int j=0;j<tr.size();j++) 
                    {
                        
                        
                        System.out.println(tr.get(j));//get metodu listeki elemanları getirir.
                    }
        }
        
        catch(Exception e){ //try ifadesi calismazsa hata yakalayıp mesaj verir.
            System.out.println("Dosya Okunamadı");
    }
    }  
}


    
 
        
