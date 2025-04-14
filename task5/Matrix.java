package task5;
public class Matrix {

    private double[][] elements;
    private int sizeR;
    private int sizeC;
    
    public Matrix(int r, int c) {
        sizeR = r;
        sizeC = c;
        elements = new double[r][c];
    }

    public double get(int r,int c) throws Exception{
        if(!(r<0 && c<0)){
            return elements[r][c];
        }
        else{
            throw new Exception();
        }
    }

    public void set(int r,int c, double val) throws Exception{
        if(!(r<0 && c<0)){
            elements[r][c] = val;
        }
        else{
            throw new Exception();
        }
    }

    public Matrix add(Matrix matrix) throws IllegalArgumentException{
       
        if(!(this.sizeC == matrix.sizeC && this.sizeR == matrix.sizeR)){
            throw new IllegalArgumentException("wrong size");
        }

        Matrix newMatrix = new Matrix(this.sizeC,this.sizeR);
        for(int r = 0;r<this.sizeR;r++){
            for(int c = 0;c<this.sizeC;c++){
                newMatrix.elements[r][c] = this.elements[r][c] + matrix.elements[r][c];
            }
        }
        return newMatrix;
    }

    public Matrix multiply(Matrix matrix) throws IllegalArgumentException{
        
        if(!(this.sizeR == matrix.sizeC)){
            throw new IllegalArgumentException("Incorrect size");
        }

        Matrix newMatrix = new Matrix(this.sizeR,matrix.sizeC);
        for (int r = 0; r < this.sizeR; r++) {
            for(int c = 0;c < matrix.sizeC; c++){
                double sum = 0;
                for(int k = 0; k < this.sizeC;k++){
                    sum += this.elements[r][k] * matrix.elements[k][c];
                }
                newMatrix.elements[r][c] = sum;
            }
        }

        return newMatrix;
    }
}