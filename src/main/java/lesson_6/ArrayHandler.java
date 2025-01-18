package lesson_6;

public class ArrayHandler {
    public static int arrayProcessing(String[][] arr) throws MyArrayDataException, MyArraySizeException{
        int row = 4;
        int column = 4;
        int sum = 0;

        if(arr.length != row || arr[0].length != column){
            throw new MyArraySizeException("Размер массива должен быть 4х4 ");
        }

        for (int i = 0; i < row; i++){
            for (int j = 0; j < column; j++){
                try {
                    sum += Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e){
                    throw new MyArrayDataException("Некорректная информация в позиции: ", i, j);
                    }
                }
            }
        return sum;
    }
}
