/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividade;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author SAMSUNG
 */
public class Atividade {

    /**
     * @param args the command line arguments
     */
    
    public static int lim;
    
    public static int[][] criaMatriz(Scanner i){
        
        String lixo = i.nextLine();
        //System.out.println(lixo);
        lixo = i.nextLine();
        //System.out.println(lixo);
        
        int coluna = i.nextInt();
        int linha = i.nextInt();
        
        
        int[][] Matriz = new int[coluna+1][linha+1];
        
        
        lim = i.nextInt();
        
        for(int x = 0; x<coluna; x++){
            for(int y = 0; y<linha; y++)
            {
                Matriz[x][y] = i.nextInt();
            }
            
        }
        //System.out.println("Colunas: "+coluna+" Linhas: "+linha);
        return Matriz;
    }
    
    public static int[][] fatiamentoImagem(int[][] imagemOriginal){
        int coluna, linha;
        
        
        coluna = imagemOriginal.length - 1;
        linha = imagemOriginal[0].length - 1;
        
        //System.out.println("Colunas: "+coluna+" Linhas: "+linha);
        
        int[][] imagemFatiada = new int[coluna][linha];
        
        
        for(int x = 0; x < coluna; x++)
        {
            for(int y = 0; y < linha; y++)
            {
                imagemFatiada[x][y] = imagemOriginal[x][y];
            }
        }
        
        for(int x = 0; x < coluna; x++)
        {
            for(int y = 0; y < linha; y++)
            {
                
                if((imagemFatiada[x][y] < 120) || (imagemFatiada[x][y] > 200))
                {
                    imagemFatiada[x][y] = 10;
                }
                else
                {
                    imagemFatiada[x][y] = 250;
                }
                        
            }
        }
        
        return imagemFatiada;
    }
    
    public static int[][] fatiamentoImagem2(int[][] imagemOriginal){
        int coluna, linha;
        
        
        coluna = imagemOriginal.length - 1;
        linha = imagemOriginal[0].length - 1;
        
        //System.out.println("Colunas: "+coluna+" Linhas: "+linha);
        
        int[][] imagemFatiada = new int[coluna][linha];
        
        
        for(int x = 0; x < coluna; x++)
        {
            for(int y = 0; y < linha; y++)
            {
                imagemFatiada[x][y] = imagemOriginal[x][y];
            }
        }
        
        for(int x = 0; x < coluna; x++)
        {
            for(int y = 0; y < linha; y++)
            {
                
                if((imagemFatiada[x][y] < 150) || (imagemFatiada[x][y] > 250))
                {
                    
                }
                else
                {
                    imagemFatiada[x][y] = 200;
                }
                        
            }
        }
        
        return imagemFatiada;
    }
    
    public static int[][] transformacaoGamma(int[][] imagemOriginal, double gamma){
        int coluna, linha;
        
        
        coluna = imagemOriginal.length - 1;
        linha = imagemOriginal[0].length - 1;
        
        //System.out.println("Colunas: "+coluna+" Linhas: "+linha);
        
        int[][] imagemGamma = new int[coluna][linha];
        
        
        for(int x = 0; x < coluna; x++)
        {
            for(int y = 0; y < linha; y++)
            {
                imagemGamma[x][y] = imagemOriginal[x][y];
            }
        }
        
        for(int x = 0; x < coluna; x++)
        {
            for(int y = 0; y < linha; y++)
            {
                
                imagemGamma[x][y] = (int) Math.pow((imagemOriginal[x][y]), gamma);
                if(imagemGamma[x][y] > 255)
                {
                    imagemGamma[x][y] = 255;
                }
   
            }
        }
        
        return imagemGamma;
    }
    
    public static void salvarImagem(int[][] imagem, String nameFile){
        try {
        FileWriter fw = new FileWriter(nameFile);
        fw.write("P2");
        fw.write("\n");
        fw.write(Integer.toString(imagem.length));
        fw.write(" ");
        fw.write(Integer.toString(imagem[0].length));
        fw.write("\n");
        fw.write(Integer.toString(lim));
        fw.write("\n");
        for (int i = 0; i < imagem.length; i++) {
            for (int j = 0; j < imagem[i].length; j++) {
                    fw.write(imagem[i][j] + " ");
            }
            fw.write("\n");
        }
        fw.flush();
        } catch (IOException e) {}
    }
    
    public static void main(String[] args) throws FileNotFoundException {
        
        Scanner in = new Scanner(new FileReader("imagem.pgm"));
        Scanner ler = new Scanner(System.in);
        
        
        int[][] imagem;
        int[][] fatiamento1;
        int[][] fatiamento2;
        int[][] transGamma;
        double gamma = 1.1;
        
        imagem = criaMatriz(in);
        
        fatiamento1 = fatiamentoImagem(imagem);
        
        salvarImagem(fatiamento1, "fatiamento1.pgm");
        
        fatiamento2 = fatiamentoImagem2(imagem);
        
        salvarImagem(fatiamento2, "fatiamento2.pgm");
        
        System.out.println("insira o gamma desejado: ");
        
        gamma = ler.nextDouble();
        
        transGamma = transformacaoGamma(imagem, gamma);
        
        salvarImagem(transGamma, "gamma.pgm");
        
    }
    
}
