package com.example.project;
import java.util.ArrayList;
import java.util.Arrays;

public class Encryptor {
    
    public static int determineColumns(int messageLen, int rows){
        if(messageLen == 0){
            return 1;
        }
        return (int)Math.ceil((double)messageLen/rows);
    }
    
    public static String[][] generateEncryptArray(String message, int rows) {
        String[][] arr = new String[rows][determineColumns(message.length(), rows)];
        int strIndex = 0;
        for(int i = 0; i < arr.length; i ++){
            for(int j = 0; j < arr[i].length; j ++){
                if(strIndex < message.length()){
                    arr[i][j] = message.substring(strIndex, strIndex+1);
                }
                else{
                    arr[i][j] = "=";
                }
                strIndex ++;
            }
        }
        return arr;
    }

    public static String encryptMessage(String message, int rows){
        String str = "";
        String[][] arr = generateEncryptArray(message, rows);
        for(int i = arr[0].length - 1; i >= 0; i --){
            for(int j = 0; j < arr.length; j ++){
                str += arr[j][i];
            }
        }
        return str;
    }

    public static String decryptMessage(String encryptedMessage, int rows) {
        int columns = determineColumns(encryptedMessage.length(), rows);
        String[][] arr = new String[rows][columns];
        String newStr = "";

        System.out.println("Rows: " + rows + " Columns: " + columns);


        int strIndex = 0;
        for(int i = columns - 1; i >= 0; i --){
            for(int j = 0; j < rows; j ++){

                if(strIndex < encryptedMessage.length()){
                    arr[j][i] = encryptedMessage.substring(strIndex, strIndex + 1);
                    strIndex ++;
                }
                else{
                    arr[j][i] = "";
                    strIndex ++;
                }
            }
        }

        for(String[] row: arr){
            for(String str: row){
                if(!str.equals("=")){
                    newStr += str; 
                }
            }
        }

        return newStr;
    }

    public static void printArray(String[][] array){
        for(String[] row: array){
            for(String str: row){
                System.out.print(str + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        String encrypted = "re o=esns.ttoesliirra t e tplsnoyauanrn   codosnieteetzno aiidmtr  ouo,ndphtonmtxiaouetrcatp- nnyoeuirdl acubolneatpEsr   pets. doanain o s nisntwteouoascbnmu  kr ,s oyet,flmnnnleeoiahii ucptlssiaau cmn nerieorogmi fietonrhptiocy   srree cohhnntttoea  i nfstdiospeg eynincrgroccioians t eeead dhtnn-tnaal e  lyst,ebexsw ren dptoaeens driari aeovllrfoap  rn l,pioat gtcuyi iberkn kochy  aceeebekhh t ttt e  xrhhseottttF irr gwee.n vhrienposgoitsaccpes  esssacses romerep cet eohnthrpiutpi o  cehtsebtpid-iyh dwrTnl c auee.cogdn wa os syieaslti eiatomsmrt ara eeopth f ntnnde aiettc znp gioytnrcrnio cedheeiotldpcub inaioce gte yi rflle onlld oebes tizs,nsieyisrcl ooolephrah tpetsu d iaeIs  h etnt.iIA tn  sxe..iedmd t henrttroeuiiihbrutp oqpiegeycclrr na cse enarnre eaa nf  ,wrysyoeblhnt lpkndia iekrm tsgrta oonrdtfeenp vnayeee rvrgscip e t ycnaferInlku";
        System.out.println(encrypted);
        System.out.println(decryptMessage(encrypted, 5));
        System.out.println(encryptMessage("This one time I was trying to do a handstand and fell backwards and landed on my shoe. It hurt! I won't try that again.", 6));
    }
}