package hu.petrik.oop.matrixoop;

import java.util.Arrays;
import java.util.Random;

public class Matrix {
    private int sor;
    private int oszlop;
    private int[][] m;
    private static final Random rnd = new Random();

    public Matrix(int sor, int oszlop) {
        this.sor = sor;
        this.oszlop = oszlop;
        this.m = new int[sor][oszlop];
        for (int i = 0; i < this.m.length; i++) {
            for (int j = 0; j < this.m[i].length; j++) {
                this.m[i][j] = rnd.nextInt(150) - 50;
            }
        }
    }

    public int getElemekOsszege() {
        int osszeg = 0;
        for (int[] sor : this.m) {
            for (int elem : sor) {
                osszeg += elem;
            }
        }
        return osszeg;
    }

    public int getPozitivElemekSzama(){
        int db = 0;
        for (int[] sor : this.m) {
            for (int elem : sor) {
                if (elem > 0){
                    db++;
                }
            }
        }
        return db;
    }

    public int getLegnagyobbElem(){
        int max = this.m[0][0];
        for (int i = 0; i < this.m.length; i++) {
            for (int j = 0; j < this.m[i].length; j++) {
                if (max < this.m[i][j]){
                    max = this.m[i][j];
                }
            }
        }
        return max;
    }

    public int[] getElsoPozitivElem(){
        int sorIndex = 0;
        int oszlopIndex = 0;
        while(sorIndex < this.m.length && this.m[sorIndex][oszlopIndex] < 1){
            while(oszlopIndex < this.m[sorIndex].length && this.m[sorIndex][oszlopIndex] < 1){
                oszlopIndex++;
            }
            if (oszlopIndex == this.m[sorIndex].length){
                sorIndex++;
                oszlopIndex = 0;
            }
        }
        if(sorIndex == this.m.length){
            return new int[] {-1, -1};
        }
        return new int[] {sorIndex, oszlopIndex};
    }

    public int sorOsszeg(int sor){
        int oszlopIndex = 0;
        int osszeg = 0;
        while(oszlopIndex < this.m[sor-1].length){
            oszlopIndex++;
            osszeg += this.m[sor-1][oszlopIndex-1];
        }
        return osszeg;
    }

    public int maxElemOszlop(int oszlop){
        int max = this.m[0][oszlop-1];
        for (int i = 0; i < this.m.length; i++) {
            if (this.m[i][oszlop-1]>max){
                max = this.m[i][oszlop-1];
            }
        }
        return max;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int[] sor : this.m) {
            for (int elem : sor) {
                sb.append(String.format("%3d ", elem));
            }
            sb.append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
