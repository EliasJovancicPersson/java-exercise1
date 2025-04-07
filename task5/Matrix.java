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

    public Matrix add(Matrix matrix1, Matrix matrix2) throws IllegalArgumentException{
       
        if(!(matrix1.sizeC == matrix2.sizeC && matrix1.sizeR == matrix2.sizeR)){
            throw new IllegalArgumentException("wrong size");
        }

        Matrix newMatrix = new Matrix(matrix1.sizeC,matrix1.sizeR);
        for(int r = 0;r<matrix1.sizeR;r++){
            for(int c = 0;c<matrix1.sizeC;c++){
                newMatrix.elements[r][c] = matrix1.elements[r][c] + matrix2.elements[r][c];
            }
        }
        return newMatrix;
    }

    public Matrix multiply(Matrix matrix1,Matrix matrix2) throws IllegalArgumentException{
        
        if(!(matrix1.sizeR == matrix2.sizeC)){
            throw new IllegalArgumentException("Incorrect size");
        }

        Matrix newMatrix = new Matrix(matrix1.sizeR,matrix2.sizeC);
        for (int r = 0; r < matrix1.sizeR; r++) {
            for(int c = 0;c < matrix2.sizeC; c++){
                double sum = 0;
                for(int k = 0; k < matrix1.sizeC;k++){
                    sum += matrix1.elements[r][k] * matrix2.elements[k][c];
                }
                newMatrix.elements[r][c] = sum;
            }
        }

        return newMatrix;
    }
}